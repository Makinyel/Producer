package com.camiones.producer.core.service.impl;

import com.camiones.producer.core.domain.TruckMetric;
import com.camiones.producer.core.service.TruckMetricService;
import java.time.LocalDateTime;
import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class TruckMetricServiceImpl implements TruckMetricService {

  private final String[] placas = {"SHS-808", "HAR-123", "ABC-123", "UAK-438"};
  private final String[] matrics = {"no gas", "filled with gas", "alarm triggered"};
  private final String[] drivers = {"Angel", "Daniel", "Estefany"};

  @Override
  public TruckMetric generateRandomMetric() {
    Random random = new Random();
    return TruckMetric.builder()
        .placa(getRandomPlaca(random))
        .event(getRandomEvent(random))
        .driver(getRandomDriver(random))
        .emittedBy(getRandomDriver(random))
        .eventDataTime(LocalDateTime.now())
        .build();
  }

  private String getRandomPlaca(Random random) {
    int randomIndex = random.nextInt(placas.length);
    return placas[randomIndex];

  }

  private String getRandomEvent(Random random) {
    int randomIndex = random.nextInt(matrics.length);
    return matrics[randomIndex];
  }

  private String getRandomDriver(Random random) {
    int randomIndex = random.nextInt(drivers.length);
    return drivers[randomIndex];
  }
}
