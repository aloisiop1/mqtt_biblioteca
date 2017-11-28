package br.com.etecmam.bibloteca.mqttserver.api;

import org.eclipse.paho.client.mqttv3.MqttMessage;

import br.com.etecmam.bibloteca.mqttserver.MQTTDispatcher;
import br.com.etecmam.bibloteca.pst.LivroPST;

public class ProcessaLivrosPorGenero implements IProcessaMQTT {

	@SuppressWarnings("unused")
	private MQTTDispatcher dispatcher;

	public ProcessaLivrosPorGenero(MQTTDispatcher dispatcher) {
		this.dispatcher = dispatcher;		
	}

	@Override
	public void processaPedido(String topico, MqttMessage mensagem) {
		
		String[] dados = topico.split("/");
		
		new LivroPST().getlivrosPorCategoria(dados[0]);
		
		
		
	}

}
