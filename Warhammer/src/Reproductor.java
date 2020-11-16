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
   
   
}