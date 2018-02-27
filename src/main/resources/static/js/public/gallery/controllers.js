angular.module('pictureController', []);
angular.module('pictureController').controller(
        'pictureCtrl',
        function($scope, LoadingFactory, CookiesFactory, CustomSessionFactory,
                SessionFactory, GetPictureActiveFactory) {
          // VARIABLE

          // HANDLER
          var initHandler = function() {
            getPictureFactory();
          }

          var isEmpty = function(value) {
            return typeof value === 'undefined' || value === null
                    || value === '';
          }

          var getPictureHandler = function(pictures) {
            $scope.pictures = pictures;
          }

          // FACTORY
          var getPictureFactory = function() {
            LoadingFactory.increase('get-picture');
            GetPictureActiveFactory.get({}, function(response) {
              if (response.success) {
                getPictureHandler(response.content);
              } else {
                sweetAlert("Error", response.message, "error");
              }
              LoadingFactory.decrease('get-picture');
            }, function(response) {
              LoadingFactory.decrease('get-picture');
            });
          }
          // EVENT

          // INIT
          var init = function() {
            console.log("GALLERY");
            $scope.loadings = LoadingFactory;
            initHandler();
          }
          init();
        });