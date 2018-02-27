angular.module(
        'homeApp',
        ['ngSanitize', 'requestInterceptor', 'responseInterceptor',
            'utilService', 'securityService', 'homeController', 'aboutService',
            'educationService', 'skillService', 'projectService']).config(
        function($httpProvider) {
          $httpProvider.interceptors.push('RequestInterceptorFactory');
          $httpProvider.interceptors.push('ResponseInterceptorFactory');
        });