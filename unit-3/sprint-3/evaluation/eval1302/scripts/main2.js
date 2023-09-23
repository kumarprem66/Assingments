// --- do not touch  ↓↓↓↓↓↓↓↓↓↓↓↓ ----------
const baseServerURL = `http://localhost:${
  import.meta.env.REACT_APP_JSON_SERVER_PORT
}`;
// --- do not touch  ↑↑↑↑↑↑↑↑↑↑↑↑ ----------

// ***** Constants / Variables ***** //
const recipeIngredientURL = `${baseServerURL}/recipeIngredients`;
const employeeURL = `${baseServerURL}/employees`;
const userRegisterURL = `${baseServerURL}/register`;
const userLoginURL = `${baseServerURL}/login`;



let paginationWrapper = document.getElementById("pagination-wrapper");

// register
let registerUserUsername = document.getElementById("register-user-username");
let registerUserFirstname = document.getElementById("register-user-firstname");
let registerUserLastname = document.getElementById("register-user-lastname");
let registerUserEmail = document.getElementById("register-user-email");
let registerUserPassowrd = document.getElementById("register-user-passowrd");
let registerUserAvatar = document.getElementById("register-user-avatar");
let registerUserLevel = document.getElementById("register-user-level");
let registerUserButton = document.getElementById("register-user");

// login
let loginUserUsername = document.getElementById("login-user-username");
let loginUserPassword = document.getElementById("login-user-passowrd");
let loginUserButton = document.getElementById("login-user");

// getTodo
let getTodoButton = document.getElementById("fetch-todos");

let mainSection = document.getElementById("data-list-wrapper");
let notificationWrapper = document.getElementById("notifications-wrapper");

let userAuthToken = localStorage.getItem("localAccessToken") || null;
let userId = +localStorage.getItem("userId") || null;

const urlAllTodosOfUser = `${baseServerURL}/todos?userId=${userId}`;
const urlTodosBase = `${baseServerURL}/todos/`;

// cats
let empNameInput = document.getElementById("employee-name");
let empImgInput = document.getElementById("employee-image");
let empDeptInput = document.getElementById("employee-dept");
let empSalaryInput = document.getElementById("employee-salary");

let empCreateBtn = document.getElementById("add-employee");
let sortAtoZBtn = document.getElementById("sort-low-to-high");
let sortZtoABtn = document.getElementById("sort-high-to-low");
let catsData = [];

// employees
let updateEmpIdInput = document.getElementById("update-employee-id");
let updateEmpNameInput = document.getElementById("update-employee-name");
let updateEmpImageInput = document.getElementById("update-employee-image");
let updateEmpDeptInput = document.getElementById("update-employee-dept");
let updateEmpSalaryInput = document.getElementById("update-employee-salary");


let updateEmpUpdateBtn = document.getElementById("update-employee");




let updateScoreEmpId = document.getElementById("update-score-employee-id");
let updateScoreEmpSalary = document.getElementById(
  "update-score-employee-salary"
);
let updateScoreEmpSalaryButton = document.getElementById("update-score-employee");

let filterLess = document.getElementById("filter-less-than-1L");

let filterMore = document.getElementById("filter-more-than-equal-1L");

let fetchIngredient = document.getElementById("fetch-ingredient");


let fetchEmployee = document.getElementById("fetch-employees");


// user

let updateUserUsername = document.getElementById("update-user-username");
let updateUserFirst = document.getElementById("update-user-firstname");
let updateUserLast = document.getElementById("update-user-lastname");
let updateUserEmail = document.getElementById("update-user-email");
let updateUserPass = document.getElementById("update-user-passowrd");
let updateUserAvatar = document.getElementById("update-user-avatar");
let updateUserLabel = document.getElementById("update-user-username");

let updateUserBtn = document.getElementById("update-user");



let employeesData = [];

// ***** Event listeners ***** //
window.addEventListener("load", () => {
//   fetchAndRenderCats()
  fetchAndRenderEmployees2();
  // fetchAndRenderIngredients(`${recipeIngredientURL}?_limit=40&_page=1`);
});




async function fetchAndRenderEmployees2(queryParamString=null){
   let res =  await fetch(`${employeeURL}${queryParamString ? queryParamString : ""}`);
   res = await res.json();
   let emplist = res.map((item)=>({
        id: item.id,
        title: item.name,
        salary: item.salary,
        description: "Rs. " + item.salary,
        linkText: "Edit",
        linkUrl: "https://google.com",
        imageUrl: `${baseServerURL}${item.image}`,
   }))
   employeesData = emplist;
   showdata(emplist);
//    console.log(res);

}

// function fetchAndRenderEmployees(){
//     fetch(`${employeeURL}`)
//     .then((res)=>res.json())
//     .then((data)=>{
//         let emplist = data.map((item)=>({
//             id: item.id,
//             title: item.name,
//             salary: item.salary,
//             description: "Rs. " + item.salary,
//             linkText: "Edit",
//             linkUrl: "https://google.com",
//             imageUrl: `${baseServerURL}${item.image}`,

