function hello() {
    let hello = document.getElementById("hello");
    let span = document.createElement("span");
    span.innerText = "HELLO THERE!!!"
    hello.append(span);
}