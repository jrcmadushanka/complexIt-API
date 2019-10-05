/*
 * package com.example.demo.recursive;
 * 
 * import java.io.BufferedReader; import java.io.FileReader; import
 * java.io.IOException; import java.lang.reflect.Method; import
 * java.util.ArrayList; import java.util.HashMap; import java.util.List; import
 * java.util.Map; import java.util.Set; import java.util.regex.Pattern;
 * 
 * import models.ComplexitySettings; import models.ProgramStatementComplexity;
 * 
 * public class ComplexityMeasurements {
 * 
 * private int size_count; private String st; private List<String> classes;
 * private List<String> variables; private List<String> java_keywords; private
 * List<String> arithmetic_operators; private List<String> relation_operators;
 * private List<String> logical_operators; private List<String>
 * bitwise_operators; private List<String> miscellaneous_operators; private
 * List<String> primitive_types; private List<String>
 * conditional_logical_operations; private List<String> user_defined_classes =
 * new ArrayList<>(); private List<String> user_defined_parent_classes = new
 * ArrayList<>(); private List<String> methods = new ArrayList<>(); private
 * List<String> packages = new ArrayList<>(); private BufferedReader br;
 * 
 * private static int Size;
 * 
 * 
 * 
 * public ComplexityMeasurements(int size_count, String st, List<String>
 * classes, List<String> variables, List<String> java_keywords, List<String>
 * arithmetic_operators, List<String> relation_operators, List<String>
 * logical_operators, List<String> bitwise_operators, List<String>
 * miscellaneous_operators, List<String> primitive_types) { super();
 * this.size_count = size_count; this.st = st; this.classes = classes;
 * this.variables = variables; this.java_keywords = java_keywords;
 * this.arithmetic_operators = arithmetic_operators; this.relation_operators =
 * relation_operators; this.logical_operators = logical_operators;
 * this.bitwise_operators = bitwise_operators; this.miscellaneous_operators =
 * miscellaneous_operators; this.primitive_types = primitive_types; }
 * 
 * public ComplexityMeasurements(List<String> classes, List<String> variables,
 * List<String> java_keywords, List<String> arithmetic_operators, List<String>
 * relation_operators, List<String> logical_operators, List<String>
 * bitwise_operators, List<String> miscellaneous_operators, List<String>
 * primitive_types, List<String> methods) { super(); this.classes = classes;
 * this.variables = variables; this.java_keywords = java_keywords;
 * this.arithmetic_operators = arithmetic_operators; this.relation_operators =
 * relation_operators; this.logical_operators = logical_operators;
 * this.bitwise_operators = bitwise_operators; this.miscellaneous_operators =
 * miscellaneous_operators; this.primitive_types = primitive_types; this.methods
 * = methods; }
 * 
 * public ComplexityMeasurements(List<String> conditional_logical_operations,
 * BufferedReader br) { super(); this.conditional_logical_operations =
 * conditional_logical_operations; this.br = br; }
 * 
 * public ComplexityMeasurements(String st) { super(); this.st = st; }
 * 
 * public ComplexityMeasurements(BufferedReader br) { super(); this.br = br; }
 * 
 * public ComplexityMeasurements(String st, List<String> user_defined_classes,
 * List<String> user_defined_parent_classes) { super(); this.st = st;
 * this.user_defined_classes = user_defined_classes;
 * this.user_defined_parent_classes = user_defined_parent_classes; }
 * 
 * public ComplexityMeasurements(List<String> user_defined_classes, List<String>
 * user_defined_parent_classes, BufferedReader br) { super();
 * this.user_defined_classes = user_defined_classes;
 * this.user_defined_parent_classes = user_defined_parent_classes; this.br = br;
 * }
 * 
 * public ComplexityMeasurements(List<String> user_defined_classes, List<String>
 * user_defined_parent_classes, List<String> packages, BufferedReader br) {
 * super(); this.user_defined_classes = user_defined_classes;
 * this.user_defined_parent_classes = user_defined_parent_classes; this.packages
 * = packages; this.br = br; }
 * 
 * public ComplexityMeasurements() { super(); }
 * 
 * public int getSize_count() { return size_count; }
 * 
 * 
 * 
 * public void setSize_count(int size_count) { this.size_count = size_count; }
 * 
 * 
 * 
 * public String getSt() { return st; }
 * 
 * 
 * 
 * public void setSt(String st) { this.st = st; }
 * 
 * public List<String> getUser_defined_classes() { return user_defined_classes;
 * }
 * 
 * public void setUser_defined_classes(List<String> user_defined_classes) {
 * this.user_defined_classes = user_defined_classes; }
 * 
 * public List<String> getUser_defined_parent_classes() { return
 * user_defined_parent_classes; }
 * 
 * public void setUser_defined_parent_classes(List<String>
 * user_defined_parent_classes) { this.user_defined_parent_classes =
 * user_defined_parent_classes; }
 * 
 * public List<String> getPackages() { return packages; }
 * 
 * public void setPackages(List<String> packages) { this.packages = packages; }
 * 
 * public BufferedReader getBr() { return br; }
 * 
 * public void setBr(BufferedReader br) { this.br = br; }
 * 
 * public List<String> getConditional_logical_operations() { return
 * conditional_logical_operations; }
 * 
 * public void setConditional_logical_operations(List<String>
 * conditional_logical_operations) { this.conditional_logical_operations =
 * conditional_logical_operations; }
 * 
 * public int getClasses() { if (st.contains(" ")) { String[] parts =
 * st.split(" ");
 * 
 * for (String part: parts) { if (part.contains("(")) { String[] mini_parts =
 * part.split(Pattern.quote("("));
 * 
 * if (mini_parts[0].equals("")) { if (!mini_parts[0].equals("")) { if
 * (Character.isUpperCase(mini_parts[1].charAt(0))) { //
 * System.out.println("There is a class in :" + mini_parts[1]);
 * 
 * if (!classes.contains(mini_parts[1])) classes.add(mini_parts[1]);
 * size_count++; } } } else if (!mini_parts[1].equals("")) { if
 * (Character.isUpperCase(mini_parts[1].charAt(0))) { if
 * (mini_parts[1].contains("[]")) { String class_part[] =
 * mini_parts[1].split(Pattern.quote("[]")); //
 * System.out.println("There is a class in :" + class_part[0]);
 * 
 * if (!classes.contains(class_part[0])) classes.add(class_part[0]);
 * size_count++; } } } else if (Character.isUpperCase(mini_parts[1].charAt(0)))
 * { if (mini_parts[1].contains("[]")) { String class_part[] =
 * mini_parts[1].split(Pattern.quote("[]")); //
 * System.out.println("There is a class in :" + class_part[0]);
 * 
 * if (!classes.contains(class_part[0])) classes.add(class_part[0]);
 * size_count++; } }
 * 
 * else if (mini_parts[1].contains("\"")) { if
 * (Character.isUpperCase(mini_parts[0].charAt(0))) { //
 * System.out.println("There is a class in :" + mini_parts[0]);
 * 
 * if (!classes.contains(mini_parts[0])) classes.add(mini_parts[0]);
 * size_count++; } } else { System.out.println("No class"); } } else { String
 * trimmed = part.trim(); if (Character.isUpperCase(trimmed.charAt(0)) &&
 * !trimmed.contains("(")) { // System.out.println("There is a class in :" +
 * part);
 * 
 * if (!classes.contains(trimmed)) classes.add(trimmed); size_count++; } } } }
 * 
 * //if the statement contains "public" or "class" keywords, ignore the size
 * count if (st.contains(ComplexitySettings.CLASS)) { size_count = 0; } return
 * size_count;
 * 
 * }
 * 
 * public int getClassVariables() { for (String cl: classes) { if
 * (st.contains(cl) && st.contains(" ")) { String[] sub_parts = st.split(" ");
 * 
 * int index = 0;
 * 
 * for (String part: sub_parts) { if (part.contains(cl) && !part.contains("\""))
 * { if ((index + 1) < sub_parts.length) { if (!(sub_parts[index +
 * 1].contains("{"))) { if (sub_parts[index + 1].contains(")")) { String[]
 * var_part = sub_parts[index + 1].split(Pattern.quote(")")); if
 * (!variables.contains(var_part[0]) &&
 * !var_part[0].contains(ComplexitySettings.EXTENDS) &&
 * !var_part[0].contains(ComplexitySettings.IMPLEMENTS) &&
 * !var_part[0].contains("(")) { variables.add(var_part[0]); }
 * 
 * // if (!var_part[0].contains(ComplexitySettings.EXTENDS) &&
 * !var_part[0].contains(ComplexitySettings.IMPLEMENTS)) // size_count++; } else
 * { if (!variables.contains(sub_parts[index + 1]) && !sub_parts[index +
 * 1].contains(ComplexitySettings.EXTENDS) && !sub_parts[index +
 * 1].contains(ComplexitySettings.IMPLEMENTS)) { variables.add(sub_parts[index +
 * 1]); }
 * 
 * // if (!sub_parts[index + 1].contains(ComplexitySettings.EXTENDS) &&
 * !sub_parts[index + 1].contains(ComplexitySettings.IMPLEMENTS)) //
 * size_count++; }
 * 
 * } } } index++; } } } return size_count; }
 * 
 * public int getPrimitiveVariables() {
 * 
 * String st1, st2, st3; boolean isBracketFound = false;
 * 
 * // st1 = st.replaceAll(Pattern.quote("("), " "); st1 =
 * st.replaceAll(Pattern.quote(")"), " "); st2 =
 * st1.replaceAll(Pattern.quote("."), " ");
 * 
 * for (String primitive: primitive_types) { if (st2.contains(primitive) &&
 * st2.contains(" ") && !st2.contains("\"")) { String[] sub_parts =
 * st2.split(" "); int index = 0;
 * 
 * for (String part: sub_parts) {
 * 
 * if (isBracketFound && !part.contains("\"")) { part =
 * part.replaceAll(Pattern.quote("("), " "); String[] mini_parts =
 * part.split(" ");
 * 
 * if (mini_parts.length > 1) part = mini_parts[1]; }
 * 
 * if (part.trim().equals(primitive) && !part.trim().contains("\"")) { if
 * (!variables.contains(sub_parts[index + 1]) && !sub_parts[index +
 * 1].contains("(")) { variables.add(sub_parts[index + 1]); isBracketFound =
 * false; }
 * 
 * if (sub_parts[index + 1].contains("(")) { isBracketFound = true; } // else //
 * size_count++; }
 * 
 * if (index < sub_parts.length - 1) { if (sub_parts[index + 1].contains("(")) {
 * isBracketFound = true; } } index++; } } } return size_count; }
 * 
 * public int getStringValues() {
 * 
 * if (st.contains("\"")) { int doubleQuoteCount = st.split(Pattern.quote("\""),
 * -1).length - 1; int size = doubleQuoteCount / 2; size_count += size; }
 * 
 * return size_count; }
 * 
 * public int getMethodNames() {
 * 
 * if (st.contains(ComplexitySettings.PUBLIC) ||
 * st.contains(ComplexitySettings.STATIC)) { // if
 * (st.contains(method_definition)) { String[] parts = st.split(" ");
 * 
 * for (String s: parts) { if (s.contains("(")) { s =
 * s.split(Pattern.quote("("))[0]; methods.add(s); // size_count++; } }
 * 
 * } return size_count; }
 * 
 * public int getJavaKeywords() {
 * 
 * for (String word: java_keywords) { if (st.contains(word+ " ")) {
 * 
 * int occurence_count = (st.split(word, -1).length) - 1; size_count +=
 * occurence_count;
 * 
 * } } return size_count; }
 * 
 * public int getArithmeticOperations() {
 * 
 * String[] parts = st.split(" ");
 * 
 * for (String part: parts) { for (String arithemtic: arithmetic_operators) { if
 * (part.equals(arithemtic) && !part.contains("\"")) { size_count++; } else if
 * (part.contains(arithemtic)) { size_count++; } } }
 * 
 * // for (String arithmetic: arithmetic_operators) { // if
 * (st.contains(arithmetic)) { // int occurence_count =
 * (st.split(Pattern.quote(arithmetic), -1).length) - 1; // size_count +=
 * occurence_count; // } // } return size_count; }
 * 
 * public int getRelationalOperations() {
 * 
 * String[] parts = st.split(" ");
 * 
 * for (String part: parts) { for (String relation: relation_operators) { if
 * (part.equals(relation) && !part.contains("\"")) { size_count++; } } }
 * 
 * // for (String relation: relation_operators) { // if (st.contains(relation))
 * { //// System.out.println("Line no." +count+
 * " contains this Relation Operator: " + relation); // int occurence_count =
 * (st.split(Pattern.quote(relation), -1).length) - 1; // size_count +=
 * occurence_count; // } // } return size_count; }
 * 
 * public int getLogicalOperations() {
 * 
 * String[] parts = st.split(" ");
 * 
 * for (String part: parts) { for (String logical: logical_operators) { if
 * (part.equals(logical) && !part.contains("\"")) { size_count++; } } }
 * 
 * // for (String logical: logical_operators) { // if (st.contains(logical)) {
 * //// System.out.println("Line no." +count+
 * " contains this logical Operator: " + logical); // int occurence_count =
 * (st.split(Pattern.quote(logical), -1).length) - 1; // size_count +=
 * occurence_count; // } // } return size_count; }
 * 
 * public int getBitwiseOperations() {
 * 
 * String[] parts = st.split(" ");
 * 
 * for (String part: parts) { for (String bitwise: bitwise_operators) { if
 * (part.equals(bitwise) && !part.contains("\"")) { size_count++; } } }
 * 
 * // for (String bitwise: bitwise_operators) { // if (st.contains(bitwise)) {
 * //// System.out.println("Line no." +count+
 * " contains this bitwise Operator: " + bitwise); // int occurence_count =
 * (st.split(Pattern.quote(bitwise), -1).length) - 1; // size_count +=
 * occurence_count; // } // } return size_count; }
 * 
 * public int getMiscellaneousOperations() {
 * 
 * String[] parts = st.split(" ");
 * 
 * for (String part: parts) { for (String miscellaneous:
 * miscellaneous_operators) { if (part.equals(miscellaneous) &&
 * !part.contains("\"")) { size_count++; } } }
 * 
 * // for (String miscellaneous: miscellaneous_operators) { // if
 * (st.contains(miscellaneous)) { // int occurence_count =
 * (st.split(Pattern.quote(miscellaneous), -1).length) - 1; // size_count +=
 * occurence_count; // } // } return size_count; }
 * 
 * public int getDotOperatorSeparations() {
 * 
 * String[] strParts = st.split(" "); strParts[0] = strParts[0].trim();
 * 
 * int dot_count = 0;
 * 
 * if (st.contains(ComplexitySettings.DOT)) { String[] parts =
 * st.split(Pattern.quote(ComplexitySettings.DOT)); dot_count =
 * st.split(Pattern.quote(ComplexitySettings.DOT), -1).length - 1; String
 * temp_part;
 * 
 * for (String part: parts) { if (part.contains("(")) { // temp_part =
 * part.replaceAll(Pattern.quote("("), " "); // int count =
 * temp_part.split(" ").length - 1; size_count += 1; }
 * 
 * size_count++; } }
 * 
 * if (strParts[0].equals(ComplexitySettings.IMPORT)) { return 0; } return
 * size_count + dot_count; }
 * 
 * public int getNumberCount() {
 * 
 * List<Number> numbers = new ArrayList<>(); Number num;
 * 
 * st = st.trim();
 * 
 * st = st.replaceAll(Pattern.quote("("), " "); st =
 * st.replaceAll(Pattern.quote(")"), " "); st =
 * st.replaceAll(Pattern.quote(";"), " ");
 * 
 * for (String aritmetic: arithmetic_operators) { st = st.replace(aritmetic,
 * " "); }
 * 
 * for (String relational: relation_operators) { st = st.replace(relational,
 * " "); }
 * 
 * // System.out.println("After replacements: " + st);
 * 
 * String[] parts = st.split(" ");
 * 
 * for (String part: parts) { try { num = Double.parseDouble(part); if
 * (!numbers.contains(num)) { numbers.add(num); } } catch(Exception ex) { //
 * System.out.println(ex.getMessage()); } }
 * 
 * size_count += numbers.size(); return size_count; }
 * 
 * public int countVariableForReturn() { st = st.replaceAll(Pattern.quote("("),
 * " "); // st = st.replaceAll(Pattern.quote("("), " ");
 * 
 * String[] parts = st.split(" ");
 * 
 * parts[0] = parts[0].trim();
 * 
 * for (String part: parts) { if ((variables.contains(part) ||
 * methods.contains(part))) { size_count++; } }
 * 
 * return size_count; }
 * 
 * public int checkForImport() { String[] parts = st.split(" "); parts[0] =
 * parts[0].trim();
 * 
 * if (parts[0].equals(ComplexitySettings.IMPORT)) { size_count = 0; } return
 * size_count; }
 * 
 * public static ProgramStatementComplexity
 * calculateSizeMeasurements(ComplexityMeasurements cm, int line_number) {
 * 
 * Size = cm.getClasses(); Size = cm.getClassVariables(); Size =
 * cm.getPrimitiveVariables(); Size = cm.getStringValues(); Size =
 * cm.getMethodNames(); Size = cm.getJavaKeywords(); Size =
 * cm.getArithmeticOperations(); Size = cm.getRelationalOperations(); Size =
 * cm.getLogicalOperations(); Size = cm.getBitwiseOperations(); Size =
 * cm.getMiscellaneousOperations(); Size = cm.getDotOperatorSeparations(); Size
 * = cm.getNumberCount(); Size = cm.countVariableForReturn(); Size =
 * cm.checkForImport();
 * 
 * ProgramStatementComplexity psc = new ProgramStatementComplexity();
 * psc.setLineNumber(line_number); psc.setSize_count(Size);
 * 
 * return psc; }
 * 
 * 
 * 
 * //calculating the inheritance for a given program public static Map<String,
 * Integer> calculateInheritanceMeasurements(ComplexityMeasurements cm) throws
 * IOException, ClassNotFoundException {
 * 
 * BufferedReader buffer = cm.getBr(); int line_count = 1; String statement;
 * Map<Integer, String> class_blocks = new HashMap<>(); Map<Integer, String>
 * parent_class_blocks = new HashMap<>(); Map<String, Integer>
 * class_inheritance_count = new HashMap<>(); List<String> user_defined_classes
 * = cm.getUser_defined_classes(); List<String> user_defined_parent_classes =
 * cm.getUser_defined_parent_classes(); List<String> package_list =
 * cm.getPackages();
 * 
 * while ((statement = buffer.readLine()) != null) {
 * 
 * //getting the imported package names if (statement.contains(" ")) { String[]
 * parts = statement.split(" ");
 * 
 * //checking for "import" keyword if
 * (parts[0].equals(ComplexitySettings.IMPORT)) {
 * 
 * //checking for "." operator to identify the package name if
 * (parts[1].contains(".")) { String[] package_parts =
 * parts[1].split(Pattern.quote(".")); int len = package_parts.length; String
 * last_part = package_parts[len - 1];
 * 
 * //checking for the last part of the package statement to check whether it
 * contains "*;" if (last_part.equals("*;")) { String[] packages =
 * parts[1].split(Pattern.quote(".*")); System.out.println("Package name: " +
 * packages[0]);
 * 
 * //inserting the package name into the list if
 * (!package_list.contains(packages[0])) { package_list.add(packages[0]); } }
 * 
 * //checking whether the last part of the package name is a class name if
 * (Character.isUpperCase(last_part.charAt(0))) { String[] packages =
 * parts[1].split(Pattern.quote("." + last_part.charAt(0)));
 * System.out.println("Package name: " + packages[0]); } } } }
 * 
 * //checking for user defined classes and parent classes if
 * (statement.contains(" ") && !statement.contains("\"")) { String[] parts =
 * statement.split(" "); int index = 0;
 * 
 * //looping through the parts of the statement for (String part: parts) { //if
 * the statement contains "class" keyword if
 * (part.equals(ComplexitySettings.CLASS)) { String class_name = parts[index +
 * 1]; // System.out.println("User defined class name: " + class_name);
 * 
 * //if a class name is found, add to the class list with the line number if it
 * is not there if (!user_defined_classes.contains(class_name)) {
 * user_defined_classes.add(class_name); class_blocks.put(line_count,
 * class_name); }
 * 
 * }
 * 
 * //finding the parent class of the given class if
 * (part.equals(ComplexitySettings.EXTENDS) ||
 * part.equals(ComplexitySettings.IMPLEMENTS)) { String class_name = parts[index
 * + 1]; System.out.println("Parent class: " + class_name);
 * 
 * user_defined_parent_classes.add(class_name);
 * parent_class_blocks.put(line_count, class_name); } index++; }
 * 
 * }
 * 
 * line_count++; }
 * 
 * Set<Map.Entry<Integer,String>> set = class_blocks.entrySet();
 * 
 * //finding the classes from the map which contains the classes for
 * (Map.Entry<Integer, String> entries: set) { int class_start_point =
 * entries.getKey(); String class_name = entries.getValue();
 * 
 * int default_inheritance = 2; int total_inheritance = 0;
 * 
 * //getting the number of ancestor classes and displaying the total inheritance
 * complexity int calculated_inheritance =
 * cm.getClassInheritance(class_start_point, class_name, user_defined_classes,
 * parent_class_blocks, package_list); total_inheritance = default_inheritance +
 * calculated_inheritance;
 * 
 * // System.out.println("Inheritance for class " + class_name + ": " +
 * total_inheritance);
 * 
 * class_inheritance_count.put(class_name, total_inheritance);
 * 
 * }
 * 
 * return class_inheritance_count;
 * 
 * }
 * 
 * //to calculate the inheritance of a given class public int
 * getClassInheritance(int start, String class_name, List<String>
 * user_defined_classes, Map<Integer, String> parent_classes, List<String>
 * package_list) throws ClassNotFoundException {
 * 
 * String parent_class = null; String default_package = "java.lang"; String
 * test_package = "test"; //get the parent class of the given user defined class
 * parent_class = parent_classes.get(start);
 * 
 * boolean isParentUserDefined = user_defined_classes.contains(parent_class);
 * 
 * //if the parent class is not null and not user defined, get the number of
 * ancestor classes if (parent_class != null && !isParentUserDefined) {
 * 
 * //if the package is java.lang if (package_list.size() == 0) {
 * 
 * String qualified_name = default_package + "." + parent_class;
 * 
 * try { Class cl = Class.forName(qualified_name);
 * 
 * int cl2 = getNoOfParentClass(cl);
 * 
 * if (cl2 == 0) { return 1; } } catch (Exception ex) {
 * 
 * }
 * 
 * 
 * }
 * 
 * //if there are other packages imported else { for (String pk: package_list) {
 * String qualified_name = pk + "." + parent_class;
 * 
 * try { Class cl = Class.forName(qualified_name);
 * 
 * int cl2 = getNoOfParentClass(cl); if (cl2 == 0) { return 1; } } catch
 * (Exception ex) {
 * 
 * }
 * 
 * 
 * } }
 * 
 * }
 * 
 * //if the parent class is not null and user defined else if (parent_class !=
 * null && isParentUserDefined) { String qualified_name = test_package + "." +
 * parent_class; Class cl = Class.forName(qualified_name);
 * 
 * int cl2 = getNoOfParentClass(cl);
 * 
 * if (cl2 == 0) { return 1; } }
 * 
 * return 0; }
 * 
 * //to calculate the inheritance of a parent class recursively public int
 * getNoOfParentClass(Class obj) { int count= 0;
 * 
 * if (obj != null) { Class<?> cl2 = obj.getSuperclass();
 * 
 * if (cl2 != null) { return count + getNoOfParentClass(cl2); } return 0; } else
 * return 0; }
 * 
 * //this class is still not used // public int
 * getNoOfUserDefinedParentClass(int start, List<String> user_defined_classes,
 * Map<Integer, String> parent_classes) { // // int count = 0; // String
 * parent_class = null; // parent_class = parent_classes.get(start); // // if
 * (parent_class != null) { // // } // // return 1; // }
 * 
 * //to calculate the control structure measurements public static
 * List<ProgramStatementComplexity>
 * calculateControlStructureCount(ComplexityMeasurements cm) throws IOException
 * { BufferedReader br = cm.getBr(); List<String> cs =
 * cm.getConditional_logical_operations(); String statement = null; int
 * line_count = 1; List<ProgramStatementComplexity> programStatements = new
 * ArrayList<>();
 * 
 * while ((statement = br.readLine()) != null) { int control_points = 0;
 * 
 * if (statement.contains(" ")) { String[] parts = statement.split(" ");
 * parts[0] = parts[0].trim();
 * 
 * if (parts[0].equals(ComplexitySettings.FOR)) { control_points += 2; String[]
 * separations = statement.split(Pattern.quote(";"));
 * 
 * for (String sep: separations) {
 * 
 * for (String conditional: cs) {
 * 
 * if (sep.contains(conditional)) {
 * 
 * int counts = (sep.split(Pattern.quote(conditional)).length) - 1; counts *=
 * counts; control_points += counts; } } } }
 * 
 * else if (parts[0].equals(ComplexitySettings.IF)) { control_points += 1;
 * 
 * for (String conditional: cs) {
 * 
 * int counts = (statement.split(Pattern.quote(conditional)).length) - 1;
 * control_points += counts;
 * 
 * }
 * 
 * }
 * 
 * // System.out.println("Control structure measurements: " + control_points);
 * // line_count++; } ProgramStatementComplexity psc = new
 * ProgramStatementComplexity(); psc.setLineNumber(line_count);
 * psc.setControl_count(control_points);
 * 
 * programStatements.add(psc);
 * 
 * // System.out.println("Control structure measurements: " + control_points);
 * line_count++; }
 * 
 * return programStatements; }
 * 
 * public int calculateSwitchStatementCount(BufferedReader br) {
 * 
 * String statement; int first_line = 0; int count = 1; int last_line = 0; int
 * left_braces = 0; int right_braces = 0; int case_count = 0; boolean
 * isSwitchFound = false;
 * 
 * try {
 * 
 * while ((statement = br.readLine()) != null) {
 * 
 * if (statement.contains(" ")) { String[] parts = statement.trim().split(" ");
 * 
 * if (parts[0].equals(ComplexitySettings.SWITCH)) { isSwitchFound = true;
 * first_line = count; } }
 * 
 * if (isSwitchFound && statement.contains(" ")) { String[] parts =
 * statement.trim().split(" ");
 * 
 * if (parts[0].contains(ComplexitySettings.CASE)) { case_count++; } }
 * 
 * if (!statement.contains("\"") && statement.contains("}") && isSwitchFound) {
 * right_braces++; }
 * 
 * if (statement.contains("{") && isSwitchFound) { left_braces++; }
 * 
 * if ((left_braces == right_braces) && (left_braces > 0) && (right_braces > 0))
 * { System.out.println("switch method ends at line no. " + count);
 * isSwitchFound = false; case_count = 0; left_braces = 0; right_braces = 0;
 * last_line = count; }
 * 
 * count++; }
 * 
 * System.out.println("Number of cases: " + case_count);
 * System.out.println("First Line: " + first_line);
 * System.out.println("Last line: " + last_line);
 * 
 * } catch (Exception ex) { System.out.println("Error: " + ex.getMessage()); }
 * finally { return case_count; }
 * 
 * } // // public static List<ProgramStatementComplexity>
 * calculateNestingLevelMeasurement(ComplexityMeasurements cm) throws
 * IOException, NullPointerException { // // BufferedReader br = cm.getBr(); //
 * String statement = null; // String nested_control_variable = null; // int
 * left_curly_brace_count = 0; // int right_curly_brace_count = 0; // int
 * line_count = 1; // int nested_count = -1; // List<ProgramStatementComplexity>
 * programStatements = new ArrayList<>(); // // while ((statement =
 * br.readLine()) != null) { // // //check whether the line contains "public" or
 * "class" keywords // if (!statement.contains("\"")) { // if
 * (statement.contains(" ")) { // String[] parts = statement.split(" "); // //
 * if (parts[0].equalsIgnoreCase(ComplexitySettings.PUBLIC) ||
 * parts[0].equalsIgnoreCase(ComplexitySettings.CLASS)) { // nested_count = 0;
 * // } // // } // } // //check whether the line contains "for", "if", "do" or
 * "while" keywords // if (statement.contains(" ")) { // String[] parts =
 * statement.split(" "); // parts[0] = parts[0].trim(); // // if
 * (parts[0].equalsIgnoreCase(ComplexitySettings.FOR) ||
 * parts[0].equalsIgnoreCase(ComplexitySettings.IF) ||
 * parts[0].equalsIgnoreCase(ComplexitySettings.DO) ||
 * parts[0].equalsIgnoreCase(ComplexitySettings.WHILE)) { // // //checking for
 * nested control variable // if
 * (parts[0].equalsIgnoreCase(nested_control_variable) ||
 * nested_control_variable == null) { // nested_count += 1; //
 * nested_control_variable = parts[0]; // left_curly_brace_count += 1; // } //
 * // } // // } // // //checking for right curly braces if the nested control
 * variable is not null // if (statement.trim().contains("}") &&
 * (nested_control_variable != null)) { // right_curly_brace_count++; // // if
 * ((right_curly_brace_count - left_curly_brace_count) == 1) { //
 * nested_count--; // } // } // // if (nested_count <= 0) { // nested_count = 0;
 * // } //// System.out.println("Nested count for line no. " + line_count + ": "
 * + nested_count); // line_count++; // // //adding the nesting level count for
 * the given line // ProgramStatementComplexity psc = new
 * ProgramStatementComplexity(); // psc.setLineNumber(line_count); //
 * psc.setNested_level_count(nested_count); // // programStatements.add(psc); //
 * // } // // return programStatements; // }
 * 
 * public static List<String>
 * calculateRecursionMeasurements(ComplexityMeasurements cm) throws IOException
 * {
 * 
 * BufferedReader br = cm.getBr(); String statement; int left_braces = 0; int
 * right_braces = 0; List<String> method_list = new ArrayList<>(); List<String>
 * recursive_methods = new ArrayList<>(); boolean isMethodFound = false; int
 * count = 0;
 * 
 * while ((statement = br.readLine()) != null) {
 * 
 * boolean isPotentialMethod = false; boolean isFirstLine = false;
 * 
 * System.out.println(statement);
 * 
 * if (!statement.contains("\"") && statement.contains(" ")) { String[] parts =
 * statement.split(" "); parts[0] = parts[0].trim();
 * 
 * for (String return_type:
 * com.example.demo.property.ComplexitySettings.RETURN_TYPES) { if
 * (parts[0].equals(com.example.demo.property.ComplexitySettings.PUBLIC) ||
 * parts[0].equals(com.example.demo.property.ComplexitySettings.STATIC) ||
 * parts[0].equals(return_type)) { statement =
 * statement.replaceAll(com.example.demo.property.ComplexitySettings.PUBLIC,
 * " "); statement =
 * statement.replaceAll(com.example.demo.property.ComplexitySettings.STATIC,
 * " "); statement = statement.replaceAll(return_type, " "); isPotentialMethod =
 * true; } }
 * 
 * if (statement.contains("(") && isPotentialMethod) { String[] method =
 * statement.split(Pattern.quote("("));
 * 
 * if (!method[0].trim().isEmpty()) { // System.out.println("Method name: " +
 * method[0].trim()); method_list.add(method[0].trim()); isMethodFound = true;
 * isFirstLine = true; } }
 * 
 * }
 * 
 * 
 * if (!statement.contains("\"") && statement.contains("}") && isMethodFound) {
 * right_braces++; }
 * 
 * if (statement.contains("{") && isMethodFound) { left_braces++; }
 * 
 * //checking whether the recursive method is called within the scope if
 * (statement.contains(" ") && isMethodFound) { String[] parts =
 * statement.split(" ");
 * 
 * statement = statement.replaceAll(Pattern.quote("("), " "); statement =
 * statement.replaceAll(Pattern.quote(")"), " ");
 * 
 * String[] sub_parts = statement.split(" ");
 * 
 * for (String part: sub_parts) { if (method_list.contains(part.trim()) &&
 * !part.contains("\"") && !isFirstLine) { System.out.println(part +
 * " is a recursive method and recursion was found in line no. " + (count + 1));
 * 
 * //adding the recursive method to the list if
 * (!recursive_methods.contains(part)) recursive_methods.add(part); } }
 * 
 * }
 * 
 * if ((left_braces == right_braces) && (left_braces > 0) && (right_braces > 0))
 * { System.out.println("The method ends at line no. " + (count + 1));
 * isMethodFound = false; left_braces = 0; right_braces = 0;
 * method_list.clear(); }
 * 
 * isFirstLine = false; count++;
 * 
 * }
 * 
 * 
 * return recursive_methods;
 * 
 * 
 * }
 * 
 * // public static List<ProgramStatementComplexity>
 * getInheritanceCountForStatement(ComplexityMeasurements cm, Map<String,
 * Integer> class_inheritance_counts) throws IOException { // BufferedReader br
 * = cm.getBr(); // List<String> user_classes = cm.getUser_defined_classes(); //
 * String statement = null; // int line_count = 1; // int left_braces = 0; //
 * int right_braces = 0; // int inheritance_count = 0; // boolean isClassFound =
 * false; // List<ProgramStatementComplexity> line_inheritance_counts = new
 * ArrayList<>(); // // while ((statement = br.readLine()) != null) { // if
 * (statement.contains(" ") && !statement.contains("\"")) { // String[] parts =
 * statement.split(" "); // int index = 0; // // for (String part: parts) { //
 * if (part.equals(ComplexitySettings.CLASS)) { // String class_name =
 * parts[index + 1]; // // if (class_inheritance_counts.containsKey(class_name))
 * { // System.out.println("Brilliant"); // isClassFound = true; //
 * inheritance_count = class_inheritance_counts.get(class_name); // } // // } //
 * index++; // // } // // } // // if (statement.contains("{") && isClassFound) {
 * // left_braces++; // } // // if (statement.contains("}") &&
 * !statement.contains("\"") && isClassFound) { // right_braces++; // } // // if
 * ((left_braces == right_braces) && (left_braces > 0) && (right_braces > 0)) {
 * // inheritance_count = 0; // isClassFound = false; // left_braces = 0; //
 * right_braces = 0; // } // // ProgramStatementComplexity psc = new
 * ProgramStatementComplexity(); // psc.setLineNumber(line_count); //
 * psc.setInheritance_count(inheritance_count); //
 * line_inheritance_counts.add(psc); // // line_count++; // } // // return
 * line_inheritance_counts; // } // // public static
 * List<ProgramStatementComplexity>
 * getRecursionCountforStatement(ComplexityMeasurements cm, List<String>
 * recursion_methods) throws IOException { // BufferedReader br = cm.getBr(); //
 * String statement = null; // int line_count = 1; // int left_braces = 0; //
 * int right_braces = 0; // boolean isRecursionMethodFound = false; // boolean
 * isRecursionStatement = false; // boolean isFirstLine = false; // boolean
 * isPotentialMethod = false; // List<ProgramStatementComplexity>
 * line_recursion_counts = new ArrayList<>(); // // while ((statement =
 * br.readLine()) != null) { // if (statement.contains(" ") &&
 * !statement.contains("\"")) { // String[] parts = statement.split(" "); //
 * parts[0] = parts[0].trim(); // // for (String return_type:
 * ComplexitySettings.RETURN_TYPES) { // if
 * (parts[0].equals(ComplexitySettings.PUBLIC) ||
 * parts[0].equals(ComplexitySettings.STATIC) || parts[0].equals(return_type)) {
 * // statement = statement.replaceAll(ComplexitySettings.PUBLIC, " "); //
 * statement = statement.replaceAll(ComplexitySettings.STATIC, " "); //
 * statement = statement.replaceAll(return_type, " "); // isPotentialMethod =
 * true; // } // } // // if (statement.contains("(") && isPotentialMethod) { //
 * String[] method = statement.split(Pattern.quote("(")); // // for (String
 * method_part: method) { // if (!method_part.isEmpty()) { // if
 * (recursion_methods.contains(method_part.trim())) { // isRecursionStatement =
 * true; // isRecursionMethodFound = true; // } // } // } // // } // // } // //
 * if (statement.contains("{") && isRecursionMethodFound) { // left_braces++; //
 * } // // if (statement.contains("}") && !statement.contains("\"") &&
 * isRecursionMethodFound) { // right_braces++; // } // // if ((left_braces ==
 * right_braces) && (left_braces > 0) && (right_braces > 0)) { //
 * isRecursionMethodFound = false; // isRecursionStatement = false; //
 * left_braces = 0; // right_braces = 0; // } // // ProgramStatementComplexity
 * psc = new ProgramStatementComplexity(); // psc.setLineNumber(line_count); //
 * psc.setRecursionLine(isRecursionStatement); //
 * line_recursion_counts.add(psc); // // line_count++; // } // // return
 * line_recursion_counts; // } }
 */