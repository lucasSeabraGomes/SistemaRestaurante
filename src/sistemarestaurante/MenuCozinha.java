package sistemarestaurante;

import java.util.Scanner;

public class MenuCozinha {
    public static void menuPrincipal(String cpfUsuario) {
        Scanner input = new Scanner(System.in);
        int opcao = -1;

        while(opcao != 0){
            System.out.println("[1] Consultar pedidos pendentes.");
            System.out.println("[2] Registrar pedido pronto.");
            System.out.println("[3] Consultar estoque.");
            System.out.println("[0] Sair.");
            System.out.println();
    
            System.out.print("Digite a opção desejada: ");
            opcao = Integer.parseInt(input.nextLine());

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
                    return;
                
                default:
                    System.out.println("Opcao invalida!");
            }
        }
        //input.close();
    }


    public static void consultaPendentes() {
        System.out.println("Opcao nao implementada!");
    }


    public static void registraPreparo() {
        System.out.println("Opcao nao implementada!");
    }


    public static void consultaEstoque() {
        System.out.println("Opcao nao implementada!");
    }
}