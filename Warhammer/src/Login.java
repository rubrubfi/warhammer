import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.SystemColor;
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
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

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
					
					try {
						for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
							if ("Nimbus".equals(info.getName())) {
								UIManager.setLookAndFeel(info.getClassName());
								break;
							}
						}
					} catch (Exception e) {
					}
					
					frame = new Login();
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

		// CREAMOS JTEXTFIELD Y PWDFIELD PARA EL LOGIN DEL USUARIO

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

		// CREAMOS LABELS DE TITULO, FONDO, BOTONES

		JLabel lbltitulo = new JLabel("");
		lbltitulo.setBounds(685, 191, 516, 150);
		contentPane.add(lbltitulo);

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

		JLabel lblaceptar = new JLabel("");
		lblaceptar.setBounds(795, 549, 270, 70);
		contentPane.add(lblaceptar);

		JLabel lblregistro = new JLabel("");
		lblregistro.setBounds(795, 621, 270, 70);
		contentPane.add(lblregistro);

		JLabel lblsalir = new JLabel("");
		lblsalir.setBounds(1125, 872, 76, 64);
		contentPane.add(lblsalir);

		JLabel label = new JLabel("WARHAMMER \u00AE  JUEGO DE ROL - TODOS LOS DERECHOS RESERVADOS");
		label.setForeground(SystemColor.windowBorder);
		label.setBounds(456, 951, 466, 28);
		contentPane.add(label);

		JLabel lblperga = new JLabel("");
		lblperga.setBounds(720, 63, 428, 806);
		contentPane.add(lblperga);

		JLabel lblfondo = new JLabel("");
		lblfondo.setBounds(0, 0, 1270, 991);
		contentPane.add(lblfondo);

		// ASIGNAMOS IMAGENES A LOS LABELS CORRESPONDIENTES

		Image img = new ImageIcon(".\\images\\titulo.png").getImage();
		ImageIcon img2 = new ImageIcon(img.getScaledInstance(490, 182, Image.SCALE_SMOOTH));
		lbltitulo.setIcon(img2);

		Image imgperga = new ImageIcon(".\\images\\pergamino-horizontal.png").getImage();
		ImageIcon imgperga1 = new ImageIcon(imgperga.getScaledInstance(430, 813, Image.SCALE_SMOOTH));
		lblperga.setIcon(imgperga1);

		Image imgaceptar = new ImageIcon(".\\images\\botonaceptar.png").getImage();
		ImageIcon imgaceptar2 = new ImageIcon(imgaceptar.getScaledInstance(270, 70, Image.SCALE_SMOOTH));
		lblaceptar.setIcon(imgaceptar2);

		Image imgregistro = new ImageIcon(".\\images\\botonregistro.png").getImage();
		ImageIcon imgregistro2 = new ImageIcon(imgregistro.getScaledInstance(270, 70, Image.SCALE_SMOOTH));
		lblregistro.setIcon(imgregistro2);

		Image imgtest = new ImageIcon(".\\images\\boton-salir.png").getImage();
		ImageIcon imgtest2 = new ImageIcon(imgtest.getScaledInstance(40, 40, Image.SCALE_SMOOTH));
		lblsalir.setIcon(imgtest2);

		Image imgfondo = new ImageIcon(".\\images\\fondo2.jpg").getImage();
		ImageIcon imgfondo1 = new ImageIcon(imgfondo.getScaledInstance(1280, 990, Image.SCALE_SMOOTH));
		lblfondo.setIcon(imgfondo1);

		// DEFINIMOS ACCIONES PARA CADA JLABEL QUE SIMULA UN BOTÓN

		lblaceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				Image imgaceptar = new ImageIcon(".\\images\\botonaceptarencima.png").getImage();
				ImageIcon imgaceptar2 = new ImageIcon(imgaceptar.getScaledInstance(270, 70, Image.SCALE_SMOOTH));
				lblaceptar.setIcon(imgaceptar2);
				Reproductor.sonido(sonidoboton);

			}

			@Override
			public void mouseExited(MouseEvent e) {

				Image imgaceptar = new ImageIcon(".\\images\\botonaceptar.png").getImage();
				ImageIcon imgaceptar2 = new ImageIcon(imgaceptar.getScaledInstance(270, 70, Image.SCALE_SMOOTH));
				lblaceptar.setIcon(imgaceptar2);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// COMPROBACIÓN DE LOGIN 
				
				Menu.home();
				frame.setVisible(false);
				
			}
		});

		lblregistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				Image imgaceptar = new ImageIcon(".\\images\\botonregistroencima.png").getImage();
				ImageIcon imgaceptar2 = new ImageIcon(imgaceptar.getScaledInstance(270, 70, Image.SCALE_SMOOTH));
				lblregistro.setIcon(imgaceptar2);
				Reproductor.sonido(sonidoboton);

			}

			@Override
			public void mouseExited(MouseEvent e) {

				Image imgaceptar = new ImageIcon(".\\images\\botonregistro.png").getImage();
				ImageIcon imgaceptar2 = new ImageIcon(imgaceptar.getScaledInstance(270, 70, Image.SCALE_SMOOTH));
				lblregistro.setIcon(imgaceptar2);
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				frame.dispose();
				frame.setVisible(false);
				Registro.registrar();
			}
		});
		

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
				Reproductor.sonido(sonidoboton);
			}

			@Override
			public void mouseExited(MouseEvent e) {

				Image imgsalir = new ImageIcon(".\\images\\boton-salir.png").getImage();
				ImageIcon imgb11 = new ImageIcon(imgsalir.getScaledInstance(40, 40, Image.SCALE_SMOOTH));
				lblsalir.setIcon(imgb11);

			}
		});


		Thread t = new Thread(new MiHilo());
		t.start();

	}

	public class MiHilo extends Thread {

		public void run()

		{
			Reproductor.sonido(musicabase);
		}
	};

}
