function registerStudent(){
    let cname = document.getElementById("cusname").value;
    let caddress = document.getElementById("cusaddr").value;
    let cemail = document.getElementById("cusemail").value;
    let cpassword = document.getElementById("cuspass").value;

    let cid = document.getElementById("cusid").value;

    fetch("http://localhost:8000/customersP ",{
        method : "POST",
        headers : {
            "content-type":"application/json"
        },
        body : JSON.stringify({
            "customerId":cid,
            "name":cname,
            "email":cemail,
            "address":caddress,
            "password":cpassword
        })
    }).then(response=>{
        if(response.status == 201 || response.status == 200){
            response.json().then(data => {
                alert("Customer successfully registered with name :"+data.name)
            })
        }else{
            response.json().then(data => alert("failed"))
        }
    })
}