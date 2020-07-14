/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gateway.entity;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Column;

import java.io.Serializable;
import javax.persistence.FetchType;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 *
 * @author lallave
 */
@Entity
@Table(name = "gateway")
public class Gateway implements Serializable {

    @Id
    @Column(name = "serialnumber")
    private String serialnumber;

    @Column(name = "name")
    private String name;

    @Column(name = "IPv4address")
    private String IPv4address;
    
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "gateway")
    private Set<Device> devices;

    public Gateway() {
    }

    public Gateway(String serialnumber, String name, String IPv4address) {
        this.serialnumber = serialnumber;
        this.name = name;
        this.IPv4address = IPv4address;

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
        return "Gateway [serialnumber = " + serialnumber + ", name = " + name + ", IPv4address = " + IPv4address + "]";
    }

}
