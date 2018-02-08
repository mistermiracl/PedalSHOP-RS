/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedalshop.dao;

import pedalshop.entity.Usuario;

/**
 *
 * @author User
 */
public interface UsuarioDao extends EntityDao<Usuario>{
    Usuario login(String user, String pass);
}
