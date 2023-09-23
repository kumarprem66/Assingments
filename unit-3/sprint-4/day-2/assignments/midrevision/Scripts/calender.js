// Write code related to Calender page here

let meetsArr = JSON.parse(localStorage.getItem("meets")) || [];
let month = document.getElementById("month");
let week1 = document.getElementById("Week-1");
let week2 = document.getElementById("Week-2");
let week3 = document.getElementById("Week-3");
let week4 = document.getElementById("Week-4");
let monv = "";
display();
function display(month="January"){

    week1.innerText = "";
    week2.innerText = "";
    week3.innerText = "";
    week4.innerText = "";
    meetsArr.forEach(element => {
        if(element.month==month){
            let div1 = document.createElement("div");

            let name = document.createElement("p");
            name.innerText = element.name;
            let desc = document.createElement("p");
            desc.innerText = element.desc;
            let meettype = document.createElement("p");
            meettype.innerText = "Meet-Type:-"+element.meettype;
            let week = document.createElement("select");

            let weekv = document.createElement("option");
            week.setAttribute("data-page-number",23);

            weekv.innerText = element.week;
            week.append(weekv);
            let arrw = ["Week-1","Week-2","Week-3","Week-4"];
            for(let i=0;i<4;i++){
                let weekv = document.createElement("option");
                if(arrw[i]!=element.week){
                    weekv.innerText = arrw[i];
                    week.append(weekv);
                }

            }



            week.addEventListener("change",function(e){
                let v = week.value;
                element.week = v;


                console.log(meetsArr);

                
                localStorage.setItem("meets",JSON.stringify(meetsArr));
                meetsArr = JSON.parse(localStorage.getItem("meets")) || [];
                if(monv==""){
                    display();
                }else{
                    display(monv);
                }
               

            })

            

            div1.append(name,desc,meettype,week);

            if(element.week=="Week-1"){
                week1.append(div1);
            }else if(element.week=="Week-2"){
                week2.append(div1);
            }else if(element.week=="Week-3"){
                    week3.append(div1);
            }else if(element.week=="Week-4"){
                week4.append(div1);
            }

        }
    });
}


month.addEventListener("change",function(){
    monv = month.value;
    display(monv);
})


// function getMeetCard(name,desc,meettype,week){
//     let card = `
//     <div>
//     <p>${name}</p>
//     <p>${desc}</p>
//     <p>${meettype}</p>
//     <select>
//        <option value="Week-1">Week-1</option>
//        <option value="Week-2">Week-2</option>
//        <option value="Week-3">Week-3</option>
//        <option value="Week-4">Week-4</option>
//      </select>
//    </div>
    
//     `
//     return card;
// }
