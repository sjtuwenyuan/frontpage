/**
 * Created by Wen on 17/3/5.
//  */
// function login() {
//     var result = document.getElementById("inputUsername").value;
//     var password = document.getElementById("inputPassword").value;
//     if (result == "") {
//         alert("用户名不能为空");
//         return false;
//     }
//     if (password == "") {
//         alert("密码不能为空");
//         return false;
//     }
// }

$(function () {
    alert("hi");
    $("#txtName").focus();//输入焦点
    $("#txtName").keydown(function (event) {
        if (event.which == "13") {//回车键,移动光标到密码框
            $("#txtPass").focus();
        }
    });
    $("#txtPass").keydown(function (event) {
        if (event.which == "13") {//回车键，用.ajax提交表单
            $("#btnLogin").trigger("click");
        }
    });
    $("#btnLogin").click(function () { //“登录”按钮单击事件
        alert("hi");
        //获取用户名称
        var strTxtName = encodeURI($("#inputUsername").val());
        //获取输入密码
        var strTxtPass = encodeURI($("#inputPassword").val());
        //开始发送数据
        $.ajax({ //请求登录处理页
            type: "POST",
            dataType: "html",
            url: "/tokens", //登录处理页
            //传送请求数据
            data: {txtName: strTxtName, txtPass: strTxtPass},
            success: function (strValue) { //登录成功后返回的数据
                //根据返回值进行状态显示
                alert("success");
            },
            error: function (data) {
                alert("error:" + data.responseText);
            }
        })
    })
})