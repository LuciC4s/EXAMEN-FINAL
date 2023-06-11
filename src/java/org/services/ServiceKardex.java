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
        //List listar
        return lstKardex;
    }
}
