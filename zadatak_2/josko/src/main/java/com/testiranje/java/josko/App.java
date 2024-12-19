package com.testiranje.java.josko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.testiranje.java.josko.converter.FileIterator;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	/*
	 public static void main(String[] args) {
	     
	        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);

	       
	        FileIterator fileIterator = context.getBean(FileIterator.class);

	        
	        String testFilePath = "HOCIDC.001.txt";

	      
	        fileIterator.fileIterator(testFilePath);

	        
	    }
	    */
}
