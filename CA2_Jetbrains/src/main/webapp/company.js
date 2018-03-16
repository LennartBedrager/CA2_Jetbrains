document.getElementById("btnsend").addEventListener("click", getAllCompanies);
document.getElementById("btnOnesend").addEventListener("click", getCompany);

//<th>Name</th><th>CVR</th><th>Description</th><th>Market value</th><th>Employees</th><th>id</th>

function getAllCompanies(){
  fetch("https://hawkdon.dk/CA2/api/company/complete")
            .then(function (response) {
                if (response.ok) {
                    return response.json();
                } else {
                    throw new Error(response.statusText)
                }
            })
            .then(function (myJson) {
                var newArray = myJson.map(function (element) {
                    return "<tr><td>" + element.name + "</td><td>" + element.cvr + "</td><td>" + element.description 
                            + "</td><td>" + element.marketValue + "</td><td>" + element.numEmployees + "</td><td>" + element.id
                            + "</td></tr>";
                })
                document.getElementById("tblbody").innerHTML = newArray.join("");

            }).catch(function (error) {
        document.getElementById("tblbody").innerText = error;
    })  
}


function getCompany() {

    var id = document.getElementById("field1").value;
    console.log(id);
    fetch("https://hawkdon.dk/CA2/api/company/complete/"+ id)
            .then(function (response) {
                if (response.ok) {
                    return response.json();
                } else {
                    throw new Error(response.statusText)
                }
            })
            .then(data => document.getElementById("tblbody").innerHTML = 
            "<tr><td>" + data.name + "</td><td>" + data.cvr + "</td><td>" + data.description 
                            + "</td><td>" + data.marketValue + "</td><td>" + data.numEmployees + "</td><td>" + data.id
                            + "</td></tr>");
            
            
}

