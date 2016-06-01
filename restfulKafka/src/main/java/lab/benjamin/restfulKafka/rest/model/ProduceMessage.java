package lab.benjamin.restfulKafka.rest.model;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * message to produce
 * 
 * @author Benjamin Chen
 *
 */
@Data
public class ProduceMessage implements Serializable {
	private String topic;
	private List<String> messageValues;
	/**
	 * optional, for partition balance
	 */
	private String balanceKey;
	
}
