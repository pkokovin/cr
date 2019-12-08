<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <h3 class="text-center">Call registration: OPERATORS</h3>
        <hr/>

        <input type="button" value="Add Operator"
               onclick="window.location.href='showform'; return false;"
               class="btn btn-primary"/> <br/>
        <br/>
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">Operator List</div>
            </div>
            <div class="panel-body">
                <table class="table table-striped table-bordered">
                    <tr>
                        <th>login</th>
                        <th>Full Name</th>
                        <th>Action</th>
                    </tr>

                    <!-- loop over and print our customers -->
                    <c:forEach var="tempOperator" items="${operators}">

                        <!-- construct an "update" link with operator id -->
                        <c:url var="updateLink" value="/operator/updateform">
                            <c:param name="operatorId" value="${tempOperator.id}"/>
                        </c:url>

                        <!-- construct an "delete" link with customer id -->
                        <c:url var="deleteLink" value="/operator/delete">
                            <c:param name="operatorId" value="${tempOperator.id}"/>
                        </c:url>

                        <tr>
                            <td>${tempOperator.cName}</td>
                            <td>${tempOperator.fullName}</td>
                            <td>
                                <!-- display the update link --> <a href="${updateLink}">Update</a>
                                | <a href="${deleteLink}"
                                     onclick="if (!(confirm('Are you sure you want to delete this operator?'))) return false">Delete</a>
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









