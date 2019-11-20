package systemBack;

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

	public Boolean removeAlunoNaTurmaDaDisciplinaBASE(String cpfAluno, String identificadorCodigo) {

		String st = "";
		Boolean testa = false;

		for (int i = 0; i < CursosDoInstituto.size(); i++) {

			for (int j = 0; j < CursosDoInstituto.get(i).getMATERIAS().size(); j++) {

				st = CursosDoInstituto.get(i).getMATERIAS().get(j).getCodDisciplina() + " "
						+ CursosDoInstituto.get(i).getMATERIAS().get(j).getNomeDisciplina();

				if (st.equals(identificadorCodigo)) {

					for (int k = 0; k < CursosDoInstituto.get(i).getMATERIAS().get(j).getTURMAS().size(); k++) {

						for (int l = 0; l < CursosDoInstituto.get(i).getMATERIAS().get(j).getTURMAS().get(k)
								.getAlunosTurma().size(); l++) {

							if (CursosDoInstituto.get(i).getMATERIAS().get(j).getTURMAS().get(k).getAlunosTurma().get(l)
									.getCpf().equals(cpfAluno) == true) {

								CursosDoInstituto.get(i).getMATERIAS().get(j).getTURMAS().get(k).getAlunosTurma()
										.remove(l);

								CursosDoInstituto.get(i).getMATERIAS().get(j).getCodAlunosParticipantes()
										.remove(identificadorCodigo);
								testa = true;
								break;
							}

						}

					}

				}
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
	
	public Boolean removeMateriaDoProf(String codMateria) {
		
		Boolean testa = false;

		for (int i = 0; i < ProfessoresDoInstituto.size(); i++) {

			if(ProfessoresDoInstituto.get(i).getCodProfessor().equals(codMateria) == true){
				
				ProfessoresDoInstituto.get(i).removeMateria(codMateria);
				break;
			}
			
		}

		if (testa == true) {

			return true;
		} else {
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

				cpfProfessores.remove(ProfessoresDoInstituto.get(i).getCpf());
				codProfessores.remove(codProf);

				testa = true;

				ProfessoresDoInstituto.remove(i);

				break;

			}
		}

		if (testa == true) {

			return true;
		} else {
			return false;
		}

	}

	public Boolean removeCurso(String nomeCurso) {

		Boolean testa = false;

		for (int i = 0; i < CursosDoInstituto.size(); i++) {

			if (CursosDoInstituto.get(i).getNomeCurso().equals(nomeCurso)) {

				for (int j = 0; j < CursosDoInstituto.get(i).getALUNOS().size(); j++) {

					CursosDoInstituto.get(i).getALUNOS().get(j).setNomeCursoCursado("");
					CursosDoInstituto.get(i).getALUNOS().get(j).setStatus(false);
					CursosDoInstituto.get(i).getALUNOS().get(j).removeALLDisciplina();

					// implementar o resto do removeCurso.. lembrar de tirar da base! tirar turmas e
					// o professor responsavel pelas materias.

				}

				for (int k = 0; k < CursosDoInstituto.get(i).getMATERIAS().size(); k++) {

					buscarMateriaProf(CursosDoInstituto.get(i).getMATERIAS().get(k).getCodMinistrador(),
							CursosDoInstituto.get(i).getMATERIAS().get(k).getCodDisciplina());

				}

				CursosDoInstituto.remove(i);
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

	public void buscarMateriaProf(String codProfessor, String codMateria) {

		for (int i = 0; i < ProfessoresDoInstituto.size(); i++) {

			for (int j = 0; j < ProfessoresDoInstituto.get(i).getMATERIASMINISTRADAS().size(); j++) {

				if (ProfessoresDoInstituto.get(i).getMATERIASMINISTRADAS().get(j).getCodDisciplina()
						.equals(codMateria) == true) {

					if (ProfessoresDoInstituto.get(i).getMATERIASMINISTRADAS().get(j).getCodMinistrador()
							.equals(codProfessor) == true) {

						for (int k = 0; k < ProfessoresDoInstituto.get(i).getMATERIASMINISTRADAS().get(j).getTURMAS()
								.size(); k++) {

							ProfessoresDoInstituto.get(i).getMATERIASMINISTRADAS().get(k).getTURMAS().remove(k);
						}

						ProfessoresDoInstituto.get(i).getMINISTRA().remove(codMateria);

						ProfessoresDoInstituto.get(i).getMATERIASMINISTRADAS().remove(j);

					}
				}
			}

		}

	}

	public Boolean mudarSenha(String cpfMudador, String senhaAtual, String novaSenha) {

		Boolean testa = false;
		
		if (cpfAlunos.contains(cpfMudador) == true) {

			for (int i = 0; i < AlunosDoInstituto.size(); i++) {

				if (AlunosDoInstituto.get(i).getCpf().equals(cpfMudador) == true) {

					if (AlunosDoInstituto.get(i).getUSUARIO().getSenha().equals(senhaAtual) == true) {

						AlunosDoInstituto.get(i).getUSUARIO().setSenha(novaSenha);
						testa = true;
						break;
					}
				}
			}

		} else {

			for (int i = 0; i < ProfessoresDoInstituto.size(); i++) {

				if (ProfessoresDoInstituto.get(i).getCpf().equals(cpfMudador) == true) {

					if (ProfessoresDoInstituto.get(i).getUSUARIO().getSenha().equals(senhaAtual) == true) {

						ProfessoresDoInstituto.get(i).getUSUARIO().setSenha(novaSenha);
						testa=true;
						break;
					}
				}
			}

		}
		
		if(testa == true) {
			return true;
			
		}else {
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
