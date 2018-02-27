angular.module('skillService', ['ngResource']);
var Context = "";
angular.module('skillService').factory('SaveSkillFactory',
        function($resource, RequestIdFactory) {
          return $resource(Context + '/api/skill', null, {
            post: {
              method: 'POST',
              params: {
                'requestId': RequestIdFactory.get()
              }
            }
          });
        });
angular.module('skillService').factory('GetSkillFactory',
        function($resource, RequestIdFactory) {
          return $resource(Context + '/api/skill', null, {
            get: {
              method: 'GET',
              params: {
                'requestId': RequestIdFactory.get()
              }
            }
          });
        });
angular.module('skillService').factory('DeleteSkillFactory',
        function($resource, RequestIdFactory) {
          return $resource(Context + '/api/skill', null, {
            delete: {
              method: 'DELETE',
              params: {
                'requestId': RequestIdFactory.get()
              }
            }
          });
        });