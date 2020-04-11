package controllerExercicio1;

import java.util.ArrayList;

import model.vo.exercicio1.Cliente;
import model.vo.exercicio1.Endereco;
import model.bo.exercicio1.ClienteBO;

public class ClienteController {
	
	private static final int TAMANHO_MINIMO_CAMPO_NOME =3;
	private static final int TAMANHO_MAXIMO_CAMPO_NOME = 255;
	private static final int TAMANHO_MINIMO_CAMPO_SOBRENOME =4;
	private static final int TAMANHO_MAXIMO_CAMPO_SOBRENOME = 255;
	private static final int TAMANHO_MINIMO_CAMPO_TAMANHO_CPF =11;
	
	
	
	private  ClienteBO bo = new ClienteBO();
	
		
	

	public ArrayList<Cliente> listarTodosOsClientes() {
		// TODO Auto-generated method stub
		return null;
	}

}
