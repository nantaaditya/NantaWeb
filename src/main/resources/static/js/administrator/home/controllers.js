angular.module('homeController', []);
angular.module('homeController').controller(
        'homeCtrl',
        function($scope, LoadingFactory, CookiesFactory, CustomSessionFactory,
                SessionFactory, FileUploader, LogoutFactory, ChangePasswordFactory,
                UpdateAboutFactory, GetAboutFactory, SaveEducationFactory,
                GetEducationFactory, DeleteEducationFactory,
                SaveProjectFactory, GetProjectFactory, DeleteProjectFactory,
                SaveSkillFactory, GetSkillFactory, DeleteSkillFactory) {

          // VARIABLE
          $scope.oldPassword;
          $scope.newPassword;
          $scope.education = {};
          $scope.skill = {};
          $scope.project = {};
          var uploader = $scope.uploader = new FileUploader();
          uploader.filters.push({
            name: 'imageFilter',
            fn: function(item, options) {
              var type = '|' + item.type.slice(item.type.lastIndexOf('/') + 1) + '|';
              if (typeof item.type == 'undefined' || item.type == null || item.type == '') {
                type = '|' + item.name.slice(item.name.lastIndexOf('.') + 1) + '|';                
              }
              
              // max item size 2097152
              if(item.size > 2097152) {
                swal('Information', 'Your file must below 2 MB', 'warning');
                return false;
              } else{
                if ('|jpeg|'.indexOf(type) !== -1) {
                  return true;
                } else if ('|jpg|'.indexOf(type) !== -1) {
                  return true;
                } else if ('|png|'.indexOf(type) !== -1) {
                  return true;
                } else if ('|gif|'.indexOf(type) !== -1) {
                  return true;
                } else if ('|bmp|'.indexOf(type) !== -1) {
                  return true;
                }else {
                  swal('Error', 'File types are not allowed! Only image format.', 'error');
                  return false;
                }
              }                 
            }
          });

          // HANDLER
          var initHandler = function() {
            if (isEmpty(SessionFactory.token())) {
              window.location = '/login';
            } else {
              usernameHandler();
              getAboutFactory();
              getEducationFactory();
              getSkillFactory();
              getProjectFactory();
            }
          }

          var isEmpty = function(value) {
            return typeof value === 'undefined' || value === null
                    || value === '';
          }

          var logoutHandler = function() {
            CookiesFactory.remove('username');
            SessionFactory.remove();
            CustomSessionFactory.remove('username');
            window.location.href = "/Nanta/login";
          }

          var usernameHandler = function() {
            $scope.username = CustomSessionFactory.get('username');
          }

          var changePasswordHandler = function() {
            $scope.oldPassword = null;
            $scope.newPassword = null;
            $('#change-password-modal').modal('hide');
          }

          var getAboutHandler = function(about) {
            $scope.about = about;
          }

          var updateAboutHandler = function() {
            getAboutFactory();
            $('#edit-about').modal('hide');
          }

          var getEducationHandler = function(educations) {
            $scope.educations = educations;            
          }

          var saveEducationHandler = function() {
            getEducationFactory();
            $scope.education = {};
            $('#add-education').modal('hide');
          }
          
          var deleteEducationHandler = function(){
            getEducationFactory();
          }

          var getSkillHandler = function(skills) {
            $scope.skills = skills;            
          }

          var saveSkillHandler = function() {
            getSkillFactory();
            $scope.skill= {};
            $('#add-skill').modal('hide');
          }
          
          var deleteSkillHandler = function(){
            getSkillFactory();
          }
          
          var getProjectHandler = function(projects) {
            $scope.projects = projects;            
          }

          var saveProjectHandler = function() {            
            $scope.project= {};
            uploader.clearQueue();
            getProjectFactory();
            $('#add-project').modal('hide');
          }
          
          var deleteProjectHandler = function(){
            getProjectFactory();
          }
          
          // FACTORY
          var logoutFactory = function() {
            LogoutFactory.get({}, function(response) {
              if (response.success) {
                logoutHandler();
              } else {
                sweetAlert("Error", response.message, "error");
              }
            }, function(response) {
            });
          }

          var changePasswordFactory = function() {
            LoadingFactory.increase('change-password');
            ChangePasswordFactory.put({
              'username': $scope.username,
              'oldPassword': $scope.oldPassword,
              'newPassword': $scope.newPassword
            }, function(response) {
              if (response.success) {
                changePasswordHandler();
                sweetAlert("Success", response.message, "success");
              } else {
                sweetAlert("Error", response.message, "error");
              }
              LoadingFactory.decrease('change-password');
            }, function(response) {
              LoadingFactory.decrease('change-password');
            });
          }

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

          var updateAboutFactory = function() {
            LoadingFactory.increase('update-about');
            UpdateAboutFactory.put({
              'description': $scope.about.description
            }, function(response) {
              if (response.success) {
                updateAboutHandler();
                sweetAlert("Success", response.message, "success");
              } else {
                sweetAlert("Error", response.message, "error");
              }
              LoadingFactory.decrease('update-about');
            }, function(response) {
              LoadingFactory.decrease('update-about');
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

          var saveEducationFactory = function() {
            LoadingFactory.increase('add-education');
            SaveEducationFactory.post({
              'name': $scope.education.name,
              'year': $scope.education.year,
              'description': $scope.education.description
            }, function(response) {
              if (response.success) {
                saveEducationHandler();
                sweetAlert("Success", response.message, "success");
              } else {
                sweetAlert("Error", response.message, "error");
              }
              LoadingFactory.decrease('add-education');
            }, function(response) {
              LoadingFactory.decrease('add-education');
            });
          }

          var deleteEducationFactory = function(id) {
            LoadingFactory.increase('delete-education');
            DeleteEducationFactory.delete({
              'id':id
            }, function(response) {
              if (response.success) {
                deleteEducationHandler();
                sweetAlert("Success", response.message, "success");
              } else {
                sweetAlert("Error", response.message, "error");
              }
              LoadingFactory.decrease('delete-education');
            }, function(response) {
              LoadingFactory.decrease('delete-education');
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

          var saveSkillFactory = function() {
            LoadingFactory.increase('add-skill');
            SaveSkillFactory.post({
              'name': $scope.skill.name,
              'percentage': $scope.skill.percentage
            }, function(response) {
              if (response.success) {
                saveSkillHandler();
                sweetAlert("Success", response.message, "success");
              } else {
                sweetAlert("Error", response.message, "error");
              }
              LoadingFactory.decrease('add-skill');
            }, function(response) {
              LoadingFactory.decrease('add-skill');
            });
          }

          var deleteSkillFactory = function(id) {
            LoadingFactory.increase('delete-skill');
            DeleteSkillFactory.delete({
              'id':id
            }, function(response) {
              if (response.success) {
                deleteSkillHandler();
                sweetAlert("Success", response.message, "success");
              } else {
                sweetAlert("Error", response.message, "error");
              }
              LoadingFactory.decrease('delete-skill');
            }, function(response) {
              LoadingFactory.decrease('delete-skill');
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

          var saveProjectFactory = function(file, projectDto) {
            LoadingFactory.increase('add-project');
            SaveProjectFactory.post(file, projectDto).then(function(response) {
              LoadingFactory.decrease('add-project');
              if (response.success) {
                saveProjectHandler();
              } else {
                sweetAlert("Error", response.message, "error");
              }        
            }, function(response) {
              LoadingFactory.decrease('add-project');
            });
          }

          var deleteProjectFactory = function(id) {
            LoadingFactory.increase('delete-skill');
            DeleteProjectFactory.delete({
              'id':id,
              'path':'/web/'
            }, function(response) {
              if (response.success) {
                deleteProjectHandler();
                sweetAlert("Success", response.message, "success");
              } else {
                sweetAlert("Error", response.message, "error");
              }
              LoadingFactory.decrease('delete-skill');
            }, function(response) {
              LoadingFactory.decrease('delete-skill');
            });
          }
          
          // EVENT
          $scope.unauthenticate = function() {
            logoutFactory();
          }

          $scope.changePassword = function() {
            changePasswordFactory();
          }

          $scope.updateAbout = function() {
            updateAboutFactory();
          }
          
          $scope.addEducation = function(){
            saveEducationFactory();
          }
          
          $scope.deleteEducation = function(id){
            swal({
              title: "Are you sure?",              
              type: "warning",
              showCancelButton: true,
              confirmButtonColor: '#DD6B55',
              confirmButtonText: 'Yes, I am sure!',
              cancelButtonText: "No, cancel it!",
              closeOnConfirm: false,
              closeOnCancel: false
          },
          function(isConfirm) {
              if (isConfirm) {
                  deleteEducationFactory(id);                  
              } else {
                  swal("Cancelled", "Your data is safe :)", "error");
              }
          });
          }
          
          $scope.addSkill = function(){
            saveSkillFactory();
          }
          
          $scope.deleteSkill= function(id){
            swal({
              title: "Are you sure?",              
              type: "warning",
              showCancelButton: true,
              confirmButtonColor: '#DD6B55',
              confirmButtonText: 'Yes, I am sure!',
              cancelButtonText: "No, cancel it!",
              closeOnConfirm: false,
              closeOnCancel: false
          },
          function(isConfirm) {
              if (isConfirm) {
                  deleteSkillFactory(id);                  
              } else {
                  swal("Cancelled", "Your data is safe :)", "error");
              }
          });
          }
          
          $scope.clickBrowse = function() {
            uploader.queue = [];
          }
          
          $scope.addProject = function(){
            saveProjectFactory(uploader.queue[0]._file, angular.copy($scope.project));
          }
          $scope.deleteProject= function(id){
            swal({
              title: "Are you sure?",              
              type: "warning",
              showCancelButton: true,
              confirmButtonColor: '#DD6B55',
              confirmButtonText: 'Yes, I am sure!',
              cancelButtonText: "No, cancel it!",
              closeOnConfirm: false,
              closeOnCancel: false
          },
          function(isConfirm) {
              if (isConfirm) {
                  deleteProjectFactory(id);                  
              } else {
                  swal("Cancelled", "Your data is safe :)", "error");
              }
          });
          }
          // INIT
          var init = function() {
            console.log("DASHBOARD");
            $scope.loadings = LoadingFactory;
            initHandler();
          }
          init();
        });