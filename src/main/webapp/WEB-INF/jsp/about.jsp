<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>

<title>Nanta Aditya's Website</title>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport" />

<meta property="og:url" content="${url}" />
<meta property="og:type" content="Personal website" />
<meta property="og:title" content="Nanta Aditya's website" />
<meta property="og:description" content="${description}" />
<meta property="og:image"
	content="http://www.nantaaditya.com/resource/web/icon.jpg" />

<meta content='id' name='language' />
<meta name="description" content="${description}" />
<meta name="keywords" content="${keywords}" />
<meta name="author" content="Nanta Aditya">
<meta name="robots" content="index, follow">
<meta name="revisit-after" content="1 days">
<meta
	content='Aeiwi, Alexa, AllTheWeb, AltaVista, AOL Netfind, Anzwers, Canada, DirectHit, EuroSeek, Excite, Overture, Go, Google, HotBot. InfoMak, Kanoodle, Lycos, MasterSite, National Directory, Northern Light, SearchIt, SimpleSearch, WebsMostLinked, WebTop, What-U-Seek, AOL, Yahoo, WebCrawler, Infoseek, Excite, Magellan, LookSmart, CNET, Googlebot'
	name='search engines' />

<link rel="shortcut icon" type="image/png" href="/resource/web/icon.jpg" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/admin-lte/2.3.11/css/skins/skin-blue.css" />
<link rel="stylesheet" href="/css/AdminLTE.min.css" />
<link rel="stylesheet" href="/css/skin-blue-light.css" />
<link rel="stylesheet" href="/css/main.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular-resource.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular-cookies.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/angular-sanitize/1.5.6/angular-sanitize.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/angular-file-upload/2.5.0/angular-file-upload.min.js"></script>
<script src="/js/interceptor/request-interceptor.js"></script>
<script src="/js/interceptor/response-interceptor.js"></script>
<script src="/js/util/util-service.js"></script>
<script src="/js/security/security-service.js"></script>

<script src="https://www.google.com/recaptcha/api.js" async defer></script>
<script src="/js/services/contact-services.js"></script>
<script src="/js/public/about/controllers.js"></script>
<script src="/js/public/about/app.js"></script>
</head>

