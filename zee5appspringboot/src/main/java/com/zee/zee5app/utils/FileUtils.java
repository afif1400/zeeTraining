package com.zee.zee5app.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.stereotype.Component;

@Component
public class FileUtils {

	
	public byte[] readFile(File file) throws IOException {
		FileInputStream fileInputStream = new FileInputStream(file);
		
		byte[] allBytes = new byte[(int) file.length()];
		fileInputStream.read(allBytes);
		return allBytes;
	}
	

}
