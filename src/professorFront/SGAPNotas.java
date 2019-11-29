package professorFront;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import membros.Aluno;
import systemBack.JtextFieldSomenteNumeros;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class SGAPNotas extends JFrame {
	
	/**
	 *  @author Daniel de Souza Rodrigues 18.2.8112
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textADDNOTA;
	private JList<String> list;
	private JLabel labelAlunoNome;
	private JLabel labelMatricula;
	private JLabel labelFALTAS;
	private Aluno alunoManipulado;
	private JButton buttonADD;
	private JButton buttonSUB;
	private String codDisciplina;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SGAPNotas frame = new SGAPNotas();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SGAPNotas() {
		this.alunoManipulado = new Aluno("", "", "", "");
		setBounds(100, 100, 274, 432);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAluno = new JLabel("Aluno:");
		lblAluno.setBounds(10, 59, 48, 14);
		contentPane.add(lblAluno);

		labelAlunoNome = new JLabel("----");
		labelAlunoNome.setBounds(68, 59, 161, 14);
		contentPane.add(labelAlunoNome);

		JLabel lblNotas = new JLabel("Notas");
		lblNotas.setBounds(70, 191, 48, 14);
		contentPane.add(lblNotas);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 216, 89, 156);
		contentPane.add(scrollPane);

		list = new JList<String>();
		scrollPane.setViewportView(list);

		JButton btnApagar = new JButton("Apagar");
		btnApagar.setBackground(new Color(255, 255, 255));
		btnApagar.setForeground(new Color(255, 0, 0));
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (list.getSelectedIndex() >= 0) {
					apagarNota(list.getSelectedIndex());
				}

			}
		});
		btnApagar.setBounds(140, 214, 89, 23);
		contentPane.add(btnApagar);

		textADDNOTA = new JtextFieldSomenteNumeros(3);
		textADDNOTA.setBounds(41, 160, 89, 20);
		contentPane.add(textADDNOTA);
		textADDNOTA.setColumns(10);

		JLabel lblNota = new JLabel("Nota:");
		lblNota.setBounds(10, 161, 48, 14);
		contentPane.add(lblNota);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBackground(new Color(255, 255, 255));
		btnAdicionar.setForeground(new Color(100, 149, 237));
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (textADDNOTA.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Campo NOTA vazio!");

				} else {

					addNota(Float.parseFloat(textADDNOTA.getText()));
					textADDNOTA.setText("");
				}

			}
		});
		btnAdicionar.setBounds(140, 157, 89, 23);
		contentPane.add(btnAdicionar);

		JLabel lblFaltas = new JLabel("Faltas:");
		lblFaltas.setBounds(10, 124, 48, 14);
		contentPane.add(lblFaltas);

		labelFALTAS = new JLabel("----");
		labelFALTAS.setBounds(70, 124, 48, 14);
		contentPane.add(labelFALTAS);

		buttonADD = new JButton("+");
		buttonADD.setBackground(new Color(128, 128, 128));
		buttonADD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				addfalta();
				mostrarFaltas();
			}
		});
		buttonADD.setBounds(140, 120, 41, 23);
		contentPane.add(buttonADD);

		buttonSUB = new JButton("-");
		buttonSUB.setBackground(new Color(192, 192, 192));
		buttonSUB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				subfalta();
				mostrarFaltas();
			}
		});
		buttonSUB.setBounds(188, 120, 41, 23);
		contentPane.add(buttonSUB);

		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setBounds(10, 84, 79, 14);
		contentPane.add(lblMatricula);

		labelMatricula = new JLabel("----");
		labelMatricula.setBounds(68, 84, 180, 14);
		contentPane.add(labelMatricula);

		JButton btnVoltar = new JButton("Voltar <<");
		btnVoltar.setBackground(new Color(255, 255, 255));
		btnVoltar.setForeground(new Color(255, 0, 0));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnVoltar.setBounds(10, 11, 89, 23);
		contentPane.add(btnVoltar);

	}

	/*
	 * Apaga a nota do aluno manipulado
	 * 
	 * @param index
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */
	public void apagarNota(int index) {

		for (int i = 0; i < alunoManipulado.getNOTAS().size(); i++) {

			if (alunoManipulado.getNOTAS().get(i).getCodDisciplina().equals(getCodDisciplina()) == true) {

				alunoManipulado.getNOTAS().get(i).removenota(index);
				break;
			}
		}

		mostrarNotas();

	}
	/*
	 * Adiciona falta ao aluno manipulado
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */

	public void addfalta() {

		for (int i = 0; i < alunoManipulado.getNOTAS().size(); i++) {

			if (alunoManipulado.getNOTAS().get(i).getCodDisciplina().equals(getCodDisciplina()) == true) {

				alunoManipulado.getNOTAS().get(i).setFaltas(alunoManipulado.getNOTAS().get(i).getFaltas() + 1);
				break;
			}
		}
	}
	/*
	 * subtrai falta do aluno manipulado
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */

	public void subfalta() {

		for (int i = 0; i < alunoManipulado.getNOTAS().size(); i++) {

			if (alunoManipulado.getNOTAS().get(i).getCodDisciplina().equals(getCodDisciplina()) == true) {

				if (alunoManipulado.getNOTAS().get(i).getFaltas() > 0) {

					alunoManipulado.getNOTAS().get(i).setFaltas(alunoManipulado.getNOTAS().get(i).getFaltas() - 1);
					break;
				}

			}
		}
	}

	/*
	 * Adiciona nota ao aluno manipulado
	 * 
	 * @param nota
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */
	public void addNota(float nota) {

		for (int i = 0; i < alunoManipulado.getNOTAS().size(); i++) {

			if (alunoManipulado.getNOTAS().get(i).getCodDisciplina().equals(getCodDisciplina()) == true) {

				alunoManipulado.getNOTAS().get(i).addNota(nota);
				break;
			}
		}

		mostrarNotas();
	}

	/*
	 * Remove nota do aluno manipulado
	 * 
	 * @param index
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */
	public void removeNota(int index) {

		for (int i = 0; i < alunoManipulado.getNOTAS().size(); i++) {

			if (alunoManipulado.getNOTAS().get(i).getCodDisciplina().equals(getCodDisciplina()) == true) {

				alunoManipulado.getNOTAS().get(i).removenota(index);
				break;
			}
		}

		mostrarNotas();
	}

	/*
	 * Mostra faltas do aluno manipulado
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112s
	 */
	public void mostrarFaltas() {

		for (int i = 0; i < alunoManipulado.getNOTAS().size(); i++) {

			if (alunoManipulado.getNOTAS().get(i).getCodDisciplina().equals(getCodDisciplina()) == true) {

				labelFALTAS.setText(" " + alunoManipulado.getNOTAS().get(i).getFaltas());
				break;
			} else {

				JOptionPane.showMessageDialog(null, alunoManipulado.getNOTAS().get(i).getCodDisciplina());
			}
		}
	}

	/*
	 * Mostra notas do aluno manipulado
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */
	public void mostrarNotas() {

		String[] st = new String[4];

		for (int i = 0; i < alunoManipulado.getNOTAS().size(); i++) {

			if (alunoManipulado.getNOTAS().get(i).getCodDisciplina().equals(getCodDisciplina()) == true) {

				st = alunoManipulado.getNOTAS().get(i).imprimeNotas();
				break;

			}
		}

		DefaultListModel<String> ls = new DefaultListModel<String>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		for (int i = 0; i < st.length; i++) {

			ls.addElement(st[i]);
		}

		list.setModel(ls);

	}

	public Aluno getAlunoManipulado() {
		return alunoManipulado;
	}

	/*
	 * Atribui dados do aluno a interface
	 * 
	 * @param alunoManipulado
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */
	public void setAlunoManipulado(Aluno alunoManipulado) {
		this.alunoManipulado = alunoManipulado;

		labelAlunoNome.setText(alunoManipulado.getNome());
		labelMatricula.setText("" + alunoManipulado.getMatricula());

	}

	public JTextField getTextADDNOTA() {
		return textADDNOTA;
	}

	public void setTextADDNOTA(JTextField textADDNOTA) {
		this.textADDNOTA = textADDNOTA;
	}

	public JLabel getLabelAlunoNome() {
		return labelAlunoNome;
	}

	public void setLabelAlunoNome(JLabel labelAlunoNome) {
		this.labelAlunoNome = labelAlunoNome;
	}

	public JLabel getLabelMatricula() {
		return labelMatricula;
	}

	public void setLabelMatricula(JLabel labelMatricula) {
		this.labelMatricula = labelMatricula;
	}

	public String getCodDisciplina() {
		return codDisciplina;
	}

	public void setCodDisciplina(String codDisciplina) {
		this.codDisciplina = codDisciplina;
	}

	public JButton getButtonADD() {
		return buttonADD;
	}

	public void setButtonADD(JButton buttonADD) {
		this.buttonADD = buttonADD;
	}

	public JList<String> getList() {
		return list;
	}

	public void setList(JList<String> list) {
		this.list = list;
	}

	public JLabel getLabelFALTAS() {
		return labelFALTAS;
	}

	public void setLabelFALTAS(JLabel labelFALTAS) {
		this.labelFALTAS = labelFALTAS;
	}

	public JButton getButtonSUB() {
		return buttonSUB;
	}

	public void setButtonSUB(JButton buttonSUB) {
		this.buttonSUB = buttonSUB;
	}
}
