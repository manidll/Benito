/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.benito.persistencia;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import mx.itson.benito.entidades.Proveedor;
import mx.itson.benito.utilerias.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Emmanuel Rivas y Erick Garza
 */
public class ProveedorDAO {
    
    /**
     * Obtiene todos los registros de tipo Proveedor de la base de datos
     * @return Lista de tipo Proveedor de la base datos.
     */
     public static List<Proveedor> obtenerTodos(){
        List<Proveedor> Proveedor = new ArrayList<>();
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaQuery<Proveedor> criteriaQuery  = session.getCriteriaBuilder().createQuery(Proveedor.class);
            criteriaQuery.from(Proveedor.class);
            
            Proveedor = session.createQuery(criteriaQuery).getResultList();

        }catch(Exception ex){
            System.err.println("Ocurrio un error" + ex.getMessage());
        }
             return Proveedor;   
    }
    
     /**
      *  /**
      * Guarda un nuevo registro de tipo Proveedor de la base de datos
      * @param nombre nombre del proveedor (empresa)
      * @param clave clave del proveedor
      * @param contacto contacto del proveedor (trabajador)
      * @param telefono telefono del contacto
      * @param correo cprreo del proveedor
      * @param direccion direccion del proveedor
      * @return Retorna true si el registro fue guardado correctamente; De lo contrario, retorna false
      */
       public static boolean guardar (String nombre, String clave, String contacto, String telefono, String correo, String direccion){
   
        boolean resultado = false;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            Proveedor p = new Proveedor();
            p.setNombre(nombre);
            p.setClave(clave);
            p.setContacto(contacto);
            p.setTelefono(telefono);
            p.setCorreo(correo);
            p.setDireccion(direccion);

            session.save(p);        
            session.getTransaction().commit();
            
            resultado = p.getId() !=0;
            
        }catch (Exception ex){
            System.err.println("Ocurrio un error" + ex.getMessage());
            
        }
        return resultado;
        
    }
     
       /**
        * Obtiene los registros de tipo Proveedor por id en la base de datos
        * @param id id del proveedor
        * @return 
        */
      public static Proveedor obtenerPorId(int id ){
        Proveedor proveedor = null;
        try {
             Session session = HibernateUtil.getSessionFactory().openSession();
             proveedor = session.get(Proveedor.class, id);
             
            
        } catch (HibernateException ex) {
            System.err.println("Ocurrio un error " + ex.getMessage());
        
            
        }
        return proveedor;
    }
     
     /**
      * Edita un registro de tipo Proveedor en la base de datos.
      * @param id id del proveedor
      * @param nombre nombre del proveedor (empresa)
      * @param clave clave del proveedor
      * @param contacto contacto del proveedor
      * @param telefono telefono del proveedor
      * @param correo correo del proveedor
      * @param direccion direccion del proveedor
      * @return El registro se edita en la base de datos
      */    
     public  static boolean editar ( int id, String nombre, String clave, String contacto, String telefono, String correo, String direccion){
        boolean resultado  = false;
    try {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    Proveedor proveedor = obtenerPorId(id);
    if(proveedor != null){      
     proveedor.setNombre(nombre);
     proveedor.setClave(clave);
     proveedor.setContacto(contacto);
     proveedor.setTelefono(telefono);
     proveedor.setCorreo(correo);
     proveedor.setDireccion(direccion);
        
        session.saveOrUpdate(proveedor);
        session.getTransaction().commit();
        resultado = true;
    }
    
        } catch (HibernateException ex) {
            System.err.println("Ocurrio un erro " + ex.getMessage());
        
           
        }
      return resultado;
    }
     
     /**
      * Elimina un registro de tipo Proveedor en la base de datos mediante id
      * @param id id del proveedor
      * @return El registro se elimina
      */
      public boolean eliminar (int id ){
    
    boolean resultado  = false;
    
     try {
          Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    Proveedor proveedor = obtenerPorId(id);
    if(proveedor != null){
        session.delete(proveedor);
        session.getTransaction().commit();
        resultado = true;
    }
         
         } catch (HibernateException ex) {
            System.err.println("Ocurrio un erro " + ex.getMessage());
        
           
        }
      return resultado;
     }
    
    
    
}
