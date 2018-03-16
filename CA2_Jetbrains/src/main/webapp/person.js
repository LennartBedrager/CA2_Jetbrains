document.getElementById("btnsend").addEventListener("click", getAllPersons);
document.getElementById("btnOnesend").addEventListener("click", getPerson);



function getAllPersons(){
  fetch("http://localhost:8084/CA2_Jetbrains/api/person/complete")
            .then(function (response) {
                if (response.ok) {
                    return response.json();
                } else {
                    throw new Error(response.statusText)
                }
            })
            .then(function (myJson) {
                var newArray = myJson.map(function (element) {
                    return "<tr><td>" + element.firstName + "</td><td>" + element.lastName + "</td><td>" + element.id + "</td></tr>";
                })
                document.getElementById("tblbody").innerHTML = newArray.join("");

            }).catch(function (error) {
        document.getElementById("tblbody").innerText = error;
    })  
}


function getPerson() {

    var id = document.getElementById("field1").value;
    console.log(id);
    fetch("http://localhost:8084/CA2_Jetbrains/api/person/complete/"+ id)
            .then(function (response) {
                if (response.ok) {
                    return response.json();
                } else {
                    throw new Error(response.statusText)
                }
            })
            .then(data => document.getElementById("tblbody").innerHTML = 
            "<tr><td>" + data.firstName + "</td><td>" + data.lastName + "</td><td>" + data.id + "</td></tr>");
            
            
}

