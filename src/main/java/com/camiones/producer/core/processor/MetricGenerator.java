package com.camiones.producer.core.processor;

import com.camiones.producer.core.domain.TruckMetric;
import com.camiones.producer.core.service.MetricSender;
import com.camiones.producer.core.service.TruckMetricService;
import com.camiones.producer.infrastructure.event.publish.impl.Publisher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MetricGenerator implements MetricSender {

  private final Publisher publisher;
  private final ObjectMapper objectMapper;
  private final TruckMetricService truckMetricService;

  @Override
  @Scheduled(fixedRate = 5000)
  public void sendRandomEvent() throws JsonProcessingException {
    TruckMetric truckMetric = truckMetricService.generateRandomMetric();
    String metric = objectMapper.writeValueAsString(truckMetric);
    publisher.publishEvent(metric);
  }
}
