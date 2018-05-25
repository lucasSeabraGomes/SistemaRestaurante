package sistemarestaurante.estoque;

public class Ingrediente{
    private int codigo;
    private String nome;
    private int qtdEstoque;
    

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