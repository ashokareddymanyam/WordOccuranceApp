package com.file.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class WordOccuranceProgram {

	public static void main(String[] args) {
		WordOccuranceProgram wop = new WordOccuranceProgram();
		wop.printWordOccurance();
	  }
	
	/**
	 * Method to print word occurrence
	 * 
	 */
	public void printWordOccurance() {
		String filePath = "d:/text.txt";
		try {
			Map<String, Integer> counterMap = fileReaderMethod(filePath);
			printWordOccurance(counterMap);
		} catch (Exception e) {
			System.out.println("Exception Message :" + e.getMessage());
		} 
		
	}

	/**
	 * Reads the file 
	 * 
	 * @param filePath
	 * @return Map<String, Integer>
	 * @throws Exception 
	 */
	public Map<String, Integer> fileReaderMethod(String filePath) {
		File file = new File(filePath); 
	    Map<String, Integer> counterMap = new HashMap<>();
		try (Scanner sc = new Scanner(file)) {
			while (sc.hasNextLine()) {
				String nextLine = sc.nextLine();
		    	prepareWordOccurrenceMap(counterMap, nextLine);
		    }
		} catch (FileNotFoundException e) {
			System.out.println("Exception message"+e.getMessage());
		}
		return counterMap;
	}

	/**
	 * Prepare word occurrence map
	 * 
	 * @param counterMap
	 * @param nextLine
	 */
	public String prepareWordOccurrenceMap(Map<String, Integer> counterMap, String nextLine) {
		Arrays.stream(nextLine.split(" ")).forEach(i->{
			String key = i.strip();
			if(counterMap.containsKey(key)) {
				Integer integer = counterMap.get(key);
				counterMap.put(key,integer+1);
			} else {
				counterMap.put(key,1);
			}
		});
		return "successfull";
	}

	/**
	 * Print words with occurrence
	 * 
	 * @param counterMap
	 */
	public String printWordOccurance(Map<String, Integer> counterMap) {
		String printMessage = "Successfully printed"; 
		if(counterMap.isEmpty()) {
			 return printMessage = "counterMap is Empty";
		};
		//Comparing map values to sort based on value desc;
		Comparator<Entry<String, Integer>> comparator = Comparator.comparing(Map.Entry<String, Integer>::getValue).reversed();
		//Comparator<Entry<Object, Object>> comparingByValue = Map.Entry.comparingByValue(Collections.reverseOrder());
		counterMap.entrySet().stream().sorted(comparator).forEach(i->System.out.println(i.getKey() +":"+i.getValue()));
		
		return printMessage;
	} 

	
}
