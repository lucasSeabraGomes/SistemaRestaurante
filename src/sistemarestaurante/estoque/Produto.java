package sistemarestaurante.estoque;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sistemarestaurante.ferramentas.ConnectionFactory;

public class Produto{
    private int codigo;
    private String nome;
    private float preco;
    private ArrayList<Integer> listaIngredientes = new ArrayList<Integer>();
    private ArrayList<Integer> qtdCadaIngrediente = new ArrayList<Integer>();
    
    /**
     * Métodos anexação dos itens da lista de ingredientes
     */
    public void addInfoIngredientes(int codigoIngrediente, int quantidade){
        listaIngredientes.add(codigoIngrediente);
        qtdCadaIngrediente.add(quantidade);
    }

    /**
     * Métodos de classe
     */
    public static void consomeProdutoEstoque(int codigo) throws SQLException{
        Connection con = new ConnectionFactory().getConexao();
        String sql = "SELECT * FROM produtos WHERE codigo = ?;";
        PreparedStatement stmt = con.prepareStatement(sql);

        stmt.setInt(1, codigo);

        try {
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                Array a = rs.getArray("lista_ingredientes");
                Integer[] codigoIngrediente = (Integer[]) a.getArray();
                Array b = rs.getArray("qtd_ingredientes");
                Integer[] qtdIngrediente = (Integer[]) b.getArray();
                
                for(int i = 0; i < codigoIngrediente.length; i++){
                    Ingrediente.diminuiQtdEstoque(codigoIngrediente[i], qtdIngrediente[i]);
                }
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

    public static void imprimeProdutos() throws SQLException{
        Connection con = new ConnectionFactory().getConexao();
        String query = "SELECT * FROM produtos;";
        PreparedStatement stmt = con.prepareStatement(query);

        try {
            ResultSet rs = stmt.executeQuery();

            System.out.printf("\n\nCodigo\t|Nome\t\t\n");

            while(rs.next()){
                int codigo = rs.getInt("codigo");
                String nome = rs.getString("nome");

                System.out.printf("%d\t|%s\t\t\n", codigo, nome);
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

    public static String buscaNome(int codigo) throws SQLException{
        Connection con = new ConnectionFactory().getConexao();
        String query = "SELECT nome FROM produtos WHERE codigo = ?;";
        PreparedStatement stmt = con.prepareStatement(query);
        String nome = null;

        stmt.setInt(1, codigo);

        try {
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                nome = rs.getString("nome");
            }

        }
        catch(SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            stmt.close();
            con.close();
        }
        return nome;
    }

    public static float buscaPreco(int codigo) throws SQLException{
        Connection con = new ConnectionFactory().getConexao();
        String query = "SELECT preco FROM produtos WHERE codigo = ?;";
        PreparedStatement stmt = con.prepareStatement(query);
        float preco = (float) 0.0;

        stmt.setInt(1, codigo);

        try {
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                preco = rs.getFloat("preco");
            }

        }
        catch(SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            stmt.close();
            con.close();
        }
        return preco;
    }

	/**
     * Métodos de acesso ao banco de dados
     */
    public void insereBanco() throws SQLException {
        Connection con = new ConnectionFactory().getConexao();
        String query = "INSERT INTO produtos " +
                            "(nome, lista_ingredientes, qtd_ingredientes) " +
                            "VALUES(?,?,?);";
        PreparedStatement stmt = con.prepareStatement(query);
        
        stmt.setString(1, nome);
        stmt.setArray(2, con.createArrayOf("integer", listaIngredientes.toArray()));
        stmt.setArray(3, con.createArrayOf("integer", listaIngredientes.toArray()));

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
     * GET's e SET's das variveis de classe
     */
	// Variavel codigo
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
    }
    // Variavel  nome
    public String getNome() {
		return nome;
	}
    public void setNome(String nome) {
		this.nome = nome;
    }
    // Variavel preco
    public float getPreco() {
		return preco;
	}
    public void setPreco(float preco) {
		this.preco = preco;
	}
    
    public ArrayList<Integer> getListaIngredientes() {
        return listaIngredientes;
    }
    public ArrayList<Integer> getQtdCadaIngrediente() {
        return qtdCadaIngrediente;
    }

	
}