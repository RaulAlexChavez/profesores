/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import java.util.List;
import mx.alesco.DAO.UnidadDeAprendizajeDAO;
import mx.alesco.DAO.ProfesorDAO;
import mx.alesco.entidad.Profesor;
import mx.alesco.entidad.UnidadDeAprendizaje;


/**
 *
 * @author lukki
 */
public class test {
    public static void main(String[] args) {
        consultaProfesores();
    }
    
    public static void consultaProfesores() {
        List<Profesor> listaProfesores = new ArrayList();
        ProfesorDAO profesorDAO = new ProfesorDAO();
        listaProfesores = profesorDAO.findAll();
        
        System.out.println("Consulta Profesores:\n");
        boolean noProfes = true;
        for(Profesor profe : listaProfesores) {
            noProfes = false;
            System.out.println("Nombre: " + profe.getNombre());
            System.out.println("Apellido: " + profe.getApellido());
            System.out.println("RFC: " + profe.getRfc());
            System.out.println("Cantidad de materias que imparte: " + profe.getUnidadDeAprendizajeList().size());
            System.out.println();
        }
        if(noProfes) {
            System.out.println("No hay profesores registrados.");
        }
    }
    
}
