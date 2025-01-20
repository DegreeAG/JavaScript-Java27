// Tạo danh sách todo
// id, title, status

const BASE_URL = "http://localhost:8000/todo";

let todos = [];

const getAllTodos = async () => {
    try {
        const res = await axios.get(BASE_URL)
        console.log(res);

        todos = res.data;
        renderTodos(todos);
    } catch (error) {
        console.log(error);
    }
}

getAllTodos();

const ulEl = document.querySelector("ul");

const renderTodos = (todos) => {
  if (todos.length == 0) {
    ulEl.innerHTML = "<li>Không có công việc nào trong danh sách</li>";
    return;
  }

  let html = "";
  todos.forEach((todo) => {
    html += `
            <li>
                <input 
                    type="checkbox" 
                    ${todo.status ? "checked" : ""}
                    onchange="toggleStatus(${todo.id})"
                />
                <span class=${todo.status ? "active" : ""}>${todo.title}</span>
                <button>Edit</button>
                <button onclick="deleteTodo(${todo.id})">Delete</button>
            </li>
        `;
  });
  ulEl.innerHTML = html;

  // Lấy ra toàn bộ button delete
  // For -> addEventListener cho từng button
};

const deleteTodo = async (id) => {
  const isConfirm = window.confirm("Bạn có chắc chắn muốn xóa không?");
  if (!isConfirm) return;

    //Xóa ở server 
    try {
        //Xóa ở server 
        await axios.delete(`${BASE_URL}/${id}`);

        //Xóa ở client 
        todos = todos.filter((todo) => todo.id !== id);

        // Render lại giao diện 
        renderTodos(todos);

    } catch (error) {
        console.log(error);
    }



};

// Thêm công việc

const inputEl = document.querySelector("#todo-input");
const addBtn = document.querySelector("#add-todo-btn");

const addTodo = async () => {
  const title = inputEl.value.trim();

  // Kiểm tra xem tiêu đề có rỗng không
  if (title === "") {
    alert("Vui lòng nhập công việc!");
    return;
  }

  try {
    // Gửi yêu cầu POST đến server
    const res = await axios.post(BASE_URL, {
      title: title,
      status: false, // Mặc định trạng thái là chưa hoàn thành
    });

    // Cập nhật danh sách todos
    todos.push(res.data);

    // Hiển thị lại danh sách
    renderTodos(todos);

    // Xóa nội dung trong ô input
    inputEl.value = "";
  } catch (error) {
    console.log(error);
  }
};

// Gán sự kiện click cho nút thêm công việc
addBtn.addEventListener("click", addTodo);

// Xóa công việc

renderTodos(todos);
