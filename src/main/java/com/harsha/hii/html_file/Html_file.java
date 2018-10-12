package com.harsha.hii.html_file;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Html_file {
//testing done	
public String filetostring(String path)throws IOException 
{
	String content = new String(Files.readAllBytes(Paths.get(path)));
	return content;
}
}
