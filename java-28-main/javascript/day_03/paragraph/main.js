// 1. Highlight tất cả các từ có độ dài lớn hơn hoặc bằng 5 ký tự trong đoạn văn (background = “yellow”)
const para = document.querySelector("p");
console.log(para);

const content = para.innerText;
console.log(content);

const words = content.split(" ");
console.log(words);

const newWords = words.map(word => {
    if (word.length >= 5) {
        return `<span class="highlight">${word}</span>`;
    }
    return word;
})
console.log(newWords);

para.innerHTML = newWords.join(" ");

// 2. Thêm link hiển thị text “facebook” link đến trang facebook.com ở sau thẻ p
para.insertAdjacentHTML("afterend", `<a href="https://www.facebook.com">facebook</a>`);

// 3. Đếm số từ có trong đoạn văn. Tạo 1 thẻ div để hiển thị số từ
para.insertAdjacentHTML("afterend", `<div>${words.length} words</div>`);

// 4. Thay thế ký hiệu (, - dấu phẩy) => 🤔 và (. - dấu chấm) => 😲
para.innerHTML = para.innerHTML
    .replaceAll(",", "🤔")
    .replaceAll(".", "😲");