$(document).ready(() => {

    const $id = $("input[name=id]");
    const $joinSubmitBtn = $(".devJoinSubmit");

    const checkMemberId = () => {
        const idValue = $id.val().trim();
        const $checkResult = $("#checkResult");
        const regexKr = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;

        if(idValue == "") {
            $id.val("").focus();
            $checkResult.hide();
            return false;
        }

        if(regexKr.test(idValue)) {
            alert("한글을 제외한 영문과 숫자만 입력해 주세요.");
            $id.val("").focus();
            $checkResult.hide();
            return false;
        }

        $.ajax({
            type: "get",
            url: `/member/${idValue}`,
            data: {id: idValue},
            success: function(data) {
                if(data == true) {
                    $checkResult.show().text("사용 가능한 아이디 입니다.");
                    $checkResult.css("color", "green");
                } else {
                    $checkResult.show().text("이미 사용중인 아이디 입니다.");
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