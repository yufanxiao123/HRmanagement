package net.javaguide.employeeservice.kafka;

import lombok.AllArgsConstructor;
import net.javaguide.employeeservice.event.OnboardEvent;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/*
@Service
@AllArgsConstructor
public class EmployeeProducer {
   private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeProducer.class);
   private NewTopic topic;
   private KafkaTemplate<String, OnboardEvent> kafkaTemplate;

   public void sendMessage(OnboardEvent onboardEvent) {
      LOGGER.info(String.format("Onboard event => %s", onboardEvent.toString()));
      //create message
      Message<OnboardEvent> message = MessageBuilder
              .withPayload(onboardEvent)
              .setHeader(KafkaHeaders.TOPIC,topic.name())
              .build();
      kafkaTemplate.send(message);
   }
}

 */
