package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import comun.UsuariosT;
import comun.UsuariosTLogin;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class VentanaIngresoR extends JFrame {

	private JPanel contentPane;
	public static VentanaEncomiendas miVentanaEncomiendas;
	static UsuariosTLogin miUsuarioLogin;
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaIngresoR frame = new VentanaIngresoR(null);
					frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param miUsuarioLogin 
	 */
	
	public VentanaIngresoR(UsuariosTLogin miUsuarioLogin) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(650, 200, 561, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbBienvenido = new JLabel("BIENVENIDO:");
		lbBienvenido.setForeground(Color.RED);
		lbBienvenido.setFont(new Font("Arial", Font.PLAIN, 20));
		lbBienvenido.setBounds(10, 431, 154, 37);
		contentPane.add(lbBienvenido);
		
		JLabel lblPrivilegio = new JLabel("");
		lblPrivilegio.setFont(new Font("Arial", Font.PLAIN, 20));
		lblPrivilegio.setForeground(Color.ORANGE);
		lblPrivilegio.setBounds(174, 435, 169, 29);
		contentPane.add(lblPrivilegio);
		
		JLabel lblNombreRecpcionista = new JLabel("");
		lblNombreRecpcionista.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNombreRecpcionista.setForeground(Color.ORANGE);
		lblNombreRecpcionista.setBounds(374, 434, 161, 30);
		contentPane.add(lblNombreRecpcionista);
		
		lblNombreRecpcionista.setText(miUsuarioLogin.getCedulaUsuario());
		
		lblPrivilegio.setText(miUsuarioLogin.getTipo());	
		
		JLabel lblNombreEmpresa = new JLabel("ENCOMIENDAS \"DON PAQUETE\"");
		lblNombreEmpresa.setOpaque(true);
		lblNombreEmpresa.setForeground(Color.RED);
		lblNombreEmpresa.setFont(new Font("Arial", Font.BOLD, 25));
		lblNombreEmpresa.setBounds(81, 374, 454, 46);
		contentPane.add(lblNombreEmpresa);
		
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon(VentanaIngresoR.class.getResource("/imagenes/donpaquete - copia.png")));
		lblImagen.setBounds(42, 10, 441, 452);
		contentPane.add(lblImagen);
		
		JButton btnEncomiendas = new JButton("ATENDER ENCOMIENDAS");
		btnEncomiendas.setForeground(Color.WHITE);
		btnEncomiendas.setBackground(Color.GREEN);
		btnEncomiendas.setFont(new Font("Arial", Font.PLAIN, 18));
		btnEncomiendas.setBounds(103, 473, 358, 37);
		contentPane.add(btnEncomiendas);
		
				
		btnEncomiendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				  miVentanaEncomiendas=new VentanaEncomiendas(miUsuarioLogin);
				  miVentanaEncomiendas.setVisible(true);
				 				 
				dispose(); 
			}
		});
		
			
		
	}
	
	
}
