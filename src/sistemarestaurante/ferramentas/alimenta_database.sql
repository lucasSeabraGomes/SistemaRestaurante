-- Inserção de cargos
INSERT INTO public.cargos
    VALUES  (1, 'Gerente'),
            (2, 'Garcom'),
            (3, 'Cozinheiro'),
            (4, 'Barman');


-- Inserção de funcionarios
INSERT INTO public.funcionarios(cpf, nome, sexo_masculino, ctps, salario, turno_diurno, senha, cargo)
    VALUES  ('12312312312', 'Tiago', true, '478640631', 3000.00, true, 'senha', 1),
            ('45645645645', 'Roberto', true, '478640631', 3000.00, true, 'senha', 2),
            ('78978978978', 'Paulo', true, '478640631', 3000.00, true, 'senha', 3),
            ('15315315315', 'João', true, '478640631', 3000.00, true, 'senha', 4);


-- Inserção de produtos
INSERT INTO public.produtos(nome, preco, lista_ingredientes, qtd_ingredientes)
    VALUES  ('Agua', 2.50, ARRAY[1], ARRAY[1]),
            ('Suco de laranja', 4.90, ARRAY[1,17], ARRAY[1,2]),
            ('Suco de limao', 4.90, ARRAY[1,18], ARRAY[1,4]),
            ('Suco de morango', 4.90, ARRAY[1,19], ARRAY[1,8]),
            ('Suco de uva', 4.90, ARRAY[1,20], ARRAY[1,1]),
            ('Suco de manga', 4.90, ARRAY[1,21], ARRAY[1,1]),
            ('Suco de goiaba', 4.90, ARRAY[1,22], ARRAY[1,2]),
            ('Refrigerante', 3.50, ARRAY[3], ARRAY[1]),
            ('Cerveja', 6.90, ARRAY[4], ARRAY[1]),
            ('Refeição com carne bovina', 19.90, ARRAY[5,6,8,9,10,12,25,26,34], ARRAY[1,1,1,1,1,1,1,1,1]),
            ('Refeição com strogonoff de carne', 21.90, ARRAY[5,6,8,9,10,12,13,15,25,26,34], ARRAY[1,1,1,1,1,1,1,1,1,1,1]),
            ('Refeição com frango', 17.90, ARRAY[5,6,8,9,10,12,25,26,37], ARRAY[1,1,1,1,1,1,1,1,1]),
            ('Refeição com strogonoff frango', 19.90, ARRAY[5,6,8,9,10,12,13,15,25,26,37], ARRAY[1,1,1,1,1,1,1,1,1,1,1]),
            ('Refeição com salmao', 23.90, ARRAY[5,6,8,9,10,12,25,26,40], ARRAY[1,1,1,1,1,1,1,1,1]),
            ('Refeição com atum', 20.90, ARRAY[5,6,8,9,10,12,25,26,38], ARRAY[1,1,1,1,1,1,1,1,1]),
            ('Refeição com carne suina', 18.90, ARRAY[5,6,8,9,10,12,25,26,35], ARRAY[1,1,1,1,1,1,1,1,1]),
            ('Macarronada de atum', 19.90, ARRAY[7,8,9,11,12,13,38], ARRAY[1,1,1,1,1,1,1]),
            ('Macarronada de salmao', 22.90, ARRAY[7,8,9,11,12,13,40], ARRAY[1,1,1,1,1,1,1]),
            ('Macarronada de salsicha', 16.90, ARRAY[7,8,9,11,12,13,32], ARRAY[1,1,1,1,1,1,1]),
            ('Macarronada de peito de peru', 18.90, ARRAY[7,8,9,11,12,13,31], ARRAY[1,1,1,1,1,1,1]),
            ('Hambuguer', 9.90, ARRAY[10,14,25,26,29,30,33,36,41], ARRAY[1,1,1,1,1,1,1,1,1]),
            ('Cachorro quente', 7.90, ARRAY[10,27,28,29,32,41], ARRAY[1,1,1,1,1,1]),
            ('Misto quente', 4.90, ARRAY[29,30,41], ARRAY[1,1,1]),
            ('Sanduiche com peito de peru', 5.90, ARRAY[29,31,41], ARRAY[1,1,1]),
            ('Batata frita', 6.90, ARRAY[10,23], ARRAY[1,1]);


-- Inserção de ingredientes
INSERT INTO public.ingredientes(nome, qtd_estoque) 
    VALUES  ('Agua', 87),
            ('Leite', 25),
            ('Refrigerante', 61),
            ('Cerveja', 32),
            ('Arroz', 92),
            ('Feijão', 76),
            ('Macarrao', 57),
            ('Alho', 150),
            ('Sal', 142),
            ('Oleo de soja', 149),
            ('Azeite de oliva', 65),
            ('Tempero', 212),
            ('Molho de tomate', 107),
            ('Ovos', 96),
            ('Creme de leite', 43),
            ('Leite condensado', 21),
            ('Laranja', 30),
            ('Limao', 28),
            ('Morango', 19),
            ('Uva', 47),
            ('Manga', 39),
            ('Goiaba', 18),
            ('Batata', 79),
            ('Cenoura', 81),
            ('Alface', 49),
            ('Tomate', 54),
            ('Ervilha', 34),
            ('Milho', 41),
            ('Queijo mussarela', 32),
            ('Presunto', 19),
            ('Peito de peru', 37),
            ('Salsicha', 48),
            ('Hamburguer', 84),
            ('Carne bovina', 61),
            ('Carne suina', 36),
            ('Bacon', 49),
            ('Frango', 42),
            ('Atum', 33),
            ('Sardinha', 41),
            ('Salmao', 27),
            ('Pao', 87);


-- Inserção das mesas
INSERT INTO public.mesas(andar)
    VALUES (1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),
            (1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),
            (1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),
            (1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),
            (1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),
            (1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),
            (1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),
            (1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),
            (2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),
            (2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),
            (2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),
            (2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),
            (2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),
            (2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),
            (2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),
            (2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2);
