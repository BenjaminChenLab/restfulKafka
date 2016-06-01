package lab.benjamin.restfulKafka.rest.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * to reply the result of producing
 * @author Benjamin Chen
 *
 */
@Data
public class ProduceResult  implements Serializable{
	@JsonIgnore
	public static final String SUCCESS = "sent";
	@JsonIgnore
	public static final String ERROR = "err";
	/**
	 * the result of producing
	 */
	private String status;
	/**
	 * the message about the error ,if it happens
	 */
	private String errMsg;
}
