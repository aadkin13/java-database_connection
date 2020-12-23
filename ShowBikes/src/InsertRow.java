import java.sql.*;

public class InsertRow {
	void insertRow(Connection conn, String dbName, String tableName,String tableKey, String tableValue) throws SQLException{
		Statement stmt = null;
		stmt=conn.createStatement();
		String sql = "INSERT INTO "+dbName+"."+tableName+" ("+tableKey+") VALUES ("+tableValue+");";
		stmt.executeUpdate(sql);
	}
}
