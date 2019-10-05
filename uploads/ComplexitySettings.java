package com.example.demo.inheritence;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ComplexitySettings {
	public static final List<String> JAVA_KEYWORDS = new ArrayList<>(
				Arrays.asList(
							"implements","extends"
						)
			);
	public static final String EXTENDS = "extends";
	public static final String IMPLEMENTS = "implements";
	public static final String IMPORT = "import";
	public static final String CLASS = "class";
	

	public ComplexitySettings(List<String> keywords) {
		super();
	}
		
	
}

