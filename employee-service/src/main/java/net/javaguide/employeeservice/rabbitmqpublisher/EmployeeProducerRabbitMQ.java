package net.javaguide.employeeservice.rabbitmqpublisher;

import lombok.AllArgsConstructor;
import net.javaguide.employeeservice.event.OnboardEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmployeeProducerRabbitMQ {
   private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeProducerRabbitMQ.class);

   @Value("${rabbitmq.exchange.name}")
   private String exchange;
   @Value("${rabbitmq.binding.routing.key}")
   private String employeeRoutingKey;

   @Value("${rabbitmq.binding.email.routing.key}")
   private String emailRoutingKey;
   private RabbitTemplate rabbitTemplate;

   public EmployeeProducerRabbitMQ(RabbitTemplate rabbitTemplate) {
      this.rabbitTemplate = rabbitTemplate;
   }

   public void sendMessage(OnboardEvent onboardEvent) {
      LOGGER.info(String.format("Onboard event => %s", onboardEvent.toString()));
      rabbitTemplate.convertAndSend(exchange,employeeRoutingKey,onboardEvent);
      rabbitTemplate.convertAndSend(exchange,emailRoutingKey,onboardEvent);
   }
}
