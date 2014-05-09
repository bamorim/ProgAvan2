<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:default>
    <jsp:body>
        <div class="row">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title">Filtros</h3>
                </div>
                <div class="panel-body">
                    <form class="form-horizontal row">
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Título</label>
                                <div class="col-sm-10">
                                    <input value="${param.titulo}" name="titulo" type="text" class="form-control" placeholder="Título"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Autor</label>
                                <div class="col-sm-10">
                                    <input value="${param.autor}" name="autor" type="text" class="form-control" placeholder="Autor"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Veículo</label>
                                <div class="col-sm-10">
                                    <input value="${param.veiculo}" name="veiculo" type="text" class="form-control" placeholder="Veículo"/>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Data</label>
                                <div class="col-sm-4">
                                    <input value="${param.data_inicio}" name="data_inicio" type="date" class="form-control" placeholder="Início"/>
                                </div>
                                <label class="col-sm-2 control-label">Até</label>
                                <div class="col-sm-4">
                                    <input  value="${param.data_fim}" name="data_fim" type="date" class="form-control" placeholder="Fim"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Keyword</label>
                                <div class="col-sm-10">
                                    <input value="${param.keywords}" name="keywords" type="text" class="form-control" placeholder="Palavras Chave"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-10 col-sm-offset-2">
                                    <button class="btn btn-primary">Filtrar</button>
                                    <a href="<c:url value="/"/>" class="btn btn-default">Limpar</a>
                                </div>
                            </div>
                        </div>
                    </form>
                    </div>
                </div>
            </div>
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
                                <a href="<c:url value="/${article.id}/edit"/>" class="btn btn-default">Editar</a>
                                <a href="<c:url value="/uploads/${article.filename}"/>" target="_blank" class="btn btn-primary">Download</a>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </jsp:body>
</t:default>