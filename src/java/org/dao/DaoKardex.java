/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.config.Conexion;
import org.interfaces.CrudKardex;
import org.model.ModelKardex;

/**
 *
 * @author Lucia Pérez
 */
public class DaoKardex implements CrudKardex {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conexion = new Conexion();   
    String strSql =  "";

    @Override
    public List listar() {
        ArrayList<ModelKardex> lstKardex = new ArrayList<>();
        try {

            strSql = "SELECT * FROM KARDEX";

            conexion.open();
            rs = conexion.executeQuery(strSql);

            while (rs.next()) {
                ModelKardex kdx = new ModelKardex();
                kdx.setIdKardex(rs.getInt("ID_KARDEX"));
                kdx.setIdUsuario(rs.getInt("ID_USUARIO"));
                kdx.setIdProducto(rs.getInt("ID_PRODUCTO"));
                kdx.setIdTipoMovimiento(rs.getInt("ID_TIPO_MOVIMIENTO"));
                kdx.setCantidad(rs.getInt("CANTIDAD"));
                kdx.setExistencia(rs.getInt("EXISTENCIA"));
                kdx.setSaldo(rs.getInt("SALDO"));
                kdx.setDesccripcion(rs.getString("DESCRIPCION"));
                kdx.setFecha(rs.getInt("FECHA"));

                lstKardex.add(kdx);
            }
            rs.close();
            conexion.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoKardex.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoKardex.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lstKardex;
    }

    @Override
    public ModelKardex list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertar(ModelKardex idKardex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(ModelKardex idKardex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(ModelKardex idKardex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
