/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gateway.controller;

import com.mycompany.gateway.entity.Gateway;
import com.mycompany.gateway.service.IGatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.regex.Pattern;


/**
 * @author lallave
 */
@RestController
public class GatewayController {

    @Autowired
    @Qualifier("gatewayService")
    private IGatewayService gatewayService;

    @RequestMapping(value = "/gateway", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Gateway>> getGateways() {
        Collection<Gateway> gateways = gatewayService.findAll();
        return new ResponseEntity<>(gateways, HttpStatus.OK);
    }

    @RequestMapping(value = "/gateway/{serialnumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Gateway> getGateway(@PathVariable("id") String serialnumber) {
        Gateway gateway = gatewayService.findBySerialnumber(serialnumber);
        if (gateway == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(gateway, HttpStatus.OK);
    }

    @RequestMapping(value = "/gateway", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Gateway> createGateway(@RequestBody Gateway gateway) {

        Gateway savedGateway = null;
        if (!ValidoIPv4(gateway)) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (gatewayService.create(gateway)) {
            savedGateway = gatewayService.findBySerialnumber(gateway.getSerialNumber());
            return new ResponseEntity<>(savedGateway, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(value = "/gateway/{serialnumber}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Gateway> updateGateway(@PathVariable("serialnumber") String serialnumber, @RequestBody Gateway gateway) {
        Gateway updatedGateway = null;
        if (gateway != null && serialnumber.equals(gateway.getSerialNumber())) {
            gatewayService.update(gateway);
            updatedGateway = gatewayService.findBySerialnumber(serialnumber);
        }
        if (updatedGateway == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(updatedGateway, HttpStatus.OK);
    }

    @RequestMapping(value = "/gateway/{serialnumber}", method = RequestMethod.DELETE)
    public ResponseEntity<Gateway> deleteGateway(@PathVariable("serialnumber") String serialnumber) {
        if (gatewayService.delete(serialnumber)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public boolean ValidoIPv4(Gateway g) {

        String regex = "\\b((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)(\\.)){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\b";
        return Pattern.matches(regex, g.getIPv4address());

    }

}
