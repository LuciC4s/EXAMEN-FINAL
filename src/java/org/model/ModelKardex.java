/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.model;

/**
 *
 * @author Lucia Pérez
 */
public class ModelKardex {
    private int idKardex;
    private int idUsuario;
    private int idProducto;
    private int idTipoMovimiento;
    private int cantidad;
    private int existencia;
    private int saldo;
    private String desccripcion;
    private int fecha;

    public int getIdKardex() {
        return idKardex;
    }

    public void setIdKardex(int idKardex) {
        this.idKardex = idKardex;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdTipoMovimiento() {
        return idTipoMovimiento;
    }

    public void setIdTipoMovimiento(int idTipoMovimiento) {
        this.idTipoMovimiento = idTipoMovimiento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public String getDesccripcion() {
        return desccripcion;
    }

    public void setDesccripcion(String desccripcion) {
        this.desccripcion = desccripcion;
    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    public ModelKardex(int idKardex, int idUsuario, int idProducto, int idTipoMovimiento, int cantidad, int existencia, int saldo, String desccripcion, int fecha) {
        this.idKardex = idKardex;
        this.idUsuario = idUsuario;
        this.idProducto = idProducto;
        this.idTipoMovimiento = idTipoMovimiento;
        this.cantidad = cantidad;
        this.existencia = existencia;
        this.saldo = saldo;
        this.desccripcion = desccripcion;
        this.fecha = fecha;
    }

    public ModelKardex() {
    }
    
    
}
