<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<t:default>
    <jsp:body>
        <form:form action="${pageContext.request.contextPath}/" enctype="multipart/form-data" cssClass="form-horizontal" commandName="article" method="post">
            <jsp:include page="articleForm.jsp"/>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10"><input type="submit" class="btn btn-primary" value="Salvar"/></div>
            </div>
        </form:form>
    </jsp:body>
</t:default>