package io.spring.cloud.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@RefreshScope
public class ConfigClientAppApplication {
	
	@Autowired
	private ConfigClientAppConfiguration properties;
	
	@Value("${some.other.property}")
	private String someOtherProperty;

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientAppApplication.class, args);
	}
	
	@RequestMapping("/")
	public String printConfig() {
		StringBuilder sbr = new StringBuilder();
		sbr.append(properties.getProperty());
		sbr.append(" || ");
		sbr.append(someOtherProperty);
		return sbr.toString();
	}

}
