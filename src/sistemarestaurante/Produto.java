package sistemarestaurante;

/**
 *
 * @author lucas seabra
 */
public class Produto {
    private int identificadorNoCardapio;
    private String Nome;
    private int[][]ingredientesNecessarios;

    /**
     * @return the identificadorNoCardapio
     */
    public int getIdentificadorNoCardapio() {
        return identificadorNoCardapio;
    }

    /**
     * @param identificadorNoCardapio the identificadorNoCardapio to set
     */
    public void setIdentificadorNoCardapio(int identificadorNoCardapio) {
        this.identificadorNoCardapio = identificadorNoCardapio;
    }

    /**
     * @return the Nome
     */
    public String getNome() {
        return Nome;
    }

    /**
     * @param Nome the Nome to set
     */
    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    /**
     * @return the ingredientesNecessarios
     */
    public int[][] getIngredientesNecessarios() {
        return ingredientesNecessarios;
    }

    /**
     * @param ingredientesNecessarios é uma matriz de indices [x][2]onde x pode ser qualquer numero natural
     * e o indice[a][1]deve ser sempre o numero identificador e um ingrediente enquanto[a][2]deve sempre ser a quantia 
     * deste mesmo ingrediente nescessaria na receita.
     */
    public void setIngredientesNecessarios(int[][] ingredientesNecessarios) {
        this.ingredientesNecessarios = ingredientesNecessarios;
    }
}
