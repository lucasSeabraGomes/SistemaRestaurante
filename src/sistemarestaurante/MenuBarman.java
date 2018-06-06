package sistemarestaurante;

import java.util.Scanner;

public class MenuBarman {
    public static void menuPrincipal(String cpfUsuario) {
        public static void menuPrincipal(String cpfUsuario) {
            Scanner input = new Scanner(System.in);
            int opcao;
    
            System.out.println("[1] Consultar pedidos pendentes.");
            System.out.println("[2] Registrar pedido pronto.");
            System.out.println("[3] Consultar estoque.");
            System.out.println("[0] Sair.");
            System.out.println();
    
            System.out.print("Digite a opção desejada: ");
            opcao = Integer.parseInt(input.nextLine());
    
            while(opcao){
                switch(opcao){
                    case 1:
                        //Chamada de método
                        break;
    
                    case 2:
                        //Chamada de método
                        break;
                    
                    case 3:
                        //Chamada de método
                        break;
                        
                    case 0:
                        return
                    
                    default:
                        System.out.println("Opcao invalida!");
                }
            //input.close();
            }
        }
    
    
        public static void consultaPendentes() {
            Scanner input = new Scanner();
    
            System.out.println("")
        }
    
    
        public static void registraPreparo() {
            Scanner input = new Scanner();
    
            System.out.println("")
        }
    
    
        public static void consultaEstoque() {
            Scanner input = new Scanner();
    
            System.out.println("")
        }
    }
}