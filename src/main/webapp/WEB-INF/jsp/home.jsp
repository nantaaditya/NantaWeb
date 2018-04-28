<!DOCTYPE html>
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
<script src="/js/services/about-services.js"></script>
<script src="/js/services/education-services.js"></script>
<script src="/js/services/skill-services.js"></script>
<script src="/js/services/project-services.js"></script>
<script src="/js/public/home/controllers.js"></script>
<script src="/js/public/home/app.js"></script>
</head>

<body class="hold-transition skin-blue-light layout-top-nav fixed"
	ng-app="homeApp" ng-controller="homeCtrl">
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
							<li class="active"><a href="/">Home</a></li>
							<li><a href="/blog">Blog</a></li>
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
			<div class="container fill">
				<section class="content-header no-padding">
					<div class="row bg-blue">
						<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12 vcenter">
							<br class="visible-lg visible-md" /> <br
								class="visible-lg visible-md" />
							<h2 class="text-center">{{date | date:'EEEE'}}, {{date |
								date:'dd MMMM yyyy'}}</h2>
							<br class="visible-lg visible-md" />
							<h1 class="text-center" style="font-size: 100px">{{clock |
								date:'HH:mm'}}</h1>
							<br class="visible-lg visible-md" />
							<h4 class="text-center">Nice to meet you</h4>
							<br class="visible-lg visible-md" />
						</div>
						<div class="col-lg-9 col-md-9 col-sm-12 col-xs-12 bg-overlay">
							<div class="row text-center">
								<br /> <br /> <br />
								<h1>
									Hello, I'm <b>Nanta</b>
								</h1>
								<h2>Welcome to my website.</h2>
								<br class="visible-lg visible-md" /> <br
									class="visible-lg visible-md" />
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
										<a
											href="http://linkedin.com/in/pramuditya-anantanur-013859136"><i
											class="fa fa-3x fa-linkedin"></i></a>
									</p>
								</div>
								<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
									<p class="text-center animated tada">
										<a href="http://github.com/nantaaditya"><i
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
						</div>
					</div>
				</section>
				<hr class="style15" />
				<!--CONTENT-->
				<!--ABOUT ME-->
				<div class="container" style="padding-top: 5px !important">
					<section class="content no-padding">
						<div class="row" data-aos="flip-up" data-aos-delay="200">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<div class="box">
									<div class="box box-primary">
										<div class="box-body">
											<div class="row">
												<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
													<br class="visible-lg visible-md" />
													<h1 class="text-center text-blue">
														<i class="fa fa-user-circle-o fa-2x"></i>
													</h1>
													<h2 class="text-center text-blue">
														<b><u>ABOUT ME</u></b>
													</h2>
												</div>
												<div class="col-lg-9 col-md-9 col-sm-12 col-xs-12">
													<h4 class="text-justify" style="padding: 20px">
														<br class="visible-lg visible-md" /> <br
															class="visible-lg visible-md" /> <span
															ng-bind-html="about.description"></span>
													</h4>
													<br class="visible-lg visible-md" /> <br
														class="visible-lg visible-md" />
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</section>
				</div>
				<!--IMG DIVIDER-->
				<div class="container fill">
					<section class="content no-padding" id="bg-image-1">
						<div class="row">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"></div>
						</div>
					</section>
				</div>
				<!--EDUCATION-->
				<div class="container" style="padding-top: 5px !important">
					<section class="content no-padding">
						<div class="row" data-aos="fade-down" data-aos-delay="200">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<div class="box">
									<div class="box box-primary">
										<div class="box-body">
											<div class="row">
												<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
													<br class="visible-lg visible-md" />
													<h1 class="text-center text-blue">
														<i class="fa fa-graduation-cap fa-2x"></i>
													</h1>
													<h2 class="text-center text-blue">
														<b><u>EDUCATION</u></b>
													</h2>
												</div>
												<div class="col-lg-9 col-md-9 col-sm-12 col-xs-12">
													<ul class="timeline">
														<li><i class="fa fa-clock-o bg-gray"></i></li>
														<br />
														<li ng-repeat="e in educations"><i
															class="fa fa-clock-o bg-green"></i>
															<div class="timeline-item">
																<h3 class="timeline-header text-blue">{{e.name}}</h3>
																<div class="timeline-body">
																	<p class="text-aqua">
																		{{e.year}} | <span style="color: #222">{{e.description}}</span>
																	</p>
																</div>
															</div></li>
														<li class="time-label"><span class="bg-yellow">Present</span>
														</li>
													</ul>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</section>
				</div>
				<!--IMG DIVIDER-->
				<div class="container fill">
					<section class="content no-padding" id="bg-image-1">
						<div class="row">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"></div>
						</div>
					</section>
				</div>
				<!--SKILL-->
				<div class="container" style="padding-top: 5px !important">
					<section class="content no-padding">
						<div class="row" data-aos="zoom-in-up" data-aos-delay="200">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<div class="box">
									<div class="box box-primary">
										<div class="box-body">
											<div class="row">
												<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
													<br class="visible-lg visible-md" />
													<h1 class="text-center text-blue">
														<i class="fa fa-id-card-o fa-2x"></i>
													</h1>
													<h2 class="text-center text-blue">
														<b><u>SKILLSET</u></b>
													</h2>
												</div>
												<div class="col-lg-9 col-md-9 col-sm-12 col-xs-12">
													<div class="row">
														<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12"
															ng-repeat="s in skills">
															<label class="label label-primary">{{s.name}}</label>
															<div class="progress">
																<div class="progress-bar progress-bar-aqua"
																	role="progressbar" aria-valuenow="{{s.percentage}}"
																	aria-valuemin="0" aria-valuemax="100"
																	style="width: {{s.percentage}}%">
																	<span class="sr-only">{{s.percentage}}% Complete</span>
																</div>
															</div>
														</div>

													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</section>
				</div>
				<!--IMG DIVIDER-->
				<div class="container fill">
					<section class="content no-padding" id="bg-image-1">
						<div class="row">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"></div>
						</div>
					</section>
				</div>
				<!--PROJECT-->
				<div class="container" style="padding-top: 5px !important">
					<section class="content no-padding">
						<div class="row" data-aos="fade-down" data-aos-delay="200">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<div class="box">
									<div class="box box-primary">
										<div class="box-body">
											<div class="row">
												<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
													<br class="visible-lg visible-md" />
													<h1 class="text-center text-blue">
														<i class="fa fa-desktop fa-2x"></i>
													</h1>
													<h2 class="text-center text-blue">
														<b><u>MY WORKS</u></b>
													</h2>
												</div>
												<div class="col-lg-9 col-md-9 col-sm-12 col-xs-12">
													<div class="row">

														<div
															class="col-lg-6 col-md-6 col-sm-12 col-xs-12 center-block"
															ng-repeat="p in projects">
															<div class="section-box-eleven">
																<figure>
																	<div class="text-center">
																		<a href="{{p.site}}">{{p.name}}<i
																			class="fa fa-long-arrow-right" aria-hidden="true"></i></a>
																	</div>
																</figure>
																<img ng-src="{{p.image}}" class="img-responsive img-center center-block" />
															</div>
														</div>

													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</section>
				</div>
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
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
	<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.2.0/aos.css" />
	<script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.2.0/aos.js"></script>
	<script
		src="http://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.2/modernizr.js"></script>
	<!-- Global site tag (gtag.js) - Google Analytics -->
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
    /**if ('serviceWorker' in navigator) {
      // Use the window load event to keep the page load performant
      window.addEventListener('load', () => {
        navigator.serviceWorker.register('/js/services/ws.js');
      });
    }**/
  </script>
</body>
</html>
