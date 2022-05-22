package com.mikhail.tarasevich.charcounter.provider;

public class ConsoleForCharCounter {

	public static void main(String[] args) {
	
	CharCounter exampleCounter = new CharCounter();
	HashMapPrinter printer = new HashMapPrinter();
	printer.hashMapPrinter(exampleCounter.countUniqueChars("HelLo Alexey!!!"));
	}

}
