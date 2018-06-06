package sistemarestaurante;

import java.sql.SQLException;
import java.util.Scanner;

import sistemarestaurante.estoque.Produto;
import sistemarestaurante.servico.Pedido;

public class MenuGarcom {
    public static void menuPrincipal(String cpfUsuario) throws SQLException {
        Scanner input = new Scanner(System.in);
        int opcao;

        System.out.println("[1] Recepcionar proximo cliente.");
        System.out.println("[2] Realizar novo pedido.");
        System.out.println("[3] Consultar pedidos prontos.");
        System.out.println("[4] Entregar pedido pronto.");
        System.out.println("[5] Receber pagamento de pedido.");
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
                    realizaPedido(cpfUsuario, 1);
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

                case 0:
                    return
                
                default:
                    System.out.println("Opcao invalida!");
            }
        //input.close();
        }
    }

    public static void recepcionaCliente() {
        Scanner input = new Scanner();

        System.out.println("")
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


    public static void consultaPedidos() {
        Scanner input = new Scanner();

        System.out.println("")
    }


    public static void entregaPedido(int codPedido) {
        Scanner input = new Scanner();

        System.out.println("")
    }


    public static void recebePagamento(int codPedido) {
        Scanner input = new Scanner();

        System.out.println("")
    }
}