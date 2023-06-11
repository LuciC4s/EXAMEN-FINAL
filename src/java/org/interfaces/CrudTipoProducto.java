/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.interfaces;

import java.util.List;
import org.model.ModelTipoProducto;

public interface CrudTipoProducto {

    public List listar(String buscar);

    public ModelTipoProducto list(int id);

    public boolean insertar(ModelTipoProducto idTipoProducto);

    public boolean modificar(ModelTipoProducto idTipoProducto);

    public boolean eliminar(ModelTipoProducto idTipoProducto);

  
}
