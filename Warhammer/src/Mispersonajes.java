import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class Mispersonajes extends JFrame {

	private JPanel contentPane;
	public static Mispersonajes frame;
	public String sonidoboton;

	/**
	 * Launch the application.
	 * 
	 * @param idusuario
	 */
	public static void personajes(int idusuario) {
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

					frame = new Mispersonajes(idusuario);
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
	 * @param idusuario
	 */
	public Mispersonajes(int idusuario) {

		sonidoboton = "sonidoboton.mp3";

		setTitle("WARHAMMER - EL JUEGO DE ROL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 1024);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("WARHAMMER \u00AE  JUEGO DE ROL - TODOS LOS DERECHOS RESERVADOS");
		label.setBounds(456, 951, 466, 28);
		label.setForeground(SystemColor.windowBorder);
		contentPane.add(label);

		JLabel lblaceptar = new JLabel("");
		lblaceptar.setBounds(122, 788, 244, 55);
		contentPane.add(lblaceptar);

		JLabel lbllogo = new JLabel("");
		lbllogo.setBounds(57, 23, 376, 141);
		contentPane.add(lbllogo);

		JLabel lbleliminar = new JLabel("");
		lbleliminar.setBounds(122, 849, 244, 55);
		contentPane.add(lbleliminar);

		JLabel lblvolver = new JLabel("");
		lblvolver.setBounds(315, 721, 69, 55);
		contentPane.add(lblvolver);

		Image imgfondo = new ImageIcon(".\\images\\system\\fondo3.png").getImage();
		ImageIcon imgfondo1 = new ImageIcon(imgfondo.getScaledInstance(1300, 1100, Image.SCALE_SMOOTH));

		Image imgaceptar = new ImageIcon(".\\images\\system\\botonaceptar.png").getImage();
		ImageIcon imgaceptar2 = new ImageIcon(imgaceptar.getScaledInstance(240, 70, Image.SCALE_SMOOTH));
		lblaceptar.setIcon(imgaceptar2);

		Image imgeliminar = new ImageIcon(".\\images\\system\\botoneliminar.png").getImage();
		ImageIcon imgeliminar2 = new ImageIcon(imgeliminar.getScaledInstance(240, 70, Image.SCALE_SMOOTH));
		lbleliminar.setIcon(imgeliminar2);
		Image img = new ImageIcon(".\\images\\system\\titulo.png").getImage();
		ImageIcon img2 = new ImageIcon(img.getScaledInstance(370, 140, Image.SCALE_SMOOTH));
		lbllogo.setIcon(img2);

		Image imgmarco = new ImageIcon(".\\images\\system\\marcoprueba.png").getImage();
		ImageIcon imgmarco2 = new ImageIcon(imgmarco.getScaledInstance(300, 600, Image.SCALE_SMOOTH));

		JPanel panel = new JPanel();
		panel.setBounds(142, 242, 208, 105);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(142, 359, 208, 105);
		contentPane.add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(142, 476, 208, 105);
		contentPane.add(panel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(142, 593, 208, 105);
		contentPane.add(panel_3);

		JLabel lblmarco = new JLabel("");
		lblmarco.setBounds(90, 176, 300, 600);
		contentPane.add(lblmarco);
		lblmarco.setIcon(imgmarco2);

		JLabel lblfondo = new JLabel("");
		lblfondo.setBounds(0, 0, 1270, 991);
		contentPane.add(lblfondo);
		lblfondo.setIcon(imgfondo1);

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

			}
		});

		lblvolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				Image imgvolver = new ImageIcon(".\\images\\system\\flechavolver.png").getImage();
				ImageIcon imgv = new ImageIcon(imgvolver.getScaledInstance(45, 25, Image.SCALE_SMOOTH));
				lblvolver.setIcon(imgv);

				Reproductor.sonido("sonidoboton.mp3");
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				frame.dispose();
				frame.setVisible(false);
				Menu.frame.setVisible(true);

			}

			@Override
			public void mouseExited(MouseEvent e) {

				lblvolver.setIcon(null);
			}
		});

		lbleliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				Image imgaceptar = new ImageIcon(".\\images\\system\\botoneliminarencima.png").getImage();
				ImageIcon imgaceptar2 = new ImageIcon(imgaceptar.getScaledInstance(240, 70, Image.SCALE_SMOOTH));
				lbleliminar.setIcon(imgaceptar2);
				Reproductor.sonido(sonidoboton);

			}

			@Override
			public void mouseExited(MouseEvent e) {

				Image imgaceptar = new ImageIcon(".\\images\\system\\botoneliminar.png").getImage();
				ImageIcon imgaceptar2 = new ImageIcon(imgaceptar.getScaledInstance(240, 70, Image.SCALE_SMOOTH));
				lbleliminar.setIcon(imgaceptar2);
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				// BORRAR PERSONAJE

			}
			
			
			
		});
		
		 cargarPersonajes(idusuario);

	}

	public void cargarPersonajes(int idusuario) {

		ArrayList<ObjetoPersonaje> mispersonajes = new ArrayList<ObjetoPersonaje>();

		mispersonajes = Consultas.damePersonajes(idusuario);

		for (int i = 0; i < mispersonajes.size(); i++) {

		}

	}
}
