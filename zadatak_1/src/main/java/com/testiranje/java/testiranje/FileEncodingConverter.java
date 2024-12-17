package com.testiranje.java.testiranje;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class FileEncodingConverter {


    public static void convertFileEncoding(String inputFile, String outputFile) {
        Charset sourceCharset = StandardCharsets.UTF_8;
        Charset targetCharset = Charset.forName("CP852"); 

        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), sourceCharset));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), targetCharset))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Konverzija uspješno završena: " + outputFile);
        } catch (IOException e) {
            System.err.println("Greška tijekom konverzije: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Primjer korištenja
        String inputFile = "transactions_2024-12-16_192254.txt"; 
        String outputFile = "oem852_output.txt"; 

        convertFileEncoding(inputFile, outputFile);
    }
}
