package model.bo.exercicio1;

import java.util.ArrayList;

import model.vo.exercicio1.Cliente;
import model.dao.exercicio1.ClienteDAO;

public class ClienteBO {

	private ClienteDAO dao = new ClienteDAO();

	public String excluirCliente(String cpf) {
		ClienteDAO cliente = new ClienteDAO();

		String mensagemValidacao = "";
		if (dao.cpfJaUtilizado(cpf)) {
			mensagemValidacao += "cliente excluído com sucesso!";
		} else {

		}
		mensagemValidacao += "CPF não consta no cadastro do cliente";

		return mensagemValidacao;
	}

	public ArrayList<Cliente> consultarClientes() {
		return null;

	}

	public boolean existeTelefone(String txtTelefone) {
		ClienteDAO dao = new ClienteDAO();
		if (dao.existeTelefone(txtTelefone)) {
			return true;
		} else {
			return false;
		}

	}

	public String salvar(Cliente cliente) {
		String mensagem ="";
		if(dao.cpfJaUtilizado(cliente.getCpf())) {
			mensagem = "Este CPF ("+cliente.getCpf() + ") já foi utilizado em outra operação";
			
		}else {
			cliente = dao.salvar(cliente);
			if(cliente.getId()>0) {
				mensagem = "Cliente salvo com sucesso";
			}else {
				mensagem = "Erro ao salvar cliente";
			}
		}
		return mensagem;
	}

	public boolean existeCPF(String textCpf) {
		ClienteDAO dao = new ClienteDAO();
		if(dao.cpfJaUtilizado(textCpf)) {
			return true;
		} else {
			return false;
		}
	}
	public boolean excluirPorId(int id) {
		ClienteDAO dao = new ClienteDAO();
		if(dao.excluir(id)) {
			return true;
		}else {
		return false;
	}
	}
}
