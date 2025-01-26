package com.example.API_Hospital.entity.Role;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Convenio {
    ROLE_PARTICULAR,
    ROLE_PLANOSAUDE;

    @JsonCreator
    public static Convenio fromString(String value) {
        if (value != null) {
            switch (value.toUpperCase()) {
                case "ROLE_PARTICULAR":
                case "PARTICULAR":
                    return ROLE_PARTICULAR;

                case "ROLE_PLANOSAUDE":
                case "PLANOSAUDE":
                    return ROLE_PLANOSAUDE;
            }
        }
        throw new IllegalArgumentException("Valor inválido para Role: " + value);
    }
}
