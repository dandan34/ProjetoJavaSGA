package system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlterarSenha extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textSenhaAtual;
	private JTextField textNovaSenha;
	private Base BASE;
	private String cpfAutenticador;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarSenha frame = new AlterarSenha();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AlterarSenha() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textSenhaAtual = new JTextField();
		textSenhaAtual.setBounds(129, 93, 228, 20);
		contentPane.add(textSenhaAtual);
		textSenhaAtual.setColumns(10);

		JLabel lblSenharAtual = new JLabel("Senhar Atual:");
		lblSenharAtual.setBounds(34, 96, 82, 14);
		contentPane.add(lblSenharAtual);

		textNovaSenha = new JTextField();
		textNovaSenha.setBounds(129, 124, 228, 20);
		contentPane.add(textNovaSenha);
		textNovaSenha.setColumns(10);

		JLabel lblNovaSenha = new JLabel("Nova Senha:");
		lblNovaSenha.setBounds(34, 127, 82, 14);
		contentPane.add(lblNovaSenha);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (mudarSenha(getCpfAutenticador(), textSenhaAtual.getText(), textNovaSenha.getText()) == true) {

					JOptionPane.showMessageDialog(null, "Senha Atualizada");
				} else {
					JOptionPane.showMessageDialog(null, "Algo deu errado");
				}

			}
		});
		btnAlterar.setBounds(268, 155, 89, 23);
		contentPane.add(btnAlterar);
	}

	public Boolean mudarSenha(String cpfMudador, String senhaAtual, String novaSenha) {

		if (BASE.mudarSenha(getCpfAutenticador(), senhaAtual, novaSenha) == true) {

			return true;
		} else {
			return false;
		}
	}

	public Base getBASE() {
		return BASE;
	}

	public void setBASE(Base bASE) {
		BASE = bASE;
	}

	public String getCpfAutenticador() {
		return cpfAutenticador;
	}

	public void setCpfAutenticador(String cpfAutenticador) {
		this.cpfAutenticador = cpfAutenticador;
	}
}
