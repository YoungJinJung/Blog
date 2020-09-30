<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../layout/header.jsp" %>

<div class="container">
    <button class="btn btn-secondary" onclick="history.back()">Back</button>
    <button id="btn-update" class="btn btn-warning">Modify</button>
    <c:if test="${boards.user.id == principal.user.id}">
        <button id="btn-delete" class="btn btn-danger">Delete</button>
    </c:if>
    <br><br>
    <div>
        Post ID : <span id="id"><i>${boards.id} </i></span>
        Post Writer : <span><i>${boards.user.username} </i></span>
    </div>
    <br>
    <div class="form-group">
        <h3>${boards.title}</h3>
    </div>
    <hr>
    <div class="form-group">
        <div>${boards.content}</div>
    </div>
    <hr>

</div>
<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp" %>