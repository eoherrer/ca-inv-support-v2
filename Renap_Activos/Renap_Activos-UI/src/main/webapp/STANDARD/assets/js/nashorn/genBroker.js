/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global jsondata */

var Exception = Java.type("java.lang.Exception");
var ExceptionAdapter = Java.extend(Exception);

//var exception = new ExceptionAdapter("Generic Renap Exception in save") {
var exception = new ExceptionAdapter("Renap Exception in save") {
    getMessage: function() {
        var _super_ = Java.super(exception);
        return _super_.getMessage().toUpperCase();
    }
}

try {
    //execute save object
    var BaseDaoImpl = Java.type("renap.servicebroker.dao.BaseDaoImpl")
    var dao = new BaseDaoImpl;
    dao.save(jsondata,"marcas");
} catch (ex) {
    print(exception);
}


