<%@page import="com.mvc.dao.CategoryDAO"%>
<%@page import="com.mvc.beans.CategoryBean"%>
<%@page language="java" import="java.sql.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>:: Category View ::</title>
</head>
<body>
	<table>
		<tr>
			<td>Sl.No</td>
			<td>Name</td>
			<td>Edit</td>
			<td>Delete</td>
		</tr>
		<%
			int i = 1;
		CategoryBean categoryBean = new CategoryBean();
		ArrayList<CategoryBean> category = CategoryDAO.listAllCategories();
		for (CategoryBean cat : category) {
		%>
		<tr>
			<td><%=i%></td>
			<td><%=cat.getCaName()%></td>
			<td><a href="CategoryEdit.jsp?id=<%=cat.getCaId()%>">Edit</a></td>
			<td><a href="CategoryDelete.jsp?id=<%=cat.getCaId()%>">Delete</a></td>
		</tr>
		<%
i++;
}
%>
	</table>
</body>
</html>