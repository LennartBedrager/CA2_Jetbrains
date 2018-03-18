document.getElementById("createPerson").addEventListener("click", createPerson);

function createPerson() {

    var firstName = document.getElementById("firstName").value;
    var lastName = document.getElementById("lastName").value;

    console.log("firstname: "+firstName+" lastname: "+lastName);

    var apiLink = "https://hawkdon.dk/CA2/api/person";

    var newPerson = {
        firstName: firstName,
        lastName: lastName,
    };

    var data = JSON.stringify(newPerson);
    console.log(data);

    fetch(apiLink, {
        method: "POST",
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        body: data
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        alert("Person has been added to database!");
    });


}