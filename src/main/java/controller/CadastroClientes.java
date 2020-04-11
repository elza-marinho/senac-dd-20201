package viewExercicio1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controllerExercicio1.TelefoneController;

import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JLayeredPane;

public class CadastroClientes extends JFrame {

	private static final String MaskFormatter = null;
	private JFrame frame;
	private JPanel contentpage;
	private JTextField txtnome;
	private JTextField textNome;
	private JTextField textSobrenome;
	private JComboBox cbEndereco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroClientes window = new CadastroClientes();
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
	public CadastroClientes() {
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		setTitle("Cadastro Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 455, 285);
		getContentPane().setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 15, 40, 15);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(lblNome);

		JLabel lblSobrenome = new JLabel("Sobrenome: ");
		lblSobrenome.setBounds(195, 10, 90, 25);
		lblSobrenome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(lblSobrenome);
		
		
		 try { MaskFormatter maskFormatter = new MaskFormatter("###.###.###-##");
		 
		 } catch (ParseException e) { 
		  e.printStackTrace(); 
		  }
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setBounds(10, 65, 50, 15);
		lblCPF.setRequestFocusEnabled(false);
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(lblCPF);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelefoneController controller = new TelefoneController();

			}
		});
		btnSalvar.setBounds(90, 210, 85, 30);
		getContentPane().add(btnSalvar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.setBounds(265, 210, 85, 30);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cancelar();
			}

			private void Cancelar() {
				
				
			}
		});
		getContentPane().add(btnCancelar);

		textNome = new JTextField();
		textNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textNome.setBounds(70, 15, 110, 30);
		getContentPane().add(textNome);
		textNome.setColumns(10);

		textSobrenome = new JTextField();
		textSobrenome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textSobrenome.setBounds(270, 10, 110, 30);
		getContentPane().add(textSobrenome);
		textSobrenome.setColumns(10);

		JLabel lblEndereco = new JLabel("Endereço:");
		lblEndereco.setBounds(10, 110, 65, 20);
		lblEndereco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(lblEndereco);

		JFormattedTextField textCPF = new JFormattedTextField();
		textCPF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textCPF.setBounds(70, 60, 110, 30);
		getContentPane().add(textCPF);

		cbEndereco = new JComboBox();
		cbEndereco.setBounds(70, 110, 310, 30);
		getContentPane().add(cbEndereco);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(29, 153, 1, 1);
		getContentPane().add(layeredPane);
		
		JLabel lblCamposObrigatrios = new JLabel("* Campos Obrigat\u00F3rios");
		lblCamposObrigatrios.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblCamposObrigatrios.setBounds(35, 160, 145, 15);
		getContentPane().add(lblCamposObrigatrios);
		

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private ArrayList<String> consultarEndereco() {
		ArrayList<String> EnderecoCadastrado = new ArrayList<String>();
		return EnderecoCadastrado;
	}
}
