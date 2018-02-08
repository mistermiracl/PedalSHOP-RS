/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedalshop.dao.impl;

import pedalshop.dao.CompraDetalleDao;
import pedalshop.entity.CompraDetalle;

/**
 *
 * @author User
 */
class CompraDetalleDaoImpl extends AbstractEntity<CompraDetalle> implements CompraDetalleDao{
    CompraDetalleDaoImpl(){
        super(CompraDetalle.class);
    }
}
