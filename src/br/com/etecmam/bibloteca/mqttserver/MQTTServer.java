package br.com.etecmam.bibloteca.mqttserver;

import br.com.etecmam.bibloteca.mqttserver.api.ProcessaGeneros;

public class MQTTServer {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws InterruptedException {
		
		MQTTDispatcher dispatcher = new MQTTDispatcher();		
		Thread thread = new Thread(dispatcher);		
		thread.start();
		
		
		MqttReceiver receiver = new MqttReceiver(1, "broker/generos", new ProcessaGeneros( dispatcher) );
		
		
//		
//		Thread.sleep(3000);
//		
//		dispatcher.getFilaMQTT().add( new MqttJSON("biblio", "{MSG}") );
		
		
	}

}
