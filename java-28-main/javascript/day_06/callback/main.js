const doTask = (name, time, cb) => {
    console.log("Thực hiện công việc: " + name);
    setTimeout(() => {
        cb();
    }, time);
}

const finish = () => {
    console.log("Hoàn thành công việc");
}

// Th1: Các tác vụ có liên quan đến nhau
// Nhặt rau - Rửa rau - Luộc rau
// console.log("Start");

doTask("Nhặt rau", 2000, () => {
    doTask("Rửa rau", 4000, () => {
        doTask("Luộc rau", 2000, finish);
    })
})

// console.log("End");

console.log("Start");
doTask("Ăn cơm", 4000, () => {
    console.log("Ăn cơm xong");
});
doTask("Lướt facebook", 2000, () => {
    console.log("Lướt facebook xong");
});
doTask("Check mail", 2500, () => {
    console.log("Check mail xong");
});
console.log("End");