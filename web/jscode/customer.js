/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function  customerdetailsAdd() {
    var fnm = document.getElementById("fnmcus").value;
    var lname = document.getElementById("lnmcus").value;
    var nic = document.getElementById("niccus").value;
    var adrs = document.getElementById("adrescus").value;
    var mob = document.getElementById("mobcus").value;
    var tel = document.getElementById("telcus").value;
    var lcstat;
    if (document.getElementById("lchave").checked) {
        lcstat = 1;
//        alert(gen);
    } else if (document.getElementById("lcnhave").checked) {
        lcstat = 0;
//        alert(gen);
    }
    var dis = document.getElementById("discus").value;

    var url = "customerdetailsAdd_serv?fnm=" + fnm + "&lnam=" + lname + "&nic=" + nic + "&adrs=" + adrs + "&mob=" + mob + "&tel=" + tel + "&lcstat=" + lcstat + "&dis=" + dis;
//            alert(url);
    var request = new XMLHttpRequest();
    request.onreadystatechange = function() {
        if (request.readyState === 4 && request.status === 200) {
            if (request.responseText == "1") {
                swal({
                    type: 'success',
                    title: "Added!",
                    text: "Details Added Successfully",
                    timer: 3000,
                    showConfirmButton: true
                });
            } else if (request.responseText == "2") {
                swal({
                    type: 'warning',
                    title: "Added Fails!",
                    text: "Details Added is not Successfully",
                    timer: 3000,
                    showConfirmButton: true
                });
            } else if (request.responseText == "4") {
                window.location = "index.jsp";
            } else {
                alert("Details added Fails");
//                                    document.getElementById("msg").innerHTML = "NO USER...";
//                                    window.location("registration.jsp");
            }

        }
    };
    request.open("GET", url, true);
    request.send();
}

function  customerDetailsSearch() {
    var nic = document.getElementById("niccus").value;
    var request = new XMLHttpRequest();
    request.onreadystatechange = function() {
        if (request.readyState === 4 && request.status === 200) {
            if (request.responseText == "1") {
                swal({
                    type: 'error',
                    title: "No Result!",
                    text: "No Result found",
                    timer: 3000,
                    showConfirmButton: true
                });
            } else if (request.responseText == "4") {
                window.location = "index.jsp";
            } else {
//                alert(request.responseText);

                var x = request.responseText;
                var objectj = JSON.parse(x);

                document.getElementById("fnmcus").value = objectj.fname;
                document.getElementById("lnmcus").value = objectj.lname;
                document.getElementById("adrescus").value = objectj.adress;
                document.getElementById("mobcus").value = objectj.mobile;
                document.getElementById("telcus").value = objectj.telephone;
                if (objectj.lcardStat == "1") {
//                    alert(objectj.lcardStat);
//                    document.getElementById("lchave").checked = true;
                    var radiobtn = document.getElementById("lchave");
                    radiobtn.checked = true;
                } else {
//                    alert(objectj.lcardStat)
//                    document.getElementById("lcnhave").checked = true;
                    var radiobtn = document.getElementById("lcnhave");
                    radiobtn.checked = true;
                }
                document.getElementById("discus").value = objectj.discription;

            }


        }
    };
    request.open("GET", "customerDetailsSearch?nicemp=" + nic, true);
    request.send();
}

function  customerdetailsUpdate() {
    var fnm = document.getElementById("fnmcus").value;
    var lname = document.getElementById("lnmcus").value;
    var nic = document.getElementById("niccus").value;
    var adrs = document.getElementById("adrescus").value;
    var mob = document.getElementById("mobcus").value;
    var tel = document.getElementById("telcus").value;
    var lcstat;
    if (document.getElementById("lchave").checked) {
        lcstat = 1;
//        alert(gen);
    } else if (document.getElementById("lcnhave").checked) {
        lcstat = 0;
//        alert(gen);
    }
    var dis = document.getElementById("discus").value;

//            alert(x);
//            alert(catnmed);
    var url = "customerdetailsUpdate_serv?fnm=" + fnm + "&lnam=" + lname + "&nic=" + nic + "&adrs=" + adrs + "&mob=" + mob + "&tel=" + tel + "&lcstat=" + lcstat + "&dis=" + dis;
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

function  customerDetailsloadtb() {
    var request = new XMLHttpRequest();
    request.onreadystatechange = function() {
        if (request.readyState === 4 && request.status === 200) {
//            alert(request.responseText);
            if (request.responseText == "1") {
                swal({
                    type: 'error',
                    title: "No Result!",
                    text: "No Result found",
                    timer: 3000,
                    showConfirmButton: true
                });
                document.getElementById('custblretrew').innerHTML = "";
            } else if (request.responseText == "4") {
                window.location = "index.jsp";
            } else {
                document.getElementById('custblretrew').innerHTML = request.responseText;
            }

        }
    };
    request.open("GET", "customerDetailsloadtb_serv", true);
    request.send();
}

function  customerDelete(x) {
//    alert(x);
    var empid = x;
    var request = new XMLHttpRequest();
    request.onreadystatechange = function() {
        if (request.readyState === 4 && request.status === 200) {
            if (request.responseText == "1") {
                swal({
                    type: 'success',
                    title: "Deleted!",
                    text: "Customer Deleted Successfully",
                    timer: 3000,
                    showConfirmButton: true
                });
//                employeeDetailsloadtb();
            } else if (request.responseText == "2") {
                swal({
                    type: 'warning',
                    title: "Deleted Fails!",
                    text: "Customer Deleted is not Successfully",
                    timer: 3000,
                    showConfirmButton: true
                });
            } else if (request.responseText == "4") {
                window.location = "index.jsp";
            } else {
                alert("Customer Deleted Fails");
//                                    document.getElementById("msg").innerHTML = "NO USER...";
//                                    window.location("registration.jsp");
            }

        }
    };
    request.open("GET", "customerDelete_serv?idu=" + empid, true);
    request.send();
}
