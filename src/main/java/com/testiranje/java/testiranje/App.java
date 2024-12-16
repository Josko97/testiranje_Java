package com.testiranje.java.testiranje;
import java.util.List;



/**
 * Hello world!
 */
public class App {
	
    public static void main(String[] args) {
    	
    	String filePath = "HOCIDC.001.txt";
    	
    	List<TransactionData> transactions = FileProcessing.fetchData(filePath);
    	
    	OutputTxt.writeToFile(transactions);
    	
    //	FileEncodingConverter.convertFileEncoding(ulaz, izlaz);
    }
}
