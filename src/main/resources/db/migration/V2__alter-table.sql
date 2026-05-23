ALTER TABLE tipoalimento
    ADD usuario_id int;

ALTER TABLE tipoalimento
    ADD FOREIGN KEY (usuario_id) REFERENCES usuario(id);

ALTER TABLE agricultor
    ADD usuario_id int;

ALTER TABLE agricultor
    ADD FOREIGN KEY (usuario_id) REFERENCES usuario(id);

ALTER TABLE cronograma
    ADD usuario_id int;

ALTER TABLE cronograma
    ADD FOREIGN KEY (usuario_id) REFERENCES usuario(id);

ALTER TABLE edital
    ADD usuario_id int;

ALTER TABLE edital
    ADD FOREIGN KEY (usuario_id) REFERENCES usuario(id);