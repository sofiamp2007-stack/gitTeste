package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import telas.Tela01; 

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField TFusuario;
	private JTextField TFsenha;
	private String user = "prof B2";
	private String senha = "B2";
	private Usuario usuario; 

	
	 private Tela01 resultado; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro frame = new Cadastro();
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
	public Cadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setLocationRelativeTo(null);
		setResizable(false);
		
		JLabel TF = new JLabel("Usuário");
		TF.setBounds(139, 84, 76, 12);
		contentPane.add(TF);
		
		JLabel lblNewLabel_1 = new JLabel("Senha ");
		lblNewLabel_1.setBounds(139, 135, 44, 12);
		contentPane.add(lblNewLabel_1);
		
		TFusuario = new JTextField();
		TFusuario.setBounds(225, 81, 96, 18);
		contentPane.add(TFusuario);
		TFusuario.setColumns(10);
		
		TFsenha = new JTextField();
		TFsenha.setBounds(225, 132, 96, 18);
		contentPane.add(TFsenha);
		TFsenha.setColumns(10);
		
		
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


                usuario = new Usuario(TFusuario.getText(), TFsenha.getText());

        
                if (usuario.getUsuario().equals(user) && usuario.getSenha().equals(senha)) {
                    JOptionPane.showMessageDialog(null, "Usuário logado com sucesso");

                    Tela01 tela = new Tela01();
                    tela.setVisible(true);

                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário e/ou senha incorreta");
                    TFusuario.setText("");
                    TFsenha.setText("");
                    TFusuario.requestFocus();
                }
				
					
				
			
			}}
			
		);
		btnNewButton.setBounds(176, 180, 84, 20);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Cadastro");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(188, 27, 84, 12);
		contentPane.add(lblNewLabel_2);

			}
}
