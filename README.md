# API Back-end Hospital - *Por: Gabriel Coutinho*
**Esta API simula um sistema de hospital, onde nele é possível cadastrar médicos, informando seus dados e sua área de atuação. Além de cadastrar pacientes e marcar consultas.**

# Requisitos
* **Para ambos tipos de usuário, precisamos do Nome Completo, endereço e número para contato. CPF e e-mail devem ser únicos no sistema. Sendo assim, seu sistema deve permitir apenas um cadastro com o mesmo CPF ou endereço de e-mail;**

* **Não será possível cadastrar mais de uma consulta com a mesma data/hora para o mesmo médico;**

* **No momento de cadastrar uma consulta, será possível informar se o Convênio será Particular ou Plano de Saúde. Caso seja particular, no fim será exibido o valor da consulta com a opção de inserção de desconto, caso seja PS, não será debitado nenhum valor;**

* **Será possível realizar buscas através de diversos filtros;**

* **Esta é uma aplicação Dockerizada;**

* **Este serviço deve ser RESTFul.**

# Métodos http
* API - Medico
  
*POST*
**http://localhost:8080/api/v1/medico -> Cadastra um novo medico**

*GET*
**http://localhost:8080/api/v1/medico -> Lista todos os medicos cadastrados**

*GET*
**http://localhost:8080/api/v1/medico/name/{nome} -> Filtra medico por nome**

*GET*
**http://localhost:8080/api/v1/medico/role/{ROLE_PEDIATRIA} -> Filtra medicos pela especialização**

*PUT*
**http://localhost:8080/api/v1/medico/update/{id} -> Altera o endereço, número e email do médico através da busca pelo id**

*DELETE*
**http://localhost:8080/api/v1/medico/delete/{id} -> Deleta cadastro do médico através do id**

* API - Paciente

*POST*
**http://localhost:8080/api/v1/paciente -> Cadastra um novo paciente**

*GET*
**http://localhost:8080/api/v1/paciente -> Lista todos os clientes cadastrados**

*GET*
**http://localhost:8080/api/v1/paciente/name/{nome} -> Filtra pacientes através do nome**

*GET*
**http://localhost:8080/api/v1/paciente/numero/{numero} -> Filtra pacientes através do número**

*PUT*
**http://localhost:8080/api/v1/paciente/update/{id} -> Altera o endereço, número do paciente através da busca pelo id**

* API - Consulta

*POST*
**http://localhost:8080/api/v1/consulta -> Cadastra uma nova consulta**

*GET*
**http://localhost:8080/api/v1/consulta -> Lista todas as consultas**

*GET*
**http://localhost:8080/api/v1/consulta/date/{2025-02-15T17:30} -> Filtra consultas através da inserção da data e hora**

*GET*
**http://localhost:8080/api/v1/consulta/id/{id} -> Filtra consultas pelo id**

*GET*
**http://localhost:8080/api/v1/consulta/paciente/{nome} -> Filtra consultas pela busca do nome do paciente**

  
# Plataformas utilizadas
* Linguagem de programação -> JAVA
* Framework -> SpringBoot
* IDE -> Intellij
* Banco de Dados -> PostgreSQL
* Ambiente para versionamento de código -> Git e GitHub
* Ambiente para Contêinerização -> Docker

# URL para documentação da API
****



