/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.renap.repositories;

import org.renap.model.ActivoInformatica;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "activoinformatica", path = "activoinformatica")
public interface ActivoInformaticaRepository extends PagingAndSortingRepository<ActivoInformatica, Integer> {

}
