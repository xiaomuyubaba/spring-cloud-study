package com.lijin.study.springboot.controller;

import java.net.URL;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GreetingControllerTest {

	@LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate template;
	
	@Test
	public void testGreeting() throws Exception {
		URL url = new URL("http://localhost:" + port + "/greeting");
		ResponseEntity<String> resp = template.getForEntity(url.toString(), String.class);
		System.out.println("RESP----->" + resp);
	}
	
}
