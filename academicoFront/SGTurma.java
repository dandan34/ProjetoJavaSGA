package academicoFront;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import academicoBack.Disciplina;
import academicoBack.Turma;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SGTurma extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldCodTurma;
	private JButton btnCriarTurma;
	private JButton btnDeletarTurma;
	private JList<String> list;
	private JLabel labelNomeDisciplinaManipulada;

	private Disciplina materiaManipulada;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SGTurma frame = new SGTurma();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SGTurma() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 316, 364);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 102, 180, 210);
		contentPane.add(scrollPane);

		list = new JList<String>();
		scrollPane.setViewportView(list);

		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(10, 72, 46, 14);
		contentPane.add(lblCodigo);

		textFieldCodTurma = new JTextField();
		textFieldCodTurma.setBounds(66, 69, 124, 20);
		contentPane.add(textFieldCodTurma);
		textFieldCodTurma.setColumns(10);

		btnCriarTurma = new JButton("Criar");
		btnCriarTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textFieldCodTurma.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Campo vazio!");
				} else {
					addTURMA();
					mostrarListaTurmas();

				}

			}
		});
		btnCriarTurma.setBounds(200, 68, 89, 23);
		contentPane.add(btnCriarTurma);

		JLabel lblDisciplina = new JLabel("Disciplina:");
		lblDisciplina.setBounds(118, 11, 65, 14);
		contentPane.add(lblDisciplina);

		labelNomeDisciplinaManipulada = new JLabel("----");
		labelNomeDisciplinaManipulada.setBounds(192, 11, 46, 14);
		contentPane.add(labelNomeDisciplinaManipulada);

		JLabel lblCriarTurma = new JLabel("Criar Turma");
		lblCriarTurma.setBounds(118, 43, 105, 14);
		contentPane.add(lblCriarTurma);

		btnDeletarTurma = new JButton("Deletar");
		btnDeletarTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (list.getSelectedIndex() >= 0) {
					removeTURMA(list.getSelectedIndex());
				}

			}
		});
		btnDeletarTurma.setBounds(200, 100, 89, 23);
		contentPane.add(btnDeletarTurma);

		JButton btnVoltar = new JButton("Voltar <<");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
			}
		});
		btnVoltar.setBounds(10, 7, 89, 23);
		contentPane.add(btnVoltar);
	}

	public Disciplina getMateriaManipulada() {
		return materiaManipulada;
	}

	public void setMateriaManipulada(Disciplina materiaManipulada) {
		this.materiaManipulada = materiaManipulada;
		labelNomeDisciplinaManipulada.setText(materiaManipulada.getNomeDisciplina());
	}

	public boolean addTURMA() {

		Turma x = new Turma(textFieldCodTurma.getText());

		if (materiaManipulada.addTurma(x) == true) {

			return true;
		} else {
			return false;
		}
	}

	public boolean removeTURMA(int index) {

		if (materiaManipulada.removeTurma(index) == true) {
			mostrarListaTurmas();
			return true;
		} else {
			return false;
		}
	}

	public void mostrarListaTurmas() {

		DefaultListModel<String> ls = new DefaultListModel<String>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		String[] st = materiaManipulada.imprimeTURMA();

		for (int i = 0; i < st.length; i++) {

			ls.addElement(st[i]);
		}

		list.setModel(ls);

	}

}
