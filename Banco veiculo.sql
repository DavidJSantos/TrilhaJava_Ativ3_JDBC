CREATE database trilha_java;

USE trilha_java;

CREATE TABLE veiculo(
	id INTEGER(10) PRIMARY KEY AUTO_INCREMENT,
    modelo VARCHAR(30) NOT NULL,
    placa VARCHAR(10)
);

SELECT * FROM veiculo;