<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="pageTitle" value="List - Users" scope="request" />
<jsp:include page="../includes/header.jsp" />

<h3>List of Users</h3>
<hr>

<table class="table">
	<thead>
		<tr>
			<th>ID</th>
			<th>Username</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${users}" var="user">
		<tr>
			<td>${user.id}</td>
			<td>${user.username}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

<jsp:include page="../includes/footer.jsp" />