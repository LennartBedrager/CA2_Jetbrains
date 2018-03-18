document.getElementById("deletePerson").addEventListener("click", deletePerson);

function deletePerson() {

    var id = document.getElementById("id").value;
    
    var apiLink = "https://hawkdon.dk/CA2/api/person/complete/" + id;

    fetch(apiLink, {
        method: "DELETE"
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        alert("Person: "+data.firstName +" has been removed from database!");
    });


}