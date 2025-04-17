// C1: HTML-Atrribute
const sayHello = () => {
    alert("Xin chào các bạn 1");
};

// C2: DOM Property
const btn2 = document.getElementById("btn2");
// btn2.onclick = () => {
//     alert("Xin chào các bạn 2");
// };

const sayHello2 = () => {
    alert("Xin chào các bạn 2");
};
btn2.onclick = sayHello2;

// C3: Method addEventListener
const btn3 = document.getElementById("btn3");
// btn3.addEventListener("click", () => {
//     alert("Xin chào các bạn 3");
// })

const sayHello3 = () => {
    alert("Xin chào các bạn 3");
};
btn3.addEventListener("click", sayHello3)


// Yêu cầu 1:
// Khi nhấn vào button “Change content” hiển thị một nội dung quote bất kỳ
// Tạo mảng chứa các quote -> Random 1 quote trong mảng đó
function getRandomElement(arr) {
    return arr[Math.floor(Math.random() * arr.length)];
}
// Yêu cầu 2:
// Khi nhấn vào button “Change color” thì thay đổi màu của thẻ p (sử dụng màu HEX - cần viết 1 function để random màu HEX)
// Hàm random màu HEX -> Lên google search
function getRandomHexColor() {
    return `#${Math.floor(Math.random() * 16777215).toString(16).padStart(6, '0')}`;
}

// Yêu cầu 3:
// Khi nhấn vào button “Change background” thì thay đổi màu background-color của thẻ p (sử dụng màu RGB - cần viết 1 function để random màu RGB)
// Hàm random màu RGB -> Lên google search
function getRandomRgbColor() {
    const r = Math.floor(Math.random() * 256);
    const g = Math.floor(Math.random() * 256);
    const b = Math.floor(Math.random() * 256);
    return `rgb(${r}, ${g}, ${b})`;
}