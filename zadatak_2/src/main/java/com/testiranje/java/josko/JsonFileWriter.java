package com.testiranje.java.josko;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonFileWriter {

    public static void writeToJsonFile(Map<String, List<Object>> recordStorage, String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();

        
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
           
        	objectMapper.writeValue(new File("output.json"), recordStorage);
            System.out.println("Podaci su uspješno zapisani u datoteku: " + filePath);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
