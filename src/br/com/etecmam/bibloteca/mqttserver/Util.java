package br.com.etecmam.bibloteca.mqttserver;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Util {
	
	static DadosMQTT dadosMQTT;
	
	static {

		dadosMQTT = new DadosMQTT("tcp://127.0.0.1:8888", "biblioMQTT", "server", "123456");
		
	}
	
		
	
	public static DadosMQTT getDadosMQTT() {
		return dadosMQTT;
	}

	

	public static String getDateTime(ZoneId zoneId, String formatoData) {

		String dataHora = Util.getDateString(Instant.now().toEpochMilli(),
											DateTimeFormatter.ofPattern(formatoData),
											zoneId);

		return dataHora;

	}
	
	public static String getDateString(long milli, DateTimeFormatter formatter,
			ZoneId zone) {

		Instant instant = Instant.ofEpochMilli(milli);
		ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant, zone);
		String strDate = zonedDateTime.format(formatter);

		return strDate;
	}

}
