/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemarestaurante.individuos;
import sistemarestaurante.estoque.Ingrediente;
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
     * @return the nome
     */
    public String getNomeFornecedor() {
        return this.nomeFornecedor;
    }

    /**
     * @param nome the nome to set
     */
    public void setNomeFornecedor(String nome) {
        this.nomeFornecedor = nome;
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
    public int[] getPrecoDosIngredientes() {
        return precoDosIngredientes;
    }

    /**
     * @param precoDosIngredientes the precoDosIngredientes to set
     */
    public void setPrecoDosIngredientes(int[] precoDosIngredientes) {
        this.precoDosIngredientes = precoDosIngredientes;
    }
    public void verificaDisponibilidadeEPreco(Ingrediente[]estes)
    {
        int i;
        this.quantidadeDisponivelDeIngredientes=new int[estes.length][2];
        for(i=0;i<estes.length;i++)
        {
            Scanner input = new Scanner(System.in);
            this.quantidadeDisponivelDeIngredientes[i][1]=estes[i].getIdentificadorDoIngrediente();
            System.out.printf("digite a quantidade disponivel de:%s no fornecedor %s\n",estes[i].getNomeIngrediente(),this.nomeFornecedor);
            this.quantidadeDisponivelDeIngredientes[i][2] = input.nextInt();
            System.out.printf("digite o preço de:%s no fornecedor %s\n",estes[i].getNomeIngrediente(),this.nomeFornecedor);
            this.precoDosIngredientes[i]=input.nextFloat();
        }
    }
}
