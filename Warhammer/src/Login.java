import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.commons.codec.digest.DigestUtils;

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
	private JTextField txtUsuario;
	private JPasswordField txtpass;
public static JLabel lblcampos;

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
	 */
	public Login() {

		Conectar.Conectar();
		
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

		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Maiandra GD", Font.BOLD, 18));
		txtUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsuario.setBounds(820, 408, 220, 28);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtpass = new JPasswordField();
		txtpass.setFont(new Font("Maiandra GD", Font.BOLD, 18));
		txtpass.setHorizontalAlignment(SwingConstants.CENTER);
		txtpass.setBounds(820, 498, 220, 28);
		contentPane.add(txtpass);

		// CREAMOS LABELS DE TITULO, FONDO, BOTONES

		JLabel lbltitulo = new JLabel("");
		lbltitulo.setBounds(685, 191, 516, 150);
		contentPane.add(lbltitulo);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsuario.setFont(new Font("Felix Titling", Font.BOLD, 18));
		lblUsuario.setBounds(820, 370, 187, 28);
		contentPane.add(lblUsuario);

		JLabel lblpass = new JLabel("CONTRASE\u00D1A");
		lblpass.setHorizontalAlignment(SwingConstants.LEFT);
		lblpass.setFont(new Font("Felix Titling", Font.BOLD, 18));
		lblpass.setBounds(820, 460, 187, 28);
		contentPane.add(lblpass);

		JLabel lblaceptar = new JLabel("");
		lblaceptar.setBounds(812, 584, 244, 55);
		contentPane.add(lblaceptar);

		JLabel lblregistro = new JLabel("");
		lblregistro.setBounds(812, 651, 244, 55);
		contentPane.add(lblregistro);

		JLabel label = new JLabel("WARHAMMER \u00AE  JUEGO DE ROL - TODOS LOS DERECHOS RESERVADOS");
		label.setForeground(SystemColor.windowBorder);
		label.setBounds(456, 951, 466, 28);
		contentPane.add(label);
		
		lblcampos = new JLabel("* Debes rellenar todos los campos");
		lblcampos.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblcampos.setForeground(Color.RED);
		lblcampos.setBounds(830, 538, 244, 16);
		contentPane.add(lblcampos);
		lblcampos.setVisible(false);

		JLabel lblperga = new JLabel("");
		lblperga.setBounds(720, 63, 428, 806);
		contentPane.add(lblperga);

		JLabel lblfondo = new JLabel("");
		lblfondo.setBounds(0, 0, 1270, 991);
		contentPane.add(lblfondo);

		// ASIGNAMOS IMAGENES A LOS LABELS CORRESPONDIENTES

		Image img = new ImageIcon(".\\images\\system\\titulo.png").getImage();
		ImageIcon img2 = new ImageIcon(img.getScaledInstance(490, 182, Image.SCALE_SMOOTH));
		lbltitulo.setIcon(img2);

		Image imgperga = new ImageIcon(".\\images\\system\\pergamino-horizontal.png").getImage();
		ImageIcon imgperga1 = new ImageIcon(imgperga.getScaledInstance(430, 813, Image.SCALE_SMOOTH));
		lblperga.setIcon(imgperga1);

		Image imgaceptar = new ImageIcon(".\\images\\system\\botonaceptar.png").getImage();
		ImageIcon imgaceptar2 = new ImageIcon(imgaceptar.getScaledInstance(240, 70, Image.SCALE_SMOOTH));
		lblaceptar.setIcon(imgaceptar2);

		Image imgregistro = new ImageIcon(".\\images\\system\\botonregistro.png").getImage();
		ImageIcon imgregistro2 = new ImageIcon(imgregistro.getScaledInstance(240, 70, Image.SCALE_SMOOTH));
		lblregistro.setIcon(imgregistro2);

		Image imgfondo = new ImageIcon(".\\images\\system\\fondo2.jpg").getImage();
		ImageIcon imgfondo1 = new ImageIcon(imgfondo.getScaledInstance(1280, 990, Image.SCALE_SMOOTH));
		lblfondo.setIcon(imgfondo1);

		// DEFINIMOS ACCIONES PARA CADA JLABEL QUE SIMULA UN BOTÓN Y LOS CAMPOS
		// RELLENABLES

		txtUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				if (txtUsuario.getText().length() >= 20)
					e.consume();

			}
		});

		txtpass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				if (txtpass.getText().length() >= 12)
					e.consume();

			}
		});

		lblaceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				Image imgaceptar = new ImageIcon(".\\images\\system\\botonaceptarencima.png").getImage();
				ImageIcon imgaceptar2 = new ImageIcon(imgaceptar.getScaledInstance(240, 70, Image.SCALE_SMOOTH));
				lblaceptar.setIcon(imgaceptar2);
				Reproductor.sonido(sonidoboton);

			}

			@Override
			public void mouseExited(MouseEvent e) {

				Image imgaceptar = new ImageIcon(".\\images\\system\\botonaceptar.png").getImage();
				ImageIcon imgaceptar2 = new ImageIcon(imgaceptar.getScaledInstance(240, 70, Image.SCALE_SMOOTH));
				lblaceptar.setIcon(imgaceptar2);
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				if (comprobacion()) {

					Menu.home();
					frame.setVisible(false);

				} else {

					// Login incorrecto
					
				}

			}
		});

		lblregistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				Image imgaceptar = new ImageIcon(".\\images\\system\\botonregistroencima.png").getImage();
				ImageIcon imgaceptar2 = new ImageIcon(imgaceptar.getScaledInstance(240, 70, Image.SCALE_SMOOTH));
				lblregistro.setIcon(imgaceptar2);
				Reproductor.sonido(sonidoboton);

			}

			@Override
			public void mouseExited(MouseEvent e) {

				Image imgaceptar = new ImageIcon(".\\images\\system\\botonregistro.png").getImage();
				ImageIcon imgaceptar2 = new ImageIcon(imgaceptar.getScaledInstance(240, 70, Image.SCALE_SMOOTH));
				lblregistro.setIcon(imgaceptar2);
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				frame.dispose();
				frame.setVisible(false);
				Registro.registrar();
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
	}

	public boolean comprobacion() {

		boolean esCorrecto = false;

		String usuario, pass, encriptada;
		usuario = txtUsuario.getText();
		pass = txtpass.getText();
		encriptada = DigestUtils.md5Hex(pass);

		// COMPROBACIÓN CAMPOS VACÍOS

		if (usuario.length() == 0 ||  pass.length() == 0) {

			/*String[] options = { "Aceptar" };

			JOptionPane.showOptionDialog(null, "No debes dejar ningún campo vacío", "Atención !",
					JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
			*/
			lblcampos.setText("* Debes rellenar todos los campos");
			lblcampos.setVisible(true);
			
		} else {

			// COMPROBACIÓN DE LOGIN
			
			lblcampos.setVisible(false);
			
			if (Consultas.compruebaLogin(usuario, encriptada)) {

				esCorrecto = true;

			} else {

				esCorrecto = false;
				lblcampos.setText("Usuario y/o contraseña incorrectos");
				lblcampos.setVisible(true);
			}

		}

		return esCorrecto;

	}
}
