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
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;
	private String senha = "";
	private Base BASE;
	private String codDept = "";

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SystemLogin frame = new SystemLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public SystemLogin() {
		
		this.BASE = new Base();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		passwordField = new JPasswordField();
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		passwordField.setBounds(93, 142, 254, 20);
		contentPane.add(passwordField);

		textField = new JTextField();
		textField.setBounds(93, 111, 254, 20);
		contentPane.add(textField);
		textField.setColumns(10);

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
		btnLogar.setBackground(new Color(255, 255, 255));
		btnLogar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				conversordeSenha();

				if (verificar(textField.getText(), getSenha()) == true) {

					JOptionPane.showMessageDialog(null, "Bem-vindo ao painel de controle!");
				
				} else {
					JOptionPane.showMessageDialog(null, "Não encontramos seu acesso! Verifique sua senha");
				}
			}
			
		});
		btnLogar.setBounds(258, 173, 89, 23);
		contentPane.add(btnLogar);
		
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

	public void conversordeSenha() {

		char[] st = passwordField.getPassword();
		setSenha("");
		for (int i = 0; i < st.length; i++) {

			setSenha(getSenha() + st[i]);
		}
	}

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
	
	public void acessoProf(Professor professor){
		
		ControleProf controleprof = new ControleProf();
		controleprof.setProfessorManipulado(professor);
		controleprof.setVisible(true);
		controleprof.mostrarComboMaterias();
		controleprof.setBASE(getBASE());
		
	}
	
	public void acessoAluno(Aluno aluno) {
		
		SCAluno controleAluno = new SCAluno();
		controleAluno.setAlunocontrolado(aluno);
		controleAluno.setVisible(true);
		controleAluno.setBASE(getBASE());
		controleAluno.mostrarALL();
	}

	public void AcessoProfessor(String codigodp,String codprof) {
		
		Departamento X = new Departamento("", "");
		
		for(int i=0;i<BASE.getDepartamentosDoInstituto().size();i++) {	
				
			if(BASE.getDepartamentosDoInstituto().get(i).getCodigo().equals(codigodp) == true){
				
				X = BASE.getDepartamentosDoInstituto().get(i);
				break;
			}
		}
		
		for(int i=0;i<X.getPROFESSORES().size();i++) {
			
			if(X.getPROFESSORES().get(i).getCodProfessor().equals(codprof) ==  true){
				
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
