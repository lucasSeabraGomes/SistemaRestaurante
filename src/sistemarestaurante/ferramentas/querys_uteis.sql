-- Relaciona produtos, ingredientes e quantidade de ingredientes
SELECT prod.nome AS nome_produto, 
	ingr.nome AS nome_ingrediente, 
	prod.qtd_ingrediente 
FROM 
	(SELECT p.codigo, p.nome, pi.cod_produto, pi.cod_ingrediente, pi.qtd_ingrediente
		FROM produtos AS p 
		INNER JOIN produto_ingrediente AS pi
		ON p.codigo = pi.cod_produto) AS prod
INNER JOIN
	(SELECT i.codigo, i.nome, pi.cod_produto, pi.cod_ingrediente  
		FROM ingredientes AS i 
		INNER JOIN produto_ingrediente AS pi
		ON i.codigo = pi.cod_ingrediente) AS ingr
ON prod.codigo = ingr.cod_produto
AND ingr.codigo = prod.cod_ingrediente
ORDER BY prod.codigo, ingr.codigo;

-- Pedidos prontos
SELECT cod_pedido FROM pedido_produto WHERE cod_pedido 
	NOT IN (SELECT cod_pedido FROM pedido_produto 
			WHERE pronto = false)
GROUP BY cod_pedido;

-- Pedidos prontos por garcom
SELECT p.codigo, p.cod_mesa
FROM pedidos AS p
INNER JOIN (SELECT cod_pedido FROM pedido_produto 
			WHERE cod_pedido 
			NOT IN (SELECT cod_pedido FROM pedido_produto 
					WHERE pronto = false)) AS pronto
ON p.codigo = pronto.cod_pedido
WHERE p.cpf_garcom = '45645645645' AND pedido_pago = false
GROUP BY codigo
ORDER BY codigo;

-- Pedidos pendentes cozinha
SELECT pp.cod_pedido, pr.nome, pp.qtd_produto
FROM produtos AS pr
INNER JOIN
	(SELECT cod_pedido, cod_produto, qtd_produto 
	FROM pedido_produto WHERE pronto = false) AS pp
ON pr.codigo = pp.cod_produto
WHERE bebida = false
ORDER BY pr.codigo;

-- Pedidos pendentes bebibas
SELECT pp.cod_pedido, pr.nome, pp.qtd_produto
FROM produtos AS pr
INNER JOIN
	(SELECT cod_pedido, cod_produto, qtd_produto 
	FROM pedido_produto WHERE pronto = false) AS pp
ON pr.codigo = pp.cod_produto
WHERE bebida = true
ORDER BY pr.codigo;