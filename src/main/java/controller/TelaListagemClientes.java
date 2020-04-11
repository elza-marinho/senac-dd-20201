package viewExercicio1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controllerExercicio1.ClienteController;
import model.vo.exercicio1.Cliente;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaListagemClientes {

	private JFrame frame;
	private JTable tabelaClientes;
	private ArrayList<Cliente> clientes;
	private String[] nomesColunas = { "Nome completo", "CPF", "Quantidade de Telefones" };
	
	private void atualizarTabelaClientes() {
		limparTabelaClientes();
		DefaultTableModel model = (DefaultTableModel) tabelaClientes.getModel();

		for (Cliente c : clientes) {

			Object[] novaLinhaDaTabela = new Object[3];
			novaLinhaDaTabela[0] = c.getNomeCompleto();
			novaLinhaDaTabela[1] = c.getCpf();
			novaLinhaDaTabela[2] = c.getTelefones().size();

			model.addRow(novaLinhaDaTabela);
		}

	}


	private void limparTabelaClientes() {
		// TODO Auto-generated method stub
		
	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListagemClientes window = new TelaListagemClientes();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaListagemClientes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 555, 335);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteController controller = new ClienteController();
				clientes = controller.listarTodosOsClientes();
				
				atualizarTabelaClientes();
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscar.setBounds(215, 25, 100, 30);
		frame.getContentPane().add(btnBuscar);
		
		tabelaClientes = new JTable();
		tabelaClientes.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome Completo", "CPF", "Quantidade de Telefones"
			}
		));
		tabelaClientes.setBounds(25, 75, 500, 200);
		frame.getContentPane().add(tabelaClientes);
	}
}
