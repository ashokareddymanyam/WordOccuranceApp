package com.file.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class WordOccurance {

	public static void main(String[] args) {
		
		File file = new File("d:/text.txt");
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			Map<String, Integer> counterMap = new HashMap<>();
			  String st; 
			  try {
				while ((st = br.readLine()) != null) {
					prepareCounterMap(counterMap, st);
				}
				//Comparing map values to sort based on value desc;
				Comparator<Entry<String, Integer>> comparator = Comparator.comparing(Map.Entry<String, Integer>::getValue).reversed();
				//Comparator<Entry<Object, Object>> comparingByValue = Map.Entry.comparingByValue(Collections.reverseOrder());
				LinkedHashMap<String, Integer> collect = counterMap.entrySet().stream().sorted(comparator)
						.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(a,b)->a, LinkedHashMap::new));
				
				System.out.println(collect);
			} catch (IOException e) {
				System.out.println("Exception message"+e.getMessage());
			} 
		} catch (IOException e1) {
			System.out.println("Exceptin message"+e1.getMessage());
		} 
		
   }

	/**
	 * @param counterMap
	 * @param st
	 */
	private static void prepareCounterMap(Map<String, Integer> counterMap, String st) {
		String[] words = st.split(" ");
		
		for(int j=0;j<words.length;j++) {
			String key = words[j].strip();
			if(counterMap.containsKey(key)) {
				Integer integer = counterMap.get(key);
				counterMap.put(key,integer+1);
			} else {
				counterMap.put(key,1);
			}
		}
	} 


}
