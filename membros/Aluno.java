package membros;

import java.util.ArrayList;

import academicoBack.HistoricoAluno;
import system.Usuario;

public class Aluno extends Pessoa {

	private int matricula;
	private Usuario USUARIO;
	private Boolean status;
	private String nomeCursoCursado;
	private ArrayList<String> CURSANDO;
	private ArrayList<HistoricoAluno> NOTAS;

	public Aluno(String nome, String cpf, String sexo, String endereco) {
		super(nome, cpf, sexo, endereco);
		this.CURSANDO = new ArrayList<String>();
		this.NOTAS = new ArrayList<HistoricoAluno>();
		this.nomeCursoCursado = "";
		this.USUARIO = new Usuario(getCpf(), "123");
		this.status = true;
	}

	public Boolean addDisciplina(String codigo) {

		if (CURSANDO.contains(codigo) == true) {
			return false;
		} else {
			CURSANDO.add(codigo);
			HistoricoAluno x = new HistoricoAluno();
			x.setCodDisciplina(codigo);
			NOTAS.add(x);
			return true;
		}
	}

	public Boolean removeDisciplina(String codigo) {

		if (CURSANDO.contains(codigo)) {

			CURSANDO.remove(codigo);
			for (int i = 0; i > NOTAS.size(); i++) {
				if (NOTAS.get(i).getCodDisciplina() == codigo) {
					NOTAS.remove(i);
					break;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	public String[] imprimeCursando() {

		String[] st = new String[CURSANDO.size()];

		for (int i = 0; i < st.length; i++) {

			st[i] = CURSANDO.get(i);
		}

		return st;

	}

	public ArrayList<HistoricoAluno> getNOTAS() {
		return NOTAS;
	}

	public void setNOTAS(ArrayList<HistoricoAluno> nOTAS) {
		NOTAS = nOTAS;
	}

	public void setCURSANDO(ArrayList<String> cURSANDO) {
		CURSANDO = cURSANDO;
	}

	public ArrayList<String> getCURSANDO() {
		return CURSANDO;
	}

	public String getNomeCursoCursado() {
		return nomeCursoCursado;
	}

	public void setNomeCursoCursado(String nomeCursoCursado) {
		this.nomeCursoCursado = nomeCursoCursado;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public Usuario getUSUARIO() {
		return USUARIO;
	}

	public void setUSUARIO(Usuario uSUARIO) {
		USUARIO = uSUARIO;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
