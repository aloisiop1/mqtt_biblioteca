package br.com.etecmam.bibloteca.mqttserver;

public class DadosMQTT {
	
	private String broker;
	private String clientId;
	private String usuario;
	private String senha;	
				
	public DadosMQTT(String broker, 
					 String clientId,
					 String usuario,
					 String senha ) {

		this.broker = broker;
		this.clientId = clientId;		
		this.usuario = usuario;
		this.senha = senha;		
	}

	
	public String getBroker() {
		return broker;
	}
	public void setBroker(String broker) {
		this.broker = broker;
	}	
	
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}


	@Override
	public String toString() {
		return "DadosMQTT [broker=" + broker + ", clientId=" + clientId
				+ ", usuario=" + usuario + ", senha="
				+ senha + "]";
	}
	
}
