package academicoBack;

public class HistoricoAluno {
	
	private String codDisciplina;
	private float[] notas;
	private int faltas;

	public HistoricoAluno() {
		
		this.codDisciplina = "";
		this.notas = new float[4];
		this.faltas = 0;
	}

	public String[] imprimeNotas() {
		
		String[] st = new String[notas.length + 1];

		for (int i = 0; i < notas.length; i++) {
			st[i] = "Nota: " + this.notas[i];
		}

		st[notas.length + 1] = "Faltas: " + this.faltas;

		return st;

	}

	public String imprimeNotaEspecifica(int index) {

		String st;
		st = "Nota " + index + ": " + notas[index];
		return st;
	}

	public Boolean addNota(int index, float nota) {

		if (index > notas.length) {
			return false;
		} else {
			notas[index] = nota;
			return true;
		}

	}

	public float[] getNotas() {
		return notas;
	}

	public int getFaltas() {
		return faltas;
	}

	public void setFaltas(int faltas) {
		this.faltas = faltas;
	}

	public void setNotas(float[] notas) {
		this.notas = notas;
	}

	public String getCodDisciplina() {
		return codDisciplina;
	}

	public void setCodDisciplina(String codDisciplina) {
		this.codDisciplina = codDisciplina;
	}

}
