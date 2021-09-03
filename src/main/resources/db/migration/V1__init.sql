CREATE TABLE document
(
    id bigserial NOT NULL,
    title character varying NOT NULL,
    amount numeric(9, 2) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO document (title, amount) VALUES ('doc1', 123.45),('doc2',456.78);