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
import org.model.ModelUsuario;

/**
 *
 * @author Lucia Pérez
 */
public class DaoKardex implements CrudKardex {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conexion = new Conexion();
    String strSql = "";
    boolean respuesta = false;

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
                kdx.setFecha(rs.getString("FECHA"));

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
        ModelKardex kdx = new ModelKardex();
        try {
            strSql = "SELECT * FROM KARDEX WHERE ID_KARDEX = " + id;
            conexion.open();
            rs = conexion.executeQuery(strSql);

            while (rs.next()) {

                kdx.setIdKardex(rs.getInt("ID_KARDEX"));
                kdx.setIdUsuario(rs.getInt("ID_USUARIO"));
                kdx.setIdProducto(rs.getInt("ID_PRODUCTO"));
                kdx.setIdTipoMovimiento(rs.getInt("ID_TIPO_MOVIMIENTO"));
                kdx.setCantidad(rs.getInt("CANTIDAD"));
                kdx.setExistencia(rs.getInt("EXISTENCIA"));
                kdx.setSaldo(rs.getInt("SALDO"));
                kdx.setDesccripcion(rs.getString("DESCRIPCION"));
                kdx.setFecha(rs.getString("FECHA"));

            }
            rs.close();
            conexion.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoKardex.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoKardex.class.getName()).log(Level.SEVERE, null, ex);
        }

        return kdx;
    }

    @Override
    public boolean insertar(ModelKardex idKardex) {
        //Se prepara la sentencia SQL a ejecutar en la BD

        String strSql = "INSERT INTO KARDEX (ID_KARDEX, ID_USUARIO, ID_PRODUCTO, ID_TIPO_MOVIMIENTO, CANTIDAD,EXISTENCIA,SALDO,DESCRIPCION,FECHA) "
                + "VALUES ( (SELECT ISNULL(MAX(ID_KARDEX),0) + 1 FROM KARDEX), "
                + "'" + idKardex.getIdUsuario() + "', "
                + "'" + idKardex.getIdProducto() + "', "
                + "'" + idKardex.getIdTipoMovimiento() + "', "
                + "'" + idKardex.getCantidad() + "', "
                + "'" + idKardex.getExistencia() + "', "
                + "'" + idKardex.getSaldo() + "', "
                + "'" + idKardex.getDesccripcion() + "', "
                + "'" + idKardex.getFecha() + "' "
                + ")";

        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);

            //Se cierra la conexión hacia la BD
            conexion.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoKardex.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(DaoKardex.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public boolean modificar(ModelKardex idKardex) {
        //Se prepara la sentencia SQL a ejecutar en la BD
        String strSql2 = "UPDATE KARDEX "
                + "SET "
                //  + "ID_KARDEX = '" + idKardex.getIdKardex()+ "', "
                + "ID_USUARIO = '" + idKardex.getIdUsuario() + "', "
                + "ID_PRODUCTO = '" + idKardex.getIdProducto() + "', "
                + "ID_TIPO_MOVIMIENTO = '" + idKardex.getIdTipoMovimiento() + "', "
                + "CANTIDAD = '" + idKardex.getCantidad() + "', "
                + "EXISTENCIA = '" + idKardex.getExistencia() + "', "
                + "SALDO = '" + idKardex.getSaldo() + "', "
                + "DESCRIPCION = '" + idKardex.getDesccripcion() + "', "
                + "FECHA = '" + idKardex.getFecha() + "'"
                + " WHERE ID_KARDEX =  " + idKardex.getIdKardex();
                System.out.println("strSql2 = " + strSql2);
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria

            respuesta = conexion.executeSql(strSql2);

            //Se cierra la conexión hacia la BD
            conexion.close();

        } catch (ClassNotFoundException ex) {

            Logger.getLogger(DaoKardex.class.getName()).log(Level.SEVERE, null, ex);
            respuesta = false;
        } catch (Exception ex) {

            respuesta = false;
            Logger.getLogger(DaoKardex.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public boolean eliminar(ModelKardex idKardex) {
        //Se prepara la sentencia SQL a ejecutar en la BD

        strSql = "DELETE KARDEX WHERE  ID_KARDEX = " + idKardex.getIdKardex();


        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria

            //respuesta = conexion.executeSql(sql);
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD

            conexion.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoKardex.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(DaoKardex.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

}
