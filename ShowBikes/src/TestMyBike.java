import java.sql.*;
import java.util.*;

public class TestMyBike {
	public static void main(String[] args) throws Exception{
		
		
		String url ="jdbc:mysql://localhost:3306";
		String username="root";
		String password ="buckey3s";
		String dbName="bicycles";
		String tableName="attributes";
		
		String[] type= {"mountain_bike","race_bike","street_bike"};
		String[] color= {"steel","red","blue","black"};
		String[] constMat= {"carbon","steel","aluminium"};
		String delimiter1="\",\"";
		String delimiter2="\"";
		
		Database db = new Database();
		InsertRow ir = new InsertRow();
		DeleteRow dr = new DeleteRow();
		SearchTable st = new SearchTable();
		ShowBikes sb = new ShowBikes();
		Scanner input = new Scanner(System.in);
		
		Statement stmnt = null;
		ResultSet resultSet = null;
		
		try {
			Connection conn = db.serverConnect(url, username, password);
			stmnt = conn.createStatement();
			resultSet = conn.getMetaData().getCatalogs();
			
			// checks to see if database already exists
			while(resultSet.next()) {
				String dataBaseName = resultSet.getString(1);
				if(dataBaseName.equals(dbName)) {
					break;
				}else {
					db.createDatabase(conn, dbName);
					db.createTable(conn, dbName, tableName,"type varchar(45)","gearNum int","wheelBase int", "height int","color varchar(45)","constMat varchar(45)" );
					for(int i = 0; i<type.length;i++) {
						for(int j =4; j<=10;j++) {
							for(int k=36; k<=60;k+=6) {
								for(int l =1;l<=4;l++) {
									for(int m =0;m<color.length;m++) {
										for(int n=0;n<constMat.length;n++) {
											String tableValue=delimiter2+type[i]+delimiter1+String.valueOf(j)+delimiter1+String.valueOf(k)+delimiter1+String.valueOf(l)+
													delimiter1+color[m]+delimiter1+constMat[n]+delimiter2;
											db.insertRow(conn, dbName, tableName, "type,gearNum,wheelBase,height,color,constMat",tableValue);
										}
									}
								}
							}
						}
					}
					break;
				}
			}
			
			// prompting for user input
			System.out.println("Please choose an option (enter -1 to end):\n1. Insert Row\n2. Delete Row\n3. Search\n4. Display Database");
			int choose = input.nextInt();
			while(choose != -1) {
				switch(choose) {
				case 1: // insert row case
					int i = 0;
					String[] value = new String[6];
					System.out.println("enter data for type, gearNum, wheelBase, height, color, constMat");
					while(i < 6) {
						value[i] = input.next();
						i++;
					}
					String dbValue = delimiter2+value[0]+delimiter1+value[1]+delimiter1+value[2]+delimiter1+value[3]+
							delimiter1+value[4]+delimiter1+value[5]+delimiter2;
					ir.insertRow(conn, dbName, tableName, "type, gearNum, wheelBase, height, color, constMat", dbValue);
					break;
				case 2: // delete row case
					System.out.println("enter the data for type, gearNum, wheelBase, height, color, constMat");
					String[] deleteValues = new String[6];
					String[] tableKey = {"type","gearNum","wheelBase","height","color","constMat"};
					int j = 0;
					while(j < 6) {
						deleteValues[j] = input.next();
						j++;
					}
					dr.deleteRow(conn, dbName, tableName, tableKey, deleteValues);
					break;
				case 3: // search database case
					sb.searchDB(conn, dbName, tableName);
					break;
				case 4: // display the whole database
					String sql = "select * from "+dbName+"."+tableName+";";
					resultSet = stmnt.executeQuery(sql);
					while(resultSet.next()) {
						System.out.println(resultSet.getString(1)+" "+ resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4)+" "+resultSet.getString(5)+" "+resultSet.getString(6));
					}
					break;
				}
				System.out.println("Please choose an option (enter -1 to end):\n1. Insert Row\n2. Delete Row\n3. Search\n4. Display Database");
				choose = input.nextInt();
			}
			
			db.serverDisconnect(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
