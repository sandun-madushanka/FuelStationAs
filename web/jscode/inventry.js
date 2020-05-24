/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//------------------------------------supplier--------------------------------------
function  supplierdetailsAdd() {
    var fnm = document.getElementById("fnmsup").value;
    var lname = document.getElementById("lnmsup").value;
    var nic = document.getElementById("nicsup").value;
    var adrs = document.getElementById("adrssup").value;
    var mob = document.getElementById("nummsup").value;
    var tel = document.getElementById("telsup").value;
    var dis = document.getElementById("dessup").value;
//            alert(x);
//            alert(catnmed);
    var url = "supplierdetailsAdd_serv?fnm=" + fnm + "&lnam=" + lname + "&nic=" + nic + "&adrs=" + adrs + "&mob=" + mob + "&tel=" + tel + "&dis=" + dis;
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
                supplierDetailsloadtb();
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
                alert("Supplier Updated Fails");
//                                    document.getElementById("msg").innerHTML = "NO USER...";
//                                    window.location("registration.jsp");
            }

        }
    };
    request.open("GET", url, true);
    request.send();
}

function  supplierDetailsSearch() {
    var nic = document.getElementById("nicsup").value;
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

                document.getElementById("fnmsup").value = objectj.fname;
                document.getElementById("lnmsup").value = objectj.lname;
                document.getElementById("adrssup").value = objectj.adress;
                document.getElementById("nummsup").value = objectj.mobile;
                document.getElementById("telsup").value = objectj.telephone;
                document.getElementById("dessup").value = objectj.discription;

            }


        }
    };
    request.open("GET", "supplierDetailsSearch?nicemp=" + nic, true);
    request.send();
}

function  supplierdetailsUpdate() {
    var fnm = document.getElementById("fnmsup").value;
    var lname = document.getElementById("lnmsup").value;
    var nic = document.getElementById("nicsup").value;
    var adrs = document.getElementById("adrssup").value;
    var mob = document.getElementById("nummsup").value;
    var tel = document.getElementById("telsup").value;
    var dis = document.getElementById("dessup").value;
//            alert(x);
//            alert(catnmed);
    var url = "supplierdetailsUpdate_serv?fnm=" + fnm + "&lnam=" + lname + "&nic=" + nic + "&adrs=" + adrs + "&mob=" + mob + "&tel=" + tel + "&dis=" + dis;
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
                supplierDetailsloadtb();
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
                alert("details Updated Fails");
//                                    document.getElementById("msg").innerHTML = "NO USER...";
//                                    window.location("registration.jsp");
            }

        }
    };
    request.open("GET", url, true);
    request.send();
}

function  supplierDetailsloadtb() {
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
                document.getElementById('tbdaysuptbl').innerHTML = "";
            } else if (request.responseText == "4") {
                window.location = "index.jsp";
            } else {
                document.getElementById('tbdaysuptbl').innerHTML = request.responseText;
            }

        }
    };
    request.open("GET", "supplierDetailsloadtb_serv", true);
    request.send();
}

function  supplierDelete(x) {
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
    request.open("GET", "supplierDelete_serv?idu=" + empid, true);
    request.send();
}
//------------------------------------supplier--------------------------------------


//-------------------------inventry--------------------------

function  inventryStockAdd() {
    var supnic = document.getElementById("nicinv").value;
    var fueltyp = document.getElementById("fueltyp").value;
    var suprate = document.getElementById("suprateinv").value;
    var qtyltr = document.getElementById("qtyinv").value;
    var ppl = document.getElementById("pplinv").value;
    var tot = document.getElementById("totinv").value;
//            alert(x);
//            alert(catnmed);
    var url = "inventryStockdetailsAdd_serv?supnic=" + supnic + "&fueltyp=" + fueltyp + "&suprate=" + suprate + "&qtyltr=" + qtyltr + "&ppl=" + ppl + "&tot=" + tot ;
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
                supplierDetailsloadtb();
            } else if (request.responseText == "2") {
                swal({
                    type: 'warning',
                    title: "Added Fails!",
                    text: "Details Added is not Successfully",
                    timer: 3000,
                    showConfirmButton: true
                });
            } else if (request.responseText == "3") {
                swal({
                    type: 'error',
                    title: "No Supplier found!",
                    text: "There is no supplier from this nic",
                    timer: 3000,
                    showConfirmButton: true
                });
            }else if (request.responseText == "4") {
                window.location = "index.jsp";
            } else {
                alert("Supplier Updated Fails");
//                                    document.getElementById("msg").innerHTML = "NO USER...";
//                                    window.location("registration.jsp");
            }

        }
    };
    request.open("GET", url, true);
    request.send();
}


function  invemtryStockDetailsloadtb() {
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
                document.getElementById('invretvewtb').innerHTML = "";
            } else if (request.responseText == "4") {
                window.location = "index.jsp";
            } else {
                document.getElementById('invretvewtb').innerHTML = request.responseText;
            }

        }
    };
    request.open("GET", "invemtryStockDetailsloadtb_serv", true);
    request.send();
}

