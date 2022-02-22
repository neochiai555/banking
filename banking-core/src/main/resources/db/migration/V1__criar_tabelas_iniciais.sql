CREATE TABLE IF NOT EXISTS banking."agencia"
(
    id integer NOT NULL,
    nome character varying(100) NOT NULL,
    numero character(6) NOT NULL,
    digito character(1) NOT NULL,
    PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE banking."agencia"
    OWNER to postgres;
    
CREATE SEQUENCE banking.seq_agencia
    INCREMENT 1
    START 1;

ALTER SEQUENCE banking.seq_agencia
    OWNER TO postgres;
    
CREATE TABLE IF NOT EXISTS banking.conta
(
    id integer NOT NULL,
    id_agencia integer NOT NULL,
    numero character(10) NOT NULL,
    digito character(1) NOT NULL,
    tipo "char" NOT NULL,
    titular character varying(200) NOT NULL,
    saldo_inicial numeric(10, 2) NOT NULL,
    PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE banking.conta
    OWNER to postgres;
    
CREATE SEQUENCE banking.seq_conta
    INCREMENT 1
    START 1;

ALTER SEQUENCE banking.seq_conta
    OWNER TO postgres;

CREATE TABLE IF NOT EXISTS banking.movimentacao
(
    id integer NOT NULL,
    data timestamp without time zone NOT NULL,
    tipo integer NOT NULL,
    valor numeric(10, 2) NOT NULL,
    PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE banking.movimentacao
    OWNER to postgres;
    
CREATE SEQUENCE banking.seq_movimentacao
    INCREMENT 1
    START 1;

ALTER SEQUENCE banking.seq_movimentacao
    OWNER TO postgres;

CREATE TABLE IF NOT EXISTS banking.tipo_movimentacao
(
    id integer NOT NULL,
    codigo character varying(5) NOT NULL,
    descricao character varying(200) NOT NULL,
    PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE banking.tipo_movimentacao
    OWNER to postgres;
    
CREATE SEQUENCE banking.seq_tipo_movimentacao
    INCREMENT 1
    START 1;

ALTER SEQUENCE banking.seq_tipo_movimentacao
    OWNER TO postgres;

INSERT INTO banking.tipo_movimentacao
(id, codigo, descricao) values (nextval('banking.seq_tipo_movimentacao'), 'DEP', 'Depósito');
INSERT INTO banking.tipo_movimentacao
(id, codigo, descricao) values (nextval('banking.seq_tipo_movimentacao'), 'SAQ', 'Saque');
