<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../layout/header.jsp" %>

<div class="container">
    <button class="btn btn-secondary" onclick="history.back()">Back</button>
    <button id="btn-update" class="btn btn-warning">Modify</button>
    <button id="btn-delete" class="btn btn-danger">Delete</button>
    <br><br>
    <div class="form-group">
        <h3>${board.title}</h3>
    </div>
    <hr>
    <div class="form-group">
        <div>${board.conetent}</div>
    </div>
    <hr>

</div>
<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp" %>