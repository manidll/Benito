/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.benito.utilerias;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *   Utileria de mostrar los datos y de abrir en la base de datos
 * @author Emmmanuel Rivas y Erick Garza
 */
public class HibernateUtil {
  
    /**
     * 
     */
  private static SessionFactory factory;
    private static ServiceRegistry serviceRegistry;

    static {
        try{
            Configuration configuration = new Configuration();
            configuration.configure();
            factory = configuration.buildSessionFactory();
        }catch(HibernateException ex){
                System.out.println("No se pudo crear la sesión de Hibernate debido al error: "+ex);
        }
    }
   
    public static SessionFactory getSessionFactory() {		
        return factory;
    }

    /**
     * Se obtiene la base de datos.
     * @param factory objeto pesado por lo que normalmente se crea durante la aplicación puesta en marcha y mantenido para su uso posterior.
     * @return La vinculacion con la base de datos.
     */
    public static void setSessionFactory(SessionFactory factory) {
            HibernateUtil.factory = factory;
    }

    /**
     * 
     * @return La vinculacion con la base de datos.
     */
    public static ServiceRegistry getServiceRegistry() {
            return serviceRegistry;
    }

    /**
     * Registra la base de datos vinculada.
     * @param serviceRegistry Es un depósito que actúa como registro
     * @return La vinculacion con la base de datos.
     */
    public static void setServiceRegistry(ServiceRegistry serviceRegistry) {
            HibernateUtil.serviceRegistry = serviceRegistry;
    }

    
}
