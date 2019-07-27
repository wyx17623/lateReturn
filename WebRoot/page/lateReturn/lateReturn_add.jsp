 <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.gxuwz.bean.BO.SelectDepName" %>
<%@ page language="java" import="com.gxuwz.bean.entity.sys_department" %>
<%@ page language="java" import="com.gxuwz.bean.BO.SelectTeacher" %>
<%@ page language="java" import="java.text.SimpleDateFormat"%>
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
<title>晚归信息添加</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<link rel="shortcut icon" href="images/logo.jpg">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>

</head>

<body>
<%  
String userID = (String)session.getAttribute("userID");
java.util.Date date = new java.util.Date();
SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
String lateReturnID = sdf.format(date)+userID;
SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String applytime= sf.format(date);
     
    %>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加晚归信息</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="servlet/lateReturnServlet?type=add">  
     <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <input  class="input w50" type="hidden" value="<%=lateReturnID %>" name="lateReturnID"   />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>学生学号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="stuID"   />
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>宿舍号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="dormID"   />
          <div class="tips"></div>
        </div>
      </div>
          <div class="form-group">
        <div class="label">
          <label>床号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="bedID"   />
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>晚归时间</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="<%=applytime %>" name="lateReturnTime"   />
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>晚归原因</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="lateReturnReason"   />
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
