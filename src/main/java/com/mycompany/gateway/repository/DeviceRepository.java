/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gateway.repository;

import com.mycompany.gateway.entity.Device;
import com.mycompany.gateway.entity.Gateway;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lallave
 */
@Repository("deviceRepository")
public class DeviceRepository implements IDeviceRepository{

    @Autowired(required=true)
    @PersistenceContext
    private EntityManager entityManager;
    @Bean(name = "sessionD")
    public Session getSessionD() {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession;
    }
    
    @Override
    public boolean Create(Gateway gateway, Device d) {
        d.setGateway(gateway);
        Query<Device> query = getSessionD().createNativeQuery("insert into device (seller,cerationdate) VALUES (?,?)");
        query.setParameter(1, d.getSeller());
        query.setParameter(2, new Timestamp(new Date().getTime()));
       
        int result = query.executeUpdate();

        if (result != -1) {
            return true;
        }
        return false;
    }

    @Override
    public Device findById(long id) {
         Query<Device> query =getSessionD().createQuery("from device where id=:id", Device.class);
                        query.setParameter("id", id);
    return query.uniqueResult();
    }

    @Override
    public List<Device> findAll() {
        Query<Device> query = getSessionD().createQuery("from device", Device.class);
        List<Device> devices = query.getResultList();
        return devices;
    }

    //UPDATE `gatewaysdb`.`gateway` SET `IPv4address` = '192.88.8.1' WHERE (`serialnumber` = 'primero');

    @Override
    public void update(Device d) {
        Query<Device> query = getSessionD().createNativeQuery("insert into device (seller,creationdate) VALUES (?,?)");
        query.setParameter(1, d.getSeller());
        query.setParameter(2, d.getCreationdate());
    }

    @Override
    public boolean delete(long id) {
        @SuppressWarnings("JPQLValidation")
        Query<Device> query = getSessionD().createQuery("delete from device where id=:id");
        query.setParameter("id", id);
        int result = query.executeUpdate();

        if (result != -1) {
            return true;
        }
        return false;
    }

    @Override
    public long countBySerialnumber(String serialnumber) {
       Query<Device> query = getSessionD().createQuery("from device where serialnumber=:serialnumber", Device.class);
                    query.setParameter("serialnumber", serialnumber);
                    List<Device> devices = query.getResultList();
        return devices.stream().count(); 
    }

    @Override
    public List<Device> findBySerialnumber(String serialnumber) {
       Query<Device> query = getSessionD().createQuery("from device where serialnumber=:serialnumber", Device.class);
                    query.setParameter("serialnumber", serialnumber);
                    List<Device> devices = query.getResultList();
        return devices; }

    @Override
    public <S extends Device> S save(S s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends Device> Iterable<S> saveAll(Iterable<S> itrbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<Device> findById(Serializable id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existsById(Serializable id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<Device> findAllById(Iterable<Serializable> itrbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long count() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteById(Serializable id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Device t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAll(Iterable<? extends Device> itrbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
