// --- do not touch  ↓↓↓↓↓↓↓↓↓↓↓↓ ----------
const baseServerURL = `http://localhost:${
  import.meta.env.REACT_APP_JSON_SERVER_PORT
}`;
// --- do not touch  ↑↑↑↑↑↑↑↑↑↑↑↑ ----------

const userUrl = `${baseServerURL}/users`
let mainContainer = document.getElementById("data-list-wrapper");
let paginationCon = document.getElementById("pagination-wrapper");

let userList = [];

window.addEventListener("load",function(){
  fetchUser();
})

async function fetchUser(pageNumber=1){
  let res = await fetch(`${userUrl}?_limit=10&_page=${pageNumber}`);


  let totalUser = res.headers.get("X-Total-Count");
  showPagination(totalUser,10);

  res = await res.json();

  let userdata = res.map((item)=>({
    id:item.id,
    username : `${item.firstname} ${item.lastname}`,
    image : item.avatar,
    useremail: item.email,
  }));

  userList = userdata;
  showData(userdata);
  console.log(userdata)
}

function showData(userdata){

  let parentCard = `
    <div class="card-list">

    ${userdata.map((item)=>getCard(item.id,item.username,item.image,item.useremail)).join("")}
    
    </div>
  
  `
  mainContainer.innerHTML = parentCard;
}

function getCard(id,name,image,email){

  let card = `
    <div class="card" data-id="${id}">
      <div class="card__img">
        <img src="${image}" alt="${name} image">
      </div>
      <div class="card__body">
        <h3 class="card__item card__title">${name}</h3>
        <div class="card__item card__description">${email}</div>
      </div>
    </div>
  
  `;
  console.log(card)
  return card;
}

function showPagination(totalUser,limit){

  let numberOfButton = Math.ceil(totalUser/limit);

  let paginationString = "";
  for(let i=1;i<=numberOfButton;i++){
    paginationString = paginationString.concat(getButton(i));
  }

  paginationCon.innerHTML = paginationString;

  let paginBtn = document.querySelectorAll(".pagination-button");
  for(let btn of paginBtn){
    btn.addEventListener("click",function(e){
     
      let pagen = e.target.dataset["pageNumber"];
      fetchUser(pagen);
    })
  }

  
}

function getButton(pageNumber){
  return `
  <button class="pagination-button" data-page-number="${pageNumber}">${pageNumber}</button>
  `
}