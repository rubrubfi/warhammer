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

public class Menu extends JFrame {

	private JPanel contentPane;
	public static Menu frame;
	public static String sonidoboton, musicabase;

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
					frame = new Menu();
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
	public Menu() {

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

		// ASIGNAMOS UNA IMAGEN DE FONDO

		Image imgfondo = new ImageIcon(".\\images\\fondo2.jpg").getImage();
		ImageIcon imgfondo1 = new ImageIcon(imgfondo.getScaledInstance(1280, 990, Image.SCALE_SMOOTH));

		// IMAGEN DE TITULO

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(685, 191, 516, 150);
		contentPane.add(lblNewLabel);

		Image img = new ImageIcon(".\\images\\titulo.png").getImage();
		ImageIcon img2 = new ImageIcon(img.getScaledInstance(490, 182, Image.SCALE_SMOOTH));
		lblNewLabel.setIcon(img2);

		Image imgsalir = new ImageIcon(".\\images\\boton-salir.png").getImage();
		ImageIcon imgsaliendo = new ImageIcon(imgsalir.getScaledInstance(40, 40, Image.SCALE_SMOOTH));

		// DEFINIMOS BOTONES

		JLabel btn1 = new JLabel("");
		btn1.setHorizontalAlignment(SwingConstants.CENTER);
		btn1.setBounds(769, 498, 332, 64);
		contentPane.add(btn1);

		JLabel btn2 = new JLabel("");
		btn2.setHorizontalAlignment(SwingConstants.CENTER);
		btn2.setBounds(769, 608, 332, 64);
		contentPane.add(btn2);

		JLabel btn3 = new JLabel("");
		btn3.setForeground(Color.BLACK);
		btn3.setHorizontalAlignment(SwingConstants.CENTER);
		btn3.setBounds(769, 387, 332, 64);
		contentPane.add(btn3);

		// ASIGNAMOS IMAGEN A LOS BOTONES

		Image imgb1 = new ImageIcon(".\\images\\boton1.png").getImage();
		ImageIcon imgb11 = new ImageIcon(imgb1.getScaledInstance(300, 80, Image.SCALE_SMOOTH));
		btn1.setIcon(imgb11);

		Image imgb2 = new ImageIcon(".\\images\\boton2.png").getImage();
		ImageIcon imgb22 = new ImageIcon(imgb2.getScaledInstance(300, 80, Image.SCALE_SMOOTH));
		btn2.setIcon(imgb22);

		Image imgb3 = new ImageIcon(".\\images\\boton3.png").getImage();
		ImageIcon imgb33 = new ImageIcon(imgb3.getScaledInstance(300, 80, Image.SCALE_SMOOTH));
		btn3.setIcon(imgb33);

		JLabel lblsalir = new JLabel("");
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
		lblsalir.setBounds(1125, 872, 76, 64);
		contentPane.add(lblsalir);

		Image imgtest = new ImageIcon(".\\images\\boton-salir.png").getImage();
		ImageIcon imgtest2 = new ImageIcon(imgtest.getScaledInstance(40, 40, Image.SCALE_SMOOTH));
		lblsalir.setIcon(imgtest2);

		Image imgperga = new ImageIcon(".\\images\\pergamino-horizontal.png").getImage();
		ImageIcon imgperga1 = new ImageIcon(imgperga.getScaledInstance(430, 813, Image.SCALE_SMOOTH));

		JLabel lblperga = new JLabel("");
		lblperga.setBounds(720, 63, 428, 806);
		contentPane.add(lblperga);
		lblperga.setIcon(imgperga1);

		JLabel lblfondo = new JLabel("");
		lblfondo.setBounds(0, 0, 1270, 991);
		contentPane.add(lblfondo);
		lblfondo.setIcon(imgfondo1);

		// COMPORTAMIENTO AL CLICK

		btn1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {

				Image imgclick = new ImageIcon(".\\images\\boton1encima.png").getImage();
				ImageIcon imgb11 = new ImageIcon(imgclick.getScaledInstance(300, 80, Image.SCALE_SMOOTH));
				btn1.setIcon(imgb11);
				sonido(sonidoboton);

			}

			@Override
			public void mouseExited(MouseEvent e) {

				Image imgnormal = new ImageIcon(".\\images\\boton1.png").getImage();
				ImageIcon imgb12 = new ImageIcon(imgnormal.getScaledInstance(300, 80, Image.SCALE_SMOOTH));
				btn1.setIcon(imgb12);

			}
		});

		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				Image imgclick = new ImageIcon(".\\images\\boton2encima.png").getImage();
				ImageIcon imgb21 = new ImageIcon(imgclick.getScaledInstance(300, 80, Image.SCALE_SMOOTH));
				btn2.setIcon(imgb21);
				sonido(sonidoboton);

			}

			public void mouseExited(MouseEvent e) {
				Image imgnormal = new ImageIcon(".\\images\\boton2.png").getImage();
				ImageIcon imgb22 = new ImageIcon(imgnormal.getScaledInstance(300, 80, Image.SCALE_SMOOTH));
				btn2.setIcon(imgb22);
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

		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				Image imgclick = new ImageIcon(".\\images\\boton3encima.png").getImage();
				ImageIcon imgb33 = new ImageIcon(imgclick.getScaledInstance(300, 80, Image.SCALE_SMOOTH));
				btn3.setIcon(imgb33);
				sonido(sonidoboton);

			}

			public void mouseExited(MouseEvent e) {
				Image imgnormal = new ImageIcon(".\\images\\boton3.png").getImage();
				ImageIcon imgb34 = new ImageIcon(imgnormal.getScaledInstance(300, 80, Image.SCALE_SMOOTH));
				btn3.setIcon(imgb34);
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				NuevoPersonaje.start();
				frame.setVisible(false);

			}
		});

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
