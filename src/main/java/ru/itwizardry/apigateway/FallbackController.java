package ru.itwizardry.apigateway;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class FallbackController {

    @GetMapping(value = "/fallback/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> usersFallback() {
        return ResponseEntity.status(503).body(Map.of(
                "message", "user-service is temporarily unavailable",
                "fallback", true
        ));
    }
}