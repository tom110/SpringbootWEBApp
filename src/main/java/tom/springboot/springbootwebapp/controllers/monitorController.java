package tom.springboot.springbootwebapp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import tom.springboot.springbootwebapp.domain.monitor.Metrics;

@RestController
public class monitorController {

    @RequestMapping(value = "/metrics", method = RequestMethod.GET)
    public Metrics metrics(){
        RestTemplate restTemplate = new RestTemplate();
        Metrics m = restTemplate.getForObject("http://localhost:8011/metrics", Metrics.class);
        return m;
    }

}
