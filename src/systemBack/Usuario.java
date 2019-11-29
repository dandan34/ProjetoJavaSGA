package systemBack;

public class Usuario {
	/**
	 *  @author Daniel de Souza Rodrigues 18.2.8112
	 */
	private String usuario;
	private String senha;
	
	public Usuario(String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha;
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
