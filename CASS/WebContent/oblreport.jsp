<!DOCTYPE html>
<%@page import="java.util.HashMap"%>
<%@page import="com.dao.SecurityDaoUtil"%>
<%@page import="java.util.Map"%>
<%@page import="com.beans.Balance"%>
<%@ taglib prefix ="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Obligation Report | CASS</title>
    <!-- plugins:css -->
    <link rel="stylesheet" href="vendors/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="vendors/base/vendor.bundle.base.css">
    <!-- endinject -->
    <!-- plugin css for this page -->
    <link rel="stylesheet" href="vendors/datatables.net-bs4/dataTables.bootstrap4.css">
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <link rel="stylesheet" href="css/style.css">
    <!-- endinject -->
    <link rel="shortcut icon" href="images/favicon.png" />
    <link rel="stylesheet" type="text/css"
        href="https://cdn.datatables.net/w/bs4/dt-1.10.18/b-1.5.6/sl-1.3.0/datatables.min.css" />

    <script type="text/javascript"
        src="https://cdn.datatables.net/w/bs4/dt-1.10.18/b-1.5.6/sl-1.3.0/datatables.min.js"></script>
</head>

<body>
<%
Balance obligation = (Balance) request.getAttribute("obligations");
Map<String,Integer> security = obligation.getSecurityBalance();
Balance shortBalance = (Balance)request.getAttribute("short");
Map<String,Integer> ShortSecurity = shortBalance.getSecurityBalance();
%>
    <div class="container-scroller"></div>
    <div class="container-fluid page-body-wrapper" style="padding-top: 0%">
        <!-- partial:partials/_sidebar.html -->
        <nav class="sidebar sidebar-offcanvas" id="sidebar">

            <div class="content-wrapper d-flex align-items-center auth" style="padding:0%">
                <div class="row w-100">

                    <div class="auth-form-light text-center py-5 px-5 px-sm-5">
                        <div class="brand-logo" style="padding-left: 0.6em; padding-right: 0.6em">
                            <img src="images/ps-citibank-01.jpg" alt="logo">
                        </div>
                    </div>
                </div>


                <!-- content-wrapper ends -->
            </div>
            <ul class="nav">
                <li class="nav-item">
                    <a class="nav-link" href="clearingmember.jsp">
                        <i class="mdi mdi-database menu-icon text-primary"></i>
                        <span class="menu-title">Trade Data</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="ObligationClearingMember">
                        <i class="mdi mdi-elevator menu-icon text-warning"></i>
                        <span class="menu-title">Obligation Report</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="settlreport.jsp">
                        <i class="mdi mdi-file-check menu-icon text-info"></i>
                        <span class="menu-title">Settlement Report </span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="reconstatement.jsp">
                        <i class="mdi mdi-chart-bar menu-icon text-success"></i>
                        <span class="menu-title">Reconciliation Statement </span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="account.html">
                        <i class="mdi mdi-account menu-icon text-dark"></i>
                        <span class="menu-title">Account </span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="login.html">
                        <i class="mdi mdi-logout-variant menu-icon text-danger"></i>
                        <span class="menu-title">Logout</span>
                    </a>
                </li>
            </ul>

        </nav>
        <!-- partial -->
        <div class="main-panel">
            <div class="content-wrapper">
                <div class="row">
                    <div class="col-md-12 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body dashboard-tabs p-0">
                                <ul class="nav nav-tabs px-4" role="tablist">
                                    <li class="nav-item">
                                        <a class="nav-link active" id="security-tab" data-toggle="tab" href="#security"
                                            role="tab" aria-controls="security" aria-selected="true">Security Obligation
                                            Report</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" id="funds-tab" data-toggle="tab" href="#funds" role="tab"
                                            aria-controls="funds" aria-selected="false">Funds Obligation Report</a>
                                    </li>
                                </ul>
                                <div class="tab-content py-0 px-0">
                                    <div class="tab-pane fade show active" id="security" role="tabpanel"
                                        aria-labelledby="security-tab">
                                        <div class="d-flex flex-wrap justify-content-xl-between">
                                        <% for(Map.Entry<String,Integer> entry : security.entrySet()) {
                                        	int quantity = entry.getValue();
                                        %>
                                            <div
                                                class="d-flex flex-grow-1 border-md-right align-items-center justify-content-center p-3 item">
                                                <i class="mdi mdi-<%=entry.getKey().toLowerCase() %> mr-3 icon-lg text-dark"></i>
                                                <div class="d-flex flex-column justify-content-around">
                                                <%if(quantity>0){ %>
                                                    <small class="mb-1 text-success">Receive <i
                                                            class="mdi mdi-arrow-up"></i></small>
                                                            <%} else { %>
                                                             <small class="mb-1 text-danger">Send <i
                                                            class="mdi mdi-arrow-down"></i></small>
                                                            <%} %>
                                                    <h5 class="mr-2 mb-0"><%= quantity %></h5>
                                                </div>
                                            </div>
                                            <%} %>
                                            
                                            
                                        </div>
                                    </div>
                                    <div class="tab-pane fade" id="funds" role="tabpanel" aria-labelledby="funds-tab">
                                        <div class="d-flex flex-wrap justify-content-xl-between">
                                            <div
                                                class="d-flex flex-grow-1 border-md-right align-items-center justify-content-center p-3 item">
                                                <i class="mdi mdi-currency-usd mr-3 icon-lg text-dark"></i>
                                                <div class="d-flex flex-column justify-content-around">
                                                    <small class="mb-1 text-danger">Send <i
                                                            class="mdi mdi-arrow-down"></i></small>
                                                    <h5 class="mr-2 mb-0"><%=obligation.getFunds() %></h5>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Shortages</h4>
                                <div class="table-responsive">
                                    <table class="table table-hover table-bordered">
                                        <thead>
                                            <tr>
                                                <th>
                                                    Shortage Unit
                                                </th>
                                                <th>
                                                    Quantity
                                                </th>
                                                <th>
                                                    Price
                                                </th>
                                                <th>
                                                    Interest Rate (% p.a)
                                                </th>
                                                <th>
                                                    Interest
                                                </th>
                                                
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <%for(Map.Entry<String,Integer> entry:ShortSecurity.entrySet()){ 
                                        SecurityDaoUtil securitydaoutil = new SecurityDaoUtil();
                                        String securityName = entry.getKey();
                        				Integer securityQuantity = entry.getValue();
				double IR = securitydaoutil.getSecurityByName(securityName).getInterestRate();
				double marketPrice = securitydaoutil.getSecurityByName(securityName).getMarketPrice();
				double shortSecFund = securityQuantity * marketPrice;
				double secInterest = (shortSecFund * (IR / 100f) * (2f / 365f));%>
                                            <tr>
                                                <td>  <i class="mdi mdi-<%=entry.getKey().toLowerCase() %> mr-3 icon-lg text-dark"></i></td>
                                                <td><fmt:formatNumber type = "number" maxFractionDigits="3" value="<%=entry.getValue() %>"></fmt:formatNumber></td>
                                                <td>$<fmt:formatNumber type = "number" maxFractionDigits="3" value="<%=marketPrice %>"></fmt:formatNumber></td>
                                                <td><%=IR %></td>
                                                <td>$<fmt:formatNumber type = "number" maxFractionDigits="3" value="<%=secInterest %>"></fmt:formatNumber></td>
                                  
                                            </tr>
                                            <%} %>
                                        </tbody>
                                        </table>
                                </div><br><br>
                                <div class="row"><div class="col-4"></div>
                                <div class="col-4"><button class="btn btn-block btn-primary mt-2 mt-xl-0 btn-icon-text"> Borrow and Settle</button></div>
                                <div class="col-4"></div></div>
                            </div>
                            <!-- content-wrapper ends -->
                            <!-- partial:partials/_footer.html -->
                            <!-- partial -->
                        </div>
                        <!-- main-panel ends -->
                    </div>
                    <!-- page-body-wrapper ends -->
                </div>
                <!-- container-scroller -->


                <!-- plugins:js -->
                <script src="vendors/base/vendor.bundle.base.js"></script>
                <!-- endinject -->
                <!-- Plugin js for this page-->
                <script src="vendors/chart.js/Chart.min.js"></script>
                <script src="vendors/datatables.net/jquery.dataTables.js"></script>
                <script src="vendors/datatables.net-bs4/dataTables.bootstrap4.js"></script>
                <!-- End plugin js for this page-->
                <!-- inject:js -->
                <script src="js/off-canvas.js"></script>
                <script src="js/hoverable-collapse.js"></script>
                <script src="js/template.js"></script>
                <!-- endinject -->
                <!-- Custom js for this page-->
                <!-- End custom js for this page-->
</body>

</html>