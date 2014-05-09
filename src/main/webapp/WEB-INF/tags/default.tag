<%@tag description="Default template" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="<c:url value="/assets/bootstrap.css"/>" rel="stylesheet" />
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="contailer">
                <a class="navbar-brand" href="<c:url value="/"/>">Artigos</a>
                <ul class="nav navbar-nav">
                    <li>
                        <a href="<c:url value="/" />">Home</a>
                    </li>
                    <li>
                        <a href="<c:url value="/create"/>">Criar Novo</a>
                    </li>
                </ul>
            </div>
        </nav>
        <div class="container">
            <jsp:doBody/>
        </div>
    </body>
</html>