/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global jsondata */

//function saveMarcas(json,entidad){
function save(json,entidad){
    print("NASHORN SAVE  "+json+" "+entidad);
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
//        dao.save(json,"marcas");
        result = dao.save(json,entidad);
        print("SAVE DONE NASHORN!!"+result);
        return result;
    } catch (ex) {
        print(exception);
    }
}

function update(json,entidad){
    print("IN UPDATE "+json);
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
//        dao.save(json,"marcas");
        var result = dao.update(json,entidad);
        
        return result;
    } catch (ex) {
        print(exception);
    }
}

function remove(json,entidad){
    print("IN UPDATE "+json);
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
//        dao.save(json,"marcas");
        dao.save(json,entidad);
        print("SAVE_MARCAS DONE WELL!!");
    } catch (ex) {
        print(exception);
    }
}

function getData(json,entidad){
    print("IN UPDATE "+json);
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
//        dao.save(json,"marcas");
        dao.save(json,entidad);
        print("SAVE DONE WELL!!");
    } catch (ex) {
        print(exception);
    }
}



