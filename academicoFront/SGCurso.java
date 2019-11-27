package academicoFront;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.event.ListSelectionListener;

import academicoBack.Curso;
import systemBack.Base;
import systemBack.JtextFieldSomenteLetras;
import systemBack.JtextFieldSomenteNumeros;

import javax.swing.event.ListSelectionEvent;
import java.awt.SystemColor;

public class SGCurso extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNomeMateria;
	private JTextField textCodMateria;
	private JLabel labelCURSO;

	private JList<String> list;
	private JList<String> list_1;

	private int index;
	private Curso cursoManipulado;

	private Base BASE;

	public void mostrarListaMaterias() {

		if (cursoManipulado.getMATERIAS().size() >= 0) {

			DefaultListModel<String> ls = new DefaultListModel<String>();
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			String[] st = cursoManipulado.imprimeMaterias();

			for (int i = 0; i < st.length; i++) {

				ls.addElement(st[i]);
			}

			list.setModel(ls);

		}
	}

	public void mostrarListaAlunos() {

		if (cursoManipulado.getMATERIAS().size() >= 0) {

			DefaultListModel<String> ls = new DefaultListModel<String>();
			list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			String[] st = cursoManipulado.imprimeAlunos();

			for (int i = 0; i < st.length; i++) {

				ls.addElement(st[i]);
			}

			list_1.setModel(ls);

		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SGCurso frame = new SGCurso();
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
	public SGCurso() {
		this.BASE = new Base();
		setBounds(100, 100, 671, 510);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 0, 0));
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblGerenciadorDoCurso = new JLabel("Gerenciador do Curso");
		lblGerenciadorDoCurso.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblGerenciadorDoCurso.setBounds(109, 10, 153, 14);
		contentPane.add(lblGerenciadorDoCurso);

		this.labelCURSO = new JLabel("-----");
		labelCURSO.setForeground(new Color(255, 0, 0));
		labelCURSO.setFont(new Font("Times New Roman", Font.BOLD, 14));
		labelCURSO.setBounds(249, 11, 87, 14);
		contentPane.add(labelCURSO);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 222, 167, 229);
		contentPane.add(scrollPane);

		list = new JList<String>();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {

				setIndex(list.getSelectedIndex());
			}
		});
		scrollPane.setViewportView(list);

		JButton btnAcessarMateria = new JButton("Acessar");
		btnAcessarMateria.setBackground(new Color(255, 255, 255));
		btnAcessarMateria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (list.getSelectedIndex() >= 0) {

					SGTurma turma = new SGTurma();
					turma.setMateriaManipulada(cursoManipulado.getDisciplinaIndex(list.getSelectedIndex()));
					turma.mostrarListaTurmas();
					turma.setBASE(getBASE());
					turma.setVisible(true);

				}

			}
		});
		btnAcessarMateria.setForeground(Color.BLUE);
		btnAcessarMateria.setBounds(187, 220, 89, 23);
		contentPane.add(btnAcessarMateria);

		JButton btnDeletarMateria = new JButton("Deletar");
		btnDeletarMateria.setBackground(new Color(255, 255, 255));
		btnDeletarMateria.setForeground(Color.RED);
		btnDeletarMateria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (list.getSelectedIndex() >= 0) {

					BASE.removeMateriaDoProf(cursoManipulado.getMATERIAS().get(list.getSelectedIndex()).getCodMinistrador(),
							cursoManipulado.getMATERIAS().get(list.getSelectedIndex()).getCodDisciplina(), cursoManipulado.getCodDepartamentoResponsavel());
					
					cursoManipulado.removeMateriaIndex(getIndex());

					mostrarListaMaterias();
				}

			}
		});
		btnDeletarMateria.setBounds(187, 245, 89, 23);
		contentPane.add(btnDeletarMateria);

		textNomeMateria = new JtextFieldSomenteLetras(15);
		textNomeMateria.setBounds(56, 83, 220, 20);
		contentPane.add(textNomeMateria);
		textNomeMateria.setColumns(10);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 86, 48, 14);
		contentPane.add(lblNome);

		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 117, 48, 14);
		contentPane.add(lblCodigo);

		textCodMateria = new JtextFieldSomenteNumeros(4);
		textCodMateria.setBounds(56, 114, 220, 20);
		contentPane.add(textCodMateria);
		textCodMateria.setColumns(10);

		JButton btnAdicionarMateria = new JButton("Adicionar");
		btnAdicionarMateria.setBackground(new Color(255, 255, 255));
		btnAdicionarMateria.setForeground(Color.BLUE);
		btnAdicionarMateria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textNomeMateria.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Campo nome vazio!");
				} else {

					if (textCodMateria.getText().equals("")) {

						JOptionPane.showMessageDialog(null, "Campo Codigo vazio!");
					} else {

						if (cursoManipulado.addMateria(textNomeMateria.getText(), textCodMateria.getText()) == true) {
							JOptionPane.showMessageDialog(null, "Materia cadastrada com sucesso!");
							mostrarListaMaterias();
						} else {
							JOptionPane.showMessageDialog(null, "Materia já existente!");
						}
					}
				}
			}
		});
		btnAdicionarMateria.setBounds(187, 146, 89, 23);
		contentPane.add(btnAdicionarMateria);

		JButton btnVoltar = new JButton("Voltar <<");
		btnVoltar.setBackground(new Color(255, 255, 255));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnVoltar.setForeground(new Color(255, 0, 0));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVoltar.setBounds(10, 7, 89, 23);
		contentPane.add(btnVoltar);

		JLabel lblCadastroDeDisciplina = new JLabel("Cadastro de Disciplina");
		lblCadastroDeDisciplina.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblCadastroDeDisciplina.setBounds(82, 58, 144, 14);
		contentPane.add(lblCadastroDeDisciplina);

		JLabel lblDisciplinas = new JLabel("Disciplinas Cadastradas");
		lblDisciplinas.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDisciplinas.setBounds(10, 184, 167, 14);
		contentPane.add(lblDisciplinas);

		JLabel lblCodigo_1 = new JLabel("Codigo");
		lblCodigo_1.setBounds(10, 202, 48, 14);
		contentPane.add(lblCodigo_1);

		JLabel lblNome_1 = new JLabel("Nome");
		lblNome_1.setBounds(82, 202, 48, 14);
		contentPane.add(lblNome_1);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(346, 10, 299, 461);
		contentPane.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 82, 279, 357);
		panel.add(scrollPane_1);

		setList_1(new JList<String>());
		scrollPane_1.setViewportView(getList_1());

		JLabel lblAlunosMatriculados = new JLabel("Alunos Matriculados");
		lblAlunosMatriculados.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAlunosMatriculados.setBounds(92, 57, 154, 14);
		panel.add(lblAlunosMatriculados);
	}

	public void insereCRS(Curso crs) {
		this.cursoManipulado = crs;
		labelCURSO.setText(crs.getNomeCurso());
		mostrarListaAlunos();
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public JList<String> getList_1() {
		return list_1;
	}

	public void setList_1(JList<String> list_1) {
		this.list_1 = list_1;
	}

	public Base getBASE() {
		return BASE;
	}

	public void setBASE(Base bASE) {
		BASE = bASE;
	}
}
