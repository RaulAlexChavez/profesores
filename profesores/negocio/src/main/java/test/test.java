/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import mx.alesco.entidad.Profesor;
import mx.alesco.entidad.UnidadDeAprendizaje;
import mx.alesco.integracion.ServiceFacadeLocator;

/**
 *
 * @author lukki
 */
public class test {
    public static void main(String[] args) {
        
        System.out.println("----- NEGOCIO ------");
        
        Profesor profe = null;
        // El try catch no funciona, no cacha excepciones
        try {
            profe = ServiceFacadeLocator.getInstanceFacadeProfesor().consultaProfesor.porID(2);
        } catch(Exception ex){
            System.out.println("Error");
        }
        
        if(profe !=  null) {
            System.out.println("ID Profesor: " + profe.getIdprofesor());
            System.out.println("Nombre: " + profe.getNombre());
            System.out.println("Apellido: " + profe.getApellido());
            System.out.println("RFC: " + profe.getRfc());
            System.out.println("Cantidad de materias que imparte: " + profe.getUnidadDeAprendizajeList().size());
            System.out.println();
        }
        else {
            System.out.println("Profe no encontrado.");
        }
        
        UnidadDeAprendizaje ua = ServiceFacadeLocator.getInstanceFacadeUnidadDeAprendizaje().consultaUA.porID(1);
        
        System.out.println("ID UA: " + ua.getIdunidadDeAprendizaje());
        System.out.println("Nombre UA: " + ua.getNombreUA());
        System.out.println("HC: " + ua.getHorasClase());
        System.out.println("HT: " + ua.getHorasTaller());
        System.out.println("HL: " + ua.getHorasLaboratorio());

        System.out.println("Cantidad de profesores que imparten la UA: " + ua.getProfesorList().size());
        System.out.println();
    }
}