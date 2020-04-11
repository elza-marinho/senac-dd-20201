package model.bo.exercicio1;

import java.util.ArrayList;

import model.dao.exercicio1.EnderecoDAO;
import model.vo.exercicio1.Endereco;

public class EnderecoBO {

	private EnderecoBO bo = new EnderecoBO();

	public String excluir(String textoIdSelecionado) {

		String mensagem = "";
		try {
			int idSelecionado = Integer.parseInt(textoIdSelecionado);
			mensagem = bo.excluir(idSelecionado);
		} catch (NumberFormatException ex) {
			mensagem = " Por Favor informe um número inteiro";
		}
		return mensagem;
	}

	private EnderecoDAO dao = new EnderecoDAO();

	public String excluir(int idSelecionado) {
		String mensagem = "";
		if (dao.temEnderecoCadastradoComId(idSelecionado)) {
			if (dao.excluir(idSelecionado)) {
				mensagem = "Excluído com sucesso";
			} else {
				mensagem = "Erro ao excluir";
			}
		} else {
			mensagem = "Id informado (" + idSelecionado + ") não existe no banco.";
		}

		return mensagem;
	}
	

	public String salvar(Endereco novoEndereco) {
		String mensagem = "";
		novoEndereco = dao.salvar(novoEndereco);
		if(novoEndereco.getId()>0) {
			mensagem = "Salvo com sucesso";
			
		}else {
			mensagem = "Erro ao salvar";
		}
		return mensagem;
	}


	public ArrayList<Endereco> consultarTodos() {
		EnderecoDAO dao = new EnderecoDAO();
		ArrayList<Endereco> enderecos = dao.consultarTodos();
		return enderecos;
	}
	

}
