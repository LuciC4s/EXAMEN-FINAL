/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.interfaces;

import java.util.List;
import org.model.ModelTipoMovimiento;


public interface CrudTipoMovimiento {

    public List listar(String buscar);

    public ModelTipoMovimiento list(int id);

    public boolean insertar(ModelTipoMovimiento idTipoMovimiento);

    public boolean modificar(ModelTipoMovimiento idTipoMovimiento);

    public boolean eliminar(ModelTipoMovimiento idTipoMovimiento);

  
}
