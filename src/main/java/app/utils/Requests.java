package app.utils;

import app.model.PolygonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Requests {

    private static final Logger log = LoggerFactory.getLogger(SpringBootApplication.class);

    @Autowired
    RestTemplate restTemplate;

    public ResponseEntity<PolygonResponse> getPolygon(String ticker){
        String apiKey = "tKGrsqJCMlrHGmhI1ersijwujFHmnPex";
        String url = "https://api.polygon.io/v2/aggs/ticker/" + ticker + "/range/1/day/2022-01-01/2022-08-14?adjusted=true&sort=asc&limit=120";
        log.info("reached2");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + apiKey);
        log.info("reached3");
        HttpEntity<String> request = new HttpEntity<>(headers);
        return restTemplate.exchange(url, HttpMethod.GET, request, PolygonResponse.class);
    }
}
