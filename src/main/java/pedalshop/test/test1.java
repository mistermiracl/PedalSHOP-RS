/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedalshop.test;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import pedalshop.dao.ProductoDao;
import pedalshop.dao.UsuarioDao;
import pedalshop.dao.impl.DaoFactory;
import pedalshop.entity.Producto;
import pedalshop.entity.Usuario;
import pedalshop.util.DatabaseConnection;
import pedalshop.util.Util;

/**
 *
 * @author User
 */
public class test1 {
    public static void main(String[] args) {
        System.out.println(Util.RESULT_CODE_ERROR + " " + Util.RESULT_CODE_OK + " " + Util.RESULT_CODE_WARNING);
        /*String sql = "SELECT TABLENAME FROM SYS.SYSTABLES";
        try(Connection conn = DatabaseConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql)){
        
        while(rs.next())
        System.out.println("TABLE NAME - " + rs.getString(1));
        
        } catch(SQLException x){
        System.out.println(x);
        }*/
        
        ProductoDao pro = DaoFactory.getInstance().getProductoDao();
        UsuarioDao uss = DaoFactory.getInstance().getUsuarioDao();
        
        /*Producto[] pros = {
        new Producto("EHX Super Pulsar", "", new BigDecimal("233.33"), ""),
        new Producto("Electro Harmonix Organ", "", new BigDecimal("322.1"), ""),
        new Producto("Earthquaker Devices Disaster", "", new BigDecimal("98.3"), ""),
        };
        for(Producto p : pros)
        pro.create(p);*/
        //for(Producto p : pro.findAll())
            //System.out.printf("%s - %e\n", p.getNombre(), p.getPrecio());//%a hex(not bigdec) - %g(sci if too large) - %e(always sci) - %f(right value)
        
        Usuario user = new Usuario();
        user.setUsername("root");
        user.setPassword("root");
        user.setNombre("root");
        user.setApellido("root");
        user.setEmail("root");
        
        uss.delete(1);
        //uss.create(user);
        
        Usuario newusr = uss.login(user.getUsername(), user.getPassword());
        
        System.out.printf("%d - %s\n", newusr.getUserid(), newusr.getUsername());
    }
}
