/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function DaoService() {
    this.save = function (json, $http) {
//        $http({ method: 'GET', url: 'http://localhost:8081/RenapActivosWeb/service' }).
//                success(function (data, status, headers, config) {
//                    alert('SUCCESS SAVE'+data);
//                    alert('SUCCESS SAVE'+status);
//                }).
//                error(function (data, status, headers, config) {
//                    alert('ERROR SAVE'+status);
//                    alert('ERROR SAVE'+data);
//                });
        // Simple POST request example (passing data) :
        
        
        var pos = {
            method: 'POST',
            url: 'http://localhost:8081/RenapActivosWebClipTwo/service',
            headers: {
              'Content-Type': undefined
            },
            data: { json: json }
           };
           //resolve response
        
        $http(pos).then(function(){ }, function(){ });
//        $http(pos).
//                success(function(){ }).
//                error( function(){ });

    }
    this.update = function (json, $http) {
        $http.post('http://localhost:8081/RenapActivosWebClipTwo/service', json).
                then(function (response) {
//                  alert('SUCCESS SAVE');
                }, function (response) {
                    // called asynchronously if an error occurs
                    // or server returns response with an error status.
                    alert('ERROR IN SERVICE');
                });

    }

    this.delete = function (json, $http) {
        $http.post('http://localhost:8081/RenapActivosWebClipTwo/service', json).
                then(function (response) {
//                  alert('SUCCESS SAVE');
                }, function (response) {
                    // called asynchronously if an error occurs
                    // or server returns response with an error status.
                    alert('ERROR IN SERVICE');
                });

    }
    
    this.get = function (json, $http,$q) {
        var deferred = $q.defer();
        $http.post('http://localhost:8081/RenapActivosWebClipTwo/service', json).
                then(function (response) {
                  alert('200 OK');
                }, function (response) {
                    // called asynchronously if an error occurs
                    // or server returns response with an error status.
                    alert('ERROR IN SERVICE');
                });
        return deferred.promise;        

    }
}

function SwitchRenap() {
    this.getDeptos = function (json, $http,$q) {
        
        var myPromise = this.getData(json,$http,$q);

        this.myPromise.then(function(resolve){
            alert(resolve);
            alert("RESOLVE "+JSON.stringify(response.data));
            }, function(reject){
            alert(reject)      
        });

    }
    
//    this.getDeptos = function (json, $http,$q) {
    this.getData = function (json, $http,$q) {
        // Simple POST request example (passing data) :
        var deferred = $q.defer();
               $http.post('http://localhost:8081/RenapActivosWebClipTwo/serviceSwitch', json).
                then(function (response) {
                  alert('RESPONSE11'+JSON.stringify(response.data));
                  deferred.resolve(JSON.stringify(response.data));
//                  return JSON.stringify(response.data);
                }, function (response) {
                    // called asynchronously if an error occurs
                    // or server returns response with an error status.
                    alert('ERROR IN SWITCH SERVICE');
                    deferred.reject('ERROR');
                });

        return deferred.promise;       
//        $http.post('http://localhost:8081/RenapActivosWebClipTwo/serviceSwitch', json);

//        promise.then(function (response) {
//              alert('RESPONSE'+JSON.stringify(response.data));
//              
//              return JSON.stringify(response.data);
//            }, function (response) {
//
//                // called asynchronously if an error occurs
//                // or server returns response with an error status.
//                alert('ERROR IN SWITCH SERVICE');
//            }
//        )
            
        
//        $http.post('http://localhost:8081/RenapActivosWebClipTwo/serviceSwitch', json).
//                then(function (response) {
//                  alert('RESPONSE'+JSON.stringify(response.data));
//
//                  return JSON.stringify(response.data);
//                }, function (response) {
//                    // called asynchronously if an error occurs
//                    // or server returns response with an error status.
//                    alert('ERROR IN SWITCH SERVICE');
//                });
//
//        return deferred.promise;        
        
        
    }
    this.switchhTest = function (json, $http) {
//        $http({ method: 'GET', url: 'http://localhost:8081/RenapActivosWeb/service' }).
//                success(function (data, status, headers, config) {
//                    alert('SUCCESS SAVE'+data);
//                    alert('SUCCESS SAVE'+status);
//                }).
//                error(function (data, status, headers, config) {
//                    alert('ERROR SAVE'+status);
//                    alert('ERROR SAVE'+data);
//                });

        // Simple POST request example (passing data) :
        $http.post('http://localhost:8081/RenapActivosWebClipTwo/serviceSwitch', json).
                then(function (response) {
//                  alert('SUCCESS SAVE');
                }, function (response) {
                    // called asynchronously if an error occurs
                    // or server returns response with an error status.
                    alert('ERROR IN SWITCH SERVICE');
                });

    }
    this.switchGet = function (json, $http) {
        alert("EXEC GET IN SWITCH")
//        $http({ method: 'GET', url: 'http://localhost:8081/RenapActivosWeb/service' }).
//                success(function (data, status, headers, config) {
//                    alert('SUCCESS SAVE'+data);
//                    alert('SUCCESS SAVE'+status);
//                }).
//                error(function (data, status, headers, config) {
//                    alert('ERROR SAVE'+status);
//                    alert('ERROR SAVE'+data);
//                });

        // Simple POST request example (passing data) :
        $http.post('http://localhost:8081/RenapActivosWebClipTwo/serviceSwitch', json).
                then(function (response) {
//                  alert('SUCCESS SAVE');
                }, function (response) {
                    // called asynchronously if an error occurs
                    // or server returns response with an error status.
                    alert('ERROR IN SERVICE');
                });

    }
    
}

