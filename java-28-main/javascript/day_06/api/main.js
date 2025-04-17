/*
1. API là gì?
API (Application Programming Interface)
Thành phần trung gian dùng để giao tiếp giữa các ứng dụng, hoặc các dịch vụ trong ứng dụng

Khách hàng: Client - Gửi yêu cầu
Nhân viên: Trung gian, gửi yêu cầu, nhận kết quả (API)
Nhà bếp: Server - Xử lý yêu cầu

2. Cấu tạo của 1 API bao gồm những gì?
API URL: Đường dẫn API: https://dog.ceo/api/breeds/image/random
Http method: Hành động tác động lên tài nguyên (resourse): GET, POST, PUT, PATCH, DELETE - CURD
Http status code: Trạng thái response: 1x, 2x, 3x, 4x, 5x
Request: Chứa thông tin yêu cầu
    - Headers: Thông tin về request
    - Body: Thông tin gửi kèm theo
Response: Chứa thông tin trả về
    - Headers: Thông tin về response
    - Body: Thông tin trả về
*/

// https://dog.ceo/api/breeds/image/random
const btn = document.getElementById('btn');
const image = document.getElementById('image');

// C1: Sử dụng build-in fetch trong js
// C1.1: Sử dụng promise
// btn.addEventListener('click', () => {
//     fetch("https://dog.ceo/api/breeds/image/random")
//         .then(response => {
//             console.log(response);
//             return response.json();
//         })
//         .then(data => {
//             console.log(data); 
//             // {message: "https://images.dog.ceo/breeds/terrier-irish/n02093991_1003.jpg", status: "success"}
//             image.src = data.message;
//         })
//         .catch(error => {
//             console.log(error);
//         });
// });

// C1.2: Sử dụng async await
// btn.addEventListener('click', async () => {
//     try {
//         let response = await fetch("https://dog.ceo/api/breeds/image/random");
//         console.log(response);

//         let data = await response.json();
//         console.log(data);

//         image.src = data.message;
//     } catch (error) {
//         console.log(error);
//     }
// });

// C2: Sử dụng thư viện axios
// btn.addEventListener('click', () => {
//     axios.get("https://dog.ceo/api/breeds/image/random")
//         .then(function (response) {
//             console.log(response);
//             image.src = response.data.message;
//         })
//         .catch(function (error) {
//             console.log(error);
//         });
// });

btn.addEventListener('click', async () => {
    try {
        let response = await axios.get("https://dog.ceo/api/breeds/image/random");
        console.log(response);
        image.src = response.data.message;
    } catch (error) {
        console.log(error);
    }
});