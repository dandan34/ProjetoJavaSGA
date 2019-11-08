package alunoFront;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import academicoBack.Departamento;
import membros.Aluno;
import system.Base;
import system.Funcoes;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Checkbox;

public class CadastroAluno extends JFrame implements Funcoes {

	/**
	 * 
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
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CadastroAluno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 333, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(22, 76, 48, 14);
		contentPane.add(lblNome);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(22, 101, 48, 14);
		contentPane.add(lblCpf);

		textNome = new JTextField();
		textNome.setBounds(87, 73, 176, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);

		textCPF = new JTextField();
		textCPF.setColumns(10);
		textCPF.setBounds(87, 98, 176, 20);
		contentPane.add(textCPF);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(22, 126, 48, 14);
		contentPane.add(lblSexo);

		JLabel lblCadastroDeAluno = new JLabel("Cadastro de Aluno");
		lblCadastroDeAluno.setBounds(121, 11, 126, 14);
		contentPane.add(lblCadastroDeAluno);

		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(22, 155, 65, 14);
		contentPane.add(lblEndereo);

		textEndereco = new JTextField();
		textEndereco.setColumns(10);
		textEndereco.setBounds(87, 152, 176, 20);
		contentPane.add(textEndereco);

		JLabel lblCursos = new JLabel("Cursos:");
		lblCursos.setBounds(22, 184, 48, 14);
		contentPane.add(lblCursos);

		comboBox = new JComboBox<String>();
		comboBox.setBounds(87, 180, 176, 22);
		contentPane.add(comboBox);
		comboBox.setSelectedIndex(-1);

		checkboxMasculino = new Checkbox("Masculino");
		checkboxMasculino.setBounds(87, 124, 95, 22);
		contentPane.add(checkboxMasculino);

		checkboxFeminino = new Checkbox("Feminino");
		checkboxFeminino.setBounds(190, 124, 95, 22);
		contentPane.add(checkboxFeminino);

		JButton btnCadastrar = new JButton("Cadastrar");
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

		btnCadastrar.setBounds(174, 216, 89, 23);
		contentPane.add(btnCadastrar);

		JButton btnVoltar = new JButton("Voltar <<");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
			}
		});
		btnVoltar.setBounds(10, 7, 89, 23);
		contentPane.add(btnVoltar);
	}

	public void comboBox(ArrayList<Departamento> DP) {

		if (DP.size() >= 0) {

			for (int i = 0; i < DP.size(); i++) {

				for (int j = 0; j < DP.get(i).getCURSOS().size(); j++) {

					comboBox.addItem(DP.get(i).getCURSOS().get(j).getNomeCurso());

				}
			}
		}

	}

	public void criarAluno(String nome, String cpf, String sexo, String endereco) {
			
		Aluno aluno = new Aluno(nome, cpf, sexo, endereco);
		aluno.setNomeCursoCursado(comboBox.getItemAt(getnCurso()));
		aluno.setMatricula(matriculas);

		if (addAlunoNoCurso(aluno) == true) {

			matriculas++;
			JOptionPane.showMessageDialog(null, "Aluno matriculado com Sucesso!");

			limpar();
		} else {
			JOptionPane.showMessageDialog(null, "Aluno ja matriculado!");

		}
	}

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
