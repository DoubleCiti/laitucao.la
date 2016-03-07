package com.doubleciti;

import com.doubleciti.laitucao.DevToolsApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DevToolsApplication.class)
@WebAppConfiguration
public class LaitucaoApplicationTests {

	@Test
	public void contextLoads() {
	}

}
