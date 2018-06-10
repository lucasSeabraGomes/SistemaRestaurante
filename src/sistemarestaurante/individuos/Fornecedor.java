/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemarestaurante.individuos;
import sistemarestaurante.estoque.Ingrediente;
import java.util.Scanner;//Import da classe Scanner
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sistemarestaurante.ferramentas.ConnectionFactory;
/**
 *
 * @author lucas seabra
 */
public class Fornecedor {
    private String cnpj;
    private String nomeFornecedor;
    private String enderecoFornecedor;
    private String emailFornecedor;
    private String telefoneFornecedor;
    private int[][]quantidadeDisponivelDeIngredientes;
    private float[]precoDosIngredientes;
    //metodo para colocar cadastrar novo fornecedor no banco
     public void insereBanco() throws SQLException {
        Connection con = new ConnectionFactory().getConexao();
        String query = "INSERT INTO fornecedores " +
                            "(cnpj, telefone, endereco,email) " +
                            "VALUES(?,?,?,?);";
        PreparedStatement stmt = con.prepareStatement(query);
        
        stmt.setString(1, cnpj);
        stmt.setString(2,telefoneFornecedor);
        stmt.setString(3,  enderecoFornecedor);
        stmt.setString(4, emailFornecedor);

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
    //metodo que mostra todos os fornecedores
    public static void imprimeFornecedores() throws SQLException{
        Connection con = new ConnectionFactory().getConexao();
        String query = "SELECT cnpj, telefone, endereco,email FROM fornecedores;";
        PreparedStatement stmt = con.prepareStatement(query);
        System.out.printf("Fornecedores cadastrados:\n");
        try {
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String cnpj= rs.getString("cnpj");
                String telefone= rs.getString("telefone");
                String endereco= rs.getString("endereco");
                 String email= rs.getString("email");
;

                System.out.printf("cnpj:%s  telefone:%s   endereco:%s  email:%s\n", cnpj, telefone, endereco,email);
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
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the endereco
     */
    public String getEnderecoFornecedor() {
        return enderecoFornecedor;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEnderecoFornecedor(String endereco) {
        this.enderecoFornecedor = endereco;
    }

    /**
     * @return the email
     */
    public String getEmailFornecedor() {
        return this.emailFornecedor;
    }

    /**
     * @param email the email to set
     */
    public void setEmailFornecedor(String email) {
        this.emailFornecedor = email;
    }

    /**
     * @return the telefone
     */
    public String getTelefoneFornecedor() {
        return this.telefoneFornecedor;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefoneFornecedor(String telefone) {
        this.telefoneFornecedor = telefone;
    }

    /**
     * @return the quantidadeDisponivelDeIngredientes
     */
    public int[][] getQuantidadeDisponivelDeIngredientes() {
        return quantidadeDisponivelDeIngredientes;
    }

    /**
     * @param quantidadeDisponivelDeIngredientes the quantidadeDisponivelDeIngredientes to set
     */
    public void setQuantidadeDisponivelDeIngredientes(int[][] quantidadeDisponivelDeIngredientes) {
        this.quantidadeDisponivelDeIngredientes = quantidadeDisponivelDeIngredientes;
    }

    /**
     * @return the precoDosIngredientes
     */
    public float[] getPrecoDosIngredientes() {//correção do tipo da matriz de int para float
        return precoDosIngredientes;
    }

    /**
     * @param precoDosIngredientes the precoDosIngredientes to set
     */
    public void setPrecoDosIngredientes(float[] precoDosIngredientes) {//correção do tipo da matriz de int para float
        this.precoDosIngredientes = precoDosIngredientes;
    }
    public void verificaDisponibilidadeEPreco(Ingrediente[]estes)
    {
        int i;
        this.quantidadeDisponivelDeIngredientes=new int[estes.length][2];
        Scanner input = new Scanner(System.in);//Criação do objeto Scanner fora do loop para não criar o Scanner várias vezes
        for(i=0;i<estes.length;i++)
        {
            this.quantidadeDisponivelDeIngredientes[i][1]=estes[i].getCodigo();//Correção do nome da função
            System.out.printf("digite a quantidade disponivel de:%s no fornecedor %s\n",estes[i].getNome(),this.nomeFornecedor);
            this.quantidadeDisponivelDeIngredientes[i][2] = input.nextInt();
            System.out.printf("digite o preço de:%s no fornecedor %s\n",estes[i].getNome(),this.nomeFornecedor);
            precoDosIngredientes[i]=input.nextFloat();//Correção do nome da variável referetne aos preços
        }
        input.close();//Fechando o Scanner para evitar "resource leak"
    }
}
