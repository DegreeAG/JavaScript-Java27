let user = {
    name: "Nguyễn Văn A",
    age: 23,
    email: "abc@gmail.com",
    languages: ["Vietnamese", "English", "Chinese"],
    address: {
        province: "Hà Nội",
        district: "Thanh Xuan",
        ward: "Nhân Chính"
    },
    work: function () {
        console.log("Working...");
    },
    eat: function (foodName) {
        console.log("Eating " + foodName);
    }
}

console.log(user.name);
console.log(user["name"]);
console.log(user.languages[1]);
console.log(user.address.ward);
user.work();
user.eat("Bún chả");

for (const key in user) {
    console.log(user[key]);
}

// Viết hàm cho phép truyền vào 1 mảng các số
// kết quả trả về là 1 mảng mới với các số là số dư tương ứng khi chia mảng cũ cho 2
// Vd : modulo2([4,2,5,6,2,7]) => [0,0,1,0,0,1]

const modulo2 = (arr) => {
    const rs = [];
    arr.forEach(e => {
        rs.push(e % 2);
    });
    return rs;
};
console.log(modulo2([4, 2, 5, 6, 2, 7]));

const modulo2_1 = (arr) => arr.map(e => e % 2);
console.log(modulo2_1([4, 2, 5, 6, 2, 7]));