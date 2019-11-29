package systemFront;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import academicoBack.Departamento;
import alunoFront.SCAluno;
import membros.Aluno;
import membros.Professor;
import professorFront.ControleProf;
import systemBack.Base;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class SystemLogin extends JFrame {

	/**
	 *  @author Daniel de Souza Rodrigues 18.2.8112
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField txtCpf;
	private String senha = "";
	private Base BASE;
	private String codDept = "";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SystemLogin frame = new SystemLogin();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SystemLogin() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		this.BASE = new Base();
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		passwordField = new JPasswordField();
		passwordField.setToolTipText("");
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		passwordField.setBounds(93, 142, 254, 20);
		contentPane.add(passwordField);

		txtCpf = new JTextField();
		txtCpf.setBounds(93, 111, 254, 20);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(24, 114, 59, 14);
		contentPane.add(lblUsuario);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(24, 145, 59, 14);
		contentPane.add(lblSenha);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(180, 70, 67, 14);
		contentPane.add(lblLogin);

		JButton btnLogar = new JButton("Logar");
		btnLogar.setBackground(new Color(100, 149, 237));
		btnLogar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				conversordeSenha();

				if (verificar(txtCpf.getText(), getSenha()) == true) {

					JOptionPane.showMessageDialog(null, "Bem-vindo ao painel de controle!");

				} else {
					JOptionPane.showMessageDialog(null, "Não encontramos seu acesso! Verifique sua senha");
				}
			}

		});
		btnLogar.setBounds(93, 173, 254, 23);
		contentPane.add(btnLogar);

		JButton btnVoltar = new JButton("Voltar <<");
		btnVoltar.setForeground(new Color(255, 0, 0));
		btnVoltar.setBackground(new Color(255, 255, 255));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnVoltar.setBounds(10, 11, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblCpf = new JLabel("CPF!");
		lblCpf.setForeground(new Color(192, 192, 192));
		lblCpf.setBounds(357, 114, 48, 14);
		contentPane.add(lblCpf);
		
		JLabel lblPadro = new JLabel("Padr\u00E3o:  123");
		lblPadro.setForeground(new Color(192, 192, 192));
		lblPadro.setBounds(357, 145, 77, 14);
		contentPane.add(lblPadro);
	}

	/*
	 * Converte senha de text para Array
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */
	public void conversordeSenha() {

		char[] st = passwordField.getPassword();
		setSenha("");
		for (int i = 0; i < st.length; i++) {

			setSenha(getSenha() + st[i]);
		}
	}

	/*
	 * Verifica se o usuario requerido esta presente na base
	 * 
	 * @param usuario
	 * 
	 * @param senha
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */
	public Boolean verificar(String usuario, String senha) {

		Boolean testa = false;
		if (BASE.getCpfAlunos().contains(usuario) == true) {

			for (int i = 0; i < BASE.getAlunosDoInstituto().size(); i++) {

				if (BASE.getAlunosDoInstituto().get(i).getUSUARIO().getUsuario().equals(usuario) == true) {

					if (BASE.getAlunosDoInstituto().get(i).getUSUARIO().getSenha().equals(senha) == true) {

						acessoAluno(BASE.getAlunosDoInstituto().get(i));
						testa = true;
						break;
					}
				}
			}
		} else {

			if (BASE.getCpfProfessores().contains(usuario) == true) {

				for (int i = 0; i < BASE.getProfessoresDoInstituto().size(); i++) {

					if (BASE.getProfessoresDoInstituto().get(i).getCpf().equals(usuario) == true) {

						if (BASE.getProfessoresDoInstituto().get(i).getUSUARIO().getSenha().equals(senha) == true) {

							acessoProf(BASE.getProfessoresDoInstituto().get(i));

							testa = true;
							break;
						}
					}

				}

			}

		}

		if (testa == true) {

			return true;

		} else {

			return false;
		}

	}
	/*
	 * Retorna o painel do professor caso solicitado
	 * 
	 * @param professor
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */

	public void acessoProf(Professor professor) {

		ControleProf controleprof = new ControleProf();
		controleprof.setProfessorManipulado(professor);
		controleprof.setVisible(true);
		controleprof.mostrarComboMaterias();
		controleprof.setBASE(getBASE());

	}

	/*
	 * Retorna o painel do aluno caso solicitado
	 * 
	 * @param aluno
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */
	public void acessoAluno(Aluno aluno) {

		SCAluno controleAluno = new SCAluno();
		controleAluno.setAlunocontrolado(aluno);
		controleAluno.setVisible(true);
		controleAluno.setBASE(getBASE());
		controleAluno.mostrarALL();
	}

	/*
	 * Verifica Acesso do professor
	 * 
	 * @param codigodp
	 * 
	 * @param codprof
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */
	public void AcessoProfessor(String codigodp, String codprof) {

		Departamento X = new Departamento("", "");

		for (int i = 0; i < BASE.getDepartamentosDoInstituto().size(); i++) {

			if (BASE.getDepartamentosDoInstituto().get(i).getCodigo().equals(codigodp) == true) {

				X = BASE.getDepartamentosDoInstituto().get(i);
				break;
			}
		}

		for (int i = 0; i < X.getPROFESSORES().size(); i++) {

			if (X.getPROFESSORES().get(i).getCodProfessor().equals(codprof) == true) {

				break;
			}
		}

	}

	public Base getBASE() {
		return BASE;
	}

	public void setBASE(Base bASE) {
		BASE = bASE;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCodDept() {
		return codDept;
	}

	public void setCodDept(String codDept) {
		this.codDept = codDept;
	}
}
