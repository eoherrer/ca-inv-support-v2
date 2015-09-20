'use strict';

    
app.controller('WizardCtrlActivoRenap', ['$scope', 'toaster','daoService','switchRenap','$http','$q',
function ($scope, toaster,daoService,switchRenap,$http,$q) {
    $scope.currentStep = 1;
    
    
    var xmlhttp = new XMLHttpRequest(); 
    var url = 'http://localhost:8081/RenapActivosWebClipTwo/serviceSwitch';
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            
//            alert('RESPONSE SYNCRONOUS'+xmlhttp.responseText);
            var myArr = JSON.parse(xmlhttp.responseText);
//            alert('IN ARRAY'+myArr);
            $scope.departamentos = myArr;
        }
    }
    xmlhttp.open("POST",url,false);
    xmlhttp.send();
    
//    alert('END');
//    var deptos = function(){return switchRenap.switchhTest($scope.myModel,$http)};
//    $scope.$watch('MyModel.departamento',function(newValue, oldValue){
//        alert('watch');
//    });
    
//    var result = factGetDeptos;
//    var result = switchRenap.getDeptos1($scope,$http,$q);

//     var res = function (json, $http,$q) {
//        var promise = this.getData(json,$http,$q);
//        promise.then(function(resolve){
//            alert("NEW RESOLVE "+resolve);
//            }, function(reject){
//            alert(reject)      
//        });
//
//    }

     
//    var result = res;

    
//    $scope.departamentos  = [{"DEPARTAMENTO":"16","NOMBRE":"ALTA"},
//                    {"DEPARTAMENTO":"17","NOMBRE":"ALTA1"}];
//            }

    
//    var DeptoController = function(Departamento) {
//        var departamento = new Departamento();
//  
//        var deptoPromise = Departamento.getAll();
//        return deptoPromise;
////        deptoPromise.then(function(response) {
////          departamento = response.data;
////          alert(departamento);
////          return departamento;
////        });
//    };
//   
//    var r = DeptoController(Departamento);
//    var r = switchRenap.getDeptos($scope,$http,$q);
//    alert('DATA '+r);
//    $scope.departamentos = r;
    
  
//    $scope.departamentos = result;
//    $scope.departamentos = departamento;
    
//    alert(' RESULT '+result);
//    $scope.myModel.departamento = result;
    
    // Initial Value
    
    $scope.form = {
            next: function (form) {

            $scope.toTheTop();
            
            if (form.$valid) {
                nextStep();
            } else {
                var field = null, firstError = null;
                for (field in form) {
                    if (field[0] != '$') {
                        if (firstError === null && !form[field].$valid) {
                            firstError = form[field].$name;
                        }

                        if (form[field].$pristine) {
                            form[field].$dirty = true;
                        }
                    }
                }

                angular.element('.ng-invalid[name=' + firstError + ']').focus();
                errorMessage();
            }
        },
        prev: function (form) {
            $scope.toTheTop();
            prevStep();
        },
        goTo: function (form, i) {
            if (parseInt($scope.currentStep) > parseInt(i)) {
                $scope.toTheTop();
                goToStep(i);

            } else {
                if (form.$valid) {
                    $scope.toTheTop();
                    goToStep(i);

                } else
                    errorMessage();
            }
        },
        submit: function () {
            toaster.pop('success', 'Success', 'Activo Ingresado!!!!##');
        },
        save: function () {
            alert(JSON.stringify($scope.myModel));
//            $scope.myModel = $scope.myModel.concat([{action:"save",entity:"activo_informatica"}]);
            daoService.save($scope.myModel,$http);
//            daoService.save(JSON.stringify($scope.myModel),$http);
            
            toaster.pop('success', 'Success', 'Activo Ingresado!!');
        },
        reset: function () {
            //verificar reset 
//            $scope.myModel = angular.copy($scope.master);
            $scope.myModel.reset();
        }
    };

    var nextStep = function () {
        $scope.currentStep++;
    };
    var prevStep = function () {
        $scope.currentStep--;
    };
    var goToStep = function (i) {
        $scope.currentStep = i;
    };
    var errorMessage = function (i) {
        toaster.pop('error', 'Error', 'Por favor complete la información antes de continuar');
    };
}]);
