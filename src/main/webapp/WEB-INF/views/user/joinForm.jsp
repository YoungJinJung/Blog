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
        <div class="form-group">
            <label for="username">User ID</label>
            <input type="username" placeholder="Enter ID" id="username">
            <span class="point checkNameComment">ID은 2자 이상 10자 이하로 설정해주시기 바랍니다.</span>
            <input type="hidden" id="doubleCheckName"/>
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="Password" placeholder="Enter password" id="password">
        </div>
        <div class="form-group">
            <label for="password">Validation Password</label>
            <input type="Password" placeholder="Enter password" id="validPassword">
            <span class="point checkPwdComment"></span>
            <input type="hidden" id="doubleCheckPwd"/>
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input id="email" class="email" type="text" name="sm_email" title="이메일 주소를 입력해주세요." required/>
            <span id="checkEmailBtn" class="btn btn-info">인증번호 보내기</span><br/>
            <label for="validEmail">Validation Email</label>
            <input id="validEmail" class="number" type="text" name="sm_email2" title="인증번호 입력" disabled required/>
            <span id="validEmailBtn" class="btn btn-info">이메일인증</span>
            <span class="point checkEmailComment">이메일 입력후 인증번호 보내기를 해주십시오.</span>
            <input type="hidden" id="doubleCheckEmail"/>
        </div>
        <div class="form-group">
            <label for="datepicker">birthDay</label>
            <input type="birthDay" placeholder="Enter birthDay" id="datepicker">
        </div>
        <div class="form-group">
            <label for="phoneNumber">H.P</label>
            <input type="phoneNumber" class="number" placeholder="Enter phoneNumber" id="phoneNumber">
        </div>
    </form>
    <button id="btn-save" class="btn btn-primary">Sign Up</button>

</div>
<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp" %>