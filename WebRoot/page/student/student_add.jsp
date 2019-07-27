<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.gxuwz.bean.BO.SelectDepName" %>
<%@ page language="java" import="com.gxuwz.bean.entity.sys_department" %>
<%@ page language="java" import="com.gxuwz.bean.BO.SelectClassName" %>
<%@ page language="java" import="com.gxuwz.bean.entity.sys_classes" %>
<%@ page language="java" import="com.gxuwz.bean.vo.liststudent"%>
<%@ page language="java" import="java.sql.*" %>
<%@ page language="java" import="com.gxuwz.bean.BO.SelectDormBuildingName" %>
<%@ page language="java" import="com.gxuwz.bean.entity.sys_dormbuilding" %>
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
<title>学生列表</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<link rel="shortcut icon" href="images/logo.jpg">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>

</head>

<body>
<%  
 SelectDormBuildingName sdb =new SelectDormBuildingName();
List<sys_dormbuilding> list2 = sdb.getDormBuildingName(); 
SelectDepName sd =new SelectDepName(); 
    List<sys_department> list = sd.getDepName(); 
    SelectClassName sc =new SelectClassName();
    List<sys_classes> list1 = sc.getClassName(); 
    %>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加学生</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="servlet/studentServlet?type=add">  
      <div class="form-group">
        <div class="label">
          <label>学生编号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="stuID"   />
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>学生姓名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="stuName"   />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>性别：</label>
        </div>
         <select name="sex" class="input w50" onchange="changesearch()" style="width:180px; line-height:17px; display:inline-block">
             <option value="">选择</option>
           
            <option value="男">男</option>
            <option value="女">女</option>
      </select></div>
     
           <div class="form-group">
        <div class="label">
          <label>所属班级：</label>
        </div>
         <select name="classID" class="input w50" onchange="changesearch()" style="width:180px; line-height:17px; display:inline-block">
             <option value="">选择</option>
             
        <%
        
        Iterator<sys_classes> it1 = list1.iterator();
		while(it1.hasNext()){
			sys_classes st = (sys_classes)it1.next();
			String classID =st.getClassID();
			
			String className =st.getClassName();
        %>       
             <option value="<%=classID%>"><%=className %></option>
            
      <%} %>
      </select></div>
       <div class="form-group">
        <div class="label">
          <label>所属宿舍楼：</label>
        </div>
         <select name="dormBuildingID" class="input w50" onchange="changesearch()" style="width:180px; line-height:17px; display:inline-block">
             <option value="">选择</option>
             <%
             %>
        <%
        
        Iterator<sys_dormbuilding> it = list2.iterator();
		while(it.hasNext()){
			sys_dormbuilding st1 = (sys_dormbuilding) it.next();
			String dormBuildingID =st1.getDormBuildingID();
			String dormBuildingName =st1.getDormBuildingName();
        %>       
             <option value="<%=dormBuildingID%>"><%=dormBuildingName %></option>
      <%} %>
      </select></div>  
          <div class="form-group">
        <div class="label">
          <label>所在宿舍：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="dormID"   />
          <div class="tips"></div>
        </div>
      </div>
         <div class="form-group">
        <div class="label">
          <label>所在床位：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="bedID" data-validate="required:数据必填项" />
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>联系电话：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="stuTel" data-validate="required:数据必填项" />
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>通讯地址：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="address" data-validate="required:数据必填项" />
          <div class="tips"></div>
        </div>
      </div>
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
