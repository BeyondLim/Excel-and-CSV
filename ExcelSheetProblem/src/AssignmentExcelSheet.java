
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.sql.*;
public class AssignmentExcelSheet {
public static void main(String[] args) throws Exception{
		
		
		
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mapping","root","Chetan@123");
		 Statement st = con.createStatement();
		 ResultSet rs =  st.executeQuery("select * from map");
		 
		 
	    
         XSSFWorkbook w=new XSSFWorkbook();
	     XSSFSheet mysheet=w.createSheet("ExcelSheet");
	  
		 
	     XSSFRow rowData=mysheet.createRow(0);
	     rowData.createCell(0).setCellValue("id");
	     rowData.createCell(1).setCellValue("action");
	     rowData.createCell(2).setCellValue("role");
	     rowData.createCell(3).setCellValue("status");
	     rowData.createCell(4).setCellValue("authorized");
	     rowData.createCell(5).setCellValue("submitted");
	     rowData.createCell(6).setCellValue("update_record_version");
	     rowData.createCell(7).setCellValue("inactive_previous_record");
	     rowData.createCell(8).setCellValue("last_configuration_action");
	     rowData.createCell(9).setCellValue("insert_record_into_audit");
	     rowData.createCell(10).setCellValue("insert_record_into_basetable");
	     rowData.createCell(11).setCellValue("mapping_status");
	     rowData.createCell(12).setCellValue("copy_record_from_base_table");
	     int r=1;
	     while(rs.next()) {
	    	 long id=rs.getLong("id");
	    	 String action=rs.getString("action");
	    	 String role=rs.getString("role");
	    	 String status=rs.getString("status");
	    	 String authorized=rs.getString("authorized");
	    	 String submitted=rs.getString("submitted");
	    	 String update_record_version=rs.getString("update_record_version");
	    	 String inactive_previous_record=rs.getString("inactive_previous_record");
	    	 String last_configuration_action=rs.getString("last_configuration_action");
	    	 String insert_record_into_audit=rs.getString("insert_record_into_audit");
	    	 String insert_record_into_basetable=rs.getString("insert_record_into_basetable");
	    	 String mapping_status=rs.getString("mapping_status");
	    	 String copy_record_from_base_table=rs.getString("copy_record_from_base_table");
	    	 
	    	 rowData=mysheet.createRow(r++);
	    	 rowData.createCell(0).setCellValue(id);
	    	 rowData.createCell(1).setCellValue(action);
	    	 rowData.createCell(2).setCellValue(role);
	    	 rowData.createCell(3).setCellValue(status);
	    	 rowData.createCell(4).setCellValue(authorized);
	    	 rowData.createCell(5).setCellValue(submitted);
	    	 rowData.createCell(6).setCellValue(update_record_version);
	    	 rowData.createCell(7).setCellValue(inactive_previous_record);
	    	 rowData.createCell(8).setCellValue(last_configuration_action);
	    	 rowData.createCell(9).setCellValue(insert_record_into_audit);
	    	 rowData.createCell(10).setCellValue(insert_record_into_basetable);
	    	 rowData.createCell(11).setCellValue(mapping_status);
	    	 rowData.createCell(12).setCellValue(copy_record_from_base_table);
	     }
	     FileOutputStream sheet=new FileOutputStream("D:\\ChetanExcel.xlsx"); 
	     w.write(sheet);
	     
	     w.close();
	     sheet.close();
	     con.close();
	     System.out.println("Finally, excel sheet is created.");
	}

}
