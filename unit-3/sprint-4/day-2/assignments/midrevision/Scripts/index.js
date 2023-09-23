// Write code related to Home page here

let form = document.querySelector("form");

let meetsArr = JSON.parse(localStorage.getItem("meets")) || [];

form.addEventListener("submit",function(e){

    e.preventDefault();
    let name = document.getElementById("name").value;
    let desc = document.getElementById("desc").value;
    let month = document.getElementById("month").value;
    let week = document.getElementById("week").value;
    let meettype = document.getElementById("meetType").value;


    if(name=="" && desc=="" && month==""&& week=="",meettype==""){
        return alert("Please fill all details")
    }

    let obj = {
        name,desc,month,week,meettype
    }

    console.log(obj);
    meetsArr.push(obj);
    localStorage.setItem("meets",JSON.stringify(meetsArr));

    alert("meets created.")

})

