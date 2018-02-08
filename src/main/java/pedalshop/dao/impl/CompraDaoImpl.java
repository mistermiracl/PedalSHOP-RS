/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedalshop.dao.impl;

import pedalshop.dao.CompraDao;
import pedalshop.entity.Compra;

/**
 *
 * @author User
 */
class CompraDaoImpl extends AbstractEntity<Compra> implements CompraDao{
    CompraDaoImpl(){
        super(Compra.class);
    }
}
