const doTask = (name, time, cb) => {
    console.log("Thực hiện công việc: " + name);
    setTimeout(() => {
        cb();
    }, time);
}

const finish = () => {
    console.log ("Hoàn thành công việc");
}

// doTask ("Rửa bát", 2000, finish);




//TH1: Các tác vụ có liên quan đến nhau
//Nhặt rau - rửa rau - luộc rau

doTask("Nhặt rau", 3000, true)
    .then(rs => {
    console.log(rs);
    return doTask("Rửa rau", 2000, true);
})
    .then(rs => {
        
    })

console.log("Start");
doTask("Nhặt rau", 3000, () => {
    doTask("Rửa rau", 2000,  () => {
        doTask("Luộc rau", 4000, finish);
    })
});

console.log("End");

