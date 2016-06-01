package lab.benjamin.restfulKafka.kafkaApi;

import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab.benjamin.restfulKafka.settings.KafkaSettings;
import lombok.Setter;

@Service
public class ProducerImpl implements lab.benjamin.restfulKafka.kafkaApi.Producer {
	private final Logger log=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	@Setter
	private KafkaSettings kafkaSettings;

	@Override
	public void produce(String topic, List<String> values ) {
		Properties props = kafkaSettings.getDefaultProducerProps();

		Producer<String, String> producer = new KafkaProducer<>(props);
		try{
			for (String value:values)
				producer.send(new ProducerRecord<String, String>(topic,"1",value));			
		}finally{
			producer.close();
		}
	}
	
}
