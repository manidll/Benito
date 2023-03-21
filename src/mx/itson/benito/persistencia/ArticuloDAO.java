/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.benito.persistencia;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import mx.itson.benito.entidades.Articulo;
import mx.itson.benito.entidades.Proveedor;
import mx.itson.benito.utilerias.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * 
 * @author Emmanuel Rivas y Erick Garza
 */
public class ArticuloDAO {
 
    /**
     * Obtiene todos los registros de tipo Articulo de la base de datos
     * @return Lista de tipo Articulo de la base datos.
     */
     public static List<Articulo> obtenerTodos(){
        List<Articulo> articulos = new ArrayList<>();
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaQuery<Articulo> criteriaQuery  = session.getCriteriaBuilder().createQuery(Articulo.class);
            criteriaQuery.from(Articulo.class);
            
            articulos = session.createQuery(criteriaQuery).getResultList();

        }catch(Exception ex){
            System.err.println("Ocurrio un error" + ex.getMessage());
        }
             return articulos;   
    }
     
     /**
      * Guarda un nuevo registro de tipo Articulo de la base de datos
      * @param nombre nombre del articulo
      * @param clave clave del articulo
      * @param precio precio del articulo
      * @param proveedor proveedor del articulo
      * @return Retorna true si el registro fue guardado correctamente; De lo contrario, retorna false
      */
         public static boolean guardar (String nombre, String clave, double precio, Proveedor proveedor){
   
        boolean resultado = false;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            Articulo a = new Articulo();
            a.setNombre(nombre);
            a.setClave(clave);
            a.setPrecio(precio);
            a.setProveedor(proveedor);
         
         
            
            session.save(a);        
            session.getTransaction().commit();
            
            resultado = a.getId() !=0;
            
        }catch (Exception ex){
            System.err.println("Ocurrio un error" + ex.getMessage());
            
        }
        return resultado;
        
    }
         
         /**
          * Obtiene los registros de tipo Articulo por id en la base de datos
          * @param id del Articulo
          * @return 
          */
         public static Articulo obtenerPorId(int id ){
        Articulo articulo = null;
        try {
             Session session = HibernateUtil.getSessionFactory().openSession();
             articulo = session.get(Articulo.class, id);
             
            
        } catch (HibernateException ex) {
            System.err.println("Ocurrio un erro " + ex.getMessage());
        
            
        }
        return articulo;
    }
         
         /**
          * Edita un registro de tipo Articulo en la base de datos.
          * @param id id del articulo
          * @param clave clave del articulo
          * @param precio precio del articulo
          * @param proveedor proveedor del articulo
          * @return El registro se edita en la base de datos
          */
     public  static boolean editar ( int id, String clave, double precio, Proveedor proveedor){
        boolean resultado  = false;
    try {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    Articulo articulo = obtenerPorId(id);
    if(articulo != null){      
       articulo.setNombre(clave);
       articulo.setClave(clave);
       articulo.setPrecio(precio);
       articulo.setProveedor(proveedor);
        
        session.saveOrUpdate(articulo);
        session.getTransaction().commit();
        resultado = true;
    }
    
         
        } catch (HibernateException ex) {
            System.err.println("Ocurrio un erro " + ex.getMessage());
        
           
        }
      return resultado;
}
     
     /**
     * Elimina un registro de tipo Articulo en la base de datos mediante id
     * @param id id del Articulo
     * @return El registro se elimina
     */
     public boolean eliminar (int id ){
    
    boolean resultado  = false;
    
     try {
          Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    Articulo articulo = obtenerPorId(id);
    if(articulo != null){
        session.delete(articulo);
        session.getTransaction().commit();
        resultado = true;
    }

         } catch (HibernateException ex) {
            System.err.println("Ocurrio un erro " + ex.getMessage());
        
           
        }
      return resultado;
     }
    
}
