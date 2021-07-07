package kr.sity.SpringBootActiveMQ;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skill")
public class MqController {

private static final Logger LOGGER = LoggerFactory.getLogger(MqController.class);
	
	@Autowired
	private Sender sender;
	
	@Autowired
	  private Receiver receiver;
	
	@GetMapping(path = "/activemq")
	public String activemq() throws InterruptedException {
		
		LOGGER.info("Log ActiveMQ");
		sender.send("Hello Spring JMS ActiveMQ!");

	    receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
//	    assertThat(receiver.getLatch().getCount()).isEqualTo(0);
	    
		return LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);

	}
}
