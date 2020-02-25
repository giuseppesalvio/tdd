DROP TABLE IF EXISTS contoCorrente;

CREATE TABLE contoCorrente (
  id NCHAR(20)  PRIMARY KEY,
  saldo INT DEFAULT NOT NULL
);

INSERT INTO contoCorrente  (id, saldo) VALUES
  ('123', 10),
  ('4566', 11),
  ('1', 11111);