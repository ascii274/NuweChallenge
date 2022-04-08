package com.ascii274.csvtojson;

import com.ascii274.csvtojson.config.ServerConfig;
import com.ascii274.csvtojson.controller.CsvController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
//@RunWith(MockitoJUnitRunner.class)
@AutoConfigureMockMvc
class CsvToJsonAppTests {

	@Autowired
	private MockMvc mockMvc;

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

	// mockito
	@Test
	public void returnDefaultMessageTest() throws Exception{
		this.mockMvc.perform(get("http://localhost:8762/nuwechallenges/api/v1/csvtojson/test")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Hello CSV to Json")));

	}


}
