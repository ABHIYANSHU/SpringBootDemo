package com.covidregistrationassistant.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping("covidreg")
public class MainController {

    private RestTemplate template;
    private HttpHeaders headers;

    public MainController(){
        template = new RestTemplate();
        headers = new HttpHeaders();
    }

    @RequestMapping("/")
    public String Index(){
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("Accept-Language", "en_US");
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        ResponseEntity<String> result = template.exchange("https://api.demo.co-vin.in/api/v2/admin/location/states", HttpMethod.GET, entity,String.class);
        return result.getBody();
    }

}
