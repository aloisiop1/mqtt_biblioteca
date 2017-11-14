package br.com.etecmam.bibloteca.mqttserver;

import com.google.gson.Gson;

public interface IEnviavel {
			
	default String toJson() {		
		return new Gson().toJson(this);
	}
}
