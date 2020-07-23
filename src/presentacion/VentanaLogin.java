package presentacion;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import comun.UsuariosT;
import comun.UsuariosTLogin;
import logica.Validacion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;


public class VentanaLogin extends JFrame {

	private JPanel contentPane;
	
	private JTextField txNombreUsuario;
	private JPasswordField passClave;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin frame = new VentanaLogin();
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
	
	public VentanaLogin() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(600, 200, 620, 615);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreUsuario = new JLabel("USUARIO");
		lblNombreUsuario.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNombreUsuario.setBounds(72, 435, 83, 40);
		contentPane.add(lblNombreUsuario);
		
		JLabel lblClaveAcceso = new JLabel("CLAVE");
		lblClaveAcceso.setFont(new Font("Arial", Font.PLAIN, 15));
		lblClaveAcceso.setBounds(72, 486, 83, 27);
		contentPane.add(lblClaveAcceso);
		

		JLabel lblNombreEmpresa = new JLabel("ENCOMIENDAS \"DON PAQUETE\"");
		lblNombreEmpresa.setOpaque(true);
		lblNombreEmpresa.setForeground(Color.RED);
		lblNombreEmpresa.setFont(new Font("Arial", Font.BOLD, 28));
		lblNombreEmpresa.setBounds(79, 384, 515, 46);
		contentPane.add(lblNombreEmpresa);
		
		
		//Icon iconoFondo=new ImageIcon(imagenFondo.getImage().getScaledInstance(lblFondoImagen.getWidth(), lblFondoImagen.getHeight(),Image.SCALE_DEFAULT)); Por si quiero modificar tamaño imagen
		//lblFondoImagen.setIcon(iconoFondo); 
		
		
		
		txNombreUsuario = new JTextField();
		txNombreUsuario.setFont(new Font("Arial", Font.PLAIN, 15));
		txNombreUsuario.setBounds(165, 441, 272, 29);
		contentPane.add(txNombreUsuario);
		txNombreUsuario.setColumns(10);
		
		
		JButton btnIngresar = new JButton("INICIAR SESION");
		btnIngresar.setForeground(Color.WHITE);
		btnIngresar.setBackground(Color.GREEN);
		btnIngresar.setFont(new Font("Arial", Font.PLAIN, 18));
		btnIngresar.setDoubleBuffered(true);
		btnIngresar.setBounds(135, 524, 334, 40);
		contentPane.add(btnIngresar);
		
		passClave = new JPasswordField();
		passClave.setBounds(165, 486, 272, 29);
		passClave.setFont(new Font("Arial", Font.PLAIN, 15));
		contentPane.add(passClave);
		
	   	
		JLabel lblFondoImagen = new JLabel("");
		lblFondoImagen.setIcon(new ImageIcon(VentanaLogin.class.getResource("/imagenes/donpaquete - copia.png")));
		lblFondoImagen.setBounds(69, 11, 488, 456);
		contentPane.add(lblFondoImagen);
		
		
		
					
		
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Validacion miValidacionLogin=new Validacion();	
				UsuariosTLogin miUsuarioLogin=new UsuariosTLogin();
				
				String pase=new String(passClave.getPassword());

				// String paseoculto=hash.saha1(pase);     encripto el pase
				//miUsuarioLogin.setClaveacceso(paseoculto);
				
				
				miUsuarioLogin.setNombreusuario(txNombreUsuario.getText());
				miUsuarioLogin.setClaveacceso(pase);
				
				miValidacionLogin.validarLogin(miUsuarioLogin);
										
				
			      dispose();
								
		}
		});
						 
	}
}

