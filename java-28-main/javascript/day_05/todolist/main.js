// Tạo mảng todos (mockup data)
let todos = [
    { id: 1, name: "Đi chơi với bạn", status: true },
    { id: 2, name: "Đá bóng", status: false },
    { id: 3, name: "Làm bài tập JS", status: true },
    { id: 4, name: "nskdkkd", status: false },
];

// Hiển thị danh sách todo ra ngoài giao diện
const ul = document.querySelector("ul");
const renderTodos = (todos) => {
    if (todos.length === 0) {
        ul.innerHTML = "<li>Danh sách công việc trống</li>";
        return;
    }

    let html = "";
    todos.forEach(todo => {
        html += `
            <li>
                <input 
                    type="checkbox" 
                    ${todo.status ? "checked" : ""}
                    onchange="toggleStatus(${todo.id})"
                />
                <span class=${todo.status ? "active" : ""}>${todo.name}</span>
                <button>Edit</button>
                <button onclick="deleteTodo(${todo.id})">Delete</button>
            </li>
        `;
        // if (!todo.status) {
        //     html += `
        //     <li>
        //         <input type="checkbox" />
        //         <span>${todo.name}</span>
        //         <button>Edit</button>
        //         <button>Delete</button>
        //     </li>
        //     `
        // } else {
        //     html += `
        //     <li>
        //         <input type="checkbox" checked />
        //         <span class="active">${todo.name}</span>
        //         <button>Edit</button>
        //         <button>Delete</button>
        //     </li>
        //     `
        // }
    });
    ul.innerHTML = html;
}

const deleteTodo = (id) => {
    const isConfirm = window.confirm("Bạn có chắc chắn muốn xóa công việc này không?");
    if(!isConfirm) return;

    // todos = todos.filter(todo => todo.id !== id);
    const index = todos.findIndex((todo) => todo.id === id);
    todos.splice(index, 1);
    renderTodos(todos);
};

const toggleStatus = (id) => {
    // const index = todos.findIndex(todo => todo.id === id);
    // todos[index].status = !todos[index].status;

    const todo = todos.find(todo => todo.id === id);
    todo.status = !todo.status;
    renderTodos(todos);
};

renderTodos(todos);