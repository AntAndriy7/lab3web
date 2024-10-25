package org.example.lab3;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/external")
public class ExternalApiController {

    @GetMapping
    public ResponseEntity<String> getExternalApiResponse() {
        RestTemplate restTemplate = new RestTemplate();
        try {
            String response = restTemplate.getForObject("https://catfact.ninja/fact", String.class);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Failed to access external API");
        }
    }
}