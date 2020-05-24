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

        <title>Sales</title>

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
                                <p> Sales Manage</p>
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
                            <a class="navbar-brand" href="#">Sales Manage</a>
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
                                        <h4 class="title">Add Sales</h4>
                                        <br/>
                                        <h5 class="title"><a href="dailysalesretrive.jsp">Retrieve Sales</a></h5>
                                    </div>
                                    <div class="content">


                                        <div class="row">
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <label for="sel1">Employee : </label>
                                                    <select class="form-control" id="select_employee">
                                                        <option>Please Select</option>
                                                        <option value="1" >L.D.Premadasa</option>
                                                        <option value="2" >T.D.Perera</option>
                                                        <option value="3">R.S.Kumara</option>
                                                        <option value="4">N.I.Samantha</option>
                                                        <option value="5">N.L.Priyantha</option>
                                                    </select>
                                                </div>
                                            </div>
                                            
                                            
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <label for="sel1">Machine : </label>
                                                    <select class="form-control" id="select_machine">
                                                        <option>Please Select</option>
                                                        <option value="1" >MCH001-A</option>
                                                        <option value="2" >MCH001-B</option>
                                                        <option value="3" >MCH002-A</option>
                                                        <option value="4" >MCH002-B</option>
                                                        <option value="5" >MCH003-A</option>
                                                        <option value="6" >MCH003-B</option>
                                                        <option value="7" >MCH004-A</option>
                                                        <option value="8" >MCH004-B</option>
                                                    </select>
                                                </div>
                                            </div>
                                         </div>
                                        
                                        <div>    
                                            <div class="col-md-3">
                                                <div class="form-group">
                                                    <label>Date :</label>
                                                    <input type="date" class="form-control border-input"  id="sfromdate">
                                                </div>
                                            </div>
                                            
                                            
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <label>Sales Start Reading :</label>
                                                    <input id="revdsale" type="text" class="form-control border-input" required placeholder="Amount">
                                                </div>
                                            </div>
                                          
                                             <div class="col-md-4">
                                                <div class="form-group">
                                                    <label>Sales End Reading :</label>
                                                    <input id="revdsale" type="text" class="form-control border-input" required placeholder="Amount">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <label>Consumed Qty :</label>
                                                    <input id="totdsale" type="text" class="form-control border-input" required placeholder="Gain Amount">
                                                </div>
                                            </div>
                                            
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group">
                                                    <label>Description</label>
                                                    <textarea rows="5" id="discripemp" class="form-control border-input" placeholder="Here is description" value="Mike"></textarea>
                                                </div>
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


                        <div class="row">

                            <div class="col-lg-12 col-md-12">
                                <div class="card">
                                    <div class="header">
                                        <h4 class="title">Manage Profit from Here</h4>
                                        <!--                                        <br/>
                                                                                <h5 class="title"><a href="salesretrieve.jsp">Retrieve Sales</a></h5>-->
                                    </div>
                                    <div class="content">

                                        <div class="row">
                                            <div class="col-md-3">
                                                <div class="form-group">
                                                    <span>From</span><br><br>
                                                    <input type="date" class="form-control border-input"  id="sfromdate">
                                                </div>
                                            </div>
                                            <div class="col-md-3">
                                                <div class="form-group">
                                                    <span>To</span><br><br>
                                                    <input type="date" class="form-control border-input"   id="stodate">
                                                </div>
                                            </div>
                                            <div class="col-md-2">
                                                <div class="form-group">
                                                    <!--<label></label>--><br><br>
                                                    <button class="form-control border-input btn btn-fill btn-primary" onclick="CalculateProfitSale();" >Calculate Profit</button>  
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <label>Profit (Rs.)</label>
                                                    <input id="profitsale" type="text" disabled class="form-control border-input" required placeholder="profit">
                                                </div>
                                            </div>

                                            <!--                                            <div class="col-md-4">
                                                                                            <div class="form-group">
                                                                                                <label>Price per Liter</label>
                                                                                                <input id="pplcussale" type="number" class="form-control border-input" placeholder="price rate">
                                                                                            </div>
                                                                                        </div>-->
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
