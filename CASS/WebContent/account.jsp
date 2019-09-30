<!DOCTYPE html>
<%@page import="com.beans.Rights"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="com.beans.Balance"%>
<%@ taglib prefix ="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Account | CASS</title>
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
<% Balance balance = (Balance) request.getAttribute("balance");
Map<String,Integer> security = balance.getSecurityBalance();
List<Rights> right=balance.getRights();%>
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
                    <a class="nav-link" href="clearingmember.html">
                        <i class="mdi mdi-database menu-icon text-primary"></i>
                        <span class="menu-title">Trade Data</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="oblreport.html">
                        <i class="mdi mdi-elevator menu-icon text-warning"></i>
                        <span class="menu-title">Obligation Report</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="settlreport.html">
                        <i class="mdi mdi-file-check menu-icon text-info"></i>
                        <span class="menu-title">Settlement Report </span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="reconstatement.html">
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
                    <a class="nav-link" href="logout">
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
                    <div class="col-lg-6 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Balance</h4>
                                <div class="table-responsive">
                                    <table class="table table-hover table-bordered">
                                        <thead>
                                            <tr>
                                                <th>
                                                    Security
                                                </th>
                                                <th>
                                                    Quantity
                                                </th>
                                                <th>
                                                    Action
                                                </th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <% for(Map.Entry<String,Integer> entry : security.entrySet()) {
                                        	int quantity = entry.getValue();
                                        %>
                                            <tr>
                                                <td><i class="mdi mdi-<%=entry.getKey().toLowerCase() %> icon-md text-dark"></i></td>
                                                <td><fmt:formatNumber type = "number" maxFractionDigits="3" value="<%=quantity %>"></fmt:formatNumber></td>
                                                <td><button type="button"
                                                        class="btn btn-sm btn-outline-dark btn-rounded btn-icon">
                                                        <i class="mdi mdi-pencil"></i>
                                                    </button></td>
                                            </tr>
                                            <%} %>
                                            
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <!-- content-wrapper ends -->
                            <!-- partial:partials/_footer.html -->
                            <!-- partial -->
                        </div>
                        <!-- main-panel ends -->
                    </div>
                    <!-- page-body-wrapper ends -->
                    <div class="col-lg-6 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Rights</h4>
                                <div class="table-responsive">
                                    <table class="table table-hover table-bordered">
                                        <thead>
                                            <tr>
                                                <th>
                                                    Security
                                                </th>
                                                <th>
                                                    Quantity
                                                </th>
                                                <th>
                                                    Price
                                                </th>
                                                <th>
                                                    Action
                                                </th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <% for(Rights r:right) {
                                        %>
                                            <tr>
                                                <td><i class="mdi mdi-<%=r.getSecurityName().toLowerCase() %> icon-md text-dark"></i></td>
                                                <td><fmt:formatNumber type = "number" maxFractionDigits="3" value="<%=r.getQuantity()%>"></fmt:formatNumber></td>
                                                <td>$<fmt:formatNumber type = "number" maxFractionDigits="3" value="<%=r.getMarketPrice() %>"></fmt:formatNumber></td>
                                                <td><button type="button"
                                                        class="btn btn-sm btn-outline-dark btn-rounded btn-icon">
                                                        <i class="mdi mdi-share"></i>
                                                    </button></td>
                                            </tr>
                                            <%} %>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <!-- content-wrapper ends -->
                            <!-- partial:partials/_footer.html -->
                            <!-- partial -->
                        </div>
                        <!-- main-panel ends -->
                    </div>
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