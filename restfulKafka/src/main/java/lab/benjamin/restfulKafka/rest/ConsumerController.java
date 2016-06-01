package lab.benjamin.restfulKafka.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lab.benjamin.restfulKafka.kafkaApi.Consumer;
import lab.benjamin.restfulKafka.rest.model.ConsumeMessage;
import lab.benjamin.restfulKafka.rest.model.ConsumeQuery;
import lombok.Setter;

@RestController
public class ConsumerController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	@Setter
	private Consumer consumer;

	@RequestMapping(value = "/seek/{groupId}/{offset}", method = RequestMethod.PUT)
	public ConsumeMessage seekByOffset(@PathVariable String groupId, @PathVariable Long offset,
			@RequestBody ConsumeQuery query) {
		// TODO: validation
		ConsumeMessage result = new ConsumeMessage();
		try {
			String value = consumer.consumeByOffset(groupId, query.getSubscribeTopics(), offset);
			result.setMessage(value);
			result.setStatus(ConsumeMessage.SUCCESS);
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			// TODO: 1.need better error handling
			result.setStatus(ConsumeMessage.ERROR);
		}
		return result;
	}
}
