package professorFront;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import membros.Aluno;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SGAPNotas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textADDNOTA;
	
	private JLabel labelAlunoNome;
	private JLabel labelMatricula;
	
	private Aluno alunoManipulado;
	
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

	public SGAPNotas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 284, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAluno = new JLabel("Aluno:");
		lblAluno.setBounds(10, 11, 48, 14);
		contentPane.add(lblAluno);
	
		labelAlunoNome = new JLabel("----");
		labelAlunoNome.setBounds(68, 11, 48, 14);
		contentPane.add(labelAlunoNome);
		
		JLabel lblNotas = new JLabel("Notas");
		lblNotas.setBounds(70, 143, 48, 14);
		contentPane.add(lblNotas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 168, 89, 201);
		contentPane.add(scrollPane);
		
		JList<String> list = new JList<String>();
		scrollPane.setViewportView(list);
		
		JButton btnApagar = new JButton("Apagar");
		btnApagar.setBounds(140, 166, 89, 23);
		contentPane.add(btnApagar);
		
		textADDNOTA = new JTextField();
		textADDNOTA.setBounds(41, 112, 89, 20);
		contentPane.add(textADDNOTA);
		textADDNOTA.setColumns(10);
		
		JLabel lblNota = new JLabel("Nota:");
		lblNota.setBounds(10, 113, 48, 14);
		contentPane.add(lblNota);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(140, 109, 89, 23);
		contentPane.add(btnAdicionar);
		
		JLabel lblFaltas = new JLabel("Faltas:");
		lblFaltas.setBounds(10, 76, 48, 14);
		contentPane.add(lblFaltas);
		
		JLabel labelFALTAS = new JLabel("----");
		labelFALTAS.setBounds(70, 76, 48, 14);
		contentPane.add(labelFALTAS);
		
		JButton buttonADD = new JButton("+");
		buttonADD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonADD.setBounds(140, 72, 41, 23);
		contentPane.add(buttonADD);
		
		JButton buttonSUB = new JButton("-");
		buttonSUB.setBounds(188, 72, 41, 23);
		contentPane.add(buttonSUB);
		
		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setBounds(10, 36, 79, 14);
		contentPane.add(lblMatricula);
		
		labelMatricula = new JLabel("----");
		labelMatricula.setBounds(68, 36, 48, 14);
		contentPane.add(labelMatricula);
	}

	public Aluno getAlunoManipulado() {
		return alunoManipulado;
	}

	public void setAlunoManipulado(Aluno alunoManipulado) {
		this.alunoManipulado = alunoManipulado;

		labelAlunoNome.setText(alunoManipulado.getNome());
		labelMatricula.setText("" + alunoManipulado.getMatricula());
		//implementando notas.. conferir Selecionar do professor tirar o fixo
	}

	public JTextField getTextADDNOTA() {
		return textADDNOTA;
	}

	public void setTextADDNOTA(JTextField textADDNOTA) {
		this.textADDNOTA = textADDNOTA;
	}

	public JLabel getLabelAlunoNome() {
		return labelAlunoNome;
	}

	public void setLabelAlunoNome(JLabel labelAlunoNome) {
		this.labelAlunoNome = labelAlunoNome;
	}

	public JLabel getLabelMatricula() {
		return labelMatricula;
	}

	public void setLabelMatricula(JLabel labelMatricula) {
		this.labelMatricula = labelMatricula;
	}

	
	
}
