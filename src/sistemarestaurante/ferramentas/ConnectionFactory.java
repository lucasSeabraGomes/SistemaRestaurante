package sistemarestaurante.ferramentas;
import java.sql.*;

public class ConnectionFactory{
    public Connection getConexao() {
        try{
            Class.forName("org.postgresql.Driver");
            
            return DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/restaurante",
                                                "restaurante", "senhapg");
        }
        //catch(SQLException e){
        //    throw new RuntimeException(e);
        //}
        catch(Exception e){
            System.err.println(e);
			e.printStackTrace();
        }
		return null;
    }
}
