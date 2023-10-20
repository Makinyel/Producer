package com.camiones.producer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
  @Bean
  public Queue queue(){
    return new Queue("metrics");
  }
  @Bean
  public TopicExchange exchange(){
    return new TopicExchange("metrics_topic_exchange");
  }
  @Bean
  public Binding binding(){
    return BindingBuilder
        .bind(queue())
        .to(exchange())
        .with("metrics_routing_key");
  }



}
