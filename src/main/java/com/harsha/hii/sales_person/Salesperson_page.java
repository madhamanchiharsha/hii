package com.harsha.hii.sales_person;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.harsha.hii.html_file.Html_file;
@Path("/salesperson")
public class Salesperson_page {
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String login() throws IOException 
	{
		String path="C:\\Users\\harsha\\Desktop\\rest1\\hii\\src\\main\\webapp\\html_js\\salespage.html";
		Html_file obj=new Html_file();
		String file=obj.filetostring(path);
		return file;
	}


}
