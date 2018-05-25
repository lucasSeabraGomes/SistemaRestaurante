package sistemarestaurante.servico;

public class Mesa{
    private int codigo;
    private String cpfCliente;
    private double conta;

    public Mesa(){
        conta = 0.0;
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

	// Variavel cpfCliente
	public String getCpfCliente() {
		return cpfCliente;
	}
	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	// Variavel conta
	public double getConta() {
		return conta;
	}
	public void setConta(double conta) {
		this.conta = conta;
	}
    

}