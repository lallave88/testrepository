/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.gateway.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author lallave
 */
@Entity
@Table(name = "device")
public class Device implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "seller")
    private String seller;

    @Column(name = "creationdate")
    @CreationTimestamp
    private Timestamp creationdate;

    @ManyToOne
    @JoinColumn(name = "serialnumber")
    private Gateway gateway;

    public Device() {

    }

    public Device(String seller, Timestamp creationdate) {
        this.seller = seller;
        this.creationdate = creationdate;
    }

    public Device(long id, String seller, Timestamp creationdate, Gateway gateway) {
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
        return "Device [id = " + id + ", seller = " + seller + ", creationdate = " + creationdate + "]";
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
