package com.harsha.hii;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.harsha.hii.db.Dbcon;

@Path("/authentication")
public class Authentic
{
@POST
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Produces(MediaType.TEXT_PLAIN)
public Response logincheck(@FormParam("uname") String uname,
        @FormParam("pass") String password,@Context HttpServletRequest request) throws ClassNotFoundException, SQLException, URISyntaxException
{
	Authentic obj1=new Authentic();
	String query="select * from admin where uname=? and password=?";
	Dbcon obj=new Dbcon();
	Connection con=obj.getconnection();
	PreparedStatement pst=con.prepareStatement(query);
	pst.setString(1, uname);
	pst.setString(2, password);
	ResultSet rs=pst.executeQuery();
	java.net.URI location = new java.net.URI("/hii/webapi/home");
	if(rs.next()) 
	{
		HttpSession session=request.getSession();
	    session.setAttribute("uname",uname);
	    location = new java.net.URI("/hii/webapi/home");
	    return Response.seeOther(location).build();
	}
	else {
	location = new java.net.URI("/hii/webapi/login");
	return Response.seeOther(location).build();
}
	}
}