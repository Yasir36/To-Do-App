<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="./base.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<meta charset="ISO-8859-1">
</head>
<body>

	<div class="section">
		<div class="sidebar">
			<h1 class="sidebar-heading">TO-DO</h1>
			<ul>
				<li><button type="button" class="btn btn-primary"
						data-toggle="modal" data-target="#exampleModal">Add
						Todo-Card</button></li>
				<li><a href="">Sign In</a></li>
				<li><a href="">Log in</a></li>
				<li><a href="">Settings</a></li>
			</ul>
		</div>

		<c:forEach items="${cards}" var="card">
			<div class="text-center todos ">
				<div class="card mt-5 mr-1" style="width: 15rem;">
					<div class="card-body">
						<h5 class="card-title">${card.title}</h5>
						<p class="card-text">${card.text}</p>
						<a href="${pageContext.request.contextPath}/deleteCard/${card.id}" class="btn btn-danger">Delete</a>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>

	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body ">
					<form action="createCard" method="POST">
						<div class="form-group">
							<label for="title">Title</label> <input type="text"
								class="form-control" id="title" name="title"
								placeholder="Enter Title">
						</div>
						<div class="form-group">
							<label for="text">Password</label>
							<textarea type="text" class="form-control" id="text" name="text"
								placeholder="Add todos here"></textarea>
						</div>
						<button type="submit" class="btn btn-primary">Create</button>
					</form>
				</div>
			</div> 
		</div>
	</div>
</body>
</html>