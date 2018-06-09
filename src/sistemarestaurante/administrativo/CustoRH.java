package sistemarestaurante.administrativo;

import java.util.Date;

public class CustoRH {
    private int codigo;
    private int codigoFuncionario;
    private Date data;
    private double salario;
    
    /**
	 * GET's e SET's
	 */
    // Variavel codigo
     public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

    // Variavel codigoFuncionario
	public int getCodigoFuncionario() {
		return codigoFuncionario;
	}
	public void setCodigoFuncionario(int codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
	}

    // Variavel data
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}

    // Variavel salario
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
}