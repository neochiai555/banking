CREATE TABLE IF NOT EXISTS banking.cartao
(
    id integer NOT NULL,
    emissao timestamp without time zone NOT NULL,
    validade timestamp without time zone NOT NULL,
    tipo integer NOT NULL,
    numero character(16) NOT NULL,
    limiteSaque numeric(10,2) NOT NULL,
    PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE banking.cartao
    OWNER to postgres;
    
CREATE SEQUENCE banking.seq_cartao
    INCREMENT 1
    START 1;

ALTER SEQUENCE banking.seq_cartao
    OWNER TO postgres;

CREATE TABLE IF NOT EXISTS banking.tipo_cartao
(
    id integer NOT NULL,
    codigo character varying(5) NOT NULL,
    descricao character varying(200) NOT NULL,
    PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE banking.tipo_cartao
    OWNER to postgres;
    
CREATE SEQUENCE banking.seq_tipo_cartao
    INCREMENT 1
    START 1;

ALTER SEQUENCE banking.seq_tipo_cartao
    OWNER TO postgres;

INSERT INTO banking.tipo_cartao
(id, codigo, descricao) values (nextval('banking.seq_tipo_cartao'), 'DEB', 'Débito');
INSERT INTO banking.tipo_cartao
(id, codigo, descricao) values (nextval('banking.seq_tipo_cartao'), 'CRD', 'Crédito');
INSERT INTO banking.tipo_cartao
(id, codigo, descricao) values (nextval('banking.seq_tipo_cartao'), 'MUL', 'Múltiplo');
