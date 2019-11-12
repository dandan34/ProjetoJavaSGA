package system;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JTextField;

import academicoFront.CadastroDep;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;


public class Inicializar {

	private JFrame frame;
	private JTextField txNomeInst;

	/*
	 * Retorna nome da instituição
	 */
	public String getNome() {

		return this.txNomeInst.getText();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicializar window = new Inicializar();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Inicializar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.window);
		frame.setBounds(100, 100, 560, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		txNomeInst = new JtextFieldSomenteLetras(20);
		txNomeInst.setBounds(126, 187, 306, 20);
		frame.getContentPane().add(txNomeInst);
		txNomeInst.setColumns(10);

		JLabel lblInsiraONome = new JLabel("Insira o nome da Institui\u00E7\u00E3o");
		lblInsiraONome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInsiraONome.setBounds(174, 162, 218, 14);
		frame.getContentPane().add(lblInsiraONome);

		JButton btnCriarInst = new JButton("Criar");
		btnCriarInst.setForeground(Color.BLUE);
		btnCriarInst.setBackground(new Color(255, 255, 255));
		btnCriarInst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (txNomeInst.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Campo Vazio!");
					} else {
						JOptionPane.showMessageDialog(null, "Sistema " + txNomeInst.getText() + " criado com sucesso!");
						CadastroDep x = new CadastroDep();			
						x.setVisible(true);
						frame.dispose();
					
					}
				} catch (Exception e2) {

					JOptionPane.showMessageDialog(null, "ERRO!");
				}
			}
		});
		btnCriarInst.setBounds(238, 218, 89, 23);
		frame.getContentPane().add(btnCriarInst);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(255, 255, 255));
		btnCancelar.setForeground(Color.RED);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.exit(0);
			}
		});
		btnCancelar.setBounds(238, 244, 89, 23);
		frame.getContentPane().add(btnCancelar);
	}
}
