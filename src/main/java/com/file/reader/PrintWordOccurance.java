package com.file.reader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class PrintWordOccurance {

	public static void main(String[] args)  {
		
		//Read all lines from file
		List<String> readAllLines = readFileInList("d:/text1.txt");
		
		Map<String, Integer> counterMap = new HashMap<>();
		prepareCounterMap(readAllLines, counterMap);
		Comparator<Entry<String, Integer>> comparator = Comparator.comparing(Map.Entry<String, Integer>::getValue).reversed();
	    //Comparator<Entry<Object, Object>> comparingByValue = Map.Entry.comparingByValue(Collections.reverseOrder());
		counterMap.entrySet().stream().sorted(comparator).forEach(i->System.out.println(i.getKey() +":"+i.getValue()));
	}

	/**
	 * Method to prepare counter map
	 * 
	 * 
	 * @param readAllLines
	 * @param counterMap
	 */
	public static Map<String, Integer> prepareCounterMap(List<String> readAllLines, Map<String, Integer> counterMap) {
		readAllLines.forEach(i->{
			String[] split = i.split(" ");
			for(int j=0;j<split.length;j++) {
				String key = split[j].strip();
				if(counterMap.containsKey(key)) {
					Integer integer = counterMap.get(key);
					counterMap.put(key,integer+1);
				} else {
					counterMap.put(key,1);
				}
			}
			
		});
		return counterMap;
	}
	
	/**
	 * Read file
	 * 
	 * 
	 * @param fileName
	 * @return List<String>
	 */
	public static List<String> readFileInList(String fileName) { 
	    List<String> lines = Collections.emptyList(); 
	    try{ 
	    	Path path = Paths.get(fileName);
	      lines = Files.readAllLines(path, StandardCharsets.UTF_8); 
	    } catch (IOException e)  { 
	      System.out.println("Exception ::"+e.getMessage());
	      e.printStackTrace(); 
	    } 
	    return lines; 
	  } 
	
	
	/**
	 * 
	 * 
	 * @return
	 */
	public final String helloMethod() {
        return "Hello";
    }

	/**
	 * 
	 */
	public static void thirdMethod() {
		
	}

	/**
	 * 
	 * @param anyString
	 * @return
	 */
	public static String firstMethod(String anyString) {
		return "xyz";
	}

	/**
	 * 
	 * @return
	 */
	public static String secondMethod() {
		return "abc";
	}

}
