angular.module('blogService', ['ngResource']);
var Context = "";
angular.module('blogService').factory('SaveBlogFactory', function($http, RequestIdFactory) {
  return {
    post: function(blogImage, postDto) {
      var formData = new FormData();
      formData.append('file', blogImage);
      formData.append('postDto', new Blob([angular.toJson(postDto)], {
        type: 'application/json'
      }));
      return $http.post(Context+'/api/blog?requestId='+RequestIdFactory.get(), formData, {
        transformRequest: angular.identity,
        headers: {
          'Content-Type': undefined
        }
      }).then(function(response) {
        return response.data;
      }, function(response) {
        return response;
      });
    }
  }
});
angular.module('blogService').factory('GetBlogFactory',
        function($resource, RequestIdFactory) {
          return $resource(Context + '/api/blog', null, {
            get: {
              method: 'GET',
              params: {
                'requestId': RequestIdFactory.get()
              }
            }
          });
        });
angular.module('blogService').factory('ToggleBlogFactory',
        function($resource, RequestIdFactory) {
          return $resource(Context + '/api/blog/:id/:status', {id:'@id',status:'@status'}, {
            put: {
              method: 'PUT',
              params: {
                'requestId': RequestIdFactory.get()                
              }
            }
          });
        });
angular.module('blogService').factory('FindBlogFactory',
        function($resource, RequestIdFactory) {
          return $resource(Context + '/api/blog/:url', {url:'@url'}, {
            get: {
              method: 'GET',
              params: {
                'requestId': RequestIdFactory.get()                
              }
            }
          });
        });

angular.module('blogService').factory('UpdateBlogFactory',
        function($resource, RequestIdFactory) {
          return $resource(Context + '/api/blog', null, {
            put: {
              method: 'PUT',
              params: {
                'requestId': RequestIdFactory.get()                
              }
            }
          });
        });

angular.module('blogService').factory('DeleteBlogFactory',
        function($resource, RequestIdFactory) {
          return $resource(Context + '/api/blog/:id', {id:'@id'}, {
            delete: {
              method: 'DELETE',
              params: {
                'requestId': RequestIdFactory.get()                
              }
            }
          });
        });
angular.module('blogService').factory('GetActiveBlogFactory',
        function($resource, RequestIdFactory) {
          return $resource(Context + '/api/blog/active', null, {
            get: {
              method: 'GET',
              params: {
                'requestId': RequestIdFactory.get()
              }
            }
          });
        });