let index = {
    init: function () {
        $("#btn-save").on("click", () => {
            this.save();
        });
        $("#btn-delete").on("click", () => {
            this.deleteById();
        });
        $("#btn-update").on("click", () => {
            this.update();
        });
        $("#btn-reply-save").on("click", () => {
            this.replySave();
        });
    },
    save: function () {
        let data = {
            title: $("#title").val(),
            content: $("#content").val(),
        }

        //ajax default : async call
        //ajax default type json
        $.ajax({
            type: "POST",
            url: "/api/board",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
        }).done(function (resp) {
            alert("Success Save Post");
            location.href = "/";
        }).fail(function (error) {
            alert(JSON.stringify(error))
        });
    },
    deleteById : function (boardId) {
        console.log(boardId);
        $.ajax({
            type: "DELETE",
            url: `/api/board/${boardId}`,
            contentType: "application/json; charset=utf-8",
        }).done(function (resp) {
            alert("Success Delete Post");
            location.href = "/";
        }).fail(function (error) {
            alert(JSON.stringify(error))
        });
    },
    update: function () {
        let id = $("#id").val();
        let data = {
            title: $("#title").val(),
            content: $("#content").val(),
        };

        $.ajax({
            type: "PUT",
            url: "/api/board/" + id,
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
        }).done(function (resp) {
            alert("Success Modify Post");
            location.href = "/";
        }).fail(function (error) {
            alert(JSON.stringify(error))
        });
    },
    replySave: function () {
        let data = {
            userId: $("#userId").val(),
            boardId: $("#boardId").val(),
            content: $("#reply-content").val()
        }

        $.ajax({
            type: "POST",
            url: `/api/board/${data.boardId}/reply`,
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
        }).done(function (resp) {
            alert("Success Save Reply");
            location.href = `/board/${data.boardId}`;
        }).fail(function (error) {
            alert(JSON.stringify(error))
        });
    },

    replyDelete: function (boardId, replyId) {
        $.ajax({
            type: "DELETE",
            url: `/api/board/${boardId}/reply/${replyId}`,
            contentType: "application/json; charset=utf-8",
        }).done(function (resp) {
            alert("Success Remove Reply");
            location.href = `/board/${boardId}`;
        }).fail(function (error) {
            alert(JSON.stringify(error))
        });
    }


}

index.init();