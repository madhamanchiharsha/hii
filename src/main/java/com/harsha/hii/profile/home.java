package com.harsha.hii.profile;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.harsha.hii.html_file.Html_file;
@Path("/home")
public class home {	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String home1() throws IOException 
	{
		String path="C:\\Users\\harsha\\Desktop\\rest1\\hii\\src\\main\\webapp\\html_js\\home.html";
		Html_file obj=new Html_file();
		String file=obj.filetostring(path);
		return file;
	}
	
	

}
