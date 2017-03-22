<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<title>New note added</title>
<link href="<spring:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet" type="text/css">
<link href="<spring:url value="/resources/css/style.css" />"
	rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="<spring:url value="/resources/js/bootstrap.min.js"/>"></script>
</head>
<body class="well well-sm">
	<header>
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="<spring:url value="/" />">Note
						manager</a>
				</div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="<spring:url value="/" />">Home</a></li>
				</ul>
			</div>
		</nav>
	</header>
	<div class="container">
		<div class="row text-center">
			<div class="col-md-6 col-md-offset-3">
				<h1>${note.noteHeadline}</h1>
				<p>${note.noteText}</p>
				<hr />
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th class="text-center">Written by</th>
								<th class="text-center">Username</th>
								<th class="text-center">Notebook</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>${note.user.firstName}&nbsp;${note.user.lastName}</td>
								<td>${note.user.username}</td>
								<td>${note.notebook.name}</td>
							</tr>
						</tbody>
					</table>
					<a class="btn btn-secondary text-center"
						href="<spring:url value="/" />"><button
							class="btn btn-secondary text-center">Go back</button></a>
				</div>
			</div>
		</div>
	</div>
	<footer class="footer">
		<div class="container">
			<p class="text-muted text-center">© mstuban, 2017.</p>
		</div>
	</footer>
</body>
</html>