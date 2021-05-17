package com.example.demo.routes;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RouterTest {

    private URL base;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate template;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        this.base = new URL("http://localhost:" + port + "/");
    }

    @Test
    void getHome() {
        ResponseEntity<String> response = template.getForEntity(
            base.toString(),
            String.class
        );
        assertThat(response.getBody()).isEqualTo("Home");
    }
}
