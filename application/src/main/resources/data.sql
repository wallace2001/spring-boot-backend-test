CREATE TABLE IF NOT EXISTS public.seg_usuario (
    id_usuario SERIAL PRIMARY KEY,
    nm_usuario VARCHAR(255),
    ds_cidade VARCHAR(255),
    nr_telefone VARCHAR(255),
    data_nascimento DATE,
    cd_uf VARCHAR(2)
);
INSERT INTO public.seg_usuario(id_usuario, nm_usuario, ds_cidade, nr_telefone, data_nascimento, cd_uf) VALUES
  (1, 'José da Silva', 'São Paulo', '61992289025', '1990-02-01', 'SP'),
  (2, 'Marco Antonio Alves', 'Ubutuba', '61992289025', '2007-05-03', 'SP'),
  (3, 'Maria Joaquina', 'Brasília', '61992289025', '2000-07-22', 'DF'),
  (4, 'Mauricio de Souza', 'Niterói', '61992289025', '1991-01-01', 'SP'),
  (5, 'André Silvério Pinto', 'Guarulhos', '61992289025', '1990-11-30', 'SP'),
  (6, 'Eduardo Urbano', 'Rio de Janeiro', '61992289025', '1977-05-08', 'RJ'),
  (7, 'Vanessa Alvares Cabral', 'Barueri', '61992289025', '1980-06-20', 'SP');
