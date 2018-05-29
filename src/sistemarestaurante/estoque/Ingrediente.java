package sistemarestaurante.estoque;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sistemarestaurante.ferramentas.ConnectionFactory;

public class Ingrediente{
    private int codigo;
    private String nome;
	private int qtdEstoque;
	
	/**
     * Construtor de classe
     */
	public Ingrediente(String nome, int qtdEstoque){
		setNome(nome);
		setQtdEstoque(qtdEstoque);
	}
	public Ingrediente(){
		this(null, 0);
    }
    
    /**
     * Métodos de classe
     */
    public static void imprimeEstoque() throws SQLException{
        Connection con = new ConnectionFactory().getConexao();
        String query = "SELECT * FROM ingredientes;";
        PreparedStatement stmt = con.prepareStatement(query);

        try {
            ResultSet rs = stmt.executeQuery();

            System.out.printf("\n\n Codigo\t| Nome\t\t| Quantidade em estoque |\n");

            while(rs.next()){
                int codigo = rs.getInt("codigo");
                String nome = rs.getString("nome");
                int qtdEstoque = rs.getInt("qtd_estoque");

                System.out.printf(" %d\t| %s\t\t| %d\n", codigo, nome, qtdEstoque);
            }

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
        String query = "INSERT INTO ingredientes " +
                            "(nome, qtd_estoque) " +
                            "VALUES(?,?);";
        PreparedStatement stmt = con.prepareStatement(query);
        
        stmt.setString(1, nome);
        stmt.setInt(2, qtdEstoque);

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
	
	public static void aumentaQtdEstoque(int codigo, int qtd) throws SQLException{
		Connection con = new ConnectionFactory().getConexao();
        String query = "UPDATE ingredientes SET qtd_estoque = qtd_estoque + ? " +
                            "WHERE codigo = ?;";
        PreparedStatement stmt = con.prepareStatement(query);
        
        stmt.setInt(1, qtd);
        stmt.setInt(2, codigo);

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

	public static void diminuiQtdEstoque(int codigo, int qtd) throws SQLException{
		Connection con = new ConnectionFactory().getConexao();
        String query = "UPDATE ingredientes SET qtd_estoque = qtd_estoque - ? " +
                            "WHERE codigo = ?;";
        PreparedStatement stmt = con.prepareStatement(query);
        
        stmt.setInt(1, qtd);
        stmt.setInt(2, codigo);

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
     * GET's e SET's das variaveis de classe
     */
    
    // Variavel codigo
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
    
	// Variavel nome
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
    
	// Variavel qtdEstoque
	public int getQtdEstoque() {
		return qtdEstoque;
	}
	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}
}