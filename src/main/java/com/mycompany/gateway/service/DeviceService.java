/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gateway.service;

import com.mycompany.gateway.entity.Device;
import com.mycompany.gateway.entity.Gateway;
import com.mycompany.gateway.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author lallave
 */
@Service("deviceService")
public class DeviceService implements IDeviceService {

    @Autowired(required = true)
    @Qualifier("deviceRepository")
    DeviceRepository deviceRepo;

    @Autowired
    IGatewayService gatewayService;

    public DeviceService() {
    }

    @Override
    public List<Device> findAll() {
        return deviceRepo.findAll();
    }

    @Override
    public List<Device> findBySerialnumber(String serialnumber) {
        return deviceRepo.findByGateway_SerialNumber(serialnumber);
    }

    @Override
    public Optional<Device> findById(long id) {
        return deviceRepo.findById(id);
    }

    @Override
    public void update(Device d) {
        deviceRepo.save(d);
    }

    @Override
    public boolean Create(Gateway gateway, Device device) {
        if (deviceRepo.count(Example.of(device)) == 10) {
            return false;
        } else {
            device.setGateway(gateway);
            deviceRepo.save(device);
            return true;
        }
    }

    @Override
    public boolean delete(long id) {
        if (deviceRepo.existsById(id)) {
            deviceRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
