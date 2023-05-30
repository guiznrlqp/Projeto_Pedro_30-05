package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.UsuarioDAO;
import DTO.UsuarioDTO;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Trainer extends JFrame {

	private JPanel contentPane;
	private JTextField txtTrainer;
	private JTextField txtAge;
	private JTextField txtAddress;
	private JTextField txtMobile;
	private JTable TabelaTrainer;
	private JTextField txtID;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Trainer frame = new Trainer();
					frame.setVisible(true);
					frame.listarValores();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Trainer() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 988, 653);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		


		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(0, 0, 972, 81);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Trainers");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(418, 11, 114, 45);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Personal");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 135, 112, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Idade");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(10, 181, 46, 24);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Endereço");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(10, 230, 70, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Telefone");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(10, 274, 70, 14);
		contentPane.add(lblNewLabel_4);
		
		txtTrainer = new JTextField();
		txtTrainer.setBounds(131, 134, 131, 20);
		contentPane.add(txtTrainer);
		txtTrainer.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setColumns(10);
		txtAge.setBounds(131, 185, 131, 20);
		contentPane.add(txtAge);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(131, 229, 131, 20);
		contentPane.add(txtAddress);
		
		txtMobile = new JTextField();
		txtMobile.setColumns(10);
		txtMobile.setBounds(131, 273, 131, 20);
		contentPane.add(txtMobile);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String trainer_id,Trainer,Age, Address, Mobile;
				
				trainer_id = txtID.getText();
				Trainer = txtTrainer.getText();
				Age = txtAge.getText();
				Address = txtAddress.getText();
				Mobile = txtMobile.getText();
				

				DTO.UsuarioDTO objusuariodto = new UsuarioDTO();
				objusuariodto.setTrainer(Trainer);
				objusuariodto.setAge(Age);
				objusuariodto.setAddress(Address);
				objusuariodto.setMobile(Mobile);
				
				
				UsuarioDAO objcadastrodao = new UsuarioDAO();
				objcadastrodao.cadastrarTrainer(objusuariodto);
				JOptionPane.showMessageDialog(null, "Trainer Adicionado");
				listarValores();
			}
		});
		btnNewButton.setBounds(24, 362, 164, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(367, 137, 540, 256);
		contentPane.add(scrollPane);
		
		TabelaTrainer = new JTable();
		scrollPane.setViewportView(TabelaTrainer);
		TabelaTrainer.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "PersonalTrainer", "Idade", "Endereço", "Telefone"
			}
		));
		
		JButton btnpesquisar = new JButton("Pesquisar");
		btnpesquisar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				listarValores();
			}
		});
		btnpesquisar.setBounds(24, 396, 164, 23);
		contentPane.add(btnpesquisar);
		
		JButton btnCarregarCampos = new JButton("CARREGAR CAMPOS");
		btnCarregarCampos.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				CarregarCampos();
			}
		});
		btnCarregarCampos.setBounds(24, 430, 164, 23);
		contentPane.add(btnCarregarCampos);
		
		JButton btnNewButton_1 = new JButton("Limpar");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				LimparCampos();
			}
		});
		btnNewButton_1.setBounds(24, 475, 164, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Alterar");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				AlterarTrainer();
				listarValores();
				LimparCampos();
			}
		});
		btnNewButton_2.setBounds(24, 509, 164, 23);
		contentPane.add(btnNewButton_2);
		
		txtID = new JTextField();
		txtID.setEnabled(false);
		txtID.setColumns(10);
		txtID.setBounds(39, 102, 131, 20);
		contentPane.add(txtID);
		
		JLabel lblNewLabel_1_1 = new JLabel("ID");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(10, 103, 112, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ExcluirTrainer();
				listarValores();
				LimparCampos();
			}
		});
		btnExcluir.setBounds(24, 550, 164, 23);
		contentPane.add(btnExcluir);
	}
	
	
	private void listarValores() {
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			
			DefaultTableModel DefaultTableModel = (DefaultTableModel) TabelaTrainer.getModel();
			DefaultTableModel.setNumRows(0);
			
			ArrayList<UsuarioDTO> lista = usuarioDAO.PesquisarTrainer();
			
			for(int num = 0; num < lista.size(); num ++) {
				DefaultTableModel.addRow(new Object[]{
						lista.get(num).getTrainer_id(),
						lista.get(num).getTrainer(),
						lista.get(num).getAge(),
						lista.get(num).getAddress(),
						lista.get(num).getMobile(),
				});
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro");
		}
	}
	
	private void CarregarCampos() {
		int setar = TabelaTrainer.getSelectedRow();
		
		txtID.setText(TabelaTrainer.getModel().getValueAt(setar, 0).toString());
		txtTrainer.setText(TabelaTrainer.getModel().getValueAt(setar, 1).toString());
		txtAge.setText(TabelaTrainer.getModel().getValueAt(setar, 2).toString());
		txtAddress.setText(TabelaTrainer.getModel().getValueAt(setar, 3).toString());
		txtMobile.setText(TabelaTrainer.getModel().getValueAt(setar, 4).toString());
	}
	
	private void LimparCampos() {
		txtTrainer.setText("");
		txtAge.setText("");
		txtAddress.setText("");
		txtMobile.setText("");
		txtTrainer.requestFocus();
	}
	
	private void AlterarTrainer() {
		int trainer_id;
		String Trainer,Age, Address, Mobile;
		
		trainer_id = Integer.parseInt(txtID.getText());
		Trainer = txtTrainer.getText();
		Age = txtAge.getText();
		Address = txtAddress.getText();
		Mobile = txtMobile.getText();
		
		DTO.UsuarioDTO objusuariodto = new UsuarioDTO();
		objusuariodto.setTrainer_id(trainer_id);
		objusuariodto.setTrainer(Trainer);
		objusuariodto.setAge(Age);
		objusuariodto.setAddress(Address);
		objusuariodto.setMobile(Mobile);
		
		UsuarioDAO objusuariodao = new UsuarioDAO();
		objusuariodao.AlterarTrainer(objusuariodto);
		
		
	}
	
	private void ExcluirTrainer(){
		int trainer_id;
		
		trainer_id = Integer.parseInt(txtID.getText());
		
		DTO.UsuarioDTO objusuariodto = new UsuarioDTO();
		objusuariodto.setTrainer_id(trainer_id);
		
		UsuarioDAO objusuariodao = new UsuarioDAO();
		objusuariodao.ExcluirTrainer(objusuariodto);
	}
	

	
	
}
