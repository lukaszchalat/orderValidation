<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Validation Form</title>
 <link href="webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="webjars/bootstrap/4.0.0/js/bootstrap.min.js" ></script>
 <script src="webjars/jquery/3.0.0/jquery.min.js" ></script>
</head>
<body>

<div class="container">

<h1>Here you can validate your work order</h1>

<form action="/validate" method="POST">
	<div class="form-group">
		<label for="requestInput">Request</label><br>
		<textarea id="requestInput" name="order" rows="5" cols="100">${order}</textarea>
		<small class="form-text text-muted">Please put here your work order.</small>
	</div>
	<div class="form-group">
		<label for="responseInput">Response</label><br>
		<textarea id="responseInput" rows="5" cols="100" readonly placeholder="Submit to get result">${response}</textarea>
		<small class="form-text text-muted">Here you will find request validation result.</small>
	</div>
	<input type="submit" class="btn btn-primary" value="Submit" />
</form>

<a href="/requests">Show all requests</a>

</div>

</body>
</html>
