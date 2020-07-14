/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gateway.repository;

import com.mycompany.gateway.entity.Gateway;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lallave
 */

public interface IGatewayRepository extends CrudRepository<Gateway, Serializable>{
    boolean create(Gateway g);
    Gateway findBySerialnumber(String serialnumber);
    @Override
    List<Gateway> findAll();
    void update(Gateway g);
    boolean delete(String serialnumber);
    
}
