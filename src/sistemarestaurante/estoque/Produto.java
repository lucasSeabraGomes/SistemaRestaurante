package sistemarestaurante.estoque;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sistemarestaurante.ferramentas.ConnectionFactory;

public class Produto{
    private int codigo;
    private String nome;
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
    public void registraPedido() throws SQLException{
        insereBanco();

        for(int i = 0; i < listaIngredientes.size(); i++){
            Ingrediente.diminuiQtdEstoque(listaIngredientes.get(i), qtdCadaIngrediente.get(i));
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
    // Varial  nome
    public String getNome() {
		return nome;
	}
    public void setNome(String nome) {
		this.nome = nome;
    }
    
    public ArrayList<Integer> getListaIngredientes() {
        return listaIngredientes;
    }
    public ArrayList<Integer> getQtdCadaIngrediente() {
        return qtdCadaIngrediente;
    }
}