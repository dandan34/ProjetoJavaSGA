package system;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class SCAluno extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public SCAluno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 355, 549);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAluno = new JLabel("Aluno:");
		lblAluno.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAluno.setBounds(154, 11, 48, 14);
		contentPane.add(lblAluno);
		
		JLabel label = new JLabel("----");
		label.setFont(new Font("Tahoma", Font.ITALIC, 14));
		label.setBounds(212, 11, 48, 14);
		contentPane.add(label);
		
		JLabel lblNomeAluno = new JLabel("Nome:");
		lblNomeAluno.setBounds(10, 57, 48, 14);
		contentPane.add(lblNomeAluno);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(10, 82, 48, 14);
		contentPane.add(lblCodigo);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(10, 157, 48, 14);
		contentPane.add(lblStatus);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(10, 132, 48, 14);
		contentPane.add(lblSexo);
		
		JLabel label_1 = new JLabel("----");
		label_1.setBounds(66, 57, 48, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("----");
		label_2.setBounds(66, 82, 48, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("----");
		label_3.setBounds(66, 132, 48, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("----");
		label_4.setBounds(66, 157, 48, 14);
		contentPane.add(label_4);
		
		JLabel lblCurso = new JLabel("Curso:");
		lblCurso.setBounds(10, 107, 48, 14);
		contentPane.add(lblCurso);
		
		JLabel label_5 = new JLabel("----");
		label_5.setBounds(66, 107, 48, 14);
		contentPane.add(label_5);
		
		JButton btnRelatorio = new JButton("Relatorio");
		btnRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRelatorio.setBounds(230, 454, 89, 23);
		contentPane.add(btnRelatorio);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 243, 191, 234);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JLabel lblMaterias = new JLabel("Materias");
		lblMaterias.setBounds(100, 218, 48, 14);
		contentPane.add(lblMaterias);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(230, 241, 89, 23);
		contentPane.add(btnAdicionar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(230, 268, 89, 23);
		contentPane.add(btnRemover);
	}
}
