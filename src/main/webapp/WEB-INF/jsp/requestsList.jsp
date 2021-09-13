<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>All validation requests</title>
 <link href="webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="webjars/bootstrap/4.0.0/js/bootstrap.min.js" ></script>
 <script src="webjars/jquery/3.0.0/jquery.min.js" ></script>
</head>
<body>

<div class="container">

<table class="table">
	<thead>
		<td>Id</td>
		<td>Receiving date</td>
		<td>Order type</td>
		<td>Department</td>
		<td>Status</td>
	</thead>
	<tbody>
	<c:forEach items="${requests}" var="request">
		<tr>
			<td>${request.id}</td>
			<td>
				<fmt:parseDate value="${request.receivingDate}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedReceivingDate" type="both" />
                <fmt:formatDate pattern="dd.MM.yyyy HH:mm:ss" value="${parsedReceivingDate}" />
			</td>
			<td>${request.orderType}</td>
			<td>${request.department}</td>
			<td>
				${request.status ? "Valid" : "Invalid"}
			</td>
		</tr>
	</c:forEach>
	</tbody>
</table>

<a href="/">Back to the validation form</a>

</div>

</body>
</html>