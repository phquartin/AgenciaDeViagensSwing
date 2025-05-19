-- Seleção do banco de dados para uso
USE agencia_de_viagens_swing;

-- Tabela Países (sem alterações)
CREATE TABLE paises (
                id_pais INT AUTO_INCREMENT PRIMARY KEY,
                nome VARCHAR(100) NOT NULL UNIQUE,
                continente ENUM('ASIA', 'EUROPA', 'AFRICA', 'AMERICA_CENTRAL', 'AMERICA_DO_NORTE', 'AMERICA_DO_SUL', 'OCEANIA')
);

-- Tabela Destinos (sem alterações)
CREATE TABLE destinos (
                id_destino INT AUTO_INCREMENT PRIMARY KEY,
                nome VARCHAR(100) NOT NULL UNIQUE,
                descricao TEXT NULL,
                id_pais INT,
                FOREIGN KEY (id_pais) REFERENCES paises(id_pais) ON DELETE CASCADE
);

-- Tabela Pacotes (remover a coluna id_destino e alterar para relacionamento muitos-para-muitos)
CREATE TABLE pacotes (
                id_pacote INT AUTO_INCREMENT PRIMARY KEY,
                nome VARCHAR(100) NOT NULL,
                duracao INT NOT NULL,
                preco DECIMAL(10,2) NOT NULL,
                tipo_pacote ENUM('AVENTURA','CULTURAL','FAMILIA','LUXO', 'RELAX', 'NATUREZA', 'CULINARIO') NOT NULL
);

-- Tabela Pacotes-Relacional entre Pacotes e Destinos (muitos-para-muitos)
CREATE TABLE pacotes_destinos (
                id_pacote INT,
                id_destino INT,
                PRIMARY KEY (id_pacote, id_destino),
                FOREIGN KEY (id_pacote) REFERENCES pacotes(id_pacote) ON DELETE CASCADE,
                FOREIGN KEY (id_destino) REFERENCES destinos(id_destino) ON DELETE CASCADE
);

-- Tabela Clientes (sem alterações)
CREATE TABLE clientes (
                id_cliente INT AUTO_INCREMENT PRIMARY KEY,
                nome VARCHAR(100) NOT NULL,
                telefone VARCHAR(20) NOT NULL,
                email VARCHAR(100) NOT NULL,
                tipo_cliente ENUM('NACIONAL', 'ESTRANGEIRO') NOT NULL,
                documento VARCHAR(20) NOT NULL UNIQUE
);

-- Tabela Clientes-Pacotes (sem alterações)
CREATE TABLE clientes_pacotes (
                id_cliente_pacote INT AUTO_INCREMENT PRIMARY KEY,
                id_cliente INT NOT NULL,
                id_pacote INT NOT NULL,
                data_inicio DATE NOT NULL,
                FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente) ON DELETE CASCADE,
                FOREIGN KEY (id_pacote) REFERENCES pacotes(id_pacote) ON DELETE CASCADE
);

-- Tabela Serviços (sem alterações)
CREATE TABLE servicos (
                id_servico INT AUTO_INCREMENT PRIMARY KEY,
                nome VARCHAR(100) NOT NULL,
                preco DECIMAL(10,2) NOT NULL
);

-- Tabela Pedidos-Serviços Adicionais (sem alterações)
CREATE TABLE pedidos_servicos (
                id_cliente_pacote INT,
                id_servico INT,
                PRIMARY KEY (id_cliente_pacote, id_servico),
                FOREIGN KEY (id_cliente_pacote) REFERENCES clientes_pacotes(id_cliente_pacote) ON DELETE CASCADE,
                FOREIGN KEY (id_servico) REFERENCES servicos(id_servico) ON DELETE CASCADE
);

                
INSERT INTO paises (nome, continente)
VALUES
    ('Brasil', 'AMERICA_DO_SUL'), ('Argentina', 'AMERICA_DO_SUL'), ('Estados Unidos', 'AMERICA_DO_NORTE'), ('Canadá', 'AMERICA_DO_NORTE'), ('México', 'AMERICA_CENTRAL'), ('Alemanha', 'EUROPA'), ('França', 'EUROPA'), ('Itália', 'EUROPA'), ('Espanha', 'EUROPA'), ('Japão', 'ASIA'), ('China', 'ASIA'), ('Austrália', 'OCEANIA'), ('Nova Zelândia', 'OCEANIA'), ('África do Sul', 'AFRICA'), ('Egito', 'AFRICA'), ('Índia', 'ASIA'), ('Rússia', 'EUROPA'), ('Portugal', 'EUROPA'), ('Chile', 'AMERICA_DO_SUL'), ('Colômbia', 'AMERICA_DO_SUL');

