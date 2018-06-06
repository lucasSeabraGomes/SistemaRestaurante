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


CREATE TABLE public.clientes(
  cpf VARCHAR(11) PRIMARY KEY,
  nome VARCHAR(50) NOT NULL,
  rg VARCHAR(20) NOT NULL,
  telefone VARCHAR(12),
  endereco VARCHAR(50),
  email VARCHAR(30),
  sexo_masculino BOOLEAN NOT NULL,
  pedidos_frequentes INTEGER[]
);
ALTER TABLE public.clientes
  OWNER TO restaurante;


CREATE TABLE public.cargos(
  codigo INTEGER PRIMARY KEY,
  nome VARCHAR(20) NOT NULL
);
ALTER TABLE public.cargos
  OWNER TO restaurante;


CREATE TABLE public.funcionarios(
  cpf VARCHAR(11) PRIMARY KEY,
  nome VARCHAR(50) NOT NULL,
  rg VARCHAR(20) NOT NULL,
  telefone VARCHAR(12),
  endereco VARCHAR(50),
  email VARCHAR(30),
  sexo_masculino BOOLEAN NOT NULL,
  ctps VARCHAR(20) NOT NULL,
  salario NUMERIC NOT NULL DEFAULT 0.0,
  turno_diurno BOOLEAN NOT NULL DEFAULT true,
  senha VARCHAR(20) NOT NULL,
  cargo INTEGER REFERENCES public.cargos(codigo)
);
ALTER TABLE public.funcionarios
  OWNER TO restaurante;


CREATE TABLE public.fornecedores(
  cnpj VARCHAR(14) PRIMARY KEY,
  telefone VARCHAR(12),
  endereco VARCHAR(50),
  email VARCHAR(30)
);
ALTER TABLE public.fornecedores
  OWNER TO restaurante


CREATE TABLE public.mesas(
  codigo SERIAL PRIMARY KEY,
  andar INTEGER NOT NULL,
  ocupada BOOLEAN NOT NULL DEFAULT false,
  cpf_ocupante VARCHAR(11) DEFAULT null REFERENCES public.clientes(cpf)
);
ALTER TABLE public.mesas
  OWNER TO restaurante;


CREATE TABLE public.ingredientes(
  codigo SERIAL PRIMARY KEY,
  nome VARCHAR(50) NOT NULL,
  qtd_estoque INTEGER NOT NULL DEFAULT 0
);
ALTER TABLE public.ingredientes
  OWNER TO restaurante;


CREATE TABLE public.pedidos(
  codigo SERIAL PRIMARY KEY,
  codigo_mesa INTEGER NOT NULL REFERENCES public.mesas(codigo),
  cpf_cliente VARCHAR(11) NOT NULL REFERENCES public.clientes(cpf),
  cpf_garcom VARCHAR(11) NOT NULL REFERENCES public.funcionarios(cpf),
  lista_produtos INTEGER[],
  qtd_produtos INTEGER[],
  preco_total NUMERIC NOT NULL DEFAULT 0.0,
  pedido_pronto BOOLEAN DEFAULT false,
  pedido_pago BOOLEAN DEFAULT false
);
ALTER TABLE public.pedidos
  OWNER TO restaurante;

CREATE TABLE public.pagamentos(
  codigo SERIAL PRIMARY KEY,
  codigo_pedido INTEGER NOT NULL REFERENCES public.pedidos(codigo),
  valor NUMERIC NOT NULL DEFAULT 0.0,
);
ALTER TABLE public.pagamentos
  OWNER TO restaurante;


CREATE TABLE public.produtos(
  codigo SERIAL PRIMARY KEY,
  nome VARCHAR(50) NOT NULL,
  preco NUMERIC NOT NULL DEFAULT 0.0,
  lista_ingredientes INTEGER[],
  qtd_ingredientes INTEGER[]
);
ALTER TABLE public.produtos
  OWNER TO restaurante;