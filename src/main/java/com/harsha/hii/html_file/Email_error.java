package com.harsha.hii.html_file;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/error_email")
public class Email_error {
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String add() throws IOException 
	{
		String path="C:\\Users\\harsha\\Desktop\\rest1\\hii\\src\\main\\webapp\\html_js\\error_email.html";
		Html_file obj=new Html_file();
		String file=obj.filetostring(path);
		System.out.println(file);
		return file;
	}
}
