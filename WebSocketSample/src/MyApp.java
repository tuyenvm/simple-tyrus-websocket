import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.glassfish.tyrus.server.Server;


public class MyApp {

	public static void main(String[] args) {
		Server server = new Server("127.0.0.1", 40000, "/websocket", null, MyEndPoint.class);
		
	    try {
	        server.start();
	        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	       
	        while (true) {
	        	System.out.println("Type -q to terminate server...");
	        	String cmd = reader.readLine();
	        	if (cmd.equals("-q"))
	        		break;
	        }
	
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        server.stop();
	    }

	}

}
