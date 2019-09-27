<!DOCTYPE html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title></title>
  <!-- plugins:css -->
  <link rel="stylesheet" href="vendors/mdi/css/materialdesignicons.min.css">
  <link rel="stylesheet" href="vendors/base/vendor.bundle.base.css">
  <!-- endinject -->
  <!-- plugin css for this page -->
  <link rel="stylesheet" href="vendors/datatables.net-bs4/dataTables.bootstrap4.css">
  <!-- End plugin css for this page -->
  <!-- inject:css -->
  <link rel="stylesheet" href="css/stylecorporate.css">
  <!-- endinject -->
  <link rel="shortcut icon" href="images/favicon.png" />
</head>
<body>
  <div class="container-scroller">
    <!-- partial:partials/_navbar.html -->
    
    <!-- partial -->
    <div class="container-fluid page-body-wrapper">
      <!-- partial:partials/_sidebar.html -->
      <!-- partial -->
      <div class="main-panel">
        <div class="content-wrapper">                             
          <div class="row">
            <div class="col-md-12 grid-margin stretch-card">
              <div class="card">
                <div class="card-body dashboard-tabs p-0">
                  <ul class="nav nav-tabs px-4 justify-content-center" role="tablist">
                    <li class="nav-item">
                      <a class="nav-link active" id="overview-tab" data-toggle="tab" href="#stock-split" role="tab" aria-controls="overview" aria-selected="true">Stock split</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" id="sales-tab" data-toggle="tab" href="#cash-dividend" role="tab" aria-controls="sales" aria-selected="false">Cash dividend</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" id="purchases-tab" data-toggle="tab" href="#stock-dividend" role="tab" aria-controls="purchases" aria-selected="false">Stock Bonus</a>
                    </li>
					<li class="nav-item">
                      <a class="nav-link" id="new-tab" data-toggle="tab" href="#rights" role="tab" aria-controls="purchases" aria-selected="false">Rights</a>
                    </li>
                  </ul>
                  <div class="tab-content py-0 px-0">
                    <div class="tab-pane fade show active" id="stock-split" role="tabpanel" aria-labelledby="overview-tab">
						<div class="col-md-6 grid-margin stretch-card">
              <div class="card" style="margin-left:50%; margin-right:50%;">
                <div class="card-body ">
                  <h4 class="card-title">Input details</h4>
                 
                <form action="IssueStockSplit" method ="get">
                  <div class="form-group">
                    <div class="input-group">
                      <div class="input-group-prepend">
                        <button class="btn btn-sm btn-outline-primary dropdown-toggle"  placeholder="Security Name" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Security Name</button>
                        <div class="dropdown-menu">
                          <a class="dropdown-item" href="#apple">Apple</a>
                          <a class="dropdown-item" href="#facebook">Facebook</a>
                          <a class="dropdown-item" href="#ge">GE</a>
                          <a class="dropdown-item" href="#linkedin">LinkedIn</a>
                          <a class="dropdown-item" href="#walmart">Walmart</a>
                          <div role="separator" class="dropdown-divider"></div>
                        
                        </div>
                      </div>
                      
                          <input id="Walmart" type="text" class="form-control" aria-label="Text input with dropdown button" value="Apple" name="security">
                    </div>
                  </div>
                  
                   <div class="form-group">
                    <div class="input-group">
                      <div class="input-group-prepend">
                        <span class="input-group-text"></span>
                      </div>
                      <input type="text" class="form-control" placeholder="" aria-label="Username" name="securityname" value="1">
                      <input type="text" class="form-control" placeholder="Split Value" aria-label="Username" name="factor">
                    </div>
                  </div>
                  
                   <button class="btn btn-sm btn-primary" type="submit">Submit</button>
                  </form>
                
                  
                </div>
              </div>
            </div>
                    </div>
                    
                    
                    
                    
                    <div class="tab-pane fade" id="cash-dividend" role="tabpanel" aria-labelledby="cash-dividend-tab">
						<div class="justify-content-center ">
                      <div class="col-md-6 grid-margin stretch-card">
              <div class="card" style="margin-left:50%; margin-right:50%;">
                <div class="card-body">
                  <h4 class="card-title">Input Details</h4>
                  
                  <form action="IssueCashDividend" method ="get">
                  
                   <div class="form-group">
                    <div class="input-group">
                      <div class="input-group-prepend">
                        <button class="btn btn-sm btn-outline-primary dropdown-toggle"  placeholder="Security Name" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Security Name</button>
                        <div class="dropdown-menu">
                          <a class="dropdown-item" href="#apple">Apple</a>
                          <a class="dropdown-item" href="#facebook">Facebook</a>
                          <a class="dropdown-item" href="#ge">GE</a>
                          <a class="dropdown-item" href="#linkedin">LinkedIn</a>
                          <a class="dropdown-item" href="#walmart">Walmart</a>
                          <div role="separator" class="dropdown-divider"></div>
                        
                        </div>
                      </div>
                      
                          <input id="Walmart" type="text" class="form-control" aria-label="Text input with dropdown button" value="Apple" name="security">
                    </div>
                  </div>
                 
              
                  <div class="form-group">
                    <div class="input-group">
                      
                      <input type="text" class="form-control" aria-label="Amount (to the nearest dollar)" placeholder="Cash Dividend Percent" name="percent">
                      <div class="input-group-append">
                        <span class="input-group-text">%</span>
                      </div>
                    </div>
                  </div>
                 <button class="btn btn-sm btn-primary" type="submit">Submit</button>
                
                 
                   </form>
                </div>
              </div>
            </div>
					  </div>
                    </div>
                    
                   
                    
                    
                    <div class="tab-pane fade" id="stock-dividend" role="tabpanel" aria-labelledby="stock-dividend-tab">
                     <div class="col-md-6 grid-margin stretch-card">
              <div class="card" style="margin-left:50%; margin-right:50%;">
                <div class="card-body">
                  <h4 class="card-title">Input Details</h4>
  
                 <form action="IssueStockBonus" method ="get">
                  <div class="form-group">
                    <div class="input-group">
                      <div class="input-group-prepend">
                        <button class="btn btn-sm btn-outline-primary dropdown-toggle"  placeholder="Security Name" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Security Name</button>
                        <div class="dropdown-menu">
                          <a class="dropdown-item" href="#apple">Apple</a>
                          <a class="dropdown-item" href="#facebook">Facebook</a>
                          <a class="dropdown-item" href="#ge">GE</a>
                          <a class="dropdown-item" href="#linkedin">LinkedIn</a>
                          <a class="dropdown-item" href="#walmart">Walmart</a>
                          <div role="separator" class="dropdown-divider"></div>
                        
                        </div>
                      </div>
                      
                          <input id="Walmart" type="text" class="form-control" aria-label="Text input with dropdown button" value="Apple" name="security">
                    </div>
                  </div>
                  
                   <div class="form-group">
                    <div class="input-group">
                      <div class="input-group-prepend">
                        <span class="input-group-text"></span>
                      </div>
                      <input type="text" class="form-control" placeholder="" aria-label="Username" name="securityname" value="1">
                      <input type="text" class="form-control" placeholder="Bonus factor" aria-label="Username" name="factor">
                    </div>
                  </div>
                  
                   <button class="btn btn-sm btn-primary" type="submit">Submit</button>
                  </form>
                    </div>
                  </div>
                </div>
                    </div>
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
					<div class="tab-pane fade" id="rights" role="tabpanel" aria-labelledby="rights-tab">
                      <div class="col-md-6 grid-margin stretch-card">
              <div class="card" style="margin-left:50%; margin-right:50%;">
                <div class="card-body" >
                  <h4 class="card-title">Input Details</h4>
				 
				  <form action="IssueRights" method ="get">
                  <div class="form-group">
                    <div class="input-group">
                      <div class="input-group-prepend">
                        <button class="btn btn-sm btn-outline-primary dropdown-toggle"  placeholder="Security Name" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Security Name</button>
                        <div class="dropdown-menu">
                          <a class="dropdown-item" href="#apple">Apple</a>
                          <a class="dropdown-item" href="#facebook">Facebook</a>
                          <a class="dropdown-item" href="#ge">GE</a>
                          <a class="dropdown-item" href="#linkedin">LinkedIn</a>
                          <a class="dropdown-item" href="#walmart">Walmart</a>
                          <div role="separator" class="dropdown-divider"></div>
                        
                        </div>
                      </div>
                      
                          <input id="Walmart" type="text" class="form-control" aria-label="Text input with dropdown button" value="Apple" name="security">
                    </div>
                  </div>
                                    <div class="form-group">
                    <div class="input-group">
                      <div class="input-group-prepend">
                        <span class="input-group-text bg-primary text-white">$</span>
                      </div>
                      <input type="text" class="form-control" placeholder="Issue price" aria-label="Amount (to the nearest dollar)" name="price">
                      
                    </div>
                  </div>
                  
                   <div class="form-group">
                    <div class="input-group">
                      <div class="input-group-prepend">
                        <span class="input-group-text"></span>
                      </div>
                      <input type="text" class="form-control" placeholder="" aria-label="Username" name="securityname" value="1">
                      <input type="text" class="form-control" placeholder="Rights factor" aria-label="Username" name="factor">
                    </div>
                  </div>
                  
                   <button class="btn btn-sm btn-primary" type="submit">Submit</button>
                  </form>
                  
                 
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
  <script src="js/dashboard.js"></script>
  <script src="js/data-table.js"></script>
  <script src="js/jquery.dataTables.js"></script>
  <script src="js/dataTables.bootstrap4.js"></script>
  <!-- End custom js for this page-->
</body>

</html>

