package model.bo.exercicio1;
import java.util.ArrayList;
import model.dao.exercicio1.TelefoneDAO;
import model.vo.exercicio1.Telefone;

public class TelefoneBO {
	private TelefoneDAO dao = new TelefoneDAO();

	public String salvar(Telefone novoTelefone) {
		String mensagem = "";

		novoTelefone = dao.salvar(novoTelefone);

		if (novoTelefone.getId() > 0) {
			mensagem = "Telefone cadastrado com sucesso!";
		} else {
			mensagem = "Erro ao cadastrar telefone";
		}
		return mensagem;
	}

	public ArrayList<Telefone> listarTelefones() {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean existeDono(String numero) {
		TelefoneDAO dao = new TelefoneDAO();
	Boolean existeDono = dao.existeDono(numero);			
		return existeDono(null);
	}
	
	}

	
	
	
	


