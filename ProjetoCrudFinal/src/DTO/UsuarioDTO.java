package DTO;

public class UsuarioDTO {
	
	private int id_usuario, trainer_id;
	private String nome_usuario, email_cadastro, cpf_cadastro, telefone_cadastro, senha_usuario,Trainer,Age,Address,Mobile;
	
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNome_usuario() {
		return nome_usuario;
	}
	public void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}
	public String getSenha_usuario() {
		return senha_usuario;
	}
	public void setSenha_usuario(String senha_usuario) {
		this.senha_usuario = senha_usuario;
	}
	public String getEmail_cadastro() {
		return email_cadastro;
	}

	public void setEmail_cadastro(String email_cadastro) {
		this.email_cadastro = email_cadastro;
	}

	public String getCpf_cadastro() {
		return cpf_cadastro;
	}

	public void setCpf_cadastro(String cpf_cadastro) {
		this.cpf_cadastro = cpf_cadastro;
	}

	public String getTelefone_cadastro() {
		return telefone_cadastro;
	}

	public void setTelefone_cadastro(String telefone_cadastro) {
		this.telefone_cadastro = telefone_cadastro;
	}
	
	public String getTrainer() {
		return Trainer;
	}

	public void setTrainer( String Trainer) {
		this.Trainer = Trainer;
	}
	
	public String getAge() {
		return Age;
	}

	public void setAge( String Age) {
		this.Age = Age;
	}
	
	public String getAddress() {
		return Address;
	}

	public void setAddress( String Address) {
		this.Address = Address;
	}
	
	public String getMobile() {
		return Mobile;
	}

	public void setMobile( String Mobile) {
		this.Mobile = Mobile;
	}
	public int getTrainer_id() {
		return trainer_id;
	}
	public void setTrainer_id(int trainer_id) {
		this.trainer_id = trainer_id;
	}

}