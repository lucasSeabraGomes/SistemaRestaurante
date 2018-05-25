package sistemarestaurante.ferramentas;
import java.sql.*;

/*
*
*/

public class ConexaoPostgres {
    private String local;
    private String porta;
    private String database;
    private String usuario;
    private String senha;
    private Connection postgres;
    private Statement statement;
    private String conexao;
    private String driverjdbc;

    /*
    * Construtor de classe
    */
    public ConexaoPostgres(String local, String porta, String database, String usuario, String senha){
        configDatabase( local, porta, database );
        configUsuario( usuario, senha );
        setDriverjdbc( "org.postgresql.Driver" );
    }

    /*
    * Metodos de configuração da conexão
    */
    public void configUsuario(String usuario, String senha){
        setUsuario( usuario );
        setSenha( senha );
    }

    public void configDatabase(String local, String porta, String database){
        setLocal( local );
        setPorta( porta );
        setDatabase( database );
        setConexao( "jdbc:postgresql://" + local + ":" + porta + "/" + database );
    }

    /*
    * Metodos de uso do banco de dados
    */
    public void conectar(){
		try {
			Class.forName( getDriverjdbc() );
			setPostgres( DriverManager.getConnection( getConexao(), getUsuario(), getSenha() ) );
			setStatment( getPostgres().createStatement() );
        }
        catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		} 
    }
    
    public void desconectar(){
		try {
			getPostgres().close();
        }
        catch (SQLException ex) {
			System.err.println(ex);
			ex.printStackTrace();
		}
    }
    
    public ResultSet execQuery(String query){
		try {
			return getStatment().executeQuery(query);
		}catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	} 

    /*
    * GET's e SET's das variáveis de classe
    */

    //Variavel local
    public String getLocal(){
        return local;
    }
    public void setLocal(String local){
        this.local = local;
    }

    //Variavel porta
    public String getPorta() {
		return porta;
	}
    public void setPorta(String porta) {
		this.porta = porta;
    }

    //Variavel database
    public String getDatabase() {
		return database;
	}
    public void setDatabase(String database) {
		this.database = database;
    }
    
    //Variavel usuario
    public String getUsuario(){
        return usuario;
    }
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }

    //Variavel senha
    public String getSenha(){
        return senha;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }

    //Variavel postgres
    public Connection getPostgres(){
        return postgres;
    }
    public void setPostgres(Connection postgres){
        this.postgres = postgres;
    }

    //Variavel statement
    public Statement getStatment(){
        return statement;
    }
    public void setStatment(Statement statement){
        this.statement = statement;
    }

    //Variavel conexao
    public String getConexao(){
        return conexao;
    }
    public void setConexao(String conexao){
        this.conexao = conexao;
    }

    //Variavel driverjdbc
    public String getDriverjdbc(){
        return driverjdbc;
    }
    public void setDriverjdbc(String driverjdbc){
        this.driverjdbc = driverjdbc;
    }
}