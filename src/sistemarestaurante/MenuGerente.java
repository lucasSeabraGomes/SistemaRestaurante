package sistemarestaurante;

import java.util.Scanner;

public class MenuGerente {
    public static void menuPrincipal(String cpfUsuario) {
        Scanner input = new Scanner(System.in);
        int opcao;

        System.out.println("[1] Opção 1.");
        System.out.println();

        System.out.print("Digite a opção desejada: ");
        opcao = Integer.parseInt(input.nextLine());

        switch(opcao){
            case 1:
                break;
            
            default:
                System.out.println("Opcao invalida!");
        }
        input.close();
    }
}