angular.module('pictureController', []);
angular.module('pictureController').controller(
        'pictureCtrl',
        function($scope, LoadingFactory, CookiesFactory, CustomSessionFactory,
                SessionFactory, FileUploader, LogoutFactory, ChangePasswordFactory,
                SavePictureFactory, GetPictureFactory, DeletePictureFactory,
                TogglePictureFactory) {
          // VARIABLE
          $scope.oldPassword;
          $scope.newPassword;          
          $scope.picture = {};
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
              getPictureFactory();
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
          
          var getPictureHandler = function(pictures) {
            $scope.pictures = pictures;            
          }
          
          var savePictureHandler = function() {            
            $scope.picture= {};
            uploader.clearQueue();
            getPictureFactory();
            $('#add-picture').modal('hide');
          }
          
          var deletePictureHandler = function() {                        
            getPictureFactory();            
          }
          
          var togglePictureHandler = function() {                        
            getPictureFactory();            
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
          
          var getPictureFactory = function() {
            LoadingFactory.increase('get-picture');
            GetPictureFactory.get({}, function(response) {
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
                    
          var savePictureFactory = function(file, pictureDto) {
            LoadingFactory.increase('add-picture');
            SavePictureFactory.post(file, pictureDto).then(function(response) {
              LoadingFactory.decrease('add-picture');
              if (response.success) {
                savepictureHandler();
              } else {
                sweetAlert("Error", response.message, "error");
              }        
            }, function(response) {
              LoadingFactory.decrease('add-picture');
            });
          }

          var deletePictureFactory = function(id) {
            LoadingFactory.increase('delete-picture');
            DeletePictureFactory.delete({
              'id':id,
              'path':'/gallery/'
            }, function(response) {
              if (response.success) {
                deletePictureHandler();
                sweetAlert("Success", response.message, "success");
              } else {
                sweetAlert("Error", response.message, "error");
              }
              LoadingFactory.decrease('delete-picture');
            }, function(response) {
              LoadingFactory.decrease('delete-picture');
            });
          }
          
          var togglePictureFactory = function(id,status) {
            LoadingFactory.increase('toggle-picture');
            TogglePictureFactory.put({
              'id':id,
              'status':status
            }, function(response) {
              if (response.success) {
                togglePictureHandler();
                sweetAlert("Success", response.message, "success");
              } else {
                sweetAlert("Error", response.message, "error");
              }
              LoadingFactory.decrease('toggle-picture');
            }, function(response) {
              LoadingFactory.decrease('toggle-picture');
            });
          }
          
          // EVENT
          $scope.unauthenticate = function() {
            logoutFactory();
          }

          $scope.changePassword = function() {
            changePasswordFactory();
          }

          $scope.addPicture= function(status){
            console.log(status);
            if(status=='true'){
              $scope.picture.status = true;
              savePictureFactory(uploader.queue[0]._file, angular.copy($scope.picture));
            }else if(status=='false'){
              $scope.picture.status = false;
              savePictureFactory(uploader.queue[0]._file, angular.copy($scope.picture));
            }            
          }
          $scope.deletePicture= function(id){
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
                  deletePictureFactory(id);                  
              } else {
                  swal("Cancelled", "Your data is safe :)", "error");
              }
          });
          }
          
          $scope.togglePicture= function(id, status){            
            togglePictureFactory(id, status);
          }
          
          $scope.clickBrowse = function() {
            uploader.queue = [];
          }
          // INIT
          var init = function() {
            console.log("DASHBOARD");
            $scope.loadings = LoadingFactory;
            initHandler();
          }
          init();
        });