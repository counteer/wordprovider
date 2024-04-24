package com.counteer.wordprovider.service;

import com.counteer.wordprovider.config.EventProperties;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final EventProperties eventProperties;

    @Override
    public void sendEvent(final String event) {
        this.kafkaTemplate.send(this.eventProperties.getDefaultTopic(), event);
    }

}
