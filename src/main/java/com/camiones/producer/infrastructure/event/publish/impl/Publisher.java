package com.camiones.producer.infrastructure.event.publish.impl;

import com.camiones.producer.infrastructure.event.publish.PublisherService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class Publisher implements PublisherService {

  private final RabbitTemplate rabbitTemplate;

  @Override
  public void publishEvent(String message) {
    try {
      log.info("Sending event to RabbitMQ..." + message);
      rabbitTemplate.convertAndSend("metrics_topic_exchange", "metrics_routing_key", message);
    } catch (Exception e) {
      log.info("Failed to send event to RabbitMQ. Error: [{}], Cause: [{}], At: [{}]",
          e.getLocalizedMessage(), e.getCause(), this.getClass());
    }
  }
}
