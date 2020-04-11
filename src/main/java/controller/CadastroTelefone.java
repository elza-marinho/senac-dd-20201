package viewExercicio1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CadastroTelefone extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigoPais;
	private JTextField txtDDD;
	private JTextField txtNumero;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroTelefone frame = new CadastroTelefone();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastroTelefone() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 308);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDono = new JLabel("Dono:");
		lblDono.setEnabled(false);
		lblDono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDono.setBounds(10, 15, 45, 20);
		contentPane.add(lblDono);
		
		JLabel lblCodigoPais = new JLabel("Código do País: ");
		lblCodigoPais.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCodigoPais.setEnabled(false);
		lblCodigoPais.setBounds(10, 75, 95, 20);
		contentPane.add(lblCodigoPais);
		
		JLabel lblDdd = new JLabel("DDD: ");
		lblDdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDdd.setBounds(235, 75, 45, 20);
		contentPane.add(lblDdd);
		
		JLabel lblNumero = new JLabel("Número:");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNumero.setBounds(10, 125, 59, 20);
		contentPane.add(lblNumero);
		
		txtCodigoPais = new JTextField();
		txtCodigoPais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		txtCodigoPais.setBounds(105, 70, 50, 30);
		contentPane.add(txtCodigoPais);
		txtCodigoPais.setColumns(10);
		
		txtDDD = new JTextField();
		txtDDD.setBounds(270, 70, 50, 30);
		contentPane.add(txtDDD);
		txtDDD.setColumns(10);
		
		JLabel lblMovel = new JLabel("Móvel:");
		lblMovel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMovel.setBounds(10, 170, 45, 20);
		contentPane.add(lblMovel);
		
		JRadioButton rbtMovelSim = new JRadioButton("Sim");
		rbtMovelSim.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		rbtMovelSim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		buttonGroup.add(rbtMovelSim);
		rbtMovelSim.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rbtMovelSim.setBounds(118, 170, 50, 20);
		contentPane.add(rbtMovelSim);
		
		JRadioButton rbtMovelNao = new JRadioButton("Não");
		rbtMovelNao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		rbtMovelNao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroup.add(rbtMovelNao);
		rbtMovelNao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rbtMovelNao.setBounds(286, 170, 50, 20);
		contentPane.add(rbtMovelNao);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSalvar.setBounds(105, 236, 85, 25);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.setBounds(235, 236, 85, 25);
		contentPane.add(btnCancelar);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		comboBox.setBounds(100, 10, 270, 30);
		contentPane.add(comboBox);
		
		txtNumero = new JTextField();
		txtNumero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		txtNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNumero.setBounds(105, 125, 120, 30);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);
		
		JLabel lblCamposObrigatrios = new JLabel("* Campos Obrigat\u00F3rios");
		lblCamposObrigatrios.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblCamposObrigatrios.setBounds(25, 205, 145, 15);
		contentPane.add(lblCamposObrigatrios);
	}
	
	
}