//         }));

//         employeesData = emplist;
        
//         showdata(emplist);
//     })
// }

function showdata(emplist){
    // console.log(emplist);
    let cardList = `

        <div class="card-list">
            ${
                emplist.map((item)=>
                {
                return getCard(item.id,item.title,item.imageUrl,item.description,item.linkText,item.linkUrl)
                }
                )
                .join("")
            }
        </div>
    
    `;

    mainSection.innerHTML = cardList;

    let editT = document.querySelectorAll(".card__link");
    for(let edit of editT){
        edit.addEventListener("click",(e)=>{
            e.preventDefault();
            let currid = e.target.dataset.id;
            // console.log(e)
            populateForm(currid);
        })
    }


    
}

function getCard(id,title,image,desc,editText,linkURL){
    let card = `
    <div class="card" data-id="${id}">
        <div class="card__img">
            <img src="${image}" alt="">
        </div>
        <div class="card__body">
            <h3 class="card__item card__title">${title}</h3>
            <div class="card__item card_description">${desc}</div>
            <a href="${linkURL}" data-id="${id}" class="card__item card__link">
                ${editText}
            </a>
        </div>
    </div>
    
    
    `;

  
    return card;


}


function populateForm(cid){
    fetch(`${employeeURL}/${cid}`)
    .then((res)=>res.json())
    .then((data)=>{
        updateEmpIdInput.value = data.id;
      updateEmpNameInput.value = data.name;
      updateEmpImageInput.value = data.image;
      updateEmpDeptInput.value = data.department;
      updateEmpSalaryInput.value = data.salary;

      updateScoreEmpId.value = data.id;
      updateScoreEmpSalary.value = data.salary;

    });
}


empCreateBtn.addEventListener("click",function(){
    let name = empNameInput.value;
    let image = empImgInput.value;
    let dept = empDeptInput.value;
    let salary = empSalaryInput.value;

    if(name=="" || image=="" || dept=="" || salary==""){
        return alert("no field should be empty");
    }

    let userobj = {
        name :name,
        image:image,
        department:dept,
        salary:salary
    }

    createEmp(userobj);

    fetchAndRenderEmployees2()

    // fetch(`${employeeURL}`,{
    //     method: "POST",
    //     headers: {
    //         "Content-Type":"application/json",
    //     },
    //     body: JSON.stringify({
    //         name: name,
    //         image: image,
    //         department:dept,
    //         salary:salary
    //     }),
    // })
    // .then((res)=>res.json())
    // .then((data)=>{
    //     console.log(data);
    //     fetchAndRenderEmployees2();
    // })
    // .catch((err)=>{
    //     alert(JSON.stringify(err))
    // })



})

async function createEmp(userObj){

    let res = await fetch(`${employeeURL}`,{
        method:"POST",
        headers:{
            "Content-Type":"application/json",
        },
        body:JSON.stringify(userObj)
    });

    res = res.json();
    alert("user created with name : "+ userObj.name)
    console.log(res);
}


updateEmpUpdateBtn.addEventListener("click",function(){
    let id = updateEmpIdInput.value;
    let n = updateEmpNameInput.value;
    let im = updateEmpImageInput.value;
    let dept = updateEmpDeptInput.value;
    let salary = updateEmpSalaryInput.value;

    let empObj = {};
    if(id) empObj["id"] = id;
    if(n) empObj["name"] = n;
    if(im) empObj["image"] = im;
    if(dept) empObj["department"] = dept;
    if(salary) empObj["salary"] = salary;


    fetch(`${employeeURL}/${id}`,{
        method: "PUT",
        headers : {
            "Content-Type":"application/json",

        },
        body : JSON.stringify(empObj),
    })
    .then((res)=>res.json())
    .then((data)=>{
        alert(`Data of ${id} updated.`);
        fetchAndRenderEmployees2();
    })
    .catch((err)=> alert(JSON.stringify(err)));

})


updateScoreEmpSalaryButton.addEventListener("click",function(){
    let id = updateScoreEmpId.value;
    let salary = updateScoreEmpSalary.value;

    if(id=="" && salary==""){
        return alert("empty field")
    }

    fetch(`${employeeURL}/${id}`,{
        method :"PATCH",
        headers:{
            "Content-Type": "application/json",
        },
        body:JSON.stringify({
            salary:salary,
        })
    }
    )
    .then((res)=> res.json())
    .then((data)=>{
        alert(`salary updated with ${salary}`)
        fetchAndRenderEmployees2();
    })
    .catch((err)=> alert(JSON.stringify(err)))
});


sortAtoZBtn.addEventListener("click", () => {
 

//   fetchAndRenderEmployees("?_sort=salary&_order=asc");
  fetchAndRenderEmployees2("?_sort=salary&_order=asc")
});

sortZtoABtn.addEventListener("click", () => {

//   fetchAndRenderEmployees("?_sort=salary&_order=desc");
  fetchAndRenderEmployees2("?_sort=salary&_order=desc")
});


