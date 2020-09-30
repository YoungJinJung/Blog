<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../layout/header.jsp" %>

<div class="container">
    <form>
        <input type="hidden" id="id" value="${boards.id}">
        <div class="form-group">
            <input value=${boards.title} type="text" name="title" class="form-control" placeholder="Enter title" id="title">
        </div>

        <div class="form-group">
            <textarea class="form-control summernote" rows="5" id="content">value=${boards.content}</textarea>
        </div>
    </form>
    <button id="btn-update" class="btn btn-primary">Save</button>

</div>

<script>
    $('#summernote').summernote({
        tabsize: 2,
        height: 100
    });
</script>

<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp" %>