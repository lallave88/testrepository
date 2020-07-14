/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gateway.service;

import com.mycompany.gateway.entity.Gateway;
import java.util.List;

/**
 *
 * @author lallave
 */
public interface IGatewayService {

    public boolean create(Gateway g);

    public List<Gateway> findAll();

    public Gateway findBySerialnumber(String serialnumber);

    public void update(Gateway g);

    public boolean delete(String serialnumber);
}
