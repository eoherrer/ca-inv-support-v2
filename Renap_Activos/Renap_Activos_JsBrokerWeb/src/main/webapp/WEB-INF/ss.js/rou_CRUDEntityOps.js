/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function exec(remoteDao, switchClient, reqBodyObj, qParamsObj) {
    var lcReqBodyObj = reqBodyObj !== null && reqBodyObj.length > 0 ? JSON.parse(reqBodyObj) : null;
    var lcQParamsObj = qParamsObj !== null && qParamsObj.length > 0 ? JSON.parse(qParamsObj) : null;

    if (lcQParamsObj !== null && lcQParamsObj.entity && lcQParamsObj.entity.length > 0) { //entity is required to do a remote dao request
        remoteDao = new RemoteDao();
        lcQParamsObj.page = lcQParamsObj.page ? lcQParamsObj.page : null;
        lcQParamsObj.sort = lcQParamsObj.sort ? lcQParamsObj.sort : null;
        lcQParamsObj.size = lcQParamsObj.size ? lcQParamsObj.size : null;
        return remoteDao.doEntityRequest(lcQParamsObj.entity, lcQParamsObj.id, lcQParamsObj.page, lcQParamsObj.size, lcQParamsObj.sort);
    }

    return {};
}

