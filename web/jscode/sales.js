/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//----------------invoice--------------


function  salesCusInvoiceAdd() {
    var supnic = document.getElementById("niccussale").value;
    var fueltyp = document.getElementById("fueltypcussale").value;
    var suprate = document.getElementById("pplcussale").value;
    var qtyltr = document.getElementById("qtycussale").value;
    var tot = document.getElementById("totcussale").value;
    var pymtyp = document.getElementById("pymnttypcussale").value;
//            alert(x);
//            alert(catnmed);
    var url = "salesCusInvoiceAdd_serv?supnic=" + supnic + "&fueltyp=" + fueltyp + "&suprate=" + suprate + "&qtyltr=" + qtyltr + "&tot=" + tot + "&pymtyp=" + pymtyp ;
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
                    title: "No Customoer found!",
                    text: "There is no Customoer from this nic",
                    timer: 3000,
                    showConfirmButton: true
                });
            }else if (request.responseText == "5") {
                swal({
                    type: 'error',
                    title: "No fuel found!",
                    text: "There is not much stock from this fuel",
                    timer: 3000,
                    showConfirmButton: true
                });
            }else if (request.responseText == "4") {
                window.location = "index.jsp";
            } else {
                alert("Customoer Updated Fails");
//                                    document.getElementById("msg").innerHTML = "NO USER...";
//                                    window.location("registration.jsp");
            }

        }
    };
    request.open("GET", url, true);
    request.send();
}


function  salesCusInvoiceDetailsloadtb() {
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
                document.getElementById('tbodysalesretew').innerHTML = "";
            } else if (request.responseText == "4") {
                window.location = "index.jsp";
            } else {
                document.getElementById('tbodysalesretew').innerHTML = request.responseText;
            }

        }
    };
    request.open("GET", "salesCusInvoiceDetailsloadtb_serv", true);
    request.send();
}

//----------------invoice--------------



//---------------------profit---------------

function  CalculateProfitSale() {
    var frmdt = document.getElementById("sfromdate").value;
    var todt = document.getElementById("stodate").value;
    
//            alert(x);
//            alert(catnmed);
    var url = "CalculateProfitSale_serv?frmdt=" + frmdt + "&todt=" + todt ;
//            alert(url);
    var request = new XMLHttpRequest();
    request.onreadystatechange = function() {
        if (request.readyState === 4 && request.status === 200) {
            if (request.responseText == "1") {
                swal({
                    type: 'error',
                    title: "No profit!",
                    text: "There is no Profit Between these days",
                    timer: 3000,
                    showConfirmButton: true
                });
            }if (request.responseText == "2") {
                swal({
                    type: 'error',
                    title: "Two Dates Need!",
                    text: "Please Select to dates",
                    timer: 3000,
                    showConfirmButton: true
                });
            } else if (request.responseText == "4") {
                window.location = "index.jsp";
            } else {
//                alert(request.responseText);

                var x = request.responseText;
                var objectj = JSON.parse(x);

                document.getElementById("profitsale").value = objectj.profTot;

            }

        }
    };
    request.open("GET", url, true);
    request.send();
}

function  addDailySale() {
    var fueltypdlysale = document.getElementById("fueltypdlysale").value;
    var expndsale = document.getElementById("expndsale").value;
    var revdsale = document.getElementById("revdsale").value;
    var totdsale = document.getElementById("totdsale").value;
//            alert(x);
//            alert(catnmed);
    var url = "sailysalesAdd_serv?fueltypdlysale=" + fueltypdlysale + "&expndsale=" + expndsale + "&revdsale=" + revdsale + "&totdsale=" + totdsale  ;
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
             
            }else if (request.responseText == "4") {
                window.location = "index.jsp";
            } else {
                alert("Customoer Updated Fails");
//                                    document.getElementById("msg").innerHTML = "NO USER...";
//                                    window.location("registration.jsp");
            }

        }
    };
    request.open("GET", url, true);
    request.send();
}

function  DailySaleDetailsloadtb() {
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
                document.getElementById('tbodydailysalesretew').innerHTML = "";
            } else if (request.responseText == "4") {
                window.location = "index.jsp";
            } else {
                document.getElementById('tbodydailysalesretew').innerHTML = request.responseText;
            }

        }
    };
    request.open("GET", "DailySaleDetailsloadtb_serv", true);
    request.send();
}

function  DailySaleUpdate(x) {
//    alert(x);
    var empid = x;
    var tot = document.getElementById("dailysaleretrivegm" + x).value;
    var request = new XMLHttpRequest();
    request.onreadystatechange = function() {
        if (request.readyState === 4 && request.status === 200) {
            if (request.responseText == "1") {
                swal({
                    type: 'success',
                    title: "Updated!",
                    text: "Updated Successfully",
                    timer: 3000,
                    showConfirmButton: true
                });
                DailySaleDetailsloadtb();
//                employeeDetailsloadtb();
            } else if (request.responseText == "2") {
                swal({
                    type: 'warning',
                    title: "Updated Fails!",
                    text: "Updated is not Successfully",
                    timer: 3000,
                    showConfirmButton: true
                });
            } else if (request.responseText == "4") {
                window.location = "index.jsp";
            } else {
                alert("Updated Fails");
//                                    document.getElementById("msg").innerHTML = "NO USER...";
//                                    window.location("registration.jsp");
            }

        }
    };
    request.open("GET", "DailySaleUpdate_serv?idu=" + empid + "&tot=" + tot, true);
    request.send();
}

function  dailySaleDelete(x) {
//    alert(x);
    var empid = x;
    var request = new XMLHttpRequest();
    request.onreadystatechange = function() {
        if (request.readyState === 4 && request.status === 200) {
            if (request.responseText == "1") {
                swal({
                    type: 'success',
                    title: "Deleted!",
                    text: "Deleted Successfully",
                    timer: 3000,
                    showConfirmButton: true
                });
                DailySaleDetailsloadtb();
            } else if (request.responseText == "2") {
                swal({
                    type: 'warning',
                    title: "Deleted Fails!",
                    text: "Deleted is not Successfully",
                    timer: 3000,
                    showConfirmButton: true
                });
            } else if (request.responseText == "4") {
                window.location = "index.jsp";
            } else {
                alert("Deleted Fails");
//                                    document.getElementById("msg").innerHTML = "NO USER...";
//                                    window.location("registration.jsp");
            }

        }
    };
    request.open("GET", "dailySaleDelete_serv?idu=" + empid, true);
    request.send();
}

