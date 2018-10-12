package com.harsha.hii;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import com.harsha.hii.db.*;
public class checked_out {
public void remove(String injson) throws JSONException 
{
	System.out.println("in");
	String item_id=null,quantity;
	JSONObject list = new JSONObject(injson);
	Iterator<String> keys = list.keys();
	while(keys.hasNext()) 
	{
		item_id=keys.next();
		quantity=list.getString(item_id);
		int quant=Integer.parseInt(quantity);
		try {
			Dbcon obj= new Dbcon();
			Connection con=obj.getconnection();
			String sql= "select count_item from items where item_id= ?";
			String sql_up="UPDATE items SET count_item = ? WHERE item_id = ?";
			PreparedStatement pstmt= con.prepareStatement(sql);
			PreparedStatement pstmt1= con.prepareStatement(sql_up);
			pstmt.setString(1,item_id);
			ResultSet rs= pstmt.executeQuery();
			while(rs.next()) 
			{
				int quantity1=rs.getInt("count_item");
				System.out.println(quantity1);
				int result_quantity=quantity1-quant;
				pstmt1.setInt(1, result_quantity);
				pstmt1.setString(2, item_id);
				pstmt1.executeUpdate();
			}
		}catch(Exception e) 
			{
			System.out.println(e);
			}
	}
}
}
