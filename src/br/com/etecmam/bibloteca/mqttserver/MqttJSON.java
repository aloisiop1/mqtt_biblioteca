package br.com.etecmam.bibloteca.mqttserver;

import java.time.LocalDateTime;
import com.google.gson.annotations.SerializedName;

public class MqttJSON implements IEnviavel{
			
	@SerializedName("topico")
	private String topico;
	
	@SerializedName("mensagem")
	private String mensagem;
	
	
	public MqttJSON(String topico, String mensagem) {
		this.topico = topico;
		this.mensagem = mensagem;
	}	
	
	public String getTopico() {
		return topico;
	}
	public void setTopico(String topico) {
		this.topico = topico;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
	public static void main(String[] args) {
		System.out.println(new MqttJSON("mqtt/teste", LocalDateTime.now().toString() ).toJson());
	}

}

