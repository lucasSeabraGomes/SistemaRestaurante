package sistemarestaurante.servico;

import java.util.ArrayList;

public class Pedido{
    private int codigo;
    private int codigoMesa;
    private String cpfGarcom;
    private ArrayList<Integer> produtosPedidos = new ArrayList<Integer>();
    private ArrayList<Integer> qtdProdutosPedidos = new ArrayList<Integer>();
    private boolean pedidoPronto;
    
    /**
     * Método para adicionar produto ao pedido da mesa
     */
    public void addItemPedido(int codigoProduto, int quantidade){
        produtosPedidos.add(codigoProduto);
        qtdProdutosPedidos.add(quantidade);
    }
    
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

    // Variavel codigoMesa
	public int getCodigoMesa() {
		return codigoMesa;
	}
	public void setCodigoMesa(int codigoMesa) {
		this.codigoMesa = codigoMesa;
	}
    
	// Variavel cpfGarcom
	public String getCpfGarcom() {
		return cpfGarcom;
	}
	public void setCpfGarcom(String cpfGarcom) {
		this.cpfGarcom = cpfGarcom;
	}
    
    //Variavel produtosPedidos
	public ArrayList<Integer> getProdutosPedidos() {
		return produtosPedidos;
	}

    //Variavel qtdProdutosPedidos
	public ArrayList<Integer> getQtdProdutosPedidos() {
		return qtdProdutosPedidos;
	}

	// Variavel pedidoPronto
	public boolean isPedidoPronto() {
		return pedidoPronto;
	}
	public void setPedidoPronto(boolean pedidoPronto) {
		this.pedidoPronto = pedidoPronto;
	}
}