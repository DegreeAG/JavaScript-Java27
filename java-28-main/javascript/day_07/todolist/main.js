// Tạo mảng todos (mockup data)
const API_URL = "http://localhost:3000/todos";
let todos = [];

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
    });
    ul.innerHTML = html;
}

// Lấy danh sách todo từ server
const getAllTodos = async () => {
    try {
        let res = await axios.get(API_URL); // Gọi API lấy danh sách todo từ server
        console.log(res);

        todos = res.data; // Gán dữ liệu từ server vào mảng todos

        renderTodos(todos); // Hiển thị danh sách todo ra ngoài giao diện
    } catch (error) {
        console.log(error);
    }
};

const deleteTodo = async (id) => {
    const isConfirm = window.confirm("Bạn có chắc chắn muốn xóa công việc này không?");
    if (!isConfirm) return;
    try {
        // Xóa ở server
        await axios.delete(`${API_URL}/${id}`);

        // Xóa ở client
        const index = todos.findIndex((todo) => todo.id === id);
        todos.splice(index, 1);
        renderTodos(todos);
    } catch (error) {
        console.log(error);
    }
};

const toggleStatus = async (id) => {
    try {
        // Update status ở server
        const todo = todos.find(todo => todo.id === id);
        const request = {
            name: todo.name,
            status: !todo.status
        }
        await axios.put(`${API_URL}/${id}`, request);

        // Update status ở client
        todo.status = !todo.status;
        renderTodos(todos);
    } catch (error) {
        console.log(error);
    }
};

getAllTodos();