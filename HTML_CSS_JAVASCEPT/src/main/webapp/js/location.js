/*
var reloadW = document.getElementById("reload");
var href = location.href;
reloadW.onclick = function (){

    location.reload();
}*/

/*
var href = location.href;
var elementById = document.getElementById("href");
elementById.onclick = function (){
    location.href = "https:\\www.baidu.com"
}*/

var change = document.getElementById("change");
var time = 5;
function toBaidu() {
    time--;
    change.innerHTML = time + "";
    if (time <= 0){
        location.href = "https:\\www.baidu.com";
    }
}
setInterval(toBaidu, 1000);