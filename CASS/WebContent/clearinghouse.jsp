<!DOCTYPE html>
<%@ taglib prefix ="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Trade Data | CASS</title>
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
  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/w/bs4/dt-1.10.18/b-1.5.6/sl-1.3.0/datatables.min.css"/>
 
<script type="text/javascript" src="https://cdn.datatables.net/w/bs4/dt-1.10.18/b-1.5.6/sl-1.3.0/datatables.min.js"></script>
</head>
<body>
<% String message = (String)request.getAttribute("message"); 
String status = (String)request.getAttribute("status");
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
              <div class="row" id="proBanner">
                <div class="col-md-12 grid-margin">
                <%if(status!=null && status.equals("fail")) {%>
                  <div class="card bg-gradient-danger border-0">
                    <div class="card-body py-3 px-4 d-flex align-items-center justify-content-between flex-wrap">
                      <p class="mb-0 text-black font-weight-medium"><%=message %></p>
                      <div class="d-flex">
                        <button id="bannerClose" class="btn border-0 p-0">
                          <i class="mdi mdi-close text-black"></i>
                        </button>
                      </div>
                    </div>
                  </div>
                  <% } else if(status!=null && status.equals("success")){%>
                  <div class="card bg-gradient-success border-0">
                  <div class="card-body py-3 px-4 d-flex align-items-center justify-content-between flex-wrap">
                      <p class="mb-0 text-black font-weight-medium"><%=message %></p>
                      <div class="d-flex">
                        <button id="bannerClose" class="btn border-0 p-0">
                          <i class="mdi mdi-close text-black"></i>
                        </button>
                      </div>
                    </div>
                  
                </div>
                <%} %>
              </div></div>
          <div class="row">
            <div class="col-md-12 stretch-card">
              <div class="card">
                <div class="card-body">
                    <div class="row ">
                        <div class="col-md-12 grid-margin ">
                          <div class="align-items-center flex-wrap">
                              <div class="mr-md-3 mr-xl-5 text-center">
                                <h2>Trade Data</h2>
                                <p class="mb-md-0">Details of all transactions today.</p>
                              </div>
                          </div>
                        </div>
                      </div>
                  <div class="table-responsive">
                    <table id="recent-trades-listing" class="table table-hover">
                      <thead>
                        <tr>
                            <th>Name</th>
                            <th>Status report</th>
                            <th>Office</th>
                            <th>Price</th>
                            <th>Percentage</th>
                            <th>Date</th>
                            <th>Gross amount</th>
                            <th>Action</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                            <td class="py-1">
                                <img src="images/faces/face4.jpg" alt="image"/>
                            </td>
                            <td>Levelled up</td>
                            <td>Catalinaborough</td>
                            <td>$790</td>
                            <td class="text-danger"> 28.76% <i class="mdi mdi-arrow-down"></i></td>
                            <td>06 Jan 2018</td>
                            <td>$2274253</td>
                            <td><label class="badge badge-danger">Sell</label></td>
                        </tr>
                        <tr>
                            <td class="py-1">
                                <img src="images/faces/face3.jpg" alt="image"/>
                            </td>
                            <td>Ui design completed</td>
                            <td>East Mayra</td>
                            <td>$23230</td>
                            <td class="text-danger"> 28.76% <i class="mdi mdi-arrow-down"></i></td>
                            <td>18 Jul 2018</td>
                            <td>$83127</td>
                            <td><label class="badge badge-success">Buy</label></td>
                        </tr>
                        <tr>
                            <td class="py-1">
                                <img src="images/faces/face1.jpg" alt="image"/>
                            </td>
                            <td>support</td>
                            <td>Makennaton</td>
                            <td>$939</td>
                            <td class="text-danger"> 28.76% <i class="mdi mdi-arrow-down"></i></td>
                            <td>16 Jul 2018</td>
                            <td>$29177</td>
                            <td><label class="badge badge-success">Buy</label></td>
                        </tr>
                        <tr>
                            <td class="py-1">
                                <img src="images/faces/face2.jpg" alt="image"/>
                            </td>
                            <td>support</td>
                            <td>Agustinaborough</td>
                            <td>$30</td>
                            <td class="text-primary"> 28.76% <i class="mdi mdi-arrow-up"></i></td>
                            <td>30 Apr 2018</td>
                            <td>$44617</td>
                            <td><label class="badge badge-success">Buy</label></td>
                        </tr>
                        <tr>
                            <td class="py-1">
                                <img src="images/faces/face3.jpg" alt="image"/>
                            </td>
                            <td>Ui design not completed</td>
                            <td>Lake Sandrafort</td>
                            <td>$571</td>
                            <td class="text-primary"> 28.76% <i class="mdi mdi-arrow-up"></i></td>
                            <td>25 Jun 2018</td>
                            <td>$78952</td>
                            <td><label class="badge badge-danger">Sell</label></td>
                        </tr>
                        <tr>
                            <td class="py-1">
                                <img src="images/faces/face4.jpg" alt="image"/>
                            </td>
                            <td>Ui design completed</td>
                            <td>Cassinbury</td>
                            <td>$36</td>
                            <td class="text-primary"> 28.76% <i class="mdi mdi-arrow-up"></i></td>
                            <td>05 Nov 2018</td>
                            <td>$36422</td>
                            <td><label class="badge badge-danger">Sell</label></td>
                          </tr>
                        <tr>
                            <td class="py-1">
                                <img src="images/faces/face2.jpg" alt="image"/>
                            </td>
                            <td>New project</td>
                            <td>Cletaborough</td>
                            <td>$314</td>
                            <td class="text-primary"> 28.76% <i class="mdi mdi-arrow-up"></i></td>
                            <td>12 Jul 2018</td>
                            <td>$34167</td>
                            <td><label class="badge badge-danger">Sell</label></td>
                          </tr>
                        <tr>
                            <td class="py-1">
                                <img src="images/faces/face1.jpg" alt="image"/>
                            </td>
                            <td>Levelled up</td>
                            <td>West Fidelmouth</td>
                            <td>$484</td>
                            <td class="text-primary"> 28.76% <i class="mdi mdi-arrow-up"></i></td>
                            <td>08 Sep 2018</td>
                            <td>$50862</td>
                            <td><label class="badge badge-danger">Sell</label></td>
                          </tr>
                      </tbody>
                    </table>
                  </div><br><br>
                  <div class="row"><div class="col-4"></div>
                  <div class="col-4"><a href="startClearing"  style="text-decoration: none"><button class="btn btn-block btn-primary mt-2 mt-xl-0 btn-icon-text"><i class="mdi mdi-chart-areaspline btn-icon-prepend"></i> Generate report</button></a></div>
                  <div class="col-4"></div></div>
                  
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
  <script>
  $(document).ready( function () {
    var table = $('#recent-trades-listing').DataTable({
      
      "lengthChange": false,
      "pageLength":7,
      "select": true,
      "ordering": true,
      
    }); }); 
  </script>
  <!-- End custom js for this page-->
</body>

</html>
<!-- 
"columnDefs": [{
  "targets": -1,       // -1 = last column
  "data": null,        // no data for this column, instead we will show default content, described in 'defaultContent'
  "defaultContent": "<div class='btn-group' role='group' aria-label='Basic example'><button type='button' class='btn btn-lg btn-outline-primary'><i class='mdi mdi-pencil'></i></button><button type='button' class='btn btn-lg btn-outline-primary'><i class='mdi mdi-delete'></i></button></div>"
}], -->
