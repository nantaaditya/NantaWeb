angular.module('contactController', []);
angular
        .module('contactController')
        .controller(
                'contactCtrl',
                function($scope, LoadingFactory, CookiesFactory,
                        CustomSessionFactory, SessionFactory,
                        SaveContactFactory) {
                  // VARIABLE
                  $scope.contact = {};
                  $scope.profile = "production";

                  // HANDLER
                  var initHandler = function() {
                    if ($scope.profile == "production") {
                      $scope.captchaPublicKey = "6LeO4UYUAAAAALeGqo6BbKWPkMkAVDmVltXJgsXj";
                    } else if ($scope.profile == "development") {
                      $scope.captchaPublicKey = "6Len4UYUAAAAAGj6vm-Wgnrt5Q_78rVBMQu14JrL";
                    }
                  }

                  var isEmpty = function(value) {
                    return typeof value === 'undefined' || value === null
                            || value === '';
                  }

                  // FACTORY
                  var saveContactFactory = function() {
                    LoadingFactory.increase('save-message');
                    SaveContactFactory.post($scope.contact, function(response) {
                      if (response.success) {
                        $.notify(response.message, "success");
                        $scope.contact = {};
                        grecaptcha.reset();
                      } else {
                        $.notify(response.message, "warn");
                      }
                      LoadingFactory.decrease('save-message');
                    }, function(response) {
                      LoadingFactory.decrease('save-message');
                    });
                  }
                  // EVENT
                  $scope.saveMessage = function() {
                    $scope.contact.captchaResponse = grecaptcha.getResponse();
                    $scope.contact.status = "unread";
                    console.log($scope.contact);
                    saveContactFactory();
                  }
                  // INIT
                  var init = function() {
                    console.log("ABOUT");
                    $scope.loadings = LoadingFactory;
                    initHandler();
                  }
                  init();
                });