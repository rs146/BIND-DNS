<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="pageTitle" value="Please Login" scope="request" />
<jsp:include page="./includes/header.jsp" />

<c:url value="/login" var="loginUrl" />
<form action="${loginUrl}" method="post">
	<c:if test="${param.error != null}">
		<div class="alert alert-error">
			Failed to login.
			<c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
              Reason: <c:out
					value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
			</c:if>
		</div>
	</c:if>
	<c:if test="${param.logout != null}">
		<div class="alert alert-success">You have been logged out.</div>
	</c:if>
	<label for="username">Username</label> 
	<input type="text" id="username" name="username" /> 
	
	<label for="password">Password</label>
	<p>
		<input type="password" id="password" name="password" />
	
		<label for="remember">Remember Me?</label>
		<input type="checkbox" id="remember" name="_spring_security_remember_me" value="true" />
		<div class="form-actions">
	</p>
		<input id="submit" class="btn" name="submit" type="submit"
			value="Login" />
	</div>
</form>
<jsp:include page="./includes/footer.jsp" />