package com.gxuwz.bean.BO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.base.database;
import com.gxuwz.bean.vo.listhouseparent;

public class actionhouseparent {

	private String houseparentID;
	private String houseparentName;
	private String sex;
	private String houTel;
	private String dormBuildingID;

	public actionhouseparent(String houseparentID, String houseparentName,
			String sex, String houTel, String dormBuildingID) {
		super();
		this.houseparentID = houseparentID;
		this.houseparentName = houseparentName;
		this.sex = sex;
		this.houTel = houTel;
		this.dormBuildingID = dormBuildingID;
	}

	public String getHouseparentID() {
		return houseparentID;
	}

	public void setHouseparentID(String houseparentID) {
		this.houseparentID = houseparentID;
	}

	public String getHouseparentName() {
		return houseparentName;
	}

	public void setHouseparentName(String houseparentName) {
		this.houseparentName = houseparentName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getHouTel() {
		return houTel;
	}

	public void setHouTel(String houTel) {
		this.houTel = houTel;
	}

	public String getDormBuildingID() {
		return dormBuildingID;
	}

	public void setDormBuildingID(String dormBuildingID) {
		this.dormBuildingID = dormBuildingID;
	}

	public actionhouseparent() {

	}
/* 
 * ϵͳ����Ա �����������Ա
 */
	public void addhouseparent() throws Exception {

		Connection conn = database.getConn();
		String sql = "insert into sys_houseparent(houseparentID, houseparentName,sex,houTel,dormBuildingID)values(?,?,?,?,?)";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		int index = 1;
		pstmt.setString(index++, houseparentID);
		pstmt.setString(index++, houseparentName);
		pstmt.setString(index++, sex);
		pstmt.setString(index++, houTel);
		pstmt.setString(index++, dormBuildingID);

		int count = pstmt.executeUpdate();
		// �ر����ݿ�������Դ
		database.close(pstmt, conn);

	}
/*
 * ϵͳ����Ա�޸��޹�Ա
 */
	public void updatehouseparent() throws Exception {
		Connection conn = database.getConn();
		String sql = "update sys_houseparent set houseparentName=?,sex=?,houTel=? ,dormBuildingID=? where houseparentID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int index = 1;
		pstmt.setString(index++, houseparentName);
		pstmt.setString(index++, sex);
		pstmt.setString(index++, houTel);
		pstmt.setString(index++, dormBuildingID);
		pstmt.setString(index++, houseparentID);
		// ִ��SQL������ִ�н��
		int count = pstmt.executeUpdate();
		// �ر����ݿ�������Դ
		database.close(pstmt, conn);
	}
/*
 * ϵͳ����Ա�޸��������Ա
 */
	public void removehouseparent(String houseparentID) throws Exception {
		Connection conn = database.getConn();
		String sql = "delete from sys_houseparent where houseparentID=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		int parameterIndex = 1;
		pstmt.setString(parameterIndex, houseparentID);

		int count = pstmt.executeUpdate();

		database.close(pstmt, conn);
	}
/*
 * ϵͳ����Ա��ѯ�����޹�Ա����
 * 
 * 
 * 
 * 
 * 
 * 
 * ע��˷��������������β�ѯ�����ǲ��������ӣ������������Ӵ���
 */
	public List<listhouseparent> listhouseparent() throws Exception {
		
		String sql1 = null;
		String sql2 = null;
		
			sql1 = "select houseparentID, houseparentName, sex, houTel ,dormBuildingName from sys_houseparent,sys_dormbuilding where sys_houseparent.dormBuildingID=sys_dormbuilding.dormBuildingID ";
			sql2 = "select houseparentID, houseparentName, sex, houTel ,dormBuildingID from sys_houseparent where dormBuildingID is null or dormBuildingID=''";
		Connection conn = database.getConn();
		PreparedStatement pstmt = conn.prepareStatement(sql1);
		PreparedStatement pstmt1 = conn.prepareStatement(sql2);

		// PrepareStatement���͵Ķ���pstmtִ��SQL��ѯ��䲢���ؽ��
		ResultSet rs = pstmt.executeQuery();
		ResultSet rs1 = pstmt1.executeQuery();
		List<listhouseparent> ls = new ArrayList<listhouseparent>();
		while (rs.next()) {
			houseparentID = rs.getString("houseparentID");
			houseparentName = rs.getString("houseparentName");
			sex = rs.getString("sex");
			houTel = rs.getString("houTel");
			String dormBuildingName = rs.getString("dormBuildingName");

			listhouseparent sl = new listhouseparent(houseparentID,houseparentName, sex, houTel, dormBuildingName);
			ls.add(sl);

		}
		while (rs1.next()) {
			houseparentID = rs1.getString("houseparentID");
			houseparentName = rs1.getString("houseparentName");
			sex = rs1.getString("sex");
			houTel = rs1.getString("houTel");
			String dormBuildingName = rs1.getString("dormBuildingID");

			listhouseparent sl = new listhouseparent(houseparentID,houseparentName, sex, houTel, dormBuildingName);
			ls.add(sl);

		}
		return ls;
	}
	/*
	 * �޹�Ա������Ϣ�鿴
	 * 
	 * 
	 */
	public List<listhouseparent> listhouseparentpersonal(String houseparentID)
			throws Exception {

		String sql1 = null;
			sql1 = "select houseparentID, houseparentName, sex, houTel ,dormBuildingName from sys_houseparent,sys_dormbuilding "
					+ "where sys_houseparent.dormBuildingID=sys_dormbuilding.dormBuildingID and houseparentID=?";
		Connection conn = database.getConn();
		PreparedStatement pstmt = conn.prepareStatement(sql1);
		pstmt.setString(1, houseparentID);
		// PrepareStatement���͵Ķ���pstmtִ��SQL��ѯ��䲢���ؽ��
		ResultSet rs = pstmt.executeQuery();

		List<listhouseparent> ls = new ArrayList<listhouseparent>();
		while (rs.next()) {
			houseparentID = rs.getString("houseparentID");
			houseparentName = rs.getString("houseparentName");
			sex = rs.getString("sex");
			houTel = rs.getString("houTel");
			String dormBuildingName = rs.getString("dormBuildingName");

			listhouseparent sl = new listhouseparent(houseparentID,houseparentName, sex, houTel, dormBuildingName);
			ls.add(sl);

		}
		return ls;
	}
	/*
	 * �޹�Ա�޸ĸ�����Ϣ����
	 * 
	 * 
	 */
	public void updatehouseparentpersonal() throws Exception {
		Connection conn = database.getConn();
		String sql = "update sys_houseparent set houseparentName=?,sex=?,houTel=? ,dormBuildingID=? where houseparentID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int index = 1;
		pstmt.setString(index++, houseparentName);
		pstmt.setString(index++, sex);
		pstmt.setString(index++, houTel);
		pstmt.setString(index++, dormBuildingID);
		pstmt.setString(index++, houseparentID);
		// ִ��SQL������ִ�н��
		int count = pstmt.executeUpdate();
		// �ر����ݿ�������Դ
		database.close(pstmt, conn);
	}
}
