Create table Credit(
id int PRIMARY KEY AUTO_INCREMENT,
Libelle VARCHAR(100),
Montant double,
rest double
);

Create table Depense(
    id int PRIMARY key AUTO_INCREMENT,
    idCredit int,
    Montant double,
    Da_te date,
    FOREIGN KEY (idCredit) REFERENCES Credit(id)
);

Create Table User (
    id int PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    password VARCHAR(100)

);
