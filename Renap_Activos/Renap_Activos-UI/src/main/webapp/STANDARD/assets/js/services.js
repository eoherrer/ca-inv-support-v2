/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function DaoService() {
    this.save = function (json, $http,$scope) {

        var xmlhttp = new XMLHttpRequest();
        var url = 'http://localhost:8081/RenapActivosWebClipTwo/service';
//        xmlhttp.setRequestHeader('Content-Type', 'application/json');
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                alert(xmlhttp.responseText);
                var result = JSON.parse(xmlhttp.responseText);
                alert (JSON.stringify(result));
                $scope.saveResult = result;
                alert('IN SAVE RESULT '+$scope.saveResult);
                return result;
            }
        }
        xmlhttp.open("POST", url, false);
        alert('JSON '+JSON.stringify(json));
        xmlhttp.send(JSON.stringify(json));
        
//        var pos = {
//            method: 'POST',
//            url: 'http://localhost:8081/RenapActivosWebClipTwo/service',
//            headers: {
//              'Content-Type': undefined
//            },
//            data: { json: json }
//           };
//           //resolve response
//        
//        $http(pos).then(function(){ }, function(){ });
        
        
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
    //get DEPTOS BY FACTORY.
    
//    this.getDeptos1 =new function(){
//        var xmlhttp = new XMLHttpRequest(); 
//        var url = 'http://localhost:8081/RenapActivosWebClipTwo/serviceSwitch';
//        xmlhttp.onreadystatechange = function() {
//            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
//                alert(xmlhttp.responseText);
//                var myArr = JSON.parse(xmlhttp.responseText);
//                alert(myArr);
//            }
//        }
//        xmlhttp.open("POST",url,true);
//        xmlhttp.send();
//    }
    
    this.getDeptos = function (json, $http,$q) {
        var promise = this.getData(json,$http,$q);
        promise.then(function(resolve){
            alert("RESOLVE "+resolve);
            }, function(reject){
            alert(reject)      
        });

    }
    
//    this.getDeptos = function (json, $http,$q) {
//        var evt = json.shift();
    this.getData = function (json, $http,$q) {
        // Simple POST request example (passing data) :
        var deferred = $q.defer();
        
        $http.post('http://localhost:8081/RenapActivosWebClipTwo/serviceSwitch', json).
        then(function (response) {
//            alert('RESPONSE11111'+JSON.stringify(response.data));
            deferred.resolve(JSON.stringify(response.data));

//          deferred.resolve(JSON.stringify(response.data));
          
//                  return JSON.stringify(response.data);
        }, function (response) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
            alert('ERROR IN SWITCH SERVICE');
            deferred.reject('ERROR');
        });
            
        
//        delay = function ($q, $defer) {
//            var delay = $q.defer();
//            $defer(delay.resolve, 5000);
//            return delay.promise;
//          }
          
//        delay:delay;
//        a;
        return deferred.promise;
            
    }
    
    this.getDeptosBACK = function (json, $http,$q) {
        $http.post('http://localhost:8081/RenapActivosWebClipTwo/serviceSwitch', json).
                then(function (response) {
                  alert('RESPONSE'+JSON.stringify(response.data));

                  return JSON.stringify(response.data);
                }, function (response) {
                    // called asynchronously if an error occurs
                    // or server returns response with an error status.
                    alert('ERROR IN SWITCH SERVICE');
                });
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

