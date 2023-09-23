function addsong(){
    let sname = document.getElementById("song_name").value;
let sartist = document.getElementById("song_artist_id").value;
let salbum = document.getElementById("song_album_id").value;
let duration = document.getElementById("song_data").value;

fetch("http://localhost:8080/spotify/songs",{
    method : "POST",
    headers : {
        "Content-type" : "application/json"
    },
    body :JSON.stringify({
        "name" : sname,
        "artistid" : sartist,
        "albumid" : salbum,
        "duration":duration
    })
}).then(response => {
    if(response.status==201 | response.status == 200){
        response.json().then(data => {
            alert("song added successfully")
        })
    }else{
        response.json().then(data => alert(data.message));
    }
})
}