/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gateway.repository;

import com.mycompany.gateway.entity.Gateway;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lallave
 */
@Transactional
@Repository("gatewayRepository")
public class GatewayRepository implements IGatewayRepository {

    @Autowired
    @PersistenceContext
    private EntityManager entityManager;
    @Bean(name = "sessionG")
    public Session getSessionG() {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession;
    }

    @Override
    public boolean create(Gateway g) {
        Query<Gateway> query = getSessionG().createNativeQuery("insert into gateway (serialnumber,name,IPv4address) VALUES (?,?,?)");
        query.setParameter(1, g.getSerialnumber());
        query.setParameter(2, g.getName());
        query.setParameter(3, g.getIPv4address());
        int result = query.executeUpdate();

        if (result != -1) {
            return true;
        }
        return false;

    }

    @Override
    public Gateway findBySerialnumber(String serialnumber) {
        Gateway g = getSessionG().get(Gateway.class, serialnumber);
        return g;
    }

    @Override
    public List<Gateway> findAll() {
        Query<Gateway> query = getSessionG().createQuery("from gateway", Gateway.class);
        List<Gateway> gateways = query.getResultList();
        return gateways;
    }

    @Override
    public void update(Gateway g) {
      Query<Gateway> query = getSessionG().createNativeQuery("insert into gateway (serialnumber,name,IPv4address) VALUES (?,?,?)");
        query.setParameter(1, g.getSerialnumber());
        query.setParameter(2, g.getName());
        query.setParameter(3, g.getIPv4address());
        query.executeUpdate();
        
    }

    @Override
    public boolean delete(String serialnumber) {
        @SuppressWarnings("JPQLValidation")
        Query<Gateway> query = getSessionG().createQuery("delete from gateway where serialnumber=:serialnumber");
        query.setParameter("serialnumber", serialnumber);
        int result = query.executeUpdate();

        if (result != -1) {
            return true;
        }
        return false;
    }

    @Override
    public <S extends Gateway> S save(S s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends Gateway> Iterable<S> saveAll(Iterable<S> itrbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<Gateway> findById(Serializable id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existsById(Serializable id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<Gateway> findAllById(Iterable<Serializable> itrbl) {
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
    public void delete(Gateway t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAll(Iterable<? extends Gateway> itrbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
