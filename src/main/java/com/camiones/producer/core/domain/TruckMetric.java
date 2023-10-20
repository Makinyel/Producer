package com.camiones.producer.core.domain;

import jakarta.persistence.Column;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TruckMetric {

  private String placa;
  private String event;
  private String driver;
  private String emittedBy;
  private LocalDateTime eventDataTime;
}
