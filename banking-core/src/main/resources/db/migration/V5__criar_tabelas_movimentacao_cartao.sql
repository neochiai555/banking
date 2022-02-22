CREATE TABLE IF NOT EXISTS banking.movimentacao_cartao
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

ALTER TABLE banking.movimentacao_cartao
    OWNER to postgres;
    
CREATE SEQUENCE banking.seq_movimentacao_cartao
    INCREMENT 1
    START 1;

ALTER SEQUENCE banking.seq_movimentacao_cartao
    OWNER TO postgres;

CREATE TABLE IF NOT EXISTS banking.tipo_movimentacao_cartao
(
    id integer NOT NULL,
    codigo character varying(5) NOT NULL,
    descricao character varying(200) NOT NULL,
    PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE banking.tipo_movimentacao_cartao
    OWNER to postgres;
    
CREATE SEQUENCE banking.seq_tipo_movimentacao_cartao
    INCREMENT 1
    START 1;

ALTER SEQUENCE banking.seq_tipo_movimentacao_cartao
    OWNER TO postgres;

INSERT INTO banking.tipo_movimentacao_cartao
(id, codigo, descricao) values (nextval('banking.seq_tipo_movimentacao_cartao'), 'CPR', 'Compra');
INSERT INTO banking.tipo_movimentacao_cartao
(id, codigo, descricao) values (nextval('banking.seq_tipo_movimentacao_cartao'), 'PGT', 'Pagamento');
INSERT INTO banking.tipo_movimentacao_cartao
(id, codigo, descricao) values (nextval('banking.seq_tipo_movimentacao_cartao'), 'EST', 'Estorno');