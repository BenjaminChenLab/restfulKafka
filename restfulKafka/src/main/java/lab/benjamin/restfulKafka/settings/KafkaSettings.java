package lab.benjamin.restfulKafka.settings;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lab.benjamin.restfulKafka.Env;
import lombok.Setter;

@Component
public class KafkaSettings {
	@Autowired
	@Setter
	private Env env;
	
	public final Long CONSUMING_POLL_DURATION=1000L;
	
	public Properties getDefaultProducerProps() {
		Properties props = new Properties();
		props.put("bootstrap.servers", env.getKafkaUrl());
		props.put("acks", "all");
		props.put("retries", 0);
		props.put("batch.size", 16384);
		props.put("linger.ms", 1);
		props.put("buffer.memory", 33554432);
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		return props;
	}

	public Properties getDefaultConsumerProps() {
		Properties props = new Properties();
		props.put("bootstrap.servers", env.getKafkaUrl());
		props.put("enable.auto.commit", "false");
		props.put("auto.commit.interval.ms", "1000");
		props.put("session.timeout.ms", "30000");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		return props;
	}
}
