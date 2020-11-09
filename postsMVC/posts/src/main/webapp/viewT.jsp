<%@page import="com.mphasis.app.crud.ToDos"%>
<%@page import="java.util.List"%>
<%@page import="com.mphasis.app.dao.ToDosDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./assets/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
	 <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">


</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>

	<div class="container">
		<div class="jumbotron py-5">
			<h3 class="h3 mb-0">Showing all the ToDos</h3>
		</div>
		<%
			ToDosDAOImpl impl = new ToDosDAOImpl();
		%>
		<%
			List<ToDos> list = impl.view();
		%>

		<%
			for (ToDos t : list) {
		%>
		<li class="list-group-item d-flex justify-content-between align-items-center">
		<%= t.getId()   %>
		<%= t.getTitle() %>
		<span>
		<% if(t.isCompleted().equals("true")) { %>
		<span class="material-icons text-success" >assignment_turned_in</span>
		<% } %>
		<% if(t.isCompleted().equals("false")) { %>
		<span class="material-icons text-warning" >assignment_late</span>
		<% } %>
		</span>
		</li>
		<%
			}
		%>
	</div>
</body>
</html>