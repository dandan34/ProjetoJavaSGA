package academicoFront;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.event.ListSelectionListener;

import academicoBack.Departamento;
import professorFront.SCProf;
import systemBack.Base;
import systemBack.Funcoes;
import systemBack.JtextFieldSomenteLetras;
import systemBack.JtextFieldSomenteNumeros;

import javax.swing.event.ListSelectionEvent;
import java.awt.Color;
import java.awt.Checkbox;
import java.awt.SystemColor;

public class SGDep extends JFrame implements Funcoes {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txNomeCurso;
	private JLabel lblDP;
	private int valorIndexList;
	private int valorIndexList2;
	private JList<String> list;
	private JList<String> list_2;

	private JButton btnDeletarCurso;
	private Base BASE;
	private Departamento dpManipulado;

	private JTextField txNomeProf;
	private JTextField txCPFprof;
	private JTextField txEndProf;
	private JTextField txCodProf;

	public void mostrarListaCR() {

		if (dpManipulado.getCURSOS().size() >= 0) {

			DefaultListModel<String> ls = new DefaultListModel<String>();
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			String[] st = dpManipulado.imprimeCursos();

			for (int i = 0; i < st.length; i++) {

				ls.addElement(st[i]);
			}

			list.setModel(ls);

		}
	}

	public void mostrarListaPRF() {

		if (dpManipulado.getPROFESSORES().size() >= 0) {

			DefaultListModel<String> ls = new DefaultListModel<String>();
			list_2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			String[] st = dpManipulado.imprimeProfessores();

			for (int i = 0; i < st.length; i++) {

				ls.addElement(st[i]);
			}

			list_2.setModel(ls);

		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SGDep frame = new SGDep();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SGDep() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 757, 565);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNomedp = new JLabel("Controle do departamento");
		lblNomedp.setBounds(113, 11, 176, 25);
		lblNomedp.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(lblNomedp);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 285, 207, 230);
		contentPane.add(scrollPane);

