package com.vetalalien.miniservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Map;

@SpringBootApplication
public class MiniserviceApplication {

	public static void main(String[] args) {
		Map<String, String> envs = System.getenv();
		for (Map.Entry<String, String> entry : envs.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}

		SpringApplication.run(MiniserviceApplication.class, args);

	}
}
