package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela01 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfNumero;
	private JTable table;
	private JTable table_1;
	
	private DefaultTableModel modeloTabela; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela01 frame = new Tela01();
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
	public Tela01() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sistema dos professores ");
		lblNewLabel.setBounds(230, 11, 135, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome do aluno:");
		lblNewLabel_1.setBounds(30, 59, 107, 14);
		contentPane.add(lblNewLabel_1);
		
		tfNome = new JTextField();
		tfNome.setBounds(137, 56, 86, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Número de alunos cadastrados na sala:");
		lblNewLabel_2.setBounds(30, 98, 240, 14);
		contentPane.add(lblNewLabel_2);
		
		tfNumero = new JTextField();
		tfNumero.setBounds(247, 95, 86, 20);
		contentPane.add(tfNumero);
		tfNumero.setColumns(10);
		
		table = new JTable();
		table.setBounds(293, 224, 1, 1);
		contentPane.add(table);
		
		JScrollPane Tabela = new JScrollPane();
		Tabela.setBounds(30, 139, 368, 185);
		contentPane.add(Tabela);
		
		table_1 = new JTable(modeloTabela);
		table_1.setModel(new DefaultTableModel(new Object[][] {},
			new String[] {
				"Nome Completo", "Participou da atividade"
			}
		));
		Tabela.setViewportView(table_1);
		
		JLabel lblNewLabel_3 = new JLabel("Paticipou da atividade proposta?");
		lblNewLabel_3.setBounds(341, 52, 178, 14);
		contentPane.add(lblNewLabel_3);
		
		JRadioButton rdbtnSim = new JRadioButton("Sim");
		rdbtnSim.setBounds(515, 48, 49, 23);
		contentPane.add(rdbtnSim);
		
		JRadioButton rdbtnNao = new JRadioButton("Não");
		rdbtnNao.setBounds(576, 48, 49, 23);
		contentPane.add(rdbtnNao);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String nome = tfNome.getText().trim(); 
		    String numero = ""; 
		    
		    if (rdbtnSim.isSelected()) {
            	numero= "Sim"; 
            } else if (rdbtnNao.isSelected()) {
            	numero = "Não"; 
           }
		
				if (!nome.isEmpty() && !nome.isEmpty()){
				modeloTabela.addRow(new Object[] {nome}); 
				tfNome.setText("");// pra apagar
				tfNome.setText(""); 
				tfNome.requestFocus(); // cursor parado no nome 
			}
				 }}
			);
		btnNewButton.setBounds(448, 178, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Alterar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(448, 232, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Excluir");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(448, 284, 89, 23);
		contentPane.add(btnNewButton_2);

	}
}
