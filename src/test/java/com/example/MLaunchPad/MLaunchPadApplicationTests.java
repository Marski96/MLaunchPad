package com.example.MLaunchPad;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.MLaunchPad.web.LaunchPadController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MLaunchPadApplicationTests {

	@Autowired
	private LaunchPadController controller;
	
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}
