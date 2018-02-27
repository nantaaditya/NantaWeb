angular.module(
        'contactApp',
        ['ngSanitize', 'requestInterceptor', 'responseInterceptor',
            'utilService', 'securityService', 'contactController',
            'contactService']).config(function($httpProvider) {
  $httpProvider.interceptors.push('RequestInterceptorFactory');
  $httpProvider.interceptors.push('ResponseInterceptorFactory');
});