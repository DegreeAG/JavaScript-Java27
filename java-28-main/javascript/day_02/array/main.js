// Khai báo array rỗng
let arr = [];

// Khai báo array
let number = [];

// Gán giá trị cho các phần tử của array thông qua chỉ số
number[0] = 1;
number[1] = "Bùi Hiên";
number[2] = true;

// Khai báo và khởi tạo giá trị cho array
let myArr = [1, 2, 3, 4, true, false, "Nguyễn Văn A"];
console.log(myArr);

for (let i = 0; i < myArr.length; i++) {
    console.log(myArr[i]);
}

// value = myArr[i]
myArr.forEach((value, index) => {
    if (index === 3) return;
    console.log(value, index);
})

// value = myArr[i]
for (const value of myArr) {
    console.log(value);
}

// Array methods
// 1. push()
myArr.push(5);
console.log(myArr);

// 2. pop()
myArr.pop();
console.log(myArr);

// splice
myArr.splice(2, 2, 10);
console.log(myArr);