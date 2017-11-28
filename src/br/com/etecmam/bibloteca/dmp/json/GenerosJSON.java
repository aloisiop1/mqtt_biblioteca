package br.com.etecmam.bibloteca.dmp.json;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.mysql.fabric.xmlrpc.base.Array;

import br.com.etecmam.bibloteca.mqttserver.IEnviavel;

public class GenerosJSON implements IEnviavel {
	
	@SerializedName("generos")
	List<String> generos;
		
	public GenerosJSON() {
	}

	public GenerosJSON(List<String> generos) {
		super();
		this.generos = generos;
	}

	public List<String> getGeneros() {
		return generos;
	}

	public void setGeneros(List<String> generos) {
		this.generos = generos;
	}
	
	
//	public static void main(String[] args) {
//		
//		List<String> lista = Arrays.asList("Informática", "Enfermagem", "Literatura Juvenil");
//		
//		System.out.println( new GenerosJSON(lista).toJson() );		
//		
//	}


}
