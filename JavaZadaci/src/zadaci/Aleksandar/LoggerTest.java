package zadaci.Aleksandar;

import org.apache.log4j.*;

public class LoggerTest 
{

	private static final Logger logger = Logger.getLogger(LoggerTest.class);
	
	public static void main(String[] args)
	{
		
		LoggerTest logger = new LoggerTest();
		logger.pokreni("Provera");

	}
	
	private void pokreni(String poruka) 
	{
		if(logger.isDebugEnabled()){
			logger.debug("Ovo je debug : " + poruka);
		}

		if(logger.isInfoEnabled()){
			logger.info("Ovo je info : " + poruka);
		}

		logger.warn("Ovo je warn : " + poruka);
		logger.error("ovo je error : " + poruka);
		logger.fatal("Ovo je fatal : " + poruka);
	}

}
