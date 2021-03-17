var fun = function (a, b) {
    document.write(a + b + "<br/>");
}
fun(1, 2);

function f(a, b, c) {
    document.write(arguments[4] + "<br/>");
}
f(1, 2, 3, 4, 5);

var a1 = [1, 3, 5, 6];
var a2 = new Array(3);
document.write(a1 + "<br/>");
document.write(a2 + "<br/>");
document.write(a1.join("--") + "<br/>");
a1.push("123");
document.write(a1 + "<br/>");

var date = new Date();
document.write(date + "<br>");
document.write(date.toLocaleDateString() + "<br>");
document.write(date.getTime() + "<br>");

document.write(Math.random() + "<br>");

var red = /^[\d]{4,5}$/;
var boo = red.test("qwee1")
document.write(boo + "<br>")

var url = "智慧";
var u = encodeURI(url);
var uri1 = decodeURI(u);
document.write(u + "<br>");
document.write(uri1 + "<br>");