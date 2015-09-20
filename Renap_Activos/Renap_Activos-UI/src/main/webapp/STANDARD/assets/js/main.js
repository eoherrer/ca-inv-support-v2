
var app = angular.module('clipApp', ['clip-two']);
app.run(['$rootScope', '$state', '$stateParams',
function ($rootScope, $state, $stateParams) {

    // Attach Fastclick for eliminating the 300ms delay between a physical tap and the firing of a click event on mobile browsers
    FastClick.attach(document.body);

    // Set some reference to access them from any scope
    $rootScope.$state = $state;
    $rootScope.$stateParams = $stateParams;

    // GLOBAL APP SCOPE
    // set below basic information
    $rootScope.app = {
        name: 'Clip-Two', // name of your project
        author: 'ClipTheme', // author's name or company name
        description: 'Angular Bootstrap Admin Template', // brief description
        version: '1.0', // current version
        year: ((new Date()).getFullYear()), // automatic current year (for copyright information)
        isMobile: (function () {// true if the browser is a mobile device
            var check = false;
            if (/Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(navigator.userAgent)) {
                check = true;
            };
            return check;
        })(),
        layout: {
            isNavbarFixed: true, //true if you want to initialize the template with fixed header
            isSidebarFixed: true, // true if you want to initialize the template with fixed sidebar
            isSidebarClosed: false, // true if you want to initialize the template with closed sidebar
            isFooterFixed: false, // true if you want to initialize the template with fixed footer
            theme: 'theme-4', // indicate the theme chosen for your project
            logo: 'assets/images/logo.png', // relative path of the project logo
        }
    };
    $rootScope.user = {
        name: 'Peter',
        job: 'ng-Dev',
        picture: 'app/img/user/02.jpg'
    };
}]);
// translate config
app.config(['$translateProvider',
function ($translateProvider) {

    // prefix and suffix information  is required to specify a pattern
    // You can simply use the static-files loader with this pattern:
    $translateProvider.useStaticFilesLoader({
        prefix: 'assets/i18n/',
        suffix: '.json'
    });

    // Since you've now registered more then one translation table, angular-translate has to know which one to use.
    // This is where preferredLanguage(langKey) comes in.
    $translateProvider.preferredLanguage('en');

    // Store the language in the local storage
    $translateProvider.useLocalStorage();

}]);
// Angular-Loading-Bar
// configuration
app.config(['cfpLoadingBarProvider',
function (cfpLoadingBarProvider) {
    cfpLoadingBarProvider.includeBar = true;
    cfpLoadingBarProvider.includeSpinner = false;

}]);

app.service("daoService", DaoService);
app.service("switchRenap", SwitchRenap);


//app.factory('Departamento',function($http,$q){
////    var deferred = $q.defer();
//    var Departamento = function(data) {
//        angular.extend(this, data);
//    }
//    
//    // a static method to retrieve by ID
//  Departamento.get = function(id) {
//        $http.post('http://localhost:8081/RenapActivosWebClipTwo/serviceSwitch', '').then(function (result) {
////              return new Departamento(result.data);
//        });
//  };
//  Departamento.getAll = function() {
//      
////      beforecreate: function(node,targetNode,type,to) {
////            jQuery.ajax({
////                 url:    'http://localhost:8081/RenapActivosWebClipTwo/serviceSwitch' 
////                          ,
////                 success: function(result) {
////                              if(result.isOk == false)
//////                                  alert(result.message);
////                                  alert('RESULT JQUERY '+result.data);
////                          },
////                 async:   false
////            });          
////        }
//      
//      
//      $http.post('http://localhost:8081/RenapActivosWebClipTwo/serviceSwitch', '').then(function (result) {
////        $resource.post('http://localhost:8081/RenapActivosWebClipTwo/serviceSwitch', '').then(function (result) {
//            alert('FACTORY 11'+JSON.stringify(result.data));
////            deferred.resolve(JSON.stringify(result.data));
//              return new Departamento(result.data);
//        });
//        
//        
//        //  
////  Departamento.getAll = function() {
////        $http.post('http://localhost:8081/RenapActivosWebClipTwo/serviceSwitch', '').then(function (result) {
////            alert('FACTORY '+JSON.stringify(result.data));
//////            deferred.resolve(JSON.stringify(result.data));
////              return new Departamento(result.data);
////        });
//        
//          
////      return deferred.promise;
//  };
//
//  // an instance method to create a new Book
////  Departamento.prototype.create = function() {
////    var book = this;
////    return $http.post('/Book/', book).then(function(response) {
////      book.id = response.data.id;
////      return book;
////    });
////  }
//
//  return Departamento;
//    
////        var getD = function() {
////          return $http.post('http://localhost:8081/RenapActivosWebClipTwo/serviceSwitch', json).then(function (result) {
////              alert(JSON.stringify(result.data));
////              return result.data;
////          });
////        };
////        
////      return { getD: getD };  
//        
//    });

//app.factory("Departamentos",
//            function($http){$http.post('http://localhost:8081/RenapActivosWebClipTwo/serviceSwitch', json).
//                then(function (response) {
//                  alert('RESPONSE'+JSON.stringify(response.data));
//                  return JSON.stringify(response.data);
//                }, function (response) {
//                    // called asynchronously if an error occurs
//                    // or server returns response with an error status.
//                    alert('ERROR IN SWITCH SERVICE');
//                })
//            }
//        );

//var servicesModule = angular.module('servicesModule',[]);

//app.factory('Product', ['$resource', 'API',
//    function ($resource, API) {
//        var url = API.URL + 'product/:pId';
//        return $resource(url,
//            {method: "@method"},
//            {
//                get:{method: 'GET'},
//                findAll: {method: 'GET', params: {}, isArray: true}
//            }
//        );
//    }
//]);