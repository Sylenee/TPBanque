# Projet D'assurance

## Contributeurs


| Nom Prénom       | classe  |
|------------------|---------|
| Morreau Sylène   | M2-GL   |
| Gouyet Thomas    | M2-GL   |
| Lidstrom Henrik  | M2-GL   |
| Guillarmou Mathis | CIPA-GL |
| Le Duot Nathan   | CIPA-GL |

## Base de donnée

### Acces
- Url :   localhost
- base :  assurance
- user :  assurance
- mdp :   assurance

### Tables

**client**
- id         Int  Auto_increment
- nom        Varchar (100)
- prenom     Varchar (50)
- adresse    Varchar (200)
- id_contrat Int

**Conseiller**
- id        Int  Auto_increment
- nom       Varchar (100)
- prenom    Varchar (50)
- id_client Int

**contrat**
- id         Int  Auto_increment
- mensualite Float
- type       Varchar (50)
- date_debut Datetime
- date_fin   Datetime