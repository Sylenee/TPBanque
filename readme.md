# Projet D'assurance

## Contributeurs


| Nom Prénom         | classe  |
|--------------------|---------|
| Morreau Sylène     | M2-GL   |
| Gouyet Thomas      | M2-GL   |
| Lidstrom Henrik    | M2-GL   |
| Guillarmou Mathis  | CIPA-GL |
| Le Duot Nathan     | CIPA-GL |

## Base de donnée

### Acces
- Url :   localhost
- base :  assurance
- user :  assurance
- mdp :   assurance

### Tables

**Conseiller**
- id        Int  Auto_increment
- nom       Varchar (100)
- prenom    Varchar (50)

**client**
- id         Int  Auto_increment
- nom        Varchar (100)
- prenom     Varchar (50)
- adresse    Varchar (200)
- id_conseiller Int

**contrat**
- id         Int  Auto_increment
- mensualite Float
- type       Varchar (50)
- date_debut Datetime
- date_fin   Datetime
- id_client  Int

# Architecture

### isen.group1.api.assurance.aspect.LogAspect.java

- Description : Cette classe représente l'aspect de logging utilisé dans l'application.
- Nom de classe : LogAspect.java
- Package : isen.group1.api.assurance.aspect

### isen.group1.api.assurance.controller.ClientController.java

- Description : Cette classe représente le contrôleur pour les clients dans l'API d'assurance.
- Nom de classe : ClientController.java
- Package : isen.group1.api.assurance.controller
- Endpoint 1 : GET /clients/{client_id}/contrats
- Endpoint 2 : GET /clients/{client_id}/contrats/{contrat_id}

### isen.group1.api.assurance.controller.ConseillerController.java

- Description : Cette classe représente le contrôleur pour les conseillers dans l'API d'assurance.
- Nom de classe : ConseillerController.java
- Package : isen.group1.api.assurance.controller
- Endpoint 1 : GET /conseillers/{idConseiller}/clients
- Endpoint 2 : DELETE /conseillers/{idConseiller}/clients/{idClient}
- Endpoint 3 : PUT /conseillers/{idConseiller}/clients/{idClient}
- Endpoint 4 : PUT /conseillers/{idconseiller}/contrats/{idcontrat}
- Endpoint 5 : POST /conseillers/{idconseiller}/clients/{idclient}/contrats

### isen.group1.api.assurance.data.entity.ClientEntity.java

- Description : Cette classe représente l'entité Client dans la base de données de l'application.
- Nom de classe : ClientEntity.java
- Package : isen.group1.api.assurance.data.entity
- Table : client
- Colonnes :
- id (clé primaire, auto-incrémentée)
- nom
- prenom
- adresse
- id_conseiller

### isen.group1.api.assurance.data.entity.ConseillerEntity.java

- Description : Cette classe représente l'entité Conseiller dans la base de données de l'application.
- Nom de classe : ConseillerEntity.java
- Package : isen.group1.api.assurance.data.entity
- Table : conseiller
- Colonnes :
  - id (clé primaire)
  - nom
  - prenom
  - id_client

### isen.group1.api.assurance.data.entity.ContratEntity.java

- Description : Cette classe représente l'entité Contrat dans la base de données de l'application.
- Nom de classe : ContratEntity.java
- Package : isen.group1.api.assurance.data.entity
- Table : contrat
- Colonnes :
  - id (clé primaire, auto-incrémentée)
  - mensualite
  - type
  - dateDebut
  - dateFin
  - id_client

