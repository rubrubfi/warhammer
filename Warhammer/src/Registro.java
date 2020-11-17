import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import javazoom.jl.decoder.JavaLayerException;

public class Registro extends JFrame {

	private JPanel contentPane;
	public static Registro frame;
	public static String sonidoboton, musicabase;
	private JTextField txtUsuario;
	private JPasswordField txtpass;
	private JPasswordField txtpass2;
	private JTextField txtCorreo;

	/**
	 * Launch the application.
	 */
	public static void registrar() {
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
					
					frame = new Registro();
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
	public Registro() {
		
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
		
		// CREAMOS JTEXTFIELD Y PWDFIELD PARA REALIZAR EL REGISTRO
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Maiandra GD", Font.BOLD, 18));
		txtUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsuario.setBounds(377, 443, 220, 28);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCorreo.setFont(new Font("Maiandra GD", Font.BOLD, 18));
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(377, 538, 220, 28);
		contentPane.add(txtCorreo);

		txtpass = new JPasswordField();
		txtpass.setFont(new Font("Maiandra GD", Font.BOLD, 18));
		txtpass.setHorizontalAlignment(SwingConstants.CENTER);
		txtpass.setBounds(698, 443, 220, 28);
		contentPane.add(txtpass);
		

		txtpass2 = new JPasswordField();
		txtpass2.setHorizontalAlignment(SwingConstants.CENTER);
		txtpass2.setFont(new Font("Maiandra GD", Font.BOLD, 18));
		txtpass2.setBounds(698, 538, 220, 28);
		contentPane.add(txtpass2);
		
		
		// CREAMOS JLABELS DE TITULO, FONDO Y BOTONES		
		
		JLabel lbltitulo = new JLabel("");
		lbltitulo.setBounds(392, 186, 516, 150);
		contentPane.add(lbltitulo);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsuario.setFont(new Font("Felix Titling", Font.BOLD, 17));
		lblUsuario.setBounds(377, 405, 187, 28);
		contentPane.add(lblUsuario);

		JLabel lblpass = new JLabel("CONTRASE\u00D1A");
		lblpass.setHorizontalAlignment(SwingConstants.LEFT);
		lblpass.setFont(new Font("Felix Titling", Font.BOLD, 17));
		lblpass.setBounds(698, 405, 187, 28);
		contentPane.add(lblpass);		
		
		JLabel lblaceptar = new JLabel("");
		lblaceptar.setBounds(510, 665, 270, 70);
		contentPane.add(lblaceptar);
		
		JLabel lblvolver = new JLabel("");
		lblvolver.setBounds(308, 794, 74, 76);
		contentPane.add(lblvolver);
		
		JLabel lblpass2 = new JLabel("CONFIRMAR CONTRASE\u00D1A");
		lblpass2.setHorizontalAlignment(SwingConstants.LEFT);
		lblpass2.setFont(new Font("Felix Titling", Font.BOLD, 17));
		lblpass2.setBounds(698, 500, 281, 28);
		contentPane.add(lblpass2);
		
		
		JLabel lblCorreo = new JLabel("CORREO");
		lblCorreo.setHorizontalAlignment(SwingConstants.LEFT);
		lblCorreo.setFont(new Font("Felix Titling", Font.BOLD, 17));
		lblCorreo.setBounds(377, 500, 187, 28);
		contentPane.add(lblCorreo);
		
		JLabel label = new JLabel("WARHAMMER \u00AE  JUEGO DE ROL - TODOS LOS DERECHOS RESERVADOS");
		label.setForeground(SystemColor.windowBorder);
		label.setBounds(456, 951, 466, 28);
		contentPane.add(label);		
		
		
		JLabel lblperga = new JLabel("");
		lblperga.setVerticalAlignment(SwingConstants.TOP);
		lblperga.setHorizontalAlignment(SwingConstants.LEFT);
		lblperga.setForeground(Color.YELLOW);
		lblperga.setFont(new Font("Eras Demi ITC", Font.PLAIN, 18));
		lblperga.setBounds(58, 93, 1165, 832);
		contentPane.add(lblperga);		
		
		JLabel lblfondo = new JLabel("");
		lblfondo.setBounds(0, 0, 1270, 991);
		contentPane.add(lblfondo);
		
		// ASIGNAMOS IMAGENES A LOS LABELS CORRESPONDIENTES
		
		Image img = new ImageIcon(".\\images\\titulo.png").getImage();
		ImageIcon img2 = new ImageIcon(img.getScaledInstance(490, 182, Image.SCALE_SMOOTH));
		lbltitulo.setIcon(img2);		
		
		Image imgaceptar = new ImageIcon(".\\images\\botonaceptar.png").getImage();
		ImageIcon imgaceptar2 = new ImageIcon(imgaceptar.getScaledInstance(270, 70, Image.SCALE_SMOOTH));
		lblaceptar.setIcon(imgaceptar2);	
		
		Image imgvolver = new ImageIcon(".\\images\\volver.png").getImage();
		ImageIcon imgv = new ImageIcon(imgvolver.getScaledInstance(60, 80, Image.SCALE_SMOOTH));
		lblvolver.setIcon(imgv);		
		
		Image imgh = new ImageIcon(".\\images\\pergahorizontal.png").getImage();
		ImageIcon imgperga = new ImageIcon(imgh.getScaledInstance(1165, 832, Image.SCALE_SMOOTH));
		lblperga.setIcon(imgperga);		
		
		Image imgfondo = new ImageIcon(".\\images\\fondo2.jpg").getImage();
		ImageIcon imgfondo1 = new ImageIcon(imgfondo.getScaledInstance(1280, 990, Image.SCALE_SMOOTH));
		lblfondo.setIcon(imgfondo1);
		
		
		// DEFINIMOS ACTION LISTENER A LOS BOTONES Y CAMPOS RELLENABLES
		
		txtUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				if (txtUsuario.getText().length() >= 20) 
					e.consume();

			}
		});
		
		txtCorreo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				if (txtCorreo.getText().length() >= 20) 
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
		
		txtpass2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				if (txtpass2.getText().length() >= 12) 
					e.consume();

			}
		});
		
		
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
				
				// DATOS CORRECTOS == CREAR USUARIO -> REDIRIGIR AL LOGIN
				
				JOptionPane.showMessageDialog(null, "Usuario registrado con éxito");
				frame.dispose();				
				frame.setVisible(false);
				Login.main(null);
				
				
			}
		});
		
		lblvolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				Image imgvolver = new ImageIcon(".\\images\\volverencima.png").getImage();
				ImageIcon imgv = new ImageIcon(imgvolver.getScaledInstance(60, 80, Image.SCALE_SMOOTH));
				lblvolver.setIcon(imgv);

				Reproductor.sonido("sonidoboton.mp3");
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				frame.dispose();
				frame.setVisible(false);
				Login.frame.setVisible(true);
				
				
			}

			@Override
			public void mouseExited(MouseEvent e) {

				Image imgvolver = new ImageIcon(".\\images\\volver.png").getImage();
				ImageIcon imgv = new ImageIcon(imgvolver.getScaledInstance(60, 80, Image.SCALE_SMOOTH));
				lblvolver.setIcon(imgv);
			}
		});
	}
	
	
}
