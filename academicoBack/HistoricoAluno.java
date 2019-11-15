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
	
	public String imprimeFaltas() {
		
		String faltas = "" + this.faltas;
		
		return faltas;
		
	}
	public String[] imprimeNotas() {

		String[] st = new String[notas.size()];

		for (int i = 0; i < notas.size(); i++) {
			st[i] = "Nota: " + this.notas.get(i);
		}

		return st;

	}

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
