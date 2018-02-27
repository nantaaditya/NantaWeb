angular.module('loginService', ['ngResource']);
var Context = "";
angular.module('loginService').factory('LoginFactory',
        function($resource, RequestIdFactory) {
          return $resource(Context+'/api/login', null, {
            post: {
              method: 'POST',
              params: {
                'requestId': RequestIdFactory.get()
              }
            }
          });
        });
angular.module('loginService').factory('LogoutFactory',
        function($resource, RequestIdFactory) {
          return $resource(Context+'/api/logout', null, {
            get: {
              method: 'GET',
              params: {
                'requestId': RequestIdFactory.get()
              }
            }
          });
        });
angular.module('loginService').factory('ChangePasswordFactory',
        function($resource, RequestIdFactory) {
          return $resource(Context+'/api/change-password', null, {
            put: {
              method: 'POST',
              params: {
                'requestId': RequestIdFactory.get()
              }
            }
          });
        });