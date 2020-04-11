package model.dao.exercicio1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.dao.Banco;
import model.vo.exercicio1.Cliente;
import model.vo.exercicio1.Endereco;
import model.vo.exercicio1.Telefone;

public class ClienteDAO {

	public boolean salvar(Cliente novocliente) {
		Connection conexao = Banco.getConnection();
		String sql = " INSERT INTO CLIENTE(NOME, SOBRENOME, CPF, IDENDERECO) " + " VALUES (?,?,?,?)";
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);
		int registrosAlterados = 0;
		try {
			stmt.setString(1, novocliente.getNome());
			stmt.setString(2, novocliente.getSobrenome());
			stmt.setString(3, novocliente.getCpf());
			stmt.setInt(4, novocliente.getEndereco().getId());
			stmt.setInt(5, novocliente.getId());
			registrosAlterados = stmt.executeUpdate();

			TelefoneDAO telefoneDAO = new TelefoneDAO();
			telefoneDAO.ativarTelefones(novocliente, novocliente.getTelefones());

		} catch (SQLException e) {
			System.out.println("Erro ao inserir novo cliente.");
			System.out.println("Erro: " + e.getMessage());
		}

		return registrosAlterados > 0;
	}

	public boolean excluir(int id) {

		Connection conn = Banco.getConnection();
		String sql = "DELETE FROM CLIENTE WHERE ID= " + id;
		Statement stmt = Banco.getStatement(conn);

		int quantidadeLinhasAfetadas = 0;
		try {
			quantidadeLinhasAfetadas = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Erro ao excluir cliente.");
			System.out.println("Erro: " + e.getMessage());
		}

		boolean excluiu = quantidadeLinhasAfetadas > 0;
		if (excluiu) {
			TelefoneDAO telefoneDAO = new TelefoneDAO();
			telefoneDAO.desativarTelefones(id);

		}

		return excluiu;
	}

	public boolean alterar(Cliente cliente) {
		Connection conexao = Banco.getConnection();
		String sql = " UPDATE CLIENTE" + "SET NOME=?, SOBRENOME=?, CPF=?, IDENDERECO=? " + " WHERE ID = ?";
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);
		int registrosAlterados = 0;
		try {
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getSobrenome());
			stmt.setString(3, cliente.getCpf());
			stmt.setInt(4, cliente.getEndereco().getId());
			stmt.setInt(5, cliente.getId());
			registrosAlterados = stmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Erro ao inserir novo cliente.");
			System.out.println("Erro: " + e.getMessage());
		}

		return registrosAlterados > 0;
	}

	public Cliente consultarPorId(int id) {
		Connection conexao = Banco.getConnection();
		String sql = " SELECT * FROM CLIENTE  WHERE is = " + id;
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);

		Cliente cliente = null;
		try {
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				cliente = construirClienteDoResultSet(rs);

			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar cliente com id: " + id);
			System.out.println("Erro: " + e.getMessage());
		}

		return cliente;
	}

	public ArrayList<Cliente> consultarTodos() {
		Connection conexao = Banco.getConnection();
		String sql = " SELECT * FROM CLIENTE ";
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);

		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		try {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente c = construirClienteDoResultSet(rs);
				clientes.add(c);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar clientes.");
			System.out.println("Erro: " + e.getMessage());
		}

		return clientes;
	}

	private Cliente construirClienteDoResultSet(ResultSet rs) {
		Cliente c = new Cliente();
		try {
			c.setId(rs.getInt("id"));
			c.setNome(rs.getString("nome"));
			c.setSobrenome(rs.getString("sobrenome"));
			c.setCpf(rs.getString("cpf"));

			EnderecoDAO enderecoDAO = new EnderecoDAO();
			Endereco end = enderecoDAO.consultarPorId(rs.getInt("idendereco"));
			c.setEndereco(end);

			TelefoneDAO telefoneDAO = new TelefoneDAO();
			ArrayList<Telefone> telefones = telefoneDAO.consultarTodosPorIdCliente(rs.getInt("id"));
			c.setTelefones(telefones);
		} catch (SQLException e) {
			System.out.println("Erro ao construir cliente a partir do ResultSet. Causa: " + e.getMessage());
		}

		return c;
	}

	public boolean cpfJaUtilizado(String cpf) {

		Connection conexao = Banco.getConnection();
		String sql = " select id from cliente c " + "where c.cpf = '" + cpf + "'";
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);
		boolean cpfUsado = false;

		try {
			ResultSet rs = stmt.executeQuery();
			cpfUsado = rs.next();
		} catch (SQLException e) {
			System.out.println("Erro ao verificar se CPF j� foi usado. Causa: " + e.getMessage());
		}

		return cpfUsado;
	}

	public boolean temClienteMorandoNoEndereco(int idEndereco) {
		Connection conexao = Banco.getConnection();
		String sql = " SELECT id FROM CLIENTE c " + " WHERE c.idEndereco = " + idEndereco;
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);

		boolean enderecoJaUsado = false;

		try {
			ResultSet rs = stmt.executeQuery();
			enderecoJaUsado = rs.next();
		} catch (SQLException e) {
			System.out.println("Erro ao verificar se endere�o j� foi usado. Causa: " + e.getMessage());
		}

		return enderecoJaUsado;
	}

	public boolean existeTelefone(String txtTelefone) {
		Connection conn = Banco.getConnection();
		String sql = "Select id from telefone where numero = '" + txtTelefone + "'";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet rs = null;
		boolean existeTelefone = false;
		try {
			rs = stmt.executeQuery(sql);
			existeTelefone = rs.next();
		} catch(SQLException e) {
			System.out.println("Erro ao verificar se o telefone j� existe. Causa: " + e.getMessage());
		} finally {
			Banco.closeResultSet(rs);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return existeTelefone;
	}
}
