/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.interfaces;

import java.util.List;
import org.model.ModelKardex;


public interface CrudKardex {

    public List listar();

    public ModelKardex list(int id);

    public boolean insertar(ModelKardex idKardex);

    public boolean modificar(ModelKardex idKardex);

    public boolean eliminar(ModelKardex idKardex);

  
}
