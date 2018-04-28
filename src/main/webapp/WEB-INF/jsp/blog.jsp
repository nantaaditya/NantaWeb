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
	src="https://cdnjs.cloudflare.com/ajax/libs/angular-i18n/1.6.6/angular-locale_id-id.js  "></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/angular-sanitize/1.5.6/angular-sanitize.js"></script>
<script src="/js/interceptor/request-interceptor.js"></script>
<script src="/js/interceptor/response-interceptor.js"></script>
<script src="/js/util/util-service.js"></script>
<script src="/js/security/security-service.js"></script>
<script src="/js/services/blog-services.js"></script>
<script src="/js/services/dirPagination.js"></script>
<script src="/js/public/blog/controllers.js"></script>
<script src="/js/public/blog/app.js"></script>
<script async
	src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
<script>
  (adsbygoogle = window.adsbygoogle || []).push({
    google_ad_client: "ca-pub-6542581225360208",
    enable_page_level_ads: true
  });
</script>
</head>

<body class="hold-transition skin-blue-light layout-top-nav fixed"
	ng-app="blogApp" ng-controller="blogCtrl" id="fb-root">
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
							<div class="card hovercard">
								<div class="cardheader"></div>
								<div class="avatar">
									<img alt="" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQoTSPfa412HXD6SIeXFsP7JpnxKCn7eHeEmJI6kwXOMVeghvJj">
								</div>
								<div class="info">
									<div class="title">
										<a target="_blank" href="/">Nanta Aditya</a>
									</div>
									<div class="desc">Get into my brain.</div>
								</div>
								<div class="bottom">
									<div class="row">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<div class="input-group">
												<input type="text" class="form-control" placeholder="search"
													ng-model="searchKeyword" /> <span
													class="input-group-addon"><i class="fa fa-search"></i></span>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!--CONTENT-->
					<div class="row">
						<div class="col-lg-12 col-md-12 col-sm-12">
							<div class="row">
								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
									ng-show="blogs.length<=0">
									<h3 class="text-center text-blue">Empty Post</h3>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12"
									data-aos="fade-down" data-aos-delay="1000"
									dir-paginate="b in blogs| filter:searchKeyword | itemsPerPage: '10'"
									ng-show="blogs.length>0">

									<div class="box" style="background: inherit">
										<div class="box-body no-padding" style="background: #03a9f4">
											<img class="img-responsive bg-image center-block"
												ng-src="{{b.image}}" style="height: 200px;" />
										</div>
										<div class="box-footer post-bottom">
											<div class="row">
												<div class="col-lg-8 ol-md-8 col-sm-12 col-xs-12">
													<h3 class="text-blue text-justify" style="cursor: pointer"
														ng-click="open(b.url)">{{b.title}}</h3>
												</div>
											</div>
											<div class="text-right">
												<div class="btn btn-social-icon btn-facebook"
													data-href="{{b.url}}" data-mobile-iframe="true">
													<a target="_blank"
														href="https://www.facebook.com/sharer/sharer.php?u=http://www.nantaaditya.com/blog/{{b.url}}&amp;src=sdkpreparse"
														class="fb-xfbml-parse-ignore"><i
														class="fa fa-facebook"></i></a>
												</div>
												<a class="btn btn-primary" ng-click="open(b.url)">Read
													more &ensp;<i class="fa fa-chevron-circle-right"></i>
												</a>
											</div>
										</div>
									</div>

								</div>

							</div>

							<div class="pull-right">
								<dir-pagination-controls max-size="5" direction-links="true"
									boundary-links="true"></dir-pagination-controls>
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
		src="http://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.2/modernizr.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
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

    (function(d, s, id) {
      var js, fjs = d.getElementsByTagName(s)[0];
      if (d.getElementById(id)) return;
      js = d.createElement(s);
      js.id = id;
      js.src = 'https://connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.12';
      fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));

    window.dataLayer = window.dataLayer || [];
    function gtag() {
      dataLayer.push(arguments);
    }
    gtag('js', new Date());

    gtag('config', 'UA-114339618-1');
  </script>
</body>

</html>
