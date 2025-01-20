//Truy cập vào thẻ h1 có id=“heading” thay đổi màu chữ thành ‘red’, và in hoa nội dung của thẻ đó

const heading = document.getElementById("heading");
console.log(heading);

const heading1 = document.querySelector("#heading");
console.log(heading1);

const heading2 = document.querySelector("h1");
console.log(heading2);

heading.style.color = "red";
heading.style.textTransform = "uppercase";

//Thay đổi màu chữ của tất cả thẻ có class “para” thành màu “blue” và có font-size = “20px”

const paraList = document.querySelectorAll(".para");
console.log(paraList);

paraList.forEach((para) => {
    para.style.color = "blue";
    para.style.fontSize = "20px";
});

//Thêm thẻ a link đến trang ‘facebook’ ở đằng sau thẻ có class “para-3”

const link = document.createElement("a");
link.href = "https://facebook.com";
link.innerText = "Facebook";
console.log(link);

const contentEl = document.querySelector(".content");
console.log(contentEl);
document.body.insertBefore(link, contentEl);

//Thay đổi nội dung của thẻ có id=“title” thành “Đây là thẻ tiêu đề”

const titleEl = document.getElementById("title");
titleEl.innerText = "Đây là thẻ tiêu đề";

//Thêm class “text-bold” vào thẻ có class=“description” (định nghĩa class “text-bold” có tác dụng in đậm chữ)

const descriptionEl = document.querySelector(".description");
descriptionEl.classList.add("text-bold");
console.log(descriptionEl.classList.contains("text-bold")); //true
console.log(descriptionEl.classList.contains("text-red"));  //false

descriptionEl.classList.remove("description");

setInterval (() => {
    descriptionEl.classList.toggle("text-bold")
}, 1000); //1000ms = 1s

//Thay thế thẻ có class=“para-3” thành thẻ button có nội dung là “Click me”

const btn = document.createElement("button");
btn.innerText = "Click me";
console.log(btn);

const para3 = document.querySelector(".para-3");
document.body.replaceChild(btn, para3);

//Copy thẻ có class=“para-2” và hiển thị ngay đằng sau thẻ đó

const para2 = document.querySelector(".para-2");
const para2Clone = para2.cloneNode(true);
document.body.insertBefore(para2Clone, btn);

//Xóa thẻ có class=“para-1”

const para1 = document.querySelector(".para-1");
document.body.removeChild(para1);

