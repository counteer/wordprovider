package com.counteer.wordprovider.controller;

import com.counteer.wordprovider.service.EventService;
import com.counteer.wordprovider.wordgenerator.HungarianWordGenerator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    private final HungarianWordGenerator wordGenerator;

    @PostMapping("/publish")
    public String sendEvent() {
        String word = wordGenerator.generateWord();
        this.eventService.sendEvent(word);
        return "Sent event: " + word;
    }

}