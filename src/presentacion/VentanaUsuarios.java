package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.table.DefaultTableModel;

import comun.UsuariosT;
import comun.UsuariosTLogin;
import logica.Validacion;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VentanaUsuarios extends JFrame {

	private JPanel contentPane;
	private JTextField txNombre;
	private JTextField txApellido;
	private JTextField txCedulaUsuario;
	private JTextField txNombreUsuario;
	private JTextField txClaveAcceso;
	private JTable jtUsuarios;
	static UsuariosTLogin miUsuarioLogin;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaUsuarios frame = new VentanaUsuarios(miUsuarioLogin);
					frame.setVisible(true);
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
	
	public VentanaUsuarios(UsuariosTLogin miUsuarioLogin) {
		addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent arg0) {
				
				VentanaIngresoA.miVentanaUsuarios=null;
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(650, 250, 550, 450);
		
				
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		JMenuItem mntmInicio = new JMenuItem("Inicio");
		mnMenu.add(mntmInicio);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(21, 23, 75, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(21, 62, 75, 14);
		contentPane.add(lblApellido);
		
		JLabel lblCedula = new JLabel("Cedula Usuario");
		lblCedula.setBounds(291, 23, 90, 14);
		contentPane.add(lblCedula);
		
		JLabel lblNombreusuario = new JLabel("NombreUsuario");
		lblNombreusuario.setBounds(292, 62, 99, 14);
		contentPane.add(lblNombreusuario);
		
		JLabel lblClaveacceso = new JLabel("ClaveAcceso");
		lblClaveacceso.setBounds(291, 107, 75, 14);
		contentPane.add(lblClaveacceso);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(21, 107, 75, 14);
		contentPane.add(lblTipo);
		
		JLabel lbUsuarioActual = new JLabel("Usuario Actual:");
		lbUsuarioActual.setBounds(10, 135, 99, 14);
		contentPane.add(lbUsuarioActual);
		
		JLabel lblUsuarioA = new JLabel("");
		lblUsuarioA.setForeground(Color.RED);
		lblUsuarioA.setBounds(144, 135, 118, 14);
		contentPane.add(lblUsuarioA);
		
		lblUsuarioA.setText(miUsuarioLogin.getCedulaUsuario());
				
		
		txNombre = new JTextField();
		txNombre.setBounds(106, 20, 118, 20);
		contentPane.add(txNombre);
		txNombre.setColumns(10);
		
		txApellido = new JTextField();
		txApellido.setColumns(10);
		txApellido.setBounds(106, 59, 118, 20);
		contentPane.add(txApellido);
		
		txCedulaUsuario = new JTextField();
		txCedulaUsuario.setColumns(10);
		txCedulaUsuario.setBounds(389, 20, 118, 20);
		contentPane.add(txCedulaUsuario);
		
		txNombreUsuario = new JTextField();
		txNombreUsuario.setColumns(10);
		txNombreUsuario.setBounds(389, 59, 118, 20);
		contentPane.add(txNombreUsuario);
		
		txClaveAcceso = new JTextField();
		txClaveAcceso.setColumns(10);
		txClaveAcceso.setBounds(389, 104, 118, 20);
		contentPane.add(txClaveAcceso);
		
		
		
		JButton btnCrearUsu = new JButton("Crear Usuario");
		btnCrearUsu.setBackground(Color.GREEN);
		btnCrearUsu.setBounds(177, 339, 166, 23);
		contentPane.add(btnCrearUsu);
		
		JButton btnCargarTabla = new JButton("Actualizar Tabla");
		btnCargarTabla.setBounds(179, 292, 164, 23);
		contentPane.add(btnCargarTabla);	
		
		JButton btnEliminarUsuario = new JButton("Eliminar Usuario");
		btnEliminarUsuario.setBackground(Color.RED);
		btnEliminarUsuario.setBounds(21, 339, 146, 23);
		contentPane.add(btnEliminarUsuario);
		
		
		JButton btnModificarUsuario = new JButton("Modificar Usuario");
		btnModificarUsuario.setBackground(Color.ORANGE);
		btnModificarUsuario.setBounds(372, 339, 135, 23);
		contentPane.add(btnModificarUsuario);
		
		JComboBox comboTipo = new JComboBox();
		comboTipo.setModel(new DefaultComboBoxModel(new String[] {"", "Administrador", "Recepcionista"}));
		comboTipo.setBounds(106, 104, 118, 20);
		contentPane.add(comboTipo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 160, 452, 121);
		contentPane.add(scrollPane);
		
		
		jtUsuarios = new JTable();
		jtUsuarios.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(jtUsuarios);
		
		jtUsuarios.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"Nombre", "Apellido", "Cedula", "Usuario", "Clave","Tipo"
			}
		));
		
						
        jtUsuarios.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				int fila = jtUsuarios.getSelectedRow();
				txNombre.setText(jtUsuarios.getValueAt(fila, 0).toString());
				txApellido.setText(jtUsuarios.getValueAt(fila, 1).toString());
				txCedulaUsuario.setText(jtUsuarios.getValueAt(fila, 2).toString());
				txNombreUsuario.setText(jtUsuarios.getValueAt(fila, 3).toString());
				txClaveAcceso.setText(jtUsuarios.getValueAt(fila, 4).toString());
				comboTipo.setSelectedItem(jtUsuarios.getValueAt(fila, 5));
				btnCrearUsu.setEnabled(false);	
				//txCedulaUsuario.setEnabled(false);
			}
		});
		
		
        
		
		btnCrearUsu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Validacion miValidacion=new Validacion();
				UsuariosT miUsuarioT=new UsuariosT();
				
				try{														
					miUsuarioT.setNombreusuario(txNombreUsuario.getText());
					miUsuarioT.setClaveacceso(txClaveAcceso.getText());
					miUsuarioT.setApellido(txApellido.getText());
					miUsuarioT.setCedulaUsuario(txCedulaUsuario.getText());
					miUsuarioT.setNombre(txNombre.getText());
													
				    miUsuarioT.setTipo(comboTipo.getSelectedItem().toString());   
	 				
					miValidacion.crearUsuario(miUsuarioT);
				 
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos");
				                                                   } 
									                                                     
				 txNombreUsuario.setText("");
			    	txClaveAcceso.setText("");
			    	txApellido.setText("");
			    	txCedulaUsuario.setText("");
			    	txNombre.setText("");
			    	comboTipo.setSelectedIndex(0);
				}				
				
			});
		
				
		
		btnCargarTabla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Validacion miValidacion=new Validacion();
				DefaultTableModel modelo;
				modelo=new DefaultTableModel();
				modelo.addColumn("Nombre");
				modelo.addColumn("Apellido");
				modelo.addColumn("Cedula");
				modelo.addColumn("Usuario");
				modelo.addColumn("Clave");
				modelo.addColumn("Tipo");
				
				ArrayList<Object[]> datosUsuarios= miValidacion.buscarTablaUsuarios();
				
				for(int f=0;f<datosUsuarios.size();f++) {
					modelo.addRow(datosUsuarios.get(f));
				}
				
				jtUsuarios.setModel(modelo);	
													
			}
		});
		
		
		
				
		btnEliminarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			int respuestaEliminar=JOptionPane.showConfirmDialog(null, "Esta a punto de eliminar un usuario. ¿Desea continuar?");
			
				if(JOptionPane.OK_OPTION==respuestaEliminar) {
				
				Validacion miValidacion=new Validacion();
                UsuariosT miUsuarioT=new UsuariosT();

              if( (jtUsuarios.getSelectedRow())!=-1) {
                    
                    miUsuarioT.setCedulaUsuario((String) jtUsuarios.getValueAt(jtUsuarios.getSelectedRow(),2));  
                                       
                      if(!miUsuarioLogin. getCedulaUsuario().equals((String) jtUsuarios.getValueAt(jtUsuarios.getSelectedRow(),2))){
                     miValidacion.eliminarUsuario(miUsuarioT);
                     }else {
                    	 JOptionPane.showMessageDialog(null,"No se puede eliminar a si mismo");
                     }
                    
                               
                 
              }else {JOptionPane.showMessageDialog(null,"No se puede eliminar si no selecciona directamente de la tabla");
                
              
              } 
                txNombreUsuario.setText("");
		    	txClaveAcceso.setText("");
		    	txApellido.setText("");
		    	txCedulaUsuario.setText("");
		    	txNombre.setText("");
		    	comboTipo.setSelectedIndex(0);
		    	btnCrearUsu.setEnabled(true);	
                                       
			}else {
				
			}
			}		
		});
				
		
		
					
		btnModificarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Validacion miValidacion=new Validacion();
				UsuariosT miUsuarioT=new UsuariosT();
				try{		
													
					miUsuarioT.setNombreusuario(txNombreUsuario.getText());
					miUsuarioT.setClaveacceso(txClaveAcceso.getText());
					miUsuarioT.setApellido(txApellido.getText());
					miUsuarioT.setCedulaUsuario(txCedulaUsuario.getText());
					miUsuarioT.setNombre(txNombre.getText());
					miUsuarioT.setTipo((String) comboTipo.getSelectedItem());   
					txCedulaUsuario.setEnabled(true);;
					
					miValidacion.modificarUsuario(txCedulaUsuario.getText(), miUsuarioT);
					
					txNombreUsuario.setText("");
			    	txClaveAcceso.setText("");
			    	txApellido.setText("");
			    	txCedulaUsuario.setText("");
			    	txNombre.setText("");
			    	comboTipo.setSelectedIndex(0);
			    	btnCrearUsu.setEnabled(true);	
				}catch (Exception ex) {
						JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos");
					                                                   } 				
				}		
		});
		
		
		
		
		mntmInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaIngresoA miVentanaIngresoA = new VentanaIngresoA(miUsuarioLogin);
				miVentanaIngresoA.setVisible(true);
				
			}
		});
		
				
		
	}   
	
}		
