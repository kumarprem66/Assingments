function registerRestaurant(){
    let resname = document.getElementById("resname").value;
    let resaddr = document.getElementById("resaddr").value;
    let resrole = document.getElementById("resrole").value;
    let respass = document.getElementById("respass").value;

    let rid = document.getElementById("resid").value;

    fetch("http://localhost:8000/restaurant",{
        method : "POST",
        headers : {
            "content-type":"application/json"
        },
        body : JSON.stringify({
            "restaurantId":rid,
            "name":resname,
           "role":resrole,
            "address":resaddr,
            "password":respass
        })
    }).then(response=>{
        if(response.status == 201 || response.status == 200){
            response.json().then(data => {
                alert("Restaurant successfully registered with name :"+data.name)
            })
        }else{
            response.json().then(data => alert("failed"))
        }
    })
}