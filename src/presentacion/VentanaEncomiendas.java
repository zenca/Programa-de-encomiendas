package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import comun.ClientesT;
import comun.EncomiendasT;
import comun.UsuariosT;
import comun.UsuariosTLogin;
import logica.Validacion;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;

public class VentanaEncomiendas extends JFrame {

	private JPanel contentPane;
	private JTextField txNombreR;
	private JTextField txNombreD;
	private JTextField txCedulaC;
	private JTextField txTelefono;
	private JTextField txDireccionD;
	private JTable jtEncomiendas;
	private JTextField txCodigo;
	private JTextField txBuscarPorCodigo;
	private JTextField txtIngreseElNombre;
	private JTable jtTablaBuscar;
	
	static UsuariosTLogin miUsuarioLogin;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEncomiendas frame = new VentanaEncomiendas(miUsuarioLogin);
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
	
	
	public VentanaEncomiendas(UsuariosTLogin miUsuarioLogin) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				
				VentanaIngresoA.miVentanaEncomiendasA=null;
			}
		});                                  
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(550, 200, 875, 700);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		JMenuItem mntmInicio = new JMenuItem("Inicio");
		mnMenu.add(mntmInicio);
		
		if(miUsuarioLogin.getTipo().equals("Administrador")){	
			
			mntmInicio.setEnabled(true);
			
			}else{mntmInicio.setEnabled(false);
	                   		
		}
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreR = new JLabel("NombreRemitente");
		lblNombreR.setBounds(10, 65, 112, 14);
		contentPane.add(lblNombreR);
		
		JLabel lblNombreD = new JLabel("Nombre Destinatario");
		lblNombreD.setBounds(10, 96, 120, 14);
		contentPane.add(lblNombreD);
		
		JLabel lblCedulaC = new JLabel("Cedula Cliente");
		lblCedulaC.setBounds(10, 34, 97, 20);
		contentPane.add(lblCedulaC);
		
		JLabel lblDireccionR = new JLabel("Direccion Destino");
		lblDireccionR.setBounds(10, 133, 105, 14);
		contentPane.add(lblDireccionR);
		
		JLabel lblTipoE = new JLabel("Tipo Paquete");
		lblTipoE.setBounds(379, 96, 77, 14);
		contentPane.add(lblTipoE);
		
		JLabel lblOrigen = new JLabel("Origen");
		lblOrigen.setBackground(new Color(240, 240, 240));
		lblOrigen.setBounds(379, 37, 55, 14);
		contentPane.add(lblOrigen);
		
		JLabel lblDestino = new JLabel("Destino");
		lblDestino.setBounds(379, 65, 55, 14);
		contentPane.add(lblDestino);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(10, 158, 97, 14);
		contentPane.add(lblTelefono);
		
		JLabel lblObservaciones = new JLabel("Observaciones");
		lblObservaciones.setBounds(379, 127, 89, 14);
		contentPane.add(lblObservaciones);
		
		JLabel lblNombreUsuario = new JLabel("Usuario Actual");
		lblNombreUsuario.setBounds(288, 186, 120, 14);
		contentPane.add(lblNombreUsuario);
		
		JLabel lblCategoriaUsuario = new JLabel("Privilegios");
		lblCategoriaUsuario.setBounds(561, 186, 120, 14);
		contentPane.add(lblCategoriaUsuario);
		
		JLabel lblCeUsuario = new JLabel("");
		lblCeUsuario.setForeground(Color.RED);
		lblCeUsuario.setBounds(427, 186, 112, 14);
		contentPane.add(lblCeUsuario);
		
		JLabel lblCatUsuario = new JLabel("");
		lblCatUsuario.setForeground(Color.RED);
		lblCatUsuario.setBounds(691, 186, 121, 14);
		contentPane.add(lblCatUsuario);
						
		lblCeUsuario.setText(miUsuarioLogin.getCedulaUsuario());
		
		lblCatUsuario.setText(miUsuarioLogin.getTipo());
		
		
		
		txNombreR = new JTextField();
		txNombreR.setBounds(132, 62, 149, 20);
		contentPane.add(txNombreR);
		txNombreR.setColumns(10);
		
		txNombreD = new JTextField();
		txNombreD.setColumns(10);
		txNombreD.setBounds(132, 93, 149, 20);
		contentPane.add(txNombreD);
		
		txCedulaC = new JTextField();
		txCedulaC.setDisabledTextColor(Color.RED);
		txCedulaC.setColumns(10);
		txCedulaC.setBounds(132, 31, 149, 20);
		contentPane.add(txCedulaC);
		
		txTelefono = new JTextField();
		txTelefono.setColumns(10);
		txTelefono.setBounds(132, 155, 149, 20);
		contentPane.add(txTelefono);
		
		txDireccionD = new JTextField();
		txDireccionD.setColumns(10);
		txDireccionD.setBounds(132, 124, 149, 20);
		contentPane.add(txDireccionD);
		
		txCodigo = new JTextField();
		txCodigo.setDisabledTextColor(Color.RED);
		txCodigo.setColumns(10);
		txCodigo.setBounds(10, 183, 70, 20);
		contentPane.add(txCodigo);
		txCodigo.setVisible(false);
		
		
		txtIngreseElNombre = new JTextField();
		txtIngreseElNombre.setForeground(Color.LIGHT_GRAY);
		txtIngreseElNombre.setText("Ingrese Nombre Remitente");
		txtIngreseElNombre.setBounds(215, 487, 178, 20);
		contentPane.add(txtIngreseElNombre);
		txtIngreseElNombre.setColumns(10);
		
		txBuscarPorCodigo = new JTextField();
		txBuscarPorCodigo.setForeground(Color.GRAY);
		txBuscarPorCodigo.setText("Ingrese Codigo");
		txBuscarPorCodigo.setBounds(691, 487, 129, 20);
		contentPane.add(txBuscarPorCodigo);
		txBuscarPorCodigo.setColumns(10);
		
		JButton btnIngresarEncomienda = new JButton("INGRESAR");
		btnIngresarEncomienda.setBackground(Color.GREEN);
		btnIngresarEncomienda.setBounds(379, 440, 120, 23);
		contentPane.add(btnIngresarEncomienda);
		
		JButton btnDespachar = new JButton("DESPACHAR");
		btnDespachar.setEnabled(false);
		btnDespachar.setBackground(Color.ORANGE);
		btnDespachar.setBounds(665, 440, 120, 23);
		contentPane.add(btnDespachar);
						
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setEnabled(false);
		btnCancelar.setBackground(Color.RED);
		btnCancelar.setBounds(60, 440, 120, 23);
		contentPane.add(btnCancelar);
		
		JButton btnActualizarTabla = new JButton("ACTUALIZAR TABLA");
		btnActualizarTabla.setBounds(354, 390, 170, 23);
		contentPane.add(btnActualizarTabla);
		
		JButton btnBuscarPorCodigo = new JButton(" BUSCAR POR CODIGO");
		btnBuscarPorCodigo.setBounds(509, 486, 172, 23);
		contentPane.add(btnBuscarPorCodigo);
		
		JButton btnBuscarPorRemitente = new JButton("BUSCAR POR REMITENTE");
		btnBuscarPorRemitente.setBounds(20, 486, 185, 23);
		contentPane.add(btnBuscarPorRemitente);
		
		JComboBox comboTipoE = new JComboBox();
		comboTipoE.setModel(new DefaultComboBoxModel(new String[] {"Peque\u00F1o", "Mediano", "Grande"}));
		comboTipoE.setBounds(481, 93, 129, 20);
		contentPane.add(comboTipoE);
		
		JComboBox comboObservaciones = new JComboBox();
		comboObservaciones.setModel(new DefaultComboBoxModel(new String[] {"Fr\u00E1gil", "Pesado", "L\u00EDquido"}));
		comboObservaciones.setBounds(481, 124, 129, 20);
		contentPane.add(comboObservaciones);
		
		JComboBox comboDestino = new JComboBox();
		comboDestino.setModel(new DefaultComboBoxModel(new String[] {"Montevideo", "Artigas", "Salto", "Paysandu", "Rio Negro", "Colonia", "Tacuarembo", "Durazno", "Rivera", "Flores", "Florida", "Rocha", "Maldonado"}));
		comboDestino.setBounds(481, 62, 129, 20);
		contentPane.add(comboDestino);
		
		JComboBox comboOrigen = new JComboBox();
		comboOrigen.setModel(new DefaultComboBoxModel(new String[] {"Montevideo", "Artigas", "Salto", "Paysandu", "Rio Negro", "Colonia", "Tacuarembo", "Durazno", "Rivera", "Flores", "Florida", "Rocha", "Maldonado"}));
		comboOrigen.setBounds(481, 34, 129, 20);
		contentPane.add(comboOrigen);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 534, 835, 80);
		contentPane.add(scrollPane_1);
		
		jtTablaBuscar = new JTable();
		jtTablaBuscar.setForeground(Color.MAGENTA);
		scrollPane_1.setViewportView(jtTablaBuscar);
		
		jtTablaBuscar.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Codigo", "Estado", "Origen", "Destino", "Fecha Recibido", "Fecha Entregado", "CedulaUsuario", "Cedula Cliente", "Nombre Remitente", "Telefono", "Direccion Entrega", "Nombre Destinatario"
			}
		));
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 214, 835, 158);
		contentPane.add(scrollPane);
		
		jtEncomiendas = new JTable();
		scrollPane.setViewportView(jtEncomiendas);
		
		jtEncomiendas.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null, null, null, null, null},
				},
				new String[] {
					"Codigo Paquete", "Estado", "Origen", "Destino", "Fecha Recibido", "Fecha de Entregado", "Tipo Paquete", "Usuario", "Cedula Cliente", "Observaciones"
				}
			));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaEncomiendas.class.getResource("/imagenes/donpaquete - copia - copia - copia.png")));
		lblNewLabel.setBounds(645, 11, 204, 189);
		contentPane.add(lblNewLabel);
		
		
								
		jtEncomiendas.getColumnModel().getColumn(0).setPreferredWidth(92);
		jtEncomiendas.getColumnModel().getColumn(1).setPreferredWidth(73);
		jtEncomiendas.getColumnModel().getColumn(2).setPreferredWidth(60);
		jtEncomiendas.getColumnModel().getColumn(3).setPreferredWidth(62);
		jtEncomiendas.getColumnModel().getColumn(4).setPreferredWidth(90);
		jtEncomiendas.getColumnModel().getColumn(5).setPreferredWidth(115);
		jtEncomiendas.getColumnModel().getColumn(7).setPreferredWidth(84);
		jtEncomiendas.getColumnModel().getColumn(8).setPreferredWidth(90);
		jtEncomiendas.getColumnModel().getColumn(9).setPreferredWidth(103);
		
		
					
	    jtEncomiendas.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				
			int fila = jtEncomiendas.getSelectedRow();
			
				txCodigo.setText(jtEncomiendas.getValueAt(fila, 0).toString());
				
										
				txCodigo.setEnabled(false);
				btnIngresarEncomienda.setEnabled(false);	
				btnCancelar.setEnabled(true);
				btnDespachar.setEnabled(true);
								
				
			}
		});
	    
	    
			
		
		btnIngresarEncomienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 Validacion miValidacionC=new Validacion();
	             ClientesT miClienteT=new ClientesT();
	             
	             Validacion miValidacionE=new Validacion();
	             EncomiendasT miEncomiendaT=new EncomiendasT();
	             
	             Date ahora = new Date(System.currentTimeMillis());
	             SimpleDateFormat fechahorarecibida = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	             String fechaYHora=fechahorarecibida.format(ahora);
					try{		
						
						miClienteT.setNombreremitente(txNombreR.getText());
						miClienteT.setCedulacliente(txCedulaC.getText());   
						miClienteT.setTelefono(txTelefono.getText());
						miClienteT.setDireccion(txDireccionD.getText());
						miClienteT.setNombredestinatario(txNombreD.getText());
						
						miValidacionC.ingresarClienteC(miClienteT);
						
												
						miEncomiendaT.setTipoE((String) comboTipoE.getSelectedItem());
						miEncomiendaT.setOrigen((String) comboOrigen.getSelectedItem());
						miEncomiendaT.setObservaciones((String) comboObservaciones.getSelectedItem());
						miEncomiendaT.setDestino((String) comboDestino.getSelectedItem());
					    miEncomiendaT.setFechahorarecibida(fechaYHora);
						miEncomiendaT.setCedulacliente(txCedulaC.getText());
						miEncomiendaT.setCedulausuario(lblCeUsuario.getText());
						
						miEncomiendaT.setEstado("Pendiente");
						
												
						miValidacionE.ingresarEncomiendaE(miEncomiendaT);
						
						comboOrigen.setSelectedIndex(0);
						comboObservaciones.setSelectedIndex(0);
						comboDestino.setSelectedIndex(0);
						comboTipoE.setSelectedIndex(0);
						txCedulaC.setText("");
						txNombreR.setText("");
						txTelefono.setText("");
						txDireccionD.setText("");
						txNombreD.setText("");
						
						JOptionPane.showMessageDialog(null,"Los datos se han ingresado exitosamente.Para corroborarlos actualice la tabla");
						
					}catch (Exception ex) {
						JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos");
                    }
			}		
		});
		
		
		
				
		btnActualizarTabla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Validacion miValidacionE=new Validacion();
				DefaultTableModel modeloE;
				modeloE=new DefaultTableModel();
				modeloE.addColumn("Codigo");
				modeloE.addColumn("Estado");
				modeloE.addColumn("Origen");
				modeloE.addColumn("Destino");
				modeloE.addColumn("FechaIngresado");
				modeloE.addColumn("FechaDesCanc");
				modeloE.addColumn("TipoEncomienda");
				modeloE.addColumn("CedulaUsuario");
				modeloE.addColumn("CedulaCliente");
				modeloE.addColumn("Observaciones");
				
				
				if(lblCatUsuario.getText().equals("Recepcionista")) {
					
					ArrayList<Object[]> datosEncomiendas= miValidacionE.traerTablaEncomiendasR();	
					
					for(int f=0;f<datosEncomiendas.size();f++) {
						modeloE.addRow(datosEncomiendas.get(f));
					
					}
					
					jtEncomiendas.setModel(modeloE);    ;
					
				}else {
				
				
				
				
				ArrayList<Object[]> datosEncomiendas= miValidacionE.traerTablaEncomiendas();
				
				for(int f=0;f<datosEncomiendas.size();f++) {
					modeloE.addRow(datosEncomiendas.get(f));
				}
				
				jtEncomiendas.setModel(modeloE);	;
				}
			}
		});
		
		
		
		
		btnDespachar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//////
				
				
                      int respuestaDespachar=JOptionPane.showConfirmDialog(null, "¿Esta seguro que quiere despachar esta encomienda?");
				
				if(JOptionPane.YES_OPTION ==respuestaDespachar) {		
				
				try{	
				 Validacion miValidacionE=new Validacion();
	             EncomiendasT miEncomiendaT=new EncomiendasT();
	             
	             Date ahora = new Date(System.currentTimeMillis());
	             SimpleDateFormat fechahoraentregada = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	             String fechaYHora=fechahoraentregada.format(ahora);
	             
	             miEncomiendaT.setFechahoraentregada(fechaYHora);
				 miEncomiendaT.setEstado("Despachado");   
				 int numerocodigo=Integer.parseInt(txCodigo.getText());
				 miEncomiendaT.setCodigopaquete(numerocodigo);
				 
				 miValidacionE.despacharEncomienda(numerocodigo, miEncomiendaT);
				 				  
					btnIngresarEncomienda.setEnabled(true);
					txCodigo.setEnabled(true);
					txCodigo.setText("");
					
					 JOptionPane.showMessageDialog(null,"Los datos se han ingresado exitosamente.Para corroborarlos actualice la tabla");
			}catch (Exception ex) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos");
            }
				}
			}
		});
		
		
		
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			
				int respuestaEliminar=JOptionPane.showConfirmDialog(null, "¿Esta seguro que quiere cancelar esta encomienda?");
				
				if(JOptionPane.OK_OPTION==respuestaEliminar) {		
				
				
				
			if(lblCatUsuario.getText().equals("Recepcionista"))	{
				
				String claveCancela=JOptionPane.showInputDialog(null, "Ingrese la clave de cancelacion", null);                
			
				if(claveCancela!=null &&  claveCancela.equals("permiso")) {
					
						
						Validacion miValidacionEC=new Validacion();
			            EncomiendasT miEncomiendaT=new EncomiendasT();
			             
			             Date ahora = new Date(System.currentTimeMillis());
			             SimpleDateFormat fechahoraentregada = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			             String fechaYHora=fechahoraentregada.format(ahora);
			             
			             miEncomiendaT.setFechahoraentregada(fechaYHora);
						 miEncomiendaT.setEstado("Cancelada");   
						 int numerocodigo=Integer.parseInt(txCodigo.getText());
						 miEncomiendaT.setCodigopaquete(numerocodigo);
						 
						 miValidacionEC.cancelarEncomienda(numerocodigo, miEncomiendaT);
						 				  
							btnIngresarEncomienda.setEnabled(true);
							txCodigo.setEnabled(true);	
							txCodigo.setText("");	
							
							JOptionPane.showMessageDialog(null,"Los datos se han cancelado. Para corroborarlo actualice la tabla");
							
									
				}else {
					JOptionPane.showMessageDialog(null,"El permiso de cancelacion no es correcto");
				}
				
				}else
			try {	
				Validacion miValidacionEC=new Validacion();
	            EncomiendasT miEncomiendaT=new EncomiendasT();
	             
	             Date ahora = new Date(System.currentTimeMillis());
	             SimpleDateFormat fechahoraentregada = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	             String fechaYHora=fechahoraentregada.format(ahora);
	             
	             miEncomiendaT.setFechahoraentregada(fechaYHora);
				 miEncomiendaT.setEstado("Cancelada");   
				 int numerocodigo=Integer.parseInt(txCodigo.getText());
				 miEncomiendaT.setCodigopaquete(numerocodigo);
				 
				 miValidacionEC.cancelarEncomienda(numerocodigo, miEncomiendaT);
				 				  
					btnIngresarEncomienda.setEnabled(true);
					txCodigo.setEnabled(true);	
					txCodigo.setText("");	
					
					JOptionPane.showMessageDialog(null,"Los datos se han cancelado. Para corroborarlo actualice la tabla");//aca otro jop con una decision 
					
			}catch (Exception ex) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos");
            }
			}
			}	
		});
		
		
		
		
			
		btnBuscarPorCodigo.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		
		 Validacion miValidacionEC=new Validacion();
		 EncomiendasT miEncomiendaT=new EncomiendasT();
				 
		 
		    DefaultTableModel modeloEC;
			modeloEC=new DefaultTableModel();  
			
          int numerocodigo=Integer.parseInt(txBuscarPorCodigo.getText());
		  miEncomiendaT.setCodigopaquete(numerocodigo);
		         	
			
			modeloEC.addColumn("Codigo");
			modeloEC.addColumn("Estado");
			modeloEC.addColumn("Origen");
			modeloEC.addColumn("Destino");
			modeloEC.addColumn("FechaIngresado");
			modeloEC.addColumn("FechaDespachado");
			modeloEC.addColumn("CedulaUsuario");
			modeloEC.addColumn("CedulaCliente");
			modeloEC.addColumn("NombreRemitente");
			modeloEC.addColumn("Telefono");
			modeloEC.addColumn("DireccionEntrega");
			modeloEC.addColumn("NombreDestinatario");
			
							 
			ArrayList<Object[]> datosEncomiendasClientes= miValidacionEC.traerEncomiendasClientes(numerocodigo, miEncomiendaT);
			
			for(int f=0;f<datosEncomiendasClientes.size();f++) {
				modeloEC.addRow(datosEncomiendasClientes.get(f));
			}
			
			jtTablaBuscar.setModel(modeloEC);	;
		
			
		}
	});

		
		
	
	  	btnBuscarPorRemitente.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		
		 Validacion miValidacionCE=new Validacion();
		 ClientesT miClienteT=new ClientesT();
		 
		 
		 String nombreDelRemitente= txtIngreseElNombre.getText();  
		  miClienteT.setNombreremitente(nombreDelRemitente);
		   
		 
		    DefaultTableModel modeloEC;
			modeloEC=new DefaultTableModel();  
			
             		
			modeloEC.addColumn("Codigo");
			modeloEC.addColumn("Estado");
			modeloEC.addColumn("Origen");
			modeloEC.addColumn("Destino");
			modeloEC.addColumn("FechaIngresado");
			modeloEC.addColumn("FechaDespachado");
			modeloEC.addColumn("CedulaUsuario");
			modeloEC.addColumn("CedulaCliente");
			modeloEC.addColumn("NombreRemitente");
			modeloEC.addColumn("Telefono");
			modeloEC.addColumn("DireccionEntrega");
			modeloEC.addColumn("NombreDestinatario");
			
							 
			ArrayList<Object[]> datosEncomiendasClientes= miValidacionCE.traerEncomiendasClientesC(nombreDelRemitente, miClienteT);
			
			for(int f=0;f<datosEncomiendasClientes.size();f++) {
				modeloEC.addRow(datosEncomiendasClientes.get(f));
			}
			
			jtTablaBuscar.setModel(modeloEC);	;
		
			
		}
	});

	  	
	  	
	
		
		mntmInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			VentanaIngresoA miVentanaIngresoA=new VentanaIngresoA(miUsuarioLogin);
			miVentanaIngresoA.setVisible(true);
				
			}
			
		});	
		
		
	
}   
}	



/*btnModificar.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
		
		Validacion miValidacion=new Validacion();
		EncomiendasT miEncomiendaT=new EncomiendasT();
		try{		
										
			miEncomiendaT.setOrigen(txOrigen.getText());
			miEncomiendaT.setObservaciones(txObservaciones.getText());
			miEncomiendaT.setDestino(txDestino.getText());
			miEncomiendaT.setTipoE(txTipoE.getText());
			miEncomiendaT.setCedulacliente(txCedulaC.getText());
			//miEncomiendaT.setTipo((String) comboTipo.getSelectedItem());   
			
			
			miValidacion.modificarEncomienda(txCedulaC.getText(), miEncomiendaT);
			
			txOrigen.setText("");
			txObservaciones.setText("");
			txDestino.setText("");
			txTipoE.setText("");
			txCedulaC.setText("");
			txNombreR.setText("");
			txTelefono.setText("");
			txDireccionD.setText("");
			txNombreD.setText("");
			
	    	//comboTipo.setSelectedIndex(0);
	    	txCedulaC.setEnabled(true);
			btnIngresarEncomienda.setEnabled(true);
			
		}catch (Exception ex) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos");
			                                                   } 
	}
});*/




