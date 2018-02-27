angular.module('blogController', []);
angular.module('blogController').controller(
        'blogCtrl',
        function($scope, LoadingFactory, CookiesFactory, CustomSessionFactory,
                SessionFactory, GetActiveBlogFactory) {
          // VARIABLE

          // HANDLER
          var initHandler = function() {
            getActiveBlogFactory();
          }

          var isEmpty = function(value) {
            return typeof value === 'undefined' || value === null
                    || value === '';
          }

          var getActiveBlogHandler = function(blogs) {
            $scope.blogs = blogs;
          }

          // FACTORY
          var getActiveBlogFactory = function() {
            LoadingFactory.increase('get-blog');
            GetActiveBlogFactory.get({}, function(response) {
              if (response.success) {
                getActiveBlogHandler(response.content);
              } else {
                swal("Success", response.message, "success");
              }
              LoadingFactory.decrease('get-blog');
            }, function(response) {
              LoadingFactory.decrease('get-blog');
            });
          }

          // EVENT
          $scope.open = function(url) {
            window.location = '/blog/' + url;
          }

          // INIT
          var init = function() {
            console.log("BLOG");
            $scope.loadings = LoadingFactory;
            initHandler();
          }
          init();
        });