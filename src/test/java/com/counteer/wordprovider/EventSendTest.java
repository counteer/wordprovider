package com.counteer.wordprovider;

import com.counteer.wordprovider.service.EventService;
import com.counteer.wordprovider.wordgenerator.HungarianWordGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EventSendTest {

    @Autowired
    private EventService service;

    @Autowired
    private HungarianWordGenerator wordGenerator;

    @Test
    public void test() {
        service.sendEvent(wordGenerator.generateWord());
    }

}
