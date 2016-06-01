package lab.benjamin.restfulKafka.kafkaApi;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.google.common.collect.Lists;

import lab.benjamin.restfulKafka.Application;
import lombok.Data;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@Data
public class ConsumerImplTest {
		@Autowired
		private lab.benjamin.restfulKafka.kafkaApi.Consumer consumer;
		
		@Test
		public void testConsumeByOffset(){
//			String result=this.consumer.consumeByOffset("group1", Lists.newArrayList("unitTest"), 1L);
//			
//			Assert.assertEquals(null,result);//TODO: use proper expectation value.
		}
	
}
