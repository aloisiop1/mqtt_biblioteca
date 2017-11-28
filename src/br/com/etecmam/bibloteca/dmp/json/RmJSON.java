package br.com.etecmam.bibloteca.dmp.json;

import com.google.gson.annotations.SerializedName;

import br.com.etecmam.bibloteca.mqttserver.IEnviavel;

public class RmJSON implements IEnviavel {
	
	@SerializedName("rm")
	private int rm;
	
	
	public RmJSON(int rm) {
		this.rm = rm;
	}
	
	public int getRm() {
		return rm;
	}

	public void setRm(int rm) {
		this.rm = rm;
	}

}
