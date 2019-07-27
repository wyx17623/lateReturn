package com.gxuwz.bean.BO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.base.database;
import com.gxuwz.bean.vo.listlateReturn;

/**
 * 
 * @author 时间：2019年6月12日下午10:41:26 Description: 晚归处理类
 */
public class actionlateReturn {
	private String lateReturnID;
	private String stuID;
	private String dormID;
	private String bedID;
	private String lateReturnTime;
	private String lateReturnReason;

	public actionlateReturn() {
		super();
	}

	public actionlateReturn(String lateReturnID, String stuID, String dormID,
			String bedID, String lateReturnTime, String lateReturnReason) {
		super();
		this.lateReturnID = lateReturnID;
		this.stuID = stuID;
		this.dormID = dormID;
		this.bedID = bedID;
		this.lateReturnTime = lateReturnTime;
		this.lateReturnReason = lateReturnReason;
	}

	public String getlateReturnID() {
		return lateReturnID;
	}

	public void setlateReturnID(String lateReturnID) {
		this.lateReturnID = lateReturnID;
	}

	public String getStuID() {
		return stuID;
	}

	public void setStuID(String stuID) {
		this.stuID = stuID;
	}

	public String getDormID() {
		return dormID;
	}

	public void setDormID(String dormID) {
		this.dormID = dormID;
	}

	public String getBedID() {
		return bedID;
	}

	public void setBedID(String bedID) {
		this.bedID = bedID;
	}

	public String getlateReturnTime() {
		return lateReturnTime;
	}

	public void setlateReturnTime(String lateReturnTime) {
		this.lateReturnTime = lateReturnTime;
	}

	public String getlateReturnReason() {
		return lateReturnReason;
	}

