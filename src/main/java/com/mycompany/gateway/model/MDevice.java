/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gateway.model;

import com.mycompany.gateway.entity.Device;
import com.mycompany.gateway.entity.Gateway;
import java.sql.Timestamp;

/**
 *
 * @author lallave
 */
public class MDevice {

    private long id;

    private String seller;

    private Timestamp creationdate;

    private Gateway gateway;

    public MDevice() {

    }

    public MDevice(Device d) {
        this.seller = d.getSeller();
        this.creationdate = d.getCreationdate();
    }

    public MDevice(String seller, Timestamp creationdate) {
        this.seller = seller;
        this.creationdate = creationdate;
    }

    public MDevice(long id, String seller, Timestamp creationdate, Gateway gateway) {
        this.id = id;
        this.seller = seller;
        this.creationdate = creationdate;
        this.gateway = gateway;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public Timestamp getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Timestamp creationdate) {
        this.creationdate = creationdate;
    }

    @Override
    public String toString() {
        return "MDevice [id = " + id + ", seller = " + seller + ", creationdate = " + creationdate + "]";
    }

    /**
     * @return the gateway
     */
    public Gateway getGateway() {
        return gateway;
    }

    /**
     * @param gateway the gateway to set
     */
    public void setGateway(Gateway gateway) {
        this.gateway = gateway;
    }
}
