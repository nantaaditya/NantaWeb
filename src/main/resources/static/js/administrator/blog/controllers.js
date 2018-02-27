angular.module('blogController', []);
angular.module('blogController').controller(
        'blogCtrl',
        function($scope, LoadingFactory, CookiesFactory, CustomSessionFactory,
                SessionFactory, FileUploader, LogoutFactory,
                ChangePasswordFactory, SaveBlogFactory, GetBlogFactory,
                ToggleBlogFactory, FindBlogFactory, UpdateBlogFactory, DeleteBlogFactory) {
          // VARIABLE
          $scope.oldPassword;
          $scope.newPassword;
          $scope.blog = {};
          var uploader = $scope.uploader = new FileUploader();
          uploader.filters.push({
            name: 'imageFilter',
            fn: function(item, options) {
              var type = '|' + item.type.slice(item.type.lastIndexOf('/') + 1)
                      + '|';
              if (typeof item.type == 'undefined' || item.type == null
                      || item.type == '') {
                type = '|' + item.name.slice(item.name.lastIndexOf('.') + 1)
                        + '|';
              }

              // max item size 2097152
              if (item.size > 2097152) {
                swal('Information', 'Your file must below 2 MB', 'warning');
                return false;
              } else {
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
                } else {
                  swal('Error',
                          'File types are not allowed! Only image format.',
                          'error');
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
              getBlogFactory();
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
            window.location.href = "/login";
          }

          var usernameHandler = function() {
            $scope.username = CustomSessionFactory.get('username');
          }

          var changePasswordHandler = function() {
            $scope.oldPassword = null;
            $scope.newPassword = null;
            $('#change-password-modal').modal('hide');
          }

          var getBlogHandler = function(blogs) {
            $scope.blogs = blogs;
          }

          var saveBlogHandler = function() {
            $scope.blog = {};
            CKEDITOR.instances['text-create'].setData($scope.blog);
            uploader.clearQueue();
            getBlogFactory();
            $('#add-blog').modal('hide');
          }

          var toggleBlogHandler = function() {
            getBlogFactory();
          }

          var findBlogHandler = function(blog) {
            $scope.activeBlog = blog;
            $scope.id = blog.id;
            CKEDITOR.instances['text-edit'].setData(blog.post);
            $('#edit-blog').modal('show');
          }

          var updateBlogHandler = function() {
            $scope.activeBlog = {};
            $scope.id = null;
            CKEDITOR.instances['text-edit'].setData(null);
            $('#edit-blog').modal('hide');
          }
          
          var deleteBlogHandler = function(){
            getBlogFactory();
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

          var getBlogFactory = function() {
            LoadingFactory.increase('get-blog');
            GetBlogFactory.get({}, function(response) {
              if (response.success) {
                getBlogHandler(response.content);
              } else {
                sweetAlert("Error", response.message, "error");
              }
              LoadingFactory.decrease('get-blog');
            }, function(response) {
              LoadingFactory.decrease('get-blog');
            });
          }

          var saveBlogFactory = function(file, postDto) {
            LoadingFactory.increase('add-blog');
            SaveBlogFactory.post(file, postDto).then(function(response) {
              LoadingFactory.decrease('add-blog');
              if (response.success) {
                saveBlogHandler();
                sweetAlert("Success", response.message, "success");
              } else {
                sweetAlert("Error", response.message, "error");
              }
            }, function(response) {
              LoadingFactory.decrease('add-blog');
            });
          }

          var toggleBlogFactory = function(id, status) {
            LoadingFactory.increase('toggle-blog');
            ToggleBlogFactory.put({
              'id': id,
              'status': status
            }, function(response) {
              if (response.success) {
                toggleBlogHandler();
                sweetAlert("Success", response.message, "success");
              } else {
                sweetAlert("Error", response.message, "error");
              }
              LoadingFactory.decrease('toggle-blog');
            }, function(response) {
              LoadingFactory.decrease('toggle-blog');
            });
          }

          var findBlogFactory = function(url) {
            LoadingFactory.increase('find-blog');
            FindBlogFactory.get({
              'url': url,
            }, function(response) {
              if (response.success) {
                findBlogHandler(response.value);
              } else {
                sweetAlert("Error", response.message, "error");
              }
              LoadingFactory.decrease('find-blog');
            }, function(response) {
              LoadingFactory.decrease('find-blog');
            });
          }

          var updateBlogFactory = function() {
            LoadingFactory.increase('update-blog');
            UpdateBlogFactory.put($scope.activeBlog, function(response) {
              if (response.success) {
                updateBlogHandler();
                sweetAlert("Success", response.message, "success");
              } else {
                sweetAlert("Error", response.message, "error");
              }
              LoadingFactory.decrease('update-blog');
            }, function(response) {
              LoadingFactory.decrease('update-blog');
            });
          }

          var deleteBlogFactory = function(id) {
            LoadingFactory.increase('delete-blog');
            DeleteBlogFactory.delete({
              'id':id
            }, function(response) {
              if (response.success) {
                deleteBlogHandler();
                sweetAlert("Success", response.message, "success");
              } else {
                sweetAlert("Error", response.message, "error");
              }
              LoadingFactory.decrease('delete-blog');
            }, function(response) {
              LoadingFactory.decrease('delete-blog');
            });
          }
          
          // EVENT
          $scope.unauthenticate = function() {
            logoutFactory();
          }

          $scope.changePassword = function() {
            changePasswordFactory();
          }

          $scope.clickBrowse = function() {
            uploader.queue = [];
          }

          $scope.addBlog = function(status) {
            $scope.blog.post = CKEDITOR.instances['text-create'].getData();
            if (status == 'true') {
              $scope.blog.status = true;
              console.log($scope.blog);
              saveBlogFactory(uploader.queue[0]._file, angular
                      .copy($scope.blog));
            } else if (status == 'false') {
              $scope.blog.status = false;
              console.log($scope.blog);
              saveBlogFactory(uploader.queue[0]._file, angular
                      .copy($scope.blog));
            }
          }

          $scope.toggleBlog = function(id, status) {
            toggleBlogFactory(id, status);
          }

          $scope.open = function(url) {
            findBlogFactory(url);
          }

          $scope.update = function() {
            $scope.activeBlog.post = CKEDITOR.instances['text-edit'].getData();
            updateBlogFactory();
          }
          
          $scope.deleteBlog = function(id){
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
                deleteBlogFactory(id);                  
              } else {
                  swal("Cancelled", "Your data is safe :)", "error");
              }
          });            
          }
          // INIT
          var init = function() {
            console.log("BLOG");
            $scope.loadings = LoadingFactory;
            initHandler();
          }
          init();
        });