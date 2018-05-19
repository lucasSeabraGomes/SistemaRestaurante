package sistemarestaurante;

/**
 *
 * @author newlo
 */
public class Ingrediente {
    private int identificadorDoIngrediente;
    private String nomeIngrediente;
    private int quantiDisponivelParaUso;

    /**
     * @return the identificadorDoIngrediente
     */
    public int getIdentificadorDoIngrediente() {
        return identificadorDoIngrediente;
    }

    /**
     * @param identificadorDoIngrediente the identificadorDoIngrediente to set
     */
    public void setIdentificadorDoIngrediente(int identificadorDoIngrediente) {
        this.identificadorDoIngrediente = identificadorDoIngrediente;
    }

    /**
     * @return the nomeIngrediente
     */
    public String getNomeIngrediente() {
        return nomeIngrediente;
    }

    /**
     * @param nomeIngrediente the nomeIngrediente to set
     */
    public void setNomeIngrediente(String nomeIngrediente) {
        this.nomeIngrediente = nomeIngrediente;
    }

    /**
     * @return the quantiDisponivelParaUso
     */
    public int getQuantiDisponivelParaUso() {
        return quantiDisponivelParaUso;
    }

    /**
     * @param quantiDisponivelParaUso the quantiDisponivelParaUso to set
     */
    public void setQuantiDisponivelParaUso(int quantiDisponivelParaUso) {
        this.quantiDisponivelParaUso = quantiDisponivelParaUso;
    }
    
}
