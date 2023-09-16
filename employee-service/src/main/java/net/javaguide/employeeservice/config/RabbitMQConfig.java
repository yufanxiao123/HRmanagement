package net.javaguide.employeeservice.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

   @Value("${rabbitmq.queue.employee.name}")
   private String employeeQueue;
   @Value("${rabbitmq.queue.email.name}")
   private String emailQueue;
   @Value("${rabbitmq.exchange.name}")
   private String exchange;
   @Value("${rabbitmq.binding.routing.key}")
   private String employeeRoutingKey;
   @Value("${rabbitmq.binding.email.routing.key}")
   private String emailRoutingKey;
   // spring bean for queue - employee queue
   @Bean
   public Queue employeeQueue(){
      return new Queue(employeeQueue);
   }
   @Bean
   public Queue emailQueue(){
      return new Queue(emailQueue);
   }
   // spring bean for exchange
   @Bean
   public TopicExchange exchange(){
      return new TopicExchange(exchange);
   }
   // spring bean for binding between exchange and queue using routing key
   @Bean
   public Binding binding(){
      return BindingBuilder
              .bind(employeeQueue())
              .to(exchange())
              .with(employeeRoutingKey);
   }
   @Bean
   public Binding bindingEmail(){
      return BindingBuilder
              .bind(emailQueue())
              .to(exchange())
              .with(emailRoutingKey);
   }
   // message converter
   @Bean
   public MessageConverter converter(){
      return new Jackson2JsonMessageConverter();
   }
   // configure RabbitTemplate
   @Bean
   public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
      RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
      rabbitTemplate.setMessageConverter(converter());
      return rabbitTemplate;
   }
}
