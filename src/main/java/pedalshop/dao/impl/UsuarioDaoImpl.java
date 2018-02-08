/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedalshop.dao.impl;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import pedalshop.dao.UsuarioDao;
import pedalshop.entity.Usuario;

/**
 *
 * @author User
 */
class UsuarioDaoImpl extends AbstractEntity<Usuario> implements UsuarioDao{

    public UsuarioDaoImpl(){
        super(Usuario.class);
    }
    
    @Override
    public Usuario login(String user, String pass) {
        CriteriaQuery<Usuario> cq = cb.createQuery(clazz);//CLASSS AND OBJECT TYPE MUST BE SPECIFIED FOR RESULTS TO WORK
        Root users = cq.from(clazz);
        cq.where(cb.and(cb.equal(users.get("username"), user), cb.equal(users.get("password"), pass)));//EXTREMELY CASE SENSITIVE
        //em.createQuery(cq).getResultList()
        return em.createQuery(cq).getSingleResult();
    }
    
}
