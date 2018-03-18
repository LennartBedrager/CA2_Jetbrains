document.getElementById("deletePerson").addEventListener("click", deletePerson);

function deletePerson() {

    var id = document.getElementById("id").value;
    
    var apiLink = "http://localhost:8084/CA2_Jetbrains/api/person/complete/" + id;

    fetch(apiLink, {
        method: "DELETE"
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        alert("Person: "+data.firstName +" has been removed from database!");
    });


}