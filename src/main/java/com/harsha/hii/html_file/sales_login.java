package com.harsha.hii.html_file;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("/sales_login")
public class sales_login {
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String login() throws IOException 
	{
		String path="C:\\Users\\harsha\\Desktop\\rest1\\hii\\src\\main\\webapp\\html_js\\sales_login.html";
		Html_file obj=new Html_file();
		String file=obj.filetostring(path);
		return file;
	}
}
