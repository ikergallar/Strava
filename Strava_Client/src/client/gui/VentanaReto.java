package client.gui;

import javax.swing.JFrame;

import client.controller.LoginController;
import client.controller.RetoController;
import client.controller.SesionController;
import server.data.dto.RetoDTO;

import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.SwingConstants;
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

public class VentanaReto extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
				VentanaSesion vP = new VentanaSesion(loginController, retoController, sesionController);
				vP.setVisible(true);
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
					VentanaLogin vL = new VentanaLogin(loginController, retoController, sesionController);
					vL.setVisible(true);
					dispose();
				}else {
					
					System.out.println(" - Logout from the server..."); 
					loginController.logout();
					System.out.println("\t* Logout success!");
					VentanaLogin vL = new VentanaLogin(loginController, retoController, sesionController);
					vL.setVisible(true);
					dispose();
				}
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
		btnCrearReto.setBounds(285, 501, 140, 23);
		getContentPane().add(btnCrearReto);

		JButton btnBuscarReto = new JButton("Obtener retos");
		btnBuscarReto.setBounds(170, 343, 128, 23);
		getContentPane().add(btnBuscarReto);

		JButton btnApuntarse = new JButton("Apuntarse ");
		btnApuntarse.setBounds(490, 397, 128, 23);
		getContentPane().add(btnApuntarse);

		btnBuscarReto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultListModel<RetoDTO> modelo;
				List<RetoDTO> lista;

				modelo = new DefaultListModel<RetoDTO>();
				lista = retoController.getRetos();

				if (lista != null) {
					for (RetoDTO re : lista) {
						modelo.addElement(re);
						list.setModel(modelo);
					}
				} 

			}
		});

		btnApuntarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				RetoDTO reto = (RetoDTO) list.getSelectedValue();
				
				if(retoController.apuntarseReto(loginController.getToken(), reto.getIdReto()) == true) {
					JOptionPane.showMessageDialog(null, "Apuntado al reto", "Confirmacion", 1);
				}else {
					JOptionPane.showMessageDialog(null, "Error al apuntarse al reto", "error", 2);

				}
				
			}
		});

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setSize(750, 600);

	}
}
