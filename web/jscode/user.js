/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function  userdetailsUpdate() {
    var fnm = document.getElementById("ufnm").value;
    var lname = document.getElementById("ulnm").value;
    var nic = document.getElementById("unic").value;
    var adrs = document.getElementById("uadrs").value;
    var mob = document.getElementById("umob").value;
    var tel = document.getElementById("utel").value;
//            alert(x);
//            alert(catnmed);
    var url = "udatailsUpdate_serv?fnm=" + fnm + "&lnam=" + lname + "&nic=" + nic+ "&adrs=" + adrs + "&mob=" + mob+ "&tel=" + tel;
//            alert(url);
    var request = new XMLHttpRequest();
    request.onreadystatechange = function() {
        if (request.readyState === 4 && request.status === 200) {
            if (request.responseText == "1") {
                swal({
                    type: 'success',
                    title: "Updated!",
                    text: "Details Updated Successfully",
                    timer: 3000,
                    showConfirmButton: true
                });
                catreload();
                cattypeload();
            } else if (request.responseText == "2") {
                swal({
                    type: 'warning',
                    title: "Updated Fails!",
                    text: "Details Updated is not Successfully",
                    timer: 3000,
                    showConfirmButton: true
                });
            } else if (request.responseText == "4") {
                window.location = "index.jsp";
            } else {
                alert("Category Updated Fails");
//                                    document.getElementById("msg").innerHTML = "NO USER...";
//                                    window.location("registration.jsp");
            }

        }
    };
    request.open("GET", url, true);
    request.send();
}
function  UserDetailsload() {
    var request = new XMLHttpRequest();
    request.onreadystatechange = function() {
        if (request.readyState === 4 && request.status === 200) {
//                    alert("1");
            document.getElementById('userboday').innerHTML = request.responseText;

        }
    };
    request.open("GET", "UserDetailsload_serv", true);
    request.send();
}