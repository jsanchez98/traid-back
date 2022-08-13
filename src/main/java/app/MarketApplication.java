package app;

import app.repository.PolygonRepository;
import app.model.PolygonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class MarketApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringBootApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MarketApplication.class, args);
	}

	@Bean
    public WebMvcConfigurer corsConfigurer(){
	    return new WebMvcConfigurer(){
	        @Override
            public void addCorsMappings(CorsRegistry registry){
	            registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE").allowedHeaders("*")
                        .allowedOrigins("*");
            }
        };
    }

    @Bean
    public RestTemplate restTemplate(){
	    RestTemplateBuilder builder = new RestTemplateBuilder();
	    return builder.build();
    }

    /*
    @Bean
    public CommandLineRunner run(RestTemplate restTemplate, PolygonRepository polygonRepository) throws Exception{
	    return args -> {
	        String apiKey = "tKGrsqJCMlrHGmhI1ersijwujFHmnPex";
	        String url = "https://api.polygon.io/v2/aggs/ticker/AAPL/range/1/day/2021-01-01/2021-07-22?adjusted=true&sort=asc&limit=120";

            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Bearer " + apiKey);

            HttpEntity<String> request = new HttpEntity<String>(headers);
            ResponseEntity<PolygonResponse> response = restTemplate.exchange(url, HttpMethod.GET, request, PolygonResponse.class);
	        PolygonResponse polygon = response.getBody();
	        log.info(polygon.toString());

	        polygonRepository.save(polygon);
        };
    }
    **/
}
