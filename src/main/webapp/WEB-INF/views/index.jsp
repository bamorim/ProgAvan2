<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:default>
    <jsp:body>
        <div class="row">
            <c:forEach var="article" items="${articles}">
                <div class="col-md-6 col-sm-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h3 class="panel-title">${article.titulo}</h3>
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-sm-3"><h4>Autor</h4></div>
                                <div class="col-sm-9"><p>${article.autor}</p></div>
                            </div>
                            <div class="row">
                                <div class="col-sm-3"><h4>Veículo</h4></div>
                                <div class="col-sm-9"><p>${article.veiculo}</p></div>
                            </div>
                            <div class="row">
                                <div class="col-sm-3"><h4>Data</h4></div>
                                <div class="col-sm-9"><p>${article.data}</p></div>
                            </div>
                            <div class="row">
                                <div class="col-sm-3"><h4>Keywords</h4></div>
                                <div class="col-sm-9">
                                    <p>
                                        <c:forEach var="k" varStatus="loop" items="${article.keywords}">
                                            <c:if test="${loop.index > 0}">,</c:if>
                                            ${k.keyword}
                                        </c:forEach>
                                    </p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-3"><h4>Ações</h4></div>
                            </div>
                            <div class="col-sm-9">
                                <a href="<c:url value="/${article.id}/edit"/>" class="btn btn-secondary">Editar</a>
                                <a href="<c:url value="/uploads/${article.filename}"/>" target="_blank" class="btn btn-primary">Download</a>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </jsp:body>
</t:default>