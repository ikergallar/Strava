package client.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import client.controller.LoginController;
import client.controller.RetoController;
import client.controller.SesionController;

import javax.swing.JSpinner;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCrearSesion extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textNombre;
	private JTextField textFechaIni;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public VentanaCrearSesion(LoginController loginController, RetoController retoController,
			SesionController sesionController) {
		getContentPane().setLayout(null);

		this.setBounds(150, 100, 450, 500);
		
		JLabel lblNombre = new JLabel("Nombre de la sesi\u00F3n");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombre.setBounds(37, 60, 234, 14);
		getContentPane().add(lblNombre);

		textNombre = new JTextField();
		textNombre.setText("Nombre de la sesi\u00F3n");
		textNombre.setBounds(37, 88, 255, 28);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);

		JComboBox<?> comDeporte = new JComboBox();
		comDeporte.setModel(new DefaultComboBoxModel(new String[] { "Running", "Ciclismo" }));
		comDeporte.setToolTipText("");
		comDeporte.setBounds(37, 127, 255, 28);
		getContentPane().add(comDeporte);

		JLabel lblFecha = new JLabel("Fecha de inicio de la sesi\u00F3n");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFecha.setBounds(37, 166, 174, 21);
		getContentPane().add(lblFecha);

		JLabel lblTitulo = new JLabel("Crea tu sesi\u00F3n personalizada de entrenamiento");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitulo.setBounds(37, 11, 350, 38);
		getContentPane().add(lblTitulo);

		textFechaIni = new JTextField();
		textFechaIni.setBounds(37, 198, 174, 30);
		getContentPane().add(textFechaIni);
		textFechaIni.setColumns(10);

		JLabel lblDur = new JLabel("Duraci\u00F3n de la sesi\u00F3n");
		lblDur.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDur.setBounds(37, 239, 174, 21);
		getContentPane().add(lblDur);

		JSpinner spinnerDur = new JSpinner();
		spinnerDur.setBounds(37, 271, 118, 28);
		getContentPane().add(spinnerDur);

		JLabel lblDistanciaDeLa = new JLabel("Distancia de la sesi\u00F3n");
		lblDistanciaDeLa.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDistanciaDeLa.setBounds(37, 310, 174, 21);
		getContentPane().add(lblDistanciaDeLa);

		JSpinner spinnerDis = new JSpinner();
		spinnerDis.setBounds(37, 342, 118, 28);
		getContentPane().add(spinnerDis);

		JButton btnCrearSesion = new JButton("Crear Sesi\u00F3n");
		btnCrearSesion.setBounds(79, 399, 118, 23);
		getContentPane().add(btnCrearSesion);

		btnCrearSesion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String nombre = textNombre.getText();
				String Deporte = (String) comDeporte.getSelectedItem();
				int distancia = (Integer) spinnerDis.getValue();
				String fecha_ini = textFechaIni.getText();
				int duracion = (Integer) spinnerDur.getValue();

				System.out.println(" - Creando una sesion " + nombre + "'");
				sesionController.crearSesion(loginController.getToken(), nombre, Deporte, distancia, fecha_ini,
						duracion);
				System.out.println(" - Sesion creada correctamente " + nombre + "'");

			}
		});

		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(207, 399, 104, 23);
		getContentPane().add(btnAtras);
		
		
		btnAtras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaSesion C = new VentanaSesion(loginController, retoController, sesionController);
				C.setVisible(true);
				dispose();

			}
		});

	}
}