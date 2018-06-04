package sistemarestaurante.servico;

 import java.io.*;
import sistemarestaurante.estoque.produto.java
public class Pagamento {
    private int codigoDosProdutosPedidos[];
    private int quantiaDeProdutos[];
    private String mensagem;
    private int CodigoDaMesa;
    private String cpfGarcom;
    void CriarNotaEmTxt()throws IOException
    {
        Produto este=new Produto();
        float resultado=0;
        File file = new File( "c:\\NotaFiscal.txt" );
        if(file.exists())
        {
        // apaga o arquivo caso ja exista evitando erros na nota uma vez que ela não sera armazenada.
             file.delete();
        }
        String nomesProdutos[]=new String[this.codigoDosProdutosPedidos.length];
         FileWriter arq = new FileWriter("c:\\NotaFiscal.txt");
         PrintWriter gravarArq = new PrintWriter(arq);
         for(i=0;i<this.codigoDosProdutosPedidos.length)
         {
             gravarArq.printf("%dx%s=%f\n",this.quantiaDeProdutos[i],este.buscaNome(this.codigoDosProdutosPedidos[i]),this.quantiaDeProdutos[i]*este.buscaPreco(this.codigoDosProdutosPedidos[i]));
             rusultado=,this.quantiaDeProdutos[i]*este.buscaPreco(this.codigoDosProdutosPedidos[i]);
         }
         gravarArq.printf("total:%f",resultado);
         gravarArq.printf("%s",this.mensagem);
         arq.close();
    };
    /**
     * @return the codigoDosProdutosPedidos
     */
    public int[] getCodigoDosProdutosPedidos() {
        return codigoDosProdutosPedidos;
    }

    /**
     * @param codigoDosProdutosPedidos the codigoDosProdutosPedidos to set
     */
    public void setCodigoDosProdutosPedidos(int[] codigoDosProdutosPedidos) {
        this.codigoDosProdutosPedidos = codigoDosProdutosPedidos;
    }

    /**
     * @return the mensagem
     */
    public String getMensagem() {
        return mensagem;
    }

    /**
     * @param mensagem the mensagem to set
     */
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    /**
     * @return the CodigoDaMesa
     */
    public int getCodigoDaMesa() {
        return CodigoDaMesa;
    }

    /**
     * @param CodigoDaMesa the CodigoDaMesa to set
     */
    public void setCodigoDaMesa(int CodigoDaMesa) {
        this.CodigoDaMesa = CodigoDaMesa;
    }

    /**
     * @return the cpfGarçom
     */
    public String getCpfGarcom() {
        return cpfGarcom;
    }

    /**
     * @param cpfGarcom the cpfGarçom to set
     */
    public void setCpfGarcom(String cpfGarcom) {
        this.cpfGarcom = cpfGarcom;
    }

    /**
     * @return the quantiaDeProdutos
     */
    public int[] getQuantiaDeProdutos() {
        return quantiaDeProdutos;
    }

    /**
     * @param quantiaDeProdutos the quantiaDeProdutos to set
     */
    public void setQuantiaDeProdutos(int[] quantiaDeProdutos) {
        this.quantiaDeProdutos = quantiaDeProdutos;
    }
}
