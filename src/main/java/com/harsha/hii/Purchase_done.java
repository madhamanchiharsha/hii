package com.harsha.hii;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import org.json.JSONObject;

import com.harsha.hii.db.Dbcon;
@Path("/purchase_done")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Purchase_done {
	 int invoice;
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String gru( @Context HttpServletRequest request,@Context HttpServletResponse response) throws Exception {
		String line = "";
	    StringBuilder total = new StringBuilder();
		if(response.getStatus()==200) 
		{
			InputStream reis= request.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(reis), 1024 * 4);
			try
		    {

		        while ((line = rd.readLine()) != null)
		        {
		            total.append(line);
		        }
		    } catch (IOException e)
		    {
		        System.out.println("error build string" + e.getMessage());
		    }
			System.out.println(total);
			//Amount_process obj= new Amount_process();
			//int bill_amount=obj.process(total.toString());
			JSONObject list = new JSONObject(total.toString());
			//JSONArray list = new JSONArray(total.toString());
			int bill=list.getInt("total_bill");
			System.out.println(bill);
			  try {
		         System.out.println("Opened database successfully");
		         String query = "INSERT INTO sale_invoice VALUES (?,?,?)";
		         Dbcon obj1=new Dbcon();
		         Connection con=obj1.getconnection();
		         Statement stmt= con.createStatement();
		         String query1="select * from sale_invoice";
		         ResultSet rs = stmt.executeQuery(query1);
		         int i=0;
		         while(rs.next()) 
		         {
		        	 i++;
		         }
		         invoice=i;
		         System.out.println("invoice_id  :  "+invoice);
		 PreparedStatement pstmt = con.prepareStatement(query);
		 list.remove("total_bill");
		 String total1=list.toString();
		 total1=total1.replaceAll("\"", "");
		 System.out.println(invoice);
		 invoice= invoice+1;
		 pstmt.setInt(1, invoice);
		 System.out.println(total1);
		 pstmt.setString(2, total1);
		 System.out.println(bill);
		 pstmt.setInt(3,bill);
		 System.out.println(query);
		 pstmt.executeUpdate();
		 invoice=0;
		 System.out.println("done"+total1);
		 checked_out obj= new checked_out();
		 String st=total.toString();
		 obj.remove(st);
			}catch(Exception e)
		      {
				System.out.println(e);
		      }	
		}
		return "hiii";
	}
	
	public String inputStreamToString(InputStream is)
	{

	    String line = "";
	    StringBuilder total = new StringBuilder();
	    // Wrap a BufferedReader around the InputStream
	    BufferedReader rd = new BufferedReader(new InputStreamReader(is), 1024 * 4);
	    // Read response until the end
	    try
	    {

	        while ((line = rd.readLine()) != null)
	        {
	            total.append(line);
	        }
	    } catch (IOException e)
	    {
	        System.out.println("error build string" + e.getMessage());
	    }
	    // Return full string
	    return total.toString();
	}
}
