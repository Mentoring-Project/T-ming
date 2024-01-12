$(document).ready(() => {

    const $id = $("input[name=id]");
    const $joinSubmitBtn = $(".devJoinSubmit");

    const checkMemberId = () => {
        let idValue = {"id": $id.val().trim()};
        const $checkResult = $("#checkResult");

        $.ajax({
            type: "post",
            url: "/member/checkId",
            data: idValue,
            success: function(data) {
                console.log("요청성공", data);
                if(data == "ok") {
                    $checkResult.text("사용 가능한 아이디 입니다.");
                    $checkResult.css("color", "green");
                } else {
                    $checkResult.text("이미 사용중인 아이디 입니다.");
                    $checkResult.css("color", "red");
                }
            },
            error: function(err) {
                console.log("error, ", err);
            }
        });
    }

    $id.on("blur", () => { checkMemberId() });


    $joinSubmitBtn.on("click", (e) => {
        const $joinForm = $("#joinForm");
        let checkValue = "false";

        if( !$("input[name=id]").val().trim() ) {
            alert("아이디를 입력해 주세요.");
            return false;
        } else if( !$("input[name=password]").val().trim() ) {
            alert("비밀번호를 입력해 주세요.");
            return false;
        } else {
            checkValue = true;
        }

        if(checkValue) {
            $joinForm.submit();
        }
    });

});