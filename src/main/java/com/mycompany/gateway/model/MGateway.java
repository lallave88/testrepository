/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gateway.model;

import com.mycompany.gateway.entity.Device;
import com.mycompany.gateway.entity.Gateway;
import java.util.Set;

/**
 *
 * @author lallave
 */
public class MGateway {
  
    
    private String serialnumber;
    private String name;
    private String IPv4address;
    private Set<Device> devices;

    public MGateway() {
    }
    public MGateway(Gateway g) {
        this.serialnumber = g.getSerialNumber();
        this.name = g.getName();
        this.IPv4address = g.getIPv4address();
        this.devices = g.getDevices();
    }

    public MGateway(String serialnumber, String name, String IPv4address, Set<Device> devices) {
        this.serialnumber = serialnumber;
        this.name = name;
        this.IPv4address = IPv4address;
        this.devices = devices;
    }

    /**
     * @return the serialnumber
     */
    public String getSerialnumber() {
        return serialnumber;
    }

    /**
     * @param serialnumber the serialnumber to set
     */
    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the IPv4address
     */
    public String getIPv4address() {
        return IPv4address;
    }

    /**
     * @param IPv4address the IPv4address to set
     */
    public void setIPv4address(String IPv4address) {
        this.IPv4address = IPv4address;
    }

    /**
     * @return the devices
     */
    public Set<Device> getDevices() {
        return devices;
    }

    /**
     * @param devices the devices to set
     */
    public void setDevices(Set<Device> devices) {
        this.devices = devices;
    }

    @Override
    public String toString() {
        return "MGateway [serialnumber = " + serialnumber + ", name = " + name + ", IPv4address = " + IPv4address + "]";
    }
    
    
    
}
