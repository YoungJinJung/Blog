let index = {
    init: function () {
        $("#btn-save").on("click", () => {
            this.save();
        });
    },
    save: function () {
        //alert("call user's Save func");
        let data = {
            userName: $("#userName").val(),
            password: $("#password").val(),
            email: $("#email").val()
        }

        //ajax default : async call
        //ajax default type json
        $.ajax({
            type: "POST",
            url: "/blog/api/user",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
        }).done(function (resp) {
            alert("Success Sign Up");
            location.href = "/blog";
        }).fail(function (error) {
            alert(JSON.stringify(error))
        });
    }
}

index.init();