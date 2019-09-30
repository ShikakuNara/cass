<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Corporate Actions | CASS</title>
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
 String message = (String) request.getAttribute("message");
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
                    <a class="nav-link" href="#split">
                        <i class="mdi mdi-call-split menu-icon text-warning"></i>
                        <span class="menu-title">Stock Split</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#bonus">
                        <i class="mdi mdi-plus-circle-multiple-outline menu-icon text-primary"></i>
                        <span class="menu-title">Stock Bonus</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#cash">
                        <i class="mdi mdi-currency-usd menu-icon text-dark"></i>
                        <span class="menu-title">Cash Dividend </span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#rights">
                        <i class="mdi mdi-cash-multiple menu-icon text-info"></i>
                        <span class="menu-title">Rights</span>
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
                        <div class="card bg-gradient-success border-0">
                            <div
                                class="card-body py-3 px-4 d-flex align-items-center justify-content-between flex-wrap">
                                <p class="mb-0 text-black font-weight-medium">${message}</p>
                                <div class="d-flex">
                                    <button id="bannerClose" class="btn border-0 p-0">
                                        <i class="mdi mdi-close text-black"></i>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6 grid-margin stretch-card">
                        <div class="card" id="split">
                            <div class="card-body">
                                <div class="d-flex align-items-center mb-3">
                                    <i class="mdi mdi-call-split icon-md text-warning"></i>
                                    <h4 class="mb-0 ml-3 card-title">Stock Split</h4>
                                </div>
                                <form action ="IssueStockSplit" method = "get" class="forms-sample">
                                    <div class="form-group row">
                                        <label class="col-sm-3 col-form-label">Security</label>
                                        <div class="col-sm-9">
                                            <select class="form-control" name="security">
                                                <option selected disabled>Please select an option</option>
                                                <option value="Apple">Apple</option>
                                                <option value="LinkedIn">LinkedIn</option>
                                                <option value="Twitter">Twitter</option>
                                                <option value="Amazon">Amazon</option>
                                                <option value="Facebook">Facebook</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">Issue</label>
                                        <div class="col-sm-6">
                                            <input type="number" placeholder="1" class="form-control" name="factor" />
                                        </div>
                                        <label class="col-sm-4 col-form-label">shares for 1 share</label>
                                    </div>
                                    <button type="submit" class="btn btn-primary mr-2">Issue</button>
                                    <button type="reset" class="btn btn-light">Reset</button>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 grid-margin stretch-card">
                        <div class="card" id="bonus">
                            <div class="card-body">
                                <div class="d-flex align-items-center mb-3">
                                    <i class="mdi mdi-plus-circle-multiple-outline icon-md text-primary"></i>
                                    <h4 class="mb-0 ml-3 card-title">Stock Bonus</h4>
                                </div>
                                <form action="IssueStockBonus" method="get" class="forms-sample">
                                    <div class="form-group row">
                                        <label class="col-sm-3 col-form-label">Security</label>
                                        <div class="col-sm-9">
                                            <select class="form-control" name="security">
                                                <option selected disabled>Please select an option</option>
                                                <option value="Apple">Apple</option>
                                                <option value="LinkedIn">LinkedIn</option>
                                                <option value="Twitter">Twitter</option>
                                                <option value="Amazon">Amazon</option>
                                                <option value="Facebook">Facebook</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">Issue</label>
                                        <div class="col-sm-6">
                                            <input type="number" placeholder="1" class="form-control" name="factor"/>
                                        </div>
                                        <label class="col-sm-4 col-form-label">shares for 1 share</label>
                                    </div>
                                    <button type="submit" class="btn btn-primary mr-2">Issue</button>
                                    <button type="reset" class="btn btn-light">Reset</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6 grid-margin stretch-card">
                        <div class="card" id="cash">
                            <div class="card-body">
                                <div class="d-flex align-items-center mb-3">
                                    <i class="mdi mdi-currency-usd icon-md text-dark"></i>
                                    <h4 class="mb-0 ml-3 card-title">Cash Dividend</h4>
                                </div>
                                <form action="IssueCashDividend" method="get" class="forms-sample">
                                    <div class="form-group row">
                                        <label class="col-sm-3 col-form-label">Security</label>
                                        <div class="col-sm-9">
                                            <select class="form-control" name="security"
                                                onchange="checkvalue(this.value)">
                                                <option selected disabled>Please select an option</option>
                                                <option value="Apple">Apple</option>
                                                <option value="LinkedIn">LinkedIn</option>
                                                <option value="Twitter">Twitter</option>
                                                <option value="Amazon">Amazon</option>
                                                <option value="Facebook">Facebook</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-3 col-form-label">Facevalue</label>
                                        <div class="col-sm-9">
                                            <input type="text" id="facevalue" class="form-control" disabled />
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-3 col-form-label">% Value</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" name="percent"/>
                                        </div>
                                    </div>
                                    <button type="submit" class="btn btn-primary mr-2">Issue</button>
                                    <button type="reset" class="btn btn-light">Reset</button>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 grid-margin stretch-card">
                        <div class="card" id="rights">
                            <div class="card-body">
                                <div class="d-flex align-items-center mb-3">
                                    <i class="mdi mdi-cash-multiple icon-md text-info"></i>
                                    <h4 class="mb-0 ml-3 card-title">Rights
                                    </h4>
                                </div>
                                <form action="IssueRights" method="get" class="forms-sample">
                                    <div class="form-group row">
                                        <label class="col-sm-3 col-form-label">Security</label>
                                        <div class="col-sm-9">
                                            <select class="form-control" name="security">
                                                <option selected disabled>Please select an option</option>
                                                <option value="Apple">Apple</option>
                                                <option value="LinkedIn">LinkedIn</option>
                                                <option value="Twitter">Twitter</option>
                                                <option value="Amazon">Amazon</option>
                                                <option value="Facebook">Facebook</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-3 col-form-label">Issue Value</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" name="issueValue" />
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">Issue</label>
                                        <div class="col-sm-6">
                                            <input type="number" placeholder="1" class="form-control" name="factor" />
                                        </div>
                                        <label class="col-sm-4 col-form-label">rights for 1 share</label>
                                    </div>
                                    <button type="submit" class="btn btn-primary mr-2">Issue</button>
                                    <button type="reset" class="btn btn-light">Reset</button>
                                </form>
                            </div>
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
        function checkvalue(val) {
            if (val === "Apple")
                document.getElementById('facevalue').value = '$123';
            else if (val === "Twitter")
                document.getElementById('facevalue').value = '$11';
            else if (val === "Facebook")
                document.getElementById('facevalue').value = '$250';
            else if (val === "LinkedIn")
                document.getElementById('facevalue').value = '$345';
            else if (val === "Amazon")
                document.getElementById('facevalue').value = '$100';

        }
    </script>
    <!-- End custom js for this page-->
</body>

</html>