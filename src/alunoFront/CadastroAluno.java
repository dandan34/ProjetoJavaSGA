package alunoFront;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import academicoBack.Departamento;
import membros.Aluno;
import systemBack.Base;
import systemBack.Funcoes;
import systemBack.JtextFieldSomenteLetras;
import systemBack.JtextFieldSomenteNumeros;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Font;

public class CadastroAluno extends JFrame implements Funcoes {

	/**
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textCPF;
	private String sexo = "";
	private JTextField textEndereco;
	private int nCurso;
	private JComboBox<String> comboBox;
	private Checkbox checkboxMasculino;
	private Checkbox checkboxFeminino;
	private ArrayList<Departamento> DPTS;
	private Base BASE;

	static int matriculas = 1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroAluno frame = new CadastroAluno();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CadastroAluno() {
		this.BASE = new Base();
		setBounds(100, 100, 287, 348);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 101, 48, 14);
		contentPane.add(lblNome);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(10, 126, 48, 14);
		contentPane.add(lblCpf);

		textNome = new JtextFieldSomenteLetras(40);
		textNome.setBounds(75, 98, 176, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);

		textCPF = new JtextFieldSomenteNumeros(11);
		textCPF.setColumns(10);
		textCPF.setBounds(75, 123, 176, 20);
		contentPane.add(textCPF);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(10, 151, 48, 14);
		contentPane.add(lblSexo);

		JLabel lblCadastroDeAluno = new JLabel("Cadastro de Aluno");
		lblCadastroDeAluno.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCadastroDeAluno.setBounds(61, 58, 178, 14);
		contentPane.add(lblCadastroDeAluno);

		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(10, 180, 65, 14);
		contentPane.add(lblEndereo);

		textEndereco = new JtextFieldSomenteLetras(20);
		textEndereco.setColumns(10);
		textEndereco.setBounds(75, 177, 176, 20);
		contentPane.add(textEndereco);

		JLabel lblCursos = new JLabel("Cursos:");
		lblCursos.setBounds(10, 209, 48, 14);
		contentPane.add(lblCursos);

		comboBox = new JComboBox<String>();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setBounds(75, 205, 176, 22);
		contentPane.add(comboBox);
		comboBox.setSelectedIndex(-1);

		checkboxMasculino = new Checkbox("Masculino");
		checkboxMasculino.setBounds(75, 149, 95, 22);
		contentPane.add(checkboxMasculino);

		checkboxFeminino = new Checkbox("Feminino");
		checkboxFeminino.setBounds(178, 149, 95, 22);
		contentPane.add(checkboxFeminino);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(new Color(30, 144, 255));
		btnCadastrar.setBackground(new Color(255, 255, 255));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textNome.getText().equals("") == true) {

					JOptionPane.showMessageDialog(null, "Campo nome vazio!");
				} else {
					if (textCPF.getText().equals("") == true) {

						JOptionPane.showMessageDialog(null, "Campo cpf vazio!");
					} else {

						if (textEndereco.getText().equals("") == true) {

							JOptionPane.showMessageDialog(null, "Campo endereço vazio!");
						} else {

							if (checkboxFeminino.getState() == true && checkboxMasculino.getState() == true) {

								JOptionPane.showMessageDialog(null, "Marque apenas uma opção");
							} else {

								if (checkboxFeminino.getState() == true) {

									setSexo("Feminino");
								} else {

									if (checkboxMasculino.getState() == true) {

										setSexo("Masculino");

									} else {

										JOptionPane.showMessageDialog(null, "Marque uma opcão de sexo!");
									}

								}

							}
						}

						if (comboBox.getSelectedIndex() >= 0) {

							setnCurso(comboBox.getSelectedIndex());

							criarAluno(textNome.getText(), textCPF.getText(), getSexo(), textEndereco.getText());

						} else {

							JOptionPane.showMessageDialog(null, "Selecione um Curso");
						}

					}
				}

			}

		});

		btnCadastrar.setBounds(145, 241, 106, 23);
		contentPane.add(btnCadastrar);

		JButton btnVoltar = new JButton("Voltar <<");
		btnVoltar.setForeground(new Color(255, 0, 0));
		btnVoltar.setBackground(new Color(255, 255, 255));
		btnVoltar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				dispose();
				limpar();

			}

		});
		btnVoltar.setBounds(10, 7, 89, 23);
		contentPane.add(btnVoltar);
	}

	/*
	 * imprime a combo box na interface grafica
	 * 
	 * @param DP
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */
	public void comboBox(ArrayList<Departamento> DP) {

		comboBox.removeAllItems();

		if (DP.size() >= 0) {

			for (int i = 0; i < DP.size(); i++) {

				for (int j = 0; j < DP.get(i).getCURSOS().size(); j++) {

					comboBox.addItem(DP.get(i).getCURSOS().get(j).getNomeCurso());

				}
			}
		}

	}
	/*
	 * Cria um Aluno para adicionar ao instituto
	 * 
	 * @param nome
	 * 
	 * @param cpf
	 * 
	 * @param sexo
	 * 
	 * @param endereco
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */

