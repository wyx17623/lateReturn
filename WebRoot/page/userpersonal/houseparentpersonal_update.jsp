<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.gxuwz.base.database" %>
<%@ page language="java" import="com.gxuwz.base.base" %>
<%@ page language="java" import="java.sql.*" %>
<%@ page language="java" import="com.gxuwz.bean.BO.actionhouseparent" %>
<%@ page language="java" import="com.gxuwz.bean.vo.listhouseparent"%>
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
<title>修改宿管员信息</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<link rel="shortcut icon" href="images/logo.jpg">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>

</head>

<body>
<%
    
   String houseparentID = request.getParameter("houseparentID");
actionhouseparent as =new actionhouseparent();
List<listhouseparent> sl=as.listhouseparentpersonal(houseparentID);
   listhouseparent tl = sl.get(0);
   SelectDormBuildingName st =new SelectDormBuildingName();
   List<sys_dormbuilding> list = st.getDormBuildingName();
%>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改个人信息</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="servlet/houseparentServlet?type=updatepersonal">  
      <div class="form-group">
        <div class="label">
          <label>宿管员编号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="<%=tl.getHouseparentID() %>" name="houseparentID" readonly="readonly"  />
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>宿管员姓名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="<%=tl.getHouseparentName() %>" name="houseparentName"   />
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
          <label>电话号码：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="<%=tl.getHouTel() %>" name="houTel" data-validate="required:数据必填项" />
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
