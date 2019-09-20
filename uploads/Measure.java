package com.example.demo.mail_tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.demo.file_reader.FileReaderLocal;

public class Measure {

	String filePath = "";
	List<String> lines = null;
	int numberOfLines = 0;

	public Measure(String filePath) {
		super();
		this.filePath = filePath;
	}

	public Measure() {
		super();
	}
	
	@SuppressWarnings({ "unchecked", "null", "unused" })
	public void start() {
		
		FileReaderLocal reader = new FileReaderLocal(filePath);
        Complexity complexityObj = new Complexity();
        @SuppressWarnings("unused")
		List<String> complexityDueToSize = new ArrayList<String>();
        ArrayList<List<String>> allComplexityDueToSize = new ArrayList<List<String>>();
        
        lines = reader.readFile(filePath);
		
        if(lines != null) {
        	
        	numberOfLines = lines.size();
        	
			for (String statement : lines) {
				
				complexityDueToSize = complexityObj.dueToSize(statement);
				System.out.println(complexityDueToSize.get(0));
				if(complexityDueToSize != null) {
				allComplexityDueToSize.add(complexityDueToSize);
				}
			}
			
        }
        
        int count = 1;
        if( allComplexityDueToSize != null ) {
	        for (List<String> item : allComplexityDueToSize) {
	        	
				System.out.print(count); count++;
				System.out.print(item.get(1)); item.remove(1);
				System.out.println(item.get(0)); item.remove(0);
				
				for (String token : item) {
					System.out.print(token + ",");
				}
			}
        }
	}
}
