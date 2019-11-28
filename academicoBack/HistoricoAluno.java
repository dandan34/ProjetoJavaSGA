package academicoBack;

import java.util.ArrayList;

public class HistoricoAluno {

	private String codDisciplina;
	private ArrayList<Float> notas;
	private int faltas;

	public HistoricoAluno(String codDisciplina) {

		this.codDisciplina = codDisciplina;
		this.notas = new ArrayList<Float>();
		this.faltas = 0;
		this.notas = new ArrayList<Float>();
	}
	/*
	 * Armazena em todas as faltas em uma String
	 * 
	 * @return String
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */

	public String imprimeFaltas() {

		String faltas = "" + this.faltas;

		return faltas;

	}

	/*
	 * Armazena todas as notas em um Array
	 * 
	 * @return String[]
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */
	public String[] imprimeNotas() {

		String[] st = new String[notas.size()];

		for (int i = 0; i < notas.size(); i++) {
			st[i] = "Nota: " + this.notas.get(i);
		}

		return st;

	}

	/*
	 * Imprime uma nota especifica baseado em um index
	 * 
	 * @param index
	 * 
	 * @return String
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */
	public String imprimeNotaEspecifica(int index) {

		String st;
		st = "Nota " + index + ": " + notas.get(index);
		return st;
	}

	public void addNota(float nota) {

		notas.add(nota);

	}

	public void removenota(int index) {

		notas.remove(index);
	}

	public int getFaltas() {
		return faltas;
	}

	public void setFaltas(int faltas) {
		this.faltas = faltas;
	}

	public String getCodDisciplina() {
		return codDisciplina;
	}

	public void setCodDisciplina(String codDisciplina) {
		this.codDisciplina = codDisciplina;
	}

}
