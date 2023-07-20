<%@include file="/include/header.jsp"  %>
<%@page import="java.util.List"%>
<%@page import="org.studyeasy.entity.user" %>

<div class="container mtb">
	<div class="row">
		<div class="col-lg-6">
			<Strong>Listing users</Strong>
			<hr/>
			<table border="1">
			<thead>
			
			<th>User Id</th>
			<th>UserName</th>
			<th>Email</th>
			<th>Operations</th>
			
			</thead>
			<%! String deleteURL;%>
			<%
			String updateURL;
			List<user> listUsers=(List)request.getAttribute("listUsers");
			for(int i=0;i<listUsers.size();i++){
				out.print("<tr>");
				out.print("<td>"+listUsers.get(i).getUserid()+"</td>");
				out.print("<td>"+listUsers.get(i).getUsername()+"</td>");
				out.print("<td>"+listUsers.get(i).getEmail()+"</td>");
				updateURL=request.getContextPath()+"/operation?page=updateUser"+
				"&userid="+listUsers.get(i).getUserid()+"&username="+listUsers.get(i).getUsername()+
				"&email="+listUsers.get(i).getEmail();
				deleteURL=request.getContextPath()+"/operation?page=deleteUser"+
						"&userid="+listUsers.get(i).getUserid();
				out.print("<td><a href="+updateURL+">Update</a>|");
				
			
			%>
			<a href="<%=deleteURL%>" 
			onclick="if(!confirm('Are you sure to delete the user?')) return false">Delete</a>
				</td>
				</tr>
			<%}%>
			</table>
		</div>
	</div>
</div>
<%@include file="/include/footer.jsp"  %>