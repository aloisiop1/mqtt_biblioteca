package br.com.etecmam.bibloteca.mqttserver.api;

import org.eclipse.paho.client.mqttv3.MqttMessage;

public interface IProcessaMQTT {
	void processaPedido(String topico, MqttMessage mensagem);
	
}
