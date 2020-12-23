import java.sql.*;

public class Database {
	//Connect to Server 
		Connection serverConnect(String url,String username, String password) throws SQLException {
			Connection conn=null;
			conn=DriverManager.getConnection(url,username,password);
			return conn;
		}
		
		//Disconnect Server
		void serverDisconnect(Connection conn) throws SQLException{
			conn.close();
		}
		
		//Drop Database
		void dropDatabase(Connection conn, String dbName)throws SQLException{
			Statement stmt=null;
			stmt=conn.createStatement();
			String sql="DROP DATABASE IF EXISTS "+ dbName+";";
			stmt.executeUpdate(sql);
		}
		
		
		//Create a Database
		void createDatabase(Connection conn,String dbName) throws SQLException {
			Statement stmt = null;
			stmt=conn.createStatement();
			String sql= "CREATE DATABASE "+dbName+";";
			stmt.executeUpdate(sql);
		}
		
		//Create Table
		void createTable(Connection conn, String dbName, String tableName, String... tableColumns) throws SQLException {
			Statement stmt = null;
			StringBuilder columnData = new StringBuilder();
			for(String tableColumn:tableColumns) {
				if(columnData.length()!=0) {
					columnData.append(",");
				}
				columnData.append(tableColumn);
			}
			stmt= conn.createStatement();
			String sql = "CREATE TABLE "+dbName+"."+tableName+" ( "+columnData+");";
			stmt.executeUpdate(sql);
		}
		
		void insertRow(Connection conn, String dbName, String tableName,String tableKey, String tableValue) throws SQLException{
			Statement stmt = null;
			stmt=conn.createStatement();
			String sql = "INSERT INTO "+dbName+"."+tableName+" ("+tableKey+") VALUES ("+tableValue+");";
			stmt.executeUpdate(sql);
		}
		
		void deleteRow(Connection conn, String dbName, String tableName, String tableKey, String tableValue) throws SQLException{
			Statement stmt = null;
			stmt = conn.createStatement();
			String sql = "DELETE FROM "+dbName+"."+tableName+" WHERE "+tableKey+"= '"+tableValue+"';";
			stmt.executeUpdate(sql);
		}
}
