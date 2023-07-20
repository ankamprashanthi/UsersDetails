<%@include file="/include/header.jsp"  %>
<div class="container mtb">
	<div class="row">
		<div class="col-lg-6">
			<form action="${pageContext.request.contextPath}/operation" method="post">
			Username:<input type="text" name="username" value="${param.username}" required="required"/><br/>
			Email:<input type="email" name="email" value="${param.email}"required="required"/><br/>
			<input type="hidden" name="userid" value="${param.userid}"/>
			<input type="hidden" name="form" value="updateUserOperation">
			<input type="submit" value="updateUser"/>
			</form>
		</div>
	</div>
</div>
<%@include file="/include/footer.jsp"%>