package lab.benjamin.restfulKafka;

import org.springframework.stereotype.Component;
/**
 * todo: use external configuration file and with environment sensitive 
 * @author Benjamin Chen
 *
 */
@Component("env")
public class Env {
	public String kafkaLocation="192.168.144.135";
	public String kafkaPort="9092";
	
	public String getKafkaUrl(){
		return kafkaLocation+":"+kafkaPort;
	}
}
