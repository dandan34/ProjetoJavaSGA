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

	/*
	 * Adiciona um Aluno na disciplina
	 * 
	 * @param codigo
	 * 
	 * @return boolean
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */
	public Boolean addAlunoNaDisciplina(String codigo) {

		if (codAlunosParticipantes.contains(codigo) == true) {

			return false;
		} else {
			codAlunosParticipantes.add(codigo);
			return true;
		}
	}

	/*
	 * remove aluno da disciplina baseado no index
	 * 
	 * @param index
	 * 
	 * @return boolean
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */
	public Boolean removeAluno(int index) {

		if (index >= 0) {

			codAlunosParticipantes.remove(index);
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Adiciona professor na disciplina
	 * 
	 * @param codProf
	 * 
	 * @return boolean
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */
	public Boolean addProfessorNaDisciplina(String codProf) {

		if (codMinistrador.equals("")) {

			setCodMinistrador(codProf);
			setStatusDisciplina(true);
			return true;
		} else {
			return false;
		}

	}
	/*
	 * Remove professor atual da disciplina
	 * 
	 * @return boolean
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */

	public Boolean removeProfesorNaDisciplina() {

		if (getCodMinistrador().equals("")) {

			return false;
		} else {
			setCodMinistrador("");
			setStatusDisciplina(false);
			return true;
		}
	}

	/*
	 * Adiciona Turma na disciplina
	 * 
	 * @param turma
	 * 
	 * @return boolean
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */
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

	/*
	 * Remove turma da disciplina
	 * 
	 * @param index
	 * 
	 * @return boolean
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */
	public Boolean removeTurma(int index) {

		if (TURMAS.size() >= index) {

			for (int i = 0; i < TURMAS.get(index).getAlunosTurma().size(); i++) {

				if (TURMAS.get(index).getAlunosTurma().get(i).getCURSANDO()
						.contains(getCodDisciplina() + " " + getNomeDisciplina()) == true) {

					TURMAS.get(index).getAlunosTurma().get(i).getCURSANDO()
							.remove(getCodDisciplina() + " " + getNomeDisciplina());
				}

			}
			TURMAS.remove(index);
			return true;
		} else {
			return false;
		}

	}
	/*
	 * Armazena todas as turmas da disciplina em um Array
	 * 
	 * @return String[]
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */

	public String[] imprimeTURMA() {

		String[] st = new String[TURMAS.size()];

		for (int i = 0; i < TURMAS.size(); i++) {

			st[i] = TURMAS.get(i).getCodigoTurma();
		}

		return st;

	}
	/*
	 * Acrescenta null ao valor do ministrador
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 *
	 */

	public void setNullMinistrador() {

		setCodMinistrador(null);
	}
	/*
	 * Acrescenta null a todos os paraetros da disciplina
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */

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
