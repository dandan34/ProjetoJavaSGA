package system;

import java.util.ArrayList;
import java.util.LinkedList;

import academicoBack.Curso;
import academicoBack.Departamento;
import membros.Aluno;
import membros.Professor;

public class Base {

	private LinkedList<Curso> CursosDoInstituto;
	private LinkedList<Aluno> AlunosDoInstituto;
	private LinkedList<Professor> ProfessoresDoInstituto;
	private LinkedList<String> cpfAlunos;
	private LinkedList<String> codProfessores;
	private ArrayList<Departamento> DepartamentosDoInstituto;

	public Base() {

		this.CursosDoInstituto = new LinkedList<Curso>();
		this.AlunosDoInstituto = new LinkedList<Aluno>();
		this.ProfessoresDoInstituto = new LinkedList<Professor>();
		this.cpfAlunos = new LinkedList<String>();
		this.DepartamentosDoInstituto = new ArrayList<Departamento>();
		this.setCodProfessores(new LinkedList<String>());
	}

	public Boolean addAlunoBase(Aluno aluno) {

		if (cpfAlunos.contains(aluno.getCpf()) == true) {

			return false;
		} else {

			AlunosDoInstituto.add(aluno);
			cpfAlunos.add(aluno.getCpf());
			return true;
		}

	}

	public Boolean addProfessorBase(Professor professor) {

		Boolean testa = true;

		for (int i = 0; i < ProfessoresDoInstituto.size(); i++) {

			if (ProfessoresDoInstituto.get(i).getCpf().equals(professor.getCpf()) == true) {

				testa = false;
				break;
			}
		}

		if (testa == true) {

			ProfessoresDoInstituto.add(professor);
			codProfessores.add(professor.getCodProfessor());
			return true;
		} else {
			return false;
		}

	}

	public Boolean addCursoBase(Curso curso) {

		Boolean testa = true;

		for (int i = 0; i < CursosDoInstituto.size(); i++) {

			if (CursosDoInstituto.get(i).getNomeCurso().equals(curso.getNomeCurso()) == true) {

				testa = false;
				break;

			}

		}

		if (testa == true) {

			CursosDoInstituto.add(curso);
			return true;
		} else {

			return false;
		}

	}

	public Boolean buscarCursoBase(String nomecurso) {

		Boolean testa = false;

		for (int i = 0; i < CursosDoInstituto.size(); i++) {

			if (CursosDoInstituto.get(i).getNomeCurso().equals(nomecurso) == true) {

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

	public Boolean adiconarAlunoNaTurmaDaDisciplinaBASE(String nomeDisciplina, int indexTurma, Aluno aluno) {

		Boolean testa = false;

		for (int i = 0; i < CursosDoInstituto.size(); i++) {

			for (int j = 0; j < CursosDoInstituto.get(i).getMATERIAS().size(); j++) {

				if (CursosDoInstituto.get(i).getMATERIAS().get(j).getNomeDisciplina().equals(nomeDisciplina)) {

					CursosDoInstituto.get(i).getMATERIAS().get(j).getTURMAS().get(indexTurma).addAluno(aluno);
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

	public LinkedList<Aluno> getAlunosDoInstituto() {
		return AlunosDoInstituto;
	}

	public void setAlunosDoInstituto(LinkedList<Aluno> alunosDoInstituto) {
		AlunosDoInstituto = alunosDoInstituto;
	}

	public LinkedList<String> getCpfAlunos() {
		return cpfAlunos;
	}

	public void setCpfAlunos(LinkedList<String> cpfAlunos) {
		this.cpfAlunos = cpfAlunos;
	}

	public LinkedList<Curso> getCursosDoInstituto() {
		return CursosDoInstituto;
	}

	public void setCursosDoInstituto(LinkedList<Curso> cursosDoInstituto) {
		CursosDoInstituto = cursosDoInstituto;
	}

	public LinkedList<Professor> getProfessoresDoInstituto() {
		return ProfessoresDoInstituto;
	}

	public void setProfessoresDoInstituto(LinkedList<Professor> professoresDoInstituto) {
		ProfessoresDoInstituto = professoresDoInstituto;
	}

	public ArrayList<Departamento> getDepartamentosDoInstituto() {
		return DepartamentosDoInstituto;
	}

	public void setDepartamentosDoInstituto(ArrayList<Departamento> departamentosDoInstituto) {
		DepartamentosDoInstituto = departamentosDoInstituto;
	}

	public LinkedList<String> getCodProfessores() {
		return codProfessores;
	}

	public void setCodProfessores(LinkedList<String> codProfessores) {
		this.codProfessores = codProfessores;
	}

}
