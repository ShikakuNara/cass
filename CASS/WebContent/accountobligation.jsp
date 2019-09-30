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
  <title>Majestic Admin</title>
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
		Balance balance = (Balance) request.getAttribute("balance");
		Map<String,Integer> security = balance.getSecurityBalance();
		List<Rights> rights = balance.getRights();
	%>
  <div class="container-scroller">
    <!-- partial -->
    
      <!-- partial:partials/_sidebar.html -->
      
      <!-- partial -->
      <div class="main-panel">
        <div class="content-wrapper">
          
        
                   
          <div class="row">
            <div class="col-md-7 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <p class="card-title"><h3>SECURITIES</h3></p>
                  <div class="table-responsive">
                    <table id="recent-purchases-listing" class="table">
                      <thead>
                        <tr>
                            <th>Name</th>
                            <th>Quantity</th>
                             <th>Edit</th>
                            
                        </tr>
                      </thead>
                      
                       <% for(Map.Entry<String,Integer> entry: security.entrySet())  {
        	 
        	 String securityName = entry.getKey();
        	 Integer quantity = entry.getValue();
         %> 
                      <tbody>
                
                        
                        
                        <tr>
                            <td><%= securityName %></td>
                            <td><%= quantity %></td>
                           <td><a href="">Edit Quantity</a></td> 
                            
                        </tr>
                 <%} %>       
                      </tbody>
                    </table>
                  </div>
              </div>
            </div>
			</div>
            <div class="col-md-5 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <p class="card-title"><h3>FUNDS</h3></p>
					<h1>$<%= balance.getFunds() %></h1>                  
                 
                                    
                </div>
                
              </div>
            </div>
          </div>
        </div>
        <!-- content-wrapper ends -->
        <!-- partial:partials/_footer.html -->
        
        <!-- partial -->
      </div>
      <!-- main-panel ends -->
    </div>
    
    <a href=""> Settle </a>
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
  <script src="js/dashboard.js"></script>
  <script src="js/data-table.js"></script>
  <script src="js/jquery.dataTables.js"></script>
  <script src="js/dataTables.bootstrap4.js"></script>
  <!-- End custom js for this page-->
</body>

</html>

