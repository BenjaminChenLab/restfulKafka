package lab.benjamin.restfulKafka.kafkaApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab.benjamin.restfulKafka.settings.KafkaSettings;
import lombok.Setter;

@Service
public class ConsumerImpl implements Consumer {
	private final Logger log=LoggerFactory.getLogger(this.getClass());
	@Autowired
	@Setter
	private KafkaSettings kafkaSettings;

	@Override
	public String consumeByOffset(String groupId, List<String> subscribeTopics,Long offset) {
		String result=null;
		
		Properties props = kafkaSettings.getDefaultConsumerProps();
		props.put("group.id", groupId);
		
		
		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
		consumer.subscribe(subscribeTopics);
		final int minBatchSize = 200;
		List<ConsumerRecord<String, String>> buffer = new ArrayList<>();
		try {
			
			ConsumerRecords<String, String> records = consumer.poll(kafkaSettings.CONSUMING_POLL_DURATION);

			for (TopicPartition partition : records.partitions())
				consumer.seek(partition, offset);
				//Honesty I don't know how to use seek yet...  pick this up in the future..
			
			 ConsumerRecords<String, String> records2 = consumer.poll(100);
		      for (ConsumerRecord<String, String> record : records2){
		    	  result=record.value();//Assuming if one offset can only maps to one value.  My apology that I need to figure this out later.
		      }
		

		} finally {
			consumer.close();
		}
		return result;

	}

}
