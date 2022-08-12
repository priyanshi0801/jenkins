package com.nkdebug.jenkins;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JenkinsApplicationTests {

	static Logger logger = LoggerFactory.getLogger(JenkinsApplicationTests.class);

	@Test
	void contextLoads() {
		logger.info("Jenkins Test is running");
		logger.info("Jenkins Test is running");
	}

}
