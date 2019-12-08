<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://cr.kokovin.ru/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Call registration: OPERATORS</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />"
          rel="stylesheet">
    <%@ page isELIgnored="false" %>
    <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<div class="container">
    <div class="col-md-offset-1 col-md-10">
        <h3 class="text-center">Calls VIEW and registration</h3>
        <hr/>

        <input type="button" value="register"
               onclick="window.location.href='showform'; return false;"
               class="btn btn-primary"/> <br/>
        <br/>
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">Calls List</div>
            </div>
            <div class="panel-body">
                <table class="table table-striped table-bordered">
                    <tr>
                        <th>Date</th>
                        <th>Number</th>
                        <th>Customer</th>
                        <th>Comment</th>
                        <th>Direction</th>
                        <th>Operator</th>
                        <th>Action</th>
                    </tr>

                    <!-- loop over and print our customers -->
                    <c:forEach var="tempCall" items="${calls}">

                        <!-- construct an "update" link with operator id -->
                        <c:url var="updateLink" value="/call/updateform">
                            <c:param name="callId" value="${tempCall.id}"/>
                        </c:url>

                        <tr>
                            <td>${fn:formatDateTime(tempCall.registered)}</td>
                            <td>${tempCall.phone}</td>
                            <td>${tempCall.customer}</td>
                            <td>${tempCall.comment}</td>
                            <td>${tempCall.direction}</td>
                            <td>${tempCall.operator.fullName}</td>
                            <td>
                                <!-- display the update link -->
                                <a href="${updateLink}">Update</a>
                            </td>

                        </tr>

                    </c:forEach>

                </table>

            </div>
        </div>
    </div>

</div>
<jsp:include page="fragments/footer.jsp"/>
</body>

</html>









