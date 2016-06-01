package lab.benjamin.restfulKafka.kafkaApi;

import java.util.List;

/**
 * 
 * @author Benjamin Chen
 *
 */
public interface Producer {

	public void produce(String topic, List<String> values);

}
