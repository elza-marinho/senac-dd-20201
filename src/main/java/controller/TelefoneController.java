package controllerExercicio1;
import model.bo.exercicio1.TelefoneBO;
import model.vo.exercicio1.Telefone;

public class TelefoneController {
	private static final int TAMANHO_MINIMO_CAMPO_CODIGOPAIS =2;
	private static final int TAMANHO_MINIMO_CAMPO_NUMERO = 9;
	private static final int TAMANHO_MINIMO_CAMPO_DDD =2;
	
	
	
	private TelefoneBO bo = new TelefoneBO();
	
	public String Salvar(String dono, String códigoPais, String ddd, String numero, boolean movel, boolean ativo) {
		
		String mensagem ="";
		
	
		
	
		return mensagem;
	}
	private String validarCampoDeTexto(String nomeDoCampo, String valor, int tamanhoMinimo, int tamanhoMaximo, boolean obrigatorio) {
		String mensagemValidacao = "";
		if(obrigatorio && valor != null 
				&& ! valor.isEmpty()
				|| valor.length() < tamanhoMinimo
				|| valor.length() > tamanhoMaximo) {
		mensagemValidacao = nomeDoCampo + "deve possuir pelo menos " + tamanhoMinimo+ "e no máximo" + tamanhoMaximo + "caracteres \n";	
		}
				
			return mensagemValidacao;
		}
	}
	
	


