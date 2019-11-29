package membros;

public abstract class Pessoa {
	
	/**
	 *  @author Daniel de Souza Rodrigues 18.2.8112
	 */
	private String nome;
	private String cpf;
	private String sexo;
	private String endereco;

	public Pessoa(String nome, String cpf, String sexo, String endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
