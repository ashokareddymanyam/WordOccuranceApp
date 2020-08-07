package com.file.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class ReadFile {

	public static void main(String[] args) {
		
		Map<String,Integer> map = new HashMap<>();
		try (Stream<String> stream = Files.lines(Paths.get("d:/text.txt"))) {
			stream.forEach(line->{
				Arrays.stream(line.split(" ")).forEach(word->{
					String key = word.strip();
					if(map.containsKey(key)) {
						Integer integer = map.get(key);
						map.put(key,++integer);
					} else {
						map.put(key,1);
					}
				});
			});
			
			map.entrySet().stream().sorted(Comparator.comparing(Map.Entry<String,Integer>::getValue).reversed()).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
