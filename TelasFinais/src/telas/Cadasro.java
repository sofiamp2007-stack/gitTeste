package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cadasro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField TFusuario;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadasro frame = new Cadasro();
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
	public Cadasro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuário ");
		lblNewLabel.setBounds(118, 91, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel TFsenha = new JLabel("Senha");
		TFsenha.setBounds(118, 150, 46, 14);
		contentPane.add(TFsenha);
		
		TFusuario = new JTextField();
		TFusuario.setBounds(207, 88, 86, 20);
		contentPane.add(TFusuario);
		TFusuario.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(207, 147, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(167, 202, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Cadastro professores");
		lblNewLabel_2.setBounds(155, 33, 121, 14);
		contentPane.add(lblNewLabel_2);

	}
}
