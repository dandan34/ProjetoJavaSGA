package academicoFront;

import java.awt.EventQueue;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;

import academicoBack.Departamento;
import alunoFront.CadastroAluno;
import system.Base;
import system.SystemLogin;

import javax.swing.event.ListSelectionEvent;
import java.awt.Color;
import java.awt.Font;

public class CadastroDep extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txNomeDP;
	private JTextField txCodDP;
	private JButton btAcessarDP;
	private JButton btDelDP;
	private JList<String> list;
	private int index;
	private SGDep dPControle;
	private ArrayList<Departamento> DP;

	private Base BASE;

	/*
	 * Controles departamentos
	 */
	public Boolean addDepartamento(String nome, String codigo) {

		Boolean testa = true;

		for (int i = 0; i < DP.size(); i++) {

			if (this.DP.get(i).getCodigo().equals(codigo)) {

				testa = false;
				break;
			}
		}

		if (testa == true) {

			Departamento dpt = new Departamento(nome, codigo);
			DP.add(dpt);
			return true;
		} else {
			return false;
		}

	}

	public String[] imprimeDPTexistentes() {

		String st[] = new String[DP.size()];

		for (int i = 0; i < DP.size(); i++) {

			st[i] = DP.get(i).getCodigo() + "   " + DP.get(i).getNome();
		}
		return st;
	}

	public ArrayList<Departamento> getDPTS() {

		return this.DP;
	}

	public void setDPTS(ArrayList<Departamento> x) {

		this.DP = x;
	}

	public void mostrarListaDP() {

		if (DP.size() >= 0) {

			DefaultListModel<String> ls = new DefaultListModel<String>();
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			String st[] = imprimeDPTexistentes();

			for (int i = 0; i < DP.size(); i++) {

				ls.addElement(st[i]);
			}

			list.setModel(ls);

		}
	}

	public Departamento acess(int index) {

		return DP.get(index);

	}

	public void delete(int index) {

		DP.remove(index);
		JOptionPane.showMessageDialog(null, "REMOVIDO COM SUCESSO");
	}

	public void setValorIndex(int index) {
		this.index = index;
	}

	public int getValorIndex() {

		return this.index;
	}

	/*
	 * lauch
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroDep frame = new CadastroDep();
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

	public CadastroDep() {
		
		this.DP = new ArrayList<Departamento>();
		dPControle = new SGDep();
		this.setBASE(new Base());
		BASE.setDepartamentosDoInstituto(DP);
		setValorIndex(0);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 867, 508);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Cadastrar Departamento");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(46, 9, 247, 34);
		contentPane.add(lblNewLabel);

		txNomeDP = new JTextField();
		txNomeDP.setBounds(72, 54, 147, 20);
		contentPane.add(txNomeDP);
		txNomeDP.setColumns(10);

		txCodDP = new JTextField();
		txCodDP.setBounds(72, 85, 147, 20);
		contentPane.add(txCodDP);
		txCodDP.setColumns(10);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 57, 48, 14);
		contentPane.add(lblNome);

		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 88, 68, 14);
		contentPane.add(lblCodigo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 237, 263, 221);
		contentPane.add(scrollPane);

		list = new JList<>();

		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {

				int index = list.getSelectedIndex();
				setValorIndex(index);

			}

		});

		JButton btnCadastrarDP = new JButton("Cadastrar");
		btnCadastrarDP.setForeground(Color.BLUE);
		btnCadastrarDP.setBackground(new Color(255, 255, 255));
		btnCadastrarDP.setBounds(117, 116, 102, 23);
		btnCadastrarDP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txNomeDP.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Campo nome Vazio!");
				} else {
					if (txCodDP.getText().equals("")) {

						JOptionPane.showMessageDialog(null, "Campo codigo Vazio!");
					} else {
						if (addDepartamento(txNomeDP.getText(), txCodDP.getText()) == true) {

							JOptionPane.showMessageDialog(null, "Departamento Registrado com sucesso!");
							mostrarListaDP();

						} else {
							JOptionPane.showMessageDialog(null, "Departamento já existente, tente outro codigo!");
						}

					}
				}
			}
		});

		contentPane.add(btnCadastrarDP);

		btAcessarDP = new JButton("Acessar");
		btAcessarDP.setForeground(Color.BLUE);
		btAcessarDP.setBackground(new Color(255, 255, 255));
		btAcessarDP.setBounds(283, 237, 92, 28);
		contentPane.add(btAcessarDP);

		btDelDP = new JButton("Deletar");
		btDelDP.setForeground(Color.RED);
		btDelDP.setBackground(new Color(255, 255, 255));
		btDelDP.setBounds(283, 268, 92, 28);
		contentPane.add(btDelDP);

		scrollPane.setRowHeaderView(list);
		scrollPane.setViewportView(list);

		JLabel lblCodigo_1 = new JLabel("Codigo");
		lblCodigo_1.setBounds(10, 216, 48, 14);
		contentPane.add(lblCodigo_1);

		JLabel lblNome_1 = new JLabel("Nome");
		lblNome_1.setBounds(117, 216, 48, 14);
		contentPane.add(lblNome_1);

		JLabel lblDepartamentosCadastrados = new JLabel("Departamentos Cadastrados");
		lblDepartamentosCadastrados.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDepartamentosCadastrados.setBounds(46, 188, 187, 14);
		contentPane.add(lblDepartamentosCadastrados);

		JButton btnNewButton = new JButton("Matricular Aluno");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CadastroAluno cadastrarAluno = new CadastroAluno();
				cadastrarAluno.setVisible(true);
				cadastrarAluno.comboBox(DP);
				cadastrarAluno.setDPTS(getDPTS());
				cadastrarAluno.setBASE(getBASE());
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(468, 188, 311, 114);
		contentPane.add(btnNewButton);
		
		JButton btnTesteLogin = new JButton("TESTE  LOGIN");
		btnTesteLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SystemLogin login = new SystemLogin();
				login.setBASE(getBASE());
				login.setVisible(true);
				
			}
		});
		btnTesteLogin.setBounds(575, 395, 134, 23);
		contentPane.add(btnTesteLogin);

		btDelDP.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (list.getSelectedIndex() >= 0) {

					delete(getValorIndex());
					mostrarListaDP();

				}

			}
		});

		btAcessarDP.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (list.getSelectedIndex() >= 0) {

					acessarDPT();
				}

			}
		});
	}
	
	public void acessarDPT() {
		
		dPControle.insereDP(acess(getValorIndex()));
		dPControle.mostrarListaCR();
		dPControle.mostrarListaPRF();
		dPControle.setBASE(getBASE());
		dPControle.setVisible(true);
		
	}

	public Base getBASE() {
		return BASE;
	}

	public void setBASE(Base bASE) {
		BASE = bASE;
	}

	public SGDep getdPControle() {
		return dPControle;
	}

	public void setdPControle(SGDep dPControle) {
		this.dPControle = dPControle;
	}
}
