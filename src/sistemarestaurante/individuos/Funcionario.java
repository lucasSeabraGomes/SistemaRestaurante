package sistemarestaurante.individuos;

public class Funcionario extends Pessoa{
    private String carteiraDeTrabalho;
    private String senha;
    private double salario;
    private boolean turnoDiurno;
    private int cargo;//varia de 1 a 4 sendo 1-gerente,2-garçom,3-cozinheiro,4-barman;
    protected void setCarteiraDeTrabalho(String este)
    {
        this.carteiraDeTrabalho=este;
    }
    protected String getCarteiraDeTrabalho()
    {
        return this.carteiraDeTrabalho;
    }
    private void setSenha(String este)
    {
        this.senha=este;
    }
    protected int getCargo()
    {
        return this.cargo;
    }
    private void setCargo(int este)
    {
        this.cargo=este;
    }
    private String getSenha()
    {
        return this.senha;
    }
    protected void setSalario(double este)
    {
        this.salario=este;
    }
    protected double getSalario()
    {
        return this.salario;
    }
    protected void setTurno(boolean este)
    {
        this.turnoDiurno=este;
    }
    protected boolean getTurno()
    {
        return this.turnoDiurno;
    }
}
