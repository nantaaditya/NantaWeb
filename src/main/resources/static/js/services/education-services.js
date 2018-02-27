angular.module('educationService', ['ngResource']);
var Context = "";
angular.module('educationService').factory('SaveEducationFactory',
        function($resource, RequestIdFactory) {
          return $resource(Context + '/api/education', null, {
            post: {
              method: 'POST',
              params: {
                'requestId': RequestIdFactory.get()
              }
            }
          });
        });
angular.module('educationService').factory('GetEducationFactory',
        function($resource, RequestIdFactory) {
          return $resource(Context + '/api/education', null, {
            get: {
              method: 'GET',
              params: {
                'requestId': RequestIdFactory.get()
              }
            }
          });
        });
angular.module('educationService').factory('DeleteEducationFactory',
        function($resource, RequestIdFactory) {
          return $resource(Context + '/api/education', null, {
            delete: {
              method: 'DELETE',
              params: {
                'requestId': RequestIdFactory.get(),
                'id':'@id'
              }
            }
          });
        });