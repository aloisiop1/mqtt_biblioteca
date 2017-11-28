package br.com.etecmam.bibloteca.mqttserver;

import java.time.ZoneId;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MqttReceiver implements MqttCallback {

	private String topico;
	private int id;

	public String getTopico() {
		return topico;
	}

	public void setTopico(String topico) {
		this.topico = topico;
	}

	public MqttReceiver(int id, String topico) {
		this.id = id;
		this.topico = topico;

	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static void main(String[] args) throws InterruptedException {

		try {

			MqttReceiver receiver = new MqttReceiver(1, "broker/generos");
			
			DadosMQTT dadosMQTT = Util.getDadosMQTT();
			
			dadosMQTT.setClientId(dadosMQTT.getClientId() + receiver.getId() );
			
			/////////

			MemoryPersistence persistence = new MemoryPersistence();
			MqttAsyncClient cliente = null;

			System.out.println(Util.getDadosMQTT());
			
			cliente = new MqttAsyncClient(dadosMQTT.getBroker(), dadosMQTT.getClientId() , persistence);

			cliente.setCallback(receiver);

			MqttConnectOptions options = new MqttConnectOptions();

			cliente.connect(options);
			
			Thread.sleep(3000);
			
			cliente.subscribe(receiver.getTopico() , 0);
			
			System.out.println("----------------------------------------------------------------------------------------");
			System.out.println("OUVINDO TÓPICO " + receiver.getTopico() );
			System.out.println("----------------------------------------------------------------------------------------");
			

		} catch (MqttException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void connectionLost(Throwable cause) {
		
		System.out.println(cause.toString() );

	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		
		System.out.println("# MENSAGEM RECEBIDA");
		
		System.out.println(topic + " " + message.toString()  + " " + Util.getDateTime(ZoneId.of("America/Sao_Paulo"), "MM/dd/yyyy HH:mm:ss") );

	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {


	}

}
