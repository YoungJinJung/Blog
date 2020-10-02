<%--
  Created by IntelliJ IDEA.
  User: yjjun
  Date: 2020-09-13
  Time: 오후 7:24
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../layout/header.jsp" %>

<div class="container">
    <form action="/auth/loginProc" method="post">
        <div class="form-group">
            <label for="username">User Name</label>
            <input type="username" name="username" class="form-control" placeholder="Enter username" id="username">
        </div>

        <div class="form-group">
            <label for="password">Password</label>
            <input type="Password" name="password" class="form-control" placeholder="Enter password" id="password">
        </div>
        <button id="btn-login" class="btn btn-primary">Sign In</button>
        <a href="https://kauth.kakao.com/oauth/authorize?client_id=ff5f69798cd670d861c1210025ae9df0&redirect_uri=http://localhost:8000/auth/kakao/callback&response_type=code"><img height="38" src="/image/kakao_login_medium.png"></a>
    </form>
</div>
<%@ include file="../layout/footer.jsp" %>