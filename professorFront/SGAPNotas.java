package professorFront;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JTextField;

public class SGAPNotas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SGAPNotas frame = new SGAPNotas();
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
	public SGAPNotas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 292, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAluno = new JLabel("Aluno:");
		lblAluno.setBounds(105, 11, 48, 14);
		contentPane.add(lblAluno);
		
		JLabel label = new JLabel("----");
		label.setBounds(163, 11, 48, 14);
		contentPane.add(label);
		
		JLabel lblNotas = new JLabel("Notas");
		lblNotas.setBounds(63, 143, 48, 14);
		contentPane.add(lblNotas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 168, 160, 201);
		contentPane.add(scrollPane);
		
		JList<String> list = new JList();
		scrollPane.setViewportView(list);
		
		JButton btnApagar = new JButton("Apagar");
		btnApagar.setBounds(180, 166, 89, 23);
		contentPane.add(btnApagar);
		
		textField = new JTextField();
		textField.setBounds(41, 86, 129, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNota = new JLabel("Nota:");
		lblNota.setBounds(10, 89, 48, 14);
		contentPane.add(lblNota);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(180, 85, 89, 23);
		contentPane.add(btnAdicionar);
	}
}
