<!DOCTYPE html>
<%@page import="java.util.Map"%>
<%@page import="com.dao.ClearingMemberDaoUtil"%>
<%@page import="com.beans.Balance"%>
<%@page import="com.beans.ClearingMember"%>
<%@page import="java.util.List"%>
<%@ taglib prefix ="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Obligations | CASS</title>
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
 
</head>
<body>
<%
List<Balance> obligations = (List<Balance>) request.getAttribute("obligation");
%>
  <div class="container-scroller"></div>
    <div class="container-fluid page-body-wrapper" style="padding-top: 0%">
      <!-- partial:partials/_sidebar.html -->
      <nav class="sidebar sidebar-offcanvas" id="sidebar">
          
              <div class="content-wrapper d-flex align-items-center auth" style="padding:0%">
                <div class="row w-100">
                  
                    <div class="auth-form-light text-center py-5 px-5 px-sm-5">
                      <div class="brand-logo" style="padding-left: 0.6em; padding-right: 0.6em">
                        <img src="images/logo.jpg" alt="logo">
                      </div>
                    </div>
                  </div>
               
           
              <!-- content-wrapper ends -->
            </div>
        <ul class="nav">
          <li class="nav-item">
            <a class="nav-link" href="clearinghouse.jsp">
              <i class="mdi mdi-database menu-icon text-primary"></i>
              <span class="menu-title">Trade Data</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="obligation">
              <i class="mdi mdi-chart-pie menu-icon text-warning"></i>
              <span class="menu-title">Obligations</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="restart">
              <i class="mdi mdi-refresh menu-icon text-info"></i>
              <span class="menu-title">Restart Process </span>
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
                                <div class="row ">
                                    <div class="col-md-12 grid-margin ">
                                        <div class="align-items-center flex-wrap">
                                            <div class="mr-md-3 mr-xl-5 text-center">
                                            <h2>Net Obligation Report</h2>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                              <div class="table-responsive">
                                <table class="table table-hover table-bordered text-center">
                                  <thead>
                                    <tr>
                                      <th>#</th>
                                      <td class="py-1">
                                            <i class="mdi mdi-apple mr-3 icon-lg text-dark"></i>
                                        </td>
                                        <td class="py-1">
                                            <i class="mdi mdi-facebook  mr-3 icon-lg text-primary"></i>
                                        </td>
                                        <td class="py-1">
                                             <i class="mdi mdi-linkedin mr-3 icon-lg text-info"></i>
                                        </td>
                                        <td class="py-1">
                                             <i class="mdi mdi-twitter mr-3 icon-lg text-primary"></i>
                                        </td>
                                        <td class="py-1">
                                             <i class="mdi mdi-amazon mr-3 icon-lg text-warning"></i>
                                        </td>
                                        <td class="py-1">
                                             <i class="mdi mdi-currency-usd mr-3 icon-lg text-dark"></i>
                                        </td>
                                    </tr>
                                  </thead>
                                  <tbody>
                                  
                               <% for(Balance balance: obligations) {
                                ClearingMemberDaoUtil dao = new ClearingMemberDaoUtil(); 
                               String name = dao.getNameById(balance.getClearingMemberId()); %>
                              
                                    <tr>
                                      <td><b><%= name %></b></td>
                               <%        Map<String,Integer> security=balance.getSecurityBalance();
                               for(Map.Entry<String,Integer> entry: security.entrySet()) { 
                               %>
                               <%if(entry.getValue()>0){ %>
                                      <td class="text-success"><b><fmt:formatNumber type = "number" maxFractionDigits="3" value="<%=entry.getValue() %>"></fmt:formatNumber> <i class="mdi mdi-arrow-up"></i></b></td>
                                      <%}else if(entry.getValue()<0){ %>
                                      <td class="text-danger"><b><fmt:formatNumber type = "number" maxFractionDigits="3" value="<%=entry.getValue() %>"></fmt:formatNumber> <i class="mdi mdi-arrow-down"></i></b></td>
                                      <%}else { %>
                                       <td class="text-dark"><fmt:formatNumber type = "number" maxFractionDigits="3" value="<%=entry.getValue() %>"></fmt:formatNumber> </td>
                                    <%} } %>  
                                    <%if (balance.getFunds() >0){%>
                                    <td><label class="badge badge-success">$<fmt:formatNumber type = "number" maxFractionDigits="3" value="<%=balance.getFunds() %>"></fmt:formatNumber></label></td>
                                    <% }else if (balance.getFunds() <0) { %>
                                      <td><label class="badge badge-danger">$<fmt:formatNumber type = "number" maxFractionDigits="3" value="<%=balance.getFunds() %>"></fmt:formatNumber></label></td>
                                      <%} else { %>
                                       <td><b><label class="text-dark">$<fmt:formatNumber type = "number" maxFractionDigits="3" value="<%=balance.getFunds() %>"></fmt:formatNumber></label></b></td>
                                    </tr>
                                    
                              
                                    <%} }%>
                                    
                                  </tbody>
                                </table>
                              </div>
                            </div>
                          </div>
                        </div></div> 
            <div class="row">
                <div class="col-lg-6 grid-margin stretch-card">
                    <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">Funds</h4>
                        <canvas id="barChart"></canvas>
                    </div>
                    </div>
                </div>
                <div class="col-lg-6 grid-margin stretch-card">
                    <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">Apple</h4>
                        <canvas id="barChart1"></canvas>
                    </div>
                    </div>
                </div>
            </div>   
            <div class="row">
                    <div class="col-lg-6 grid-margin stretch-card">
                        <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">LinkedIn</h4>
                            <canvas id="barChart2"></canvas>
                        </div>
                        </div>
                    </div>
                    <div class="col-lg-6 grid-margin stretch-card">
                        <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">Walmart</h4>
                            <canvas id="barChart3"></canvas>
                        </div>
                        </div>
                    </div>
                </div>   
                <div class="row">
                        <div class="col-lg-6 grid-margin stretch-card">
                            <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Facebook</h4>
                                <canvas id="barChart4"></canvas>
                            </div>
                            </div>
                        </div>
                        <div class="col-lg-6 grid-margin stretch-card">
                            <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">GE</h4>
                                <canvas id="barChart5"></canvas>
                            </div>
                            </div>
                        </div>
                    </div>   
      </div>
    </div>
  </div>

  
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

<script src="js/chartUser.js"></script>
</body>

</html>
