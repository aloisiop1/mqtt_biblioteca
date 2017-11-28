package br.com.etecmam.bibloteca.mqttserver.api;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.paho.client.mqttv3.MqttMessage;

import com.google.gson.Gson;

import br.com.etecmam.bibloteca.dmp.Livro;
import br.com.etecmam.bibloteca.dmp.json.LivroJSON;
import br.com.etecmam.bibloteca.dmp.json.RmJSON;
import br.com.etecmam.bibloteca.mqttserver.MQTTDispatcher;
import br.com.etecmam.bibloteca.mqttserver.MqttJSON;
import br.com.etecmam.bibloteca.pst.ListaDeLivrosJSON;
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
		
		RmJSON rm = new Gson().fromJson(mensagem.toString() , RmJSON.class);
		
		List<Livro> livros = new LivroPST().getlivrosPorCategoria( dados[2] );
		
		List<LivroJSON> listaJSON = new ArrayList<LivroJSON>();
		
		for (Livro livro : livros) {			
			listaJSON.add( new LivroJSON(livro) );	
		}
		ListaDeLivrosJSON respostaJSON = new ListaDeLivrosJSON(listaJSON);

		dispatcher.getFilaMQTT().add(  new MqttJSON("broker/resp-livros-do-genero/" + rm.getRm() , respostaJSON.toJson() ) );
		
		
	}

}
