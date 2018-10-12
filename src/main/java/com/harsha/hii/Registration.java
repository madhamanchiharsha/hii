
package com.harsha.hii;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;
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
@Path("registration_do")
public class Registration {
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public Response logincheck(@FormParam("uname") String uname,
	        @FormParam("pass") String password, @FormParam("mobile") String mobile,@FormParam("email") String email,@FormParam("name") String name,@Context HttpServletRequest request) throws ClassNotFoundException, SQLException, URISyntaxException
	{
		Sales_authentic obj1=new Sales_authentic();
		Dbcon obj=new Dbcon();
		Connection con=obj.getconnection();
		String query="insert into sales values(?,?,?,?,?)";
		PreparedStatement pst=con.prepareStatement(query);
		String q ="select * from sales where email= ?";
		PreparedStatement pst1=con.prepareStatement(q);
		pst1.setString(1, email);
		ResultSet rs= pst1.executeQuery();
		java.net.URI location = new java.net.URI("/hii/webapi/error_email");
		if(rs.next()) 
		{
		    return Response.seeOther(location).build();
		}
		pst.setString(1, uname);
		pst.setString(2, password);
		pst.setString(3, name);
		pst.setString(4, mobile);
		pst.setString(5, email);
		pst.executeUpdate();
		java.net.URI location1 = new java.net.URI("/hii/webapi/success");
		return Response.seeOther(location1).build();

	}
}