<body class="hold-transition skin-blue-light layout-top-nav fixed"
	ng-app="contactApp" ng-controller="contactCtrl">
	<div class="se-pre-con"></div>
	<div class="wrapper">
		<!--HEADER-->
		<header class="main-header">
			<nav class="navbar navbar-static-top">
				<div class="container">
					<div class="navbar-header">
						<a href="/" class="navbar-brand">Nanta</a>
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse" data-target="#navbar-collapse">
							<i class="fa fa-bars"></i>
						</button>
					</div>
					<div class="collapse navbar-collapse pull-left"
						id="navbar-collapse">
						<ul class="nav navbar-nav">
							<li><a href="/">Home</a></li>
							<li><a href="/blog">Blog</a></li>
							<li><a href="/gallery">Gallery</a></li>
							<li class="active"><a href="/about">About me</a></li>
						</ul>
					</div>
				</div>
			</nav>
		</header>

		<!--/HEADER-->

		<!--CONTENT WRAPPER-->
		<div class="content-wrapper">
			<div class="container">
				<section class="content-header">
					<div class="row">
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
							<h1 class="text-blue text-center">About Me</h1>
						</div>
					</div>
					<hr class="style15" />
					<!--CONTENT-->
					<div class="row">
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
							data-aos="fade-up" data-aos-delay="200">
							<div class="box box-widget widget-user">
								<div class="widget-user-header bg-blue">
									<h3 class="widget-user-username">Nanta Aditya</h3>
									<h5 class="widget-user-desc">Ordinary People</h5>
								</div>
								<div class="widget-user-image">
									<img class="img-responsive img-circle"
										src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQoTSPfa412HXD6SIeXFsP7JpnxKCn7eHeEmJI6kwXOMVeghvJj"
										alt="User Avatar">
								</div>
								<div class="box-footer">
									<div class="row">
										<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
											<p class="text-center animated tada">
												<a
													href="mailto:pramuditya.social@gmail.com?Subject=Nanta%20Web"
													target="_top"><i class="fa fa-3x fa-envelope-o"></i></a>
											</p>
										</div>
										<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
											<p class="text-center animated tada">
												<a href="https://www.facebook.com/Indigo.Boyss"><i
													class="fa fa-3x fa-facebook"></i></a>
											</p>
										</div>
										<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
											<p class="text-center animated tada">
												<a href="https://twitter.com/PramudityaAN"><i
													class="fa fa-3x fa-twitter"></i></a>
											</p>
										</div>
										<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
											<p class="text-center animated tada">
												<a href="linkedin.com/in/pramuditya-anantanur-013859136"><i
													class="fa fa-3x fa-linkedin"></i></a>
											</p>
										</div>
										<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
											<p class="text-center animated tada">
												<a href="github.com/nantaaditya"><i
													class="fa fa-3x fa-github"></i></a>
											</p>
										</div>
										<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
											<p class="text-center animated tada">
												<a href="https://bitbucket.org/NantaAditya/"><i
													class="fa fa-3x fa-bitbucket"></i></a>
											</p>
										</div>
									</div>
									<div class="row" data-aos="zoom-in-up" data-aos-delay="200">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<h3 class="text-blue text-center">Contact Me</h3>
										</div>
										<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12"></div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<form ng-submit="saveMessage()">
												<div class="form-group">
													<label class="label label-primary">Name</label> <input
														type="text" class="form-control" placeholder="name"
														ng-model="contact.name" required />
												</div>
												<div class="form-group">
													<label class="label label-primary">Email</label> <input
														type="email" class="form-control" placeholder="email"
														ng-model="contact.email" required />
												</div>
												<div class="form-group">
													<label class="label label-primary">Message</label>
													<textarea class="form-control" rows="5"
														placeholder="message" ng-model="contact.message" required></textarea>
												</div>
												<div class="form-group">
													<div class="g-recaptcha"
														data-sitekey="{{captchaPublicKey}}"
														id="captcha"></div>
												</div>
												<button type="submit" class="btn btn-success pull-right">
													<i class="fa fa-send"></i> Send
												</button>
											</form>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</section>
				<!--CONTENT-->

				<hr class="style15">
			</div>
			<!-- /CONTAINER -->
		</div>
		<!-- /CONTENT-WRAPPER -->

		<!--FOOTER-->
		<footer class="main-footer">
			<div class="container">
				<div class="navbar navbar-default"
					style="background-color: transparent; border: 0px">
					<div class="row aligned-row">
						<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
							<h3 class="text-center text-blue">Nanta</h3>
							<h4 class="text-center text-blue">
								Copyright � Nanta 2017 <br />Created By Nanta
							</h4>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
							<h4 class="text-blue text-center">MENU</h4>
							<nav class="footer-menu">
								<ul class="no-style text-center">
									<li><a href="/">Home</a></li>
									<br />
									<li><a href="/blog">Blog</a></li>
									<br />
									<li><a href="/gallery">Gallery</a></li>
									<br />
									<li><a href="/about">About Me</a></li>
									<br />
								</ul>
							</nav>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
							<h4 class="text-blue text-center">SOCIAL MEDIA</h4>
							<div class="row">
								<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
									<p class="text-center">
										<a
											href="mailto:pramuditya.social@gmail.com?Subject=Nanta%20Web"
											target="_top"><i class="fa fa-3x fa-envelope-o"></i></a>
									</p>
								</div>
								<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
									<p class="text-center">
										<a href="https://www.facebook.com/Indigo.Boyss"><i
											class="fa fa-3x fa-facebook"></i></a>
									</p>
								</div>
								<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
									<p class="text-center">
										<a href="https://twitter.com/PramudityaAN"><i
											class="fa fa-3x fa-twitter"></i></a>
									</p>
								</div>
								<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
									<p class="text-center">
										<a
											href="http://linkedin.com/in/pramuditya-anantanur-013859136"><i
											class="fa fa-3x fa-linkedin"></i></a>
									</p>
								</div>
								<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
									<p class="text-center">
										<a href="http://github.com/nantaaditya"><i
											class="fa fa-3x fa-github"></i></a>
									</p>
								</div>
								<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
									<p class="text-center">
										<a href="https://bitbucket.org/NantaAditya/"><i
											class="fa fa-3x fa-bitbucket"></i></a>
									</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</footer>
		<!--/FOOTER-->

	</div>
	<!--/WRAPPER -->

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jQuery-slimScroll/1.3.8/jquery.slimscroll.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/fastclick/1.0.6/fastclick.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/admin-lte/2.4.2/js/adminlte.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/notify/0.4.2/notify.min.js"></script>

	<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.2.0/aos.css" />
	<script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.2.0/aos.js"></script>
	<script
		src="http://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.2/modernizr.js"></script>
	<script async
		src="https://www.googletagmanager.com/gtag/js?id=UA-114339618-1"></script>
	<script>
    $(window).on('load', function() {
      // Animate loader off screen
      $(".se-pre-con").fadeOut("slow");
      ;
    });
    $(document).ready(function() {
      AOS.init();
    });
    window.dataLayer = window.dataLayer || [];
    function gtag() {
      dataLayer.push(arguments);
    }
    gtag('js', new Date());

    gtag('config', 'UA-114339618-1');
  </script>
</body>

</html>
