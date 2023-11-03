<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="<c:url value="/view/wikistyle.css"/>" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<nav>
    <ul class="pagination pagination-sm justify-content-center">
        <c:forEach begin="1" end="${2}" var="i">
            <li class="page-item"><a class="page-link" href="/whattoeat?wikipage=${i}">${i}</a></li>
        </c:forEach>
    </ul>
</nav>
</body>
</html>
