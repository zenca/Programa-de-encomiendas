package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import comun.UsuariosT;
import comun.UsuariosTLogin;
import logica.Validacion;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;

public class VentanaIngresoA extends JFrame {
/*
 * 
 */
	private JPanel contentPane;

	public static VentanaEncomiendas miVentanaEncomiendasA; 
    public static VentanaUsuarios miVentanaUsuarios;
    static UsuariosTLogin miUsuarioLogin;
    
	 /*
	 */
	
    
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaIngresoA frame = new VentanaIngresoA(miUsuarioLogin);
					frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * 
	 */
	
	public VentanaIngresoA(UsuariosTLogin miUsuarioLogin) {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(650, 200, 675, 615);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbBienvenido = new JLabel("BIENVENIDO:");
		lbBienvenido.setForeground(Color.RED);
		lbBienvenido.setFont(new Font("Arial", Font.PLAIN, 20));
		lbBienvenido.setBounds(10, 449, 167, 39);
		contentPane.add(lbBienvenido);
		
		JLabel lblCategoria = new JLabel("New label");
		lblCategoria.setForeground(Color.ORANGE);
		lblCategoria.setFont(new Font("Arial", Font.PLAIN, 25));
		lblCategoria.setBounds(194, 452, 207, 29);
		contentPane.add(lblCategoria);
		
		JLabel lblCUsuario = new JLabel("New label");
		lblCUsuario.setForeground(Color.ORANGE);
		lblCUsuario.setFont(new Font("Arial", Font.PLAIN, 25));
		lblCUsuario.setBounds(443, 447, 206, 39);
		contentPane.add(lblCUsuario);
		
				
		JLabel lblNombreEmpresa = new JLabel("ENCOMIENDAS \"DON PAQUETE\"");
		lblNombreEmpresa.setOpaque(true);
		lblNombreEmpresa.setForeground(Color.RED);
		lblNombreEmpresa.setFont(new Font("Arial", Font.BOLD, 25));
		lblNombreEmpresa.setBounds(127, 403, 459, 46);
		contentPane.add(lblNombreEmpresa);
		
        lblCUsuario.setText(miUsuarioLogin.getCedulaUsuario());
		
		lblCategoria.setText(miUsuarioLogin.getTipo());	
		
		JLabel lblImagenFondoA = new JLabel("");
		lblImagenFondoA.setIcon(new ImageIcon(VentanaIngresoA.class.getResource("/imagenes/ghfghgh.png")));
		lblImagenFondoA.setBounds(60, 0, 562, 503);
		contentPane.add(lblImagenFondoA);
		
			
		JButton btnEncomiendas = new JButton("ATENDER ENCOMIENDAS");
		btnEncomiendas.setBackground(Color.GREEN);
		btnEncomiendas.setForeground(Color.WHITE);
		btnEncomiendas.setFont(new Font("Arial", Font.PLAIN, 18));
		btnEncomiendas.setBounds(25, 514, 276, 39);
		contentPane.add(btnEncomiendas);
		
				
		JButton btnUsuarios = new JButton("CREAR USUARIOS");
		btnUsuarios.setBackground(Color.ORANGE);
		btnUsuarios.setForeground(Color.WHITE);
		btnUsuarios.setFont(new Font("Arial", Font.PLAIN, 18));
		btnUsuarios.setBounds(396, 514, 226, 39);
		contentPane.add(btnUsuarios);
		
				
		
		btnEncomiendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
								
				 if(miVentanaEncomiendasA==null){
				  miVentanaEncomiendasA=new VentanaEncomiendas(miUsuarioLogin);
				  miVentanaEncomiendasA.setVisible(true);
								 
			dispose(); 
											
				 }	
			}
		});
		
		
		
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				  if(miVentanaUsuarios==null){
				  miVentanaUsuarios=new VentanaUsuarios(miUsuarioLogin);
				  miVentanaUsuarios.setVisible(true);
				  
				  dispose();
				  }
											
			}
		});
		
		
}
	
}
