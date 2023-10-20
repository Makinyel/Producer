package com.camiones.producer.infrastructure.event.publish;

import java.util.Map;

public interface PublisherService {

  void publishEvent(String message);
}
