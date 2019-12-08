<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Call registration: operator service</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />"
          rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
<jsp:include page="WEB-INF/views/fragments/bodyHeader.jsp"/>
<div class="jumbotron">
    <div class="container">
        <form method="post" class="form-inline">
            <label>Login</label>
            <select name="userId" class="form-control mx-3">
                <option value="100000" selected>operator1</option>
                <option value="100001">operator2</option>
            </select>
            <button type="submit" class="btn btn-primary">Select</button>
        </form>
    </div>
</div>
<jsp:include page="WEB-INF/views/fragments/footer.jsp"/>
</body>
</body>
</html>
