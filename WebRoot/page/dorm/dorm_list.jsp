<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.gxuwz.base.database" %>
<%@ page language="java" import="com.gxuwz.bean.vo.listdorm "%>
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
<title>宿舍信息列表</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<link rel="shortcut icon" href="images/logo.jpg">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>

</head>

<body>
<form method="post" action="" id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 宿舍信息列表</strong> </div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
       <li> <a class="button border-main icon-plus-square-o" href="page/dorm/dorm_add.jsp"> 添加宿舍信息</a> </li>
       
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
       <th>序号</th>
				
  
         <th>宿舍编号</th>
         <th>宿舍名称</th>
         <th>所属宿舍楼</th>
         <th>操作</th>
         

      </tr>
    
			<%  List<listdorm> sl = (List<listdorm>)request.getAttribute("dormlist");			
			int index=1;
			Iterator<listdorm> it = sl.iterator();
			while(it.hasNext()){
				listdorm st = (listdorm) it.next();
				String dormID=st.getDormID();
				String dormName = st.getDormName();
				String dormBuildingID = st.getDormBuildingID();
				
				  %>
				
		
			<tr>
				 <td><%=index++ %></td>
				  <td><%=dormID %></td>
				 <td><%=dormName %></td>
			     <td><%=dormBuildingID %></td>
			
				<td>
				<div class="button-group">
				 <a class="button border-main" href="<%=path%>/page/dorm/dorm_update.jsp?index=<%=index-2%>"><span class="icon-edit"></span> 修改</a> <a class="button border-red" href="<%=path%>/servlet/dormServlet?type=remove&dormID=<%=dormID%>" ><span class="icon-trash-o"></span> 删除</a>  </div>
				</td>
			</tr>
	<%} %>
    </table>
  </div>
  <div class="pagelist"> <a href="">上一页</a> <span class="current">1</span><a href="">2</a><a href="">3</a><a href="">下一页</a><a href="">尾页</a> </div>
</form>
</body>
</html>
