<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.gxuwz.bean.BO.SelectDepName" %>
<%@ page language="java" import="com.gxuwz.bean.entity.sys_department" %>
<%@ page language="java" import="com.gxuwz.bean.BO.SelectTeacher" %>
<%@ page language="java" import="com.gxuwz.bean.entity.sys_teacher"%>
<%@ page language="java" import="java.sql.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>班级添加</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<link rel="shortcut icon" href="images/logo.jpg">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>

</head>

<body>
<%  
    SelectDepName sd =new SelectDepName();
       List<sys_department> list = sd.getDepName();
       SelectTeacher st =new SelectTeacher();
       List<sys_teacher> list1 = st.getTeacher(); 
     
    %>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加班级</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="servlet/classServlet?type=add">  
      <div class="form-group">
        <div class="label">
          <label>班级编号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="classID"   />
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>班级名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="className"   />
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>年级：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="grade"   />
          <div class="tips"></div>
        </div>
      </div>
        <div class="form-group">
        <div class="label">
          <label>所属学院：</label>
        </div>
         <select name="depID" class="input w50" onchange="changesearch()" style="width:180px; line-height:17px; display:inline-block">
             <option value="">选择</option>
             <%
             %>
        <%
        
        Iterator<sys_department> it = list.iterator();
		while(it.hasNext()){
			sys_department st1 = (sys_department) it.next();
			String depID =st1.getDepID();
			String depName =st1.getDepName();
        %>       
             <option value="<%=depID%>"><%=depName %></option>
      <%} %>
      </select></div>   
       <div class="form-group">
        <div class="label">
          <label>带班老师：</label>
        </div>
         <select name="teacherID" class="input w50" onchange="changesearch()" style="width:180px; line-height:17px; display:inline-block">
             <option value="">选择</option>
             <%
             %>
        <%
        
        Iterator<sys_teacher> it1 = list1.iterator();
		while(it1.hasNext()){
			sys_teacher s = (sys_teacher) it1.next();
			String teacherID =s.getTeacherID();
			
			String teacherName =s.getTeacherName();
        %>       
             <option value="<%=teacherID%>"><%=teacherName %></option>
            
      <%} %>
      </select></div>
     <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
        </div>
      </div> </form>
      </div>
    
  </div>


</body>
</html>
