package system;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import academicoBack.Curso;
import academicoBack.Departamento;
import membros.Aluno;
import membros.Professor;

public class Base {

	private ArrayList<Departamento> DepartamentosDoInstituto;
	private LinkedList<Curso> CursosDoInstituto;
	private LinkedList<Aluno> AlunosDoInstituto;
	private LinkedList<Professor> ProfessoresDoInstituto;

	private LinkedList<String> cpfAlunos;
	private LinkedList<String> codProfessores;
	private LinkedList<String> cpfProfessores;

	public Base() {

		this.CursosDoInstituto = new LinkedList<Curso>();
		this.AlunosDoInstituto = new LinkedList<Aluno>();
		this.ProfessoresDoInstituto = new LinkedList<Professor>();
		this.cpfAlunos = new LinkedList<String>();
		this.DepartamentosDoInstituto = new ArrayList<Departamento>();
		this.setCodProfessores(new LinkedList<String>());
		this.cpfProfessores = new LinkedList<String>();
	}

	public void ProcuraMateriasCurso(String codCurso) {

		for (int i = 0; i < CursosDoInstituto.size(); i++) {

			CursosDoInstituto.get(i).getNomeCurso().equals(codCurso);

		}
	}

	public Boolean addAlunoBase(Aluno aluno) {

		if (cpfProfessores.contains(aluno.getCpf()) == true) {

			return false;
		} else {

			if (cpfAlunos.contains(aluno.getCpf()) == true) {

				return false;
			} else {

				AlunosDoInstituto.add(aluno);
				cpfAlunos.add(aluno.getCpf());
				return true;
			}

		}

	}

	public Boolean addProfessorBase(Professor professor) {

		Boolean testa = true;

		if (cpfAlunos.contains(professor.getCpf()) == true) {

			return false;
		} else {

			for (int i = 0; i < ProfessoresDoInstituto.size(); i++) {

				if (ProfessoresDoInstituto.get(i).getCpf().equals(professor.getCpf()) == true) {

					testa = false;
					break;
				}
			}

			if (testa == true) {
				
				
				ProfessoresDoInstituto.add(professor);
				cpfProfessores.add(professor.getCpf());
				codProfessores.add(professor.getCodProfessor());
						
				return true;
			} else {
				return false;
			}

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
		String st = "";

		for (int i = 0; i < CursosDoInstituto.size(); i++) {

			for (int j = 0; j < CursosDoInstituto.get(i).getMATERIAS().size(); j++) {

				st = CursosDoInstituto.get(i).getMATERIAS().get(j).getCodDisciplina() + " "
						+ CursosDoInstituto.get(i).getMATERIAS().get(j).getNomeDisciplina();

				if (st.equals(nomeDisciplina)) {

					CursosDoInstituto.get(i).getMATERIAS().get(j).getTURMAS().get(indexTurma).addAluno(aluno);
					testa = true;
					break;
				}
			}
		}

		if (testa == true) {

			return true;
		} else {

			JOptionPane.showMessageDialog(null, "ERRO - Base - LINHA 172 - NÃO ADICIONADO!");
			return false;
		}

	}

	public Boolean removeProf(String codProf) {

		Boolean testa = false;

		for (int i = 0; i < ProfessoresDoInstituto.size(); i++) {

			String st = ProfessoresDoInstituto.get(i).getCodProfessor();

			if (st.equals(codProf) == true) {

				for (int j = 0; j < ProfessoresDoInstituto.get(i).getMATERIASMINISTRADAS().size(); j++) {

					ProfessoresDoInstituto.get(i).getMATERIASMINISTRADAS().get(j).setCodMinistrador("");
					ProfessoresDoInstituto.get(i).getMATERIASMINISTRADAS().get(j).setStatusDisciplina(false);

				}

				for (int k = 0; k < cpfProfessores.size(); k++) {
					
					if (cpfProfessores.contains(ProfessoresDoInstituto.get(i).getCpf()) == true) {
					
						
						getCpfProfessores().remove(k);
						getCodProfessores().remove(k);
						
						testa = true;
						break;
					}
				}

				ProfessoresDoInstituto.remove(i);
				
			}
		}

		if (testa == true) {
			
			return true;
		} else {
			return false;
		}

	}

	public void addDepartamento(Departamento departamento) {

		DepartamentosDoInstituto.add(departamento);

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

	public LinkedList<String> getCpfProfessores() {
		return cpfProfessores;
	}

	public void setCpfProfessores(LinkedList<String> cpfProfessores) {
		this.cpfProfessores = cpfProfessores;
	}

}
