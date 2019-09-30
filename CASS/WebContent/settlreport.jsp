<!DOCTYPE html>
<%@page import="com.dao.SecurityDaoUtil"%>
<%@page import="java.util.Map"%>
<%@page import="com.beans.Balance"%>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Settlement Report | CASS</title>
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
Balance balance = (Balance)request.getAttribute("balance");
Map<String,Integer> security = balance.getSecurityBalance();
Balance shortBal = (Balance)request.getAttribute("short");
Map<String,Integer> shortsecurity = shortBal.getSecurityBalance();
Balance obligation = (Balance)request.getAttribute("obligation");
Map<String,Integer> oblisecurity = obligation.getSecurityBalance();
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
                    <div class="col-lg-12 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Settlement Report</h4>
                                <div class="table-responsive mb-3">
                                    <table class="table table-hover table-bordered">
                                        <thead>
                                            <tr>
                                                <th>
                                                    #
                                                </th>
                                                <th><i class="mdi mdi-apple icon-md text-dark"></i></th>
                                                <th><i class="mdi mdi-facebook icon-md text-primary"></i></th>
                                                <th><i class="mdi mdi-linkedin icon-md text-info"></i></th>
                                                <th><i class="mdi mdi-twitter icon-md text-danger"></i></th>
                                                <th><i class="mdi mdi-amazon icon-md text-warning"></i></th>
                                                <th><i class="mdi mdi-currency-usd icon-md text-dark"></i></th>

                                            </tr>
                                        </thead>
                                        <tbody>
                                        
                                            <tr>
                                                <td>Initial Balance</td>
                                                
                                                 <% for(Map.Entry<String,Integer> entry : security.entrySet()) {
                                        	int quantity = entry.getValue();
                                        %>
                                                <td><%= quantity %></td>
                                            
                                                <% }%>
                                                
                                                <td><%= balance.getFunds()%> </td>
                                            </tr>
                                            
                                            <tr>
                                                <td>Obligations</td>
                                                   <% for(Map.Entry<String,Integer> entry : oblisecurity.entrySet()) {
                                        	int quantity = entry.getValue();
                                        %>
                                                <td><%= quantity %></td>
                                            
                                                <% }%>
                                                 <td><%= obligation.getFunds()%> </td>
                                            </tr>
                                            <tr>
                                                <td>Shortages</td>
                                                   <% for(Map.Entry<String,Integer> entry : security.entrySet()) {
                                                	   int quantity = 0;
                                                	   if(shortsecurity.containsKey(entry.getKey()))
                                        	                quantity = shortsecurity.get(entry.getKey());
                                        %>
                                                <td><%= quantity %></td>
                                            
                                                <% }%>
                                                
                                                <td> <%= shortBal.getFunds() %> </td>
                                            </tr>
                                            <tr>
                                                <td>Shortage Cost</td>
                                                   <%  {double total = 0;
                                                   for(Map.Entry<String,Integer> entry : security.entrySet()) {
                                                	   int quantity = 0;
                                                	   double secInterest = 0;
                                                	  
                                                	   if(shortsecurity.containsKey(entry.getKey())){
                                                		   
				                                        	quantity = shortsecurity.get(entry.getKey());
				                                        	SecurityDaoUtil securitydaoutil = new SecurityDaoUtil();
				                                            String securityName = entry.getKey();
				                        
				                                        	double IR = securitydaoutil.getSecurityByName(securityName).getInterestRate();
				                            				double marketPrice = securitydaoutil.getSecurityByName(securityName).getMarketPrice();
				                            				double shortSecFund = quantity * marketPrice;
				                            				secInterest = (shortSecFund * (IR / 100f) * (2f / 365f));
				                            				total = total+secInterest;
                                                	   }
                                        %>
                                                <td><%= secInterest %></td>
                                            
                                              <%} %>
                                                
                                                 <td> <%=total %> </td>
                                                 
                                                   <% }%>
                                                
                                            </tr>
                                            <tr>
                                                <td>Final Balance</td>
                                                   <% for(Map.Entry<String,Integer> entry : security.entrySet()) {
                                                	   int obli = oblisecurity.get(entry.getKey());
                                        	int quantity = entry.getValue() - obli;
                                        %>
                                                <td><%= quantity %></td>
                                            
                                                <% }%>
                                                
                                                <td><%= balance.getFunds() - obligation.getFunds()%> </td>
                                            </tr>
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