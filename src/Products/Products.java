/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Products;

import Conexion.Conexion;
import Modelo.Producto;
import interfaces.Metodo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LN710Q
 */
public class Products implements Metodo <Producto>{
    //cambiar los insertar para mi db
    private static final String SQL_INSERT = "INSERT INTO filtros_aceite (codFiltro, marca,stock,existencia) VALUES(?,?,?,?)" ;
    private static final String SQL_UPDATE = "UPDATE filtros_aceite SET marca=? , stock=?, existencia=? WHERE codFiltro=?" ;
    private static final String SQL_DELETE = "DELETE from filtros_aceite WHERE codFiltro=?";
    private static final String SQL_READ = "SELECT * FROM filtros_aceite WHERE codFiltro=?";
    private static final String SQL_READALL = "SELECT * FROM filtros_aceite";
    private static final Conexion con = Conexion.conectar();

    @Override
    public boolean create(Producto g) {
                PreparedStatement ps;
        try{
            ps = con.getCnx().prepareStatement(SQL_INSERT);
            ps.setInt(1, g.getId());
            ps.setString(2, g.getNombre());
            ps.setString(3, g.getTipo());
            ps.setFloat(4, g.getPrecio());
            ps.setInt(5, g.getCantidad());
            ps.setBoolean(6, true);
            if(ps.executeUpdate() > 0){
                return true;
            }
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE,null,ex) ;
            } finally{
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean delete(Object key) {
                    
        PreparedStatement ps;
        try{
            ps= con.getCnx().prepareStatement(SQL_DELETE);
            ps.setString(1, key.toString());
            
            if(ps.executeUpdate() >0){
                return true;
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE,null,ex);
            }finally{
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(Producto c) {
                PreparedStatement ps;
        try{
            System.out.println(c.getId());
            ps= con.getCnx().prepareStatement(SQL_UPDATE);
            ps.setInt(1, c.getId());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getTipo());
            ps.setFloat(4, c.getPrecio());
            ps.setInt(5, c.getCantidad());
            ps.setBoolean(6, true);
            
            if(ps.executeUpdate() >0){
                return true;
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE,null,ex);
            }finally{
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public Producto read(Object key) {
                Producto f=null;
        PreparedStatement ps;
        ResultSet rs;
        try{
            ps= con.getCnx().prepareStatement(SQL_READ);
            ps.setString(1,key.toString());
            
            rs=ps.executeQuery();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE,null,ex);
        }finally{
            con.cerrarConexion();
        }
        return f;
    }

    @Override
    public ArrayList<Producto> readAll() {
                ArrayList<Producto> all = new ArrayList();
        Statement s;
        ResultSet rs;
        try{
            s= con.getCnx().prepareStatement(SQL_READALL);
            rs = s.executeQuery(SQL_READALL);
            while(rs.next()){
                all.add(new Producto(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getFloat(4),rs.getInt(5),rs.getBoolean(6)));
            }
            rs.close();
        }catch(SQLException ex){
           Logger.getLogger(Products.class.getName()).log(Level.SEVERE,null,ex);
        }
        return all;
    }
    
}