	public void setlateReturnReason(String lateReturnReason) {
		this.lateReturnReason = lateReturnReason;
	}
     /*
      * 
      * 宿管员的查询学生晚归方法
      */
	public List<listlateReturn> listlateReturn(String houseparentID) throws Exception {
		String sql = "select lateReturnID,a.stuID,stuName,a.dormID,dormName,a.bedID,lateReturnTime,lateReturnReason"
				+ " from sys_latereturn a left join  sys_dorm b on  a.dormID=b.dormID LEFT JOIN sys_student c on a.stuID=c.stuID "
				+ " LEFT JOIN sys_houseparent d on b.dormBuildingID=d.dormBuildingID"
				+ " where d.houseparentID=?";

		// 获取数据库链接
		Connection conn = database.getConn();

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, houseparentID);
		ResultSet rs = pstmt.executeQuery();
		//
		List<listlateReturn> ls = new ArrayList<listlateReturn>();
		while (rs.next()) {
			lateReturnID = rs.getString("lateReturnID");
			String stuName = rs.getString("stuName");
			       stuID = rs.getString("stuID");
			       dormID = rs.getString("dormID");
			String dormName = rs.getString("dormName");
			String bedID = rs.getString("bedID");
			String lateReturnTime = rs.getString("lateReturnTime");
			String lateReturnReason = rs.getString("lateReturnReason");
			listlateReturn sl = new listlateReturn( lateReturnID,  stuID,  stuName, dormID,  dormName,  bedID, lateReturnTime,  lateReturnReason);
			ls.add(sl);

		}
		database.close(pstmt, conn);
		return ls;
	}
	
	/*
	 * 
	 * 
	 * 
	 * 教师统计自己带班的所有学生的晚归情况
	 */
	public List<listlateReturn> listTeacherlateReturn(String teacherID) throws Exception {
		
              return listTeacherlateReturn(teacherID, null);

	}//教师统计晚归情况：按班级统计
	public List<listlateReturn> listTeacherlateReturn(String teacherID,String classID) throws Exception {
		String sql=null;
		if(classID==null){
			sql = "select lateReturnID,a.stuID,stuName,a.dormID,dormName,a.bedID,lateReturnTime,lateReturnReason "
					+ " from sys_latereturn a left join  sys_dorm b on  a.dormID=b.dormID LEFT JOIN sys_student c on a.stuID=c.stuID "
					+ " LEFT JOIN sys_classes d on c.classID=d.classID"
					+ " where d.teacherID=?";
		}
		if(classID!=null){
			sql = "select lateReturnID,a.stuID,stuName,a.dormID,dormName,a.bedID,lateReturnTime,lateReturnReason "
					+ " from sys_latereturn a left join  sys_dorm b on  a.dormID=b.dormID LEFT JOIN sys_student c on a.stuID=c.stuID "
					+ " LEFT JOIN sys_classes d on c.classID=d.classID"
					+ " where d.teacherID=? and d.classID=?";
		}
	// 获取数据库链接
	Connection conn = database.getConn();
         int index=1;
	PreparedStatement pstmt = conn.prepareStatement(sql);
	if(classID==null){
	pstmt.setString(index, teacherID);
	}
	if(classID!=null){
		pstmt.setString(index++, teacherID);
		pstmt.setString(index, classID);
		}
	ResultSet rs = pstmt.executeQuery();
	//
	List<listlateReturn> ls = new ArrayList<listlateReturn>();
	while (rs.next()) {
		lateReturnID = rs.getString("lateReturnID");
		String stuName = rs.getString("stuName");
		       stuID = rs.getString("stuID");
		       dormID = rs.getString("dormID");
		String dormName = rs.getString("dormName");
		String bedID = rs.getString("bedID");
		String lateReturnTime = rs.getString("lateReturnTime");
		String lateReturnReason = rs.getString("lateReturnReason");
		listlateReturn sl = new listlateReturn( lateReturnID,  stuID,  stuName, dormID,  dormName,  bedID, lateReturnTime,  lateReturnReason);
		ls.add(sl);
	}
	database.close(pstmt, conn);
	return ls;
}  /*
    *学生查询个人晚归信息
    */
	public List<listlateReturn> listStulateReturn(String stuID) throws Exception {
		String sql ="select lateReturnID,a.stuID,stuName,a.dormID,dormName,a.bedID,lateReturnTime,lateReturnReason"+
				" from sys_latereturn a LEFT JOIN sys_dorm b ON a.dormID=b.dormID LEFT JOIN sys_student c on a.stuID=c.stuID "+
				" LEFT JOIN sys_houseparent d ON b.dormBuildingID=d.dormBuildingID "+
				"where a.stuID=?";

		// 获取数据库链接
		Connection conn = database.getConn();

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, stuID);
		ResultSet rs = pstmt.executeQuery();
		//
		List<listlateReturn> ls = new ArrayList<listlateReturn>();
		while (rs.next()) {
			lateReturnID = rs.getString("lateReturnID");
			String stuName = rs.getString("stuName");
			       stuID = rs.getString("stuID");
			       dormID = rs.getString("dormID");
			String dormName = rs.getString("dormName");
			String bedID = rs.getString("bedID");
			String lateReturnTime = rs.getString("lateReturnTime");
			String lateReturnReason = rs.getString("lateReturnReason");
			listlateReturn sl = new listlateReturn( lateReturnID,  stuID,  stuName, dormID,  dormName,  bedID, lateReturnTime,  lateReturnReason);
			ls.add(sl);

		}
		database.close(pstmt, conn);
		return ls;
	}
	/*
	 * 
	 * 
	 * 
	 * 
	 * 宿管员添加晚归记录
	 */
	public void addlateReturn() throws Exception {

		String sql = "insert into sys_lateReturn(lateReturnID,stuID,dormID,bedID,lateReturnTime,lateReturnReason) values(?,?,?,?,?,?)";
		Connection conn = database.getConn();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int Index = 1;
		pstmt.setString(Index++, lateReturnID);
		pstmt.setString(Index++, stuID);
		pstmt.setString(Index++, dormID);
		pstmt.setString(Index++, bedID);
		pstmt.setString(Index++, lateReturnTime);
		pstmt.setString(Index++, lateReturnReason);
		pstmt.executeUpdate();
		// 定义int序号变量

		database.close(pstmt, conn);

	}

	/*
	 * 
	 *  
	 *  
	 *  宿管员修改晚归记录处理
	 */
	public void updatelateReturn() throws Exception {

		String sql = "update sys_lateReturn set stuID=?,dormID=?,bedID=? ,lateReturnTime=?,lateReturnReason=? where lateReturnID=?";

		Connection conn = database.getConn();

		PreparedStatement pstmt = conn.prepareStatement(sql);
		int Index = 1;
		pstmt.setString(Index++, stuID);
		pstmt.setString(Index++, dormID);
		pstmt.setString(Index++, bedID);
		pstmt.setString(Index++, lateReturnTime);
		pstmt.setString(Index++, lateReturnReason);
		pstmt.setString(Index++, lateReturnID);
		pstmt.executeUpdate();
		
		database.close(pstmt, conn);

	}

	/*
	 * 
	 *  
	 *  
	 *  宿管员删除晚归记录处理
	 */
	public void removelateReturn(String lateReturnID) throws Exception {
		Connection conn = database.getConn();
		String sql = "delete from sys_lateReturn where lateReturnID=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		int parameterIndex = 1;
		pstmt.setString(parameterIndex, lateReturnID);

		int count = pstmt.executeUpdate();

		database.close(pstmt, conn);
	}
}
