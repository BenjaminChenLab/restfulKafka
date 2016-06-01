package lab.benjamin.restfulKafka;

import org.springframework.stereotype.Component;
/**
 * todo: use external configuration file and with environment sensitivity
 * @author Benjamin Chen
 *
 */
@Component("env")
public class Env {
	public String kafkaLocation=System.getProperty("RESTFULKAFKA_KAFKA_HOST_NAME");
	public String kafkaPort=System.getProperty("RESTFULKAFKA_KAFKA_PORT");
	
	public String getKafkaUrl(){
		return kafkaLocation+":"+kafkaPort;
	}
}
