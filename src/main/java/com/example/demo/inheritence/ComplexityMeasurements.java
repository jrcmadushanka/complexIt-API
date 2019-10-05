package com.example.demo.inheritence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class ComplexityMeasurements {
	
	private List<String> user_classes = new ArrayList<>();
	private List<String> parent_classes = new ArrayList<>();
	private List<String> methods = new ArrayList<>();
	private List<String> packages = new ArrayList<>();
	private BufferedReader br;
	private String st;
	
	private static int Size;
	
	
	public ComplexityMeasurements(String st) {
		super();
		this.st = st;
	}

	public ComplexityMeasurements(BufferedReader br) {
		super();
		this.br = br;
	}

	public ComplexityMeasurements(String st, List<String> user_defined_classes,
			List<String> user_defined_parent_classes) {
		super();
		this.st = st;
		this.user_classes = user_defined_classes;
		this.parent_classes = user_defined_parent_classes;
	}

	public ComplexityMeasurements(List<String> user_defined_classes, List<String> user_defined_parent_classes,
			BufferedReader br) {
		super();
		this.user_classes = user_defined_classes;
		this.parent_classes = user_defined_parent_classes;
		this.br = br;
	}

	public ComplexityMeasurements(List<String> user_defined_classes, List<String> user_defined_parent_classes,
			List<String> packages, BufferedReader br) {
		super();
		this.user_classes = user_defined_classes;
		this.parent_classes = user_defined_parent_classes;
		this.packages = packages;
		this.br = br;
	}

	public ComplexityMeasurements() {
		super();
	}
	
	
	
	
	public List<String> getUser_defined_classes() {
		return user_classes;
	}

	public void setUser_defined_classes(List<String> user_defined_classes) {
		this.user_classes = user_defined_classes;
	}

	public List<String> getUser_defined_parent_classes() {
		return parent_classes;
	}

	public void setUser_defined_parent_classes(List<String> user_defined_parent_classes) {
		this.parent_classes = user_defined_parent_classes;
	}

	public List<String> getPackages() {
		return packages;
	}

	public void setPackages(List<String> packages) {
		this.packages = packages;
	}

	public BufferedReader getBr() {
		return br;
	}

	public void setBr(BufferedReader br) {
		this.br = br;
	}






    //calculate the inheritance of a program
	public static void calculateInheritanceMeasurements(ComplexityMeasurements cm) throws IOException, ClassNotFoundException {
		
		BufferedReader buffer = cm.getBr();
		int line_count = 1;
		String statement;
		Map<Integer, String> class_blocks = new HashMap<>();
		Map<Integer, String> parent_class_blocks = new HashMap<>();
		List<String> user_defined_classes = cm.getUser_defined_classes();
		List<String> user_defined_parent_classes = cm.getUser_defined_parent_classes();
		List<String> package_list = cm.getPackages();
		
		while ((statement = buffer.readLine()) != null) {
			
			//getting the imported package names
			if (statement.contains(" ")) {
				String[] parts = statement.split(" ");
				
				
				//checking for "import" keyword
				if (parts[0].equals(ComplexitySettings.IMPORT)) {
					
					//checking for "." operator to identify the package name
					if (parts[1].contains(".")) {
						String[] package_parts = parts[1].split(Pattern.quote("."));
						int len = package_parts.length;
						String last_part = package_parts[len - 1];
						
						//checking for the last part of the package statement to check whether it contains "*;"
						if (last_part.equals("*;")) {
							String[] packages = parts[1].split(Pattern.quote(".*"));
							System.out.println("Package name: " + packages[0]);
							
							//inserting the package name into the list
							if (!package_list.contains(packages[0])) {
								package_list.add(packages[0]);
							}
						}
						
						//checking whether the last part of the package name is a class name
						if (Character.isUpperCase(last_part.charAt(0))) {
							String[] packages = parts[1].split(Pattern.quote("." + last_part.charAt(0)));
							System.out.println("Package name: " + packages[0]);
						}
					}
				}
			}
		
			//checking for user defined classes and parent classes
			if (statement.contains(" ") && !statement.contains("\"")) {
				String[] parts = statement.split(" ");
				int index = 0;
				
				
				for (String part: parts) {
					//if the statement contains "class" keyword
					if (part.equals(ComplexitySettings.CLASS)) {
						String class_name = parts[index + 1];
//						System.out.println("User defined class name: " + class_name);
						
						
						
					}
					
					//finding the parent class of the given class
					if (part.equals(ComplexitySettings.EXTENDS) || part.equals(ComplexitySettings.IMPLEMENTS)) {
						String class_name = parts[index + 1];
						System.out.println("Parent class: " + class_name);
						
						user_defined_parent_classes.add(class_name);
						parent_class_blocks.put(line_count, class_name);
					}
					index++;
				}
	
			}
			
			line_count++;
		}
		
		Set<Map.Entry<Integer,String>> set = class_blocks.entrySet();
		
		//finding the classes 
		for (Map.Entry<Integer, String> entries: set) {
			int class_start_point = entries.getKey();
			String class_name = entries.getValue();
			
			int default_inheritance = 2;
			int total_inheritance = 0;
			
			//getting the number of ancestor classes and displaying the total inheritance complexity
			int calculated_inheritance = cm.getClassInheritance(class_start_point, class_name, user_defined_classes, parent_class_blocks, package_list);
			total_inheritance = default_inheritance + calculated_inheritance;
			
			
			System.out.println("Class Inheritance: " + class_name + ": " + total_inheritance);
		}
		
	}
	
	//to calculate the inheritance of a given class
	public int getClassInheritance(int start, String class_name, List<String> user_defined_classes, Map<Integer, String> parent_classes, List<String> package_list) throws ClassNotFoundException {
		
		String parent_class = null;
		String default_package = "java.lang";
		String test_package = "test";
		//By the given class you can get the parent class
		parent_class = parent_classes.get(start);
		
		boolean isParentUserDefined = user_defined_classes.contains(parent_class);
		
		//if the parent class is not null and not user defined, get the number of ancestor classes
		if (parent_class != null && !isParentUserDefined) {
			
			//if the package is java.lang
			if (package_list.size() == 0) {
				
				String qualified_name = default_package + "." + parent_class;
				Class cl = Class.forName(qualified_name);
				
				int cl2 = getNoOfParentClass(cl);
				
				if (cl2 == 0) {
					return 1;
				}

			}
			
			//if there are other packages imported
			else {
				for (String pk: package_list) {
					String qualified_name = pk + "." + parent_class;
					
					Class cl = Class.forName(qualified_name);
					
					int cl2 = getNoOfParentClass(cl);
					if (cl2 == 0) {
						return 1;
					}

				}
			}	
			
		}
		
		//if the parent class is not null and user defined
		else if (parent_class != null && isParentUserDefined) {
			String qualified_name = test_package + "." + parent_class;
			Class cl = Class.forName(qualified_name);
			
			int cl2 = getNoOfParentClass(cl);
			
			if (cl2 == 0) {
				return 1;
			}
		}
		
		return 0;
	}
	
	//to calculate the inheritance of a parent class recursively
	public int getNoOfParentClass(Class obj) {
		int count= 0;
		
		if (obj != null) {
			Class<?> ci = obj.getSuperclass();
			
			if (ci != null) {
				return count + getNoOfParentClass(ci);
			}
			return 0;
		}
		else
			return 0;
	}
	

}
