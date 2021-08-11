
CREATE DATABASE IF NOT EXISTS BABEL;

USE BABEL;

CREATE TABLE Localizacion(
	idLocalizacion INT NOT NULL AUTO_INCREMENT,
	sala INT,
	estante INT,
	posicion INT,
	PRIMARY KEY (idLocalizacion)
);

CREATE TABLE Libro(
	idLibro INT NOT NULL AUTO_INCREMENT,
	volumen INT,
	titulo VARCHAR(100),
	idLocalizacion INT NOT NULL,
	PRIMARY KEY(idLibro),
	FOREIGN KEY(idLocalizacion) REFERENCES Localizacion(idLocalizacion)
);

INSERT INTO Localizacion VALUES (0,1,1,1);
INSERT INTO Localizacion VALUES (0,2,4,2);
INSERT INTO Localizacion VALUES (0,1,6,7);
INSERT INTO Localizacion VALUES (0,1,3,1);

INSERT INTO Libro VALUES (0,1,"El principito",1);
INSERT INTO Libro VALUES (0,2,"Romeo y Julieta",2);
INSERT INTO Libro VALUES (0,1,"Hamlet",3);
INSERT INTO Libro VALUES (0,1,"El laberinto",4);
