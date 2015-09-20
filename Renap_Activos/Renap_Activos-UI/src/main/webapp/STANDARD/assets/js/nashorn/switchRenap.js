/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function getDeptos(){

    var Exception = Java.type("java.lang.Exception");
    var ExceptionAdapter = Java.extend(Exception);

    //var exception = new ExceptionAdapter("Generic Renap Exception in save") {
    var exception = new ExceptionAdapter("Renap Exception switch get") {
        getMessage: function() {
            var _super_ = Java.super(exception);
            return _super_.getMessage().toUpperCase();
        }
    }

    try {
        var RenapSwitch = Java.type("renap.servicebroker.rswicth.RenapSwitch")
        var switchh = new RenapSwitch;

        result = switchh.getDepartamentos();
        
        return result;
    } catch (ex) {
        print(ex);
        print(exception);
    }
    
}

