package systemBack;

import javax.swing.JTextField;

public final class JtextFieldSomenteLetras extends JTextField {
	
	/**
	 *  @author Daniel de Souza Rodrigues 18.2.8112
	 */
	private static final long serialVersionUID = 1L;
	private int maximoCaracteres = -1;

	public JtextFieldSomenteLetras() {
		super();
		addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyTyped(java.awt.event.KeyEvent evt) {
				jTextFieldKeyTyped(evt);
			}
		});
	}

	/*
	 * Determina o tamanho maximo de letras que podem conter no textField
	 * 
	 * @param maximo
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */
	public JtextFieldSomenteLetras(int maximo) {
		super();
		setMaximoCaracteres(maximo);

		addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyTyped(java.awt.event.KeyEvent evt) {
				jTextFieldKeyTyped(evt);
			}
		});
	}

	private void jTextFieldKeyTyped(java.awt.event.KeyEvent evt) {

		String caracteres = "0987654321.,=-+)(*&¨%$#@!}{^`´:;|\"'/<>~_";
		if (caracteres.contains(evt.getKeyChar() + "")) {

			evt.consume();
		}
		if ((getText().length() >= getMaximoCaracteres()) && (getMaximoCaracteres() != -1)) {

			evt.consume();
			setText(getText().substring(0, getMaximoCaracteres()));

		}

	}

	public int getMaximoCaracteres() {
		return maximoCaracteres;
	}

	public void setMaximoCaracteres(int maximoCaracteres) {
		this.maximoCaracteres = maximoCaracteres;
	}
}