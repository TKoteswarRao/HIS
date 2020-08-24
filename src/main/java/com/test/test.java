package com.test;

public class test {

	public static void main(String[] args) {
		String input = "Hello today is monday";
		String output = "olleH yadot si yadnom";

		char[] ch = input.toCharArray();
		String result = "";
		String reverseWord = "";

		for (int i = 0; i <= ch.length - 1; i++) {

			if (ch[i] != ' ') {
				reverseWord = ch[i] + reverseWord;
			} else {
				result = result + " " + reverseWord;
				reverseWord = "";
			}
			if (ch.length - 1 == i) {
				result = result + " " + reverseWord;
			}
		}
		System.out.println("input: " + input);
		System.out.println("result: " + result);
	}
}
