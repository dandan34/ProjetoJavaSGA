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

	public boolean addAluno(Aluno aluno) {

		if (verificaAluno(aluno.getCpf()) == true) {

			alunosTurma.add(aluno);
			return true;
		} else {
			return false;
		}
	}

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
	
	public String[] imprimeAlunosTurma() {
		
		String[] st = new String[alunosTurma.size()];
		
		for(int i=0; i < st.length ; i ++) {
			
			st[i] = alunosTurma.get(i).getMatricula() + " " + alunosTurma.get(i).getNome();
		}
		
		return st;
	}
	
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
