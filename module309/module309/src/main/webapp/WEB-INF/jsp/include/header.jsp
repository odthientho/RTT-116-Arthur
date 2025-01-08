<%--
  Created by IntelliJ IDEA.
  User: odthi
  Date: 12/13/2024
  Time: 2:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <!-- jquery is always loaded at the top of the file because its needed by so many other libraries -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
    <section>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">Navbar</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="/index">Home</a>
                    </li>
                    <sec:authorize access="hasAnyAuthority('ADMIN', 'USER')">
                    <li class="nav-item">
                        <a class="nav-link" href="/customer/search">Search</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/customer/create">New</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/customer/ajaxExample">AjaxExample</a>
                    </li>
                    </sec:authorize>
                    <sec:authorize access="!isAuthenticated()">
                        <li class="nav-item">
                            <a class="nav-link" href="/login/login">Login</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/login/signup">Sign Up</a>
                        </li>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                        <li class="nav-item">
                            <a class="nav-link" href="/login/logout">Logout</a>
                        </li>
                    </sec:authorize>
                    <sec:authorize access="hasAuthority('ADMIN')">
                        <li class="nav-item">
                            <a class="nav-link" href="/">Admin</a>
                        </li>
                    </sec:authorize>
                </ul>
            </div>
        </nav>
    </section>
