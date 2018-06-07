package sistemarestaurante.individuos;

import java.util.Date;

public class Pessoa {
    private String cpf;
    private String nome;
    private String rg;
    private Date dataNascimento;
    private String filiacaoPai;
    private String filiacaoMae;
    private String naturalidade;
    private String estadoCivil;
    private boolean sexoMasculino;
    private String telefone;
    private String email;
    private String endereco;
    private String escolaridade;
    private String profissao;
    
    
    /**
     * GET's e SET's das variaveis de classe
     */
    // Variavel cpf
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
    
    // Variavel nome
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
    
    // Variavel rg
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
    
    // Variavel dataNascimento
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
    
    // Variavel filiacaoPai
	public String getFiliacaoPai() {
		return filiacaoPai;
	}
	public void setFiliacaoPai(String filiacaoPai) {
		this.filiacaoPai = filiacaoPai;
	}
    
    // Variavel filiacaoMae
	public String getFiliacaoMae() {
		return filiacaoMae;
	}
	public void setFiliacaoMae(String filiacaoMae) {
		this.filiacaoMae = filiacaoMae;
	}
    
    // Variavel naturalidade
	public String getNaturalidade() {
		return naturalidade;
	}
	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}
    
    // Variavel estadoCivil
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
    
    // Variavel sexoMasculino
	public boolean isSexoMasculino() {
		return sexoMasculino;
	}
	public void setSexoMasculino(boolean sexoMasculino) {
		this.sexoMasculino = sexoMasculino;
	}
    
    // Variavel telefone
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
    
    // Variavel email
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
    
    // Variavel endereco
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
    
    // Variavel escolaridade
	public String getEscolaridade() {
		return escolaridade;
	}
	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}
    
    // Variavel profissao
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
}