/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.benito.persistencia;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import mx.itson.benito.entidades.Articulo;
import mx.itson.benito.entidades.OrdenCompra;
import mx.itson.benito.entidades.Proveedor;
import mx.itson.benito.utilerias.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Emmanuel Rivas y Erick Garza
 */
public class OrdenCompraDAO {
    /**
     * Obtiene todos los registros de tipo OrdenCompra de la base de datos
     * @return Lista de tipo OrdenCompra de la base datos.
     */
     public static List<OrdenCompra> obtenerTodos(){
        List<OrdenCompra> ordeCompras= new ArrayList<>();
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaQuery<OrdenCompra> criteriaQuery  = session.getCriteriaBuilder().createQuery(OrdenCompra.class);
            criteriaQuery.from(OrdenCompra.class);
            
            ordeCompras = session.createQuery(criteriaQuery).getResultList();

        }catch(Exception ex){
            System.err.println("Ocurrio un error" + ex.getMessage());
        }
             return ordeCompras;   
    }
 
     /**
      * Guarda un nuevo registro de tipo OrdenCompra de la base de datos
      * @param observacion observaciones de la orden de compra
      * @param folio folio de la orden de compra
      * @param fecha fecha de generacion de la orden de compra
      * @param proveedor proveedor del articulo en la orden de compra
      * @param articulo articulo de la orden de compra
      * @param carrito cantidad de articulos
      * @param estado estado de la orden de compra
      * @return Retorna true si el registro fue guardado correctamente; De lo contrario, retorna false
      */
     
       public static boolean guardar (String observacion, String folio, Date fecha, Proveedor proveedor ,  Articulo articulo, int carrito, String estado ){
   
        boolean resultado = false;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            OrdenCompra o = new OrdenCompra();
            o.setObservacion(observacion);
            o.setFolio(folio);
            o.setFecha(fecha);
            o.setProveedor(proveedor);
            o.setArticulo(articulo);
            o.setCarrito(carrito);
            o.setEstado(estado);
      
         
            
            session.save(o);        
            session.getTransaction().commit();
            
            resultado = o.getId() !=0;
            
        }catch (Exception ex){
            System.err.println("Ocurrio un error" + ex.getMessage());
            
        }
        return resultado;
        
    }
       /**
        * Obtiene los registros de tipo OrdenCompra por id en la base de datos
        * @param id id de la orden de compra
        * @return 
        */
           public static OrdenCompra obtenerPorId(int id ){
        OrdenCompra ordenCompra = null;
        try {
             Session session = HibernateUtil.getSessionFactory().openSession();
             ordenCompra = session.get(OrdenCompra.class, id);
             
            
        } catch (HibernateException ex) {
            System.err.println("Ocurrio un erro " + ex.getMessage());
        
            
        }
        return ordenCompra;
    }
      
    /**
     * Edita un registro de tipo OrdenCompra en la base de datos.
     * @param id id de la orden de compra
     * @param observacion observaciones de las ordenes de compra
     * @param folio folio de las ordenes de compra
     * @param fecha fecha de generacion de las ordenes de compra
     * @param proveedor proveedores de las ordenes de compra
     * @param articulo articulos de las ordenes de compra
     * @param carrito cantidad de articulos de las ordenes de compra
     * @param estado estado de las ordenes de compra
     * @return El registro se edita en la base de datos
     */       
     public  static boolean editar ( int id, String observacion, String folio, Date fecha, Proveedor proveedor ,  Articulo articulo,  int carrito, String estado ){
        boolean resultado  = false;
    try {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    OrdenCompra ordenCompra = obtenerPorId(id);
    if(ordenCompra != null){      
       ordenCompra.setId(id);
       ordenCompra.setObservacion(observacion);
       ordenCompra.setFolio(folio);
       ordenCompra.setFecha(fecha);
       ordenCompra.setProveedor(proveedor);
       ordenCompra.setArticulo(articulo);
       ordenCompra.setCarrito(carrito);
       ordenCompra.setEstado(estado);
        
        
        session.saveOrUpdate(ordenCompra);
        session.getTransaction().commit();
        resultado = true;
    }
    
        } catch (HibernateException ex) {
            System.err.println("Ocurrio un error " + ex.getMessage());
 
        }
      return resultado;
}
     
     /**
      * Elimina un registro de tipo OrdenCompra en la base de datos mediante id
      * @param id id de la orden de compra
      * @return El registro se elimina
      */
    public boolean eliminar (int id ){
     boolean resultado  = false;
    
     try {
          Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    OrdenCompra ordenCompra = obtenerPorId(id);
    if(ordenCompra != null){
        session.delete(ordenCompra);
        session.getTransaction().commit();
        resultado = true;
    }
         
         
         } catch (HibernateException ex) {
            System.err.println("Ocurrio un error " + ex.getMessage());
        
           
        }
      return resultado;
     }      
    
}
