/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.services;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import org.dao.DaoKardex;
import org.model.ModelKardex;


/**
 *
 * @author Lucia Pérez
 */
@WebServlet("/ServiceKardex")
public class ServiceKardex extends HttpServlet{
    DaoKardex dao = new DaoKardex();


    @WebMethod(operationName = "listar")
    public List<ModelKardex> listar() {
        List lstKardex = dao.listar();
        return lstKardex;
    }
    
    @WebMethod(operationName = "insertar")
    public boolean insertar(@WebParam(name = "ID_USUARIO") int idUsr, @WebParam(name = "CANTIDAD") int cantidad ,@WebParam(name = "ID_PRODUCTO") int idProducto, @WebParam(name = "ID_TIPO_MOVIMIENTO") int idMov,  @WebParam(name = "DESCRIPCION") String descripcion) {
        ModelKardex modelKardex = new ModelKardex();
        modelKardex.setIdProducto(idProducto);
        modelKardex.setDesccripcion(descripcion);
        modelKardex.setCantidad(cantidad);
        modelKardex.setExistencia(1);
        modelKardex.setFecha("2023-10-06 00:00:00.0");
        modelKardex.setIdTipoMovimiento(idMov);
        modelKardex.setIdUsuario(idUsr);
        boolean inserto = dao.insertar(modelKardex);
        //List listar
        return inserto;
    }
    
    
    public boolean update(@WebParam(name = "ID_KARDEX") int idKardex, @WebParam(name = "ID_USUARIO") int idUsr, @WebParam(name = "ID_PRODUCTO") int idProducto, @WebParam(name = "ID_TIPO_MOVIMIENTO") int idMov, @WebParam(name = "CANTIDAD") int cantidad, @WebParam(name = "EXISTENCIA") int existencia, @WebParam(name = "SALDO") double saldo, @WebParam(name = "DESCRIPCION") String descripcion, @WebParam(name = "FECHA") String fecha) {
        ModelKardex modelKardex = new ModelKardex();
        
        modelKardex.setIdProducto(idKardex);
        modelKardex.setIdProducto(idProducto);
        modelKardex.setDesccripcion(descripcion);
        modelKardex.setCantidad(cantidad);
        modelKardex.setExistencia(existencia);
        modelKardex.setFecha(fecha);
        modelKardex.setIdTipoMovimiento(idMov);
        modelKardex.setIdUsuario(idUsr);
        
        boolean updateKardex = dao.modificar(modelKardex);
        //List listar
        return updateKardex;
    }
    
     @WebMethod(operationName = "delete")
    public boolean delete(@WebParam(name = "ID_KARDEX") int idKardex) {
        ModelKardex modelKardex = new ModelKardex();
        modelKardex.setIdKardex(idKardex);
        
        boolean delKardex = dao.eliminar(modelKardex);
        //List listar
        return delKardex;
    }
    
    
    
    
}
