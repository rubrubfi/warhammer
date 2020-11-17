import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Reproductor {

	static  Player apl;
	
	
   public static void reproduce(String archivo) throws FileNotFoundException,
         JavaLayerException {

      apl = new Player(new FileInputStream(
            ".\\music\\" + archivo));
      apl.play();
      
   }
   
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