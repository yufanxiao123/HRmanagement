package net.javaguide.orginazationservice.consumerRabbitMQ;

import net.javaguide.employeeservice.event.OnboardEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class EmployeeConsumerRabbitMQ {
   private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeConsumerRabbitMQ.class);

   @RabbitListener(queues = "${rabbitmq.queue.email.name}")
   public void consume(OnboardEvent onboardEvent) {
      LOGGER.info(String.format("Onboard event received from RabbitMQ => %s",onboardEvent.toString()));
      //operate database
   }
}
