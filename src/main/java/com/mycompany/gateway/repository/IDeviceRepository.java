/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gateway.repository;

import com.mycompany.gateway.entity.Device;
import com.mycompany.gateway.entity.Gateway;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author lallave
 */
public interface IDeviceRepository extends CrudRepository<Device, Serializable>{
    boolean Create(Gateway gateway,Device d);
    Device findById(long id);
    List<Device> findAll();
    void update(Device d);
    boolean delete(long id);
    long countBySerialnumber(String serialnumber);
    List<Device> findBySerialnumber(String serialnumber);
}
