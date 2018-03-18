document.getElementById("updatePerson").addEventListener("click", updatePerson);

function updatePerson() {

    var id = document.getElementById("id").value;
    var firstName = document.getElementById("firstName").value;
    var lastName = document.getElementById("lastName").value;

    var apiLink = "http://localhost:8084/CA2_Jetbrains/api/person/complete/"+id;

    var newPerson = {
        id: id,
        firstName: firstName,
        lastName: lastName,
    };

    var data = JSON.stringify(newPerson);
    
    fetch(apiLink, {
        method: "PUT",
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        body: data
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        alert("Person: "+data.firstName+" "+ data.lastName+ " has been updated for id: "+id+" in database!");
    });


}