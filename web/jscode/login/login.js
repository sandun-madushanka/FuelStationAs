/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function login() {
//    alert('1');
    var email = document.getElementById("usname").value;
    var password = document.getElementById("uspwd").value;

    var request = new XMLHttpRequest();

    request.onreadystatechange = function() {
        if (request.readyState === 4 && request.status === 200) {
//            alert(request.responseText);
            if (request.responseText === "1") {
                //invalid details
                swal({
                    type: 'error',
                    title: 'Invalid Details',
                    text: "Your User Name or Password is Wrong. Please Enter correct Details.",
                    timer: 3000,
                    showConfirmButton: true
                });
            } else if (request.responseText === "2") {
                //correct login details
                window.location = "employee.jsp";

            } 

        }
    };


    request.open("POST", "login_serv", true);
    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    request.send("user=" + email + "&pass=" + password);
}

function logout() {

    var request = new XMLHttpRequest();

    request.onreadystatechange = function() {
        if (request.readyState === 4 && request.status === 200) {
//            alert(request.responseText);

            window.location = "index.jsp";

        }
    };


    request.open("POST", "logout_serv", true);
    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    request.send();
}
