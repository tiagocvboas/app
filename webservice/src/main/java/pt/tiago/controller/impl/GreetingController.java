package pt.tiago.controller.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.tiago.controller.Greeting;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping(value = "api")
public class GreetingController {

    private final Logger logger = LoggerFactory.getLogger(GreetingController.class);



    private static final String template = "Greetings, this is the root of the api!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping(value = "")
    public ResponseEntity<Greeting> greeting() {
        logger.info("Greeting was called!");
        return new ResponseEntity<>(new Greeting(counter.incrementAndGet(),
                template), HttpStatus.OK);
    }
}