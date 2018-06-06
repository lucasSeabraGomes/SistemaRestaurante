package sistemarestaurante;

import java.sql.SQLException;
import java.util.Scanner;

import sistemarestaurante.estoque.Produto;
import sistemarestaurante.servico.Pedido;

public class MenuGarcom {
    public static void menuPrincipal(String cpfUsuario) throws SQLException {
        Scanner input = new Scanner(System.in);
        int opcao;

        System.out.println("[1] Cadastrar novo pedido.");
        System.out.println();

        System.out.print("Digite a opção desejada: ");
        opcao = Integer.parseInt(input.nextLine());

        switch(opcao){
            case 1:
                realizaPedido(cpfUsuario, 1);
                break;
            
            default:
                System.out.println("Opcao invalida!");
        }
        //input.close();
    }


    public static void realizaPedido(String cpfGarcom, int codigoMesa) throws SQLException{
        Scanner input = new Scanner(System.in);
        Pedido pedido = new Pedido();
        int codigoProduto;
        int qtdProduto;
        boolean pedidoConcluido = false;
        
        pedido.setCodigoMesa(codigoMesa);
        pedido.setCpfGarcom(cpfGarcom);

        System.out.print("Insira o CPF do cliente: ");
        pedido.setCpfCliente(input.nextLine());
        Produto.imprimeProdutos();
        
        while(!pedidoConcluido){
            System.out.print("Digite o codigo do produto ou \"0\" para sair: ");
            codigoProduto = Integer.parseInt(input.nextLine());

            if(codigoProduto > 0){
                System.out.printf("Digite a quantidade do produto %s: ", Produto.buscaNome(codigoProduto));
                qtdProduto = Integer.parseInt(input.nextLine());

                pedido.addItemPedido(codigoProduto, qtdProduto);
            }
            else{
                pedidoConcluido = true;
            }
        }

        //input.close();
        pedido.insereBanco();
    }
}