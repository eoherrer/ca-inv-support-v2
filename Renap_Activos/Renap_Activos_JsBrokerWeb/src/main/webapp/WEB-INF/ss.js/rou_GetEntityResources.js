/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function exec(remoteModel, switchClient, reqBodyObj, qParamsObj) {
    print(qParamsObj);
    var lcQParamsObj = qParamsObj !== null ? JSON.parse(qParamsObj) : null;

    if (lcQParamsObj !== null && lcQParamsObj.entity && lcQParamsObj.entity.length > 0) { //entity is required to do a remote dao request
       // remoteModel = new RemoteDao();
        lcQParamsObj.id = lcQParamsObj.id ? lcQParamsObj.id : null;
        lcQParamsObj.page = lcQParamsObj.page ? lcQParamsObj.page : null;
        lcQParamsObj.sort = lcQParamsObj.sort ? lcQParamsObj.sort : null;
        lcQParamsObj.size = lcQParamsObj.size ? lcQParamsObj.size : null;
        
        return remoteModel.doGetEntityRequest(lcQParamsObj.entity, lcQParamsObj.id, lcQParamsObj.page, lcQParamsObj.size, lcQParamsObj.sort);
    }

    return {};
}

