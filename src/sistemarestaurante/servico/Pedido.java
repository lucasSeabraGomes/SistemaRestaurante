package sistemarestaurante.servico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sistemarestaurante.estoque.Produto;
import sistemarestaurante.ferramentas.ConnectionFactory;

public class Pedido{
    private int codigo;
    private int codigoMesa;
    private String cpfCliente;
    private String cpfGarcom;
    private ArrayList<Integer> produtosPedidos = new ArrayList<Integer>();
    private ArrayList<Integer> qtdProdutosPedidos = new ArrayList<Integer>();
    private double precoTotal;
    private boolean pedidoPronto;
    private boolean pedidoPago;

    public Pedido(){
        precoTotal = 0.0;
    }
    
    /**
     * Método para adicionar produto ao pedido da mesa
     */
    public void addItemPedido(int codigoProduto, int quantidade) throws SQLException {
        if(Produto.verificaPossuiEstoque(codigoProduto, quantidade)){
            produtosPedidos.add(codigoProduto);
            qtdProdutosPedidos.add(quantidade);
            precoTotal = precoTotal + (Produto.buscaPreco(codigoProduto) * quantidade);
        }
        else{
            System.out.printf("Nao ha estoque para o produto %s!", Produto.buscaNome(codigoProduto));
        }
	}

	/**
     * Métodos de classe
     */
    public static void marcaPedidoPronto(int codigo) throws SQLException{
		Connection con = new ConnectionFactory().getConexao();
        String query = "UPDATE pedidos SET pedido_pronto = true " +
                            "WHERE codigo = ?;";
        PreparedStatement stmt = con.prepareStatement(query);
        
        stmt.setInt(1, codigo);

        try {
            stmt.executeUpdate();
        }
        catch(SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            stmt.close();
            con.close();
        }
    }
    
    public static void marcaPedidoPago(int codigo) throws SQLException{
		Connection con = new ConnectionFactory().getConexao();
        String query = "UPDATE pedidos SET pedido_pago = true " +
                            "WHERE codigo = ?;";
        PreparedStatement stmt = con.prepareStatement(query);
        
        stmt.setInt(1, codigo);

        try {
            stmt.executeUpdate();
        }
        catch(SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            stmt.close();
            con.close();
        }
	}
    
	/**
     * Métodos de acesso ao banco de dados
     */
    public void insereBanco() throws SQLException {
        Connection con = new ConnectionFactory().getConexao();
        String query = "INSERT INTO pedidos " +
                            "(cod_mesa, cpf_cliente, cpf_garcom, lista_produtos, qtd_produtos, preco_total) " +
                            "VALUES(?, ?, ?, ?, ?, ?);";
        PreparedStatement stmt = con.prepareStatement(query);
        
        stmt.setInt(1, codigoMesa);
        stmt.setString(2, cpfCliente);
        stmt.setString(3, cpfGarcom);
        stmt.setArray(4, con.createArrayOf("integer", produtosPedidos.toArray()));
        stmt.setArray(5, con.createArrayOf("integer", qtdProdutosPedidos.toArray()));
        stmt.setDouble(6, precoTotal);

        try {
            stmt.executeUpdate();
        }
        catch(SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            stmt.close();
            con.close();
        }
    }


    public static double buscaConta(int codigo) throws SQLException{
        Connection con = new ConnectionFactory().getConexao();
        String sql = "SELECT preco_total FROM pedidos WHERE codigo = ?;";
        PreparedStatement stmt = con.prepareStatement(sql);
        double conta = 0.0;

        stmt.setInt(1, codigo);

        try {
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                conta = rs.getDouble("preco_total");
            }
        }
        catch(SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            stmt.close();
            con.close();
        }
        return conta;
    }

    
    /**
     * GET's e SET's das variaveis de classe
     */

	// Variavel codigo
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

    // Variavel codigoMesa
	public int getCodigoMesa() {
		return codigoMesa;
	}
	public void setCodigoMesa(int codigoMesa) {
		this.codigoMesa = codigoMesa;
    }
    
    // Variavel cpfCliente
	public String getCpfCliente() {
		return cpfCliente;
	}
	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}
    
	// Variavel cpfGarcom
	public String getCpfGarcom() {
		return cpfGarcom;
	}
	public void setCpfGarcom(String cpfGarcom) {
		this.cpfGarcom = cpfGarcom;
	}
    
    //Variavel produtosPedidos
	public ArrayList<Integer> getProdutosPedidos() {
		return produtosPedidos;
	}

    //Variavel qtdProdutosPedidos
	public ArrayList<Integer> getQtdProdutosPedidos() {
		return qtdProdutosPedidos;
    }
    
    // Variavel precoTotal
	public double getPrecoTotal() {
		return precoTotal;
	}

	// Variavel pedidoPronto
	public boolean isPedidoPronto() {
		return pedidoPronto;
	}
	public void setPedidoPronto(boolean pedidoPronto) {
		this.pedidoPronto = pedidoPronto;
	}

	// Variavel pedidoPago
	public boolean isPedidoPago() {
		return pedidoPago;
	}
    public void setPedidoPago(boolean pedidoPago) {
		this.pedidoPago = pedidoPago;
	}
}