package lab.benjamin.restfulKafka.rest.model;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * consumer parameters
 * @author Benjamin Chen
 *
 */
@Data
public class ConsumeQuery implements Serializable{
	private String groupId;
	private Long offset;
	private List<String> subscribeTopics;
}
