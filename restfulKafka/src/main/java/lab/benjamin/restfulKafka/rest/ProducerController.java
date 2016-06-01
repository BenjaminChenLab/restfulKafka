package lab.benjamin.restfulKafka.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lab.benjamin.restfulKafka.kafkaApi.Producer;
import lab.benjamin.restfulKafka.rest.model.ProduceMessage;
import lab.benjamin.restfulKafka.rest.model.ProduceResult;
import lombok.Setter;

@RestController
public class ProducerController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	@Setter
	private Producer producer;

	/**
	 * to send a message to Kafka topic
	 * @param topic
	 * @param message
	 * @return
	 */
	@RequestMapping(value = "/produce/{topic}", method = RequestMethod.PUT)
	public ProduceResult produce(@PathVariable String topic, @RequestBody ProduceMessage message) {
		// TODO: validation
		ProduceResult result =new ProduceResult();
		log.debug(message.toString());
		try {
			producer.produce(topic, message.getMessageValues());
			
			result.setStatus(ProduceResult.SUCCESS);
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			result.setStatus(ProduceResult.ERROR);
		}
		return result;
	}
}
