/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.services;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.inject.Produces;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.dao.DaoKardex;
import org.model.ModelKardex;


/**
 *
 * @author Lucia Pérez
 */
@WebService(serviceName = "ServiceKardex")
public class ServiceKardex {
    DaoKardex dao = new DaoKardex();


    @WebMethod(operationName = "listar")
    public List<ModelKardex> listar() {
        List lstKardex = dao.listar();
        return lstKardex;
    }
    
    @WebMethod(operationName = "insertar")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertar(@WebParam(name = "ID_USUARIO") int idUsr, @WebParam(name = "CANTIDAD") int cantidad ,@WebParam(name = "ID_PRODUCTO") int idProducto, @WebParam(name = "ID_TIPO_MOVIMIENTO") int idMov,  @WebParam(name = "DESCRIPCION") String descripcion) {
        ModelKardex modelKardex = new ModelKardex();
        modelKardex.setIdProducto(idProducto);
        modelKardex.setDesccripcion(descripcion);
        modelKardex.setCantidad(cantidad);
        modelKardex.setExistencia(1);
        modelKardex.setFecha("ServiceKardex");
        modelKardex.setIdTipoMovimiento(idMov);
        modelKardex.setIdUsuario(idUsr);
        boolean inserto = dao.insertar(modelKardex);
        //List listar
        return (inserto) ? Response.status(200).build() : Response.status(400).build();
    }
    
    @WebMethod(operationName = "update")
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
