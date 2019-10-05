package com.example.demo.file_reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.springframework.core.io.Resource;

import javassist.bytecode.stackmap.BasicBlock.Catch;

@SuppressWarnings("resource")
public class FileReaderLocal {

	String filePath = null;
	
	FileReaderLocal(){}

	public FileReaderLocal(String filePath) {
		super();
		this.filePath = filePath;
	}
	
	public List readFile(String pathString) {
		
		Path path = Paths.get(pathString); 
		List<String> allLines = null;
		try {
				byte[] bytes = Files.readAllBytes(path);
				allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
				
		}catch(Exception e){
				System.out.println(e);
		}

		return allLines;
				
	}
}
