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
  nome VARCHAR(50) NOT null,
  rg VARCHAR(20),
  data_nascimento DATE,
  filiacao_pai VARCHAR(50),
  filiacao_mae VARCHAR(50),
  naturalidade VARCHAR(20),
  estado_civil VARCHAR(12),
  sexo_masculino BOOLEAN NOT null,
  telefone VARCHAR(12),
  email VARCHAR(30),
  endereco VARCHAR(50),
  escolaridade VARCHAR(20),
  profissao VARCHAR(20),
  pedidos_frequentes INTEGER[]
);
ALTER TABLE public.clientes
  OWNER TO restaurante;


CREATE TABLE public.cargos(
  codigo INTEGER PRIMARY KEY,
  nome VARCHAR(20) NOT null
);
ALTER TABLE public.cargos
  OWNER TO restaurante;


CREATE TABLE public.funcionarios(
  cpf VARCHAR(11) PRIMARY KEY,
  nome VARCHAR(50) NOT null,
  rg VARCHAR(20),
  data_nascimento DATE,
  filiacao_pai VARCHAR(50),
  filiacao_mae VARCHAR(50),
  naturalidade VARCHAR(20),
  estado_civil VARCHAR(12),
  sexo_masculino BOOLEAN NOT null,
  telefone VARCHAR(12),
  email VARCHAR(30),
  endereco VARCHAR(50),
  escolaridade VARCHAR(20),
  ctps VARCHAR(20) NOT null,
  salario NUMERIC NOT null DEFAULT 0.0,
  turno_diurno BOOLEAN NOT null DEFAULT true,
  senha VARCHAR(20) NOT null,
  cargo INTEGER REFERENCES public.cargos(codigo)
);
ALTER TABLE public.funcionarios
  OWNER TO restaurante;


CREATE TABLE public.fornecedores(
  codigo SERIAL,
  cnpj VARCHAR(14) PRIMARY KEY,
  telefone VARCHAR(12),
  endereco VARCHAR(50),
  email VARCHAR(30)
);
ALTER TABLE public.fornecedores
  OWNER TO restaurante;


CREATE TABLE public.mesas(
  codigo SERIAL PRIMARY KEY,
  andar INTEGER NOT null,
  ocupada BOOLEAN NOT null DEFAULT false,
  cpf_ocupante VARCHAR(11) DEFAULT null
);
ALTER TABLE public.mesas
  OWNER TO restaurante;


CREATE TABLE public.ingredientes(
  codigo SERIAL PRIMARY KEY,
  nome VARCHAR(50) NOT null,
  qtd_estoque INTEGER NOT null DEFAULT 0
);
ALTER TABLE public.ingredientes
  OWNER TO restaurante;


CREATE TABLE public.pedidos(
  codigo SERIAL PRIMARY KEY,
  cod_mesa INTEGER NOT null REFERENCES public.mesas(codigo),
  cpf_cliente VARCHAR(11) NOT null REFERENCES public.clientes(cpf),
  cpf_garcom VARCHAR(11) NOT null REFERENCES public.funcionarios(cpf),
  lista_produtos INTEGER[],
  qtd_produtos INTEGER[],
  preco_total NUMERIC NOT null DEFAULT 0.0,
  pedido_pronto BOOLEAN DEFAULT false,
  pedido_pago BOOLEAN DEFAULT false
);
ALTER TABLE public.pedidos
  OWNER TO restaurante;


CREATE TABLE public.pagamentos(
  codigo SERIAL PRIMARY KEY,
  cod_pedido INTEGER NOT null REFERENCES public.pedidos(codigo),
  data DATE NOT null,
  valor NUMERIC NOT null DEFAULT 0.0
);
ALTER TABLE public.pagamentos
  OWNER TO restaurante;


CREATE TABLE public.produtos(
  codigo SERIAL PRIMARY KEY,
  nome VARCHAR(50) NOT null,
  preco NUMERIC NOT null DEFAULT 0.0,
  lista_ingredientes INTEGER[],
  qtd_ingredientes INTEGER[]
);
ALTER TABLE public.produtos
  OWNER TO restaurante;


CREATE TABLE public.custos_rh(
  codigo SERIAL PRIMARY KEY,
  data DATE NOT null,
  cod_funcionario VARCHAR(11) REFERENCES public.funcionarios(cpf),
  salario NUMERIC NOT null
);
ALTER TABLE public.custos_rh
  OWNER TO restaurante;


CREATE TABLE public.custos_estoque(
  codigo SERIAL PRIMARY KEY,
  data DATE NOT null,
  cod_ingrediente INTEGER REFERENCES public.ingredientes(codigo),
  quantidade INTEGER NOT null,
  valor_total NUMERIC NOT null
);
ALTER TABLE public.custos_estoque
  OWNER TO restaurante;







-- DROP TABLE cargos, clientes, custos_estoque, custos_rh, fornecedores, funcionarios, ingredientes, mesas, pagamentos, pedidos, produtos;