package client.gui;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import client.controller.LoginController;


import com.toedter.calendar.JDateChooser;
import javax.swing.JSpinner;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;


public class VentanaCrearSesion extends JFrame {
    private JTextField textNombre;
    private JTextField txtDuracDeLa;
    
    public VentanaCrearSesion(LoginController controller) {
        getContentPane().setLayout(null);

        textNombre = new JTextField();
        textNombre.setText("Nombre de la sesi\u00F3n");
        textNombre.setBounds(37, 86, 255, 28);
        getContentPane().add(textNombre);
        textNombre.setColumns(10);

        JComboBox comDeporte = new JComboBox();
        comDeporte.setModel(new DefaultComboBoxModel(new String[] {"Running", "Ciclismo"}));
        comDeporte.setToolTipText("");
        comDeporte.setBounds(37, 125, 255, 28);
        getContentPane().add(comDeporte);
        
        JDateChooser dateFechaIni = new JDateChooser();
        dateFechaIni.setBounds(37, 164, 255, 28);
        getContentPane().add(dateFechaIni);
        
        JSpinner spinnerHora = new JSpinner();
        spinnerHora.setBounds(37, 235, 45, 28);
        getContentPane().add(spinnerHora);
        
        JLabel lblNewLabel = new JLabel("Hora de inicio de la sesi\u00F3n");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel.setBounds(37, 203, 174, 21);
        getContentPane().add(lblNewLabel);
        
        JSpinner spinnerMinutos = new JSpinner();
        spinnerMinutos.setBounds(92, 235, 45, 28);
        getContentPane().add(spinnerMinutos);
        
        txtDuracDeLa = new JTextField();
        txtDuracDeLa.setText("Duraci\u00F3n de la sesi\u00F3n (minutos)");
        txtDuracDeLa.setColumns(10);
        txtDuracDeLa.setBounds(37, 278, 255, 28);
        getContentPane().add(txtDuracDeLa);
        
        JButton btnCrearSesion = new JButton("Crear Sesi\u00F3n");
        btnCrearSesion.setBounds(82, 343, 104, 23);
        getContentPane().add(btnCrearSesion);
        
        JButton btnAtras = new JButton("Atras");
        btnAtras.setBounds(210, 343, 104, 23);
        getContentPane().add(btnAtras);
        
        JLabel lblTitulo = new JLabel("Crea tu sesi\u00F3n personalizada de entrenamiento");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblTitulo.setBounds(37, 36, 350, 38);
        getContentPane().add(lblTitulo);
        
        btnAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaPrincipal C = new VentanaPrincipal(controller);
				 C.setVisible(true);
				 dispose();
				
			}
		});
        
        
    }
}