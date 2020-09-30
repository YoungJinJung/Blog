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
    udpate: function () {
        let id = $("#id").val();
        let data = {
            title: $("#title").val(),
            content: $("#content").val(),
        };

        $.ajax({
            type: "PUT",
            url: "/api/board/" + id,
            contentType: "application/json; charset=utf-8",
        }).done(function (resp) {
            alert("Success Modify Post");
            location.href = "/";
        }).fail(function (error) {
            alert(JSON.stringify(error))
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
    }
}

index.init();