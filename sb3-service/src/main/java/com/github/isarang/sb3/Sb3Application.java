package com.github.isarang.sb3;

import com.github.isarang.sb3.config.MyRuntimeHints;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportRuntimeHints;

@SpringBootApplication
@ImportRuntimeHints({MyRuntimeHints.class})
public class Sb3Application {

	public static void main(String[] args) {
		SpringApplication.run(Sb3Application.class, args);
	}

}
