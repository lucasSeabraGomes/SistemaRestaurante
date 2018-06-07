package sistemarestaurante;

import java.sql.SQLException;
import java.util.Scanner;

import sistemarestaurante.estoque.Ingrediente;
import sistemarestaurante.estoque.Produto;
import sistemarestaurante.individuos.Funcionario;

public class MenuGerente {
    public static void menuPrincipal(String cpfUsuario) {
        Scanner input = new Scanner(System.in);
        int opcao = -1;

        while(opcao != 0){
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
        
        }
        //input.close();
    }


    public static void listaFuncionarios() throws SQLException {
        Funcionario.listaFuncionarios();
    }

    
    public static void listaCardapio() throws SQLException {
        Produto.imprimeProdutos();
    }

    
    public static void listaEstoque() throws SQLException {
        Ingrediente.imprimeEstoque();
    }

    
    public static void listaFornecedores() {
        System.out.println("Opcao nao implementada!");
    }

    
    public static void contrataFuncionario() {
        System.out.println("Opcao nao implementada!");
    }

    
    public static void pagaFuncionario() {
        System.out.println("Opcao nao implementada!");
    }

    
    public static void consultaProdutividade() {
        System.out.println("Opcao nao implementada!");
    }

    
    public static void demiteFuncionario() {
        System.out.println("Opcao nao implementada!");
    }

    
    public static void cadastraProduto() {
        System.out.println("Opcao nao implementada!");
    }

    
    public static void removeProduto() {
        System.out.println("Opcao nao implementada!");
    }

    
    public static void compraEstoque() {
        System.out.println("Opcao nao implementada!");
    }

    
    public static void consultaReceitas() {
        System.out.println("Opcao nao implementada!");
    }

    
    public static void consultaDespesaEstq() {
        System.out.println("Opcao nao implementada!");
    }

    
    public static void consultaDespesaRh() {
        System.out.println("Opcao nao implementada!");
    }

    
    public static void consultaBalanco() {
        System.out.println("Opcao nao implementada!");
    }

    public static void listarPreferencias() {
        System.out.println("Opcao nao implementada!");
    }
}