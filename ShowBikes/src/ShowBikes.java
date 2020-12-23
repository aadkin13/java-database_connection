import java.sql.*;
import java.util.*;

public class ShowBikes {
	
	void searchDB(Connection conn, String dbName, String tableName) throws SQLException{
		SearchTable search = new SearchTable();
		Scanner input = new Scanner(System.in);
		Statement stmnt = null;
		stmnt = conn.createStatement();
		ResultSet rs = null;
		String[] tableColumns = {"type", "gearNum", "wheelBase", "height", "color", "constMat"};
		String searchInfo = null;
		List<String> columns = new ArrayList<>();
		List<String> columnData = new ArrayList<>();
		
		for(int i = 0; i < tableColumns.length; i++) {
			System.out.println(i+" "+tableColumns[i]);
		}
		
		System.out.println("enter the number of the column you would like to search (enter -1 to quit): ");
		int choose = input.nextInt();
		while(choose != -1) {
			columns.add(tableColumns[choose]);
			if(choose == 0) {
				System.out.println("what would you like to search in type (put info to get data): ");
				searchInfo = input.next();
				if(searchInfo.equals("info")) {
					
				}else {
					columnData.add(searchInfo);
				}
				
			}else if(choose == 1) {
				System.out.println("what would you like to search in gearNum (put info to get data): ");
				searchInfo = input.next();
				if(searchInfo.equals("info")) {
					
				}else {
					columnData.add(searchInfo);
				}
			}else if(choose == 2) {
				System.out.println("what would you like to search in wheelBase (put info to get data): ");
				searchInfo = input.next();
				if(searchInfo.equals("info")) {
					
				}else {
					columnData.add(searchInfo);
				}
			}else if(choose == 3) {
				System.out.println("what would you like to search in height (put info to get data): ");
				searchInfo = input.next();
				if(searchInfo.equals("info")) {
					
				}else {
					columnData.add(searchInfo);
				}
			}else if(choose == 4) {
				System.out.println("what would you like to search in color (put info to get data): ");
				searchInfo = input.next();
				if(searchInfo.equals("info")) {
					
				}else {
					columnData.add(searchInfo);
				}
			}else if(choose == 5) {
				System.out.println("what would you like to search in constMat (put info to get data): ");
				searchInfo = input.next();
				if(searchInfo.equals("info")) {
					
				}else {
					columnData.add(searchInfo);
				}
			}
			System.out.println("enter the number of the column you would like to search (enter -1 to quit): ");
			choose = input.nextInt();
		}
		search.search(conn, rs, stmnt, dbName, tableName, columns, columnData);
	}
}


	


