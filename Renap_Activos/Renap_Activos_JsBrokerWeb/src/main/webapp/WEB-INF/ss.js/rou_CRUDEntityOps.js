/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function exec(remoteDao, switchClient, reqBodyObj, qParamsObj) {
    var lcReqBodyObj = reqBodyObj !== null && reqBodyObj.length > 0 ? reqBodyObj : null;
    var lcQParamsObj = qParamsObj !== null && qParamsObj.length > 0 ? JSON.parse(qParamsObj) : null;

    if (lcReqBodyObj !== null && lcReqBodyObj.length > 0) {        
        return remoteDao.doPersistEntityRequest(lcQParamsObj.entity, lcQParamsObj.id, lcReqBodyObj, lcQParamsObj.method);
    }

    if (lcQParamsObj !== null && lcQParamsObj.entity && lcQParamsObj.entity.length > 0) { //entity is required to do a remote dao request
        lcQParamsObj.page = lcQParamsObj.page ? lcQParamsObj.page : null;
        lcQParamsObj.sort = lcQParamsObj.sort ? lcQParamsObj.sort : null;
        lcQParamsObj.size = lcQParamsObj.size ? lcQParamsObj.size : null;
        return remoteDao.doGetEntityRequest(lcQParamsObj.entity, lcQParamsObj.id, lcQParamsObj.page, lcQParamsObj.size, lcQParamsObj.sort);
    }

    return {};
}

