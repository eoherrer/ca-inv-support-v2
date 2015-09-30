/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.renap.infrastructure;

import org.renap.infrastructure.integrations.RemoteModel;
import org.renap.infrastructure.integrations.SwitchClient;

/**
 *
 * @author edcracken
 */
public interface JsRoutine {

    public String exec(RemoteModel dao, SwitchClient switchClient, Object remote,String objParams);
}
