angular.module(
        'pictureApp',
        ['ngSanitize', 'requestInterceptor', 'responseInterceptor',
            'utilService', 'securityService', 'pictureController',
            'pictureService']).config(function($httpProvider) {
  $httpProvider.interceptors.push('RequestInterceptorFactory');
  $httpProvider.interceptors.push('ResponseInterceptorFactory');
});