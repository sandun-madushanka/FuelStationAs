<%-- 
    Document   : user
    Created on : Aug 4, 2019, 10:26:25 PM
    Author     : Sandun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

        <title>Employee</title>

        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
        <meta name="viewport" content="width=device-width" />


        <!-- Bootstrap core CSS     -->
        <link href="assets/css/bootstrap.min.css" rel="stylesheet" />

        <!-- Animation library for notifications   -->
        <link href="assets/css/animate.min.css" rel="stylesheet"/>

        <!--  Paper Dashboard core CSS    -->
        <link href="assets/css/paper-dashboard.css" rel="stylesheet"/>

        <!--  CSS for Demo Purpose, don't include it in your project     -->
        <link href="assets/css/demo.css" rel="stylesheet" />

        <!--  Fonts and icons     -->
        <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
        <link href="assets/css/themify-icons.css" rel="stylesheet">

        <script src="sweetalert/sweetalert2.all.min.js"></script>
        <script src="sweetalert/sweetalert2.min.js"></script>
        <script src="jscode/login/login.js" type="text/javascript"></script>
        <script src="jscode/employee.js" type="text/javascript"></script>
    </head>
    <body onload="employeeSalaryDetailsloadtb()">
        <%
            String s = (String) request.getSession().getAttribute("user");
            if (s != null) {

        %>
        <div class="wrapper">
            <div class="sidebar" data-background-color="white" data-active-color="danger">

                <!--
                            Tip 1: you can change the color of the sidebar's background using: data-background-color="white | black"
                            Tip 2: you can change the color of the active button using the data-active-color="primary | info | success | warning | danger"
                -->

                <div class="sidebar-wrapper">
                    <div class="logo">
                        <a href="user.jsp" class="simple-text">
                            Fuel Station
                        </a>
                    </div>

                    <ul class="nav">

                        <!--                        <li>
                                                    <a href="user.jsp">
                                                        <i class="ti-user"></i>
                                                        <p>User Profile</p>
                                                    </a>
                                                </li>-->
                        <li  class="active">
                            <a href="employee.jsp">
                                <i class="ti-user"></i>
                                <p>Employee Manage</p>
                            </a>
                        </li>
                        <li>
                            <a href="customer.jsp">
                                <i class="ti-user"></i>
                                <p>Customer Payment Manage</p>
                            </a>
                        </li>
                        <li>
                            <a href="sales.jsp">
                                <i class="ti-user"></i>
                                <p>Daily Sales Manage</p>
                            </a>
                        </li>
                        <li>
                            <a href="inventry.jsp">
                                <i class="ti-clipboard"></i>
                                <p>Inventory Manage</p>
                            </a>
                        </li>

                    </ul>
                </div>
            </div>

            <div class="main-panel">
                <nav class="navbar navbar-default">
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar bar1"></span>
                                <span class="icon-bar bar2"></span>
                                <span class="icon-bar bar3"></span>
                            </button>
                            <a class="navbar-brand" href="#">Employee Manage</a>
                        </div>
                        <div class="collapse navbar-collapse">
                            <ul class="nav navbar-nav navbar-right">

                                <li>
                                    <a onclick="logout()">
                                        <i class="ti-power-off"></i>
                                        <p>Log out</p>
                                    </a>
                                </li>
                            </ul>

                        </div>
                    </div>
                </nav>


                <div class="content">
                    <div class="container-fluid">
                        <div class="row">

                            <div class="col-lg-12 col-md-12">
                                <div class="card">
                                    <div class="header">
                                        <h4 class="title">Manage Employees from Here</h4>
                                        <br/>
                                        <h5 class="title"><a href="employeeretrieve.jsp">Retrieve & Delete Employee </a></h5>
                                    </div>
                                    <div class="content">


                                        <div class="row">
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <label>First Name</label>
                                                    <input type="text" id="fnmemp" class="form-control border-input" required placeholder="First Name">
                                                </div>
                                            </div>
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <label>Last Name</label>
                                                    <input type="text" id="lnmemp" class="form-control border-input" required placeholder="Last Name">
                                                </div>
                                            </div>
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <label>NIC</label>
                                                    <input type="text" id="nicemp" class="form-control border-input" required placeholder="nic">
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row">

                                            <div class="col-md-12">
                                                <div class="form-group">
                                                    <label>Address</label>
                                                    <input type="text" id="adrsemp" class="form-control border-input" required placeholder="Home Address">
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <label>Mobile</label>
                                                    <input type="number" id="mobemp" class="form-control border-input" required placeholder="mobile">
                                                </div>
                                            </div>
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <label>Telephone</label>
                                                    <input type="number" id="telemp" class="form-control border-input" required placeholder="telephone">
                                                </div>
                                            </div>
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <label>Salary</label>
                                                    <input type="number" id="salaemp" class="form-control border-input" required placeholder="Salary">
                                                </div>
                                            </div>

                                        </div>
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group">
                                                    <label>Description</label>
                                                    <textarea rows="5" id="discripemp" class="form-control border-input" placeholder="Here can be your description" value="Mike"></textarea>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-4">
                                                <div class="text-center">
                                                    <button type="button" onclick="employeedetailsAdd()" class="btn btn-info btn-fill btn-wd">Add Employee</button>
                                                </div>
                                            </div>
                                            <div class="col-md-4">
                                                <div class="text-center">
                                                    <button type="button" onclick="employeeDetailsSearch()" class="btn btn-info btn-fill btn-wd">Search</button>
                                                </div>
                                            </div>
                                            <div class="col-md-4">
                                                <div class="text-center">
                                                    <button type="button" onclick="employeedetailsUpdate()" class="btn btn-info btn-fill btn-wd">Update</button>
                                                </div>
                                            </div>

                                        </div>

                                        <div class="clearfix"></div>


                                    </div>
                                </div>
                            </div>


                        </div>

                        <div class="row">

                            <div class="col-lg-12 col-md-12">
                                <div class="card">
                                    <div class="header">
                                        <h4 class="title">Manage Salary from Here</h4>
                                        <!--                                        <br/>
                                                                                <h5 class="title"><a href="employeeretrieve.jsp">Retrieve & Delete Employee Salary </a></h5>-->
                                    </div>
                                    <div class="content">


                                        <div class="row">
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <label>Employee NIC</label>
                                                    <input  type="text" id="nicsal" class="form-control border-input" required placeholder="nic">
                                                </div>
                                            </div>
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <label>Salary</label>
                                                    <input type="number" id="empsalsal" disabled="" class="form-control border-input" required placeholder="Salary">
                                                </div>
                                            </div>
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <label for="exampleInputEmail1"></label>
                                                    <div class="text-center">
                                                        <button type="button" onclick="searchEmployeeSal()" class="btn btn-info btn-fill btn-wd">Search Employee</button>
                                                    </div>
                                                </div>
                                            </div>

                                        </div>

                                        <div class="row">
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <label>OT Hours Count</label>
                                                    <input type="number" id="otcntsal" class="form-control border-input" required placeholder="OT Hour Count">
                                                </div>
                                            </div>
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <label>Price Paid per 1 OT Hour (Rs.)</label>
                                                    <input type="number" id="pppotsal" class="form-control border-input" required placeholder="price Rate for OT hour">
                                                </div>
                                            </div>
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <label for="exampleInputEmail1"></label>
                                                    <div class="text-center">
                                                        <button type="button" onclick="CalTotSal()" class="btn btn-info btn-fill btn-wd">Calculate Total Salary</button>
                                                    </div>
                                                </div>
                                            </div>

                                        </div>
                                        <div class="row">
                                            <!--<div class="col-md-4"></div>-->
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <label>Total</label>
                                                    <input type="number" id="totsal" class="form-control border-input" required placeholder="total">
                                                </div>
                                            </div>
                                            <div class="col-md-4"></div>
                                        </div>

                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="text-center">
                                                    <button type="button" onclick="employeeSalarydetailsAdd()" class="btn btn-info btn-fill btn-wd">Add Salary</button>
                                                </div>
                                            </div>
                                            <!--                                                <div class="col-md-4">
                                                                                                <div class="text-center">
                                                                                                    <button type="button" onclick="employeeDetailsSearch()" class="btn btn-info btn-fill btn-wd">Search</button>
                                                                                                </div>
                                                                                            </div>
                                                                                            <div class="col-md-4">
                                                                                                <div class="text-center">
                                                                                                    <button type="button" onclick="employeedetailsUpdate()" class="btn btn-info btn-fill btn-wd">Update</button>
                                                                                                </div>
                                                                                            </div>-->

                                        </div>
                                        <br>
                                        <hr><br>
                                        <div class="header">
                                            <h4 class="title">Retrieve Employees Salary from Here</h4>
                                        </div>
                                        <div class="content table-responsive table-full-width">
                                            <table class="table table-striped">
                                                <thead>
                                                <th>First Name</th>
                                                <th>Salary (Rs.)</th>
                                                <th>OT Hour Count</th>
                                                <th>Price Rate (OT Hour)</th>
                                                <th>Total Salary</th>
                                                <th>Date</th>
                                                </thead>
                                                <tbody id="tbodayempsal">
                                                    <!--                                                    <tr>
                                                                                                            <td>Test Name</td>
                                                                                                            <td>36,738</td>
                                                                                                            <td>968745874V</td>
                                                                                                            <td><button type="button" onclick="employeeDelete(x)" class="btn btn-danger btn-fill">Delete</button></td>
                                                                                                        </tr>                                                    -->
                                                </tbody>
                                            </table>

                                        </div>

                                        <div class="clearfix"></div>


                                    </div>
                                </div>
                            </div>


                        </div>

                    </div>
                </div>

            </div>
        </div>
        <%                } else {

                response.sendRedirect("index.jsp");
            }
        %>

    </body>

    <!--   Core JS Files   -->
    <script src="assets/js/jquery-1.10.2.js" type="text/javascript"></script>
    <script src="assets/js/bootstrap.min.js" type="text/javascript"></script>

    <!--  Checkbox, Radio & Switch Plugins -->
    <script src="assets/js/bootstrap-checkbox-radio.js"></script>

    <!--  Charts Plugin -->
    <script src="assets/js/chartist.min.js"></script>

    <!--  Notifications Plugin    -->
    <script src="assets/js/bootstrap-notify.js"></script>

    <!--  Google Maps Plugin    -->
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js"></script>

    <!-- Paper Dashboard Core javascript and methods for Demo purpose -->
    <script src="assets/js/paper-dashboard.js"></script>

    <!-- Paper Dashboard DEMO methods, don't include it in your project! -->
    <script src="assets/js/demo.js"></script>

</html>