	public void criarAluno(String nome, String cpf, String sexo, String endereco) {

		if (BASE.getCpfProfessores().contains(textCPF.getText()) == true) {

			JOptionPane.showMessageDialog(null, "CPF JÁ REGISTRADO - TENTE OUTRO");
			limpar();
		} else {

			Aluno aluno = new Aluno(nome, cpf, sexo, endereco);
			aluno.setNomeCursoCursado(comboBox.getItemAt(getnCurso()));
			aluno.setMatricula(matriculas);

			if (addAlunoNoCurso(aluno) == true) {

				matriculas++;
				JOptionPane.showMessageDialog(null, "Aluno matriculado com Sucesso!");

				limpar();
			} else {
				JOptionPane.showMessageDialog(null, "Aluno ja matriculado!");
				textCPF.setText("");

			}
		}
	}
	/*
	 * Adiciona Aluno no curso
	 * 
	 * @param aluno
	 * 
	 * @return boolean
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */

	public Boolean addAlunoNoCurso(Aluno aluno) {

		if (BASE.getCpfAlunos().contains(aluno.getCpf()) == false) {

			Boolean testa = false;

			for (int i = 0; i < DPTS.size(); i++) {

				for (int j = 0; j < DPTS.get(i).getCURSOS().size(); j++) {

					if (DPTS.get(i).getCURSOS().get(j).getNomeCurso().equals(aluno.getNomeCursoCursado())) {

						DPTS.get(i).getCURSOS().get(j).addAlunoNoCurso(aluno);
						BASE.addAlunoBase(aluno);
						testa = true;
						break;
					}
				}

			}

			if (testa == true) {

				return true;
			} else {
				return false;
			}

		} else {

			JOptionPane.showMessageDialog(null, "Aluno ja matriculado!");
			return false;
		}

	}

	public void setTextNome(JTextField textNome) {
		this.textNome = textNome;
	}

	public JTextField getTextCPF() {
		return textCPF;
	}

	public void setTextCPF(JTextField textCPF) {
		this.textCPF = textCPF;
	}

	public JTextField getTextEndereco() {
		return textEndereco;
	}

	public void setTextEndereco(JTextField textEndereco) {
		this.textEndereco = textEndereco;
	}

	public JTextField getTextNome() {
		return textNome;
	}

	public int getnCurso() {
		return nCurso;
	}

	public void setnCurso(int nCurso) {
		this.nCurso = nCurso;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public ArrayList<Departamento> getDPTS() {
		return DPTS;
	}

	public void setDPTS(ArrayList<Departamento> dPTS) {
		DPTS = dPTS;
	}

	public Base getBASE() {
		return BASE;
	}

	public void setBASE(Base bASE) {
		BASE = bASE;
	}

	public Checkbox getCheckboxMasculino() {
		return checkboxMasculino;
	}

	public void setCheckboxMasculino(Checkbox checkboxMasculino) {
		this.checkboxMasculino = checkboxMasculino;
	}

	public Checkbox getCheckboxFeminino() {
		return checkboxFeminino;
	}

	public void setCheckboxFeminino(Checkbox checkboxFeminino) {
		this.checkboxFeminino = checkboxFeminino;
	}

	@Override
	public void limpar() {
		textNome.setText("");
		textCPF.setText("");
		textEndereco.setText("");
		setSexo("");
		setnCurso(-1);
		checkboxFeminino.setState(false);
		checkboxMasculino.setState(false);
		comboBox.setSelectedIndex(-1);
	}
}
