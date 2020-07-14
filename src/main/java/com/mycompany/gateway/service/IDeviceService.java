/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gateway.service;

import com.mycompany.gateway.entity.Device;
import com.mycompany.gateway.entity.Gateway;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author lallave
 */
public interface IDeviceService {
	public List<Device> findAll();
    
    public List<Device> findBySerialnumber(String serialnumber);

	public Optional<Device> findById(long id);

	public void update(Device d);
	
	public boolean Create(Gateway gateway, Device device);

	public boolean delete(long id);
}
