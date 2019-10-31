CREATE TABLE CAD_USUARIOS (
  CPF CHAR(11) NOT NULL, 
  SENHA CHAR(40) NOT NULL, 
  NOME VARCHAR(20) NOT NULL, 
  SOBRENOME VARCHAR(50) NOT NULL, 
  NASCIMENTO CHAR(10) NOT NULL, 
  EMAIL VARCHAR(50) NOT NULL, 
  TELEFONE CHAR(14) NOT NULL, 
  CELULAR CHAR(15) NOT NULL, 
  PRIMARY KEY (CPF)
);

CREATE TABLE CAD_IMOVEIS (
  ID INTEGER AUTO_INCREMENT NOT NULL, 
  CPFLOGADO CHAR(11) NOT NULL, 
  TIPO VARCHAR(15) NOT NULL, 
  TITULO VARCHAR(50) NOT NULL, 
  QUARTOS INTEGER NOT NULL, 
  SUITES INTEGER NOT NULL, 
  BANHEIROS INTEGER NOT NULL, 
  VAGAS INTEGER NOT NULL, 
  AREA INTEGER NOT NULL, 
  PISCINA CHAR(3), 
  CIDADE VARCHAR(30) NOT NULL, 
  ESTADO VARCHAR(20) NOT NULL, 
  BAIRRO VARCHAR(30) NOT NULL, 
  DESCRICAO VARCHAR(100) NOT NULL, 
  VALORSUGERIDO VARCHAR(15), 
  VALORVENDA VARCHAR(15) NOT NULL, 
  TELEFONE CHAR(14), 
  CELULAR CHAR(15), 
  EMAIL VARCHAR(50), 
  PRIMARY KEY (ID)
);

ALTER TABLE 
  CAD_IMOVEIS AUTO_INCREMENT = 10100;

CREATE TABLE BAIRROS_IMOVEIS (
  ID INTEGER NOT NULL, 
  BAIRRO VARCHAR(50) NOT NULL, 
  PRIMARY KEY (ID)
);

