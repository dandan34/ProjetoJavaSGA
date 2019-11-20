package professorFront;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import membros.Aluno;
import membros.Professor;
import systemBack.Base;
import systemFront.AlterarSenha;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class ControleProf extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JLabel labelNome;
	private JLabel labelCod;
	private Professor ProfessorManipulado;
	private JComboBox<String> comboBoxMaterias;
	private JComboBox<String> comboBoxTurma;
	private JList<String> list;
	private Base BASE;
	private int valor;
	private int valor2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControleProf frame = new ControleProf();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ControleProf() {
		BASE = new Base();
		setBounds(100, 100, 407, 719);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(33, 100, 48, 14);
		contentPane.add(lblNome);

		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(33, 128, 48, 14);
		contentPane.add(lblCodigo);

		labelNome = new JLabel("----");
		labelNome.setBounds(103, 100, 48, 14);
		contentPane.add(labelNome);

		labelCod = new JLabel("----");
		labelCod.setBounds(103, 128, 48, 14);
		contentPane.add(labelCod);

		JLabel lblMateriasMinistradas = new JLabel("Materias Ministradas");
		lblMateriasMinistradas.setBounds(85, 166, 124, 14);
		contentPane.add(lblMateriasMinistradas);

		comboBoxMaterias = new JComboBox<String>();
		comboBoxMaterias.setBackground(new Color(255, 255, 255));
		comboBoxMaterias.setBounds(33, 191, 220, 22);
		contentPane.add(comboBoxMaterias);

		JButton btnSelecao = new JButton("Selecionar");
		btnSelecao.setForeground(new Color(30, 144, 255));
		btnSelecao.setBackground(new Color(255, 255, 255));
		btnSelecao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (comboBoxMaterias.getSelectedIndex() >= 0) {

					setValor(comboBoxMaterias.getSelectedIndex());
					mostrarComboTurma(comboBoxMaterias.getSelectedIndex());

				}

			}
		});
		btnSelecao.setBounds(263, 191, 105, 23);
		contentPane.add(btnSelecao);

		comboBoxTurma = new JComboBox<String>();
		comboBoxTurma.setBackground(new Color(255, 255, 255));
		comboBoxTurma.setBounds(33, 248, 220, 22);
		contentPane.add(comboBoxTurma);

		JLabel lblTurma = new JLabel("Turma");
		lblTurma.setBounds(121, 224, 48, 14);
		contentPane.add(lblTurma);

		JButton btnSelecionar2 = new JButton("Selecioanar");
		btnSelecionar2.setForeground(new Color(30, 144, 255));
		btnSelecionar2.setBackground(new Color(255, 255, 255));
		btnSelecionar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (comboBoxTurma.getSelectedIndex() >= 0) {

					setValor2(comboBoxTurma.getSelectedIndex());
					mostrarListaAlunos(getValor(), comboBoxTurma.getSelectedIndex());
				}

			}
		});
		btnSelecionar2.setBounds(263, 248, 105, 23);
		contentPane.add(btnSelecionar2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 314, 220, 333);
		contentPane.add(scrollPane);

		list = new JList<String>();
		scrollPane.setViewportView(list);

		JLabel lblAlunos = new JLabel("Alunos");
		lblAlunos.setBounds(121, 289, 48, 14);
		contentPane.add(lblAlunos);

		JButton btnControle = new JButton("Controle");
		btnControle.setForeground(new Color(173, 255, 47));
		btnControle.setBackground(new Color(255, 255, 255));
		btnControle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (list.getSelectedIndex() >= 0) {

					SGAPNotas notasControle = new SGAPNotas();
					notasControle.setVisible(true);
					notasControle.setCodDisciplina(
							ProfessorManipulado.getMATERIASMINISTRADAS().get(getValor()).getCodDisciplina() + " "
									+ ProfessorManipulado.getMATERIASMINISTRADAS().get(getValor()).getNomeDisciplina());
					notasControle.setAlunoManipulado(PuxarAluno(list.getSelectedValue()));
					notasControle.mostrarNotas();
					notasControle.mostrarFaltas();

				}

			}
		});
		btnControle.setBounds(263, 314, 105, 23);
		contentPane.add(btnControle);

		JLabel lblPainelDoProfessor = new JLabel("Painel do Professor");
		lblPainelDoProfessor.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPainelDoProfessor.setBounds(101, 52, 231, 37);
		contentPane.add(lblPainelDoProfessor);

		JButton btnVoltar = new JButton("Voltar <<");
		btnVoltar.setForeground(new Color(255, 0, 0));
		btnVoltar.setBackground(new Color(255, 255, 255));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
			}
		});
		btnVoltar.setBounds(10, 11, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnAlterarSenha = new JButton("Alterar Senha");
		btnAlterarSenha.setBackground(new Color(255, 255, 255));
		btnAlterarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AlterarSenha alterarSenha = new AlterarSenha();
				alterarSenha.setVisible(true);
				alterarSenha.setBASE(getBASE());
				alterarSenha.setCpfAutenticador(ProfessorManipulado.getCpf());
				
			}
		});
		btnAlterarSenha.setBounds(103, 11, 118, 23);
		contentPane.add(btnAlterarSenha);
	}

	public Aluno PuxarAluno(String dadosAluno) {

		String st = "";
		st = ProfessorManipulado.getMATERIASMINISTRADAS().get(getValor()).getTURMAS().get(getValor2()).getAlunosTurma()
				.get(list.getSelectedIndex()).getMatricula() + " "
				+ ProfessorManipulado.getMATERIASMINISTRADAS().get(getValor()).getTURMAS().get(getValor2())
						.getAlunosTurma().get(list.getSelectedIndex()).getNome();

		if (st.equals(dadosAluno) == true) {

			return ProfessorManipulado.getMATERIASMINISTRADAS().get(getValor()).getTURMAS().get(getValor2())
					.getAlunosTurma().get(list.getSelectedIndex());

		} else {
			return null;
		}

	}

	public Professor getProfessorManipulado() {
		return ProfessorManipulado;
	}

	public void setProfessorManipulado(Professor professorManipulado) {
		ProfessorManipulado = professorManipulado;
		labelCod.setText(professorManipulado.getCodProfessor());
		labelNome.setText(professorManipulado.getNome());
	}

	public void mostrarComboMaterias() {

		if (ProfessorManipulado.getMINISTRA().isEmpty() == false) {

			String[] st = ProfessorManipulado.imprimeMinistradasNome();

			for (int i = 0; i < ProfessorManipulado.getMINISTRA().size(); i++) {

				comboBoxMaterias.addItem(st[i]);
			}
		}
	}

	public void mostrarComboTurma(int index) {

		if (comboBoxTurma.getItemCount() >= 0) {

			comboBoxTurma.removeAllItems();

		}

		if (ProfessorManipulado.getMATERIASMINISTRADAS().get(index).getTURMAS().size() >= 0) {

			for (int i = 0; i < ProfessorManipulado.getMATERIASMINISTRADAS().get(index).getTURMAS().size(); i++) {

				comboBoxTurma.addItem(
						ProfessorManipulado.getMATERIASMINISTRADAS().get(index).getTURMAS().get(i).getCodigoTurma());

			}
		}
	}

	// controle de prof...
	public void mostrarListaAlunos(int index, int index2) {

		DefaultListModel<String> ls = new DefaultListModel<String>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		String[] st = ProfessorManipulado.getMATERIASMINISTRADAS().get(index).getTURMAS().get(index2)
				.imprimeAlunosTurma();

		for (int i = 0; i < st.length; i++) {

			ls.addElement(st[i]);
		}

		list.setModel(ls);

	}

	public JLabel getLabelNome() {
		return labelNome;
	}

	public void setLabelNome(JLabel labelNome) {
		this.labelNome = labelNome;
	}

	public JLabel getLabelCod() {
		return labelCod;
	}

	public void setLabelCod(JLabel labelCod) {
		this.labelCod = labelCod;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public int getValor2() {
		return valor2;
	}

	public void setValor2(int valor2) {
		this.valor2 = valor2;
	}

	public Base getBASE() {
		return BASE;
	}

	public void setBASE(Base bASE) {
		BASE = bASE;
	}
}
