/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedalshop.dao;

import java.util.List;

/**
 *
 * @author User
 */
interface EntityDao<T> {
    boolean create(T toInsert);
    boolean update(T toUpdate);
    boolean delete(Object id);
    T find(Object id);
    List<T> findAll();
}
