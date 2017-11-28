package br.com.etecmam.bibloteca.mqttserver.api;

import java.util.List;

import org.eclipse.paho.client.mqttv3.MqttMessage;

import com.google.gson.Gson;

import br.com.etecmam.bibloteca.dmp.json.GenerosJSON;
import br.com.etecmam.bibloteca.dmp.json.RmJSON;
import br.com.etecmam.bibloteca.mqttserver.MQTTDispatcher;
import br.com.etecmam.bibloteca.mqttserver.MqttJSON;
import br.com.etecmam.bibloteca.pst.LivroPST;

public class ProcessaGeneros implements IProcessaMQTT {
	
	@SuppressWarnings("unused")
	private MQTTDispatcher dispatcher = null;
		
	public ProcessaGeneros( MQTTDispatcher dispatcher ) {
		this.dispatcher = dispatcher;	
	}

	@Override
	public void processaPedido(String topico, MqttMessage mensagem) {	
		
		System.out.println("processaPedido " + topico + " " + mensagem.toString() );
				
		RmJSON rm = new Gson().fromJson(mensagem.toString() , RmJSON.class);
		
		List<String> listaDeGeneros = new LivroPST().getListaDeGeneros();
		
		GenerosJSON respostaJSON = new GenerosJSON(listaDeGeneros);			
		
		dispatcher.getFilaMQTT().add(  new MqttJSON("broker/generos/" + rm.getRm() , respostaJSON.toJson() ) );
	
	}

}
