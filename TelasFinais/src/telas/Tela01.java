package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
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
	private int linhaAlteracao = -1; 

	 protected JTextArea taResultado = new JTextArea(); 
	 

	
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
		
		setLocationRelativeTo(null);
		setResizable(false);
		
		JLabel lblNewLabel = new JLabel("Sistema dos professores ");
		lblNewLabel.setBounds(230, 11, 178, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome do aluno:");
		lblNewLabel_1.setBounds(30, 59, 107, 14);
		contentPane.add(lblNewLabel_1);
		
		tfNome = new JTextField();
		tfNome.setBounds(137, 56, 86, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Número de alunos cadastrados na sala:");
		lblNewLabel_2.setBounds(30, 98, 229, 14);
		contentPane.add(lblNewLabel_2);
		
		tfNumero = new JTextField();
		tfNumero.setBounds(269, 96, 86, 20);
		contentPane.add(tfNumero);
		tfNumero.setColumns(10);
		
		table = new JTable();
		table.setBounds(293, 224, 1, 1);
		contentPane.add(table);
		
		JScrollPane Tabela = new JScrollPane();
		Tabela.setBounds(30, 139, 368, 185);
		contentPane.add(Tabela);
		
		//coloca os campos na tabla 
				modeloTabela = new DefaultTableModel(new Object[] {"Nome Completo", "Participou da atividade"}, 0); 
				
		table_1 = new JTable(modeloTabela);

		Tabela.setViewportView(table_1);
		
		JLabel lblNewLabel_3 = new JLabel("Paticipou da atividade proposta?");
		lblNewLabel_3.setBounds(293, 52, 223, 14);
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
			 
		    if( linhaAlteracao >= 0) {
        		
        		modeloTabela.setValueAt(nome, linhaAlteracao, 0);
        		modeloTabela.setValueAt(numero, linhaAlteracao,1);
        		linhaAlteracao = -1; 
		    } else { modeloTabela.addRow(new Object[] {nome, numero}); 
		              }
				tfNome.setText("");
				tfNome.requestFocus(); 
		}
				 
		});
		btnNewButton.setBounds(448, 141, 107, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Alterar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int  linhaSelecionada = table_1.getSelectedRow();
        		if (linhaSelecionada  >=0) {
        			
        			linhaAlteracao = linhaSelecionada; 
        			
        			String nome = modeloTabela.getValueAt(linhaSelecionada, 0).toString();
        			
        			String numero= modeloTabela.getValueAt(linhaSelecionada, 1).toString(); 
        			if (numero.equals("Sim")) {
        				rdbtnSim.setSelected(true);
        				rdbtnNao.setSelected(false);	
        			} else if (numero.equals("Não")) {
        				rdbtnSim.setSelected(false);
        				rdbtnNao.setSelected(true);	
        			}
        		
        			tfNome.setText(nome);
        			
        			
        			
        		} else {
        			JOptionPane.showMessageDialog(null, "Selecione uma linha para alerar"); 
        		}
        	}
				
			});
		
		btnNewButton_1.setBounds(448, 189, 107, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Excluir");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = table_1.getSelectedRow(); 
        		if (linhaSelecionada >= 0 ) {
        			modeloTabela.removeRow(linhaSelecionada); 
        		} else {
        			
        			JOptionPane.showMessageDialog(null, "Selecione uma linha para excluir");
        		
        		}
				
			}
		}
				
			
		);
		btnNewButton_2.setBounds(448, 236, 107, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Concluir ");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int total_linhas = modeloTabela.getRowCount();
				int faltantes = 0; 
				
				for (int i=0; i< total_linhas; i++) {
				    String participou = modeloTabela.getValueAt(i, 1).toString();
		            
				    if(participou.equalsIgnoreCase("Não")) {
				    	faltantes++;
				    }
		        }

				JOptionPane.showMessageDialog(null, "Total de alunos faltantes: " +faltantes);
		        dispose();
		    }
		});
		
		btnNewButton_3.setBounds(448, 285, 107, 20);
		contentPane.add(btnNewButton_3);
		
	
		

	}
}
