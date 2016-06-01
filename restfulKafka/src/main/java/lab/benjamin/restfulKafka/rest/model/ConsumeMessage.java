package lab.benjamin.restfulKafka.rest.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class ConsumeMessage implements Serializable {
	@JsonIgnore
	public static final String SUCCESS="scd";
	@JsonIgnore
	public static final String ERROR="err";
	/**
	 * the result of producing
	 */
	private String status;
	/**
	 * the message about the error ,if it happens
	 */
	private String errMmsg;
	
	private String message;
}
