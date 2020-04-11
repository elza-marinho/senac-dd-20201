package viewExercicio1;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import java.awt.Font;

public class CadastroEndereco extends JFrame {
	private JPanel contentPane;
	private JTextField txtRua;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtNumero;
	private JFormattedTextField txtCep;
	private JComboBox cbSiglaEstado;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroEndereco frame = new CadastroEndereco();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CadastroEndereco() {
		setTitle("Cadastro de endereço");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRua.setBounds(20, 20, 40, 15);
		contentPane.add(lblRua);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBairro.setBounds(10, 70, 50, 15);
		contentPane.add(lblBairro);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCidade.setBounds(10, 109, 50, 15);
		contentPane.add(lblCidade);

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEstado.setBounds(359, 109, 42, 16);
		contentPane.add(lblEstado);

		JLabel lblNumero = new JLabel("Número:");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNumero.setBounds(340, 20, 60, 15);
		contentPane.add(lblNumero);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(360, 70, 27, 16);
		contentPane.add(lblCep);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalvar.setBounds(105, 190, 120, 30);
		contentPane.add(btnSalvar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}

		});
		btnLimpar.setBounds(235, 190, 115, 30);
		contentPane.add(btnLimpar);

		txtRua = new JTextField();
		txtRua.setBounds(70, 15, 200, 30);
		contentPane.add(txtRua);
		txtRua.setColumns(10);

		txtBairro = new JTextField();
		txtBairro.setBounds(70, 65, 200, 30);
		contentPane.add(txtBairro);
		txtBairro.setColumns(10);

		txtCidade = new JTextField();
		txtCidade.setBounds(70, 104, 200, 30);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);

		txtNumero = new JTextField();
		txtNumero.setBounds(410, 15, 110, 30);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);
		try {
			MaskFormatter mascaraCep = new MaskFormatter("#####-###");

			txtCep = new JFormattedTextField(mascaraCep);
			txtCep.setBounds(410, 65, 110, 30);
			contentPane.add(txtCep);

		} catch (ParseException e) {
			
			e.printStackTrace();
		}

		ArrayList<String> siglasEstados = consultarEstados();
		cbSiglaEstado = new JComboBox(siglasEstados.toArray());
		cbSiglaEstado.setBounds(410, 105, 110, 30);
		contentPane.add(cbSiglaEstado);
		
		JLabel lblCamposObrigatorios = new JLabel("* Campos Obrigat\u00F3rios");
		lblCamposObrigatorios.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCamposObrigatorios.setBounds(49, 164, 135, 15);
		contentPane.add(lblCamposObrigatorios);
	}

	protected void limparCampos() {
		// Campos de texto: "setar" o texto para ""
		this.txtRua.setText("");
		this.txtBairro.setText("");
		this.txtCidade.setText("");
		this.txtNumero.setText("");
		this.txtCep.setText("");

		// Campos com combobox: "setar" o índice selecionado para -1 (sem item
		// selecionado no combo)
		this.cbSiglaEstado.setSelectedIndex(-1);
	}

	private ArrayList<String> consultarEstados() {
		ArrayList<String> siglasEstados = new ArrayList<String>();

		siglasEstados.add("AC");
		siglasEstados.add("AL");
		siglasEstados.add("AM");
		siglasEstados.add("AP");
		siglasEstados.add("BA");
		siglasEstados.add("CE");
		siglasEstados.add("DF");
		siglasEstados.add("ES");
		siglasEstados.add("GO");
		siglasEstados.add("MA");
		siglasEstados.add("MT");
		siglasEstados.add("MS");
		siglasEstados.add("MG");
		siglasEstados.add("PA");
		siglasEstados.add("PB");
		siglasEstados.add("PR");
		siglasEstados.add("PE");
		siglasEstados.add("PI");
		siglasEstados.add("RJ");
		siglasEstados.add("RN");
		siglasEstados.add("RS");
		siglasEstados.add("RO");
		siglasEstados.add("RR");
		siglasEstados.add("SC");
		siglasEstados.add("SP");
		siglasEstados.add("SE");
		siglasEstados.add("TO");

		return siglasEstados;
	}

}
