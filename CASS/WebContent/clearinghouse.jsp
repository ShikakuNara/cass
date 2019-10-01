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

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
 <script>
var tradeId;
        var table;
        var makeTable =  function () {
            table = $('#recent-trades-listing').DataTable({
              "lengthChange": false,
              "pageLength":7,
              "select": true,
              "ordering": true,
              
            }); } 
$(document).ready( function() {       
	$.ajax({ 
	    type: 'GET', 
	    url: 'showAllTrades',  
	    dataType: 'json',
		success: function (data) {
	    console.log("plkjh");
	    	makeTable();
	    	table.rows().remove().draw();
	        $.each(data, function(index,element) {
	        	var icon ="<i class='mdi mdi-";
	        	var icon_end = " icon-md' >";
	        	var html = "<div class='template-demo d-flex justify-content-between flex-nowrap'><button id='editTrade' type='button' class='mt-0 px-0 py-0 btn btn-outline-secondary btn-rounded btn-icon justify-content-between'><i class='mdi mdi-pencil' data-dismiss='modal' data-target='#exampleModal'></i></button><button type='button' id='removeTrade' class='mt-0 px-0 py-0 btn btn-outline-secondary btn-rounded btn-icon' data-dismiss='modal'><i class='mdi mdi-delete'></i></button></div>";
	        	table.row.add([element.tradeId,icon.concat(element.securityName.toLowerCase(),icon_end),element.quantity,element.price,element.buyer,element.seller,html])
	                
	        });
	        table.draw();
	       tradeId=0;
	        
	    }
	}); 
});


$(document).on("click", "#insertTrades", function() {   
	alert(tradeId);
	if(tradeId==0)
	{	
	$.ajax({ 
	    type: 'GET', 
	    url: 'addTrade', 
	    data: {tid:"0",securityName: security.value,quantity:quantity.value,price:price.value,buyer:buyer.value,seller:seller.value }, 
	    dataType: 'json',
	    success: function (data) { 
	    	console.log(data)
	    	var icon ="<i class='mdi mdi-";
	        	var icon_end = " icon-md' >";
	    	table.row.add([data.tradeId,icon.concat(data.securityName.toLowerCase(),icon_end),data.quantity,data.price,data.buyer,data.seller,"<button id='editTrade' class='btn btn-primary mr-2 mt-8' data-dismiss='modal' data-target='#exampleModal'>Edit</button> <button id='removeTrade' class='btn btn-primary mr-2 mt-8' data-dismiss='modal'>Remove</button>"])
	    	table.draw();
        	
	    }
	}); 
}
	
	else
	{	
		$.ajax({ 
		    type: 'GET', 
		    url: 'addTrade', 
		    data: {tid:tradeId,securityName: security.value,quantity:quantity.value,price:price.value,buyer:buyer.value,seller:seller.value }, 
		    dataType: 'json',
		    success: function (data) { 
		    	console.log(data)
		    	var icon ="<i class='mdi mdi-";
	        	var icon_end = " icon-md' >";
		    	table.row.add([data.tradeId,icon.concat(data.securityName.toLowerCase(),icon_end),data.quantity,data.price,data.buyer,data.seller,"<button id='editTrade' class='btn btn-primary mr-2 mt-8' data-dismiss='modal' data-target='#exampleModal'>Edit</button> <button id='removeTrade' class='btn btn-primary mr-2 mt-8' data-dismiss='modal'>Remove</button>"])
		    	table.draw();
	        	
		    }
		}); 
	}
	tradeId=0;
});



$(document).on("click", "#removeTrade", function() {
	var data = table.row( $(this).parents('tr') ).data();
	 tradeId=data[0];
	 
	 alert(tradeId);
	$.ajax({ 
	    type: 'GET', 
	    url: 'deleteTrade', 
	    data: {tid: data[0]}, 
	    dataType: 'json',
	    success: function () { 
	    	console.log("done");
	    	
	    }
	}); 
	$.ajax({ 
	    type: 'GET', 
	    url: 'showAllTrades',  
	    dataType: 'json',
		success: function (data) {
	    console.log("plkjh");
	    	//makeTable();
	    	table.rows().remove().draw();
	        $.each(data, function(index,element) {
	        	var icon ="<i class='mdi mdi-";
	        	var icon_end = " icon-md' >";
	        	table.row.add([element.tradeId,icon.concat(element.securityName.toLowerCase(),icon_end),element.quantity,element.price,element.buyer,element.seller,"<button id='editTrade' class='btn btn-primary mr-2 mt-8' data-dismiss='modal' data-target='#exampleModal'>Edit</button> <button id='removeTrade' class='btn btn-primary mr-2 mt-8' data-dismiss='modal'>Remove</button>"])
	                
	        });
	        table.draw();
	       tradeId=0;
	        
	    }
	}); 

});


