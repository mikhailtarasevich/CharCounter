package com.mikhail.tarasevich.charcounter.provider;

import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class CharCounterImpl implements CharCounter {

	public LinkedHashMap<Character, Long> uniqueCharCounter(String text) {
		return text.chars()
				.mapToObj(item -> (char) item)
				.collect(Collectors.toMap(key -> key, value -> {
			return text.chars()
					.mapToObj(item -> (char) item)
					.filter(value::equals).count();
		}, (e1, e2) -> e1, LinkedHashMap::new));
	}
}
