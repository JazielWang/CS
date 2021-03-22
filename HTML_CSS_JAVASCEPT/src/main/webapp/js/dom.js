// document
var tagName = document.getElementsByTagName("div");
// alert(tagName.length);
var className = document.getElementsByClassName("div4");
// alert(className.length);
var byName = document.getElementsByName("username");
// alert(byName.length);

// element
var elementById = document.getElementById("username");
var del = document.getElementById("del");
var set = document.getElementById("set");


// Node
var div5 = document.getElementById("div5");
var div1 = document.getElementById("div1");
/*del.onclick = function () {
    div1.removeChild(div5);
}
set.onclick = function () {
    div1.appendChild(div5);
}*/

// dynamic table

var add = document.getElementById("btn_add");

add.onclick = function () {
    var id = document.getElementById("id").value;
    var name = document.getElementById("name").value;
    var gender = document.getElementById("gender").value;
    var table = document.getElementsByTagName("table")[0];
    table.innerHTML += "<tr>\n" +
        "        <td>" + id + "</td>\n" +
        "        <td>" + name + "</td>\n" +
        "        <td>" + gender + "</td>\n" +
        "        <td><a href=\"javascript:void(0);\" onclick=\"delTr(this);\" >删除</a></td>\n" +
        "    </tr>"
}

function delTr(obj) {
    var table = obj.parentNode.parentNode.parentNode;
    var tr = obj.parentNode.parentNode;
    table.removeChild(tr);
}