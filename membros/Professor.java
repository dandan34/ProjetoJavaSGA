package membros;

import java.util.ArrayList;

import academicoBack.Disciplina;
import systemBack.Usuario;

public class Professor extends Pessoa {

	private String codigoDepartamento;
	private String codProfessor;
	private Usuario USUARIO;
	private ArrayList<String> MINISTRA;
	private ArrayList<Disciplina> MATERIASMINISTRADAS;

	public Professor(String nome, String cpf, String sexo, String endereco, String codProfessor,
			String codDepartamento) {
		super(nome, cpf, sexo, endereco);
		this.codProfessor = codProfessor;
		this.MINISTRA = new ArrayList<String>();
		this.MATERIASMINISTRADAS = new ArrayList<Disciplina>();
		this.codigoDepartamento = codDepartamento;
		this.USUARIO = new Usuario(getCpf(), "123");

	}

	public boolean addMateria(String codDisciplina, Disciplina disciplina) {

		if (MINISTRA.contains(codDisciplina) == true) {
			return false;

		} else {
			MINISTRA.add(codDisciplina);
			MATERIASMINISTRADAS.add(disciplina);
			return true;
		}

	}

	public boolean removeMateria(String codDisciplina) {

		Boolean testa = false;

		if (MINISTRA.contains(codDisciplina) == true) {
			MINISTRA.remove(codDisciplina);

			for (int i = 0; i < MATERIASMINISTRADAS.size(); i++) {

				if (MATERIASMINISTRADAS.get(i).getCodDisciplina().equals(codDisciplina) == true) {

					MATERIASMINISTRADAS.remove(i);
					testa = true;
					break;
				}

			}

		

		}
		
		if (testa == true) {
			return true;
		} else {
			return false;
		}
	}

	public boolean removeMateriaIndex(int index) {

		String st = "";
		st = MINISTRA.get(index);
		if (removeMateria(st) == true) {
			return true;
		} else {
			return false;
		}

	}

	public String[] imprimeMinistradas() {

		String st[] = new String[MINISTRA.size()];

		for (int i = 0; i < MINISTRA.size(); i++) {

			st[i] = MINISTRA.get(i);
		}

		return st;

	}

	public String[] imprimeMinistradasNome() {

		if (MATERIASMINISTRADAS.isEmpty() == false) {

			String st[] = new String[MATERIASMINISTRADAS.size()];

			for (int i = 0; i < MINISTRA.size(); i++) {

				st[i] = MATERIASMINISTRADAS.get(i).getNomeDisciplina();
			}

			return st;

		} else {

			String st[] = new String[0];

			return st;
		}

	}

	public String getCodProfessor() {
		return codProfessor;
	}

	public void setCodProfessor(String codProfessor) {
		this.codProfessor = codProfessor;
	}

	public String getCodigoDepartamento() {
		return codigoDepartamento;
	}

	public void setCodigoDepartamento(String codigoDepartamento) {
		this.codigoDepartamento = codigoDepartamento;
	}

	public ArrayList<String> getMINISTRA() {
		return MINISTRA;
	}

	public void setMINISTRA(ArrayList<String> mINISTRA) {
		MINISTRA = mINISTRA;
	}

	public Usuario getUSUARIO() {
		return USUARIO;
	}

	public void setUSUARIO(Usuario uSUARIO) {
		USUARIO = uSUARIO;
	}

	public ArrayList<Disciplina> getMATERIASMINISTRADAS() {
		return MATERIASMINISTRADAS;
	}

	public void setMATERIASMINISTRADAS(ArrayList<Disciplina> mATERIASMINISTRADAS) {
		MATERIASMINISTRADAS = mATERIASMINISTRADAS;
	}

}
