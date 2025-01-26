package com.example.API_Hospital.entity.Role;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Especializacao {
    ROLE_PEDIATRIA,
    ROLE_DERMATOLOGIA,
    ROLE_CARDIOLOGIA,
    ROLE_GINECOLOGIA,
    ROLE_ODONTOLOGIA,
    ROLE_FISIOTERAPIA,
    ROLE_OFTAMOLOGIA;

    @JsonCreator
    public static Especializacao fromString(String value) {
        if (value != null) {
            switch (value.toUpperCase()) {
                case "ROLE_PEDIATRIA":
                case "PEDIATRIA":
                    return ROLE_PEDIATRIA;

                case "ROLE_DERMATOLOGIA":
                case "DERMATOLOGIA":
                    return ROLE_DERMATOLOGIA;

                case "ROLE_CARDIOLOGIA":
                case "CARDIOLOGIA":
                    return ROLE_CARDIOLOGIA;

                case "ROLE_GINECOLOGIA":
                case "GINECOLOGIA":
                    return ROLE_GINECOLOGIA;

                case "ROLE_ODONTOLOGIA":
                case "ODONTOLOGIA":
                    return ROLE_ODONTOLOGIA;

                case "ROLE_FISIOTERAPIA":
                case "FISIOTERAPIA":
                    return ROLE_FISIOTERAPIA;

                case "ROLE_OFTAMOLOGIA":
                case "OFTAMOLOGIA":
                    return ROLE_OFTAMOLOGIA;
            }
        }
        throw new IllegalArgumentException("Valor inválido para Role: " + value);
    }
}
