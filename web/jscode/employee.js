/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



function  employeedetailsAdd() {
    var fnm = document.getElementById("fnmemp").value;
    var lname = document.getElementById("lnmemp").value;
    var nic = document.getElementById("nicemp").value;
    var adrs = document.getElementById("adrsemp").value;
    var mob = document.getElementById("mobemp").value;
    var tel = document.getElementById("telemp").value;
    var sal = document.getElementById("salaemp").value;
    var dis = document.getElementById("discripemp").value;
//            alert(x);
//            alert(catnmed);
    var url = "employeedetailsAdd_serv?fnm=" + fnm + "&lnam=" + lname + "&nic=" + nic + "&adrs=" + adrs + "&mob=" + mob + "&tel=" + tel + "&salar=" + sal + "&dis=" + dis;
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
                alert("Category Updated Fails");
//                                    document.getElementById("msg").innerHTML = "NO USER...";
//                                    window.location("registration.jsp");
            }

        }
    };
    request.open("GET", url, true);
    request.send();
}

function  employeeDetailsSearch() {
    var nic = document.getElementById("nicemp").value;
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

                document.getElementById("fnmemp").value = objectj.fname;
                document.getElementById("lnmemp").value = objectj.lname;
                document.getElementById("adrsemp").value = objectj.adress;
                document.getElementById("mobemp").value = objectj.mobile;
                document.getElementById("telemp").value = objectj.telephone;
                document.getElementById("salaemp").value = objectj.salary;
                document.getElementById("discripemp").value = objectj.discription;

            }


        }
    };
    request.open("GET", "employeeDetailsSearch?nicemp=" + nic, true);
    request.send();
}

function  employeedetailsUpdate() {
    var fnm = document.getElementById("fnmemp").value;
    var lname = document.getElementById("lnmemp").value;
    var nic = document.getElementById("nicemp").value;
    var adrs = document.getElementById("adrsemp").value;
    var mob = document.getElementById("mobemp").value;
    var tel = document.getElementById("telemp").value;
    var sal = document.getElementById("salaemp").value;
    var dis = document.getElementById("discripemp").value;
//            alert(x);
//            alert(catnmed);
    var url = "employeedetailsUpdate_serv?fnm=" + fnm + "&lnam=" + lname + "&nic=" + nic + "&adrs=" + adrs + "&mob=" + mob + "&tel=" + tel + "&salar=" + sal + "&dis=" + dis;
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

function  employeeDetailsloadtb() {
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
                document.getElementById('tbodayemp').innerHTML = "";
            } else if (request.responseText == "4") {
                window.location = "index.jsp";
            } else {
                document.getElementById('tbodayemp').innerHTML = request.responseText;
            }

        }
    };
    request.open("GET", "employeeDetailsloadtb_serv", true);
    request.send();
}

function  employeeDelete(x) {
//    alert(x);
    var empid = x;
    var request = new XMLHttpRequest();
    request.onreadystatechange = function() {
        if (request.readyState === 4 && request.status === 200) {
            if (request.responseText == "1") {
                swal({
                    type: 'success',
                    title: "Deleted!",
                    text: "Employee Deleted Successfully",
                    timer: 3000,
                    showConfirmButton: true
                });
//                employeeDetailsloadtb();
            } else if (request.responseText == "2") {
                swal({
                    type: 'warning',
                    title: "Deleted Fails!",
                    text: "Employee Deleted is not Successfully",
                    timer: 3000,
                    showConfirmButton: true
                });
            } else if (request.responseText == "4") {
                window.location = "index.jsp";
            } else {
                alert("Employee Deleted Fails");
//                                    document.getElementById("msg").innerHTML = "NO USER...";
//                                    window.location("registration.jsp");
            }

        }
    };
    request.open("GET", "employeeDelete_serv?idu=" + empid, true);
    request.send();
}


//----------------------------salary-----------------------------------
function CalTotSal() {
//    alert('awaaa');

    var empsalsal = parseInt(document.getElementById("empsalsal").value);
    var otcntsal = document.getElementById("otcntsal").value;
    var pppotsal = document.getElementById("pppotsal").value;
    
    var ottot = (otcntsal*pppotsal);
    var tot = ottot + empsalsal;
//    alert(tot)
    
    document.getElementById('totsal').value = tot;
}

function  searchEmployeeSal() {
    var nic = document.getElementById("nicsal").value;
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
                
            } else if (request.responseText == "4") {
                window.location = "index.jsp";
            } else {
//                alert(request.responseText);
                var x = request.responseText;
                var objectj = JSON.parse(x);

                document.getElementById("empsalsal").value = objectj.salarySal;
            }

        }
    };
    request.open("GET", "searchEmployeeSal_serv?nicemp=" + nic, true);
    request.send();
}

function  employeeSalarydetailsAdd() {
    var nic = document.getElementById("nicsal").value;
    var empsalsal = document.getElementById("empsalsal").value;
    var otcntsal = document.getElementById("otcntsal").value;
    var pppotsal = document.getElementById("pppotsal").value;
    var totsal = document.getElementById("totsal").value;
//            alert(x);
//            alert(catnmed);
    var url = "employeeSalarydetailsAdd_serv?nic=" + nic + "&empsalsal=" + empsalsal + "&otcntsal=" + otcntsal + "&pppotsal=" + pppotsal + "&totsal=" + totsal;
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
                employeeSalaryDetailsloadtb();
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
                alert("Salary added Fails");
//                                    document.getElementById("msg").innerHTML = "NO USER...";
//                                    window.location("registration.jsp");
            }

        }
    };
    request.open("GET", url, true);
    request.send();
}

function  employeeSalaryDetailsloadtb() {
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
                document.getElementById('tbodayempsal').innerHTML = "";
            } else if (request.responseText == "4") {
                window.location = "index.jsp";
            } else {
                document.getElementById('tbodayempsal').innerHTML = request.responseText;
            }

        }
    };
    request.open("GET", "employeeSalaryDetailsloadtb_serv", true);
    request.send();
}

