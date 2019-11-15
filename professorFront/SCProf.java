package professorFront;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import academicoBack.Curso;
import membros.Professor;

import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Color;

public class SCProf extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Professor professorManipulado;

	private JLabel labelNome;
	private JLabel label_Dpto;
	private JLabel label_Codigo;
	private JLabel label_cpf;
	private JList<String> list;
	private JList<String> list_1;
	private JComboBox<String> comboBox;
	private Integer indexL1;
	private Integer cursoSelect;

	private ArrayList<Curso> cursosManipulados;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SCProf frame = new SCProf();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SCProf() {

		this.cursosManipulados = new ArrayList<Curso>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 261, 207, 228);
		contentPane.add(scrollPane);

		list = new JList<String>();
		scrollPane.setViewportView(list);

		JLabel lblAlunosDisciplina = new JLabel("Disciplina do Curso");
		lblAlunosDisciplina.setBounds(53, 211, 126, 14);
		contentPane.add(lblAlunosDisciplina);

		JLabel lblDPT = new JLabel("DPTO:");
		lblDPT.setBounds(10, 45, 48, 14);
		contentPane.add(lblDPT);

		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(10, 64, 48, 14);
		contentPane.add(lblCodigo);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(10, 84, 48, 14);
		contentPane.add(lblCpf);

		JLabel lblProfessor = new JLabel("Professor:");
		lblProfessor.setBounds(123, 7, 84, 14);
		contentPane.add(lblProfessor);

		labelNome = new JLabel("----");
		labelNome.setForeground(new Color(255, 0, 0));
		labelNome.setBounds(197, 7, 193, 14);
		contentPane.add(labelNome);

		label_Dpto = new JLabel("----");
		label_Dpto.setBounds(68, 45, 139, 14);
		contentPane.add(label_Dpto);

		label_Codigo = new JLabel("----");
		label_Codigo.setBounds(68, 64, 131, 14);
		contentPane.add(label_Codigo);

		label_cpf = new JLabel("----");
		label_cpf.setBounds(68, 84, 131, 14);
		contentPane.add(label_cpf);

		JButton btnAdicionarMateria = new JButton("Adicionar");
		btnAdicionarMateria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (list.getSelectedIndex() >= 0) {

					if (cursosManipulados.get(comboBox.getSelectedIndex()).getDisciplinaIndex(list.getSelectedIndex())
							.getCodMinistrador() == null) {

						professorManipulado.addMateria(
								cursosManipulados.get(comboBox.getSelectedIndex())
										.getDisciplinaIndex(list.getSelectedIndex()).getCodDisciplina(),
								cursosManipulados.get(comboBox.getSelectedIndex())
										.getDisciplinaIndex(list.getSelectedIndex()));

						cursosManipulados.get(comboBox.getSelectedIndex()).getDisciplinaIndex(list.getSelectedIndex())
								.setCodMinistrador(professorManipulado.getCodProfessor());

						mostrarListaMinistradas();

					} else {

						JOptionPane.showMessageDialog(null,
								"Disciplina já possui um professor - CODIGO DO PROFESSOR:"
										+ cursosManipulados.get(comboBox.getSelectedIndex())
												.getDisciplinaIndex(list.getSelectedIndex()).getCodMinistrador());
					}

				}

			}
		});
		btnAdicionarMateria.setBackground(new Color(255, 255, 255));
		btnAdicionarMateria.setForeground(new Color(0, 0, 255));
		btnAdicionarMateria.setBounds(231, 259, 99, 23);
		contentPane.add(btnAdicionarMateria);

		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.setBackground(new Color(255, 255, 255));
		btnSelecionar.setForeground(new Color(0, 0, 255));
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (comboBox.getSelectedIndex() >= 0) {

					setCursoSelect(comboBox.getSelectedIndex());
					mostrarListaDisciplinas(cursosManipulados.get(comboBox.getSelectedIndex()));

				}

			}
		});
		btnSelecionar.setBounds(231, 139, 99, 23);
		contentPane.add(btnSelecionar);

		JLabel lblDisciplinasDoDepartamento = new JLabel("Cursos do Departamento");
		lblDisciplinasDoDepartamento.setBounds(95, 109, 177, 14);
		contentPane.add(lblDisciplinasDoDepartamento);

		JButton btnVoltar = new JButton("Voltar <<");
		btnVoltar.setBackground(new Color(255, 255, 255));
		btnVoltar.setForeground(new Color(255, 0, 0));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVoltar.setBounds(10, 7, 89, 23);
		contentPane.add(btnVoltar);

		setComboBox(new JComboBox<String>());
		getComboBox().setBounds(10, 139, 207, 22);
		contentPane.add(getComboBox());

		JLabel lblCodigo_1 = new JLabel("Codigo:");
		lblCodigo_1.setBounds(12, 236, 46, 14);
		contentPane.add(lblCodigo_1);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(107, 236, 46, 14);
		contentPane.add(lblNome);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(412, 7, 332, 493);
		contentPane.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 251, 191, 231);
		panel.add(scrollPane_1);

		list_1 = new JList<String>();
		scrollPane_1.setViewportView(list_1);

		JButton btnVisualizar_1 = new JButton("Visualizar");
		btnVisualizar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (list_1.getSelectedIndex() >= 0) {

					SCAProf MateriaManipulada = new SCAProf();

					if (professorManipulado.getMATERIASMINISTRADAS().size() >= 0) {
						MateriaManipulada.setMateriaMinistrada(
								professorManipulado.getMATERIASMINISTRADAS().get(list_1.getSelectedIndex()));
					}

					MateriaManipulada.setVisible(true);

				}

			}
		});
		btnVisualizar_1.setBackground(new Color(255, 255, 255));
		btnVisualizar_1.setForeground(new Color(0, 0, 255));
		btnVisualizar_1.setBounds(219, 249, 103, 23);
		panel.add(btnVisualizar_1);

		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (list_1.getSelectedIndex() >= 0) {

					removeMinistrador(list_1.getSelectedValue());
					removeDisciplinaProfManipulado(list_1.getSelectedIndex());
					mostrarListaMinistradas();

				}

			}
		});
		btnDeletar.setBackground(new Color(255, 255, 255));
		btnDeletar.setForeground(Color.RED);
		btnDeletar.setBounds(219, 282, 103, 23);
		panel.add(btnDeletar);

		JLabel lblMateriasMinistradas = new JLabel("Materias Ministradas");
		lblMateriasMinistradas.setBounds(120, 194, 120, 14);
		panel.add(lblMateriasMinistradas);

		JLabel lblNome_1 = new JLabel("Codigo:");
		lblNome_1.setBounds(10, 226, 46, 14);
		panel.add(lblNome_1);

		JLabel lblNome_2 = new JLabel("Nome:");
		lblNome_2.setBounds(93, 226, 46, 14);
		panel.add(lblNome_2);

	}

	public Professor getProfessorManipulado() {
		return professorManipulado;
	}

	public void setProfessorManipulado(Professor professorManipulado) {
		this.professorManipulado = professorManipulado;
		labelNome.setText(professorManipulado.getNome());
		label_Codigo.setText(professorManipulado.getCodProfessor());
		label_Dpto.setText(professorManipulado.getCodigoDepartamento());
		label_cpf.setText(professorManipulado.getCpf());
		comboBox.setSelectedIndex(-1);

	}

	public void setCursosDPdoProf(ArrayList<Curso> cursosDoDP) {

		if (cursosDoDP.size() >= 0) {

			String[] st = new String[cursosDoDP.size()];

			for (int i = 0; i < st.length; i++) {

				st[i] = cursosDoDP.get(i).getNomeCurso();
			}

			for (int i = 0; i < st.length; i++) {
				comboBox.addItem(st[i]);
			}

		} else {
			JOptionPane.showMessageDialog(null, "ERRO CURSOS DP PROF ");
		}
	}

	public void mostrarListaDisciplinas(Curso manipulado) {

		DefaultListModel<String> ls = new DefaultListModel<String>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		String[] st = manipulado.imprimeMaterias();

		for (int i = 0; i < st.length; i++) {

			ls.addElement(st[i]);
		}

		list.setModel(ls);

	}

	public void mostrarListaMinistradas() {

		DefaultListModel<String> ls = new DefaultListModel<String>();
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		String[] st = professorManipulado.imprimeMinistradas();

		for (int i = 0; i < st.length; i++) {

			ls.addElement(st[i]);
		}

		list_1.setModel(ls);

	}

	public void removeDisciplinaProfManipulado(int index) {

		if (professorManipulado.removeMateriaIndex(index) == true) {

			JOptionPane.showMessageDialog(null, "Materia removida com sucesso!");

		} else {
			JOptionPane.showMessageDialog(null, "ERRO NA REMOÇÃO!!!");
		}
	}

	public void removeMinistrador(String codigo) {

		for (int i = 0; i < cursosManipulados.size(); i++) {

			int aux = cursosManipulados.get(i).getMATERIAS().size();

			for (int j = 0; j < aux; j++) {

				if (cursosManipulados.get(i).getMATERIAS().get(j).getCodDisciplina().equals(codigo) == true) {

					cursosManipulados.get(i).getMATERIAS().get(j).setCodMinistrador(null);
					break;
				}
			}

		}
	}

	public JLabel getLabel_cpf() {
		return label_cpf;
	}

	public void setLabel_cpf(JLabel label_cpf) {
		this.label_cpf = label_cpf;
	}

	public JLabel getLabel_Dpto() {
		return label_Dpto;
	}

	public void setLabel_Dpto(JLabel label_Dpto) {
		this.label_Dpto = label_Dpto;
	}

	public JLabel getLabelNome() {
		return labelNome;
	}

	public void setLabelNome(JLabel labelNome) {
		this.labelNome = labelNome;
	}

	public JLabel getLabel_Codigo() {
		return label_Codigo;
	}

	public void setLabel_Codigo(JLabel label_Codigo) {
		this.label_Codigo = label_Codigo;
	}

	public JComboBox<String> getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox<String> comboBox) {
		this.comboBox = comboBox;
	}

	public ArrayList<Curso> getCursosManipulados() {
		return cursosManipulados;
	}

	public void setCursosManipulados(ArrayList<Curso> cursosManipulados) {
		this.cursosManipulados = cursosManipulados;
	}

	public int getIndexL1() {
		return indexL1;
	}

	public void setIndexL1(int indexL1) {
		this.indexL1 = indexL1;
	}

	public Integer getCursoSelect() {
		return cursoSelect;
	}

	public void setCursoSelect(Integer cursoSelect) {
		this.cursoSelect = cursoSelect;
	}
}
