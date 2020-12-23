import java.sql.*;

public class DeleteRow {
	void deleteRow(Connection conn, String dbName, String tableName, String[] tableKey, String[] tableValue) throws SQLException{
		Statement stmt = null;
		stmt = conn.createStatement();
		String sql = "DELETE FROM "+dbName+"."+tableName+" WHERE "+tableKey[0]+"= '"+tableValue[0]+"' AND "+tableKey[2]+"= '"+tableValue[2]+
				"' AND "+tableKey[3]+"= '"+tableValue[3]+"' AND "+tableKey[4]+"= '"+tableValue[4]+"' AND "+tableKey[5]+"= '"+tableValue[5]+"';";
		stmt.executeUpdate(sql);
	}

}
