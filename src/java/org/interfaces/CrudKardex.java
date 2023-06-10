/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.interfaces;

import java.util.List;
import org.model.ModelUsuario;

/**
 *
 * @author josef
 */
public interface CrudKardex {

    public List listar(String buscar);

    public ModelUsuario list(int id);

    public boolean insertar(ModelUsuario usuario);

    public boolean modificar(ModelUsuario usuario);

    public boolean eliminar(ModelUsuario usuario);

    public boolean validarusuario(ModelUsuario usuario);
}
