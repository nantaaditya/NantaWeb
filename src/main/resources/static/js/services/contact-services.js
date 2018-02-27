angular.module('contactService', ['ngResource']);
var Context = "";
angular.module('contactService').factory('SaveContactFactory',
        function($resource, RequestIdFactory) {
          return $resource(Context + '/api/contact', null, {
            post: {
              method: 'POST',
              params: {
                'requestId': RequestIdFactory.get()
              }
            }
          });
        });

angular.module('contactService').factory('GetContactFactory',
        function($resource, RequestIdFactory) {
          return $resource(Context + '/api/contact', null, {
            get: {
              method: 'GET',
              params: {
                'requestId': RequestIdFactory.get()
              }
            }
          });
        });
angular.module('contactService').factory('FindContactFactory',
        function($resource, RequestIdFactory) {
          return $resource(Context + '/api/contact/:id', {
            id: '@id'
          }, {
            get: {
              method: 'GET',
              params: {
                'requestId': RequestIdFactory.get()
              }
            }
          });
        });
angular.module('contactService').factory('ReplyContactFactory',
        function($resource, RequestIdFactory) {
          return $resource(Context + '/api/contact/reply', null, {
            post: {
              method: 'POST',
              params: {
                'requestId': RequestIdFactory.get()
              }
            }
          });
        });
