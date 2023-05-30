package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.CadastroDAO;
import DAO.UsuarioDAO;
import DTO.UsuarioDTO;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class frmCadastroVIEW extends JFrame {

	private JPanel contentPane;
	private JTextField textEmail;
	private JTextField textNome;
	private JTextField textCpf;
	private JTextField textTelefone;
	private JTextField textSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmCadastroVIEW frame = new frmCadastroVIEW();
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
	public frmCadastroVIEW() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 580);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Email:");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(53, 343, 45, 20);
		contentPane.add(lblNewLabel);
		
		textEmail = new JTextField();
		textEmail.setBounds(114, 345, 206, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(Color.BLACK);
		lblNome.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNome.setBounds(56, 190, 48, 20);
		contentPane.add(lblNome);
		
		textNome = new JTextField();
		textNome.setColumns(10);
		textNome.setBounds(114, 193, 206, 20);
		contentPane.add(textNome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setForeground(Color.BLACK);
		lblCpf.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblCpf.setBounds(63, 222, 45, 20);
		contentPane.add(lblCpf);
		
		textCpf = new JTextField();
		textCpf.setColumns(10);
		textCpf.setBounds(114, 224, 206, 20);
		contentPane.add(textCpf);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setForeground(Color.BLACK);
		lblTelefone.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblTelefone.setBounds(43, 258, 67, 20);
		contentPane.add(lblTelefone);
		
		textTelefone = new JTextField();
		textTelefone.setColumns(10);
		textTelefone.setBounds(114, 260, 206, 20);
		contentPane.add(textTelefone);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(Color.BLACK);
		lblSenha.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblSenha.setBounds(53, 374, 56, 20);
		contentPane.add(lblSenha);
		
		textSenha = new JTextField();
		textSenha.setColumns(10);
		textSenha.setBounds(114, 376, 206, 20);
		contentPane.add(textSenha);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCadastrar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String email,nome_usuario, cpf, telefone, senha_usuario;
				
				email = textEmail.getText();
				nome_usuario = textNome.getText();
				cpf = textCpf.getText();
				telefone = textTelefone.getText();
				senha_usuario = textSenha.getText();

				DTO.UsuarioDTO objusuariodto = new UsuarioDTO();
				objusuariodto.setNome_usuario(nome_usuario);
				objusuariodto.setEmail_cadastro(email);
				objusuariodto.setCpf_cadastro(cpf);
				objusuariodto.setTelefone_cadastro(nome_usuario);
				objusuariodto.setSenha_usuario(senha_usuario);;
				
				UsuarioDAO objcadastrodao = new UsuarioDAO();
				objcadastrodao.cadastrarCliente(objusuariodto);
			}
		});
		btnCadastrar.setBounds(160, 442, 121, 31);
		contentPane.add(btnCadastrar);
		
		JLabel lblNewLabel_1 = new JLabel("Retornar");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				frmLoginView login = new frmLoginView();
				login.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_1.setBounds(10, 11, 88, 31);
		contentPane.add(lblNewLabel_1);
	}
}
