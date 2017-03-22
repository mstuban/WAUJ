<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<title>New note</title>
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
				<h1>Add a new note</h1>
				<hr />
				<form:form class="form-group" method="POST"
					modelAttribute="newNoteForm">
					<label for="username">User</label>
					<form:select class="form-control" id="userID" path="userID" required="required">
 						<option value="">Choose user</option>
						<form:options items="${users}" itemLabel="username" itemValue="id" />
					</form:select>
					<br />
					<label for="notebookName">Notebook</label>
					<form:select class="form-control" name="notebookName" required="required"
						path="notebookName">
						<option value="">Choose notebook</option>
						<form:options items="${notebooks}" itemLabel="name"
							itemValue="name" />
					</form:select>
					<br />
					<label for="headline">Headline</label>
					<form:input type="text" class="form-control" path="headline"
						name="headline" required="required" />
					<br />
					<label for="content">Content</label>
					<form:textarea class="form-control" path="content" id="content"
						required="required"></form:textarea>
					<br />
					<input type="submit" class="btn btn-primary" name="saveButton"
						value="Save note" />
				</form:form>
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