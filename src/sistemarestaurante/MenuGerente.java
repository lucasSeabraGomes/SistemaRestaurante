package sistemarestaurante;

import java.util.*;

public class MenuGerente {
    public static void menuPrincipal(String cpfUsuario) {
        Scanner input = new Scanner(System.in);
        int opcao;

        System.out.println("[1] Listar funcionarios.");
        System.out.println("[2] Listar cardapio.");
        System.out.println("[3] Listar estoque.");
        System.out.println("[4] Listar fornecedores.");
        System.out.println("[5] Contratar funcionario.");
        System.out.println("[6] Pagar funcionario.");
        System.out.println("[7] Consultar produtividade garcom.");
        System.out.println("[8] Demitir funcionario.");
        System.out.println("[9] Cadastrar novo produto no cardapio.");
        System.out.println("[10] Remover produto do cardapio.");
        System.out.println("[11] Repor estoque.");
        System.out.println("[12] Consultar receitas.");
        System.out.println("[13] Consultar despesas estoque.");
        System.out.println("[14] Consultar despesas funcionarios.");
        System.out.println("[15] Consultar balanco.");
        System.out.println("[16] Listar preferencias de clientes.");
        System.out.println("[0] Sair.");
        System.out.println();

        System.out.print("Digite a opção desejada: ");
        opcao = Integer.parseInt(input.nextLine());

        while(opcao!=0){
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
                    
                case 4:
                    //Chamada de método
                    break;
                    
                case 5:
                    //Chamada de método
                    break;

                case 6:
                    //Chamada de método
                    break;

                case 7:
                    //Chamada de método
                    break;
                
                case 8:
                    //Chamada de método
                    break;
                    
                case 9:
                    //Chamada de método
                    break;
                    
                case 10:
                    //Chamada de método
                    break;

                case 11:
                    //Chamada de método
                    break;

                case 12:
                    //Chamada de método
                    break;
                
                case 13:
                    //Chamada de método
                    break;
                    
                case 14:
                    //Chamada de método
                    break;
                    
                case 15:
                    //Chamada de método
                    break;

                case 16:
                    //Chamada de método
                    break;

                case 0:
                    return;
                
                default:
                    System.out.println("Opcao invalida!");
            }
        //input.close();
        }
    }


    public static void listaFuncionarios() {
        Scanner input = new Scanner(System.in);

        System.out.println("");
    }

    
    public static void listaCardapio() {
        Scanner input = new Scanner(System.in);

        System.out.println("");
    }

    
    public static void listaEstoque() {
        Scanner input = new Scanner(System.in);

        System.out.println("");
    }

    
    public static void listaFornecedores() {
        Scanner input = new Scanner(System.in);

        System.out.println("");
    }

    
    public static void contrataFuncionario() {
        Scanner input = new Scanner(System.in);

        System.out.println("");
    }

    
    public static void pagaFuncionario() {
        Scanner input = new Scanner(System.in);

        System.out.println("");
    }

    
    public static void consultaProdutividade() {
        Scanner input = new Scanner(System.in);

        System.out.println("");
    }

    
    public static void demiteFuncionario() {
        Scanner input = new Scanner(System.in);

        System.out.println("");
    }

    
    public static void cadastraProduto() {
        Scanner input = new Scanner(System.in);

        System.out.println("");
    }

    
    public static void removeProduto() {
        Scanner input = new Scanner(System.in);

        System.out.println("");
    }

    
    public static void compraEstoque() {
        Scanner input = new Scanner(System.in);

        System.out.println("");
    }

    
    public static void consultaReceitas() {
        Scanner input = new Scanner(System.in);

        System.out.println("");
    }

    
    public static void consultaDespesaEstq() {
        Scanner input = new Scanner(System.in);

        System.out.println("");
    }

    
    public static void consultaDespesaRh() {
        Scanner input = new Scanner(System.in);

        System.out.println("");
    }

    
    public static void consultaBalanco() {
        Scanner input = new Scanner(System.in);

        System.out.println("");
    }

    public static void listarPreferencias() {
        Scanner input = new Scanner(System.in);

        System.out.println("");
    }
}