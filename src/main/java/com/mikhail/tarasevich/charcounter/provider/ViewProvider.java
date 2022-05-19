package com.mikhail.tarasevich.charcounter.provider;

import java.util.LinkedHashMap;

public interface  ViewProvider {
	String  provideView(LinkedHashMap<Character, Long> hashMap, String text);
}
