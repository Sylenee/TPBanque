#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: contrat
#------------------------------------------------------------

CREATE TABLE contrat(
        id         Int  Auto_increment  NOT NULL ,
        mensualite Float NOT NULL ,
        type       Varchar (50) NOT NULL ,
        date_debut Datetime NOT NULL ,
        date_fin   Datetime NOT NULL
	,CONSTRAINT contrat_PK PRIMARY KEY (id)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: client
#------------------------------------------------------------

CREATE TABLE client(
        id         Int  Auto_increment  NOT NULL ,
        nom        Varchar (100) NOT NULL ,
        prenom     Varchar (50) NOT NULL ,
        adresse    Varchar (200) NOT NULL ,
        id_contrat Int
	,CONSTRAINT client_PK PRIMARY KEY (id)

	,CONSTRAINT client_contrat_FK FOREIGN KEY (id_contrat) REFERENCES contrat(id)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: conseiller
#------------------------------------------------------------

CREATE TABLE conseiller(
        id        Int  Auto_increment  NOT NULL ,
        nom       Varchar (100) NOT NULL ,
        prenom    Varchar (50) NOT NULL ,
        id_client Int
	,CONSTRAINT conseiller_PK PRIMARY KEY (id)

	,CONSTRAINT conseiller_client_FK FOREIGN KEY (id_client) REFERENCES client(id)
)ENGINE=InnoDB;

