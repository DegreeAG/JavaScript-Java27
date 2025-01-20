//Lắng nghe sự kiện click ở 3 nút button theo 3 cách sau :

//Button “Change content” sử dụng “HTML-attribute”
//Button “Change color” sử dụng “DOM property”
//Button “Change background” sử dụng “addEventListener”
//Thực hiện các chức năng sau:

//Yêu cầu 1:

//Khi nhấn vào button “Change content” hiển thị một nội dung quote bất kỳ
const para = document.getElementById("text");
function changeContent() {
  const quotes = [
    "The best way to predict the future is to create it.",
    "Life is 10% what happens to us and 90% how we react to it.",
    "Do not wait to strike till the iron is hot, but make it hot by striking.",
    "In the middle of every difficulty lies opportunity.",
    "Success is not how high you have climbed, but how you make a positive difference to the world.",
  ];
  const randomIndex = Math.floor(Math.random() * quotes.length);
  para.innerText = quotes[randomIndex];
}

//Yêu cầu 2:
//Khi nhấn vào button “Change color” thì thay đổi màu của 
// thẻ p (sử dụng màu HEX - cần viết 1 function để random màu HEX)

const HexColor = () => {
  const letter = "0123456789ABCDEF";
  let color = "#";
  for (let i = 0; i < 6; i++) {
    color += letter[Math.floor(Math.random() * 16)];
  }
  return color;
};

const changeColor = () => {
  const text = document.getElementById("text");
  text.style.color = HexColor();
};

const btn2 = document.getElementById("btn-2");
btn2.onclick = changeColor;

//Yêu cầu 3:

//Khi nhấn vào button “Change background” thì thay đổi màu 
// background-color của thẻ p 
// (sử dụng màu RGB - cần viết 1 function để random màu RGB)

const randomRGBColor = () => {
  const r = Math.floor(Math.random() * 256);
  const g = Math.floor(Math.random() * 256);
  const b = Math.floor(Math.random() * 256);
  const color = `rgb(${r}, ${g}, ${b})`;
  return color;
};

const changeBackgroundColor = () => {
  para.style.backgroundColor = randomRGBColor();
};

const btn3 = document.getElementById("btn-3");
btn3.addEventListener("click", changeBackgroundColor);

// Lắng nghe sự kiện keydown

document.addEventListener("keydown", function (event){
    console.log(event);
});

window.addEventListener("scroll", function (event) {
    console.log(event);
});

// Lăng nghe sự kiện scroll

const btnTop = document.getElementById("top");
window.addEventListener("scroll", function (event){
    if (this.document.documentElement.scrollTop>200){
        btnTop.classList.remove("hide");
    } else {
        btnTop.classList.add("hide");
    }
});

btnTop.addEventListener("click", () => {
    window.scrollTo ({
        top: 0,
        behavior: "smooth"
    });
})
