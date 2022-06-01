
// 获取本地存储的数据,每次请求都带上
let jwt = localStorage["jwt"];
let name = localStorage["name"];
console.log("输出:"+jwt);

let frm = $('#form');
frm.submit(function (ev) {
  $.ajax({
    headers: {
      Authorization : jwt,
      'name' : name
    },
    type: "post",
    url: "http://localhost:8090/ssm_bs_v3_we/register",
    data: frm.serialize(),

    success:function(data) {
      console.log(data);
      alert("注册成功!");
    },

    error:function(data){
      console.log(data);
    }
  });
  ev.preventDefault();
});