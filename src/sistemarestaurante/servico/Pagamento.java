package sistemarestaurante.servico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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