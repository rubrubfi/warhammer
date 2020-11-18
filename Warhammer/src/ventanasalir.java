import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ventanasalir extends JFrame {

	private JPanel contentPane;
	public static ventanasalir frame;
	
	/**
	 * Launch the application.
	 */
	public static void salir() {
		
		
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
					frame = new ventanasalir();
					
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					ImageIcon img = new ImageIcon(".\\images\\icono.png");
					frame.setIconImage(img.getImage());
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	public ventanasalir() {
		setTitle("WARHAMMER - EL JUEGO DE ROL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblaceptar = new JLabel("");
		lblaceptar.setBounds(45, 202, 207, 59);
		contentPane.add(lblaceptar);

		JLabel lblsalir = new JLabel("");
		lblsalir.setBounds(253, 202, 112, 59);
		contentPane.add(lblsalir);

		JLabel lblNewLabel = new JLabel("<html> <center>\u00A1ATENCI\u00D3N \u00A1 </center><br><center>Se va a cerrar el juego. </center><br><center>\u00BFSeguro que quieres salir ?</center></html>");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Eras Light ITC", Font.BOLD, 20));
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setBounds(45, 52, 323, 138);
		contentPane.add(lblNewLabel);

		JLabel lblfondo = new JLabel("");
		lblfondo.setFont(new Font("Myanmar Text", Font.PLAIN, 12));
		lblfondo.setBounds(-20, -60, 450, 445);
		contentPane.add(lblfondo);

		Image imgaceptar = new ImageIcon(".\\images\\botonaceptar.png").getImage();
		ImageIcon imgaceptar2 = new ImageIcon(imgaceptar.getScaledInstance(200, 60, Image.SCALE_SMOOTH));
		lblaceptar.setIcon(imgaceptar2);

		Image imgtest = new ImageIcon(".\\images\\botonvolverprueba.png").getImage();
		ImageIcon imgtest2 = new ImageIcon(imgtest.getScaledInstance(100, 70, Image.SCALE_SMOOTH));
		lblsalir.setIcon(imgtest2);

		Image imgventana = new ImageIcon(".\\images\\ventana-vacia.png").getImage();
		ImageIcon imgventana2 = new ImageIcon(imgventana.getScaledInstance(460,340,Image.SCALE_SMOOTH));
		lblfondo.setIcon(imgventana2);
		
		lblaceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				Image imgaceptar = new ImageIcon(".\\images\\botonaceptarencima.png").getImage();
				ImageIcon imgaceptar2 = new ImageIcon(imgaceptar.getScaledInstance(200, 60, Image.SCALE_SMOOTH));
				lblaceptar.setIcon(imgaceptar2);
				Reproductor.sonido("sonidoboton.mp3");

			}

			@Override
			public void mouseExited(MouseEvent e) {

				Image imgaceptar = new ImageIcon(".\\images\\botonaceptar.png").getImage();
				ImageIcon imgaceptar2 = new ImageIcon(imgaceptar.getScaledInstance(200, 60, Image.SCALE_SMOOTH));
				lblaceptar.setIcon(imgaceptar2);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// COMPROBACIÓN DE LOGIN 
				
				System.exit(0);
				
			}
		});
		
		lblsalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				Image imgvolver = new ImageIcon(".\\images\\botonvolverpruebaencima.png").getImage();
				ImageIcon imgv = new ImageIcon(imgvolver.getScaledInstance(100, 70, Image.SCALE_SMOOTH));
				lblsalir.setIcon(imgv);

				Reproductor.sonido("sonidoboton.mp3");
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				
				

				frame.dispose();		

				
			}

			@Override
			public void mouseExited(MouseEvent e) {

				Image imgvolver = new ImageIcon(".\\images\\botonvolverprueba.png").getImage();
				ImageIcon imgv = new ImageIcon(imgvolver.getScaledInstance(100, 70, Image.SCALE_SMOOTH));
				lblsalir.setIcon(imgv);
			}
		});

	}

	
	
}
