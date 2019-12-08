<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<nav class="navbar navbar-dark bg-dark py-0">
    <div class="container">
        <form class="form-inline my-2">
            <a class="btn btn-info mr-1" href="${pageContext.request.contextPath}/operator/list">Operators</a>
            <a class="btn btn-info mr-1" href="${pageContext.request.contextPath}/call/list">Calls</a>
            <a class="btn btn-info mr-1" href="${pageContext.request.contextPath}">Home</a>
            <a class="btn btn-info mr-1" href="${pageContext.request.contextPath}/call/listcomputed">Statistics</a>
        </form>
    </div>
</nav>
