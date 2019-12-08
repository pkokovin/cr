<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Call registration: call service</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />"
          rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

</head>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<div class="container">
    <div class="col-md-offset-2 col-md-7">
        <h3 class="text-center">Call registration: call service</h3>
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">Register call</div>
            </div>
            <div class="panel-body">
                <form:form action="save" cssClass="form-horizontal"
                           method="post" modelAttribute="call">

                    <!-- need to associate this data with customer id -->
                    <form:hidden path="id"/>

                    <div class="form-group">
                        <label for="phone" class="col-md-3 control-label">Phone number</label>
                        <div class="col-md-9">
                            <form:input path="phone" cssClass="form-control"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="customer" class="col-md-3 control-label">Customer Name</label>
                        <div class="col-md-9">
                            <form:input path="customer" cssClass="form-control"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="comment" class="col-md-3 control-label">Comments</label>
                        <div class="col-md-9">
                            <form:textarea path="comment" cssClass="form-control" rows="5"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <select name="Direction" class="form-control">
                            <option value="IN" selected>Inbound</option>
                            <option value="OUT">Outbound</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <!-- Button -->
                        <div class="col-md-offset-3 col-md-9">
                            <form:button cssClass="btn btn-primary">Submit</form:button>
                        </div>
                    </div>

                </form:form>
            </div>
        </div>
    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>