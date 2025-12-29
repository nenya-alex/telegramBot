package com.example.telegrambot;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@SpringBootApplication
@EnableEncryptableProperties
@Slf4j
public class TelegramBotApplication {

	public static void main(String[] args) {
		Environment env = SpringApplication.run(TelegramBotApplication.class, args).getEnvironment();

		String serverPort = env.getProperty("server.port");
		log.info("\n ----------------------------------------------------------\n\t" +
						"Application is running!\n\t" +
						"Swagger: \t{} \n\t" +
						"----------------------------------------------------------",
				"http://localhost:" + serverPort + "/swagger-ui.html");
	}

}
