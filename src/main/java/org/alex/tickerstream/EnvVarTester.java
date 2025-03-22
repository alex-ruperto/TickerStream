package org.alex.tickerstream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EnvVarTester implements CommandLineRunner {

	@Value("${spring.datasource.url}")
	private String datasourceUrl;

	@Override
	public void run(String... args) {
		System.out.println("Database URL resolved to: " + datasourceUrl);
	}
}