filterLess.addEventListener("click",function(){
    let lessthanLakh = employeesData.filter((item)=>{
        if(item.salary < 100000){
            return true;
        }
    })

    showdata(lessthanLakh);


})
filterMore.addEventListener("click",function(){
    let lessthanLakh = employeesData.filter((item)=>{
        if(item.salary >= 100000){
            return true;
        }
    })

    showdata(lessthanLakh);


})


fetchEmployee.addEventListener("click", async function(){
    fetchAndRenderEmployees2();
})


fetchIngredient.addEventListener("click",async function(){

    let recipeRes = await fetch(`${recipeIngredientURL}`);
    recipeRes = await recipeRes.json();
    console.log(recipeRes);

});




getTodoButton.addEventListener("click", async function () {
   

    try{
        let res = await fetch(urlAllTodosOfUser,{
            method : "GET",
            headers : {
                Authorization : `Bearer ${userAuthToken}`,
                "Content-type": "application/json",
            },
            
        });
        let data = await res.json();
        mainSection.innerHTML = `
            <pre>${JSON.stringify(data,null,2)}</pre>
        `;
        console.log(data)

    }catch(err){
        alert("Err. ",JSON.stringify(err));
    }
 
});

loginUserButton.addEventListener("click", async function () {
    let username = loginUserUsername.value;
    let password = loginUserPassword.value;

    let userObj = {
        username : username,
        password : password,
    }

    try{
        let res = await fetch(userLoginURL,{
            method : "POST",
            headers : {
                "Content-Type":"application/json",

            },
            body: JSON.stringify(userObj),
        });
        let data = await res.json();
        localStorage.setItem("localAccessToken",
        data.accessToken);
        localStorage.setItem("userId",data.user.id);

        alert("user successfully logged in.");
        
        // console.log(data.accessToken);
        // console.log(data.user.id);
        console.log(data)

    }catch(err){
        alert("Err. ",JSON.stringify(err));
    }

});

registerUserButton.addEventListener("click", function () {
    let userName = registerUserUsername.value;
    let firstName = registerUserFirstname.value;
    let lastName = registerUserLastname.value;
    let email = registerUserEmail.value;
    let password = registerUserPassowrd.value;
    let avatar = registerUserAvatar.value;
    let level = registerUserLevel.value;

    let userObject = {
        username: userName,
        password: password,
        email: email,
        firstname: firstName,
        lastname: lastName,
        avatar: avatar,
        userLevel: level,
      };

      fetch(userRegisterURL,{
        method: "POST",
        headers:{
            "Content-Type":"application/json",
        },
        body: JSON.stringify(userObject),
      })
      .then((res)=>res.json())
      .then((data)=>alert(JSON.stringify(data)))
      .catch((err) => alert("err"));


});

// ***** Utilities ***** //
// array of objects
// id, title, desc, linkText, linkUrl, imageUrl






// Cats
async function fetchAndRenderCats(){
    try{
        let res = await fetch(`${baseServerURL}/cats`);

        res = await res.json();
        console.log(res);
        let catsObj = res.map((item)=>{

            let obj = {};
            obj.id =  item.id,
            obj.title = item.name,
            obj.description=  item.description.substring(0,50),
            obj.linkText =  "Edit",
            obj.linkURL=  "https://google.com",
            obj.imageUrl = `${baseServerURL}${item.image}`

            return obj;
        });

        catsData = catsObj;
        showdata(catsData);

    }catch(err){
        alert(err);
    }
    

}


// updateUserBtn.addEventListener("click", async function(){

//     let userId = 55;
//     let username2 = updateUserUsername.value;
//     let first = updateUserFirst.value;
//     let last = updateUserLast.value;
//     let email = updateUserEmail.value;
   
//     let avatar = updateUserAvatar.value;
//     let label = updateUserLabel.value;
//     let password = updateUserPass.value;

//     let userOb = {
//         id:userId,
//         username: username2,
//         firstname: first,
//         lastname: last,
//         email : email,
//         password:password,
//         avatar: avatar,
//         userLabel: label,
//     }

    
//     // let res = await fetch(`${baseServerURL}/users/${p}`,
//     // {

//     //     method:"PUT",
//     //     header:{
//     //         "Content-Type":"application/json"
//     //     },
//     //     body:JSON.stringify(userOb)

//     // }
//     // );
//     // res = await res.json();
//     // alert("successfully updated "+username2)
//     // console.log(res);

//     fetch(`${baseServerURL}/users/${userId}`, {
//         method: "PUT",
//         headers: {
//           "Content-Type": "application/json",
//         },
//         body: JSON.stringify(userOb),
//       })
//         .then((res) => res.json())
//         .then((data) => {
//           alert(`Data of ${userId} updated.`);
//         //   fetchAndRenderEmployees();
//         })
//         .catch((err) => alert(JSON.stringify(err)));


// })
// Employees



