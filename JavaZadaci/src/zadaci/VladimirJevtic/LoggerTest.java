package zadaci.VladimirJevtic;
import org.apache.log4j.*;

public class LoggerTest {
	
	private static final Logger Log = Logger.getLogger(LoggerTest.class);
	
	public static void main(String[] args ) {
		
		Log.info(" Provera Loggera" );
		Log.debug("Poruka");
		Log.error("A");
	}

}
