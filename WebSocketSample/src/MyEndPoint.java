import java.io.IOException;
import java.nio.ByteBuffer;

import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


@ServerEndpoint(
		value="/sample",
		encoders = {},
		decoders = {})
public class MyEndPoint extends Endpoint {

	@OnOpen
	public void onOpen(Session session, EndpointConfig config) {
		// TODO Auto-generated method stub
		
	}
	
	@OnMessage
	public void onMessage(String message, Session session) {
		try {
			session.getBasicRemote().sendText("Hello " + message + ", this message is sent from Server");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@OnMessage
	public void onMessage(byte[] bytes, Session session) {
		try {
			ByteBuffer buff = ByteBuffer.allocate(bytes.length);
			buff.put(bytes);
			buff.rewind();
			session.getBasicRemote().sendBinary(buff);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
