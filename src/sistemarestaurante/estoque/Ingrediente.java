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
        String sql = "SELECT codigo, nome, qtd_estoque FROM ingredientes;";
        PreparedStatement stmt = con.prepareStatement(sql);

        try {
            ResultSet rs = stmt.executeQuery();

            System.out.printf("\n\n|Codigo\t- Nome\t- Quantidade em estoque| \n");

            while(rs.next()){
                int codigo = rs.getInt("codigo");
                String nome = rs.getString("nome");
                int qtdEstoque = rs.getInt("qtd_estoque");

                System.out.printf("|%d\t- %s\t- %d|\n", codigo, nome, qtdEstoque);
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


    public static int checaEstoque(int codigo) throws SQLException{
        Connection con = new ConnectionFactory().getConexao();
        String sql = "SELECT qtd_estoque FROM ingredientes WHERE codigo = ?;";
        PreparedStatement stmt = con.prepareStatement(sql);
        int qtdEstoque = -1;

        stmt.setInt(1, codigo);

        try {
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                qtdEstoque = rs.getInt("qtd_estoque");
            }

        }
        catch(SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            stmt.close();
            con.close();
        }
        return qtdEstoque;
    }

	/**
     * Métodos de acesso ao banco de dados
     */
	public void insereBanco() throws SQLException {
        Connection con = new ConnectionFactory().getConexao();
        String sql = "INSERT INTO ingredientes " +
                            "(nome, qtd_estoque) " +
                            "VALUES(?,?);";
        PreparedStatement stmt = con.prepareStatement(sql);
        
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
        String sql = "UPDATE ingredientes SET qtd_estoque = qtd_estoque + ? " +
                            "WHERE codigo = ?;";
        PreparedStatement stmt = con.prepareStatement(sql);
        
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
        String sql = "UPDATE ingredientes SET qtd_estoque = qtd_estoque - ? " +
                            "WHERE codigo = ?;";
        PreparedStatement stmt = con.prepareStatement(sql);
        
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