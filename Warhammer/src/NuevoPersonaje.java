import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.text.NumberFormatter;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NuevoPersonaje extends JFrame {

	private JPanel contentPane;
	private static NuevoPersonaje frame;
	private static JTextField txtnombre;
	private static JFormattedTextField txtedad;
	private static String descripcion;
	static Contenido objetoContenido = new Contenido();
	static String[] profesiones;
	static JComboBox comboSexo, comboRaza, comboProfesion;
	static JLabel lbldescripcion, lblraza;
	private static JLabel lblcontinuar = new JLabel("");

	// Paco
	private static String nombre;
	private static String sexo;
	private static String raza;
	private static String profesion;
	private static String edad;
	
	
	public static int numberOfMillisecondsInTheFuture = 1000; // Ejecutar cada 1 sec
	static Date timeToRun = new Date(System.currentTimeMillis() + numberOfMillisecondsInTheFuture);
	public static Timer timer = new Timer();

	/**
	 * Launch the application.
	 */
	public static void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new NuevoPersonaje();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					ImageIcon img = new ImageIcon(".\\images\\icono.png");
					frame.setIconImage(img.getImage());
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		

	}

	/**
	 * Create the frame.
	 */
	public NuevoPersonaje() {
		
		timer.schedule(new TimerTask() {
			public void run() {
				validateCharacter();
				System.out.println("Hola");
			}
			}, timeToRun);
			
		
		setTitle("WARHAMMER - EL JUEGO DE ROL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 1024);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Image imgfondo = new ImageIcon(".\\images\\fondo2.jpg").getImage();
		ImageIcon imgfondo1 = new ImageIcon(imgfondo.getScaledInstance(1280, 990, Image.SCALE_SMOOTH));

		JLabel lblrayamarilla = new JLabel("_____________________");
		lblrayamarilla.setForeground(new Color(255, 204, 0));
		lblrayamarilla.setFont(new Font("SimSun", Font.BOLD, 56));
		lblrayamarilla.setBounds(431, 52, 743, 47);
		contentPane.add(lblrayamarilla);

		JLabel lblrayanegra = new JLabel("_____________________");
		lblrayanegra.setFont(new Font("SimSun", Font.BOLD, 56));
		lblrayanegra.setBounds(429, 51, 743, 47);
		contentPane.add(lblrayanegra);

		lblcontinuar.setBounds(408, 794, 311, 79);
		contentPane.add(lblcontinuar);
		lblcontinuar.setVisible(false);

		Image imgb1 = new ImageIcon(".\\images\\botoncontinuar.png").getImage();
		ImageIcon imgb11 = new ImageIcon(imgb1.getScaledInstance(215, 55, Image.SCALE_SMOOTH));
		lblcontinuar.setIcon(imgb11);

		lblcontinuar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				Image imgfondo = new ImageIcon(".\\images\\botoncontinuarencima.png").getImage();
				ImageIcon imgfondo1 = new ImageIcon(imgfondo.getScaledInstance(215, 55, Image.SCALE_SMOOTH));
				lblcontinuar.setIcon(imgfondo1);
				Menu.sonido("sonidoboton.mp3");
			}

			@Override
			public void mouseExited(MouseEvent e) {

				Image imgfondo = new ImageIcon(".\\images\\botoncontinuar.png").getImage();
				ImageIcon imgfondo1 = new ImageIcon(imgfondo.getScaledInstance(215, 55, Image.SCALE_SMOOTH));
				lblcontinuar.setIcon(imgfondo1);
			}

			// Modificado....
			@Override
			public void mouseClicked(MouseEvent e) {

				/*
				 * if (validateCharacter()) { Personaje nuevo = new Personaje(nombre, sexo,
				 * raza, profesion, edad); System.out.println("Todo rellenado");//Borrar esto..
				 * }
				 */
				
				timer.cancel();
				timer.purge();

			}
		});

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(123, 16, 311, 105);
		contentPane.add(lblNewLabel_1);
		Image prueba = new ImageIcon(".\\images\\titulo.png").getImage();
		ImageIcon probando = new ImageIcon(prueba.getScaledInstance(300, 90, Image.SCALE_SMOOTH));
		lblNewLabel_1.setIcon(probando);

		JLabel lblvolver = new JLabel("");
		lblvolver.setBounds(308, 794, 74, 76);
		contentPane.add(lblvolver);

		Image imgvolver = new ImageIcon(".\\images\\volver.png").getImage();
		ImageIcon imgv = new ImageIcon(imgvolver.getScaledInstance(60, 80, Image.SCALE_SMOOTH));
		lblvolver.setIcon(imgv);

		lblvolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				Image imgvolver = new ImageIcon(".\\images\\volverencima.png").getImage();
				ImageIcon imgv = new ImageIcon(imgvolver.getScaledInstance(60, 80, Image.SCALE_SMOOTH));
				lblvolver.setIcon(imgv);

				Menu.sonido("sonidoboton.mp3");
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				frame.dispose();
				Menu.frame.setVisible(true);
				//timer.cancel();
				timer.purge();
			}

			@Override
			public void mouseExited(MouseEvent e) {

				Image imgvolver = new ImageIcon(".\\images\\volver.png").getImage();
				ImageIcon imgv = new ImageIcon(imgvolver.getScaledInstance(60, 80, Image.SCALE_SMOOTH));
				lblvolver.setIcon(imgv);
			}
		});

		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Maiandra GD", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(311, 201, 186, 27);
		contentPane.add(lblNewLabel);

		txtnombre = new JTextField();
		txtnombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				if (txtnombre.getText().length() >= 30) // LIMITAMOS EL TEXTFIELD A 30 CARACTERES
					e.consume();

			}
		});
		txtnombre.setBounds(308, 231, 244, 27);
		contentPane.add(txtnombre);
		txtnombre.setColumns(10);

		JLabel lblProfesionActual = new JLabel("Profesion Actual");
		lblProfesionActual.setForeground(new Color(0, 0, 0));
		lblProfesionActual.setFont(new Font("Maiandra GD", Font.BOLD, 18));
		lblProfesionActual.setBounds(647, 201, 238, 27);
		contentPane.add(lblProfesionActual);

		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setForeground(new Color(0, 0, 0));
		lblEdad.setFont(new Font("Maiandra GD", Font.BOLD, 18));
		lblEdad.setBounds(311, 276, 186, 27);
		contentPane.add(lblEdad);

		// RESTRINGIMOS EL TEXTFIELD A USO NUMÉRICO

		txtedad = new JFormattedTextField();
		txtedad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				if (txtedad.getText().length() >= 4) // LIMITAMOS EL TEXTFIELD A 4 CARACTERES
					e.consume();

				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}

			}
		});
		txtedad.setColumns(10);
		txtedad.setBounds(308, 303, 85, 27);
		contentPane.add(txtedad);

		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setForeground(new Color(0, 0, 0));
		lblSexo.setFont(new Font("Maiandra GD", Font.BOLD, 18));
		lblSexo.setBounds(647, 271, 186, 27);
		contentPane.add(lblSexo);

		JLabel lblRaza = new JLabel("Raza");
		lblRaza.setForeground(new Color(0, 0, 0));
		lblRaza.setFont(new Font("Maiandra GD", Font.BOLD, 18));
		lblRaza.setBounds(311, 342, 186, 27);
		contentPane.add(lblRaza);

		comboProfesion = new JComboBox();
		comboProfesion.setModel(new DefaultComboBoxModel(new String[] { "-" }));
		comboProfesion.setBounds(644, 232, 241, 27);
		contentPane.add(comboProfesion);

		comboRaza = new JComboBox();
		comboRaza.setModel(new DefaultComboBoxModel(new String[] { "Humano/a", "Elfo/a", "Enano/a", "Halfling" }));
		comboRaza.setBounds(308, 374, 121, 27);
		contentPane.add(comboRaza);

		comboSexo = new JComboBox();
		comboSexo.setModel(new DefaultComboBoxModel(new String[] { "Masculino", "Femenino" }));
		comboSexo.setBounds(644, 303, 109, 27);
		contentPane.add(comboSexo);

		JLabel lblraza = new JLabel("");
		lblraza.setBounds(646, 270, 564, 584);
		contentPane.add(lblraza);

		JLabel lbldescripcion = new JLabel("");
		lbldescripcion.setVerticalAlignment(SwingConstants.TOP);
		lbldescripcion.setHorizontalAlignment(SwingConstants.LEFT);
		lbldescripcion.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lbldescripcion.setForeground(Color.BLACK);
		lbldescripcion.setBounds(308, 426, 319, 456);
		contentPane.add(lbldescripcion);

		// ASIGNAMOS POR DEFECTO LA DESCRIPCION Y LA IMAGEN DE LA RAZA DE LOS HUMANOS (
		// YA QUE VA A SER LA PRIMERA DE LA LISTA )

		objetoContenido.setRaza(comboRaza.getSelectedItem().toString());
		descripcion = objetoContenido.getRaza();
		lbldescripcion.setText(descripcion);

		profesiones = Contenido.profesiones(comboRaza.getSelectedItem().toString());
		comboProfesion.setModel(new DefaultComboBoxModel(profesiones));

		Image img = new ImageIcon(".\\images\\humano-hechicero.png").getImage();
		ImageIcon imghumano = new ImageIcon(img.getScaledInstance(640, 680, Image.SCALE_SMOOTH));
		lblraza.setIcon(imghumano);

		Image imgh = new ImageIcon(".\\images\\pergahorizontal.png").getImage();
		ImageIcon imgperga = new ImageIcon(imgh.getScaledInstance(1165, 832, Image.SCALE_SMOOTH));

		JLabel lblPersonaje = new JLabel("Nuevo Personaje");
		lblPersonaje.setForeground(new Color(255, 204, 0));
		lblPersonaje.setFont(new Font("SimSun", Font.BOLD, 56));
		lblPersonaje.setBounds(433, 6, 510, 115);
		contentPane.add(lblPersonaje);

		JLabel label = new JLabel("Nuevo Personaje");
		label.setForeground(new Color(0, 0, 0));
		label.setFont(new Font("SimSun", Font.BOLD, 56));
		label.setBounds(429, 6, 781, 115);
		contentPane.add(label);

		JLabel lblperga = new JLabel("");
		lblperga.setVerticalAlignment(SwingConstants.TOP);
		lblperga.setHorizontalAlignment(SwingConstants.LEFT);
		lblperga.setForeground(Color.YELLOW);
		lblperga.setFont(new Font("Eras Demi ITC", Font.PLAIN, 18));
		lblperga.setBounds(56, 120, 1165, 832);
		contentPane.add(lblperga);
		lblperga.setIcon(imgperga);

		JLabel FONDO = new JLabel("");
		FONDO.setBounds(0, 0, 1270, 991);
		contentPane.add(FONDO);
		FONDO.setIcon(imgfondo1);

		// DEFINIMOS QUE AL CAMBIAR EL ITEM SELECCIONADO DEL COMBOBOX, TAMBIÉN CAMBIEN
		// LA IMAGEN Y LA DESCRIPCIÓN

		// CAMBIAMOS FOTOS SEGÚN RAZA Y SEXO

		comboSexo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int indiceRaza = comboRaza.getSelectedIndex();

				int indiceSexo = comboSexo.getSelectedIndex();

				switch (indiceRaza) {
				case 0:

					objetoContenido.setRaza("Humano/a");

					descripcion = objetoContenido.getRaza();

					lbldescripcion.setText(descripcion);

					if (indiceSexo == 0) {

						Image img0 = new ImageIcon(".\\images\\humano-hechicero.png").getImage();
						ImageIcon imghuman = new ImageIcon(img0.getScaledInstance(640, 680, Image.SCALE_SMOOTH));
						lblraza.setIcon(imghuman);

					} else {

						Image img0 = new ImageIcon(".\\images\\humano-rogue.png").getImage();
						ImageIcon imghuman = new ImageIcon(img0.getScaledInstance(600, 620, Image.SCALE_SMOOTH));
						lblraza.setIcon(imghuman);

					}

					profesiones = Contenido.profesiones("Humano/a");
					comboProfesion.setModel(new DefaultComboBoxModel(profesiones));
					break;

				case 1:

					objetoContenido.setRaza("Elfo/a");

					descripcion = objetoContenido.getRaza();

					lbldescripcion.setText(descripcion);

					if (indiceSexo == 0) {

						Image img1 = new ImageIcon(".\\images\\elfo-rogue.png").getImage();
						ImageIcon imgelfo = new ImageIcon(img1.getScaledInstance(420, 520, Image.SCALE_SMOOTH));
						lblraza.setIcon(imgelfo);

					} else {

						Image img1 = new ImageIcon(".\\images\\elfa-rogue.png").getImage();
						ImageIcon imgelfo = new ImageIcon(img1.getScaledInstance(540, 660, Image.SCALE_SMOOTH));
						lblraza.setIcon(imgelfo);

					}

					profesiones = Contenido.profesiones("Elfo/a");
					comboProfesion.setModel(new DefaultComboBoxModel(profesiones));

					break;

				case 2:

					objetoContenido.setRaza("Enano/a");

					descripcion = objetoContenido.getRaza();

					lbldescripcion.setText(descripcion);

					if (indiceSexo == 0) {

						Image imgh = new ImageIcon(".\\images\\enano.png").getImage();
						ImageIcon imgenanos = new ImageIcon(imgh.getScaledInstance(400, 450, Image.SCALE_SMOOTH));
						lblraza.setIcon(imgenanos);

					} else {

						Image imgh = new ImageIcon(".\\images\\enana.png").getImage();
						ImageIcon imgenanos = new ImageIcon(imgh.getScaledInstance(540, 550, Image.SCALE_SMOOTH));
						lblraza.setIcon(imgenanos);

					}

					profesiones = Contenido.profesiones("Enano/a");
					comboProfesion.setModel(new DefaultComboBoxModel(profesiones));

					break;

				case 3:
					objetoContenido.setRaza("Halfling");

					descripcion = objetoContenido.getRaza();

					lbldescripcion.setText(descripcion);

					if (indiceSexo == 0) {

						Image img3 = new ImageIcon(".\\images\\halflingduo.png").getImage();
						ImageIcon imghalfling = new ImageIcon(img3.getScaledInstance(470, 500, Image.SCALE_SMOOTH));
						lblraza.setIcon(imghalfling);

					} else {

						Image img3 = new ImageIcon(".\\images\\halflingchica.png").getImage();
						ImageIcon imghalfling = new ImageIcon(img3.getScaledInstance(400, 420, Image.SCALE_SMOOTH));
						lblraza.setIcon(imghalfling);

					}

					profesiones = Contenido.profesiones("Halfling");
					comboProfesion.setModel(new DefaultComboBoxModel(profesiones));

					break;

				default:

					objetoContenido.setRaza("Humano/a");

					descripcion = objetoContenido.getRaza();

					lbldescripcion.setText(descripcion);

					if (indiceSexo == 0) {

						Image img0 = new ImageIcon(".\\images\\humano-hechicero.png").getImage();
						ImageIcon imghuman = new ImageIcon(img0.getScaledInstance(640, 680, Image.SCALE_SMOOTH));
						lblraza.setIcon(imghuman);

					} else {

						Image img = new ImageIcon(".\\images\\humano-rogue.png").getImage();
						ImageIcon imghumano = new ImageIcon(img.getScaledInstance(600, 620, Image.SCALE_SMOOTH));
						lblraza.setIcon(imghumano);

					}

					profesiones = Contenido.profesiones("Humano/a");
					comboProfesion.setModel(new DefaultComboBoxModel(profesiones));

					break;
				}

			}

		});

		comboRaza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				int indiceRaza = comboRaza.getSelectedIndex();

				int indiceSexo = comboSexo.getSelectedIndex();

				switch (indiceRaza) {

				case 0:

					objetoContenido.setRaza("Humano/a");

					descripcion = objetoContenido.getRaza();

					lbldescripcion.setText(descripcion);

					if (indiceSexo == 0) {

						Image img0 = new ImageIcon(".\\images\\humano-hechicero.png").getImage();
						ImageIcon imghuman = new ImageIcon(img0.getScaledInstance(640, 680, Image.SCALE_SMOOTH));
						lblraza.setIcon(imghuman);

					} else {

						Image img0 = new ImageIcon(".\\images\\humano-rogue.png").getImage();
						ImageIcon imghuman = new ImageIcon(img0.getScaledInstance(600, 620, Image.SCALE_SMOOTH));
						lblraza.setIcon(imghuman);

					}

					profesiones = Contenido.profesiones("Humano/a");
					comboProfesion.setModel(new DefaultComboBoxModel(profesiones));
					break;

				case 1:

					objetoContenido.setRaza("Elfo/a");

					descripcion = objetoContenido.getRaza();

					lbldescripcion.setText(descripcion);

					if (indiceSexo == 0) {

						Image img1 = new ImageIcon(".\\images\\elfo-rogue.png").getImage();
						ImageIcon imgelfo = new ImageIcon(img1.getScaledInstance(420, 520, Image.SCALE_SMOOTH));
						lblraza.setIcon(imgelfo);

					} else {

						Image img1 = new ImageIcon(".\\images\\elfa-rogue.png").getImage();
						ImageIcon imgelfo = new ImageIcon(img1.getScaledInstance(540, 660, Image.SCALE_SMOOTH));
						lblraza.setIcon(imgelfo);

					}

					profesiones = Contenido.profesiones("Elfo/a");
					comboProfesion.setModel(new DefaultComboBoxModel(profesiones));

					break;

				case 2:

					objetoContenido.setRaza("Enano/a");

					descripcion = objetoContenido.getRaza();

					lbldescripcion.setText(descripcion);

					if (indiceSexo == 0) {

						Image imgh = new ImageIcon(".\\images\\enano.png").getImage();
						ImageIcon imgenanos = new ImageIcon(imgh.getScaledInstance(400, 450, Image.SCALE_SMOOTH));
						lblraza.setIcon(imgenanos);

					} else {

						Image imgh = new ImageIcon(".\\images\\enana.png").getImage();
						ImageIcon imgenanos = new ImageIcon(imgh.getScaledInstance(540, 550, Image.SCALE_SMOOTH));
						lblraza.setIcon(imgenanos);

					}

					profesiones = Contenido.profesiones("Enano/a");
					comboProfesion.setModel(new DefaultComboBoxModel(profesiones));

					break;

				case 3:
					objetoContenido.setRaza("Halfling");

					descripcion = objetoContenido.getRaza();

					lbldescripcion.setText(descripcion);

					if (indiceSexo == 0) {

						Image img3 = new ImageIcon(".\\images\\halflingduo.png").getImage();
						ImageIcon imghalfling = new ImageIcon(img3.getScaledInstance(470, 500, Image.SCALE_SMOOTH));
						lblraza.setIcon(imghalfling);

					} else {

						Image img3 = new ImageIcon(".\\images\\halflingchica.png").getImage();
						ImageIcon imghalfling = new ImageIcon(img3.getScaledInstance(400, 420, Image.SCALE_SMOOTH));
						lblraza.setIcon(imghalfling);

					}

					profesiones = Contenido.profesiones("Halfling");
					comboProfesion.setModel(new DefaultComboBoxModel(profesiones));

					break;

				default:

					objetoContenido.setRaza("Humano/a");

					descripcion = objetoContenido.getRaza();

					lbldescripcion.setText(descripcion);

					if (indiceSexo == 0) {

						Image img0 = new ImageIcon(".\\images\\humano-hechicero.png").getImage();
						ImageIcon imghuman = new ImageIcon(img0.getScaledInstance(640, 680, Image.SCALE_SMOOTH));
						lblraza.setIcon(imghuman);

					} else {

						Image img = new ImageIcon(".\\images\\humano-rogue.png").getImage();
						ImageIcon imghumano = new ImageIcon(img.getScaledInstance(600, 620, Image.SCALE_SMOOTH));
						lblraza.setIcon(imghumano);

					}

					profesiones = Contenido.profesiones("Humano/a");
					comboProfesion.setModel(new DefaultComboBoxModel(profesiones));

					break;
				}

			}

		});
		

	}

	private static void validateCharacter() {
		int steps = 0;

		if (txtnombre.getText() != null && txtnombre.getText() != "" && !txtnombre.getText().equals("")) {
			nombre = txtnombre.getText();
			steps += 1;
		}

		if (comboSexo.getSelectedItem() != null && comboSexo.getSelectedItem() != ""
				&& !comboSexo.getSelectedItem().equals("")) {
			sexo = comboSexo.getSelectedItem().toString();
			steps += 1;
		}

		if (comboRaza.getSelectedItem().toString() != null && comboRaza.getSelectedItem().toString() != ""
				&& !comboRaza.getSelectedItem().equals("")) {
			raza = comboRaza.getSelectedItem().toString();
			steps += 1;
		}

		if (comboProfesion.getSelectedItem().toString() != null && comboProfesion.getSelectedItem().toString() != ""
				&& !comboProfesion.getSelectedItem().equals("")) {
			profesion = comboProfesion.getSelectedItem().toString();
			steps += 1;
		}

		if (txtedad.getText() != null && txtedad.getText() != "" && !txtedad.getText().equals("")) {
			edad = txtedad.getText();
			steps += 1;
		}

		if (steps == 5) {
			lblcontinuar.setVisible(true);
		} else {
			lblcontinuar.setVisible(false);
		}
		// Hay que hacer que una vez le demos al boton pare de comprobar o cerremos la ventana....
		timer.schedule(new TimerTask() {
			public void run() {
				validateCharacter();
				System.out.println("Hola");
			}
			}, 1000);
	    

	}
	
	

	
	

}