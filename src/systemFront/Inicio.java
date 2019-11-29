package systemFront;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import academicoFront.CadastroDep;
import systemBack.JtextFieldSomenteLetras;

public class Inicio extends JFrame {

	/**
	 *  @author Daniel de Souza Rodrigues 18.2.8112
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private Inicio inicio;
	private JtextFieldSomenteLetras jtextFieldSomenteLetras;
	private CadastroDep INSTITUTO = null;
	
	private String NOMEINSTITUTO;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Inicio() {
	
		setBounds(100, 100, 508, 290);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		jtextFieldSomenteLetras = new JtextFieldSomenteLetras(20);
		jtextFieldSomenteLetras.setBounds(55, 130, 390, 20);
		contentPane.add(jtextFieldSomenteLetras);
		
		JLabel label = new JLabel("Insira o nome da Institui\u00E7\u00E3o");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(145, 105, 218, 14);
		contentPane.add(label);
		
		JButton button = new JButton("Criar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					if (jtextFieldSomenteLetras.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Campo Vazio!");
					} else {
						JOptionPane.showMessageDialog(null, "Sistema " + jtextFieldSomenteLetras.getText() + " criado com sucesso!");
						setNOMEINSTITUTO(jtextFieldSomenteLetras.getText());
						setINSTITUTO(new CadastroDep());			
						getINSTITUTO().setVisible(true);
						getINSTITUTO().getTxInstituto().setText(getNOMEINSTITUTO());;
						INSTITUTO.mostrarListaAlunosInstituto();
						
						dispose();
					}
				} catch (Exception e2) {

					JOptionPane.showMessageDialog(null, "ERRO!");
				}
				
				
				
			}
		});
		button.setForeground(Color.BLUE);
		button.setBackground(Color.WHITE);
		button.setBounds(173, 161, 130, 32);
		contentPane.add(button);
		
		JButton btnVoltar = new JButton("Voltar <<");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVoltar.setForeground(Color.RED);
		btnVoltar.setBackground(Color.WHITE);
		btnVoltar.setBounds(10, 11, 89, 23);
		contentPane.add(btnVoltar);
	}


	public Inicio getInicio() {
		return inicio;
	}


	public void setInicio(Inicio inicio) {
		this.inicio = inicio;
	}


	public CadastroDep getINSTITUTO() {
		return INSTITUTO;
	}


	public void setINSTITUTO(CadastroDep iNSTITUTO) {
		INSTITUTO = iNSTITUTO;
	}


	public String getNOMEINSTITUTO() {
		return NOMEINSTITUTO;
	}


	public void setNOMEINSTITUTO(String nOMEINSTITUTO) {
		NOMEINSTITUTO = nOMEINSTITUTO;
	}
}
