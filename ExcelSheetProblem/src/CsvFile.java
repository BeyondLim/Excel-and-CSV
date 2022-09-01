import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.io.FileUtils;

public class CsvFile {

	public static void main(String[] args) throws SQLException, IOException {
		
			 
			 //Create csv file
			   //PrintWriter pw= new PrintWriter(new File("D:\\DB_table1.csv"));
		 PrintWriter pw =new PrintWriter("D:\\DB_Table.csv");  
			   
			 //String builder object  
			   StringBuilder sb=new StringBuilder();
			   
			   
			 //For dataBase connection
			  // Connection connection=null;
			  // DB_Connection obj_DB_Connection=new DB_Connection();
			  // connection=obj_DB_Connection.getConnection();
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mapping","root","Chetan@123");
			   ResultSet rs=null;
			   
			   
			 //Create query to fetch data from the dataBase
			   String query="select * from map";
			   
			 //Prepared Statement to call query
			   PreparedStatement ps=con.prepareStatement(query);
			   
			 // execute and get data into particular result 
			   rs=ps.executeQuery();
			   
			 //Header
			   String str1=new String("id|action|role|status|authorized|submitted|update_record_version|inactive_previous_record|last_configuration_action|insert_record_into_audit|insert_record_into_basetable|mapping_status|copy_record_from_base_table");
			   pw.write(str1);
			   
			 //AIterate over all database

			    while(rs.next()){
			     sb.append(rs.getString("id"));
			     sb.append("|"); 
			     sb.append(rs.getString("action"));
			     sb.append("|");
			     sb.append(rs.getString("role"));
			     sb.append("|");
			     sb.append(rs.getString("status"));
			     sb.append("|");
			     sb.append(rs.getString("authorized"));
			     sb.append("|");
			     sb.append(rs.getString("submitted"));
			     sb.append("|");
			     sb.append(rs.getString("update_record_version"));
			     sb.append("|");
			     sb.append(rs.getString("inactive_previous_record"));
			     sb.append("|");
			     sb.append(rs.getString("last_configuration_action"));
			     sb.append("|");
			     sb.append(rs.getString("insert_record_into_audit"));
			     sb.append("|");
			     sb.append(rs.getString("insert_record_into_basetable"));
			     sb.append("|");
			     sb.append(rs.getString("mapping_status"));
			     sb.append("|");
			     sb.append(rs.getString("copy_record_from_base_table"));
			     sb.append("|");
			     sb.append("\r\n");
			    	
			    	
			    }
			   
			   
			   pw.write(sb.toString());
			   pw.close();
			   System.out.println("CSV file created succssesfully");
			   File source = new File("D:\\DB_Table.csv");
		       File dest = new File("C:\\DB_Table21.csv");
		       FileUtils.copyToDirectory(source, dest);  
			   
			   
			   }
	}

