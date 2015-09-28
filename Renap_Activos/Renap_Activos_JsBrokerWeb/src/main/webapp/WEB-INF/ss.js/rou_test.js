/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function exec(remoteDao, switchClient, remoteContent) {
    var reObj=JSON.parse(remoteContent);
    remoteDao.doNamedQuery("test",null);
    return reObj;
}

