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

public class Ventanasalir extends JFrame {

	private JPanel contentPane;
	public static Ventanasalir frame;
	
	/**
	 * Launch the application.
	 */
	public static void salir(JFrame padre) {		
		
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
					frame = new Ventanasalir(padre);
					
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					ImageIcon img = new ImageIcon(".\\images\\system\\icono.png");
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
	public Ventanasalir(JFrame padre) {
		setTitle("WARHAMMER - EL JUEGO DE ROL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSi = new JLabel("");
		lblSi.setBounds(90, 202, 112, 59);
		contentPane.add(lblSi);

		JLabel lblNo = new JLabel("");
		lblNo.setBounds(215, 202, 112, 59);
		contentPane.add(lblNo);

		JLabel lblNewLabel = new JLabel("<html> <center>\u00A1 ATENCI\u00D3N \u00A1 </center><br><center>Se va a cerrar el juego. \u00BFSeguro que quieres salir ?</center></html>");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Footlight MT Light", Font.PLAIN, 23));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(76, 52, 257, 138);
		contentPane.add(lblNewLabel);

		JLabel lblfondo = new JLabel("");
		lblfondo.setFont(new Font("Myanmar Text", Font.PLAIN, 12));
		lblfondo.setBounds(-20, -60, 450, 445);
		contentPane.add(lblfondo);

		Image imgaceptar = new ImageIcon(".\\images\\system\\botonSi.png").getImage();
		ImageIcon imgaceptar2 = new ImageIcon(imgaceptar.getScaledInstance(100, 70, Image.SCALE_SMOOTH));
		lblSi.setIcon(imgaceptar2);

		Image imgtest = new ImageIcon(".\\images\\system\\botonNo.png").getImage();
		ImageIcon imgtest2 = new ImageIcon(imgtest.getScaledInstance(100, 70, Image.SCALE_SMOOTH));
		lblNo.setIcon(imgtest2);

		Image imgventana = new ImageIcon(".\\images\\system\\ventana-vacia.png").getImage();
		ImageIcon imgventana2 = new ImageIcon(imgventana.getScaledInstance(460,340,Image.SCALE_SMOOTH));
		lblfondo.setIcon(imgventana2);
		
		lblSi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				Image imgaceptar = new ImageIcon(".\\images\\system\\botonSiencima.png").getImage();
				ImageIcon imgaceptar2 = new ImageIcon(imgaceptar.getScaledInstance(100, 70, Image.SCALE_SMOOTH));
				lblSi.setIcon(imgaceptar2);
				Reproductor.sonido("sonidoboton.mp3");

			}

			@Override
			public void mouseExited(MouseEvent e) {

				Image imgaceptar = new ImageIcon(".\\images\\system\\botonSi.png").getImage();
				ImageIcon imgaceptar2 = new ImageIcon(imgaceptar.getScaledInstance(100, 70, Image.SCALE_SMOOTH));
				lblSi.setIcon(imgaceptar2);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// COMPROBACIÓN DE LOGIN 
				
				System.exit(0);
				
			}
		});
		
		lblNo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				Image imgvolver = new ImageIcon(".\\images\\system\\botonNoencima.png").getImage();
				ImageIcon imgv = new ImageIcon(imgvolver.getScaledInstance(100, 70, Image.SCALE_SMOOTH));
				lblNo.setIcon(imgv);

				Reproductor.sonido("sonidoboton.mp3");
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				frame.dispose();		
				
				padre.enable();
				padre.toFront();
				padre.requestFocus();
				
			}

			@Override
			public void mouseExited(MouseEvent e) {

				Image imgvolver = new ImageIcon(".\\images\\system\\botonNo.png").getImage();
				ImageIcon imgv = new ImageIcon(imgvolver.getScaledInstance(100, 70, Image.SCALE_SMOOTH));
				lblNo.setIcon(imgv);
			}
		});

	}

	
	
}
