package academicoBack;

import java.util.LinkedList;

import membros.Aluno;

public class Turma {

	private String codigoTurma;
	private LinkedList<Aluno> alunosTurma;

	public Turma(String codigoTurma) {

		this.alunosTurma = new LinkedList<Aluno>();
		this.codigoTurma = codigoTurma;
	}

	/*
	 * Verifica se um Aluno esta matriculado na turma
	 * 
	 * @return boolean
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */

	public boolean verificaAluno(String cpf) {

		Boolean testa = false;

		for (int i = 0; i < alunosTurma.size(); i++) {

			if (alunosTurma.get(i).getCpf().equals(cpf)) {

				testa = true;
			}
		}

		if (testa == true) {
			return false;

		} else {
			return true;
		}
	}
	/*
	 * Adiciona um Aluno a Turma
	 * 
	 * @param aluno
	 * 
	 * @return boolean
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */

	public boolean addAluno(Aluno aluno) {

		if (verificaAluno(aluno.getCpf()) == true) {

			alunosTurma.add(aluno);
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Remove aluno da turma
	 * 
	 * @param cpf
	 * 
	 * @return boolean
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */
	public boolean removeAluno(String cpf) {

		if (verificaAluno(cpf) == true) {

			for (int i = 0; i < alunosTurma.size(); i++) {

				if (alunosTurma.get(i).getCpf().equals(cpf) == true) {

					alunosTurma.remove(i);
					break;
				}
			}

			return true;

		} else {
			return false;
		}

	}

	/*
	 * Armazena todos os alunos da turma em um Array
	 * 
	 * @return String[]
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */
	public String[] imprimeAlunosTurma() {

		String[] st = new String[alunosTurma.size()];

		for (int i = 0; i < st.length; i++) {

			st[i] = alunosTurma.get(i).getMatricula() + " " + alunosTurma.get(i).getNome();
		}

		return st;
	}

	/*
	 * Atribui null a todos atributos da turma
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 * 
	 */
	public void setNULLTURMA() {

		alunosTurma = null;
		codigoTurma = null;
	}

	public String getCodigoTurma() {
		return codigoTurma;
	}

	public void setCodigoTurma(String codigoTurma) {
		this.codigoTurma = codigoTurma;
	}

	public LinkedList<Aluno> getAlunosTurma() {
		return alunosTurma;
	}

	public void setAlunosTurma(LinkedList<Aluno> alunosTurma) {
		this.alunosTurma = alunosTurma;
	}

}