INSERT INTO BAIRROS_IMOVEIS (ID, BAIRRO) VALUES
(1, 'Aarão Reis'),
(2, 'Acaiaca'),
(3, 'Aeroporto'),
(4, 'Águas Claras'),
(5, 'Alípio De Melo'),
(6, 'Alpes'),
(7, 'Alto Barroca'),
(8, 'Alto Caiçaras'),
(9, 'Alto Dos Pinheiros'),
(10, 'Álvaro Camargos'),
(11, 'Anchieta'),
(12, 'Aparecida'),
(13, 'Araguaia'),
(14, 'Átila de Paiva'),
(15, 'Bandeirantes'),
(16, 'Barreiro'),
(17, 'Barreiro de Baixo'),
(18, 'Barro Preto'),
(19, 'Barroca'),
(20, 'Belmonte'),
(21, 'Belvedere'),
(22, 'Betânia'),
(23, 'Boa Viagem'),
(24, 'Boa Vista'),
(25, 'Bom Jesus'),
(26, 'Bonfim'),
(27, 'Bonsucesso'),
(28, 'Brasil Industrial'),
(29, 'Braunas'),
(30, 'Buritis'),
(31, 'Cachoeirinha'),
(32, 'Caiçaras'),
(33, 'Calafate'),
(34, 'California'),
(35, 'Camargos'),
(36, 'Campo Alegre'),
(37, 'Canaã'),
(38, 'Candelária'),
(39, 'Cardoso'),
(40, 'Carlos Prates'),
(41, 'Carmo'),
(42, 'Casa Branca'),
(43, 'Castanheira'),
(44, 'Castelo'),
(45, 'Cenáculo'),
(46, 'Centro'),
(47, 'Céu Azul'),
(48, 'Cidade Jardim'),
(49, 'Cidade Nova'),
(50, 'Cinquentenário'),
(51, 'Colégio Batista'),
(52, 'Concórdia'),
(53, 'Conjunto Ademar Maldonado'),
(54, 'Conjunto Califórnia'),
(55, 'Conjunto Celso Machado'),
(56, 'Conjunto Confisco'),
(57, 'Conjunto Minascaixa'),
(58, 'Conjunto Túnel Ibirité'),
(59, 'Copacabana'),
(60, 'Coqueiros'),
(61, 'Coração De Jesus'),
(62, 'Coração Eucarístico'),
(63, 'Cruzeiro'),
(64, 'Diamante'),
(65, 'Distrito Industrial do Jatobá'),
(66, 'Dom Bosco'),
(67, 'Dom Cabral'),
(68, 'Dom Joaquim'),
(69, 'Dom Silvério'),
(70, 'Dona Clara'),
(71, 'Engenho Nogueira'),
(72, 'Ermelinda'),
(73, 'Esplanada'),
(74, 'Estoril'),
(75, 'Estrela Dalva'),
(76, 'Estrela do Oriente'),
(77, 'Etelvina Carneiro'),
(78, 'Europa'),
(79, 'Eymard'),
(80, 'Fernão Dias'),
(81, 'Flávio De Oliveira'),
(82, 'Flávio Marques Lisboa'),
(83, 'Floramar'),
(84, 'Floresta'),
(85, 'Frei Eustáquio'),
(86, 'Frei Leopoldo'),
(87, 'Funcionários'),
(88, 'Gameleira'),
(89, 'Garças'),
(90, 'Glória'),
(91, 'Goiânia'),
(92, 'Graça'),
(93, 'Grajaú'),
(94, 'Guarani'),
(95, 'Gutierrez'),
(96, 'Havaí'),
(97, 'Heliópolis'),
(98, 'Horto'),
(99, 'Inconfidência'),
(100, 'Indaiá'),
(101, 'Independência'),
(102, 'Indians'),
(103, 'Ipanema'),
(104, 'Ipê'),
(105, 'Ipiranga'),
(106, 'Itaipu'),
(107, 'Itapoã'),
(108, 'Itatiaia'),
(109, 'Jaqueline'),
(110, 'Jaraguá'),
(111, 'Jardim Alvorada'),
(112, 'Jardim América'),
(113, 'Jardim Atlântico'),
(114, 'Jardim Belmonte'),
(115, 'Jardim Dos Comerciários'),
(116, 'Jardim Felicidade'),
(117, 'Jardim Filadélfia'),
(118, 'Jardim Guanabara'),
(119, 'Jardim Leblon'),
(120, 'Jardim Montanhês'),
(121, 'Jardim Pirineus'),
(122, 'Jardim Vitória'),
(123, 'Jatobá'),
(124, 'João Pinheiro'),
(125, 'Jonas Veiga'),
(126, 'Juliana'),
(127, 'Lagoa'),
(128, 'Lagoinha'),
(129, 'Lagoinha Leblon'),
(130, 'Leblon'),
(131, 'Letícia'),
(132, 'Liberdade'),
(133, 'Lindéia'),
(134, 'Lourdes'),
(135, 'Luxemburgo'),
(136, 'Madre Gertrudes'),
(137, 'Manacás'),
(138, 'Mangabeiras'),
(139, 'Mangueiras'),
(140, 'Mantiqueira'),
(141, 'Marajó'),
(142, 'Maria Goretti'),
(143, 'Maria Helena'),
(144, 'Maria Virgínia'),
(145, 'Marilândia'),
(146, 'Milionários'),
(147, 'Minas Brasil'),
(148, 'Minascaixa'),
(149, 'Minaslândia'),
(150, 'Mineirão'),
(151, 'Miramar'),
(152, 'Monsenhor Messias'),
(153, 'Nazaré'),
(154, 'Nova Cachoeirinha'),
(155, 'Nova Cintra'),
(156, 'Nova Esperança'),
(157, 'Nova Floresta'),
(158, 'Nova Gameleira'),
(159, 'Nova Granada'),
(160, 'Nova Pampulha'),
(161, 'Nova Suíssa'),
(162, 'Nova Vista'),
(163, 'Nova York'),
(164, 'Novo Aarão Reis'),
(165, 'Novo das Indústrias'),
(166, 'Novo Glória'),
(167, 'Novo São Lucas'),
(168, 'Olaria'),
(169, 'Ouro Minas'),
(170, 'Ouro Preto'),
(171, 'Padre Eustáquio'),
(172, 'Padre Júlio Maria'),
(173, 'Palmares'),
(174, 'Palmeiras'),
(175, 'Pampulha'),
(176, 'Paquetá'),
(177, 'Paraíso'),
(178, 'Paraúna'),
(179, 'Parque Copacabana'),
(180, 'Parque São João Batista'),
(181, 'Parque São José'),
(182, 'Parque São Pedro'),
(183, 'Paulo VI'),
(184, 'Pedro II'),
(185, 'Penha'),
(186, 'Petrópolis'),
(187, 'Pilar'),
(188, 'Pindorama'),
(189, 'Pirajá'),
(190, 'Piratininga'),
(191, 'Planalto'),
(192, 'Pompeia'),
(193, 'Pongelupe'),
(194, 'Pousada Santo Antônio'),
(195, 'Prado'),
(196, 'Primeiro De Maio'),
(197, 'Providência'),
(198, 'Regina'),
(199, 'Renascença'),
(200, 'Ribeiro De Abreu'),
(201, 'Rio Branco'),
(202, 'Sagrada Familia'),
(203, 'Salgado Filho'),
(204, 'Santa Amélia'),
(205, 'Santa Branca'),
(206, 'Santa Cruz'),
(207, 'Santa Efigênia'),
(208, 'Santa Helena'),
(209, 'Santa Inês'),
(210, 'Santa Lúcia'),
(211, 'Santa Maria'),
(212, 'Santa Mônica'),
(213, 'Santa Rosa'),
(214, 'Santa Tereza'),
(215, 'Santa Terezinha'),
(216, 'Santo Agostinho'),
(217, 'Santo André'),
(218, 'Santo Antônio'),
(219, 'São Benedito'),
(220, 'São Bento'),
(221, 'São Bernardo'),
(222, 'São Cristóvão'),
(223, 'São Francisco'),
(224, 'São Gabriel'),
(225, 'São Geraldo'),
(226, 'São João Batista'),
(227, 'São José'),
(228, 'São Lucas'),
(229, 'São Luiz'),
(230, 'São Marcos'),
(231, 'São Paulo'),
(232, 'São Pedro'),
(233, 'São Salvador'),
(234, 'São Sebastião'),
(235, 'São Tomáz'),
(236, 'Saramenha'),
(237, 'Saudade'),
(238, 'Savassi'),
(239, 'Serra'),
(240, 'Serra Verde'),
(241, 'Serrano'),
(242, 'Silveira'),
(243, 'Sinimbu'),
(244, 'Sion'),
(245, 'Solar do Barreiro'),
(246, 'Taquaril'),
(247, 'Teixeira Dias'),
(248, 'Tirol'),
(249, 'Trevo'),
(250, 'Tupi A'),
(251, 'União'),
(252, 'Universitário'),
(253, 'Urca'),
(254, 'Vale do Jatobá'),
(255, 'Venda Nova'),
(256, 'Vila Cloris'),
(257, 'Vila Magnesita'),
(258, 'Vila Oeste'),
(259, 'Vila Paris'),
(260, 'Vila Pinho'),
(261, 'Vila São José'),
(262, 'Vila Zilah Spósito'),
(263, 'Vista Alegre'),
(264, 'Vitória'),
(265, 'Xodó Marize');