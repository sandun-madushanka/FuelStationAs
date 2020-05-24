<%-- 
    Document   : machine
    Created on : Aug 30, 2019, 9:20:37 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

        <title>Machines</title>

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
        <script src="jscode/sales.js" type="text/javascript"></script>
    </head>
    <body>
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
                        <li>
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
                        <li  class="active">
                            <a href="supplier.jsp">
                                <i class="ti-user"></i>
                                <p> Daily Sales Manage</p>
                            </a>
                        </li>
                        <li>
                            <a href="inventry.jsp">
                                <i class="ti-clipboard"></i>
                                <p>Inventory Manage</p>
                            </a>
                        </li>
                        <li>
                            <a href="machine.jsp">
                                <i class="ti-user"></i>
                                <p>machine</p>
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
                            <a class="navbar-brand" href="#">machine Manage</a>
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
                                        <h4 class="title">Add Machines</h4>
                                        <br/>
                                        <h5 class="title"><a href="dailysalesretrive.jsp">Retrieve Sales</a></h5>
                                    </div>
                                    <div class="content">


                                        <div class="row">
                                            
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <label>Machine Number :</label>
                                                    <input id="revdsale" type="text" class="form-control border-input" required placeholder="Amount">
                                                </div>
                                            </div>
                                            
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <label>Machine Company :</label>
                                                    <input id="revdsale" type="text" class="form-control border-input" required placeholder="Amount">
                                                </div>
                                            </div>
                                            
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <label for="sel1">Fuel Type : </label>
                                                    <select class="form-control" id="select_employee">
                                                        <option>Please Select</option>
                                                        <option value="1" >Petrol 92</option>
                                                        <option value="2" >Petrol 95</option>
                                                        <option value="3" >Diesal 92</option>
                                                        <option value="4" >Diesal 95</option>
                                                    </select>
                                                </div>
                                            </div>
                                         
                                         </div>
                                        
                                        <div>    
                                           
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group">
                                                    <label>Description</label>
                                                    <textarea rows="5" id="discripemp" class="form-control border-input" placeholder="Here is description" value="Mike"></textarea>
                                                </div>
                                            </div>
                                        </div>
                                            
                                        <div class="col-md-4">
                                                <div class="form-group">
                                                    <label for="sel1">Image : </label>
                                                    <select class="form-control" id="select_employee">
                                                        <option>Choose From Here</option>
                                               
                                                    </select>
                                                </div>
                                        </div>
                                            
                                        <div>
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <label for="exampleInputEmail1"></label>
                                                    <div class="text-center">
                                                        <button type="button" onclick="addDailySale()" class="btn btn-info btn-fill btn-wd">Submit</button>
                                                    </div>
                                                </div>
                                            </div> 
                                            <div>
                                                <div class="form-group">
                                                    <label for="exampleInputEmail1"></label>
                                                    <div class="text-center">
                                                        <button type="button" onclick="resetDailySale()" class="btn btn-info btn-fill btn-wd">Reset</button>
                                                    </div>
                                                </div>
                                            </div>
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
