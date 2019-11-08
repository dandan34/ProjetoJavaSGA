package system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class AlterarSenha extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private Base BASE;

	
	
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

	/**
	 * Create the frame.
	 */
	public AlterarSenha() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(129, 93, 228, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblSenharAtual = new JLabel("Senhar Atual:");
		lblSenharAtual.setBounds(34, 96, 82, 14);
		contentPane.add(lblSenharAtual);
		
		textField_1 = new JTextField();
		textField_1.setBounds(129, 124, 228, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNovaSenha = new JLabel("Nova Senha:");
		lblNovaSenha.setBounds(34, 127, 82, 14);
		contentPane.add(lblNovaSenha);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(268, 155, 89, 23);
		contentPane.add(btnAlterar);
	}
	
	public Base getBASE() {
		return BASE;
	}

	public void setBASE(Base bASE) {
		BASE = bASE;
	}
}
