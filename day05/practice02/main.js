//Tạo danh sách todo
//id, title. status

const todos = [
  { id: 1, title: "Làm bài tập", status: true },
  { id: 2, title: "Đá bóng", status: false },
  { id: 3, title: "Nấu cơm", status: false },
  { id: 4, title: "Học bài", status: true },
];

const ulEl= document.querySelector("ul");

const renderTodos = (todos) => {
    if (todos.length == 0) {
        ulEl.innerHTML = "<li>Không có công việc nào trong danh sách</li>";
        return;
    }

    let html = "";
    todos.forEach(todo => {
        html += `
          <li>
            <input 
            type="checkbox" 
            ${todo.status ? "checked" : ""}
            onchange = "toggleStatus(${todo.id})"
            />
            <span class = ${todo.status ? "active" : ""}>${todo.title}</span>
            <button>Edit</button>
            <button onclick="deleteTodo(${todo.id})">Delete</button>
          </li>
        `;
    })
    ulEl.innerHTML = html;

    //Lấy ra toàn bọ button delete
    //For -> addEventListener cho từng button
};

const addTodo = () => {
  const title = inputEl.value.trim();

  if (title === "") {
    alert("Vui lòng nhập tên công việc!");
    return;
  }
  const newTodo = {
    id: todos.length ? todos[todos.length - 1].id + 1 : 1,
    title,
    status: false,
  };
  todos.push(newTodo);
  inputEl.value = "";
  renderTodos(todos);
};

const deleteTodo = id => {
    const isConfirm = window.confirm("Bạn có chắc chắn muốn xóa không?");
    if (!isConfirm) return;

    // const index = todos.findIndex(todo => todo.id == id);
    // todos.splice(index, 1);

    todos = todos.filter(todo => todo.id !== id);
    renderTodos(todos);
}

renderTodos(todos);