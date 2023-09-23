// Write code related to Favourites page here

// Write code related to dashboard page here
let parent = document.querySelector("tbody");


let data = JSON.parse(localStorage.getItem("fav-menu")) || [];
appendata(data);

function appendata(data){
    parent.innerHTML = "";
    data.forEach(function(ele,ind){
        let tr = document.createElement("tr");

        let td1 = document.createElement("td");
        td1.textContent = ele.name;

        let td2 = document.createElement("td");
        td2.textContent = ele.desc;

        let td3 = document.createElement("td");
        td3.textContent = ele.type;

        let td4 = document.createElement("td");
        td4.textContent = ele.category;

        let td5 = document.createElement("td");
        td5.textContent = ele.price;

        let td6 = document.createElement("td");
        td6.textContent = "Delete";

        td6.addEventListener("click",function(){
            data.splice(ind,1);

            localStorage.setItem("fav-menu",JSON.stringify(data));
            appendata(data);

        })

        tr.append(td1,td2,td3,td4,td5,td6);
        parent.append(tr);

    })
}




