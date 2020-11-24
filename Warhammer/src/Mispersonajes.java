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
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class Mispersonajes extends JFrame {

	private JPanel contentPane;
	public static Mispersonajes frame;
	public String sonidoboton;
	public JLabel personaje0, personaje1, personaje2, personaje3;
	public static int id = 0;

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

		id = idusuario;

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

		personaje0 = new JLabel("");
		personaje0.setForeground(new Color(0, 0, 0));
		personaje0.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 17));
		personaje0.setHorizontalAlignment(SwingConstants.LEFT);
		personaje0.setBounds(155, 241, 186, 80);
		contentPane.add(personaje0);

		personaje1 = new JLabel("");
		personaje1.setForeground(new Color(0, 0, 0));
		personaje1.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 17));
		personaje1.setHorizontalAlignment(SwingConstants.LEFT);
		personaje1.setBounds(155, 348, 186, 80);
		contentPane.add(personaje1);

		personaje2 = new JLabel("");
		personaje2.setForeground(new Color(0, 0, 0));
		personaje2.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 17));
		personaje2.setHorizontalAlignment(SwingConstants.LEFT);
		personaje2.setBounds(155, 472, 186, 80);
		contentPane.add(personaje2);

		personaje3 = new JLabel("");
		personaje3.setForeground(new Color(0, 0, 0));
		personaje3.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 17));
		personaje3.setHorizontalAlignment(SwingConstants.LEFT);
		personaje3.setBounds(155, 594, 186, 80);
		contentPane.add(personaje3);

		JLabel lblNewLabel = new JLabel("_____________________________");
		lblNewLabel.setBounds(145, 310, 233, 28);
		contentPane.add(lblNewLabel);

		JLabel label_1 = new JLabel("_____________________________");
		label_1.setBounds(145, 417, 233, 28);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("_____________________________");
		label_2.setBounds(145, 541, 233, 28);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("_____________________________");
		label_3.setBounds(145, 663, 233, 28);
		contentPane.add(label_3);

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

		Thread t = new Thread(new MiHilo());
		t.start();

	}

	public void cargarPersonajes(int idusuario) {

		String nombre, id, clase, raza;

		ArrayList<ObjetoPersonaje> mispersonajes = new ArrayList<ObjetoPersonaje>();

		mispersonajes = Consultas.damePersonajes(idusuario);
		
		for (int i = 0; i < mispersonajes.size(); i++) {

			nombre = mispersonajes.get(i).getNombre();

			clase = mispersonajes.get(i).getClase();

			raza = mispersonajes.get(i).getRaza();

			id = String.valueOf(mispersonajes.get(i).getIdpersonaje());

			switch (i) {
			
			case 0 :
				personaje0.setText("<html>" + nombre + "<br>" + clase + "<br>" + raza + "<br> Nivel: 17" + "</html>");
				break;
				
			case 1:
				personaje1.setText("<html>" + nombre + "<br>" + clase + "<br>" + raza + "<br> Nivel: 26" + "</html>");
				break;
			case 2:
				personaje2.setText("<html>" + nombre + "<br>" + clase + "<br>" + raza + "</html>");
				break;
			case 3:
				personaje3.setText("<html>" + nombre + "<br>" + clase + "<br>" + raza + "</html>");
				break;
			}
		}

	}

	public class MiHilo extends Thread {

		public void run()

		{

			while (true) {
				try {
					Thread.sleep(200);
					cargarPersonajes(id);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
