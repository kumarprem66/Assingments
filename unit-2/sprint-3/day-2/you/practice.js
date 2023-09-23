let select = document.querySelector("select");
select.addEventListener("change",selectFunction);

function selectFunction(){
    let filtervalue = select.value;

    data = JSON.parse(localStorage.getItem("task-list")) || [];

    let data1 = data.filter(function(ele,ind){
        if(filtervalue===""){
            return true;
        }
        return ele.priority===filtervalue;
    })
    appenddata(data1);
    
}