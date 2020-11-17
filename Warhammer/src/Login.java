import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javazoom.jl.decoder.JavaLayerException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Login extends JFrame {

	private JPanel contentPane;
	public static Login frame;
	public static String sonidoboton, musicabase;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Login();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {

		sonidoboton = "sonidoboton.mp3";
		musicabase = "musicabase.mp3";

		setTitle("WARHAMMER - EL JUEGO DE ROL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 1024);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// CREAMOS UN JLABEL SIMULANDO EL BOTÓN DE EXIT, LE ASIGNAMOS LA IMAGEN Y LE
		// DEFINIMOS EL FUNCIONAMIENTO EN EL ACTION LISTENER

		JLabel lblsalir = new JLabel("");
		lblsalir.setBounds(1125, 872, 76, 64);
		contentPane.add(lblsalir);
		Image imgtest = new ImageIcon(".\\images\\boton-salir.png").getImage();
		ImageIcon imgtest2 = new ImageIcon(imgtest.getScaledInstance(40, 40, Image.SCALE_SMOOTH));
		lblsalir.setIcon(imgtest2);
		lblsalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int seleccion = JOptionPane.showOptionDialog(null, "¿Quieres salir del programa?",
						"Warhammer - Salir del juego", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
						new Object[] { "Si", "Cancelar" }, "opcion 1");

				switch (seleccion) {

				case 0:
					System.exit(0);
					break;

				case 1:

					break;

				}

			}

			@Override
			public void mouseEntered(MouseEvent e) {

				Image imgsalir = new ImageIcon(".\\images\\boton-salir-encima.png").getImage();
				ImageIcon imgb11 = new ImageIcon(imgsalir.getScaledInstance(40, 40, Image.SCALE_SMOOTH));
				lblsalir.setIcon(imgb11);
				sonido(sonidoboton);
			}

			@Override
			public void mouseExited(MouseEvent e) {

				Image imgsalir = new ImageIcon(".\\images\\boton-salir.png").getImage();
				ImageIcon imgb11 = new ImageIcon(imgsalir.getScaledInstance(40, 40, Image.SCALE_SMOOTH));
				lblsalir.setIcon(imgb11);

			}
		});

		// DEFINIMOS UN JLABEL PARA EL TITULO , Y LE ASIGNAMOS UNA IMAGEN

		JLabel lbltitulo = new JLabel("");
		lbltitulo.setBounds(685, 191, 516, 150);
		contentPane.add(lbltitulo);
		Image img = new ImageIcon(".\\images\\titulo.png").getImage();
		ImageIcon img2 = new ImageIcon(img.getScaledInstance(490, 182, Image.SCALE_SMOOTH));
		lbltitulo.setIcon(img2);

		textField = new JTextField();
		textField.setFont(new Font("Maiandra GD", Font.BOLD, 18));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(820, 408, 220, 28);
		contentPane.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Maiandra GD", Font.BOLD, 18));
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(820, 498, 220, 28);
		contentPane.add(passwordField);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsuario.setFont(new Font("Felix Titling", Font.BOLD, 20));
		lblUsuario.setBounds(820, 370, 187, 28);
		contentPane.add(lblUsuario);

		JLabel lblpass = new JLabel("CONTRASE\u00D1A");
		lblpass.setHorizontalAlignment(SwingConstants.LEFT);
		lblpass.setFont(new Font("Felix Titling", Font.BOLD, 20));
		lblpass.setBounds(820, 460, 187, 28);
		contentPane.add(lblpass);

		// DEFINIMOS UN JLABEL SIMULANDO BOTÓN PARA CONTINUAR
		
		JLabel lblaceptar = new JLabel("");
		lblaceptar.setBounds(795, 549, 270, 70);
		contentPane.add(lblaceptar);
		Image imgaceptar = new ImageIcon(".\\images\\botonaceptar.png").getImage();
		ImageIcon imgaceptar2 = new ImageIcon(imgaceptar.getScaledInstance(270, 70, Image.SCALE_SMOOTH));
		lblaceptar.setIcon(imgaceptar2);
		// ASIGNAMOS LISTENERS AL BOTON, PARA QUE CAMBIE LA IMAGEN O ABRA UNA NUEVA
		// VENTANA
		lblaceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				Image imgaceptar = new ImageIcon(".\\images\\botonaceptarencima.png").getImage();
				ImageIcon imgaceptar2 = new ImageIcon(imgaceptar.getScaledInstance(270, 70, Image.SCALE_SMOOTH));
				lblaceptar.setIcon(imgaceptar2);
				sonido(sonidoboton);

			}

			@Override
			public void mouseExited(MouseEvent e) {

				Image imgaceptar = new ImageIcon(".\\images\\botonaceptar.png").getImage();
				ImageIcon imgaceptar2 = new ImageIcon(imgaceptar.getScaledInstance(270, 70, Image.SCALE_SMOOTH));
				lblaceptar.setIcon(imgaceptar2);
			}
		});
		
		// DEFINIMOS UN JLABEL SIMULANDO BOTÓN PARA REGISTRO

		JLabel lblregistro = new JLabel("");		
		lblregistro.setBounds(795, 621, 270, 70);
		contentPane.add(lblregistro);
		Image imgregistro = new ImageIcon(".\\images\\botonregistro.png").getImage();
		ImageIcon imgregistro2 = new ImageIcon(imgregistro.getScaledInstance(270, 70, Image.SCALE_SMOOTH));
		lblregistro.setIcon(imgregistro2);		
		
		lblregistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				Image imgaceptar = new ImageIcon(".\\images\\botonregistroencima.png").getImage();
				ImageIcon imgaceptar2 = new ImageIcon(imgaceptar.getScaledInstance(270, 70, Image.SCALE_SMOOTH));
				lblregistro.setIcon(imgaceptar2);
				sonido(sonidoboton);

			}

			@Override
			public void mouseExited(MouseEvent e) {

				Image imgaceptar = new ImageIcon(".\\images\\botonregistro.png").getImage();
				ImageIcon imgaceptar2 = new ImageIcon(imgaceptar.getScaledInstance(270, 70, Image.SCALE_SMOOTH));
				lblregistro.setIcon(imgaceptar2);
			}
		});

		JLabel lblperga = new JLabel("");
		lblperga.setBounds(720, 63, 428, 806);
		contentPane.add(lblperga);
		Image imgperga = new ImageIcon(".\\images\\pergamino-horizontal.png").getImage();
		ImageIcon imgperga1 = new ImageIcon(imgperga.getScaledInstance(430, 813, Image.SCALE_SMOOTH));
		lblperga.setIcon(imgperga1);

		// Creamos un JLabel como fondo y le asignamos una foto
		JLabel lblfondo = new JLabel("");
		lblfondo.setBounds(0, 0, 1270, 991);
		contentPane.add(lblfondo);
		Image imgfondo = new ImageIcon(".\\images\\fondo2.jpg").getImage();
		ImageIcon imgfondo1 = new ImageIcon(imgfondo.getScaledInstance(1280, 990, Image.SCALE_SMOOTH));
		lblfondo.setIcon(imgfondo1);

		Thread t = new Thread(new MiHilo());
		t.start();

	}

	public class MiHilo extends Thread {

		public void run()

		{
			sonido(musicabase);
		}
	};

	public static void sonido(String archivo) {

		try {

			Reproductor musicobject = new Reproductor();
			musicobject.reproduce(archivo);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JavaLayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
