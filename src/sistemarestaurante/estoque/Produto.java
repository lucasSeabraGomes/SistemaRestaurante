package sistemarestaurante.estoque;

import java.util.ArrayList;

public class Produto{
    private int codigo;
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
     * GET's e SET's das variveis de classe
     */
	// Variavel codigo
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
    }
    public ArrayList<Integer> getListaIngredientes() {
        return listaIngredientes;
    }
    public ArrayList<Integer> getQtdCadaIngrediente() {
        return qtdCadaIngrediente;
    }
}