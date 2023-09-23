function addalbums(){

    let sname = document.getElementById("al_name").value;
    let sartist = document.getElementById("al_artist_id").value;
   
    let redate = document.getElementById("al_data").value;
    
    fetch("http://localhost:8080/spotify/songs",{
        method : "POST",
        headers : {
            "Content-type" : "application/json"
        },
        body :JSON.stringify({
            "name" : sname,
            "artistid" : sartist,
            "releasedate" : redate,
           
        })
    }).then(response => {
        if(response.status==201 | response.status == 200){
            response.json().then(data => {
                alert("album added successfully")
            })
        }else{
            response.json().then(data => alert(data.message));
        }
    })
}