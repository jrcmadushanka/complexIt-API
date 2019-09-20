package com.example.demo.mail_tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.property.ComplexitySettings;

public class Complexity {

	List<String> java_keywords = ComplexitySettings.JAVA_KEYWORDS;
	List<String> relation_operators = ComplexitySettings.RELATION_OPERATORS;
	List<String> arithmetic_operators = ComplexitySettings.ARITHMETIC_OPERATORS;
	List<String> logical_operators = ComplexitySettings.LOGICAL_OPERATORS;
	List<String> bitwise_operators = ComplexitySettings.BITWISE_OPERATORS;
	List<String> miscellaneous_operators = ComplexitySettings.MISCELLANEOUS_OPERATORS;
	List<String> manipulators = ComplexitySettings.MANIPULATORS;
	List<String> return_types = ComplexitySettings.RETURN_TYPES;
	List<String> method_definitions = ComplexitySettings.METHOD_DEFINITIONS;
	List<String> method_list = new ArrayList<>();
	List<String> primitive_types = ComplexitySettings.PRIMITIVE_TYPES;
	List<String> conditional_logical_operations = ComplexitySettings.CONDITIONAL_LOGICAL_OPERATORS;
	StringBuilder smObj = new StringBuilder();

	public String dueToSize(String statement) {

		List<String> line = new ArrayList<String>();
		List<String> tokens = new ArrayList<String>();

		int complexity = 0;
		String[] words = statement.split(" ");
		List<String> wordList = new ArrayList<>(Arrays.asList(words));

		String[] strings = statement.split("\"");

		String[] args = { "- ", "*", "/ ", "% ", "++", "--", "== ", "!=", " > ", " < ", ">=", "<=", "&&", "||", "!",
				"| ", "^ ", " ~ ", ">> ", "<< ", ">>>", "<<<", "+=", "-=", "*=", "/=", "= ", ">>>=", "|=", "&=", "%=",
				"<<=", ">>=", "^=", ",", "->", "::", "void ", "double ", "int ", "float ", "string ", "printf",
				"print(", "println", "count", " cin", "if ", "if(", "for ", "while ", "do-while", "do{", "do {",
				"switch ", "switch (", "case ", "String ", "Class", "method", "object", "variable", "class", "import",
				"default:", "default ", "endl", "\\n", "\\t", "[]" };

		String[] argLevel2 = { "new", "delete", "throw", "throws" };

		// tokens.add(0, Integer.toString(complexity));
		// tokens.add(1, "");

		for (String word : words) {
			boolean numeric = true;
			Double num = 0.0;

			if (word.startsWith("\"") && word.endsWith("\"")) {
				continue;
			}

			word = word + " ";

			for (String arg : args) {
				if (word.contains(arg)) {

					if (!tokens.contains(arg)) {
						tokens.add(arg);
					}
					complexity++;
				}
			}

			for (String arg : argLevel2) {
				if (word.contains(arg)) {

					if (!tokens.contains(arg)) {
						tokens.add(arg);
					}
					complexity += 2;
				}
			}

			try {
				num = Double.parseDouble(word);
			} catch (NumberFormatException e) {
				numeric = false;
			}
			if (numeric) {
				if (!tokens.contains(Double.toString(num))) {
					tokens.add(Double.toString(num));
				}
				complexity++;
			}

		}

		for (String word : wordList) {
			for (int i = 0; i < word.length(); i++) {

				if (String.valueOf(word.charAt(i)).equals(".")) {

					if (!tokens.contains(".")) {
						tokens.add(".");
					}
					complexity++;
				}
				if (String.valueOf(word.charAt(i)).equals("+")) {

					if ((i - 1) >= 0) {
						if (String.valueOf(word.charAt(i - 1)).equals("+")) {
							continue;
						}
					} else if ((i + 1) < word.length()) {
						if (String.valueOf(word.charAt(i + 1)).equals("+")) {
							continue;
						}
					} else {
						if (!tokens.contains(".")) {

							tokens.add("+");
						}
						complexity++;
					}
				}
			}
		}

		/*
		 * int stringCount = 0;
		 * 
		 * for (String s : strings) { stringCount++; if (stringCount % 2 == 0) { if
		 * (!tokens.contains(s)) { tokens.add(s); } complexity++; } continue; }
		 */

		/*
		 * tokens.set(0, Integer.toString(complexity)); tokens.set(1, statement);
		 */

		/*
		 * System.out.println(
		 * "________________________________________________________________________________________________________________"
		 * ); System.out.println(statement);
		 * System.out.println("---Complexity Due to Size--- " + complexity);
		 * System.out.println("----Tokens---- "); for (String token : tokens) {
		 * System.out.print(token + " , "); } System.out.println("");
		 * System.out.println(
		 * "________________________________________________________________________________________________________________"
		 * );
		 */

		smObj.append("<br/>_________________________________________________").append("<br/>");
		smObj.append(statement).append("<br/>");
		smObj.append("---Complexity Due to Size--- " + complexity).append("<br/>");		
		smObj.append("----Tokens---- ").append("<br/>");		
		for (String token : tokens) {
			smObj.append(token + " , ");
		}
		smObj.append("<br/>");;
		smObj.append(
				"\n__________________________________________________").append("<br/>");

		return smObj.toString();
		
	}
}
