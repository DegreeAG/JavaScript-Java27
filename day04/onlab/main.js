const sayHello = () => {
    alert ("Xin chao cac ban 1");
}

const btn2 = document.getElementById("btn-2");

const sayHello2 = () => {
    alert("Xin chao cac ban 2");
}
btn2.onclick = sayHello2;

const btn3 = document.getElementById("btn-3");

const sayHello3 = () => {
  alert("Xin chao cac ban 3");
}
btn3.addEventListener("click", sayHello)