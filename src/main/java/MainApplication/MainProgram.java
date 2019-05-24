package MainApplication;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MainProgram {

	/*public static void main(String[] args) {
		 Connection connect=ConnectionClass.dbConnect();
		 System.out.println("gata");
		 Statement statement = null;
		 try {
			 statement = connect.createStatement();
			 String sql = "INSERT INTO DEPT " +
	                   "VALUES (230,'Banking')";
			 statement.executeUpdate(sql);
		 }
	 catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(statement!=null)
	        	 connect.close();
	      }catch(SQLException se){
	      }// do nothing
	      try{
	         if(connect!=null)
	        	 connect.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
	}
*/
}
