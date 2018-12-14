package jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class ConnectionDemo {
	
	 // JDBC 椹卞姩鍚嶅強鏁版嵁搴� URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/information_schema";
 
    // 鏁版嵁搴撶殑鐢ㄦ埛鍚嶄笌瀵嗙爜锛岄渶瑕佹牴鎹嚜宸辩殑璁剧疆
    static final String USER = "root";
    static final String PASS = "000000";
 
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            // 娉ㄥ唽 JDBC 椹卞姩
            Driver driver =(Driver) Class.forName(JDBC_DRIVER).newInstance();
            DriverManager.registerDriver(driver);
            // 鎵撳紑閾炬帴
            System.out.println("杩炴帴鏁版嵁搴�...");
             Enumeration<Driver>    drivernum =DriverManager.getDrivers();
            while (drivernum.hasMoreElements()) {
				Driver driver1= drivernum.nextElement();
				System.out.println(driver1.getClass().getName());
			}
            
  
         
            
            
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
            // 鎵ц鏌ヨ
            System.out.println(" 瀹炰緥鍖朣tatement瀵硅薄...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT DISTINCT COLUMN_NAME FROM `COLUMNS` WHERE TABLE_NAME  in (\"archive_detail\",\"archive_attach\",\"archive\");";//,\"archive_detail
            ResultSet rs = stmt.executeQuery(sql);
            
            // 灞曞紑缁撴灉闆嗘暟鎹簱
            Map<String,Object> map=new HashMap();
            while(rs.next()){
                // 閫氳繃瀛楁妫�绱�
            	String str=rs.getString("COLUMN_NAME");
            	
            	while (str.indexOf("_")!=-1) {
            		
            	Character	cha=str.charAt(str.indexOf("_")+1);
            		
            		str=str.replaceAll("_"+cha,(cha.toString().toUpperCase()));
				}
            	map.put(str,"");
               //System.out.println( rs.getString("COLUMN_NAME"));
            }
            System.out.println(map.size());
            Gson gson = new Gson();  
            System.out.println(
            		  gson.toJson(map)
            		);
            // 瀹屾垚鍚庡叧闂�
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 澶勭悊 JDBC 閿欒
            se.printStackTrace();
        }catch(Exception e){
            // 澶勭悊 Class.forName 閿欒
            e.printStackTrace();
        }finally{
            // 鍏抽棴璧勬簮
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 浠�涔堥兘涓嶅仛
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
	
}	
