package client.gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import client.controller.LoginController;
import client.controller.RetoController;
import client.controller.SesionController;
import server.data.dto.RetoDTO;
import server.data.dto.SesionDTO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTextPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;

public class VentanaPrincipal extends JFrame {
	private JTextField textFechaIni;

	public VentanaPrincipal(LoginController loginController, RetoController retoController,
			SesionController sesionController) {
		getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 101, 22);
		getContentPane().add(menuBar);

		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);

		JMenuItem mntmReto = new JMenuItem("Retos");
		mntmReto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaReto vR = new VentanaReto(loginController, retoController, sesionController);
				vR.setVisible(true);
				dispose();
			}
		});
		mnNewMenu.add(mntmReto);

		JMenuItem mntmCerrarSesion = new JMenuItem("Cerrar Sesion");
		mntmCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaLogin vL = new VentanaLogin(loginController, retoController, sesionController);
				vL.setVisible(true);
				dispose();
			}
		});
		mnNewMenu.add(mntmCerrarSesion);

		JLabel lblTitulo = new JLabel("Sesiones disponibles");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitulo.setBounds(56, 33, 275, 50);
		getContentPane().add(lblTitulo);

		JButton btnCerrarSesion = new JButton("Crear Sesion");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaCrearSesion vCS = new VentanaCrearSesion(loginController, retoController, sesionController);
				vCS.setVisible(true);
				dispose();
			}
		});
		btnCerrarSesion.setBounds(133, 377, 110, 23);
		getContentPane().add(btnCerrarSesion);

//		JPanel panel = new JPanel();
//		panel.setBounds(173, 94, 179, 245);
//		getContentPane().add(panel);

		JList<SesionDTO> list = new JList<SesionDTO>();
		getContentPane().add(list);
		list.setBounds(173, 94, 179, 245);
//		JScrollPane sp=new JScrollPane(panel);
//		panel.add(sp);

		JTextPane textNombre = new JTextPane();
		textNombre.setBounds(29, 111, 110, 20);
		getContentPane().add(textNombre);

		JButton btnBuscarSesion = new JButton("Buscar Sesion");
		btnBuscarSesion.setBounds(29, 316, 124, 31);
		getContentPane().add(btnBuscarSesion);

		JLabel lblNewLabel = new JLabel("Nombre de la sesi\u00F3n");
		lblNewLabel.setBounds(29, 86, 110, 14);
		getContentPane().add(lblNewLabel);

		JLabel lblDis = new JLabel("Distancia");
		lblDis.setBounds(28, 142, 101, 20);
		getContentPane().add(lblDis);

		JSpinner spinnerDis = new JSpinner();
		spinnerDis.setBounds(29, 162, 39, 22);
		getContentPane().add(spinnerDis);

		textFechaIni = new JTextField();
		textFechaIni.setBounds(29, 220, 110, 20);
		getContentPane().add(textFechaIni);
		textFechaIni.setColumns(10);

		JLabel lblFechaIni = new JLabel("Fecha de inicio");
		lblFechaIni.setBounds(29, 195, 100, 14);
		getContentPane().add(lblFechaIni);

		JLabel lblDuracion = new JLabel("Duraci\u00F3n");
		lblDuracion.setBounds(29, 251, 110, 22);
		getContentPane().add(lblDuracion);

		JSpinner spinnerDur = new JSpinner();
		spinnerDur.setBounds(29, 283, 39, 22);
		getContentPane().add(spinnerDur);

		btnBuscarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nombre = textNombre.getText();
				int distancia = (Integer) spinnerDis.getValue();
				String fechaIni = textFechaIni.getText();
				int duracion = (Integer) spinnerDur.getValue();

				DefaultListModel<SesionDTO> modelo;
				List<SesionDTO> lista;

				modelo = new DefaultListModel<SesionDTO>();
				lista = sesionController.buscarSesiones(nombre, distancia, fechaIni, duracion);

				if (lista != null) {
					for (SesionDTO se : lista) {
						modelo.addElement(se);
						list.setModel(modelo);
					}
				} else {
					JOptionPane.showMessageDialog(null, "No existe ninguna sesion con esas caracteristicas",
							"Confirmacion", 1);

				}

			}
		});

		this.setTitle("Strava - Menu");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setSize(401, 450);
	}
}
