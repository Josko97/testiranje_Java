package com.testiranje.java.josko.converter;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class FileIterator {

	private final Map<String, FileConverter> fileConverters;

	public FileIterator(Map<String, FileConverter> fileConverters) {
		this.fileConverters = fileConverters;
	}

	public void fileIterator(String filePath) {

		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

			File file = new File(filePath);

			String line;

			while ((line = reader.readLine()) != null) {

				if (file.length() % (line.length() + 2) != 0) {
					System.out.println("Invalid row!");
					continue;
				}

				char recordType = line.charAt(32);

				fetchData(line, recordType);

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void fetchData(String line, char recordType) {

		FileConverter fileConverter = fileConverters.get(String.valueOf(recordType));

		if (fileConverter != null) {
			fileConverter.fetchData(line);
		} else {
			System.out.println("Skipping line: No converter found for record type: " + recordType);
			return;
		}

	}

}
