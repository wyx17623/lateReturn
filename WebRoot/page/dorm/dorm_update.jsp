<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.gxuwz.bean.BO.actiondorm" %>
<%@ page language="java" import="com.gxuwz.bean.vo.listdorm" %>
<%@ page language="java" import="com.gxuwz.bean.BO.SelectDormBuildingName" %>
<%@ page language="java" import="com.gxuwz.bean.entity.sys_dormbuilding" %>
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
<title>宿舍信息修改</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<link rel="shortcut icon" href="images/logo.jpg">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>

</head>

<body>
<% actiondorm as =new actiondorm();  		
List<listdorm> sl=as.listdorm();
String index = request.getParameter("index");
listdorm tl = sl.get(Integer.parseInt(index));    
SelectDormBuildingName st =new SelectDormBuildingName();
List<sys_dormbuilding> list = st.getDormBuildingName();
    %>
<div class="panel admin-panel">
  <div class="body-content">
    <form method="post" class="form-x" action="servlet/dormServlet?type=update">  
      <div class="form-group">
        <div class="label">
          <label>宿舍编号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="<%=tl.getDormID() %>" name="dormID"  readonly="readonly"  />
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>宿舍名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="<%=tl.getDormName()%>" name="dormName"   />
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>所属宿舍楼：</label>
        </div>
         <select name="dormBuildingID" class="input w50" onchange="changesearch()" style="width:180px; line-height:17px; display:inline-block">
             <option value="">选择</option>
             <%
             %>
        <%
        
        Iterator<sys_dormbuilding> it = list.iterator();
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
