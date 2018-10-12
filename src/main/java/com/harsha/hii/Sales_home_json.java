package com.harsha.hii;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import com.harsha.hii.db.Dbcon;
@Path("/home_sales_json")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Sales_home_json {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response gru( Request request) throws Exception {
	Dbcon obj= new Dbcon();
	java.sql.Connection con=obj.getconnection();
	Statement st =con.createStatement();
	ResultSet rs= st.executeQuery("select * from items");
	JSONArray array=new JSONArray();
	HashMap <String,JSONObject> db_row=new HashMap<String,JSONObject>();
	int coloumn_count=rs.getMetaData().getColumnCount();
	int j=0;
	JSONObject jsobj=new JSONObject();
	while(rs.next()) {
		JSONObject json=new JSONObject();
	for(int i=0;i<coloumn_count;i++){
		json.put(rs.getMetaData().getColumnLabel(i+1).toLowerCase(),( rs.getObject(i+1)).toString());
		db_row.put("json" + i, json);
	}
	array.put(db_row.get("json" + j));
	//JSONObject jsobj=new JSONObject();
			jsobj.put("records",array);
			j++;
			System.out.println(jsobj);
	}
	String out=array.toString();
	//Response response;
	System.out.println(out);
	return Response.status(200).entity(out).build();
	  
	  
	}
}


