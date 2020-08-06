package com.file.reader;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class WordOccuranceProgramTest {
	
	WordOccuranceProgram wop = new WordOccuranceProgram();
	
	@Test(expected = NullPointerException.class)
	public void fileReaderMethodTest() {
		String filePath = null;
		wop.fileReaderMethod(filePath);//Expected exception 
	}
	
	@Test
	public void prepareWordOccurrenceMapTest() {
		Map<String, Integer> counterMap = new HashMap<>();
		String nextLine = "word1 word2 word3";
		assertEquals("Testing prepareWordOccurrenceMap method", "successfull", wop.prepareWordOccurrenceMap(counterMap , nextLine));
	}
	
	@Test
	public void testPrintWordOccurance() {
		Map<String, Integer> counterMap = new HashMap<>();
		assertEquals("Testing the printWordOccurance method", "counterMap is Empty", wop.printWordOccurance(counterMap));
	}
	
	@Test
	public void testPrintWord() {
		Map<String, Integer> counterMap = new HashMap<>();
		counterMap.put("word",1);
		counterMap.put("is",2);
		assertEquals("Testing the printWordOccurance method", "Successfully printed", wop.printWordOccurance(counterMap));
	}
	
	@Test
	public void testCounterMapSize() {
		Map<String, Integer> counterMap = new HashMap<>();
		counterMap.put("word",1);
		assertEquals("Testing the prepareword map", 1, counterMap.size());
	}
	

}
