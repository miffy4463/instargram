// (1) 회원정보 수정
function update(userId, event) {
    event.preventDefault(); // form tag 액션을 막는다.
    let data = $("#profileUpdate").serialize();

    $.ajax({
        type: "put",
        url: `/api/user/${userId}`,
        data: data,
        contentType: "application/x-www-form-urlencoded; charset=utf8",
        dataType: "json"
    }).done(res => { // Http Status 200 번대
        console.log("성공", res);
        location.href = `/user/${userId}`;
    }).fail(error => { // Http Status 200 번대 아니면 fail
        alert(JSON.stringify(error.responseJSON.data));
    });
}