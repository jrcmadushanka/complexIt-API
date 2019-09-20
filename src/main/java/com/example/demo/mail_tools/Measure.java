package com.example.demo.mail_tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.file_reader.FileReaderLocal;
import com.google.gson.Gson;

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
	public String start() {
		
		FileReaderLocal reader = new FileReaderLocal(filePath);
        Complexity complexityObj = new Complexity();
        @SuppressWarnings("unused")
		List<String> complexityDueToSize = new ArrayList<String>();
        ArrayList<List<String>> allComplexityDueToSize = new ArrayList<List<String>>();
        
        lines = reader.readFile(filePath);
		String allJson ="";
        if(lines != null) {
        	
        	numberOfLines = lines.size();
        	
			for (String statement : lines) {
				
				complexityDueToSize = complexityObj.dueToSize(statement);
				
			        String json = new Gson().toJson(complexityDueToSize);
				//System.out.println(complexityDueToSize.get(0));
				if(complexityDueToSize != null) {
					allJson = new Gson().toJson(json);
				allComplexityDueToSize.add(complexityDueToSize);
				}
			}
			
        }
        
        String response[] = new String[10];
        String line[];
        
        Map<String, List<String>> aMap = new HashMap<String, List<String>>();
      //  aMap.put("a" , Integer.valueOf(1));
		/*
		 * int count = 1;
		 * 
		 * if( allComplexityDueToSize != null ) {
		 * 
		 * for (List<String> item : allComplexityDueToSize) {
		 * 
		 * response[0] = Integer.toString(count); System.out.println(
		 * "__________________________________________________________");
		 * System.out.print(count); count++; System.out.println(item.get(0));
		 * item.remove(0); System.out.println(
		 * "__________________________________________________________");
		 * //System.out.print(item.get(1)); item.remove(1);
		 * 
		 * for (String token : item) { System.out.print(token + ","); } } }
		 */
        
        return allJson;
	}
}
