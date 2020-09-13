<%--
  Created by IntelliJ IDEA.
  User: yjjun
  Date: 2020-09-13
  Time: 오후 7:24
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../layout/header.jsp" %>

<div class="container">
    <form action="/action_page.php">
        <div class="form-group">
            <label for="userName">User Name</label>
            <input type="userName" class="form-control" placeholder="Enter userName" id="userName">
        </div>

        <div class="form-group">
            <label for="password">Password</label>
            <input type="Password" class="form-control" placeholder="Enter password" id="password">
        </div>

        <div class="form-group form-check">
            <label class="form-check-label">
                <input class="form-check-input" type="checkbox"> Remember me
            </label>
        </div>

        <button type="submit" class="btn btn-primary">Sign In</button>
    </form>
</div>
<%@ include file="../layout/footer.jsp" %>