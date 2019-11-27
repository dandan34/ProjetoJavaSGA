package systemIniciarSGA;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import alunoFront.CadastroAluno;
import systemBack.Base;
import systemFront.Inicio;
import systemFront.SystemLogin;

public class InicializarSistema {

	private JFrame frame;

	private Inicio inicio = null;
	private CadastroAluno cadastrar = null;
	private SystemLogin login = null;

	private Base BASE;
	private JButton btCadastro;
	private JButton btLogin;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicializarSistema window = new InicializarSistema();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public InicializarSistema() {
		this.BASE = new Base();
		initialize();
	}

	private void initialize() {

		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.window);
		frame.setBounds(100, 100, 1029, 499);
		frame.getContentPane().setLayout(null);

		JButton btCriarInsti = new JButton("Criar Instituto");
		btCriarInsti.setForeground(new Color(30, 144, 255));
		btCriarInsti.setFont(new Font("Tahoma", Font.BOLD, 18));
		btCriarInsti.setBackground(new Color(255, 255, 255));
		btCriarInsti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (inicio == null) {

					inicio = new Inicio();
					inicio.setVisible(true);
					inicio.setLocationRelativeTo(null);
					btCadastro.setVisible(true);
					btCriarInsti.setText("Acessar o insituto");
					btLogin.setVisible(true);
					btCriarInsti.setBounds(144, 151, 287, 131);

				} else {

					if (inicio.getINSTITUTO() == null) {

						inicio.setVisible(true);


					} else {

						inicio.getINSTITUTO().setVisible(true);
						inicio.getINSTITUTO().mostrarListaAlunosInstituto();

					}

				}

			}
		});
		btCriarInsti.setBounds(144, 151, 757, 131);

		frame.getContentPane().add(btCriarInsti);

		btCadastro = new JButton("Quero ser um Aluno!");
		btCadastro.setForeground(new Color(0, 0, 0));
		btCadastro.setBackground(new Color(255, 255, 255));
		btCadastro.setFont(new Font("Tahoma", Font.BOLD, 18));
		btCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (inicio.getINSTITUTO() != null) {

					mostrarBASE();

				} else {
					JOptionPane.showMessageDialog(null, "Não existe uma  Instituição cadastrada");
				}

			}
		});
		btCadastro.setBounds(441, 85, 268, 117);
		frame.getContentPane().add(btCadastro);
		btCadastro.setVisible(false);

		btLogin = new JButton("Login");
		btLogin.setForeground(new Color(100, 149, 237));
		btLogin.setBackground(new Color(255, 255, 255));
		btLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		btLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (inicio != null) {

					mostrarLogin();

				}

			}
		});
		btLogin.setBounds(441, 213, 268, 126);
		frame.getContentPane().add(btLogin);
		btLogin.setVisible(false);

		JButton btSair = new JButton("Sair");
		btSair.setForeground(new Color(255, 0, 0));
		btSair.setBackground(new Color(255, 255, 255));
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
			}
		});
		btSair.setBounds(914, 426, 89, 23);
		frame.getContentPane().add(btSair);
	}

	public void mostrarBASE() {

		if (cadastrar == null) {

			cadastrar = new CadastroAluno();
			cadastrar.setBASE(inicio.getINSTITUTO().getBASE());

			if (inicio.getINSTITUTO() != null) {

				cadastrar.comboBox(inicio.getINSTITUTO().getDPTS());
				cadastrar.setDPTS(inicio.getINSTITUTO().getDPTS());
			}

			cadastrar.setVisible(true);

		} else {

			cadastrar.comboBox(inicio.getINSTITUTO().getDPTS());
			cadastrar.setVisible(true);
		}

	}

	public void mostrarLogin() {

		if (login == null) {

			login = new SystemLogin();

			if (inicio.getINSTITUTO() != null) {

				login.setBASE(inicio.getINSTITUTO().getBASE());
			}

			login.setVisible(true);

		} else {

			login.setBASE(inicio.getINSTITUTO().getBASE());
			login.setVisible(true);
		}

	}

	public Inicio getInicio() {
		return inicio;
	}

	public void setInicio(Inicio inicio) {
		this.inicio = inicio;
	}

	public Base getBASE() {
		return BASE;
	}

	public void setBASE(Base bASE) {
		BASE = bASE;
	}

	public CadastroAluno getCadastrar() {
		return cadastrar;
	}

	public void setCadastrar(CadastroAluno cadastrar) {
		this.cadastrar = cadastrar;
	}

	public JButton getBtCadastro() {
		return btCadastro;
	}

	public void setBtCadastro(JButton btCadastro) {
		this.btCadastro = btCadastro;
	}

	public JButton getBtLogin() {
		return btLogin;
	}

	public void setBtLogin(JButton btLogin) {
		this.btLogin = btLogin;
	}

}
