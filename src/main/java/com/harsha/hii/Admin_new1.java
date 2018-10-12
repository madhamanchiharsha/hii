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
@Path("/admin_new1")
public class Admin_new1 {
	int q1=0;
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public void logincheck(@FormParam("item_id") String item_id,
	        @FormParam("quantity") String quantity,@FormParam("Unit_price") String up,@FormParam("min") String min,@Context HttpServletRequest request) throws ClassNotFoundException, SQLException, URISyntaxException
	{
		Sales_authentic obj1=new Sales_authentic();
		Dbcon obj=new Dbcon();
		Connection con=obj.getconnection();
		String s1="insert into items (item_id,count_item,price,threshold) values(?,?,?,?)";
		PreparedStatement pst1=con.prepareStatement(s1);
		pst1.setString(1, item_id);
		pst1.setString(2, quantity);
		pst1.setString(3, up);
		pst1.setString(4, min);
		pst1.executeUpdate();
}

}
