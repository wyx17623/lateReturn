package com.gxuwz.bean.BO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.base.database;
import com.gxuwz.bean.vo.listclasses;

/**
 * 
 * @author 
 * ʱ�䣺2019��6��11������3:45:38
 * Description:�༶��ɾ�Ĳ鴦����
 */
public class actionclass {
	private String classID ;//ѧ��
	private String className ;//ѧ������
	private String grade ;//�꼶
	private String depID;//ѧԺID
	private String teacherID;//��ʦID
	public String getDepID() {
		return depID;
	}
	public void setDepID(String depID) {
		this.depID = depID;
	}
	public String getTeacherID() {
		return teacherID;
	}
	public actionclass(String classID, String className, String grade,
			String depID, String teacherID) {
		super();
		this.classID = classID;
		this.className = className;
		this.grade = grade;
		this.depID = depID;
		this.teacherID = teacherID;
	}
	public void setTeacherID(String teacherID) {
		this.teacherID = teacherID;
	}
	public String getClassID() {
		return classID;
	}
	public actionclass() {
		super();
	}
	
	public void setClassID(String classID) {
		this.classID = classID;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	/*
	 * ϵͳ����Ա��ѯ���а༶��Ϣ
	 */
  public List<listclasses> listclasses () throws Exception{
		String sql = "select sys_classes.classID,className,grade,depName,teacherName "
				+ "from sys_classes LEFT JOIN sys_department on sys_classes.depID=sys_department.depID LEFT JOIN sys_teacher on "
				+ "sys_teacher.teacherID=sys_classes.teacherID";
//��ȡ���ݿ�����
Connection conn = database.getConn();

PreparedStatement pstmt = conn.prepareStatement(sql);

ResultSet rs = pstmt.executeQuery();
//����һ��List�洢���а༶����
List<listclasses> ls =new ArrayList<listclasses>();
while (rs.next()) {
classID=rs.getString("classID");
className=rs.getString("className");		
grade =rs.getString("grade");
String depName=rs.getString("depName");
String teacherName=rs.getString("teacherName");
//����һ��listclasses����
listclasses sl =new listclasses(classID, className,grade ,depName,teacherName);
//��������뵽list��
ls.add(sl);

}
//�ر����ݿ�����
database.close(pstmt, conn);
	  return ls;
  }
  /*
   * ϵͳ����Ա��Ӱ༶�ķ���
   */
  public void  addclasses () throws Exception{
      
	  String sql="insert into sys_classes(classID,className,grade,depID,teacherID) values(?,?,?,?,?)";

	  Connection conn = database.getConn();

	  PreparedStatement pstmt = conn.prepareStatement(sql);
	  int Index=1;
	   pstmt.setString(Index++, classID);
	   pstmt.setString(Index++, className); 
	   pstmt.setString(Index++, grade);
	   pstmt.setString(Index++, depID);
	   pstmt.setString(Index++, teacherID);
	   pstmt.executeUpdate();
	  //����int��ű���

	   database.close(pstmt, conn);
	  	  
	    }
  /*
   * ϵͳ����Ա�޸İ༶ҵ����
   */
public void  updateclasses () throws Exception{
      
	  String sql="update sys_classes set className=?,grade=?,depID=? ,teacherID=? where classID=?";

	  Connection conn = database.getConn();

	  PreparedStatement pstmt = conn.prepareStatement(sql);
	  int Index=1;
	   pstmt.setString(Index++, className);
	   pstmt.setString(Index++, grade);
	   pstmt.setString(Index++, depID);
	   pstmt.setString(Index++, teacherID);
	   pstmt.setString(Index++, classID);
	   pstmt.executeUpdate();
	   database.close(pstmt, conn);
 
	    }
/*
 * ϵͳ����Աɾ���༶ҵ����
 */
public void removeclasses(String classID) throws Exception{
	Connection conn = database.getConn();
	  String sql="delete from sys_classes where classID=?";
	  
	   PreparedStatement pstmt=conn.prepareStatement(sql);
	  
	   int parameterIndex=1;
	   pstmt.setString(parameterIndex, classID);
	  
	   int count=pstmt.executeUpdate();
	
	    database.close(pstmt, conn);
}
}
