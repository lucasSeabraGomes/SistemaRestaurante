package sistemarestaurante.menu;

import java.sql.SQLException;
import java.util.Scanner;

import sistemarestaurante.administrativo.CustoEstoque;
import sistemarestaurante.administrativo.CustoRH;
import sistemarestaurante.administrativo.Fornecedor;
import sistemarestaurante.estoque.Ingrediente;
import sistemarestaurante.estoque.Produto;
import sistemarestaurante.individuos.Funcionario;
import sistemarestaurante.servico.Pagamento;

public class Gerente {
    public static void menuPrincipal(String cpfUsuario) throws SQLException {
        Scanner input = new Scanner(System.in);
        int opcao = -1;

        while(opcao != 0){
            System.out.println();
            System.out.println();
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
                    listaFuncionarios();
                    break;

                case 2:
                    listaCardapio();
                    break;
                
                case 3:
                    listaEstoque();
                    break;
                    
                case 4:
                    listaFornecedores();
                    break;
                    
                case 5:
                    contrataFuncionario();
                    break;

                case 6:
                    pagaFuncionario();
                    break;

                case 7:
                    consultaProdutividade();
                    break;
                
                case 8:
                    demiteFuncionario();
                    break;
                    
                case 9:
                    cadastraProduto();
                    break;
                    
                case 10:
                    removeProduto();
                    break;

                case 11:
                    compraEstoque();
                    break;

                case 12:
                    consultaReceitas();
                    break;
                
                case 13:
                    consultaDespesaEstq();
                    break;
                    
                case 14:
                    consultaDespesaRh();
                    break;
                    
                case 15:
                    consultaBalanco();
                    break;

                case 16:
                    listarPreferencias();
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

    
    public static void listaFornecedores() throws SQLException {
        Fornecedor.listaFornecedores();
    }

    //#########################################################################
    public static void contrataFuncionario() {
        System.out.println("Opcao nao implementada!");
    }

    
    public static void pagaFuncionario() throws SQLException {
        Scanner input = new Scanner(System.in);
        String cpfFuncionario;

        System.out.printf("Insira o CPF do funcionario: ");
        cpfFuncionario = input.nextLine();

        CustoRH.insereBanco(cpfFuncionario);

        System.out.printf("\nO salario do funcionario %s, CPF %s, foi pago!\n",
                            Funcionario.buscaNome(cpfFuncionario), cpfFuncionario);

        //input.close();
    }

    //#########################################################################
    public static void consultaProdutividade() {
        System.out.println("Opcao nao implementada!");
    }

    
    public static void demiteFuncionario() throws SQLException {
        Scanner input = new Scanner(System.in);
        String cpfFuncionario;
        String nomeFuncionario;

        System.out.printf("Insira o CPF do funcionario: ");
        cpfFuncionario = input.nextLine();
        nomeFuncionario = Funcionario.buscaNome(cpfFuncionario);

        Funcionario.removeBanco(cpfFuncionario);;

        System.out.printf("\nO funcionario %s, CPF %s, foi demitido!\n",
                            nomeFuncionario, cpfFuncionario);

        //input.close();
    }

    //#########################################################################
    public static void cadastraProduto() {
        System.out.println("Opcao nao implementada!");
    }

    //#########################################################################
    public static void removeProduto() {
        System.out.println("Opcao nao implementada!");
    }

    
    public static void compraEstoque() throws SQLException {
        Scanner input = new Scanner(System.in);
        CustoEstoque custo = new CustoEstoque();

        System.out.printf("Insira o CNPJ do fornecedor: ");
        custo.setCnpjFornedor(input.nextLine());

        System.out.printf("Insira o codigo do ingrediente: ");
        custo.setCodigoIngrediente(Integer.parseInt(input.nextLine()));

        System.out.printf("Insira a quantidade dos ingredientes: ");
        custo.setQtdIngredientes(Integer.parseInt(input.nextLine()));

        System.out.printf("Insira o preco unitario: ");
        custo.setPrecoUnitario(Double.parseDouble(input.nextLine()));
        
        custo.insereBanco();

        //input.close();
    }

    
    public static void consultaReceitas() throws SQLException {
        Pagamento.listaPagamentos();;
    }

    
    public static void consultaDespesaEstq() throws SQLException {
        CustoEstoque.listaCustos();
    }

    
    public static void consultaDespesaRh() throws SQLException {
        CustoRH.listaCustos();
    }

    //#########################################################################
    public static void consultaBalanco() {
        System.out.println("Opcao nao implementada!");
    }
    //#########################################################################
    public static void listarPreferencias() {
        System.out.println("Opcao nao implementada!");
    }
}