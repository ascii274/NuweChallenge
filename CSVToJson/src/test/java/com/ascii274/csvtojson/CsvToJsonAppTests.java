package com.ascii274.csvtojson;

import com.ascii274.csvtojson.config.ServerConfig;
import com.ascii274.csvtojson.controller.CsvController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
//@RunWith(MockitoJUnitRunner.class)
class CsvToJsonAppTests {

	@Autowired
	private CsvController csvController;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Autowired
	private ServerConfig serverConfig;

	@Test
	void contextLoads() throws Exception{
		assertThat(csvController).isNotNull();
	}


	@Test
	public void helloCsvMessageTest() throws Exception{
		int port = serverConfig.getPort();
		assertThat(this.testRestTemplate.getForObject("http://localhost:" + port + "/nuwechallenges/api/v1/csvtojson/test"
				,String.class )).contains("Hello CSV to Json");

	}





}
