package sistemarestaurante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import sistemarestaurante.estoque.Produto;
import sistemarestaurante.ferramentas.ConnectionFactory;
import sistemarestaurante.individuos.Cliente;
import sistemarestaurante.servico.Mesa;
import sistemarestaurante.servico.Pedido;

public class MenuGarcom {
    public static void menuPrincipal(String cpfUsuario) throws SQLException {
        Scanner input = new Scanner(System.in);
        int opcao = -1;

        while(opcao != 0){
            System.out.println("[1] Recepcionar proximo cliente.");
            System.out.println("[2] Realizar novo pedido.");
            System.out.println("[3] Consultar pedidos prontos.");
            System.out.println("[4] Receber pagamento de pedido.");
            System.out.println("[0] Sair.");
            System.out.println();
    
            System.out.print("Digite a opção desejada: ");
            opcao = Integer.parseInt(input.nextLine());

            switch(opcao){
                case 1:
                    recepcionaCliente();
                    break;

                case 2:
                    realizaPedido(cpfUsuario, 1);
                    break;
                
                case 3:
                    consultaPedidos(cpfUsuario);
                    break;
                    
                case 4:
                    recebePagamento(cpfUsuario);
                    break;

                case 0:
                    return;
                
                default:
                    System.out.println("Opcao invalida!");
            }
        }
        //input.close();
    }

    public static void recepcionaCliente() throws SQLException {
        Scanner input = new Scanner(System.in);
        String cpf = null;
        int mesaLivre = Mesa.buscaMesaLivre();

        System.out.print("Insira o CPF do cliente: ");
        cpf = input.nextLine();

        if(! Cliente.verifCadastroExiste(cpf)) {
           cadastraCliente(cpf); 
        }

        Mesa.ocupaMesa(cpf, mesaLivre);
        //input.close();
    }


    public static void cadastraCliente(String cpf) throws SQLException {
        Scanner input = new Scanner(System.in);
        Cliente cliente = new Cliente();

        cliente.setCpf(cpf);

        System.out.println("Cliente nao cadastrado. Insira abaixo as informacoes do cliente.");

        System.out.print("Nome: ");
        cliente.setNome(input.nextLine());
        
        System.out.print("RG: ");
        cliente.setRg(input.nextLine());
        
        //System.out.print("Data de nascimento: ");
        //cliente.setDataNascimento(input.nextLine());
        
        System.out.print("Nome do pai: ");
        cliente.setFiliacaoPai(input.nextLine());
        
        System.out.print("Nome da mae: ");
        cliente.setFiliacaoMae(input.nextLine());
        
        System.out.print("Naturalidade: ");
        cliente.setNaturalidade(input.nextLine());
        
        System.out.print("Estado civil: ");
        cliente.setEstadoCivil(input.nextLine());
        
        System.out.print("Sexo [1:Masculino | 2:Feminino]: ");
        if(Integer.parseInt(input.nextLine()) == 1){
            cliente.setSexoMasculino(true);
        }
        else{
            cliente.setSexoMasculino(false);
        }

        System.out.print("Telefone: ");
        cliente.setTelefone(input.nextLine());
        
        System.out.print("E-Mail: ");
        cliente.setEmail(input.nextLine());
        
        System.out.print("Endereco: ");
        cliente.setEndereco(input.nextLine());
        
        System.out.print("Escolaridade: ");
        cliente.setEscolaridade(input.nextLine());
        
        System.out.print("Profissao: ");
        cliente.setProfissao(input.nextLine());

        cliente.insereBanco();
        System.out.printf("\nO cliente %s foi cadastrado no sistema.\n", cliente.getNome());
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

        pedido.insereBanco();
        //input.close();
    }


    public static void consultaPedidos(String cpfGarcom) throws SQLException {
        Connection con = new ConnectionFactory().getConexao();
        String sql = "SELECT codigo, cod_mesa FROM pedidos " +
                        "WHERE cpf_garcom = ? AND pedido_pronto = true AND pedido_pago != true;";
        PreparedStatement stmt = con.prepareStatement(sql);

        stmt.setString(1, cpfGarcom);

        try {
            ResultSet rs = stmt.executeQuery();

            System.out.printf("\n\n|Numero do pedido - Numero da mesa|\n");

            while(rs.next()){
                int codigoPedido = rs.getInt("codigo");
                int codigoMesa = rs.getInt("cod_mesa");
                
                System.out.printf("|%d\t\t- %d\t\t|\n", codigoPedido, codigoMesa);
            }
        }
        catch(SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            stmt.close();
            con.close();
        }
    }

    
    public static void recebePagamento(String cpfGarcom) throws SQLException {
        Scanner input = new Scanner(System.in);
        int codigoPedido;

        System.out.print("Digite o número do pedido: ");
        codigoPedido = Integer.parseInt(input.nextLine());

        Pedido.marcaPedidoPago(codigoPedido);
        System.out.printf("Foi recebido R$ %.2f do pedido de número %d.\n", 
                            Pedido.buscaConta(codigoPedido), codigoPedido);

        //input.close();
    }
}