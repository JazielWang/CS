/*window.onload = function () {
    // var username = document.getElementById("username");
    /!*username.ondblclick = function () {
        alert("双击")
    }*!/
    // username.onfocus = function (){
    //     alert("失去焦点")
    // }
    /!*username.onmouseout = function (){
        alert("失去焦点")
    }*!/
    /!*document.getElementById("selectAll").onclick = function () {
        var trs = document.getElementsByName("cb")
        for (let i = 0; i < trs.length; i++) {
            trs[i].checked = true;
        }
    }
    document.getElementById("unSelectAll").onclick = function () {
        var trs = document.getElementsByName("cb")
        for (let i = 0; i < trs.length; i++) {
            trs[i].checked = false;
        }
    }
    document.getElementById("selectRev").onclick = function () {
        var trs = document.getElementsByName("cb")
        for (let i = 0; i < trs.length; i++) {
            trs[i].checked = !trs[i].checked;
        }
    }
    //给所有tr绑定鼠标移到元素之上和移出元素事件
    var trs = document.getElementsByTagName("tr");
    //2.遍历
    for (var i = 0; i < trs.length; i++) {
        //移到元素之上
        trs[i].onmouseover = function(){
            this.className = "over";
        }

        //移出元素
        trs[i].onmouseout = function(){
            this.className = "out";
        }

    }
    var firstC = document.getElementById("firstCb");
    firstC.onclick = function () {
        var trs = document.getElementsByName("cb")
        for (let i = 0; i < trs.length; i++) {
            trs[i].checked = firstC.checked;
        }
    }*!/
    document.getElementById("form").onsubmit = function (){
        return usernameTest && passwordTest;
    }
    //给用户名和密码框分别绑定离焦事件
    document.getElementById("username").onblur = usernameTest;
    document.getElementById("password").onblur = usernameTest;
}*/

window.onload = function(){
    //1.给表单绑定onsubmit事件
    document.getElementById("form").onsubmit = function(){
        //调用用户校验方法   chekUsername();
        //调用密码校验方法   chekPassword();
        //return checkUsername() && checkPassword();

        return usernameTest() && passwordTest();
    }

    //给用户名和密码框分别绑定离焦事件
    document.getElementById("username").onblur = usernameTest;
    document.getElementById("password").onblur = passwordTest;
}

function usernameTest(){
    var elementById = document.getElementById("username").value;
    var reg_username = /^\w{6,12}$/;
    var flag = reg_username.test(elementById);
    var s_username = document.getElementById("s_username");

    if (flag){
        s_username.innerHTML = "姓名正确";
    }else {
        s_username.innerHTML = "姓名格式错误，应该以..."
    }
    return flag;
}

function passwordTest(){
    var elementById = document.getElementById("password").value;
    var reg_password = /^\w{6,12}$/;
    var flag = reg_password.test(elementById);
    var s_password = document.getElementById("s_password");

    if (flag){
        s_password.innerHTML = "密码正确";
    }else {
        s_password.innerHTML = "密码格式错误，应该以..."
    }
    return flag;
}