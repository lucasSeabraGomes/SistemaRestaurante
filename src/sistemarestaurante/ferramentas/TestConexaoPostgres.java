//package sistemarestaurante.ferramentas;
//import ConexaoPostgres.*;

public class TestConexaoPostgres {
    public static void main(String[] args) {
        ConexaoPostgres pg = new ConexaoPostgres("127.0.0.1", "5432","restaurante", 
                                                            "restaurante", "senhapg");
        String query = "SELECT * FROM pessoas;";
        
        pg.conectar();
        pg.query(query);
        pg.desconectar();
    }
}
