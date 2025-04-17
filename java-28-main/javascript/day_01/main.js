console.log("Hello world");

// alert("Hello world");

// document.write("Hello world");

// String name = "John";
// var name = "John";

// ES6: let, const - Java 8
// let | const = final
let name;
console.log(typeof name); // undefined = primitive data type

name = "John";
console.log(typeof name); // string = primitive data type

name = 12;
console.log(typeof name); // number = primitive data type

let age = 30;

let fullName = "Bùi Hiên"
let year = 1997

// Template string
console.log(`Xin chào các bạn, mình tên là ${fullName}. Năm nay ${2025 - year} tuổi`);

console.log("Xin chào các bạn, mình tên là " + fullName + ". Năm nay " + (2025 - year) + " tuổi");

// Function
// C1: Regular function
function sum(a, b) {
    return a + b;
}
console.log(sum(10, 20));

// C2: Function expression -> First-class function
const sum1 = function (a, b) {
    return a + b;
}
console.log(sum(30, 40));

// C3: Arrow function (ES6) - Lambda expression Java 8 (giống cú pháp)
// Default parameter
const sum2 = (a = 100, b = 200) => {
    // if (a === undefined) {
    //     a = 100;
    // }
    // if (b === undefined) {
    //     b = 200;
    // }
    let email = "a@gmail.com"
    console.log(email);
    console.log(a, b);
    return a + b;
}

// const sum2 = (a, b) => a + b;
console.log(sum2());

// Block scope
{
    let firstName = "Peter";
    console.log(firstName);
}
console.log(firstName);