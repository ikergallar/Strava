package client.gui;

import javax.swing.JFrame;

import client.controller.LoginController;
import client.controller.RetoController;
import client.controller.SesionController;
import server.data.dto.RetoDTO;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;

public class VentanaReto extends JFrame {

	private JTextField textNombre;
	private JTextField textFechaini;
	private JTextField textFin;

	public VentanaReto(LoginController loginController, RetoController retoController,
			SesionController sesionController) {
		getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 101, 22);
		getContentPane().add(menuBar);

		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);

		JMenuItem mntmReto = new JMenuItem("Sesiones");
		mntmReto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal vP = new VentanaPrincipal(loginController, retoController, sesionController);
				vP.setVisible(true);
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

		JLabel lblTitulo = new JLabel("Busca los mejores retos");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitulo.setBounds(37, 11, 358, 62);
		getContentPane().add(lblTitulo);

		JList<RetoDTO> list = new JList<RetoDTO>();
		list.setBounds(364, 84, 330, 278);
		getContentPane().add(list);

		JButton btnCrearReto = new JButton("Crear Reto");
		btnCrearReto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaCrearReto vCR = new VentanaCrearReto(loginController, retoController, sesionController);
				vCR.setVisible(true);
				dispose();
			}
		});
		btnCrearReto.setBounds(285, 501, 110, 23);
		getContentPane().add(btnCrearReto);

		textNombre = new JTextField();
		textNombre.setBounds(170, 97, 96, 20);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);

		textFechaini = new JTextField();
		textFechaini.setBounds(170, 151, 96, 20);
		getContentPane().add(textFechaini);
		textFechaini.setColumns(10);

		textFin = new JTextField();
		textFin.setBounds(170, 211, 96, 20);
		getContentPane().add(textFin);
		textFin.setColumns(10);

		JButton btnBuscarReto = new JButton("Buscar reto");
		btnBuscarReto.setBounds(170, 343, 96, 23);
		getContentPane().add(btnBuscarReto);

		JButton btnApuntarse = new JButton("Apuntarse ");
		btnApuntarse.setBounds(490, 397, 89, 23);
		getContentPane().add(btnApuntarse);

		JSpinner spinner = new JSpinner();
		spinner.setBounds(170, 275, 30, 20);
		getContentPane().add(spinner);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(20, 97, 123, 20);
		getContentPane().add(lblNewLabel);
		
		JLabel lblFechaInicioddmmaaaa = new JLabel("Fecha inicio(dd/MM/aaaa)");
		lblFechaInicioddmmaaaa.setBounds(20, 151, 123, 20);
		getContentPane().add(lblFechaInicioddmmaaaa);
		
		JLabel lblFechaFinddmmaaaa = new JLabel("Fecha fin(dd/MM/aaaa)");
		lblFechaFinddmmaaaa.setBounds(20, 211, 123, 20);
		getContentPane().add(lblFechaFinddmmaaaa);
		
		JLabel lblNewLabel_2_1 = new JLabel("Duraci\u00F3n");
		lblNewLabel_2_1.setBounds(20, 275, 123, 20);
		getContentPane().add(lblNewLabel_2_1);

		btnBuscarReto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nombre = textNombre.getText();
				String fechaIni = textFechaini.getText();
				String fechaFin = textFin.getText();
				int duracion = (Integer) spinner.getValue();

				DefaultListModel<RetoDTO> modelo;
				List<RetoDTO> lista;

				modelo = new DefaultListModel<RetoDTO>();
				lista = retoController.buscarRetos(nombre, fechaIni, fechaFin, duracion);

				if (lista != null) {
					for (RetoDTO re : lista) {
						modelo.addElement(re);
						list.setModel(modelo);
					}
				} else {
					JOptionPane.showMessageDialog(null, "No existe ningun reto con esas caracteristicas",
							"Confirmacion", 1);

				}

			}
		});

		btnApuntarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				RetoDTO reto = (RetoDTO) list.getSelectedValue();

				retoController.apuntarseReto(loginController.getToken(), reto.getIdReto());

			}
		});

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setSize(750, 600);

	}
}
