angular.module(
        'pictureApp',
        ['requestInterceptor', 'responseInterceptor', 'utilService',
            'securityService', 'pictureController', 'loginService',
            'pictureService', 'angularUtils.directives.dirPagination',
            'angularFileUpload']).config(function($httpProvider) {
  $httpProvider.interceptors.push('RequestInterceptorFactory');
  $httpProvider.interceptors.push('ResponseInterceptorFactory');
});