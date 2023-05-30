package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import DTO.CadastroDTO;
import DAO.UsuarioDAO;
import DTO.UsuarioDTO;

public class CadastroDAO {
	
	Connection conn;
	PreparedStatement pstm;
	public void cadastrarCliente(CadastroDTO  objusuariodto){
		String sql = "insert into usuario (nome_usuario, email_cadastro, cpf_cadastro, telefone_cadastro, senha_usuario) values(?,?,?,?,?)";
		
		conn = new ConexaoDAO().conectaBD();
		
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, objusuariodto.getNome_usuario());;
			pstm.setString(5, objusuariodto.getSenha_usuario());
			
			pstm.execute();
			pstm.close();
			
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "CadastroDAO" + erro);
		}
	}
}