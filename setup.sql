CREATE TABLE IF NOT EXISTS Clientes (
    cpf         VARCHAR(14) PRIMARY KEY,
    rg          VARCHAR(15) NOT NULL,
    nome        VARCHAR(100) NOT NULL,
    sobrenome   VARCHAR(100) NOT NULL,
    rua         VARCHAR(200),
    bairro      VARCHAR(100),
    estado      VARCHAR(2),
    cidade      VARCHAR(100),
    numero      INT
);

DROP TABLE Veiculos;

CREATE TABLE IF NOT EXISTS Veiculos (
    placa           VARCHAR(9) PRIMARY KEY,
    tipo            INT NOT NULL,
    marca           VARCHAR(50) NOT NULL,
    modelo          VARCHAR(100) NOT NULL,
    estado          VARCHAR(50) NOT NULL,
    categoria       VARCHAR(50) NOT NULL,
    valor_compra    DOUBLE NOT NULL,
    ano             INT NOT NULL
);

CREATE TABLE IF NOT EXISTS Locacoes (
    id      INT AUTO_INCREMENT PRIMARY KEY,
    dias    INT NOT NULL,
    valor   DOUBLE NOT NULL,
    data    BIGINT NOT NULL,
    cpf     VARCHAR(14) NOT NULL,
    placa   VARCHAR(9) NOT NULL,

    FOREIGN KEY (cpf) REFERENCES Clientes(cpf) ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (placa) REFERENCES Veiculos(placa) ON DELETE RESTRICT ON UPDATE CASCADE
);


INSERT INTO alugacar.Clientes (cpf,rg,nome,sobrenome,rua,bairro,estado,cidade,numero) VALUES
	 ('032.772.923-63','28.052.460-2','Daniel Ricardo Carlos','Cunha','Rua do Magano','Magano','SP','Limeira',443),
	 ('196.659.997-88','47.785.119-8','Maya Sophie Emily','Dias','Rua Valmir Soares Bezerra','Zona de Expansão (Aruana)','PI','Palmas',244),
	 ('200.890.856-98','15.899.547-8','Pedro Henrique Ian','Cardoso','Rua Marieta de Mello Marques','Doutor Sílvio Leite','AC','Cariri',453),
	 ('892.672.365-80','47.381.400-6','Marcelo Caleb','Teixeira','Beco Cantinho do Amor','Bosque','MA','São Luís',223);

INSERT INTO alugacar.Veiculos (placa,tipo,marca,modelo,estado,categoria,valor_compra,ano) VALUES
	 ('BOPM-4040',1,'YAMAHA','YAMAHA_R1','NOVO','LUXO',35000.0,2009),
	 ('FJWO-2923',2,'BMW','M3','NOVO','LUXO',1200300.0,2021),
	 ('FMOG-3333',2,'TOYOTA','ETIOS','NOVO','INTERMEDIARIO',45000.0,2025),
	 ('GDFH-3535',2,'TOYOTA','COROLLA','NOVO','INTERMEDIARIO',80000.0,2022),
	 ('GKGK-3003',2,'VW','VW_JETTA','NOVO','INTERMEDIARIO',95000.0,2024),
	 ('GKOK-4994',2,'BMW','M5','NOVO','LUXO',495900.0,2013),
	 ('KBOB-3040',2,'PEUGEOT','PG_2008','NOVO','POPULAR',50000.0,2020),
	 ('KGLE-0302',1,'KAWASAKI','KAWASAKI_Z900','NOVO','LUXO',72000.0,2023),
	 ('KGOR-0320',1,'DUCATI','DUCATI_MULTISTRADA','NOVO','LUXO',120000.0,2019),
	 ('KKKG-3094',3,'PEUGEOT','PG_EXPERT','NOVO','POPULAR',80000.0,2021),
	 ('KLFL-0200',2,'CITROEN','BASALT','NOVO','INTERMEDIARIO',300000.0,2019),
	 ('KOFD-0304',1,'SUZUKI','SUZUKI_GSX_S750','NOVO','LUXO',56000.0,2016),
	 ('LALA-2903',1,'KAWASAKI','KAWASAKI_VERSYS650','NOVO','INTERMEDIARIO',72000.0,2014),
	 ('LFLL-0303',2,'MERCEDES','AMG_ONE','NOVO','LUXO',1000000.0,2016),
	 ('LNME-4404',2,'GM','GM_CELTA','NOVO','POPULAR',77200.0,2025),
	 ('OGFF-0404',1,'HONDA','HONDA_CB500F','NOVO','INTERMEDIARIO',40000.0,2024),
	 ('OGPE-3002',3,'VW','VW_KOMBI','NOVO','INTERMEDIARIO',203000.0,2022),
	 ('OIEJ-9391',2,'VW','VW_GOLF','NOVO','INTERMEDIARIO',67990.0,2024),
	 ('OPGK-4994',3,'PEUGEOT','PG_EXPERT','NOVO','POPULAR',100200.0,2018),
	 ('OSDP-0404',3,'PEUGEOT','PG_BOXER','NOVO','POPULAR',85000.0,2019),
	 ('PIOJ-0404',1,'SUZUKI','SUZUKI_HAYABUSA','NOVO','LUXO',58000.0,2009),
	 ('POKP-4004',3,'GM','GM_EXpress','NOVO','INTERMEDIARIO',50300.0,2014),
	 ('VKOV-0404',3,'PEUGEOT','PG_PARTNER','NOVO','INTERMEDIARIO',400400.0,2021),
	 ('VMOG-3030',2,'TOYOTA','YARIS','NOVO','INTERMEDIARIO',70000.0,2024);