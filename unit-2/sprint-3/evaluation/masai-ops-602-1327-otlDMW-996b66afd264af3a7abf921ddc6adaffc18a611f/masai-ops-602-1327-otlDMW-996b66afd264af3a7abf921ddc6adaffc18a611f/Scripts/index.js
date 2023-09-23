// Write code related to Home page here
let formele = document.querySelector("form");
// let arr = [];

formele.addEventListener("submit",function(e){
    e.preventDefault();

    let name = document.getElementById("name").value;
    let desc = document.getElementById("desc").value;
    let selectType = document.getElementById("type").value;
    let selectcategory = document.getElementById("category").value;
    let price = document.getElementById("price").value;

    let obj = {
        name : name,
        desc : desc,
        type: selectType,
        category: selectcategory,
        price : price

    };

    let menulist = JSON.parse(localStorage.getItem("menu")) || []
    if(name.length !=0 || desc.length !=0 || selectType.length !=0 || selectcategory.length !=0 || price.length !=0){
        menulist.push(obj);
    }
    
    localStorage.setItem("menu",JSON.stringify(menulist));

})
