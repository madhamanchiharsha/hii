package com.harsha.hii;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.harsha.hii.db.Dbcon;

@Path("/admin_db")
public class Admin_db {
	int q1=0;
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public void logincheck(@FormParam("item_id") String item_id,
	        @FormParam("quantity") String quantity,@Context HttpServletRequest request) throws ClassNotFoundException, SQLException, URISyntaxException
	{
		Sales_authentic obj1=new Sales_authentic();
		Dbcon obj=new Dbcon();
		Connection con=obj.getconnection();
		String s1="select count_item from items where item_id= ?";
		PreparedStatement pst1=con.prepareStatement(s1);
		pst1.setString(1, item_id);
		ResultSet rs= pst1.executeQuery();
		if(rs.next()) 
		{
			q1=rs.getInt("count_item");
		}
		else 
		{
			System.out.println("no item found");
		}
		String query="UPDATE items SET count_item = ? WHERE item_id = ?";
		int q2=Integer.parseInt(quantity);
		q2=q2+q1;
		PreparedStatement pst=con.prepareStatement(query);
		pst.setInt(1, q2);
		pst.setString(2, item_id);
		pst.executeUpdate();
}
}
