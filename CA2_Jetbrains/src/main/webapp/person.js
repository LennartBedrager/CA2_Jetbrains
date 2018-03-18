document.getElementById("btnsend").addEventListener("click", getAllPersons);
document.getElementById("btnOnesend").addEventListener("click", coolFunction);

var smallTable = "<th>First name</th><th>Last name</th><th>id</th>";
var bigTable = "<th>First name</th><th>Last name</th><th>Phone</th><th>Email</th><th>Hobby</th><th>id</th>";

function smallInfo(data) {
    return "<tr><td>" + data.firstName + "</td><td>" + data.lastName + "</td><td>" + data.id + "</td></tr>"
}

function bigInfo(data) {
    return  "<tr><td>" + data.firstName + "</td><td>" + data.lastName + "</td><td>" + data.phone[0].number + "</td><td>" + data.email +
            "</td><td>" + data.hobbies[0].description + "</td><td>" + data.id + "</td></tr>"
}

function coolFunction() {

    var selectionObj = document.getElementById('data');
    var selection = selectionObj.options[selectionObj.selectedIndex].text;

    if (selection.toUpperCase() === "ID") {
        getPersonById();
    } else if (selection.toUpperCase() === "PHONE") {
        getPersonByPhone();

    } else if (selection.toUpperCase() === "ZIP") {
        getAllPersonsWithZip();

    } else if (selection.toUpperCase() === "FIRST NAME") {
        getAllPersonsWithFirstName();

    } else if (selection.toUpperCase() === "LAST NAME") {
        getAllPersonsWithLastName();

    }
}


function getAllPersonsWithZip() {

    var zip = document.getElementById("field1").value;
    fetch("http://localhost:8084/CA2_Jetbrains/api/person/complete/zip=" + zip)
            .then(function (response) {
                if (response.ok) {
                    return response.json();
                } else {
                    throw new Error(response.statusText)
                }
            })
            .then(function (myJson) {
                var newArray = myJson.map(smallInfo)
                document.getElementById("tblclass").innerHTML = smallTable,
                        document.getElementById("tblbody").innerHTML = newArray.join("");

            }).catch(function (error) {
        document.getElementById("tblbody").innerText = error;
    })
}

function getAllPersonsWithFirstName() {

    var fname = document.getElementById("field1").value;
    fetch("http://localhost:8084/CA2_Jetbrains/api/person/complete/fname=" + fname)
            .then(function (response) {
                if (response.ok) {
                    return response.json();
                } else {
                    throw new Error(response.statusText)
                }
            })
            .then(function (myJson) {
                var newArray = myJson.map(smallInfo)
                document.getElementById("tblclass").innerHTML = smallTable,
                        document.getElementById("tblbody").innerHTML = newArray.join("");

            }).catch(function (error) {
        document.getElementById("tblbody").innerText = error;
    })
}

function getAllPersonsWithLastName() {

    var lname = document.getElementById("field1").value;
    fetch("http://localhost:8084/CA2_Jetbrains/api/person/complete/lname=" + lname)
            .then(function (response) {
                if (response.ok) {
                    return response.json();
                } else {
                    throw new Error(response.statusText)
                }
            })
            .then(function (myJson) {
                var newArray = myJson.map(smallInfo)
                document.getElementById("tblclass").innerHTML = smallTable,
                document.getElementById("tblbody").innerHTML = newArray.join("");

            }).catch(function (error) {
        document.getElementById("tblbody").innerText = error;
    })
}

function getAllPersons() {
    fetch("http://localhost:8084/CA2_Jetbrains/api/person/complete")

            .then(function (response) {
                if (response.ok) {
                    return response.json();
                } else {
                    throw new Error(response.statusText)
                }
            })
            .then(function (myJson) {
                var newArray = myJson.map(smallInfo)
                document.getElementById("tblclass").innerHTML = smallTable,
                        document.getElementById("tblbody").innerHTML = newArray.join("");

            }).catch(function (error) {
        document.getElementById("tblbody").innerText = error;
    })
}

function getPersonById() {

    var id = document.getElementById("field1").value;
    fetch("http://localhost:8084/CA2_Jetbrains/api/person/complete/" + id)
            .then(function (response) {
                if (response.ok) {
                    return response.json();
                } else {
                    throw new Error(response.statusText)
                }
            })
            .then(function (data) {
                if (data.phone[0].number != null && data.hobbies[0].description != null) {

                    //We only retrieve one phone number and one hobby, could add a map to the array's and print multiple
                    document.getElementById("tblclass").innerHTML = bigTable,
                            document.getElementById("tblbody").innerHTML = bigInfo(data);

                } else {
                    alert("phone not found");
                    document.getElementById("tblclass").innerHTML = smallTable,
                            document.getElementById("tblbody").innerHTML = smallInfo(data);
                }
            });


}

function getPersonByPhone() {

    var phone = document.getElementById("field1").value;
    fetch("http://localhost:8084/CA2_Jetbrains/api/person/complete/phone=" + phone)
            .then(function (response) {
                if (response.ok) {
                    return response.json();
                } else {
                    throw new Error(response.statusText)
                }
            })
            .then(function (data) {
                    document.getElementById("tblclass").innerHTML = smallTable,
                    document.getElementById("tblbody").innerHTML = smallInfo(data);
                
            });


}


