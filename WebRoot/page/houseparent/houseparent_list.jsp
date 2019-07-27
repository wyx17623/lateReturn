<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.gxuwz.base.database" %>
<%@ page language="java" import="com.gxuwz.bean.vo.listhouseparent"%>
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
<title>宿舍管理员信息列表</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<link rel="shortcut icon" href="images/logo.jpg">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>

</head>

<body>
<form method="post" action="" id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 宿舍管理员列表</strong> </div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
       <li> <a class="button border-main icon-plus-square-o" href="page/houseparent/houseparent_add.jsp"> 添加宿舍管理员</a> </li>
        <li>搜索：</li>
        <li>
          <input type="text" placeholder="请输入搜索关键字" name="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" />
          <input type="submit" class="button border-main icon-search" onclick="changesearch()" value="搜索" > </li>
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
       <th>序号</th>
				
          <th>工号</th>
         <th>姓名</th>
         <th>性别</th>            
         <th>联系电话</th>
          <th>分管宿舍楼</th>
         <th>操作</th>
         

      </tr>
    
			<%  List<listhouseparent> sl = (List<listhouseparent>)request.getAttribute("listhouseparent");
			
			
			int index=1;
			Iterator<listhouseparent> it = sl.iterator();
			while(it.hasNext()){
				listhouseparent st = (listhouseparent) it.next();
				String houseparentName =st.getHouseparentName();
				String houseparentID = st.getHouseparentID();
				String sex =st.getSex();
				String houTel= st.getHouTel();
				String dormBuildingName= st.getDormBuildingName();
			
				
				  %>
				
		
			<tr>
				 <td><%=index++ %></td>			  
				 <td><%=houseparentID %></td>
				 <td><%=houseparentName %></td>
				 <td><%=sex %></td>
			    <td><%=houTel %></td>
			    <td><%=dormBuildingName %></td>
				<td>
				<div class="button-group">
				 <a class="button border-main" href="<%=path%>/page/houseparent/houseparent_update.jsp?index=<%=index-2%>"><span class="icon-edit"></span> 修改</a> <a class="button border-red" href="<%=path%>/servlet/houseparentServlet?type=remove&houseparentID=<%=houseparentID%>" ><span class="icon-trash-o"></span> 删除</a>  </div>
				</td>
			</tr>
	<%} %>
    </table>
  </div>
  <div class="pagelist"> <a href="">上一页</a> <span class="current">1</span><a href="">2</a><a href="">3</a><a href="">下一页</a><a href="">尾页</a> </div>
</form>
</body>
</html>
