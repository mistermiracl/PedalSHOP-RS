/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedalshop.dao.impl;

import pedalshop.dao.ProductoDao;
import pedalshop.entity.Producto;

/**
 *
 * @author User
 */
class ProductoDaoImpl extends AbstractEntity<Producto> implements ProductoDao{
    public ProductoDaoImpl(){
        super(Producto.class);
    }
}
