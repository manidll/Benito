/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.benito.enumeradores;

/**
 *
 * @author mane0
 */
public enum Estado {
    
    ABIERTA(1),
    CERRADA(2);
    
    private int numero;
    Estado(int numero){
    this.numero = numero;
}
    
}
