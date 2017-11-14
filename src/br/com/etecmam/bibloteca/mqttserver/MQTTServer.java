package br.com.etecmam.bibloteca.mqttserver;

public class MQTTServer {
	
	public static void main(String[] args) throws InterruptedException {
		
		MQTTDispatcher dispatcher = new MQTTDispatcher();
		
		Thread thread = new Thread(dispatcher);
		
		thread.start();
		
		Thread.sleep(3000);
		
		dispatcher.getFilaMQTT().add( new MqttJSON("biblio", "{MSG}") );
		
		
	}

}
