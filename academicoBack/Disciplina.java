package academicoBack;

import java.util.ArrayList;
import java.util.LinkedList;

public class Disciplina {

	private String nomeDisciplina;
	private String codDisciplina;
	private String codMinistrador;
	private Boolean StatusDisciplina;

	private LinkedList<String> codAlunosParticipantes;
	private ArrayList<Turma> TURMAS;

	public Disciplina(String nome, String cod) {

		setStatusDisciplina(false);
		this.nomeDisciplina = nome;
		this.codDisciplina = cod;
		this.setCodAlunosParticipantes(new LinkedList<String>());
		this.TURMAS = new ArrayList<Turma>();
	}

	public Boolean addAlunoNaDisciplina(String codigo) {

		if (codAlunosParticipantes.contains(codigo) == true) {

			return false;
		} else {
			codAlunosParticipantes.add(codigo);
			return true;
		}
	}

	public Boolean removeAluno(int index) {

		if (index >= 0) {

			codAlunosParticipantes.remove(index);
			return true;
		} else {
			return false;
		}
	}

	public Boolean addProfessorNaDisciplina(String codProf) {

		if (codMinistrador.equals("")) {

			setCodMinistrador(codProf);
			setStatusDisciplina(true);
			return true;
		} else {
			return false;
		}

	}

	public Boolean removeProfesorNaDisciplina() {

		if (getCodMinistrador().equals("")) {

			return false;
		} else {
			setCodMinistrador("");
			setStatusDisciplina(false);
			return true;
		}
	}

	public Boolean addTurma(Turma turma) {

		Boolean testa = true;

		for (int i = 0; i < TURMAS.size(); i++) {

			if (TURMAS.get(i).getCodigoTurma().equals(turma.getCodigoTurma()) == true) {

				testa = false;
				break;

			}
		}

		if (testa == true) {

			TURMAS.add(turma);
			return true;
		} else {
			return false;
		}

	}

	public Boolean removeTurma(int index) {

		if (TURMAS.size() >= index) {
			
			for(int i=0;i< TURMAS.get(index).getAlunosTurma().size();i++){
				
				if(TURMAS.get(index).getAlunosTurma().get(i).getCURSANDO().contains(getCodDisciplina()+" "+ getNomeDisciplina()) == true) {
					
					TURMAS.get(index).getAlunosTurma().get(i).getCURSANDO().remove(getCodDisciplina()+" "+ getNomeDisciplina());
				}
				
			}
			TURMAS.remove(index);
			return true;
		} else {
			return false;
		}

	}

	public String[] imprimeTURMA() {
	
		String[] st = new String[TURMAS.size()];

		for (int i = 0; i < TURMAS.size(); i++) {

			st[i] = TURMAS.get(i).getCodigoTurma();
		}

		return st;

	}
	
	public void setNullMinistrador() {
		
		setCodMinistrador(null);
	}
	public void setNULL() {
		
		setCodAlunosParticipantes(null);
		setCodDisciplina(null);
		setCodMinistrador(null);
		setNomeDisciplina(null);
		setTURMAS(null);
		setStatusDisciplina(false);
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public String getCodDisciplina() {
		return codDisciplina;
	}

	public void setCodDisciplina(String codDisciplina) {
		this.codDisciplina = codDisciplina;
	}

	public String getCodMinistrador() {
		return codMinistrador;
	}

	public void setCodMinistrador(String codMinistrador) {
		this.codMinistrador = codMinistrador;
	}

	public Boolean getStatusDisciplina() {
		return StatusDisciplina;
	}

	public void setStatusDisciplina(Boolean statusDisciplina) {
		StatusDisciplina = statusDisciplina;
	}

	public LinkedList<String> getCodAlunosParticipantes() {
		return codAlunosParticipantes;
	}

	public void setCodAlunosParticipantes(LinkedList<String> codAlunosParticipantes) {
		this.codAlunosParticipantes = codAlunosParticipantes;
	}

	public ArrayList<Turma> getTURMAS() {
		return TURMAS;
	}

	public void setTURMAS(ArrayList<Turma> tURMAS) {
		TURMAS = tURMAS;
	}
}
