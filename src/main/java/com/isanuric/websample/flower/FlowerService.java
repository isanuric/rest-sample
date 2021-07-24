package com.isanuric.websample.flower;


import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FlowerService {

    public String getFlowerString() {
        ResponseEntity<String> response = new RestTemplate().getForEntity(
                "http://localhost:8080/flower/string-oneq",
                String.class);
        return response.getBody();
    }

    public ResponseEntity<List<Flower>> getFlower() {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("flower-header", "DFRTGZTR");

        return restTemplate.exchange(
                "/flower",
                HttpMethod.GET,
                new HttpEntity<>(null, headers),
                new FlowerParameterizedTypeReference()
        );
    }

}


