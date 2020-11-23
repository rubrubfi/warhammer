import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import javazoom.jl.decoder.JavaLayerException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

public class Menu extends JFrame {

	private JPanel contentPane;
	public static Menu frame;
	public static String sonidoboton, musicabase;
	public static  ObjetoUsuario user;

	/**
	 * Launch the application.
	 * 
	 * @param usuario
	 * @param id
	 */
	public static void home(int id, String usuario) {
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
					frame = new Menu(id, usuario);
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
	 * @param usuario2
	 * @param id
	 */
	public Menu(int id2, String usuario2) {

		id2 = Consultas.obtieneid(usuario2);

		user = Consultas.defineUsuario(id2);

		sonidoboton = "sonidoboton.mp3";

		setTitle("WARHAMMER - EL JUEGO DE ROL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 1024);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// DEFINIMOS JLABEL

		JLabel lbltitulo = new JLabel("");
		lbltitulo.setBounds(685, 191, 516, 150);
		contentPane.add(lbltitulo);

		JLabel btn1 = new JLabel("");
		btn1.setHorizontalAlignment(SwingConstants.CENTER);
		btn1.setBounds(769, 388, 332, 64);
		contentPane.add(btn1);

		// ----------------------------------------------------

		
		JLabel btn2 = new JLabel("");
		btn2.setHorizontalAlignment(SwingConstants.CENTER);
		btn2.setBounds(769, 470, 332, 64);
		contentPane.add(btn2);

		JLabel btn3 = new JLabel("");
		btn3.setHorizontalAlignment(SwingConstants.CENTER);
		btn3.setBounds(769, 552, 332, 64);
		contentPane.add(btn3);

		JLabel btn4 = new JLabel("");
		btn4.setHorizontalAlignment(SwingConstants.CENTER);
		btn4.setBounds(769, 634, 332, 64);
		contentPane.add(btn4);

		JLabel label = new JLabel("WARHAMMER \u00AE  JUEGO DE ROL - TODOS LOS DERECHOS RESERVADOS");
		label.setForeground(SystemColor.windowBorder);
		label.setBounds(456, 951, 466, 28);
		contentPane.add(label);

		JLabel lblperga = new JLabel("");
		lblperga.setBounds(720, 63, 428, 806);
		contentPane.add(lblperga);

		JLabel lblsalir = new JLabel("");
		lblsalir.setBounds(1125, 872, 76, 64);
		contentPane.add(lblsalir);

		JLabel lblfondo = new JLabel("");
		lblfondo.setBounds(0, 0, 1270, 991);
		contentPane.add(lblfondo);

		// ASIGNAMOS IMAGEN A LOS JLABEL

		Image imgb1 = new ImageIcon(".\\images\\system\\boton1.png").getImage();
		ImageIcon imgb11 = new ImageIcon(imgb1.getScaledInstance(300, 80, Image.SCALE_SMOOTH));
		btn1.setIcon(imgb11);

		Image imgb2 = new ImageIcon(".\\images\\system\\boton2.png").getImage();
		ImageIcon imgb22 = new ImageIcon(imgb2.getScaledInstance(300, 80, Image.SCALE_SMOOTH));
		btn2.setIcon(imgb22);

		Image imgb3 = new ImageIcon(".\\images\\system\\boton3.png").getImage();
		ImageIcon imgb33 = new ImageIcon(imgb3.getScaledInstance(300, 80, Image.SCALE_SMOOTH));
		btn3.setIcon(imgb33);

		Image imgb4 = new ImageIcon(".\\images\\system\\boton4.png").getImage();
		ImageIcon imgb44 = new ImageIcon(imgb4.getScaledInstance(300, 80, Image.SCALE_SMOOTH));
		btn4.setIcon(imgb44);

		Image imgperga = new ImageIcon(".\\images\\system\\pergamino-horizontal.png").getImage();
		ImageIcon imgperga1 = new ImageIcon(imgperga.getScaledInstance(430, 813, Image.SCALE_SMOOTH));
		lblperga.setIcon(imgperga1);

		Image img = new ImageIcon(".\\images\\system\\titulo.png").getImage();
		ImageIcon img2 = new ImageIcon(img.getScaledInstance(490, 182, Image.SCALE_SMOOTH));
		lbltitulo.setIcon(img2);

		Image imgfondo = new ImageIcon(".\\images\\system\\fondo2.jpg").getImage();
		ImageIcon imgfondo1 = new ImageIcon(imgfondo.getScaledInstance(1280, 990, Image.SCALE_SMOOTH));
		lblfondo.setIcon(imgfondo1);

		Image imgsalir = new ImageIcon(".\\images\\system\\boton-salir.png").getImage();
		ImageIcon imgsaliendo = new ImageIcon(imgsalir.getScaledInstance(40, 40, Image.SCALE_SMOOTH));
		lblsalir.setIcon(imgsaliendo);

		
		// COMPORTAMIENTO AL CLICK EN LOS BOTONES

				btn1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {

						Image imgclick = new ImageIcon(".\\images\\system\\boton1encima.png").getImage();
						ImageIcon imgb33 = new ImageIcon(imgclick.getScaledInstance(300, 80, Image.SCALE_SMOOTH));
						btn1.setIcon(imgb33);
						Reproductor.sonido(sonidoboton);

					}

					public void mouseExited(MouseEvent e) {
						Image imgnormal = new ImageIcon(".\\images\\system\\boton1.png").getImage();
						ImageIcon imgb34 = new ImageIcon(imgnormal.getScaledInstance(300, 80, Image.SCALE_SMOOTH));
						btn1.setIcon(imgb34);
					}

					@Override
					public void mouseClicked(MouseEvent e) {

						NuevoPersonaje.start();
						frame.setVisible(false);

					}
				});

		
		btn2.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {

				Image imgclick = new ImageIcon(".\\images\\system\\boton2encima.png").getImage();
				ImageIcon imgb11 = new ImageIcon(imgclick.getScaledInstance(300, 80, Image.SCALE_SMOOTH));
				btn2.setIcon(imgb11);
				Reproductor.sonido(sonidoboton);

			}

			@Override
			public void mouseExited(MouseEvent e) {

				Image imgnormal = new ImageIcon(".\\images\\system\\boton2.png").getImage();
				ImageIcon imgb12 = new ImageIcon(imgnormal.getScaledInstance(300, 80, Image.SCALE_SMOOTH));
				btn2.setIcon(imgb12);

			}

			@Override
			public void mouseClicked(MouseEvent e) {

				frame.setVisible(false);
				
				int idusuario = user.getId();
				Mispersonajes.personajes(idusuario);
			}
		});

		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				Image imgclick = new ImageIcon(".\\images\\system\\boton3encima.png").getImage();
				ImageIcon imgb21 = new ImageIcon(imgclick.getScaledInstance(300, 80, Image.SCALE_SMOOTH));
				btn3.setIcon(imgb21);
				Reproductor.sonido(sonidoboton);

			}

			public void mouseExited(MouseEvent e) {
				Image imgnormal = new ImageIcon(".\\images\\system\\boton3.png").getImage();
				ImageIcon imgb22 = new ImageIcon(imgnormal.getScaledInstance(300, 80, Image.SCALE_SMOOTH));
				btn3.setIcon(imgb22);
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					PDFViewer.leer();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		btn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				Image imgclick = new ImageIcon(".\\images\\system\\boton4encima.png").getImage();
				ImageIcon imgb21 = new ImageIcon(imgclick.getScaledInstance(300, 80, Image.SCALE_SMOOTH));
				btn4.setIcon(imgb21);
				Reproductor.sonido(sonidoboton);

			}

			public void mouseExited(MouseEvent e) {
				Image imgnormal = new ImageIcon(".\\images\\system\\boton4.png").getImage();
				ImageIcon imgb22 = new ImageIcon(imgnormal.getScaledInstance(300, 80, Image.SCALE_SMOOTH));
				btn4.setIcon(imgb22);
			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});

		lblsalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Ventanasalir.salir(frame);

				frame.disable();

			}

			@Override
			public void mouseEntered(MouseEvent e) {

				Image imgsalir = new ImageIcon(".\\images\\system\\boton-salir-encima.png").getImage();
				ImageIcon imgb11 = new ImageIcon(imgsalir.getScaledInstance(40, 40, Image.SCALE_SMOOTH));
				lblsalir.setIcon(imgb11);
				Reproductor.sonido(sonidoboton);
			}

			@Override
			public void mouseExited(MouseEvent e) {

				Image imgsalir = new ImageIcon(".\\images\\system\\boton-salir.png").getImage();
				ImageIcon imgb11 = new ImageIcon(imgsalir.getScaledInstance(40, 40, Image.SCALE_SMOOTH));
				lblsalir.setIcon(imgb11);

			}
		});

	}

}
