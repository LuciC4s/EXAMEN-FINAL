/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.interfaces;

import java.util.List;
import org.model.ModelProducto;

public interface CrudProducto {

    public List listar(String buscar);

    public ModelProducto list(int id);

    public boolean insertar(ModelProducto idProducto);

    public boolean modificar(ModelProducto idProducto);

    public boolean eliminar(ModelProducto idProducto);

  
}
