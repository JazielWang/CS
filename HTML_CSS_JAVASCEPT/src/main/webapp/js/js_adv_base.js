var lightObject = document.getElementById("light");
lightObject.innerText
var flag = false;
function fun(){
    if (flag){
        lightObject.src="../img/off.gif"
        flag = false;
    }else {
        lightObject.src = "../img/on.gif"
        flag = true;
    }
}
lightObject.onclick = fun;