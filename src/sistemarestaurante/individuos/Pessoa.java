/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemarestaurante.individuos;

/**
 *
 * @author newlo
 */
public class Pessoa {
    private String cpf;
    private String nome;
    private String endereco;
    private String email;
    private String telefone;
    private boolean sexoMasculino;

    //Contrutor de classe
    public Pessoa(String cpf, String nome, String endereco, String email, String telefone, boolean sexoMasculino){
        setCpf(cpf);
        setNome(nome);
        setEndereco(endereco);
        setEmail(email);
        setTelefone(telefone);
        setGenero(sexoMasculino);
    }
    public Pessoa(){
        this(null, null, null, null, null, false);
    }

    /**
     * todos os sets tem a função de definir o que esta a seguir ex setName-define o nome
     * todos os get tema função de pegar o valor do que esta a seguir ex getName- recebe o valor de name
     */
    protected void setCpf(String este)
    {
        this.cpf=este;
    }
    protected String getCpf()
    {
        return this.cpf;
    }
    protected void setNome(String este)
    {
        this.nome=este;
    }
    protected String getNome()
    {
        return this.nome;
    }
    protected void setEndereco(String este)
    {
        this.endereco=este;
    }
    protected String getEndereco()
    {
        return this.endereco;
    }
    protected void setTelefone(String este)
    {
        this.telefone=este;
    }
    protected String getTelefone()
    {
        return this.telefone;
    }
    protected void setEmail(String este)
    {
        this.email=este;
    }
    protected String getEmail()
    {
        return this.email;
    }
    protected void setGenero(boolean este)
    {
        this.sexoMasculino=este;
    }
    protected boolean getGenero()
    {
        return this.sexoMasculino;
    }
}
public class Funcionario extends Pessoa{
    private String carteiraDeTrabalho;
    private String senha;
    private double salario;
    private boolean turnoDiurno;
    protected void setCarteiraDeTrabalho(String este)
    {
        this.carteiraDeTrabalho=este;
    }
    protected String getCarteiraDeTrabalho()
    {
        return this.carteiraDeTrabalho;
    }
    private void setSenha(String senha)
    {
        this.senha=este;
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
