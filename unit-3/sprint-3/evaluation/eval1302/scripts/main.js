// --- do not touch  ↓↓↓↓↓↓↓↓↓↓↓↓ ----------
const baseServerURL = `http://localhost:${
  import.meta.env.REACT_APP_JSON_SERVER_PORT
}`;
// --- do not touch  ↑↑↑↑↑↑↑↑↑↑↑↑ ----------


const userLoginURL = `${baseServerURL}/login`;
const urlTodos = `${baseServerURL}/todos/`;

let mainSection = document.getElementById("data-list-wrapper");
let notificationWrapper = document.getElementById("notifications-wrapper");

let loginUserUsername = document.getElementById("login-user-username");
let loginUserPassword = document.getElementById("login-user-password");
let loginUserButton = document.getElementById("login-user");

let getTodoButton = document.getElementById("fetch-todos");

let sortLowToHigh = document.getElementById("sort-low-to-high");
let sortHighToLow = document.getElementById("sort-high-to-low");
let filterCompleted = document.getElementById("filter-completed");
let filterPending = document.getElementById("filter-pending");

let userToken = localStorage.getItem("localAccessToken") || null;
let userId = +localStorage.getItem("userId") || null;
const urlAllTodosOfUser = `${baseServerURL}/todos?userId=${userId}`;

let allTodo = [];


// window.addEventListener("load",function(){
//   fetchTodo();
// })

loginUserButton.addEventListener("click",async function(){
  

  let username = loginUserUsername.value;
  let pass = loginUserPassword.value;

  try{
    let res = await fetch(userLoginURL,{
      method : "POST",
      headers:{
        "Content-Type":"application/json"
      },
      
      body : JSON.stringify({
        username: username,
        password : pass
      })
    })

    let data = await res.json();
    // console.log(data.accessToken)
    localStorage.setItem("localAccessToken",data.accessToken);
    localStorage.setItem("userId",data.user.id);
    console.log(data);
    notificationWrapper.innerHTML = `
    
    <h5 class="notification info">hey ${data.user.username}, welcome back! </h5>
    `;

    fetchTodo(urlTodos);

  }catch(err){
    alert(JSON.stringify(err))
  }
})


async function fetchTodo(queryParamString){

  try{
    let res = await fetch(queryParamString,{
      method : "GET",
      headers : {
          Authorization : `Bearer ${userToken}`,
          "Content-type": "application/json",
      },
      
    });
    let data = await res.json();
    allTodo = data;
    // console.log(data)
    display(data);
  }catch(err){
    console.log(JSON.stringify(err))
  }


}

getTodoButton.addEventListener("click",async function(){

      try{
        let res = await fetch(urlTodos,{
          method : "GET",
          headers : {
              Authorization : `Bearer ${userToken}`,
              "Content-type": "application/json",
          },
          
        });
        let data = await res.json();
        // let toli = data.map((item)=>({
        //   id: item.id,
        //   userId : item.id,
        //   title: item.name,
        //   completed: item.completed,
        //   createdAt: "Rs. " + item.salary,
        //   linkText: "Edit",
        //   linkUrl: "https://google.com",
        //   imageUrl: `${baseServerURL}${item.image}`,
        // }))





        allTodo = data;
        console.log(data)
        display(data);
      }catch(err){
        console.log(JSON.stringify(err))
      }

});

function display(data){



  let todo = `
  <div class="todo-list-wrapper" id="todo-list-wrapper">

    ${data.map((item)=>{
      
      let isc = ""
      if(item.completed){
        isc = "checked";
      }
      
      return getLabel(item.id,isc,item.title)
    
    }).join("")}
  
  
  </div>
  
  `;

  // console.log(todo);

  mainSection.innerHTML = todo;



  let editT = document.querySelectorAll(".todo-item-checkbox");
  for(let edit of editT){
      edit.addEventListener("click",(e)=>{
          // e.preventDefault();
          let isch = edit.checked;
          console.log(isch)

          let currid = e.target.dataset.id;
          console.log(currid);
          findid(currid,isch);
      })
  }
}

async function findid(id,ische){

  // for(let i=0;i<allTodo.length;i++){
  //   if(allTodo[i].id==id){
  //     allTodo[i].completed = ische;
  //     break;
  //   }
  // }
  const singleurl = `${baseServerURL}/todos/${id}`;

  let res = await fetch(`${singleurl}`
  ,{
    method : "PATCH",
    headers : {
      Authorization : `Bearer ${userToken}`,
      "Content-Type" : "application/json",
    },
    body:JSON.stringify({completed : ische})
  }
  );

  let data = await res.json();
  console.log(data);
  fetchTodo(urlTodos);

}


function getLabel(dataid,ischeck,title){

  let label = `
  <label class="todo-item-label">
    <input class="todo-item-checkbox" data-id="${dataid}" type="checkbox" ${ischeck}>
    ${title}
  </label>
  `
  return label;
}



sortLowToHigh.addEventListener("click",function(){
  // `{baseServerURL}/todos?userId=1,_sort=title}`

  // todos?_sort=title&order=asc&userId=1

  // fetchTodo(`${baseServerURL}/todos?_sort=title&order=asc&userId=${userId}`);
  fetchTodo(`${baseServerURL}/todos?_sort=title&order=asc`);



})

sortHighToLow.addEventListener("click",function(){
  // fetchTodo(`${baseServerURL}/todos?_sort=title&order=desc&userId=${userId}`);
  
  // allTodo.sort(function(a,b){
  //   return b.title-a.title;
  // })

  allTodo.sort(function(a,b){
    let x = a.title.toLowerCase();
    let y = b.title.toLowerCase();
    if(x>y){
      return -1
    }
    if(x<y){
      return 1;
    }
    return 0;
  });
  // console.log(allTodo)
  display(allTodo);
 
  // fetchTodo(`${baseServerURL}/todos?_sort=title&order=desc`);

});

filterCompleted.addEventListener("click",async function(){


  try{
    let res = await fetch(urlTodos,{
      method : "GET",
      headers : {
          Authorization : `Bearer ${userToken}`,
          "Content-type": "application/json",
      },
      
    });
    let data = await res.json();
    allTodo = data;

    let pen = data.filter((item)=>{
      if(item.completed){
        return true;
      }else {
        return false;
      }
    })
  
    display(pen);
    // console.log(data)
    // display(data);
  }catch(err){
    console.log(JSON.stringify(err))
  }
});

filterPending.addEventListener("click",async function(){


  try{
    let res = await fetch(urlTodos,{
      method : "GET",
      headers : {
          Authorization : `Bearer ${userToken}`,
          "Content-type": "application/json",
      },
      
    });
    let data = await res.json();
    allTodo = data;

    let pen = data.filter((item)=>{
      if(!item.completed){
        return true;
      }else {
        return false;
      }
    })
  
    display(pen);
    // console.log(data)
    // display(data);
  }catch(err){
    console.log(JSON.stringify(err))
  }









  
});



