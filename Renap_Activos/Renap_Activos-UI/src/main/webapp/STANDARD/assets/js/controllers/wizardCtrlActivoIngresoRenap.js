'use strict';

    //wizardCtrlActivoRenap
app.controller('WizardCtrlActivoIngresoRenap', ['$scope', 'toaster','daoService','switchRenap','$http','$q',
function ($scope, toaster,daoService,switchRenap,$http,$q) {
    $scope.currentStep = 1;
    
//    var xmlhttp = new XMLHttpRequest(); 
//    var url = 'http://localhost:8081/RenapActivosWebClipTwo/serviceSwitch';
//    xmlhttp.onreadystatechange = function() {
//        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
//            
////            alert('RESPONSE SYNCRONOUS'+xmlhttp.responseText);
//            var myArr = JSON.parse(xmlhttp.responseText);
////            alert('IN ARRAY'+myArr);
//            $scope.departamentos = myArr;
//        }
//    }
//    xmlhttp.open("POST",url,false);
//    xmlhttp.send();
//    
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
            $scope.saveResult= 'test';
//            alert(JSON.stringify($scope.myModel));
//            alert('RESULT TEST '+$scope.saveResult);
//            $scope.myModel = $scope.myModel.concat([{action:"save",entity:"activo_informatica"}]);
            $scope.myModel.entity='activotecnologia';
            $scope.myModel.action='save';
            daoService.save($scope.myModel,$http,$scope);
//            daoService.save(JSON.stringify($scope.myModel),$http);
//            alert('RESULT SCOPE'+$scope.saveResult);
            
            toaster.pop('success', 'Success', 'Activo Ingresado!! '+$scope.saveResult);
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
