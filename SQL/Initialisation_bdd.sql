#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: conseiller
#------------------------------------------------------------

CREATE TABLE conseiller(
        id     Int  Auto_increment  NOT NULL ,
        nom    Varchar (100) NOT NULL ,
        prenom Varchar (50) NOT NULL
	,CONSTRAINT conseiller_PK PRIMARY KEY (id)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: client
#------------------------------------------------------------

CREATE TABLE client(
        id            Int  Auto_increment  NOT NULL ,
        nom           Varchar (100) NOT NULL ,
        prenom        Varchar (50) NOT NULL ,
        adresse       Varchar (200) NOT NULL ,
        id_conseiller Int
	,CONSTRAINT client_PK PRIMARY KEY (id)

	,CONSTRAINT client_conseiller_FK FOREIGN KEY (id_conseiller) REFERENCES conseiller(id)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: contrat
#------------------------------------------------------------

CREATE TABLE contrat(
        id         Int  Auto_increment  NOT NULL ,
        mensualite Float NOT NULL ,
        type       Varchar (50) NOT NULL ,
        date_debut Datetime NOT NULL ,
        date_fin   Datetime NOT NULL ,
        id_client  Int
	,CONSTRAINT contrat_PK PRIMARY KEY (id)

	,CONSTRAINT contrat_client_FK FOREIGN KEY (id_client) REFERENCES client(id)
)ENGINE=InnoDB;

