CREATE ROLE restaurante LOGIN
  ENCRYPTED PASSWORD 'md5365803233722b28b710adb138bd3bb14'
  SUPERUSER INHERIT NOCREATEDB NOCREATEROLE NOREPLICATION;


CREATE DATABASE restaurante
  WITH OWNER = restaurante
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'pt_BR.UTF-8'
       LC_CTYPE = 'pt_BR.UTF-8'
       CONNECTION LIMIT = -1;


CREATE TABLE public.pessoas(
  cpf VARCHAR(11) PRIMARY KEY,
  nome VARCHAR(50) NOT NULL,
  endereco VARCHAR(50),
  email VARCHAR(30),
  telefone VARCHAR(12),
  sexo_masculino BOOLEAN NOT NULL
);
ALTER TABLE public.pessoas
  OWNER TO restaurante;


CREATE TABLE public.ingredientes(
  codigo SERIAL PRIMARY KEY,
  nome VARCHAR(50) NOT NULL,
  qtd_estoque INTEGER NOT NULL DEFAULT 0
);
ALTER TABLE public.ingredientes
  OWNER TO restaurante;


CREATE TABLE public.pedidos(
  codigo serial PRIMARY KEY,
  codigo_mesa INTEGER NOT NULL,
  cpf_garcom VARCHAR(11),
  lista_produtos INTEGER[],
  qtd_produtos INTEGER[],
  pedido_pronto BOOLEAN DEFAULT false
);
ALTER TABLE public.pedidos
  OWNER TO restaurante;


CREATE TABLE public.produtos(
  codigo SERIAL PRIMARY KEY,
  nome VARCHAR(50) NOT NULL,
  preco NUMERIC DEFAULT 0.0,
  lista_ingredientes INTEGER[],
  qtd_ingredientes INTEGER[]
);
ALTER TABLE public.produtos
  OWNER TO restaurante;