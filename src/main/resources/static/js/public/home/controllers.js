angular.module('homeController', []);
angular.module('homeController').controller(
        'homeCtrl',
        function($scope, $interval, LoadingFactory, CookiesFactory, CustomSessionFactory,
                SessionFactory, GetAboutFactory, GetEducationFactory,
                GetProjectFactory, GetSkillFactory) {
          // VARIABLE

          // HANDLER
          var initHandler = function() {
            getAboutFactory();
            getEducationFactory();
            getSkillFactory();
            getProjectFactory();
          }

          var isEmpty = function(value) {
            return typeof value === 'undefined' || value === null
                    || value === '';
          }

          var getAboutHandler = function(about) {
            $scope.about = about;
          }
          var getEducationHandler = function(educations) {
            $scope.educations = educations;
          }
          var getSkillHandler = function(skills) {
            $scope.skills = skills;
          }
          var getProjectHandler = function(projects) {
            $scope.projects = projects;
          }
          
          // FACTORY
          var getAboutFactory = function() {
            LoadingFactory.increase('get-about');
            GetAboutFactory.get({}, function(response) {
              if (response.success) {
                getAboutHandler(response.value);
              } else {
                sweetAlert("Error", response.message, "error");
              }
              LoadingFactory.decrease('get-about');
            }, function(response) {
              LoadingFactory.decrease('get-about');
            });
          }

          var getEducationFactory = function() {
            LoadingFactory.increase('get-education');
            GetEducationFactory.get({}, function(response) {
              if (response.success) {
                getEducationHandler(response.content);
              } else {
                sweetAlert("Error", response.message, "error");
              }
              LoadingFactory.decrease('get-education');
            }, function(response) {
              LoadingFactory.decrease('get-education');
            });
          }
          var getSkillFactory = function() {
            LoadingFactory.increase('get-skill');
            GetSkillFactory.get({}, function(response) {
              if (response.success) {
                getSkillHandler(response.content);
              } else {
                sweetAlert("Error", response.message, "error");
              }
              LoadingFactory.decrease('get-skill');
            }, function(response) {
              LoadingFactory.decrease('get-skill');
            });
          }
          var getProjectFactory = function() {
            LoadingFactory.increase('get-project');
            GetProjectFactory.get({}, function(response) {
              if (response.success) {
                getProjectHandler(response.content);
              } else {
                sweetAlert("Error", response.message, "error");
              }
              LoadingFactory.decrease('get-project');
            }, function(response) {
              LoadingFactory.decrease('get-project');
            });
          }
          
          // EVENT
          var tick = function() {
            $scope.clock = Date.now();
            $scope.date = new Date();
          }          
          
          // INIT
          var init = function() {
            console.log("HOME");
            $scope.loadings = LoadingFactory;
            initHandler();
            tick();
            $interval(tick, 1000);
          }
          init();
        });