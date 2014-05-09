<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<div class="form-group">
    <label class="col-sm-2 control-label">T�tulo</label>
    <div class="col-sm-10">
        <form:input path="titulo" cssClass="form-control" placeholder="T�tulo"/>
    </div>
</div>

<div class="form-group">
    <label class="col-sm-2 control-label">Autor</label>
    <div class="col-sm-10">
        <form:input path="autor" cssClass="form-control" placeholder="Autor"/>
    </div>
</div>

<div class="form-group">
    <label class="col-sm-2 control-label">Ve�culo</label>
    <div class="col-sm-10">
        <form:input path="veiculo" cssClass="form-control" placeholder="Ve�culo"/>
    </div>
</div>

<div class="form-group">
    <label class="col-sm-2 control-label">Palavras Chave</label>
    <div class="col-sm-10">
        <form:input path="keywords" cssClass="form-control" placeholder="Palavras Chave"/>
    </div>
</div>

<div class="form-group">
    <label class="col-sm-2 control-label">Data</label>
    <div class="col-sm-10">
        <form:input path="data" type="date" cssClass="form-control"/>
    </div>
</div>