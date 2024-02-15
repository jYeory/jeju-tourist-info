package com.jyeory.sts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jyeory.sts.data.service.TouristService;

@SpringBootApplication
public class JejuTouristApplication implements ApplicationRunner {

	@Autowired
	private TouristService service;

	public static void main(String[] args) {
		SpringApplication.run(JejuTouristApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		String[] params = args.getSourceArgs();
		service.run(params);
		// List<String> appArgs = args.getOptionValues("xml.base.path");
		// service.doParsing(appArgs.get(0));
	}

}
