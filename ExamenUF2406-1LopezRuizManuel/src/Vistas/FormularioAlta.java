package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormularioAlta extends JFrame {

	private JPanel contentPane;
	private JTextField txtCiudad;
	private JTextField textDestino;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioAlta frame = new FormularioAlta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormularioAlta() {
		setFont(new Font("Verdana", Font.PLAIN, 14));
		setTitle("Calculadora Envios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][grow]", "[][][][][][][][fill]"));
		
		JLabel lblciudad = new JLabel("Ciudad Origen");
		lblciudad.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblciudad, "cell 0 0");
		
		txtCiudad = new JTextField();
		contentPane.add(txtCiudad, "cell 2 0,growx");
		txtCiudad.setColumns(10);
		
		JCheckBox chckbxNacional = new JCheckBox("Nacional");
		buttonGroup.add(chckbxNacional);
		chckbxNacional.setSelected(true);
		chckbxNacional.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(chckbxNacional, "flowx,cell 2 1");
		
		JCheckBox chckbxExtranjero = new JCheckBox("Extranjero");
		buttonGroup.add(chckbxExtranjero);
		chckbxExtranjero.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(chckbxExtranjero, "cell 2 1");
		
		JLabel lblDestino = new JLabel("Ciudad Destino");
		lblDestino.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblDestino, "cell 0 2");
		
		textDestino = new JTextField();
		contentPane.add(textDestino, "cell 2 2,growx");
		textDestino.setColumns(10);
		
		JCheckBox chckbxDestinonacional = new JCheckBox("Nacional");
		buttonGroup.add(chckbxDestinonacional);
		chckbxDestinonacional.setSelected(true);
		chckbxDestinonacional.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(chckbxDestinonacional, "flowx,cell 2 3");
		
		JCheckBox chckbxDestinoextranjero = new JCheckBox("Extranjero");
		buttonGroup.add(chckbxDestinoextranjero);
		chckbxDestinoextranjero.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(chckbxDestinoextranjero, "cell 2 3");
		
		JLabel lblNewLabel = new JLabel("Tipo de envio");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblNewLabel, "cell 0 4");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Verdana", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Paq 10 Antes de las 10", "Paq 14 Antes de las 14", "Paq24 Al día siguiente"}));
		contentPane.add(comboBox, "cell 2 4,growx");
		
		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblPeso, "cell 0 5");
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 40, 1));
		contentPane.add(spinner, "cell 2 5");
		
		JButton btnNewButton = new JButton("Calcular Precio");
		btnNewButton.addActionListener(new ActionListener() {
			private JLabel txtDestino;



			public void actionPerformed(ActionEvent e) {
				calcularPrecio();
			}

			

			private void calcularPrecio() {
				
				if (txtCiudad.getText()==null || txtCiudad.getText().isBlank() ||
						txtDestino.getText()==null || txtDestino.getText().isBlank()){
						
						JOptionPane.showMessageDialog(this,
							"Debe introducir los campos ciudad Origen y Destino ciudad",
							"Compruebe los datos", JOptionPane.WARNING_MESSAGE);
						
						return;
			}
				String ciudadOrigen = txtCiudad.getText();
				Boolean origenNacional = Checkbx.getCheckbx();
				String ciudadDestino = txtDestino.getText();
				Boolean origenExtranjero = CheckbxDestinoextranjero.getCheckbx();
				int precionacional=4;
				int precio=7;
				String tipoEnvio =(String) comboTipo.getSelectedItem();
				
				if (tipo.equals("Nacional")) {
					precio = 4;
				} else if (tipo.equals("Extranjero")) {
					precio= 7;
				
				int recargo=3.5;
				
				int peso="kg";
				if (Spinner.isSelected(10)) {
					precio=precio;
				}
				if (Spinner.isSelected(11)) {
					precio=precio+recargo;
				}
				if (Spinner.isSelected(21)) {
					precio=precio+(recargo*2);
				}
				if (Spinner.isSelected(31)) {
					precio=precio+(recargo*3);
				}
				
				}
			}
		}
		);
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(btnNewButton, "cell 0 7,alignx center");
	}

}
