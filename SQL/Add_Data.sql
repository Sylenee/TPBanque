--populate tables for all to use locally

INSERT INTO client(id, nom, prenom, adresse, id_contrat)
    -> VALUES
    ->('Le Duot','Nathan','1 rue du Forrestier 22000 St Brieuc','1')
    ->('Dupont','François','4 rue du Boucher 22000 St Brieuc','2')
    ->('Portus','Jean','7 rue du Boulanger 22000 St Brieuc','3')
    ->('Tourret','Jacques','10 rue du Patissier 22000 St Brieuc','4')
    ->('Renault','Danielle','13 rue de la Gendarmerie 22000 St Brieuc','5')
    ->('Noutu','Gabrielle','16 rue De Gaule 22000 St Brieuc','6')
    ->('Opieds','Maëlle','19 rue Vaut 22000 St Brieuc','8')
    ->('Spears','Britney','22 rue du Chanteur 22000 St Brieuc','7')
    ->('Obama','Barrack','22 rue du President 22000 St Brieuc','9')
    ->('Eye Pees','Black','22 rue du Groupe 22000 St Brieuc','10')
    ->('Mile','Eight','22 rue du Rap 22000 St Brieuc','11')
    ->('Jackson','Janette','22 rue de l Histoire 22000 St Brieuc','12')
;

INSERT INTO conseiller(id, nom, prenom)
    ->VALUES
    ->('Martin','Pierre',1)
    ->('Dubois','Marie',1)
    ->('Leroy','Antoine',1)
    ->('Chevalier','Emmanuelle',1)
;

INSERT INTO contrat(id, mensualite, type, date_debut, date_fin, id_client)
    ->VALUES
    ->('1','1000','Abonnement','2022-01-01 08:00:00','2022-06-30 08:00:00','1')
    ->('2','1500','Contrat','2022-02-14 12:30:00','2023-02-14 12:30:00','2')
    ->('3','300','Contrat','2022-03-01 09:15:00','2022-08-31 09:15:00','2')
    ->('4','1000','Contrat','2022-04-05 10:45:00','2024-04-05 10:45:00','3')
    ->('5','750','Abonnement','2022-05-12 13:20:00','2022-11-11 13:20:00','4')
    ->('6','2000','Abonnement','2022-06-15 16:00:00','2023-06-15 16:00:00','5')
    ->('7','400','Abonnement','2022-07-20 11:10:00','2023-01-19 11:10:00','6')
;

