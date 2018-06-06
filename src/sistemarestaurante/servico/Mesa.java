package sistemarestaurante.servico;

import sistemarestaurante.servico.Pedido;

public class Mesa{
	private int codigo;
	private int andar;
	private boolean ocupada;
	private String cpfCliente;

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

	// Variavel codigo
	public int getAndar() {
		return andar;
	}
	public void setAndar(int andar) {
		this.andar = andar;
	}

	//Variavel ocupada
	public boolean isOcupada() {
		return ocupada;
	}
	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}

	// Variavel cpfCliente
	public String getCpfCliente() {
		return cpfCliente;
	}
	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}
}