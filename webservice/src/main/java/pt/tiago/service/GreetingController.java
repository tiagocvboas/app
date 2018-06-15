package pt.tiago.service;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pt.tiago.AutoWireTest;
import pt.tiago.constant.Constant;

@RestController
public class GreetingController {

    private Logger logger = LoggerFactory.getLogger(GreetingController.class);

    private final AutoWireTest autoWireTest;


    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    public GreetingController(AutoWireTest autoWireTest) {
        this.autoWireTest = autoWireTest;
    }

    @RequestMapping(value = Constant.CONTEXT_PATH_PREFIX+"/greeting", method = RequestMethod.GET)
    public ResponseEntity<Greeting> greeting(@RequestParam(value="name", defaultValue="World") String name) {
        logger.info("Greeting was called!");
        logger.info(autoWireTest.alive());
        return new ResponseEntity<>(new Greeting(counter.incrementAndGet(),
                String.format(template, name)), HttpStatus.OK);
    }


}