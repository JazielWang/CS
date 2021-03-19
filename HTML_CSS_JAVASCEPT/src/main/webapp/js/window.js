// window.alert("hello")
/*
var confirm = window.confirm();
if (confirm){
    alert("true");
}else {
    alert("false");
}*/

/*var openW = document.getElementById("open");
openW.onclick = function (){
    open("https://www.baidu.com");
}
var closeW = document.getElementById("close");
closeW.onclick = function (){
    close();
}*/

/*function fun() {
    alert("Boom~~~");
}
setInterval(fun, 3000);*/

var lunbo = document.getElementById("light");
setInterval(fun, 3000);
var num = 1;
function fun() {
    num++;
    if (num > 3) {
        num = 1;
    }
    lunbo.src = "../img/banner_" + num + ".jpg";
}