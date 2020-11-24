import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.SystemColor;

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
	public static JLabel lbldescripcion, lblraza;
	private static JLabel lblcontinuar = new JLabel("");

	// Paco
	private static String nombre;
	private static String sexo;
	private static String raza;
	private static String profesion;
	private static String edad;

	public int numberOfMillisecondsInTheFuture = 1000; // Ejecutar cada 1 sec
	Date timeToRun = new Date(System.currentTimeMillis() + numberOfMillisecondsInTheFuture);
	public Timer timer = new Timer();
	public Timer timer2 = new Timer();

	/**
	 * Launch the application.
	 * 
	 * @param id2
	 */
	public static void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new NuevoPersonaje();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					ImageIcon img = new ImageIcon(".\\images\\system\\icono.png");
					frame.setIconImage(img.getImage());

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the frame.
	 * 
	 * @param id2
	 */
	public NuevoPersonaje() {

		try {
			timer.purge();
			timer.schedule(new TimerTask() {
				public void run() {
					validateCharacter();
					System.out.println("Hola");
				}
			}, timeToRun);
		} catch (IllegalStateException e) {

		}

		setTitle("WARHAMMER - EL JUEGO DE ROL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 1024);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// CREAMOS TXTFIELD'S PARA LOS DATOS DE NOMBRE Y EDAD

		txtnombre = new JTextField();
		txtnombre.setBounds(308, 231, 244, 27);
		contentPane.add(txtnombre);
		txtnombre.setColumns(10);

		txtedad = new JFormattedTextField();
		txtedad.setColumns(10);
		txtedad.setBounds(308, 303, 85, 27);
		contentPane.add(txtedad);

		// CREAMOS COMBOBOX PARA RAZA, SEXO Y CLASE

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

		// CREAMOS JLABEL DE TITULO, FONDO , CONTENIDO..

		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Maiandra GD", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(311, 201, 186, 27);
		contentPane.add(lblNewLabel);

		JLabel label2 = new JLabel("WARHAMMER \u00AE  JUEGO DE ROL - TODOS LOS DERECHOS RESERVADOS");
		label2.setForeground(SystemColor.windowBorder);
		label2.setBounds(456, 951, 466, 28);
		contentPane.add(label2);

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

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(123, 16, 311, 105);
		contentPane.add(lblNewLabel_1);

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

		JLabel lblraza = new JLabel("");
		lblraza.setBounds(646, 270, 564, 584);
		contentPane.add(lblraza);

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

		JLabel lblvolver = new JLabel("");
		lblvolver.setBounds(290, 790, 121, 80);
		contentPane.add(lblvolver);

		JLabel lbldescripcion = new JLabel("");
		lbldescripcion.setVerticalAlignment(SwingConstants.TOP);
		lbldescripcion.setHorizontalAlignment(SwingConstants.LEFT);
		lbldescripcion.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lbldescripcion.setForeground(Color.BLACK);
		lbldescripcion.setBounds(308, 426, 319, 456);
		contentPane.add(lbldescripcion);

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

		JLabel FONDO = new JLabel("");
		FONDO.setBounds(0, 0, 1270, 991);
		contentPane.add(FONDO);

		// ASIGNAMOS A CADA JLABEL , SU IMAGEN CORRESPONDIENTE

		Image imgvolver = new ImageIcon(".\\images\\system\\botonvolverprueba.png").getImage();
		ImageIcon imgv = new ImageIcon(imgvolver.getScaledInstance(105, 65, Image.SCALE_SMOOTH));
		lblvolver.setIcon(imgv);

		Image prueba = new ImageIcon(".\\images\\system\\titulo.png").getImage();
		ImageIcon probando = new ImageIcon(prueba.getScaledInstance(300, 90, Image.SCALE_SMOOTH));
		lblNewLabel_1.setIcon(probando);

		Image imgb1 = new ImageIcon(".\\images\\system\\botoncontinuar.png").getImage();
		ImageIcon imgb11 = new ImageIcon(imgb1.getScaledInstance(215, 55, Image.SCALE_SMOOTH));
		lblcontinuar.setIcon(imgb11);

		Image imgh = new ImageIcon(".\\images\\system\\pergahorizontal.png").getImage();
		ImageIcon imgperga = new ImageIcon(imgh.getScaledInstance(1165, 832, Image.SCALE_SMOOTH));
		lblperga.setIcon(imgperga);

		Image imgfondo = new ImageIcon(".\\images\\system\\fondo2.jpg").getImage();
		ImageIcon imgfondo1 = new ImageIcon(imgfondo.getScaledInstance(1280, 990, Image.SCALE_SMOOTH));
		FONDO.setIcon(imgfondo1);

		// ASIGNAMOS POR DEFECTO LA DESCRIPCION Y LA IMAGEN DE LA RAZA DE LOS HUMANOS (
		// YA QUE VA A SER LA PRIMERA DE LA LISTA )

		// ESTO DEBERIA REALIZARSE MEDIANTE UNA COMPROBACIÓN AUTOMÁTICA MEDIANTE UN
		// MÉTODO
		// ---------------------------------------------------------------------------------

		Image img = new ImageIcon(".\\images\\razas\\humano-hechicero.png").getImage();
		ImageIcon imghumano = new ImageIcon(img.getScaledInstance(640, 680, Image.SCALE_SMOOTH));
		lblraza.setIcon(imghumano);

		objetoContenido.setRaza(comboRaza.getSelectedItem().toString());
		descripcion = objetoContenido.getRaza();
		lbldescripcion.setText(descripcion);

		profesiones = Contenido.profesiones(comboRaza.getSelectedItem().toString());
		comboProfesion.setModel(new DefaultComboBoxModel(profesiones));

		// DEFINIMOS ACCIONES EN LOS TEXTFIELD.
		// LIMITAMOS EL TEXTFIELD DE NOMBRE A 30 CARACTERES
		// LIMITAMOS EL TEXTFIELD DE EDAD A 4 CARACTERES Y NÚMEROS EXCLUSIVAMENTE
		// SI ESTAN VACIOS, NO PODEMOS CONTINUAR

		txtnombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				if (txtnombre.getText().length() >= 30)
					e.consume();

			}
		});

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

		lblcontinuar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				Image imgfondo = new ImageIcon(".\\images\\system\\botoncontinuarencima.png").getImage();
				ImageIcon imgfondo1 = new ImageIcon(imgfondo.getScaledInstance(215, 55, Image.SCALE_SMOOTH));
				lblcontinuar.setIcon(imgfondo1);
				Reproductor.sonido("sonidoboton.mp3");
			}

			@Override
			public void mouseExited(MouseEvent e) {

				Image imgfondo = new ImageIcon(".\\images\\system\\botoncontinuar.png").getImage();
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

				String nombre, raza, clase, genero;

				int edad, id;

				nombre = txtnombre.getText();
				raza = comboRaza.getSelectedItem().toString();
				clase = comboProfesion.getSelectedItem().toString();
				genero = comboSexo.getSelectedItem().toString();
				edad = Integer.parseInt(txtedad.getText());
				id = Menu.user.getId();

				Consultas.nuevoPersonaje(id, nombre, raza, clase, genero, edad);

				timer.cancel();
				timer2.cancel();

				Mispersonajes.personajes(id);
				frame.setVisible(false);

			}
		});

		lblvolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				Image imgvolver = new ImageIcon(".\\images\\system\\botonvolverpruebaencima.png").getImage();
				ImageIcon imgv = new ImageIcon(imgvolver.getScaledInstance(105, 65, Image.SCALE_SMOOTH));
				lblvolver.setIcon(imgv);

				Reproductor.sonido("sonidoboton.mp3");
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				frame.dispose();
				Menu.frame.setVisible(true);
				timer.cancel();
				timer2.cancel();
			}

			@Override
			public void mouseExited(MouseEvent e) {

				Image imgvolver = new ImageIcon(".\\images\\system\\botonvolverprueba.png").getImage();
				ImageIcon imgv = new ImageIcon(imgvolver.getScaledInstance(105, 65, Image.SCALE_SMOOTH));
				lblvolver.setIcon(imgv);
			}
		});

		// DEFINIMOS QUE AL CAMBIAR EL ITEM SELECCIONADO DEL COMBOBOX, TAMBIÉN CAMBIEN
		// LA IMAGEN Y LA DESCRIPCIÓN
		// CAMBIAMOS FOTOS SEGÚN RAZA Y SEXO

		// ------------------------------------------------------------------------------------
		// ESTE ACTION LISTENER (COMBOSEXO) Y EL DE MÁS ABAJO (COMBORAZA) TIENEN EL
		// MISMO CÓDIGO
		// HAY QUE CREAR UN MÉTODO EL CUAL RECIBA PARÁMETROS DE RAZA Y SEXO
		// Y ÉSTE TE DEVUELVA LA IMAGEN CORRESPONDIENTE
		// -------------------------------------------------------------------------------------

		comboSexo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int indiceRaza = comboRaza.getSelectedIndex();

				int indiceSexo = comboSexo.getSelectedIndex();

				dameImagen(indiceRaza, indiceSexo, objetoContenido, lbldescripcion, lblraza);
			}

		});

		comboRaza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				int indiceRaza = comboRaza.getSelectedIndex();

				int indiceSexo = comboSexo.getSelectedIndex();

				dameImagen(indiceRaza, indiceSexo, objetoContenido, lbldescripcion, lblraza);

			}

		});

	}

	// MÉTODO QUE VALIDA QUE LOS TEXTFIELD DE NOMBRE Y EDAD ESTÉN RELLENADOS
	// TRUE = MOSTRAR BOTÓN CONTINUAR
	// FALSE = OCULTAR BOTÓN

	private void validateCharacter() {
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

		// Controla que cada segundo valida los datos del personaje al crear uno nuevo
		try {
			timer2.purge();
			timer2.schedule(new TimerTask() {
				public void run() {
					validateCharacter();

				}
			}, 1000);
		} catch (IllegalStateException e) {
			System.out.println("Error en el metodo");
		}

	}

	public void dameImagen(int indiceRaza, int indiceSexo, Contenido objetoContenido2, JLabel lbldescripcion2,
			JLabel lblraza2) {

		switch (indiceRaza) {
		case 0:

			objetoContenido2.setRaza("Humano/a");

			descripcion = objetoContenido2.getRaza();

			lbldescripcion2.setText(descripcion);

			if (indiceSexo == 0) {

				Image img0 = new ImageIcon(".\\images\\razas\\humano-hechicero.png").getImage();
				ImageIcon imghuman = new ImageIcon(img0.getScaledInstance(640, 680, Image.SCALE_SMOOTH));
				lblraza2.setIcon(imghuman);

			} else {

				Image img0 = new ImageIcon(".\\images\\razas\\humano-rogue.png").getImage();
				ImageIcon imghuman = new ImageIcon(img0.getScaledInstance(590, 660, Image.SCALE_SMOOTH));
				lblraza2.setIcon(imghuman);

			}

			profesiones = Contenido.profesiones("Humano/a");
			comboProfesion.setModel(new DefaultComboBoxModel(profesiones));
			break;

		case 1:

			objetoContenido2.setRaza("Elfo/a");

			descripcion = objetoContenido2.getRaza();

			lbldescripcion2.setText(descripcion);

			if (indiceSexo == 0) {

				Image img1 = new ImageIcon(".\\images\\razas\\elfo-rogue.png").getImage();
				ImageIcon imgelfo = new ImageIcon(img1.getScaledInstance(650, 800, Image.SCALE_SMOOTH));
				lblraza2.setIcon(imgelfo);

			} else {

				Image img1 = new ImageIcon(".\\images\\razas\\elfa-rogue.png").getImage();
				ImageIcon imgelfo = new ImageIcon(img1.getScaledInstance(540, 660, Image.SCALE_SMOOTH));
				lblraza2.setIcon(imgelfo);

			}

			profesiones = Contenido.profesiones("Elfo/a");
			comboProfesion.setModel(new DefaultComboBoxModel(profesiones));

			break;

		case 2:

			objetoContenido2.setRaza("Enano/a");

			descripcion = objetoContenido2.getRaza();

			lbldescripcion2.setText(descripcion);

			if (indiceSexo == 0) {

				Image imgh = new ImageIcon(".\\images\\razas\\enano.png").getImage();
				ImageIcon imgenanos = new ImageIcon(imgh.getScaledInstance(400, 450, Image.SCALE_SMOOTH));
				lblraza2.setIcon(imgenanos);

			} else {

				Image imgh = new ImageIcon(".\\images\\razas\\enana.png").getImage();
				ImageIcon imgenanos = new ImageIcon(imgh.getScaledInstance(540, 550, Image.SCALE_SMOOTH));
				lblraza2.setIcon(imgenanos);

			}

			profesiones = Contenido.profesiones("Enano/a");
			comboProfesion.setModel(new DefaultComboBoxModel(profesiones));

			break;

		case 3:
			objetoContenido2.setRaza("Halfling");

			descripcion = objetoContenido2.getRaza();

			lbldescripcion2.setText(descripcion);

			if (indiceSexo == 0) {

				Image img3 = new ImageIcon(".\\images\\razas\\halflingduo.png").getImage();
				ImageIcon imghalfling = new ImageIcon(img3.getScaledInstance(470, 500, Image.SCALE_SMOOTH));
				lblraza2.setIcon(imghalfling);

			} else {

				Image img3 = new ImageIcon(".\\images\\razas\\halflingchica.png").getImage();
				ImageIcon imghalfling = new ImageIcon(img3.getScaledInstance(570, 620, Image.SCALE_SMOOTH));
				lblraza2.setIcon(imghalfling);

			}

			profesiones = Contenido.profesiones("Halfling");
			comboProfesion.setModel(new DefaultComboBoxModel(profesiones));

			break;

		default:

			objetoContenido2.setRaza("Humano/a");

			descripcion = objetoContenido2.getRaza();

			lbldescripcion2.setText(descripcion);

			if (indiceSexo == 0) {

				Image img0 = new ImageIcon(".\\images\\razas\\humano-hechicero.png").getImage();
				ImageIcon imghuman = new ImageIcon(img0.getScaledInstance(640, 680, Image.SCALE_SMOOTH));
				lblraza2.setIcon(imghuman);

			} else {

				Image img = new ImageIcon(".\\images\\razas\\humano-rogue.png").getImage();
				ImageIcon imghumano = new ImageIcon(img.getScaledInstance(590, 660, Image.SCALE_SMOOTH));
				lblraza2.setIcon(imghumano);

			}

			profesiones = Contenido.profesiones("Humano/a");
			comboProfesion.setModel(new DefaultComboBoxModel(profesiones));

			break;
		}

	}

}