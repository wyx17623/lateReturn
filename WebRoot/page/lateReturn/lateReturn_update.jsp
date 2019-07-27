<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.gxuwz.bean.BO.actionlateReturn" %>
<%@ page language="java" import="com.gxuwz.bean.vo.listlateReturn"%>
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
 actionlateReturn as =new actionlateReturn();
 List<listlateReturn> sl=as.listlateReturn(userID); 
String index = request.getParameter("index");
listlateReturn tl = sl.get(Integer.parseInt(index));
    %>
<div class="panel admin-panel">
  <div class="body-content">
    <form method="post" class="form-x" action="servlet/lateReturnServlet?type=update">  
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <input type="hidden" class="input w50" value="<%=tl.getlateReturnID() %>" name="lateReturnID"  readonly="readonly" />
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>学号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="<%=tl.getStuID() %>" name="stuID"   />
          <div class="tips"></div>
        </div>
      </div>     
        <div class="form-group">
        <div class="label">
          <label>宿舍号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="<%=tl.getDormID()%>" name="dormID"   />
          <div class="tips"></div>
        </div>
      </div>
        <div class="form-group">
        <div class="label">
          <label>床位号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="<%=tl.getBedID()%>" name="bedID"   />
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>晚归时间：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="<%=tl.getlateReturnTime()%>" name="lateReturnTime"   />
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>晚归原因：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="<%=tl.getLateReturnReason()%>" name="lateReturnReason"   />
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
