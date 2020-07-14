/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gateway.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author lallave
 */
@Entity
@Table(name = "gateway")
public class Gateway implements Serializable {

    @Id
    @Column(name = "serialnumber")
    private String serialNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "IPv4address")
    private String IPv4address;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "gateway")
    private Set<Device> devices;

    public Gateway() {
    }

    public Gateway(String serialNumber, String name, String IPv4address) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.IPv4address = IPv4address;

    }

    /**
     * @return the serialnumber
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * @param serialNumber the serialnumber to set
     */
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
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
        return "Gateway [serialnumber = " + serialNumber + ", name = " + name + ", IPv4address = " + IPv4address + "]";
    }

}
