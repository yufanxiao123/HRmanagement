package net.javaguide.orginazationservice.kafka;

import net.javaguide.employeeservice.event.OnboardEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/*
@Service
public class EmployeeConsumer {
   private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeConsumer.class);

   //this consumer belongs to consumer group groupId
   @KafkaListener(topics = "${spring.kafka.topic.name}",groupId = "${spring.kafka.consumer.group-id}")
   public void consume(OnboardEvent onboardEvent) {
      LOGGER.info(String.format("Onboard event received in organization service"));
      //save the onboard event into the database, check whether department exists
   }
}

 */
