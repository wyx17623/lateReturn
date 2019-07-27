package com.gxuwz.bean.BO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.base.database;
import com.gxuwz.bean.entity.sys_dormbuilding;

/*
 * 查询所有班级宿舍楼姓名
 */
public class SelectDormBuildingName {
	 List<sys_dormbuilding> list =new ArrayList<sys_dormbuilding>();
     
		public List<sys_dormbuilding>  getDormBuildingName() throws Exception{
			Connection conn= database.getConn();
			String sql="select * from sys_dormbuilding";
			PreparedStatement pstmt = conn.prepareStatement(sql);
		
			ResultSet rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
			String  dormBuildingID=rs.getString("dormBuildingID");
			String  dormBuildingName=rs.getString("dormBuildingName");
			sys_dormbuilding sd = new sys_dormbuilding(dormBuildingID, dormBuildingName);
			list.add(sd);
			}
			return list;
			
		}
		
}
