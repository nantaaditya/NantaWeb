<html>

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Tiga Pilar Sistem</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css" />
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/admin-lte/2.3.11/css/skins/skin-blue.css" />
  <link rel="stylesheet" href="adminlte/dist/css/AdminLTE.min.css" />
  <link rel="stylesheet" href="adminlte/dist/css/skins/skin-blue-light.css" />
  <link rel="stylesheet" href="css/main.css" />
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css" />
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular-resource.min.js"></script>
</head>

<body class="hold-transition skin-blue-light sidebar-collapse sidebar-mini">
  <div class="wrapper">
    <header class="main-header">
      <a href="" class="logo">
        <span class="logo-mini"><b>N</b></span>
        <span class="logo-lg"><b>Nanta</b> System</span>
      </a>
      <nav class="navbar navbar-static-top">
        <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </a>
        <div class="navbar-custom-menu">
          <ul class="nav navbar-nav">
            <li class="dropdown user user-menu">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                <img src="http://placehold.it/200x200/39CCCC/ffffff&text=O" class="user-image" alt="User Image">
                <span class="hidden-xs">Nanta</span>
              </a>
              <ul class="dropdown-menu">
                <li class="user-header">
                  <img src="http://placehold.it/200x200/39CCCC/ffffff&text=O" class="img-circle" alt="User Image">
                  <p>
                    Nanta
                    <small>Administrator</small>
                  </p>
                </li>
                <li class="user-body">
                </li>
                <li class="user-footer">
                  <div class="btn-group-vertical btn-block">
                    <button class="btn btn-flat btn-warning" data-toggle="modal" data-target="#change-password-modal"><i class="fa fa-unlock-alt"></i> Ganti Kata Sandi</button>
                    <button class="btn btn-flat btn-danger"><i class="fa fa-sign-out"></i> Keluar</button>
                  </div>
                </li>
              </ul>
            </li>
          </ul>
        </div>
      </nav>
    </header>

    <!-- ============================SIDEBAR============================ -->
    <aside class="main-sidebar">
      <section class="sidebar">
        <ul class="sidebar-menu" data-widget="tree">
          <li class="header">MAIN NAVIGATION</li>
          <li>
            <a href="#"><i class="fa fa-dashboard"></i> <span>Dashboard</span></a>
          </li>
          <li>
            <a href="#"><i class="fa fa-home"></i> <span>Home</span></a>
          </li>
          <li>
            <a href="#"><i class="fa fa-pencil"></i> <span>Blog</span></a>
          </li>
          <li>
            <a href="#"><i class="fa fa-image"></i> <span>gallery</span></a>
          </li>
          <li>
            <a href="#"><i class="fa fa-user"></i> <span>Contact</span></a>
          </li>
          <li class="active">
            <a href="#"><i class="fa fa-calendar"></i> <span>Reminder</span></a>
          </li>
        </ul>
      </section>
    </aside>
    <!-- ============================CONTENT============================ -->
    <div class="content-wrapper">
      <section class="content-header">
        <h3 class="text-center text-blue"><b>Reminder Dashboard</b></h3>
        <div id="change-password-modal" class="modal fade" role="dialog">
          <div class="modal-dialog modal-sm">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Ganti Kata Sandi</h4>
              </div>
              <div class="modal-body">
                <form>
                  <div class="form-group">
                    <label class="label label-default">Username</label>
                    <input type="text" class="form-control" disabled/>
                  </div>
                  <div class="form-group">
                    <label class="label label-default">Kata Sandi Lama</label>
                    <input type="password" class="form-control" />
                  </div>
                  <div class="form-group">
                    <label class="label label-default">Kata Sandi Baru</label>
                    <input type="password" class="form-control" />
                  </div>
                  <button type="submit" class="btn btn-block btn-flat btn-success"><i class="fa fa-save"></i> Simpan</button>
                </form>
              </div>
            </div>
          </div>
        </div>
      </section>

      <section class="content">
        <div class="row">
          <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">

          </div>
          <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
            <div class="table-responsive">
              <table class="table table-hover table-striped table-condensed">
                <thead>
                  <tr>
                    <th class="bg-blue text-center">Note</th>
                    <th class="bg-blue text-center">Start Date</th>
                    <th class="bg-blue text-center">End Date</th>
                    <th class="bg-blue text-center">Option</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>asdfg</td>
                    <td>asdfg</td>
                    <td>asdfg</td>
                    <td class="text-center">
                      <button class="btn btn-danger"><i class="fa fa-close"></i></button>
                    </td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </section>
    </div>
    <!-- ============================FOOTER============================ -->
    <footer class="main-footer">
      <div class="navbar navbar-default navbar-fixed-bottom">
        <p class="pull-right"><strong>Copyright &copy; 2017. Pramuditya Anantanur.</strong> All rights reserved.</p>
      </div>
    </footer>
  </div>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jQuery-slimScroll/1.3.8/jquery.slimscroll.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/fastclick/1.0.6/fastclick.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/admin-lte/2.4.2/js/adminlte.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.2.0/aos.css" />
  <script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.2.0/aos.js"></script>
  <script src="http://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.2/modernizr.js"></script>
  <script>
    $(window).on('load', function() {
      // Animate loader off screen
      $(".se-pre-con").fadeOut("slow");;
    });
    $(document).ready(function() {
      AOS.init();
    });
  </script>
</body>

</html>
