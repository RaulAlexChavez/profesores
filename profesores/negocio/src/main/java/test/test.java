/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import mx.alesco.entidad.Profesor;
import mx.alesco.integracion.ServiceFacadeLocator;

/**
 *
 * @author lukki
 */
public class test {
    public static void main(String[] args) {        
        Profesor profe = new Profesor();
        profe.setIdprofesor(1);
        profe = ServiceFacadeLocator.getInstanceFacadeProfesor().consultarProfesor(profe);
        System.out.println("Profe");
        
        System.out.println("----- NEGOCIO ------");
        System.out.println("ID Profesor: " + profe.getIdprofesor());
        System.out.println("Nombre: " + profe.getNombre());
        System.out.println("Apellido: " + profe.getApellido());
        System.out.println("RFC: " + profe.getRfc());
        System.out.println("Cantidad de materias que imparte: " + profe.getUnidadDeAprendizajeList().size());
        System.out.println();
    }
}
