package practice.ddt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtils {
	
	/*@Test
	 public void getExecuteQuery() throws SQLException
	 {
	  //Step 1: Register the database
	  Driver driverref=new Driver();
	  DriverManager.registerDriver(driverref);
	  
	  //Step 2: establish Connection with database
	  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customers", "root", "root");
	  
	  //Step 3: Issue create statement
	  Statement stat=con.createStatement();
	  
	  //Step 4: Execute any query
	  ResultSet result = stat.executeQuery("select * from customer;");
	  while(result.next())
	  {
	   System.out.println(result.getString(1));
	  }
	  
	  //Step 5: Close database connection
	  con.close();
	 }*/
	
	/*@Test
	 public void getExecuteUpdate() throws SQLException{
	  //step1: resister the database
	  Connection con = null;
	  try {
	  Driver driverref=new Driver();
	  DriverManager.registerDriver(driverref);
	  
	  //step2: establish connection with database
	  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customers", "root","root");
	  
	  //step3: Issue create statement
	  Statement stat = con.createStatement();
	  
	  //step4:Execute any query
	  int res = stat.executeUpdate("insert into customer value('Soumya','Soumyasanta Sahoo','Jharsuguda','Brajrajnagar',768216,'India')");
	  //stat.executeUpdate("delete from customer where CustomerName in 'raghvandra';");
	  //int res = stat.executeUpdate("commit;");
	  if(res==1) {
	   System.out.println("Project is successfully Created");
	  }
	  else {
	   System.out.println("query failed");
	  }
	  }
	  catch(Exception e) {
	   
	  }
	  finally {
	  //step5:close database connection
	  con.close();
	  System.out.println("database closed");
	  }
	 }*/
	
	@Test
	 public void getExecuteUpdate() throws SQLException{
	  //step1: resister the database
	  Connection con = null;
	  try {
	  Driver driverref=new Driver();
	  DriverManager.registerDriver(driverref);
	  
	  //step2: establish connection with database
	  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customers", "root","root");
	  
	  //step3: Issue create statement
	  Statement stat = con.createStatement();
	  
	  //step4:Execute any query
	  //int res = stat.executeUpdate("insert into customer value('Soumya','Soumyasanta Sahoo','Jharsuguda','Brajrajnagar',768216,'India')");
	  stat.executeUpdate("delete from customer where CustomerName in 'Soumya';");
	  int res = stat.executeUpdate("commit;");
	  if(res==1) {
	   System.out.println("Project is successfully Updated");
	  }
	  else {
	   System.out.println("query failed");
	  }
	  }
	  catch(Exception e) {
	   
	  }
	  finally {
	  //step5:close database connection
	  con.close();
	  System.out.println("database closed");
	  }
	 }
	
}
