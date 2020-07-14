/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gateway.service;

import com.mycompany.gateway.entity.Gateway;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mycompany.gateway.repository.GatewayRepository;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author lallave
 */
@Service("gatewayService")
public class GatewayService implements IGatewayService {

    @Autowired(required = true)
    @Qualifier("gatewayRepository")    
    GatewayRepository gatewayRepo;

    public GatewayService() {
    }

    
    @Override
    public boolean create(Gateway g) {
        try {
            Gateway gsaved = gatewayRepo.save(g);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Gateway> findAll() {
        return gatewayRepo.findAll();
    }

    /**
     *
     * @param serialnumber
     * @return
     */
    @Override
    public Gateway findBySerialnumber(String serialnumber) {
        return gatewayRepo.findBySerialnumber(serialnumber);
    }

    @Override
    public void update(Gateway g) {
        gatewayRepo.update(g);      
    }

    @Override
    public boolean delete(String serialnumber) {
        Gateway gateway= findBySerialnumber(serialnumber);
        if(gateway!=null){
        gatewayRepo.delete(gateway);
        return true;
        }
        return false;
    }

}