		list = new JList<String>();

		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int index = list.getSelectedIndex();
				setValorIndexList(index);
			}
		});
		scrollPane.setViewportView(list);

		JLabel lblCursos = new JLabel("Cursos Existente ");
		lblCursos.setBounds(56, 245, 107, 14);
		lblCursos.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(lblCursos);

		JButton btnAcessarCurso = new JButton("Acessar");
		btnAcessarCurso.setBackground(new Color(255, 255, 255));
		btnAcessarCurso.setBounds(227, 283, 89, 23);
		btnAcessarCurso.setForeground(Color.BLUE);
		btnAcessarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (list.getSelectedIndex() >= 0) {

					SGCurso ManipulaCurso = new SGCurso();
					ManipulaCurso.insereCRS(dpManipulado.CURSOS.get(list.getSelectedIndex()));
					ManipulaCurso.setVisible(true);
					ManipulaCurso.mostrarListaMaterias();
				}
			}
		});
		contentPane.add(btnAcessarCurso);

		btnDeletarCurso = new JButton("Deletar");
		btnDeletarCurso.setBackground(new Color(255, 255, 255));
		btnDeletarCurso.setBounds(227, 311, 89, 23);
		btnDeletarCurso.setForeground(Color.RED);
		btnDeletarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (list.getSelectedIndex() >= 0) {
					if (dpManipulado
							.removeCurso(dpManipulado.CURSOS.get(list.getSelectedIndex()).getNomeCurso()) == true) {
						
						
						
						
						JOptionPane.showMessageDialog(null, "Removido com Sucesso!");
						mostrarListaCR();
					} else {
						JOptionPane.showMessageDialog(null, "Algo deu errado na remoção!");
					}
				}

			}
		});
		contentPane.add(btnDeletarCurso);

		JLabel lblCadastrarCurso = new JLabel("Cadastrar Curso");
		lblCadastrarCurso.setBounds(113, 72, 125, 14);
		lblCadastrarCurso.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(lblCadastrarCurso);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 100, 48, 14);
		contentPane.add(lblNome);

		txNomeCurso = new JtextFieldSomenteLetras(15);
		txNomeCurso.setBounds(57, 97, 259, 20);
		contentPane.add(txNomeCurso);
		txNomeCurso.setColumns(10);

		JButton btnCadastrarCurso = new JButton("Cadastrar");
		btnCadastrarCurso.setBackground(new Color(255, 255, 255));
		btnCadastrarCurso.setBounds(215, 128, 101, 23);
		btnCadastrarCurso.setForeground(Color.BLUE);
		btnCadastrarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txNomeCurso.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Campo vazio");

				} else {

					if (BASE.buscarCursoBase(txNomeCurso.getText()) == true) {

						JOptionPane.showMessageDialog(null, "Curso Existente!");

					} else {

						if (dpManipulado.addCurso(txNomeCurso.getText(), dpManipulado.getCodigo()) == true) {

							if (BASE.addCursoBase(
									dpManipulado.getCURSOS().get(dpManipulado.getCURSOS().size() - 1)) == true) {

								JOptionPane.showMessageDialog(null, "Curso Cadastrado com Sucesso!");
							} else {

								JOptionPane.showMessageDialog(null, "Deu ruim");
							}

							mostrarListaCR();
						} else {
							JOptionPane.showMessageDialog(null, "Curso já existente! Tente outro nome...");
						}

					}

				}

			}
		});
		contentPane.add(btnCadastrarCurso);

		JLabel lblNome_1 = new JLabel("Nome");
		lblNome_1.setBounds(10, 260, 48, 14);
		contentPane.add(lblNome_1);

		this.lblDP = new JLabel("-----");
		lblDP.setBounds(277, 11, 125, 25);
		lblDP.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(lblDP);

		JButton btnVoltar = new JButton("<< Voltar");
		btnVoltar.setBackground(new Color(128, 128, 128));
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVoltar.setBounds(10, 13, 89, 23);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(btnVoltar);

		JLabel lblNomProf = new JLabel("Nome");
		lblNomProf.setBounds(361, 36, 48, 14);
		contentPane.add(lblNomProf);

		JLabel lblCpfProf = new JLabel("CPF");
		lblCpfProf.setBounds(361, 64, 48, 14);
		contentPane.add(lblCpfProf);

		JLabel lblSexoProf = new JLabel("Sexo");
		lblSexoProf.setBounds(361, 89, 48, 14);
		contentPane.add(lblSexoProf);

		JLabel lblEnderecoProf = new JLabel("Endere\u00E7o");
		lblEnderecoProf.setBounds(361, 117, 56, 14);
		contentPane.add(lblEnderecoProf);

		JLabel lblCodigoProf = new JLabel("Codigo ");
		lblCodigoProf.setBounds(361, 147, 48, 14);
		contentPane.add(lblCodigoProf);

		txNomeProf = new JtextFieldSomenteLetras(40);
		txNomeProf.setBounds(427, 36, 189, 20);
		contentPane.add(txNomeProf);
		txNomeProf.setColumns(10);

		txCPFprof = new JtextFieldSomenteNumeros(11);
		txCPFprof.setBounds(427, 64, 189, 20);
		txCPFprof.setToolTipText("");
		txCPFprof.setColumns(10);
		contentPane.add(txCPFprof);

		txEndProf = new JtextFieldSomenteLetras(20);
		txEndProf.setBounds(427, 117, 189, 20);
		txEndProf.setColumns(10);
		contentPane.add(txEndProf);

		txCodProf = new JtextFieldSomenteNumeros(11);
		txCodProf.setBounds(427, 145, 189, 20);
		txCodProf.setColumns(10);
		contentPane.add(txCodProf);

		Checkbox checkboxMasculino = new Checkbox("Masculino");
		checkboxMasculino.setBounds(427, 92, 95, 22);
		contentPane.add(checkboxMasculino);

		Checkbox checkboxFeminino = new Checkbox("Feminino");
		checkboxFeminino.setBounds(521, 92, 95, 22);
		contentPane.add(checkboxFeminino);

		JButton btnCadastrarProf = new JButton("Cadastrar");
		btnCadastrarProf.setBackground(new Color(255, 255, 255));
		btnCadastrarProf.setBounds(529, 176, 89, 23);
		btnCadastrarProf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean testa = false;

				if (txNomeProf.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Digite um nome!");
				} else {
					if (txCPFprof.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Digite um cpf!");
					} else {
						if (txEndProf.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Digite um endereço!");
						} else {
							if (txCodProf.getText().equals("")) {
								JOptionPane.showMessageDialog(null, "Digite um Codigo");
							} else {
								testa = true;
							}
						}
					}

					if (testa == true) {

						String sexo = null;
						if (checkboxMasculino.getState() == true && checkboxFeminino.getState() == true) {
							JOptionPane.showMessageDialog(null, "Marque apenas uma opção de sexo!");
						} else {

							if (checkboxMasculino.getState() == true) {
								sexo = "Masculino";
							} else {
								if (checkboxFeminino.getState() == true) {
									sexo = "Feminino";
								} else {
									JOptionPane.showMessageDialog(null, "Marque uma opção de sexo!");
								}
							}
						}
						if (verificaBase(txCPFprof.getText()) == false) {

							JOptionPane.showMessageDialog(null, "CPF JA REGISTRADO!");
							txCPFprof.setText("");
						} else {

							if (verificaCodProfBASE(txCodProf.getText()) == false) {

								JOptionPane.showMessageDialog(null, "Esse codigo já esta sendo utilizado");
								txCodProf.setText("");
							} else {

								if (sexo != null) {

									if (dpManipulado.addProfessor(txNomeProf.getText(), txCPFprof.getText(), sexo,
											txEndProf.getText(), txCodProf.getText(),
											dpManipulado.getCodigo()) == true) {

										BASE.addProfessorBase(dpManipulado.getPROFESSORES().getLast());
										mostrarListaPRF();
										JOptionPane.showMessageDialog(null, "Professor Cadastrado com sucesso!");
										limpar();
									} else {
										JOptionPane.showMessageDialog(null, "Professor já existente!");
									}

								}
							}

						}
					}

				}

			}
		});
		btnCadastrarProf.setForeground(Color.BLUE);
		contentPane.add(btnCadastrarProf);

		JLabel lblCadastrarProfessor = new JLabel("Cadastrar Professor");
		lblCadastrarProfessor.setBounds(456, 11, 150, 14);
		lblCadastrarProfessor.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(lblCadastrarProfessor);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(361, 285, 255, 230);
		contentPane.add(scrollPane_1);

		list_2 = new JList<String>();

		list_2.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {

				setValorIndexList2(list_2.getSelectedIndex());
			}
		});
		scrollPane_1.setViewportView(list_2);

		JLabel lblProfessoresDoDepartamento = new JLabel("Professores do Departamento");
		lblProfessoresDoDepartamento.setBounds(405, 245, 189, 14);
		lblProfessoresDoDepartamento.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(lblProfessoresDoDepartamento);

		JButton btnAcessarProf = new JButton("Acessar");
		btnAcessarProf.setBackground(new Color(255, 255, 255));
		btnAcessarProf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list_2.getSelectedIndex() >= 0) {

					AcessoProfessor();
				}
			}
		});
		btnAcessarProf.setBounds(626, 285, 89, 23);
		btnAcessarProf.setForeground(Color.BLUE);
		contentPane.add(btnAcessarProf);

		JButton btnDeletarProf = new JButton("Deletar");
		btnDeletarProf.setBackground(new Color(255, 255, 255));
		btnDeletarProf.setBounds(626, 311, 89, 23);
		btnDeletarProf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (list_2.getSelectedIndex() >= 0) {

					if (getValorIndexList2() >= 0) {

						String st = dpManipulado.getPROFESSORES().get(getValorIndexList2()).getCodProfessor();
						
						JOptionPane.showMessageDialog(null, dpManipulado.getPROFESSORES().get(getValorIndexList2()).getCodProfessor());
						
						if (dpManipulado.removeProfessor(st) == true) {
							mostrarListaPRF();
							JOptionPane.showMessageDialog(null, "Removido com sucesso!");
							
						} else {
							JOptionPane.showMessageDialog(null, "Algo deu errado na remoção!");
						}
					}

				}
				
				JOptionPane.showMessageDialog(null, BASE.getCpfProfessores());
			}
		});
		btnDeletarProf.setForeground(Color.RED);
		contentPane.add(btnDeletarProf);

		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(361, 260, 48, 14);
		contentPane.add(lblCodigo);

		JLabel label_1 = new JLabel("Nome");
		label_1.setBounds(473, 260, 48, 14);
		contentPane.add(label_1);

	}

	public boolean verificaCodProfBASE(String codProf) {

		if (BASE.getCodProfessores().contains(codProf) == true) {

			return false;
		} else {

			return true;
		}

	}

	public boolean verificaBase(String cpf) {

		if (BASE.getCpfProfessores().contains(cpf) == true) {

			return false;
		} else {

			if (BASE.getCpfAlunos().contains(cpf) == true) {

				return false;
			} else {

				return true;
			}
		}
	}

	public void AcessoProfessor() {

		SCProf controleProf = new SCProf();

		if (list_2.getSelectedIndex() >= 0) {

			controleProf.setProfessorManipulado(dpManipulado.getProfIndex(list_2.getSelectedIndex()));
			controleProf.setCursosDPdoProf(dpManipulado.getCURSOS());
			controleProf.setCursosManipulados(dpManipulado.getCURSOS());
			controleProf.mostrarListaMinistradas();
			controleProf.setVisible(true);

		}

	}

	public void insereDP(Departamento dp) {
		this.dpManipulado = dp;
		lblDP.setText(dp.getNome());
	}

	public Departamento getDpManipulado() {
		return dpManipulado;
	}

	public void setDpManipulado(Departamento dpManipulado) {
		this.dpManipulado = dpManipulado;
	}

	public int getValorIndexList() {
		return valorIndexList;
	}

	public void setValorIndexList(int valorIndexList) {
		this.valorIndexList = valorIndexList;
	}

	public int getValorIndexList2() {
		return valorIndexList2;
	}

	public void setValorIndexList2(int valorIndexList2) {
		this.valorIndexList2 = valorIndexList2;
	}

	public Base getBASE() {
		return BASE;
	}

	public void setBASE(Base bASE) {
		BASE = bASE;
	}

	@Override
	public void limpar() {
		txCodProf.setText("");
		txCPFprof.setText("");
		txEndProf.setText("");
		txNomeProf.setText("");

	}
}
