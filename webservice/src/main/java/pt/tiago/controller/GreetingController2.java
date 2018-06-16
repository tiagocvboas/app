package pt.tiago.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pt.tiago.constant.Constant;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping(value = Constant.CONTEXT_PATH_PREFIX + "greeting2")
public class GreetingController2 {

    private final Logger logger = LoggerFactory.getLogger(GreetingController2.class);



    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping(value = "")
    public ResponseEntity<Greeting> greeting(@RequestParam(value="name", defaultValue="World") String name) {
        logger.info("Greeting was called!");
        return new ResponseEntity<>(new Greeting(counter.incrementAndGet(),
                String.format(template, name)), HttpStatus.OK);
    }


}