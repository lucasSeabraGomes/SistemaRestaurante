package sistemarestaurante.administrativo;

import java.util.Date;

public class CustoEstoque {
    private int codigo;
    private String cnpjFornedor;
    private int codigoIngrediente;
    private Date data;
    private int qtdIngredientes;
    private double precoUnitario;
    
    // Variavel codigo
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

    // Variavel cnpjFornedor
	public String getCnpjFornedor() {
		return cnpjFornedor;
	}
	public void setCnpjFornedor(String cnpjFornedor) {
		this.cnpjFornedor = cnpjFornedor;
	}

    // Variavel data
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
    }

    // Variavel codigoIngrediente
	public int getCodigoIngrediente() {
		return codigoIngrediente;
	}
	public void setCodigoIngrediente(int codigoIngrediente) {
		this.codigoIngrediente = codigoIngrediente;
	}
    
	// Variavel qtdIngredientes
	public int getQtdIngredientes() {
		return qtdIngredientes;
	}
	public void setQtdIngredientes(int qtdIngredientes) {
		this.qtdIngredientes = qtdIngredientes;
	}

    // Variavel precoUnitario
	public double getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
}