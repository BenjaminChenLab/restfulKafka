package lab.benjamin.restfulKafka.kafkaApi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.google.common.collect.Lists;

import lab.benjamin.restfulKafka.Application;
import lombok.Setter;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class ProducerImplTest {
	@Autowired
	@Setter
	private lab.benjamin.restfulKafka.kafkaApi.Producer producer;
	
	@Test
	public void testProduce(){
//		this.producer.produce("unitTest", Lists.newArrayList("kkk1","kkk2","kkk3"));
	}
}
