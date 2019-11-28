package academicoBack;

import java.util.ArrayList;
import java.util.LinkedList;

import membros.Aluno;

public class Curso {

	private String nomeCurso;
	private String codDepartamentoResponsavel;

	private ArrayList<Disciplina> MATERIAS;
	private LinkedList<Aluno> ALUNOS;

	public Curso(String nome) {

		this.MATERIAS = new ArrayList<Disciplina>();
		this.ALUNOS = new LinkedList<Aluno>();
		this.nomeCurso = nome;
	}

	/*
	 * Armazena todas as materias presentes no curso em um Array de String
	 * 
	 * @return String[]
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 * 
	 */

	public String[] imprimeMaterias() {
		String[] st = new String[MATERIAS.size()];

		for (int i = 0; i < st.length; i++) {

			st[i] = MATERIAS.get(i).getCodDisciplina() + "     " + MATERIAS.get(i).getNomeDisciplina();
		}

		return st;
	}

	/*
	 * Armazena informações de todos os alunos matriculados no curso em um Array de
	 * String
	 * 
	 * @return String[]
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */

	public String[] imprimeAlunos() {

		String[] st = new String[ALUNOS.size()];

		for (int i = 0; i < st.length; i++) {

			st[i] = ALUNOS.get(i).getMatricula() + " - " + ALUNOS.get(i).getNome() + " - " + ALUNOS.get(i).getCpf();

		}

		return st;
	}
	/*
	 * Adiciona materias no curso
	 * 
	 * @param nome
	 * 
	 * @param cod
	 * 
	 * @return boolean
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */

	public boolean addMateria(String nome, String cod) {

		Boolean testa = true;

		for (int i = 0; i < MATERIAS.size(); i++) {
			if (MATERIAS.get(i).getCodDisciplina().equals(cod)) {
				testa = false;
				break;
			}
		}

		if (testa == true) {
			Disciplina discp = new Disciplina(nome, cod);
			MATERIAS.add(discp);
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Remove Materia do curso baseado no index
	 * 
	 * @param index
	 * 
	 * @return boolean
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */
	public boolean removeMateriaIndex(int index) {

		if (MATERIAS.size() >= index) {

			if (MATERIAS.get(index).getTURMAS().size() >= 0) {

				for (int i = 0; i < MATERIAS.get(index).getTURMAS().size(); i++) {

					MATERIAS.get(index).removeTurma(i);

				}
				// conferir implementacao e conferir a base.. lembrar de olhar turma na base e
				// verificar o front
			}

			MATERIAS.remove(index);

			return true;
		} else {
			return false;
		}
	}
	/*
	 * Remove materia baseado em um codigo String
	 * 
	 * @param cod
	 * 
	 * @return boolean
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */

	public boolean removeMateria(String cod) {
		Boolean testa = false;

		for (int i = 0; i < MATERIAS.size(); i++) {
			if (MATERIAS.get(i).getCodDisciplina().equals(cod)) {
				MATERIAS.remove(i);
				testa = true;
				break;
			}
		}

		if (testa == true) {
			return true;
		} else {
			return false;
		}
	}
	/*
	 * Adiciona aluno no curso
	 * 
	 * @param Aluno
	 * 
	 * @return boolean
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */

	public boolean addAlunoNoCurso(Aluno aluno) {

		Boolean testa = true;

		for (int i = 0; i < ALUNOS.size(); i++) {

			if (ALUNOS.get(i).getCpf().equals(aluno.getCpf()) == true) {

				testa = false;
				break;
			}
		}

		if (testa == true) {

			ALUNOS.add(aluno);
			return testa;
		} else {
			return false;
		}

	}

	/*
	 * Busca por uma disciplina especifica no curso baseado em um index
	 * 
	 * @param index
	 * 
	 * @return Disciplina
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */

	public Disciplina getDisciplinaIndex(int index) {

		if (index > MATERIAS.size()) {

			return null;
		} else {
			return MATERIAS.get(index);
		}
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public ArrayList<Disciplina> getMATERIAS() {
		return MATERIAS;
	}

	public void setMATERIAS(ArrayList<Disciplina> mATERIAS) {
		MATERIAS = mATERIAS;
	}

	public String getCodDepartamentoResponsavel() {
		return codDepartamentoResponsavel;
	}

	public void setCodDepartamentoResponsavel(String codDepartamentoResponsavel) {
		this.codDepartamentoResponsavel = codDepartamentoResponsavel;
	}

	public LinkedList<Aluno> getALUNOS() {
		return ALUNOS;
	}

	public void setALUNOS(LinkedList<Aluno> aLUNOS) {
		ALUNOS = aLUNOS;
	}

}
