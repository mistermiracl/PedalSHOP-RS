/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedalshop.dao.impl;

import pedalshop.dao.CompraDao;
import pedalshop.dao.CompraDetalleDao;
import pedalshop.dao.ProductoDao;
import pedalshop.dao.UsuarioDao;

/**
 *
 * @author User
 */
public class DaoFactory {
    
    private DaoFactory() {
    }
    
    public static DaoFactory getInstance() {
        return DaoFactoryHolder.INSTANCE;
    }
    
    private static class DaoFactoryHolder {
        private static final DaoFactory INSTANCE = new DaoFactory();
    }
    
    public UsuarioDao getUsuarioDao(){
        return new UsuarioDaoImpl();
    }
    
    public ProductoDao getProductoDao(){
        return new ProductoDaoImpl();
    }
    
    public CompraDao getCompraDao(){
        return new CompraDaoImpl();
    }
    
    public CompraDetalleDao getCompraDetalleDao(){
        return new CompraDetalleDaoImpl();
    }
    
}





