//Render số box = số lượng màu ra ngoài màn hình bằng javascript (5 box)
// Box được tạo bởi thẻ div, có class=“box”, background tương ứng với từng mã màu
// Cập nhật số lượng total box trong thẻ <span> có class “points”
// Khi bấm vào box bất kỳ thì box đó biến mất, đồng thời số lượng total box giảm đi 1
// Khi click vào nút “more box” thì số lượng box tăng lên 5 (tương ứng với 5 màu trong mảng colors), đồng thời số lượng total box cũng tăng lên 5
document.addEventListener("DOMContentLoaded", () => {
  const btn = document.getElementById("btn");
  const boxesContainer = document.querySelector(".boxes");
  const scoreSpan = document.querySelector(".points");

  let colors = ["#3498db", "#9b59b6", "#e74c3c", "#2c3e50", "#d35400"];

  
  const updateScore = () => {
    const boxCount = boxesContainer.querySelectorAll(".box").length;
    scoreSpan.textContent = boxCount;
  };

  // Hàm tạo 5 hộp mới
  const createBoxes = () => {
    colors.forEach((color) => {
      const box = document.createElement("div");
      box.classList.add("box");
      box.style.backgroundColor = color;

      // Xóa hộp khi click vào
      box.addEventListener("click", () => {
        box.remove();
        updateScore();
      });

      boxesContainer.appendChild(box);
    });
    updateScore();
  };

  // Xử lý sự kiện khi nhấn nút "more box"
  btn.addEventListener("click", () => {
    createBoxes();
  });

  // Tạo 5 hộp ban đầu
  createBoxes();
});
