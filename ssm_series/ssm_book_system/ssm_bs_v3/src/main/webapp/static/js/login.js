
let frm = $('#form');

frm.submit(function (ev) {
  $.ajax({
    type: "post",
    url: "http://localhost:8090/ssm_bs_v3_we/login",
    data: frm.serialize(),

    success:function(data) {
      console.log(data)
      let json = jQuery.parseJSON(data);
      let jwt = json.jwt;


      // 登录成功,存储令牌到本地
      localStorage["jwt"] = jwt;
      localStorage["name"] = json.name;

      console.log(jwt);
      alert("登录成功!");
    },

    error:function(data){
      console.log(data)
    }
  });
  ev.preventDefault();
});

