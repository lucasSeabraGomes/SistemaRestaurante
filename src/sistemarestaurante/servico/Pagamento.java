package sistemarestaurante.servico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import sistemarestaurante.ferramentas.ConnectionFactory;

public class Pagamento {
    private int codigo;
    private int codigoPedido;
    private Date data;
    private double valor;
	

	/**
     * Métodos de acesso ao banco de dados
     */
    public static void insereBanco(int codPedido) throws SQLException {
        Connection con = new ConnectionFactory().getConexao();
        String sql = "INSERT INTO pagamentos " +
                            "(cod_pedido, valor) " +
                            "VALUES(?, ?);";
        PreparedStatement stmt = con.prepareStatement(sql);
        
        stmt.setInt(1, codPedido);
        stmt.setDouble(2, Pedido.buscaConta(codPedido));

        try {
            stmt.executeUpdate();
        }
        catch(SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            stmt.close();
            con.close();
        }
    }


    public static void listaPagamentos() throws SQLException{
        Connection con = new ConnectionFactory().getConexao();
        String sql = "SELECT data, codigo, cod_pedido, valor " +
                        "FROM pagamentos " +
						"ORDER BY data DESC, codigo ASC;";
		PreparedStatement stmt = con.prepareStatement(sql);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            ResultSet rs = stmt.executeQuery();

			System.out.printf("\n\n|Data\t\t- Codigo do pagamento - Codigo do pedido - Valor|\n");

            while(rs.next()){
				Date data = rs.getDate("data");
                String dataFormatada = sdf.format(data);
                int codPagamento = rs.getInt("codigo");
                int codPedido = rs.getInt("cod_pedido");
                double valor = rs.getDouble("valor");

                System.out.printf("|%s\t- %d\t\t\t- %d\t\t- R$ %.2f|\n", 
                                    dataFormatada, codPagamento, 
                                    codPedido, valor);
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
    

    public static double buscaReceitaTotal() throws SQLException {
		Connection con = new ConnectionFactory().getConexao();
        String sql = "SELECT SUM(valor) FROM pagamentos;";
        PreparedStatement stmt = con.prepareStatement(sql);
        double custoTotal = 0.0;

        try {
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                custoTotal = rs.getFloat("sum");
            }
        }
        catch(SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            stmt.close();
            con.close();
        }
        return custoTotal;
	}
    

    /**
	 * GET's e SET's
	 */
    // Variavel codigo
     public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

    // Variavel codigoPedido
	public int getCodigoPedido() {
		return codigoPedido;
	}
	public void setCodigoPedido(int codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

    // Variavel data
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}

    // Variavel valor
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
}