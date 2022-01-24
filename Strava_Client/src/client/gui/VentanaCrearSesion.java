package client.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import client.controller.DeporteController;
import client.controller.LoginController;
import client.controller.RetoController;
import client.controller.SesionController;
import server.data.dto.DeporteDTO;

import javax.swing.JSpinner;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VentanaCrearSesion extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textNombre;
	private JTextField textField;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public VentanaCrearSesion(LoginController loginController, RetoController retoController,
			SesionController sesionController, DeporteController deporteController) {
		getContentPane().setLayout(null);

		this.setBounds(150, 100, 538, 551);
		
		JLabel lblNombre = new JLabel("Nombre de la sesi\u00F3n");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombre.setBounds(37, 60, 234, 14);
		getContentPane().add(lblNombre);

		textNombre = new JTextField();
		textNombre.setBounds(37, 88, 255, 28);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);

		JComboBox<?> comDeporte = new JComboBox();
		comDeporte.setModel(new DefaultComboBoxModel(deporteController.getNombres().toArray()));
		comDeporte.setToolTipText("");
		comDeporte.setBounds(37, 159, 255, 28);
		getContentPane().add(comDeporte);

		JLabel lblFecha = new JLabel("Fecha de inicio de la sesi\u00F3n(dd/MM/yyyy)");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFecha.setBounds(37, 198, 315, 21);
		getContentPane().add(lblFecha);

		JLabel lblTitulo = new JLabel("Crea tu sesi\u00F3n personalizada de entrenamiento");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitulo.setBounds(37, 11, 350, 38);
		getContentPane().add(lblTitulo);

		JLabel lblDur = new JLabel("Duraci\u00F3n de la sesi\u00F3n(min)");
		lblDur.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDur.setBounds(37, 279, 255, 21);
		getContentPane().add(lblDur);

		JSpinner spinnerDur = new JSpinner();
		spinnerDur.setBounds(37, 311, 118, 28);
		getContentPane().add(spinnerDur);

		JLabel lblDistanciaDeLa = new JLabel("Distancia de la sesi\u00F3n(km)");
		lblDistanciaDeLa.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDistanciaDeLa.setBounds(37, 350, 255, 21);
		getContentPane().add(lblDistanciaDeLa);

		JSpinner spinnerDis = new JSpinner();
		spinnerDis.setBounds(37, 382, 118, 28);
		getContentPane().add(spinnerDis);

		JButton btnCrearSesion = new JButton("Crear Sesi\u00F3n");
		btnCrearSesion.setBounds(58, 448, 146, 23);
		getContentPane().add(btnCrearSesion);
		
		textField = new JTextField();
		textField.setBounds(37, 230, 152, 28);
		getContentPane().add(textField);
		textField.setColumns(10);

		btnCrearSesion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String nombre = textNombre.getText();
				String Deporte = (String) comDeporte.getSelectedItem();
				DeporteDTO dep = deporteController.getDeporte(Deporte);
				int distancia = (Integer) spinnerDis.getValue();
				Date fecha_ini = null;
				try {
					fecha_ini = sdf.parse(textField.getText());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				int duracion = (Integer) spinnerDur.getValue();

				System.out.println(" - Creando una sesion " + nombre + "'");
				sesionController.crearSesion(loginController.getToken(), nombre, dep, distancia, fecha_ini,
						duracion);
				System.out.println(" - Sesion creada correctamente " + nombre + "'");

				JOptionPane.showMessageDialog(null, "Sesion creada correctamente", "Confirmacion", 1);
				textNombre.setText("");
				spinnerDis.setValue(0);
				textField.setText("");
				spinnerDur.setValue(0);
			}
		});

		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(225, 448, 127, 23);
		getContentPane().add(btnAtras);
		
		JLabel lblDeporte = new JLabel("Deporte");
		lblDeporte.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDeporte.setBounds(37, 127, 137, 21);
		getContentPane().add(lblDeporte);
		
		btnAtras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaSesion C = new VentanaSesion(loginController, retoController, sesionController,deporteController);
				C.setVisible(true);
				dispose();

			}
		});

	}
}