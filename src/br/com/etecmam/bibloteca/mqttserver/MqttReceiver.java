package br.com.etecmam.bibloteca.mqttserver;

import java.time.ZoneId;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import br.com.etecmam.bibloteca.mqttserver.api.IProcessaMQTT;

public class MqttReceiver implements MqttCallback {
	
	private IProcessaMQTT processaMQTT = null;

	private int id;
	@SuppressWarnings("unused")
	private String clienteID;
	private String topico;

	public String getTopico() {
		return topico;
	}

	public void setTopico(String topico) {
		this.topico = topico;
	}

	public MqttReceiver(int id, String clienteID, String topico, IProcessaMQTT processaMQTT) {		
		this.id = id;
		this.clienteID = clienteID;
		this.topico = topico;
		this.processaMQTT = processaMQTT;
		
		try {

			MemoryPersistence persistence = new MemoryPersistence();
			MqttAsyncClient cliente = null;

			System.out.println(Util.getDadosMQTT());
			
			cliente = new MqttAsyncClient(Util.getDadosMQTT().getBroker(), clienteID, persistence);

			cliente.setCallback(this);

			MqttConnectOptions connOpts = new MqttConnectOptions();
			

			connOpts.setCleanSession(true);
			connOpts.setUserName( Util.getDadosMQTT().getUsuario() );
			connOpts.setPassword( Util.getDadosMQTT().getSenha().toCharArray() );
			
			connOpts.setConnectionTimeout(10);

			cliente.connect(connOpts);		
			
					
			Thread.sleep(3000);
			
			cliente.subscribe(this.getTopico() , 0);
			
			System.out.println("-------------------------------------------------------------------------------------------");
			System.out.println("OUVINDO TÓPICO: " + this.getTopico()  + " " + Util.getDateTime(ZoneId.of("America/Sao_Paulo"), "MM/dd/yyyy HH:mm:ss")  );
			System.out.println("-------------------------------------------------------------------------------------------");
			

		} catch (MqttException | InterruptedException e) {
			e.printStackTrace();
		}		
		
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public void connectionLost(Throwable cause) {
		
		System.out.println(cause.toString() );

	}

	@Override
	public void messageArrived(String topico, MqttMessage mensagem) throws Exception {
		
		System.out.println("# MENSAGEM RECEBIDA");		
		System.out.println(topico + " " + mensagem.toString()  + " " + Util.getDateTime(ZoneId.of("America/Sao_Paulo"), "MM/dd/yyyy HH:mm:ss") );
		
		processaMQTT.processaPedido(topico, mensagem);
		
		
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {


	}

}