INSERT INTO destinos (nome, descricao, id_pais)
VALUES
    ('Rio de Janeiro', 'A cidade maravilhosa com paisagens incríveis como o Pão de Açúcar e o Cristo Redentor.', 1),
    ('Buenos Aires', 'Capital da Argentina, conhecida por sua arquitetura europeia e danças de tango.', 2),
    ('Nova York', 'A cidade que nunca dorme, lar de ícones como a Estátua da Liberdade e a Times Square.', 3),
    ('Orlando', 'A cidade conhecida por ter os famosos parques da Disney e da Universal', 3),
    ('Toronto', 'Maior cidade do Canadá, conhecida por sua diversidade cultural e pela CN Tower.', 4),
    ('Cancún', 'Destino paradisíaco no México conhecido por suas praias de areia branca e águas cristalinas.', 5),
    ('Berlim', 'Capital da Alemanha repleta de história, arte e cultura.', 6),
    ('Paris', 'A cidade da luz, famosa por sua beleza, a Torre Eiffel e o Louvre.', 7),
    ('Roma', 'A cidade eterna, cheia de história e monumentos icônicos como o Coliseu.', 8),
    ('Barcelona', 'Conhecida pela arquitetura de Gaudí, ótimas praias e a cultura viva.', 9),
    ('Tóquio', 'Mistura de tradição e tecnologia no coração do Japão.', 10),
    ('Pequim', 'Capital da China, famosa pela Cidade Proibida e a Grande Muralha.', 11),
    ('Sydney', 'Centro cultural e financeiro da Austrália, lar da icônica Opera House.', 12),
    ('Queenstown', 'Cidade da Nova Zelândia conhecida por seus esportes radicais e paisagens deslumbrantes.', 13),
    ('Cidade do Cabo', 'Cidade costeira da África do Sul, com paisagens fascinantes como a Table Mountain.', 14),
    ('Cairo', 'Capital do Egito, lar das famosas pirâmides e da Grande Esfinge.', 15),
    ('Nova Deli', 'Capital vibrante da Índia, cheia de mercados, templos e história.', 16),
    ('Moscou', 'Capital da Rússia, famosa pelo Kremlin e pela Praça Vermelha.', 17),
    ('Lisboa', 'Capital de Portugal, conhecida por suas colinas e bondes charmosos.', 18),
    ('Santiago', 'Capital do Chile, com vistas impressionantes da Cordilheira dos Andes.', 19),
    ('Cartagena', 'Cidade colombiana histórica com belas praias e arquitetura colonial.', 20);

INSERT INTO pacotes (nome, duracao, preco, tipo_pacote)
VALUES
    ('Pacote Aventura Brasil', 7, 1500.00, 'AVENTURA'),
    ('Pacote Cultural Roma', 5, 2500.00, 'CULTURAL'),
    ('Relax Cancún', 4, 2000.00, 'RELAX'),
    ('Explorando o Japão', 10, 4000.00, 'AVENTURA'),
    ('Love in Paris', 6, 3000.00, 'LUXO'),
    ('Trilha na África do Sul', 8, 1800.00, 'AVENTURA'),
    ('Gastronomia Italiana', 7, 2200.00, 'CULINARIO'),
    ('Paisagens na Nova Zelândia', 9, 3500.00, 'NATUREZA'),
    ('História e Cultura Egito', 5, 2700.00, 'CULTURAL'),
    ('Praias de Cartagena', 6, 1900.00, 'RELAX'),
    ('Tour pela Europa', 20, 20000.00, 'CULTURAL');

INSERT INTO pacotes_destinos (id_pacote, id_destino)
VALUES
    (1, 1),  -- Pacote Aventura Brasil -> Rio de Janeiro
    (2, 8),  -- Pacote Cultural Roma -> Roma
    (3, 6),  -- Relax Cancún -> Cancún
    (4, 10), -- Explorando o Japão -> Tóquio
    (5, 7),  -- Love in Paris -> Paris
    (6, 14), -- Trilha na África do Sul -> Cidade do Cabo
    (7, 8),  -- Gastronomia Italiana -> Roma
    (8, 13), -- Paisagens na Nova Zelândia -> Queenstown
    (9, 15), -- História e Cultura Egito -> Cairo
    (10, 20), -- Praias de Cartagena -> Cartagena
    -- TOUR EUROPA
    (11, 7),
    (11, 8),
    (11, 9),
    (11, 10),
    (11, 18),
    (11, 19);
    --

INSERT INTO servicos (nome, preco) VALUES
             ('Transporte', 200.00),
             ('Alimentacao', 300.00),
             ('Internet', 211.99),
             ('Guia Turistico', 499.99);

