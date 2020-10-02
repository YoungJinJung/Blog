<%--
  Created by IntelliJ IDEA.
  User: yjjun
  Date: 2020-09-13
  Time: 오후 7:15
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../layout/header.jsp" %>

<div class="container">
    <form>
        <input type="hidden" id="id" value="${principal.user.id}">
        <div class="form-group">
            <label for="username">User Name</label>
            <input type="username" value="${principal.user.username}" class="form-control" placeholder="Enter username"
                   id="username" readonly>
        </div>
        <c:if test="${principal.user.loginType eq 'GENERAL'}">
            <div class="form-group">
                <label for="password">Password</label>
                <input type="Password" class="form-control" placeholder="Enter password" id="password">
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" value="${principal.user.email}" class="form-control" placeholder="Enter email"
                       id="email" readonly>
            </div>
        </c:if>

    </form>
    <button id="btn-update" class="btn btn-primary">Update</button>

</div>
<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp" %>