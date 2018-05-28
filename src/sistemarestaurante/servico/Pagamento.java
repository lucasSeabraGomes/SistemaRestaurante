package sistemarestaurante;

public class Pagamento {
    private int codigoDosProdutosPedidos[];
    private String mensagem;
    private int CodigoDaMesa;
    private String cpfGarçom;
    
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
    public String getCpfGarçom() {
        return cpfGarçom;
    }

    /**
     * @param cpfGarçom the cpfGarçom to set
     */
    public void setCpfGarçom(String cpfGarçom) {
        this.cpfGarçom = cpfGarçom;
    }
}
