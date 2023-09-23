let formelement = document.querySelector("form");
let tbodyele = document.querySelector("tbody");

let tableData = [];
let taskInput = document.getElementById("task");
let prioritySelect = document.getElementById("priority");

formelement.addEventListener("submit", function(e){
    e.preventDefault();

    let formData = {
        task: taskInput.value,
        priority: prioritySelect.value,
    }

    tableData.push(formData);

    tbodyele.innerText = "";
    for(let i=0;i<tableData.length;i++){
        let tr = document.createElement("tr");
        let taskel = document.createElement("td");
        taskel.innerText = tableData[i].task;

        let priorityel = document.createElement("td");
        priorityel.innerText = tableData[i].priority;

        let fav = document.createElement("td");
        fav.innerText = "favourite";

        tr.append(taskel,priorityel,fav);
        tbodyele.append(tr);
    }
})
