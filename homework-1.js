//Bài 1
function factorial(n) {
  if (n < 0) {
    throw new Error("Số phải là số nguyên dương.");
  }
  if (n === 0 || n === 1) {
    return 1;
  }
  return n * factorial(n - 1);
}
//Bài 2
function reverseString(str) {
  if (typeof str !== "string") {
    throw new Error("Tham số đầu vào phải là chuỗi.");
  }
  return str.split("").reverse().join("");
}
//Bài 3
function greetByCountryCode(countryCode) {
  if (typeof countryCode !== "string") {
    throw new Error("Mã quốc gia phải là một chuỗi.");
  }

  const code = countryCode.toUpperCase();

  switch (code) {
    case "VN":
      return "Xin chào";
    case "US":
      return "Hello";
    case "FR":
      return "Bonjour";
    case "ES":
      return "Hola";
    case "DE":
      return "Hallo";
    case "IT":
      return "Ciao";
    default:
      return "Xin chào (ngôn ngữ không xác định)";
  }
}
//Bài 4
function truncateString(str) {
  if (typeof str !== "string") {
    throw new Error("Tham số đầu vào phải là một chuỗi.");
  }
  if (str.length <= 15) {
    return str;
  }
  return str.slice(0, 10) + "...";
}
