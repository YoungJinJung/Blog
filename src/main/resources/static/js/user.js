let index = {
    init: function () {
        $("#btn-save").on("click", () => {
            this.save();
        });
        $("#btn-update").on("click", () => {
            this.update();
        });
    },
    save: function () {
        //alert("call user's Save func");
        let data = {
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val()
        }

        //ajax default : async call
        //ajax default type json
        $.ajax({
            type: "POST",
            url: "/auth/joinProc",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
        }).done(function (resp) {
            if(resp.status == 500) {
                alert("Failed to Sign Up");
            } else {
                alert("Success Sign Up");
                location.href = "/";
            }
        }).fail(function (error) {
            alert(JSON.stringify(error))
        });
    },

    update: function () {

        let data = {
            id: $("#id").val(),
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val()
        }

        //ajax default : async call
        //ajax default type json
        $.ajax({
            type: "PUT",
            url: "/user",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
        }).done(function (resp) {
            alert("Success Update User Info");
            location.href = "/";
        }).fail(function (error) {
            alert(JSON.stringify(error))
        });
    }

    /*login: function () {
        let data = {
            us erName: $("#username").val(),
            password: $("#password").val(),
        }

        //ajax default : async call
        //ajax default type json
        $.ajax({
            type: "POST",
            url: "/api/user/login",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
        }).done(function (resp) {
            alert("Success Sign In");
            location.href = "/";
        }).fail(function (error) {
            alert(JSON.stringify(error))
        });
    }*/
}

$("#username").blur(function(){
    let inputUserName = $("#username").val();
    if(inputUserName == "" || inputUserName.length < 2){
        $(".checkNameComment").text("이름은 2자 이상 8자 이하로 설정해주세요 :)");
        $(".checkNameComment").css("color", "red");
        $("#doubleCheckName").val("false");
    }else{
        $.ajax({
            url : '/auth/checkUserName/'+ inputUserName,
            type : 'post',
            cache : false,
            success : function(data) {
                if (data.data == 0) {
                    $(".checkNameComment").text("사용가능한 이름입니다.");
                    $(".checkNameComment").css("color", "green");
                    $("#doubleCheckName").val("true");
                } else {
                    $(".checkNameComment").text("사용중인 이름입니다 :p");
                    $(".checkNameComment").css("color", "red");
                    $("#doubleCheckName").val("false");
                }
            }, error : function() {
                console.log("실패");
            }
        });
    }
});

//비밀번호 확인
$("#validPassword").blur(function(){
    if($("#validPassword").val() == $("#password").val()){
        $(".checkPwdComment").text("비밀번호가 일치합니다.");
        $(".checkPwdComment").css("color", "green");
        $("#doubleCheckPwd").val("true");
    }else{
        $(".checkPwdComment").text("비밀번호가 일치하지 않습니다.");
        $(".checkPwdComment").css("color", "red");
        $("#doubleCheckPwd").val("false");
    }
});

var code = "";
$("#checkEmailBtn").click(function(){
    var inputEmail = $("#email").val();
    $.ajax({
        type:"GET",
        url:"/auth/checkMail/" + inputEmail,
        cache : false,
        success:function(data){
            if(data == "error"){
                alert("이메일 주소가 올바르지 않습니다. 유효한 이메일 주소를 입력해주세요.");
                $("#email").attr("autofocus",true);
                $(".checkEmailComment").text("유효한 이메일 주소를 입력해주세요.");
                $(".checkEmailComment").css("color","red");
            }else{
                alert("인증번호 발송이 완료되었습니다.\n입력한 이메일에서 인증번호 확인을 해주십시오.");
                $("#validEmail").attr("disabled",false);
                $("#validEmailBtn").css("display","inline-block");
                $(".checkEmailComment").text("인증번호를 입력한 뒤 이메일 인증을 눌러주십시오.");
                $(".checkEmailComment").css("color","green");
                code = data.data;
            }
        }
    });
});

//이메일 인증번호 대조
$("#validEmailBtn").click(function(){
    if($("#validEmail").val() == code){
        $(".checkEmailComment").text("인증번호가 일치합니다.");
        $(".checkEmailComment").css("color","green");
        $("#doubleCheckEmail").val("true");
        $("#validEmail").attr("disabled",true);
    }else{
        $(".checkEmailComment").text("인증번호가 일치하지 않습니다. 확인해주시기 바랍니다.");
        $(".checkEmailComment").css("color","red");
        $("#doubleCheckEmail").val("false");
        $("#validEmail").attr("autofocus",true);
    }
});

index.init();