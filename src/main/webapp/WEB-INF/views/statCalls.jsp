<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://cr.kokovin.ru/functions" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
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
        <h3 class="text-center">Calls Stats</h3>
        <hr/>
        <form method="get" action="${context}/call/listcomputed">
            <d1>
                <dt>From</dt>
                <dd>
                    <input type="datetime-local" name="start" value="${param.start}">
                </dd>
            </d1>
            <d1>
                <dt>To</dt>
                <dd>
                    <input type="datetime-local" name="end" value="${param.end}">
                </dd>
            </d1>
            <button type="submit">Filter</button>
        </form>
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">Calls Statistics</div>
            </div>
            <div class="panel-body">
                <table class="table table-striped table-bordered">
                    <tr>
                        <th>Operators Name</th>
                        <th>Inbound Calls</th>
                        <th>Outbound Calls</th>
                    </tr>

                    <!-- loop over and print our customers -->
                    <c:forEach var="tempCallTos" items="${callTos}">

                        <tr>
                            <td>${tempCallTos.fullName}</td>
                            <td>${tempCallTos.inbound}</td>
                            <td>${tempCallTos.outbound}</td>
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









