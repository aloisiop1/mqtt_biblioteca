package br.com.etecmam.bibloteca.mqttserver;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MQTTDispatcher implements Runnable {
	
	private List<MqttJSON> filaMQTT;
	private MqttAsyncClient clienteMQTT = null;	
	private  boolean rodar = true;
	
	public MQTTDispatcher() {		
		filaMQTT = new ArrayList<MqttJSON>();
	}
	
	@Override
	public void run() {


		System.out.println("rodar " + rodar);
		
		while(rodar){

			try {
				
				System.out.println("BIBLIOTECA  - MQTT DISPATCHER - INICIALIZANDO " + 
						Util.getDateTime(ZoneId.of("America/Sao_Paulo"), "dd/MM/yyyy HH:mm:ss") );
				System.out.println("-----------------------------------------------------------------------------------------");
				
				clienteMQTT = criarClienteMQTT();								


				while(rodar){


					if( filaMQTT.size() > 0 ){

						MqttJSON msg = filaMQTT.get(0);						

						System.out.println("MQTT DISPATCHER - publicando " + msg.getTopico() + 
								" " + msg.getMensagem() + " " + 
								Util.getDateTime(ZoneId.of("America/Sao_Paulo"), "dd/MM/yyyy HH:mm:ss") );

						MqttMessage message = new MqttMessage( msg.getMensagem().getBytes() );
						message.setQos(2); //qos - qualidade do servico						

						clienteMQTT.publish( msg.getTopico() , message );						

						Thread.sleep(100);
						this.filaMQTT.remove(0);

					}else{

						Thread.sleep(1000);
					}

				}

			} catch (MqttException me) {

				System.out.println("reason " + me.getReasonCode());
				System.out.println("msg " + me.getMessage());
				System.out.println("loc " + me.getLocalizedMessage());
				System.out.println("cause " + me.getCause());
				System.out.println("excep " + me);

				me.printStackTrace();



			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			// caso chegou aqui deve reiniciar
			
			if( ! clienteMQTT.isConnected() ){
				
				
				System.out.println("MQTT DISPATCHER - NAO CONSEGUIU CONECTAR-SE AO BROKER " + 
								   Util.getDadosMQTT().getBroker()  + " " + 
								   Util.getDateTime(ZoneId.of("America/Sao_Paulo"), "dd/MM/yyyy HH:mm:ss") );
				System.out.println("-----------------------------------------------------------------------------------------");
				try {
					Thread.sleep(10000);
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}

	}


	private MqttAsyncClient criarClienteMQTT() 
			throws MqttSecurityException, MqttException, InterruptedException {
						
		MemoryPersistence persistence = new MemoryPersistence();
		MqttAsyncClient cliente = null;

		System.out.println(Util.getDadosMQTT() );
		

		cliente = new MqttAsyncClient(Util.getDadosMQTT().getBroker(),
				Util.getDadosMQTT().getClientId(), 
				persistence);

		MqttConnectOptions connOpts = new MqttConnectOptions();

		connOpts.setCleanSession(true);
		connOpts.setUserName( Util.getDadosMQTT().getUsuario() );
		connOpts.setPassword( Util.getDadosMQTT().getSenha().toCharArray() );
		
		connOpts.setConnectionTimeout(10);

		System.out.println("MQTT DISPATCHER - CONECTANDO AO BROKER : " + 
				Util.getDadosMQTT().getBroker() + " " + 
				Util.getDateTime(ZoneId.of("America/Sao_Paulo"), "dd/MM/yyyy HH:mm:ss") );
		System.out.println("-----------------------------------------------------------------------------------------");

		cliente.connect(connOpts);				
		Thread.sleep(1000);

		System.out.println("MQTT DISPATCHER - CONECTADO " + 
				Util.getDateTime(ZoneId.of("America/Sao_Paulo"), "dd/MM/yyyy HH:mm:ss") );				
		System.out.println("-----------------------------------------------------------------------------------------");

		return cliente;

	}


	public synchronized List<MqttJSON> getFilaMQTT() {
		return filaMQTT;
	}

	public synchronized void setFilaMQTT(List<MqttJSON> filaMQTT) {
		this.filaMQTT = filaMQTT;
	}

	public synchronized boolean isRodar() {
		return rodar;
	}

	public synchronized void setRodar(boolean rodar) {
		this.rodar = rodar;
	}		
	

}
