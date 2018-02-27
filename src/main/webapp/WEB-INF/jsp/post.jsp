<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>

<title>Nanta</title>

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
	src="https://cdnjs.cloudflare.com/ajax/libs/angular-i18n/1.6.6/angular-locale_id-id.js  "></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/angular-sanitize/1.5.6/angular-sanitize.js"></script>
<script src="/js/interceptor/request-interceptor.js"></script>
<script src="/js/interceptor/response-interceptor.js"></script>
<script src="/js/util/util-service.js"></script>
<script src="/js/security/security-service.js"></script>
</head>

<body class="hold-transition skin-blue-light layout-top-nav fixed">
	<div class="se-pre-con"></div>
	<div id="fb-root"></div>
	<script>
    (function(d, s, id) {
      var js, fjs = d.getElementsByTagName(s)[0];
      if (d.getElementById(id)) return;
      js = d.createElement(s);
      js.id = id;
      js.src = 'https://connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.11';
      fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));
  </script>

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
							<li class="active"><a href="/blog">Blog</a></li>
							<li><a href="/gallery">Gallery</a></li>
							<li><a href="/about">About me</a></li>
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
							<h1 class="text-blue">${title}</h1>
							<ol class="breadcrumb" style="background: #fff">
								<li><a href="/blog">Blog</a></li>
								<li class="active">${title}</li>
							</ol>
						</div>
					</div>
					<!--CONTENT-->
					<div class="row">
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
							<div class="box">
								<div class="box-body">
									<p class="pull-left" style="color: #888">
										<i class="fa fa-pencil"></i> Written by : Nanta
									</p>
									<p class="pull-right" style="color: #888">
										<i class="fa fa-calendar"></i> Created date : ${createdDate}
									</p>
									<div class="row">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<img src="${image}"
												class="img-responsive img-rounded center-block"
												style="height: 300px;" />
										</div>
									</div>
									<br />
									<div class="text-justify">${post}</div>
								</div>
								<div class="box-footer">
									<p class="pull-right">-Nanta, ${year}</p>
								</div>
							</div>
						</div>
					</div>
					<!--COMMENT-->
					<div class="row">
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
							<div class="panel">
								<div class="panel-body">
									<div class="fb-comments" data-href="${url}" data-numposts="5"
										data-width="100%"></div>
								</div>
							</div>
						</div>
					</div>
				</section>
				<!--CONTENT-->
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
								Copyright © Nanta 2017 <br />Created By Nanta
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
	<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.2.0/aos.css" />
	<script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.2.0/aos.js"></script>
	<script
		src="/js/prism/prism.js"></script>
	<link rel="stylesheet"
		href="/js/prism/prism.css" />
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
