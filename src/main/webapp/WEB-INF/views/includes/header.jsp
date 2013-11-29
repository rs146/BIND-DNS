<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
  <head>
        <title>BIND DNS Management Application </title>
        <meta http-equiv="content-type" content="text/html;charset=utf-8" />
        <c:url var="cssUrl" value="/resources/css/bootstrap.css"/>
        <link href="${cssUrl}" rel="stylesheet"/>
        <style>
          body {
            padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
          }
        </style>

        <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
          <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
    </head>
    <body>
      <div id="nav-bar" class="navbar navbar-fixed-top">
        <div class="navbar-inner">
            <div class="container">
                <c:url var="homeUrl" value="/" />
                <a class="brand" href="${homeUrl}">BIND DNS Manager</a>
                <div class="nav-collapse">
                    <ul class="nav">
                        <c:url var="networksUrl" value="/networks/" />
                        <li><a id="navNetworksLink" href="${networksUrl}">Networks</a></li>
                        <c:url var="nameServersUrl" value="/name-servers" />
                        <li><a id="navNameServersLink" href="${nameServersUrl}">Name Servers</a></li>
                        <c:url var="resourceRecordsUrl" value="/resource-records" />
                        <li><a id="navResourceRecordsLink" href="${resourceRecordsUrl}">Resource Records</a></li>
                        <c:url var="adminUrl" value="/admin" />
                        <li><a id="navAdminLink" href="${adminUrl}">Administration</a></li>
                    </ul>
                </div>
                <div id="nav-account" class="nav-collapse pull-right">
                    <ul class="nav">
                        <sec:authorize access="authenticated" var="authenticated"/>
                        <c:choose>
                            <c:when test="${authenticated}">
                                <li id="greeting"><div>Welcome <sec:authentication property="principal.username" /></div></li>
                                <c:url var="logoutUrl" value="/logout"/>
                                <li><a id="navLogoutLink" href="${logoutUrl}">Logout</a></li>
                            </c:when>
                            <c:otherwise>
                                <c:url var="loginUrl" value="/login/form"/>
                                <li><a id="navLoginLink" href="${loginUrl}">Login</a></li>
                            </c:otherwise>
                        </c:choose>
                    </ul>
                </div>
            </div>
        </div>

    </div>

    <div class="container">
        <c:if test="${message != null}">
            <div class="alert alert-success" id="message"><c:out value="${message}"/></div>
        </c:if>
        <h1 id="title"><c:out value="${pageTitle}"/></h1>
