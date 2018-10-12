package com.harsha.hii.html_file;
//import org.apache.commons.httpclient.methods.PostMethod;

import java.io.IOException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("/home_sales")
public class Sales_home {
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String login() throws IOException 
	{
		String path="C://Users//harsha//Desktop//rest1//hii//src//main//webapp//html_js//sales_home.html";
		Html_file obj=new Html_file();
		String file=obj.filetostring(path);
		return file;
	}

		
	}


