/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.benito.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Obtiene todo los registros de Proveedor de la base de datos.
 * @author Emmanuel Rivas y Erick Garza
 */
@Entity
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String clave;
    private String nombre;
     private String contacto;
    private String telefono;
    private String correo;
    private String direccion;

    /**
     * Get and set Id
     * @return Id del proveedor
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get and set Clave
     * @return Clave del proveedor
     */
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * Get and set Nombre
     * @return Nombre del Proveedor (empresa)
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Get and set Contacto
     * @return Contacto del proveedor
     */
    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    /**
     * Get and set Telefono
     * @return Telefono del proveedor
     */
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Get and set Correo
     * @return Correo del proveedor 
     */
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Get and set Direccion
     * @return Direccion del proveedor
     */
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
      @Override
    public String toString(){
        return this.nombre;
    }
}
