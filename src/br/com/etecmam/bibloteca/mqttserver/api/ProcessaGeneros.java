package br.com.etecmam.bibloteca.mqttserver.api;

import org.eclipse.paho.client.mqttv3.MqttMessage;

import br.com.etecmam.bibloteca.mqttserver.MQTTDispatcher;

public class ProcessaGeneros implements IProcessaMQTT {
	
	@SuppressWarnings("unused")
	private MQTTDispatcher dispatcher = null;
		
	public ProcessaGeneros( MQTTDispatcher dispatcher ) {
		this.dispatcher = dispatcher;	
	}

	@Override
	public void processaPedido(String topico, MqttMessage mensagem) {

		
		System.out.println("processaPedido " + topico + " " + mensagem.toString() );
		
//		dispatcher.getFilaMQTT().add( new MqttJSON(topico, mensagem.toString()) );
		
	}

}