$(document).on("click", "#editTrade", function() {  
	var data = table.row( $(this).parents('tr') ).data();
	 tradeId=data[0];
	 $.ajax({ 
		    type: 'GET', 
		    url: 'deleteTrade', 
		    data: {tid: data[0]}, 
		    dataType: 'json',
		    success: function () { 
		    	console.log("done");
		    	
		    }
		}); 
	 var filteredData = table
	    .rows()
	    .indexes()
	    .filter( function ( value, index ) {
	       return table.row(value).data()[0] == tradeId; 
	    } );
	table.rows( filteredData )
	.remove()
	.draw();
	 alert(tradeId);
	 document.getElementById("security").value=data[1];
	 document.getElementById("security").placeholder=data[1];
	 document.getElementById("quantity").value=data[2];
	 document.getElementById("quantity").placeholder=data[2];
	 document.getElementById("price").value=data[3];
	 document.getElementById("price").placeholder=data[3];
	 document.getElementById("buyer").value=data[4];
	 document.getElementById("buyer").placeholder=data[4];
	 document.getElementById("seller").value=data[5];
	 document.getElementById("seller").placeholder=data[5];
	$("#outAdd")[0].click();
	
	//tradeId=0;
});
</script>
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
                                <p class="mb-md-0">Details of all transactions today.</p><br>
                                <button type="button" class="btn btn-success" data-toggle="modal" data-target="#exampleModal" id="outAdd">Add Trade</button>
                              </div>
                              
                          </div>
                          
                        </div>
                        
                      </div>
                  <div class="table-responsive">
                    <table id="recent-trades-listing" class="table table-hover">
                       <thead>
                        <tr>
                            <th>Trade Id</th>
                            <th>Security</th>
                            <th>Quantity</th>
                            <th>Price</th>
                            <th>Buyer</th>
                            <th>Seller</th>
                           <th>Action</th>
                        </tr>
                      </thead>
                      <tbody>
                      
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

  <!-- Button trigger modal -->


<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      
      <div class="modal-body">
			<div class="card-body">
                  <h4 class="card-title"></h4>
                  <form class="forms-sample">
                    <div class="form-group">
					<div class="row">
						<div class="col-6">
						<label for="exampleInputUsername1">Security</label>
						
						<select class="form-control" id="security">
                              <option>LinkedIn</option>
                              <option>Apple</option>
                              <option>Twitter</option>
                              <option>Facebook</option>
							  <option>Amazon</option>
                            </select>
						
                      
						</div>
						<div class="col-6">
						<label for="exampleInputEmail1"> Quantity</label>
                      <input type="number" class="form-control" id="quantity" placeholder="Quantity">
						</div>
						
					</div>
					
					
					
					<div class="row">
						<div class="col-6">
						 <label for="exampleInputPassword1">Price</label>
                      <input type="number" class="form-control" id="price" placeholder="Price">
						</div>
						<div class="col-6">
						<label for="exampleInputConfirmPassword1">Buyer Clearing member</label>
						<select class="form-control" id="buyer">
                              <option>JP Morgan</option>
                              <option>Citi</option>
                              <option>GoldmanSachs</option>
                              <option>DeutscheBank</option>
                              <option>Barclays</option>
                              <option>CreditSuisse</option>
                            </select>
                      
						</div>
						
					</div>
					
					
					<div class="row">
						<div class="col-6">
						 <label for="exampleInputPassword1">Seller Clearing Member</label>
						 <select class="form-control" id="seller">
                              <option>JP Morgan</option>
                              <option>Citi</option>
                              <option>GoldmanSachs</option>
                              <option>DeutscheBank</option>
                              <option>Barclays</option>
                              <option>CreditSuisse</option>
                            </select>
                     
						</div>
						
						
					</div>
                  </form>
                </div>
              </div>
      </div>
  <div class="modal-footer">
        <!--button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button-->
		
		<div>
			<div >
				<button id="insertTrades" class="btn btn-primary mr-2 mt-8" data-dismiss="modal">Okay</button>
				<!--button class="btn btn-light mt-8 form-control" >Cancel</button-->
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
  <script>
        var trnd = function () {
            $('.mdi-apple').addClass("text-dark");
            $('.mdi-facebook').addClass("text-primary");
            $('.mdi-linkedin').addClass("text-info");
            $('.mdi-amazon').addClass("text-warning");
            $('.mdi-twitter').addClass("text-primary");
        }
    </script>
  <!-- endinject -->
  <!-- Custom js for this page-->
  <!-- End custom js for this page-->
</body>

</html>

