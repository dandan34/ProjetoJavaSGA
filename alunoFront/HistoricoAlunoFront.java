package alunoFront;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class HistoricoAlunoFront extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JList<String> list;
	private JLabel label;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HistoricoAlunoFront frame = new HistoricoAlunoFront();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public HistoricoAlunoFront() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 281, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 141, 245, 207);
		contentPane.add(scrollPane);
		
		list = new JList<String>();
		scrollPane.setViewportView(list);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnVoltar.setBounds(10, 11, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblFaltas = new JLabel("Faltas:");
		lblFaltas.setBounds(10, 88, 46, 14);
		contentPane.add(lblFaltas);
		
		label = new JLabel("----");
		label.setBounds(66, 88, 46, 14);
		contentPane.add(label);
	}
	
	
	public void mostrarListaNotas(String[] notas) {
		

			DefaultListModel<String> ls = new DefaultListModel<String>();
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			String st[] = notas;

			for (int i = 0; i < st.length; i++) {

				ls.addElement(st[i]);
			}

			list.setModel(ls);
		
	}
	
	public void mostrarFaltas(String faltas) {
		
		getLabel().setText(faltas);
		
	}


	public JLabel getLabel() {
		return label;
	}


	public void setLabel(JLabel label) {
		this.label = label;
	}
	
	
}
