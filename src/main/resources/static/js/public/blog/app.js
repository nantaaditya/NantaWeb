angular.module(
        'blogApp',
        ['ngSanitize', 'requestInterceptor', 'responseInterceptor',
            'utilService', 'securityService', 'blogController', 'blogService',
            'angularUtils.directives.dirPagination']).config(
        function($httpProvider) {
          $httpProvider.interceptors.push('RequestInterceptorFactory');
          $httpProvider.interceptors.push('ResponseInterceptorFactory');
        });