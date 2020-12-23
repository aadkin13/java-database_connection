import java.sql.*;
import java.util.*;

public class SearchTable {
	
	void search(Connection conn, ResultSet rs, Statement stmnt, String dbName, String tableName, List columns, List columnData) throws SQLException{
		if(columns.size() == 1) {
			if(columnData.size() == 0) {
				String sql = "select "+columns.get(0)+" from "+dbName+"."+tableName+ ";";
				rs = stmnt.executeQuery(sql);
				while(rs.next()) {
					System.out.println(rs.getString(1));
				}
			}else {
				String sql = "select "+columns.get(0)+" from "+dbName+"."+tableName+" where "+columns.get(0)+" = '"+columnData.get(0)+"';";
				rs = stmnt.executeQuery(sql);
				while(rs.next()) {
					System.out.println(rs.getString(1));
				}
			}
			
		}
		if(columns.size() == 2) {
			if(columnData.size() == 1) {
				String sql = "select "+columns.get(0)+", "+columns.get(1)+" from "+dbName+"."+tableName+" where "+columns.get(0)+" = '"+columnData.get(0)+"';";
				rs = stmnt.executeQuery(sql);
				while(rs.next()) {
					System.out.println(rs.getString(1) + " " + rs.getString(2));
				}
			}else {
				String sql = "select "+columns.get(0)+", "+columns.get(1)+" from "+dbName+"."+tableName+" where "+columns.get(0)+" = '"+columnData.get(0)+"' and "+columns.get(1)+" = '"+columnData.get(1)+"';";
				rs = stmnt.executeQuery(sql);
				while(rs.next()) {
					System.out.println(rs.getString(1) + " " + rs.getString(2));
				}
			}
			
		}
		if(columns.size() == 3) {
			if(columnData.size() == 2) {
				String sql = "select "+columns.get(0)+", "+columns.get(1)+", "+ columns.get(2) + " from "+dbName+"."+tableName+" where "+columns.get(0)+" = '"+columnData.get(0)+"' and "+columns.get(1)+" = '"+columnData.get(1)+"' ;";
				rs = stmnt.executeQuery(sql);
				while(rs.next()) {
					System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
				}
			}
			else {
				String sql = "select "+columns.get(0)+", "+columns.get(1)+", "+ columns.get(2) + " from "+dbName+"."+tableName+" where "+columns.get(0)+" = '"+columnData.get(0)+"' and "+columns.get(1)+" = '"+columnData.get(1)+"' and " + 
						columns.get(2) + " = '" + columnData.get(2)+ "';";
				rs = stmnt.executeQuery(sql);
				while(rs.next()) {
					System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
				}	
			}
		}
		if(columns.size() == 4) {
			if(columnData.size() == 3) {
				String sql = "select "+columns.get(0)+", "+columns.get(1)+", "+ columns.get(2) + ", " + columns.get(3) +" from "+dbName+"."+tableName+" where "+columns.get(0)+" = '"+columnData.get(0)+"' and "+columns.get(1)+" = '"+
						columnData.get(1)+"' and " + columns.get(2) + " = " + columnData.get(2)+ ";";
				rs = stmnt.executeQuery(sql);
				while(rs.next()) {
					System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
				}
			}else {
				String sql = "select "+columns.get(0)+", "+columns.get(1)+", "+ columns.get(2) + ", " + columns.get(3) +" from "+dbName+"."+tableName+" where "+columns.get(0)+" = '"+columnData.get(0)+"' and "+columns.get(1)+" = '"+
						columnData.get(1)+"' and " + columns.get(2) + " = " + columnData.get(2)+ " and " + columns.get(3) + " = " + columnData.get(3) + ";";
				rs = stmnt.executeQuery(sql);
				while(rs.next()) {
					System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
				}
			}
			
		}
		if(columns.size() == 5) {
			if(columnData.size() == 4) {
				String sql = "select "+columns.get(0)+", "+columns.get(1)+", "+ columns.get(2) + ", " + columns.get(3) +"," + columns.get(4) + " from "+dbName+"."+tableName+" where "+columns.get(0)+" = '"+columnData.get(0)+"' and "+columns.get(1)+" = '"+
						columnData.get(1)+"' and " + columns.get(2) + " = " + columnData.get(2)+ " and " + columns.get(3) + " = " + columnData.get(3) + ";";
				rs = stmnt.executeQuery(sql);
				while(rs.next()) {
					System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5));
				}
			}else {
				String sql = "select "+columns.get(0)+", "+columns.get(1)+", "+ columns.get(2) + ", " + columns.get(3) +"," + columns.get(4) + " from "+dbName+"."+tableName+" where "+columns.get(0)+" = '"+columnData.get(0)+"' and "+columns.get(1)+" = '"+
						columnData.get(1)+"' and " + columns.get(2) + " = " + columnData.get(2)+ " and " + columns.get(3) + " = " + columnData.get(3) + " and " + columns.get(4) + " = " + columnData.get(4) + ";";
				rs = stmnt.executeQuery(sql);
				while(rs.next()) {
					System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5));
				}
			}
		}
		if(columns.size() == 6) {
			if(columnData.size() == 5) {
				String sql = "select "+columns.get(0)+", "+columns.get(1)+", "+ columns.get(2) + ", " + columns.get(3) +"," + columns.get(4) + ", " + columns.get(5) + " from "+dbName+"."+tableName+" where "+
						columns.get(0)+" = '"+columnData.get(0)+"' and "+columns.get(1)+" = '"+columnData.get(1)+"' and " + columns.get(2) + " = " + columnData.get(2)+ " and " + columns.get(3) + " = " + columnData.get(3) + " and " + 
						columns.get(4) + " = " + columnData.get(4) + " ;";
				rs = stmnt.executeQuery(sql);
				while(rs.next()) {
					System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6));
				}
			}else {
				String sql = "select "+columns.get(0)+", "+columns.get(1)+", "+ columns.get(2) + ", " + columns.get(3) +"," + columns.get(4) + ", " + columns.get(5) + " from "+dbName+"."+tableName+" where "+
						columns.get(0)+" = '"+columnData.get(0)+"' and "+columns.get(1)+" = '"+columnData.get(1)+"' and " + columns.get(2) + " = " + columnData.get(2)+ " and " + columns.get(3) + " = " + columnData.get(3) + " and " + 
						columns.get(4) + " = " + columnData.get(4) + " and " + columns.get(5) + " = " + columnData.get(5) + ";";
				rs = stmnt.executeQuery(sql);
				while(rs.next()) {
					System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6));
				}
			}
		}
	}

}
