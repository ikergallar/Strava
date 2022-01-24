package client.gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import client.controller.DeporteController;
import client.controller.LoginController;
import client.controller.RetoController;
import client.controller.SesionController;
import server.data.dto.SesionDTO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import javax.swing.SwingConstants;

import javax.swing.JTextPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;

public class VentanaSesion extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFecha;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private JTextField textDeporte;


	public VentanaSesion(LoginController loginController, RetoController retoController,
			SesionController sesionController, DeporteController deporteController) {
		getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 101, 22);
		getContentPane().add(menuBar);

		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);

		JMenuItem mntmReto = new JMenuItem("Retos");
		mntmReto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaReto vR = new VentanaReto(loginController, retoController, sesionController,deporteController);
				vR.setVisible(true);
				dispose();
			}
		});
		mnNewMenu.add(mntmReto);

		JMenuItem mntmCerrarSesion = new JMenuItem("Cerrar Sesion");
		mntmCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(loginController.getToken()==0) {
					System.out.println(" - Logout from the server..."); 
					System.out.println("\t* Logout success!");
					VentanaLogin vL = new VentanaLogin(loginController, retoController, sesionController,deporteController);
					vL.setVisible(true);
					dispose();	
				}else {
					System.out.println(" - Logout from the server..."); 
					loginController.logout();
					System.out.println("\t* Logout success!");
					VentanaLogin vL = new VentanaLogin(loginController, retoController, sesionController,deporteController);
					vL.setVisible(true);
					dispose();
				}
			}
		});
		mnNewMenu.add(mntmCerrarSesion);

		JLabel lblTitulo = new JLabel("Sesiones disponibles");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitulo.setBounds(67, 25, 275, 50);
		getContentPane().add(lblTitulo);

		JButton btnCrearSesion = new JButton("Crear Sesi\u00F3n");
		btnCrearSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaCrearSesion vCS = new VentanaCrearSesion(loginController, retoController, sesionController,deporteController);
				vCS.setVisible(true);
				dispose();
			}
		});
		btnCrearSesion.setBounds(200, 458, 142, 23);
		getContentPane().add(btnCrearSesion);

		JList<SesionDTO> list = new JList<SesionDTO>();
		getContentPane().add(list);
		list.setBounds(257, 104, 516, 316);

		JTextPane textNombre = new JTextPane();
		textNombre.setBounds(29, 111, 110, 20);
		getContentPane().add(textNombre);

		JButton btnBuscarSesion = new JButton("Buscar Sesi\u00F3n");
		btnBuscarSesion.setBounds(81, 389, 124, 31);
		getContentPane().add(btnBuscarSesion);

		JLabel lblNombre = new JLabel("Nombre de la sesi\u00F3n");
		lblNombre.setBounds(29, 86, 142, 14);
		getContentPane().add(lblNombre);

		JLabel lblDis = new JLabel("Distancia");
		lblDis.setBounds(29, 188, 101, 20);
		getContentPane().add(lblDis);

		JSpinner spinnerDis = new JSpinner();
		spinnerDis.setBounds(29, 219, 110, 22);
		getContentPane().add(spinnerDis);

		JLabel lblFechaIni = new JLabel("Fecha de inicio(dd/MM/yyyy)");
		lblFechaIni.setBounds(29, 252, 233, 14);
		getContentPane().add(lblFechaIni);

		JLabel lblDuracion = new JLabel("Duraci\u00F3n");
		lblDuracion.setBounds(29, 308, 110, 22);
		getContentPane().add(lblDuracion);

		JSpinner spinnerDur = new JSpinner();
		spinnerDur.setBounds(29, 341, 110, 22);
		getContentPane().add(spinnerDur);
		
		textFecha = new JTextField();
		textFecha.setBounds(29, 277, 106, 20);
		getContentPane().add(textFecha);
		textFecha.setColumns(10);
		
		JLabel lblDeporte = new JLabel("Deporte");
		lblDeporte.setBounds(29, 142, 46, 14);
		getContentPane().add(lblDeporte);
		
		textDeporte = new JTextField();
		textDeporte.setBounds(29, 167, 110, 20);
		getContentPane().add(textDeporte);
		textDeporte.setColumns(10);
		

		btnBuscarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nombre = textNombre.getText();
				String deporte = textDeporte.getText();
				int distancia = (Integer) spinnerDis.getValue();
				Date fechaIni = null;
				try {
					fechaIni = sdf.parse(textFecha.getText());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				int duracion = (Integer) spinnerDur.getValue();

				DefaultListModel<SesionDTO> modelo;
				List<SesionDTO> lista;

				modelo = new DefaultListModel<SesionDTO>();
				lista = sesionController.buscarSesiones(nombre,deporte, distancia, fechaIni, duracion);

				if (lista != null) {
					for (SesionDTO se : lista) {
						modelo.addElement(se);
						list.setModel(modelo);
					}
				} else {
					JOptionPane.showMessageDialog(null, "No existe ninguna sesion con esas caracteristicas","Warning", 1);
				}

			}
		});

		this.setTitle("Strava - Menu");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setSize(811, 531);
	}
}
