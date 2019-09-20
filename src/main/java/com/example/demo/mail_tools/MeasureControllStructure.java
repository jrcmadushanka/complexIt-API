package com.example.demo.mail_tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.file_reader.FileReaderLocal;
import com.google.gson.Gson;

public class MeasureControllStructure {
	String filePath = "";
	List<String> lines = null;
	int numberOfLines = 0;

	public MeasureControllStructure(String filePath) {
		super();
		this.filePath = filePath;
	}

	public MeasureControllStructure() {
		super();
	}
	
	@SuppressWarnings({ "unchecked", "null", "unused" })
	public String start() {
		
		FileReaderLocal reader = new FileReaderLocal(filePath);
        Complexity controllObj = new Complexity();
        @SuppressWarnings("unused")
		List<String> complexityDueToControllStructure = new ArrayList<String>();
        ArrayList<List<String>> allComplexityDueToControllStructure = new ArrayList<List<String>>();
        
        lines = reader.readFile(filePath);
		String allJson ="";
        if(lines != null) {
        	
        	numberOfLines = lines.size();
        	
			for (String statement : lines) {
				
				complexityDueToControllStructure = controllObj.dueToControllStructure(statement);
				
			        String json = new Gson().toJson(complexityDueToControllStructure);
				//System.out.println(complexityDueToSize.get(0));
				if(complexityDueToControllStructure != null) {
					allJson = new Gson().toJson(json);
					allComplexityDueToControllStructure.add(complexityDueToControllStructure);
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
