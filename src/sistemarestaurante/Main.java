package sistemarestaurante;

import java.sql.SQLException;

import sistemarestaurante.ferramentas.Login;

public class Main {
    public static void main(String[] args) throws SQLException {
        Login login = new Login();
        int opcao;

        opcao = login.realizaLogin();
        
        switch(opcao){
            case 1:
                MenuGerente.menuPrincipal(login.getCpfUsuario());
                break;
            
            case 2:
                MenuGarcom.menuPrincipal(login.getCpfUsuario());
                break;
            
            case 3:
                MenuBarman.menuPrincipal(login.getCpfUsuario());
                break;
            
            case 4:
                MenuCozinha.menuPrincipal(login.getCpfUsuario());
                break;
            
            default:
                System.out.println("Falha ao logar usuario!");
        }
    }
}