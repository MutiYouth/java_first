/**

 @author Cheetah
 @date 2022-06-03 22:33
 */

// 获取本地存储的数据,每次请求都带上。
// 用于jwt验证的东西。
let jwt = localStorage["jwt"];
let name = localStorage["name"];
console.log("输出:" + jwt);

function func_ts(){
    $.ajax({
        headers: {
            Authorization: jwt,
            'name': name
        },
        type: "get",
        url: "http://localhost:8090/ssm_bs_v3_we/test_s_session",
        data: {name: "tomas"},

        success: function (data) {
            $("#div_test_session_result").append(data);

            console.log(data);
            alert("success!");
        },

        error: function (data) {
            $("#div_test_session_result").append("<p>failed!</p>");
            console.log(data);
        }
    });
}


$(document).ready(function () {
    let btn_ts = document.getElementById("btn_test_session");
    // btn_ts.onclick = function(){
    //
    // }
    btn_ts.addEventListener('click', func_ts, false);
});






