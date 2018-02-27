angular.module('projectService', ['ngResource']);
var Context = "";
angular.module('projectService').factory('SaveProjectFactory', function($http, RequestIdFactory) {
  return {
    post: function(projectImage, projectDto) {
      var formData = new FormData();
      formData.append('file', projectImage);
      formData.append('projectDto', new Blob([angular.toJson(projectDto)], {
        type: 'application/json'
      }));
      return $http.post(Context+'/api/project?requestId='+RequestIdFactory.get(), formData, {
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

angular.module('projectService').factory('GetProjectFactory',
        function($resource, RequestIdFactory) {
          return $resource(Context + '/api/project', null, {
            get: {
              method: 'GET',
              params: {
                'requestId': RequestIdFactory.get()
              }
            }
          });
        });
angular.module('projectService').factory('DeleteProjectFactory',
        function($resource, RequestIdFactory) {
          return $resource(Context + '/api/project', null, {
            delete: {
              method: 'DELETE',
              params: {
                'requestId': RequestIdFactory.get(),
                'path':'@path'
              }
            }
          });
        });