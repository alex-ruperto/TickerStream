package org.alex.tickerstream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class TickerStreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(TickerStreamApplication.class, args);
	}
}
