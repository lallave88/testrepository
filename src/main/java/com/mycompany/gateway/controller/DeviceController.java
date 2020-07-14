/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gateway.controller;

import com.mycompany.gateway.entity.Device;
import com.mycompany.gateway.entity.Gateway;
import com.mycompany.gateway.service.DeviceService;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lallave
 */
@RestController
@RequestMapping(value = "/GatewaysDevices")
public class DeviceController {
    @Autowired
    @Qualifier("deviceService")
    private DeviceService deviceService;

    
    
    @RequestMapping(value = "/devices", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Device>> getDevices() {
        Collection<Device> devices = deviceService.findAll();        
        return new ResponseEntity<Collection<Device>>(devices, HttpStatus.OK);
    }

    @RequestMapping(value = "/devices/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Device> getDevice(@PathVariable("id") Long id) {
        Device device = deviceService.findById(id);
        if(device == null) {
            return new ResponseEntity<Device>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Device>(device, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/devices", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Device> createDevice(@RequestBody Gateway gateway,@RequestBody Device device) {
        
        Device savedDevice = null;
        
        if(deviceService.Create(gateway,device)){
            savedDevice=deviceService.findById(device.getId());
            return new ResponseEntity<Device>(savedDevice, HttpStatus.CREATED);
        }
        if(savedDevice==null){
        return new ResponseEntity<Device>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Device>(savedDevice, HttpStatus.CREATED);
        
    }

    @RequestMapping(value = "/devices/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Device> updateDevice(@PathVariable("id") Long id, @RequestBody Device device) {
        Device updatedDevice = null;
        if (device != null && id == device.getId()) {
            deviceService.update(device);
            updatedDevice = deviceService.findById(id);            
        }
        if(updatedDevice == null) {
            return new ResponseEntity<Device>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Device>(updatedDevice, HttpStatus.OK);
    }

    @RequestMapping(value = "/devices/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Device> deleteDevice(@PathVariable("id") Long id) {
        if(deviceService.delete(id))
        return new ResponseEntity<Device>(HttpStatus.NO_CONTENT);
        
        else{
        return new ResponseEntity<Device>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
     @RequestMapping(value = "/devicesbygateway/{serialnumber}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Device>> getDevicesByGateway(@PathVariable("serialnumber") String serialnumber) {
        Collection<Device> devices = deviceService.findBySerialnumber(serialnumber);        
        return new ResponseEntity<Collection<Device>>(devices, HttpStatus.OK);
    }

}
