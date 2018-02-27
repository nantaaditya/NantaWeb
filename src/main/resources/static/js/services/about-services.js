angular.module('aboutService', ['ngResource']);
var Context = "";
angular.module('aboutService').factory('UpdateAboutFactory',
        function($resource, RequestIdFactory) {
          return $resource(Context+'/api/about', null, {
            put: {
              method: 'PUT',
              params: {
                'requestId': RequestIdFactory.get()
              }
            }
          });
        });
angular.module('aboutService').factory('GetAboutFactory',
        function($resource, RequestIdFactory) {
          return $resource(Context+'/api/about', null, {
            get: {
              method: 'GET',
              params: {
                'requestId': RequestIdFactory.get()
              }
            }
          });
        });