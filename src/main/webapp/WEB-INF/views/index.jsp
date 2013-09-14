<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="pageTitle" value="BIND DNS Manager" scope="request"/>
<jsp:include page="./includes/header.jsp"/>
<h2>BIND DNS Management Application</h2>
<ul>
    <li><a id="networksLink" href="networks/">All Networks</a> - shows all networks, subnets and IP Addresses.</li>
    <li><a id="nameServersLink" href="name-servers/">All DNS Name Servers</a> - shows all Name Servers used.</li>
    <li><a id="resourceRecordsLink" href="resource-records/">BIND Resource Records</a> - view and amend all BIND DNS Resource Records.</li>
    <li><a id="logoutLink" href="j_spring_security_logout">Logout</a></li>
    <li>
        <a id="adminLink" href="admin/">Admin</a> - Administration
    </li>
</ul>
<jsp:include page="./includes/footer.jsp"/>