package alunoFront;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import membros.Aluno;
import systemBack.Base;
import systemFront.AlterarSenha;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class SCAluno extends JFrame {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel labelnome;
	private JLabel lbmatricula;
	private JLabel lbCPF;
	private JLabel lbsexo;
	private JLabel lbstatus;
	private JLabel lbcurso;
	private JList<String> list;
	private JList<String> list_1;
	private JComboBox<String> comboBox;

	private int indexComboBox;

	private Aluno alunocontrolado;
	private Base BASE;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SCAluno frame = new SCAluno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SCAluno() {

		BASE = new Base();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 767, 549);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAluno = new JLabel("Aluno:");
		lblAluno.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAluno.setBounds(10, 53, 48, 14);
		contentPane.add(lblAluno);

		labelnome = new JLabel("----");
		labelnome.setFont(new Font("Tahoma", Font.ITALIC, 14));
		labelnome.setBounds(93, 53, 182, 14);
		contentPane.add(labelnome);

		JLabel lblNomeAluno = new JLabel("Matricula:");
		lblNomeAluno.setBounds(10, 78, 70, 14);
		contentPane.add(lblNomeAluno);

		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setBounds(10, 103, 48, 14);
		contentPane.add(lblCPF);

		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(10, 178, 48, 14);
		contentPane.add(lblStatus);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(10, 153, 48, 14);
		contentPane.add(lblSexo);

		lbmatricula = new JLabel("----");
		lbmatricula.setBounds(91, 78, 154, 14);
		contentPane.add(lbmatricula);

		lbCPF = new JLabel("----");
		lbCPF.setBounds(91, 103, 154, 14);
		contentPane.add(lbCPF);

		lbsexo = new JLabel("----");
		lbsexo.setBounds(91, 153, 154, 14);
		contentPane.add(lbsexo);

		lbstatus = new JLabel("----");
		lbstatus.setBackground(new Color(255, 255, 255));
		lbstatus.setBounds(91, 178, 154, 14);
		contentPane.add(lbstatus);

		JLabel lblCurso = new JLabel("Curso:");
		lblCurso.setBounds(10, 128, 48, 14);
		contentPane.add(lblCurso);

		lbcurso = new JLabel("----");
		lbcurso.setBounds(91, 128, 154, 14);
		contentPane.add(lbcurso);

		JButton btnRelatorio = new JButton("Historico");
		btnRelatorio.setBackground(new Color(255, 255, 255));
		btnRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (list.getSelectedIndex() >= 0) {
					
					HistoricoAlunoFront historico = new HistoricoAlunoFront();
					historico.mostrarListaNotas(buscarListaNota(list.getSelectedValue()));
					historico.mostrarFaltas(BuscarFaltas(list.getSelectedValue()));
					historico.setVisible(true);
				}

			}
		});
		btnRelatorio.setBounds(230, 267, 89, 23);
		contentPane.add(btnRelatorio);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 243, 191, 234);
		contentPane.add(scrollPane);

		list = new JList<String>();
		scrollPane.setViewportView(list);

		JLabel lblMaterias = new JLabel("Materias Cursadas");
		lblMaterias.setBounds(76, 218, 111, 14);
		contentPane.add(lblMaterias);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBackground(new Color(255, 255, 255));
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (comboBox.getSelectedIndex() >= 0) {
					if (addMateria(list_1.getSelectedValue()) == true) {

						BASE.adiconarAlunoNaTurmaDaDisciplinaBASE(list_1.getSelectedValue(),
								comboBox.getSelectedIndex(), alunocontrolado);

						JOptionPane.showMessageDialog(null, "OK! Adicionado a turma");
					} else {
						JOptionPane.showMessageDialog(null, "Algo deu errado ao adicionar a turma");
					}
				} else {

					JOptionPane.showMessageDialog(null, "Selecione uma turma");
				}

			}
		});
		btnAdicionar.setBounds(648, 82, 89, 23);
		contentPane.add(btnAdicionar);

		JButton btnRemover = new JButton("Remover");
		btnRemover.setBackground(new Color(255, 255, 255));
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (list.getSelectedIndex() >= 0) {

					BASE.removeAlunoNaTurmaDaDisciplinaBASE(alunocontrolado.getCpf(), list.getSelectedValue());
					alunocontrolado.removeDisciplina(list.getSelectedValue());

					mostrarLista();

				}

			}
		});
		btnRemover.setBounds(230, 241, 89, 23);
		contentPane.add(btnRemover);

		JButton btnNewButton = new JButton("Alterar Senha");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AlterarSenha alterarSenha = new AlterarSenha();
				alterarSenha.setVisible(true);
				alterarSenha.setBASE(getBASE());
				alterarSenha.setCpfAutenticador(alunocontrolado.getCpf());
			}
		});
		btnNewButton.setBounds(109, 11, 118, 23);
		contentPane.add(btnNewButton);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(406, 53, 203, 424);
		contentPane.add(scrollPane_1);

		list_1 = new JList<String>();
		list_1.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {

				verificaCombo();
			}
		});
		scrollPane_1.setViewportView(list_1);

		JLabel lblMateriasDisponiveisNo = new JLabel("Materias Disponiveis no Curso");
		lblMateriasDisponiveisNo.setBounds(427, 30, 182, 14);
		contentPane.add(lblMateriasDisponiveisNo);

		comboBox = new JComboBox<String>();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setBounds(619, 53, 118, 22);
		contentPane.add(comboBox);

		JLabel lblTurmas = new JLabel("Turmas");
		lblTurmas.setBounds(662, 30, 48, 14);
		contentPane.add(lblTurmas);

		JButton btnVoltar = new JButton("Voltar <<");
		btnVoltar.setBackground(new Color(255, 255, 255));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnVoltar.setBounds(10, 11, 89, 23);
		contentPane.add(btnVoltar);

	}

	public void verificaCombo() {

		if (comboBox.getItemCount() >= 0) {

			removeComboBox();
			selecaoListaMateria(list_1.getSelectedValue());

		} else {

			selecaoListaMateria(list_1.getSelectedValue());
		}

	}

	public Boolean addMateria(String materia) {

		if (alunocontrolado.addDisciplina(materia) == false) {

			JOptionPane.showMessageDialog(null, "Já esta matriculado!");
			return false;

		} else {

			mostrarLista();
			return true;
		}
	}

	public void materiasDisponiveis(String nomeCurso) {

		int aux = -1;

		for (int i = 0; i < BASE.getCursosDoInstituto().size(); i++) {

			if (BASE.getCursosDoInstituto().get(i).getNomeCurso().equals(nomeCurso) == true) {

				aux = i;
				break;
			}
		}

		if (aux >= 0) {

			String[] st = new String[BASE.getCursosDoInstituto().get(aux).getMATERIAS().size()];

			for (int i = 0; i < st.length; i++) {

				st[i] = BASE.getCursosDoInstituto().get(aux).getMATERIAS().get(i).getCodDisciplina() + " "
						+ BASE.getCursosDoInstituto().get(aux).getMATERIAS().get(i).getNomeDisciplina();
			}

			mostrarLista2(st);
		}

	}

	public void mostrarLista2(String[] st) {

		if (st.length >= 0) {

			DefaultListModel<String> ls = new DefaultListModel<String>();
			list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			for (int i = 0; i < st.length; i++) {

				ls.addElement(st[i]);
			}

			list_1.setModel(ls);

		}

	}

	public void mostrarLista() {

		if (alunocontrolado.getCURSANDO().size() >= 0) {

			DefaultListModel<String> ls = new DefaultListModel<String>();
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			String[] st = alunocontrolado.imprimeCursando();

			for (int i = 0; i < st.length; i++) {

				ls.addElement(st[i]);
			}

			list.setModel(ls);

		}
	}

	public void selecaoListaMateria(String totalMateria) {

		String comparador = "";
		for (int i = 0; i < BASE.getCursosDoInstituto().size(); i++) {
			for (int j = 0; j < BASE.getCursosDoInstituto().get(i).getMATERIAS().size(); j++) {

				comparador = BASE.getCursosDoInstituto().get(i).getMATERIAS().get(j).getCodDisciplina() + " "
						+ BASE.getCursosDoInstituto().get(i).getMATERIAS().get(j).getNomeDisciplina();
				if (comparador.equals(totalMateria) == true) {

					mostrarComboBox(BASE.getCursosDoInstituto().get(i).getMATERIAS().get(j).imprimeTURMA());

					break;
				}
			}

		}

	}

	public void removeComboBox() {

		if (comboBox.getItemCount() >= 0) {

			comboBox.removeAllItems();

		}
	}

	public void mostrarComboBox(String[] st) {

		for (int i = 0; i < st.length; i++) {

			comboBox.addItem(st[i]);
		}

	}

	public String[] buscarListaNota(String codIdentificador) {

		String[] st = null;

		for (int i = 0; i < alunocontrolado.getNOTAS().size(); i++) {

			if (alunocontrolado.getNOTAS().get(i).getCodDisciplina().equals(codIdentificador) == true) {

				st = alunocontrolado.getNOTAS().get(i).imprimeNotas();

			}
		}
		// conferir implementação da busca igualemnte a condição
		return st;
	}
	
	public String BuscarFaltas(String codIdentificador) {
		
		String st = "";
		
		for (int i = 0; i < alunocontrolado.getNOTAS().size(); i++) {

			if (alunocontrolado.getNOTAS().get(i).getCodDisciplina().equals(codIdentificador) == true) {

				st = alunocontrolado.getNOTAS().get(i).imprimeFaltas();

			}
		}
		
		return st;
	}

	public void limparComboBox() {

		comboBox = null;
	}

	public void mostrarALL() {

		materiasDisponiveis(alunocontrolado.getNomeCursoCursado());
		mostrarLista();
	}

	public void setAlunocontrolado(Aluno alunocontrolado) {
		this.alunocontrolado = alunocontrolado;

		labelnome.setText(alunocontrolado.getNome());
		lbmatricula.setText("" + alunocontrolado.getMatricula());
		lbCPF.setText(alunocontrolado.getCpf());
		lbsexo.setText(alunocontrolado.getSexo());
		lbstatus.setText(alunocontrolado.getStatus().toString());
		lbcurso.setText(alunocontrolado.getNomeCursoCursado());
	}

	public Aluno getAlunocontrolado() {
		return alunocontrolado;
	}

	public JLabel getLabel_1() {
		return lbmatricula;
	}

	public void setLabel_1(JLabel label_1) {
		this.lbmatricula = label_1;
	}

	public JLabel getLabel_2() {
		return lbCPF;
	}

	public void setLabel_2(JLabel label_2) {
		this.lbCPF = label_2;
	}

	public JLabel getLabel_3() {
		return lbsexo;
	}

	public void setLabel_3(JLabel label_3) {
		this.lbsexo = label_3;
	}

	public JLabel getLabel_4() {
		return lbstatus;
	}

	public void setLabel_4(JLabel label_4) {
		this.lbstatus = label_4;
	}

	public JLabel getLabel() {
		return labelnome;
	}

	public void setLabel(JLabel label) {
		this.labelnome = label;
	}

	public JLabel getLabel_5() {
		return lbcurso;
	}

	public void setLabel_5(JLabel label_5) {
		this.lbcurso = label_5;
	}

	public Base getBASE() {
		return BASE;
	}

	public void setBASE(Base bASE) {
		BASE = bASE;
	}

	public int getIndexComboBox() {
		return indexComboBox;
	}

	public void setIndexComboBox(int indexComboBox) {
		this.indexComboBox = indexComboBox;
	}
}
