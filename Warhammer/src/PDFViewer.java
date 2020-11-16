import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class PDFViewer {

	    public static void leer() throws Exception {
	    	
	        if (Desktop.isDesktopSupported()) {
	            // File in user working directory, System.getProperty("user.dir");
	            File file = new File("ficha.pdf");
	            if (!file.exists()) {
	                // In JAR
	                InputStream inputStream = ClassLoader.getSystemClassLoader()
	                                    .getResourceAsStream("pdf/ficha.pdf");
	                // Copy file
	                OutputStream outputStream = new FileOutputStream(file);
	                byte[] buffer = new byte[1024];
	                int length;
	                while ((length = inputStream.read(buffer)) > 0) {
	                    outputStream.write(buffer, 0, length);
	                }
	                outputStream.close();
	                inputStream.close();
	            }
	            // Open file
	            Desktop.getDesktop().open(file);
	        }
	    }
	}


