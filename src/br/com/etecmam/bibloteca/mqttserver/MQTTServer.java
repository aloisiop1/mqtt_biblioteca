package br.com.etecmam.bibloteca.mqttserver;

import br.com.etecmam.bibloteca.mqttserver.api.ProcessaGeneros;
import br.com.etecmam.bibloteca.mqttserver.api.ProcessaLivrosPorGenero;

public class MQTTServer {
	
	public MQTTServer() {	
		iniciar();
	}
	
	@SuppressWarnings("unused")
	private void iniciar(){
	
		MQTTDispatcher dispatcher = new MQTTDispatcher();		
		Thread thread = new Thread(dispatcher);		
		thread.start();
		
		MqttReceiver recGeneros = new MqttReceiver(1, "ObsGeneroLivro", "broker/generos",  new ProcessaGeneros( dispatcher) );		
		MqttReceiver recLivrosPorGenero = new MqttReceiver(1, "ObsLivrosPorGenero", "broker/livros-do-genero/#",  new ProcessaLivrosPorGenero( dispatcher) );

	}
	
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws InterruptedException {
		
		
		new MQTTServer();
	
				
	}

}
