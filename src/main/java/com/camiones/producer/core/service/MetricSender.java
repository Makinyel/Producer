package com.camiones.producer.core.service;


import com.fasterxml.jackson.core.JsonProcessingException;

public interface MetricSender {

  void sendRandomEvent() throws JsonProcessingException;
}
