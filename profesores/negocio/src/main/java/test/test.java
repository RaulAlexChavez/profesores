/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.List;
import mx.alesco.entidad.Profesor;
import mx.alesco.entidad.UnidadDeAprendizaje;
import mx.alesco.integracion.ServiceFacadeLocator;

/**
 *
 * @author RaúL Alex Chávez
 */
public class test {
    public static void main(String[] args) {
        
        System.out.println("----- NEGOCIO ------");
        
        // ALTA UA //
        /*consultaUA(11293);
        altaUA();
        consultaUA(11293);*/
        
        // ALTA PROFESOR //
        consultaProfesor(9898);
        altaProfesor();
        consultaProfesor(9898);
        
        // CONSULTA PROFES Y UAS //
        /*consultaProfesores();
        consultaUAs();*/
        
        // BORRAR PROFESOR //
        /*altaProfesor();
        consultaProfesor(9898);
        borrarProfesor(9898);
        consultaProfesor(9898);*/
        
        // MODIFCIAR PROFESOR //
        /*consultaProfesor(9898);
        modificarProfesor();
        consultaProfesor(9898);*/
    }
    
    public static void consultaProfesor(int id) {
        Profesor profe = null;
        // El try catch no funciona, no cacha excepciones
        try {
            profe = ServiceFacadeLocator.getInstanceFacadeProfesor().consultaProfesor.porID(id);
        } catch(Exception ex){
            System.out.println("Error");
        }
        
        if(profe !=  null) {
            System.out.println("ID Profesor: " + profe.getIdprofesor());
            System.out.println("Nombre: " + profe.getNombre());
            System.out.println("Apellido: " + profe.getApellido());
            System.out.println("RFC: " + profe.getRfc());
            System.out.println("Cantidad de materias que imparte: " + profe.getUnidadDeAprendizajeList().size());
            for(UnidadDeAprendizaje ua : profe.getUnidadDeAprendizajeList()) {
                System.out.println(ua.getNombreUA());
            }
            System.out.println();
        }
        else {
            System.out.println("Profe no encontrado.");
        }
    }
    
    public static void consultaProfesores() {
        List<Profesor> profesores = ServiceFacadeLocator.getInstanceFacadeProfesor().consultaProfesor.todos();

        boolean noHayProfes = true;
        for(Profesor profe : profesores){
            noHayProfes = false;
            System.out.println("ID Profesor: " + profe.getIdprofesor());
            System.out.println("Nombre: " + profe.getNombre());
            System.out.println("Apellido: " + profe.getApellido());
            System.out.println("RFC: " + profe.getRfc());
            System.out.println("Cantidad de materias que imparte: " + profe.getUnidadDeAprendizajeList().size());
            for(UnidadDeAprendizaje ua : profe.getUnidadDeAprendizajeList()) {
                System.out.println(ua.getNombreUA());
            }
            System.out.println();
        }
        
        if(noHayProfes) {
            System.out.println("No hay profesores registrados.");
        }
    }
    
    public static void consultaUAs() {
        List<UnidadDeAprendizaje> uas = ServiceFacadeLocator.getInstanceFacadeUnidadDeAprendizaje().consultaUA.todos();

        boolean noHayUAs = true;
        for(UnidadDeAprendizaje ua : uas){
            noHayUAs = false;
            System.out.println("ID UA: " + ua.getIdunidadDeAprendizaje());
            System.out.println("Nombre UA: " + ua.getNombreUA());
            System.out.println("HC: " + ua.getHorasClase());
            System.out.println("HT: " + ua.getHorasTaller());
            System.out.println("HL: " + ua.getHorasLaboratorio());
            System.out.println("Cantidad de profesores que imparten la UA: " + ua.getProfesorList().size());
            for(Profesor profe : ua.getProfesorList()) {
                System.out.println(profe.getNombre());
            }
            System.out.println();
        }
        
        if(noHayUAs) {
            System.out.println("No hay Unidades de Aprendizaje registradas.");
        }
    }
    
    public static void consultaUA(int id) {
        UnidadDeAprendizaje ua = ServiceFacadeLocator.getInstanceFacadeUnidadDeAprendizaje().consultaUA.porID(id);
        if(ua ==  null) {
            System.out.println("No se ha encontrado una UA con ese id.");
            return;
        }
        
        System.out.println("ID UA: " + ua.getIdunidadDeAprendizaje());
        System.out.println("Nombre UA: " + ua.getNombreUA());
        System.out.println("HC: " + ua.getHorasClase());
        System.out.println("HT: " + ua.getHorasTaller());
        System.out.println("HL: " + ua.getHorasLaboratorio());

        System.out.println("Cantidad de profesores que imparten la UA: " + ua.getProfesorList().size());
        System.out.println();
    }

    public static void altaUA() {
        UnidadDeAprendizaje ua =  new UnidadDeAprendizaje(11293, "Taller de Linux", 0, 4, 0);
        if(ServiceFacadeLocator.getInstanceFacadeUnidadDeAprendizaje().altaUnidadDeAprendizaje(ua)) {
            System.out.println("Alta de UA exitosa!");
        }
        else {
            System.out.println("Alta de UA fallida :c");
        }
    }
    
    public static void altaProfesor(){
        UnidadDeAprendizaje ua = ServiceFacadeLocator.getInstanceFacadeUnidadDeAprendizaje().consultaUA.porID(11293);
        
        Profesor profe = new Profesor(9898, "Edwin R.", "García Curial", "ERGC123456789", ua);
        if(ServiceFacadeLocator.getInstanceFacadeProfesor().altaProfesor(profe)) {
            System.out.println("Alta de Profesor exitosa!");
        }
        else {
            System.out.println("Alta de Profesor fallida! :C");
        }
    }
    
    public static void borrarProfesor(int id) {
        if(ServiceFacadeLocator.getInstanceFacadeProfesor().borrarProfesor(9898)) {
            System.out.println("Registro de profesor eliminado con éxito!");
        }
        else {
            System.out.println("No se encontró el ID del registro de profesor a borrar.");
        }
    }
    
    public static void modificarProfesor(){
        UnidadDeAprendizaje ua = ServiceFacadeLocator.getInstanceFacadeUnidadDeAprendizaje().consultaUA.porID(11293);
        
        Profesor profe = new Profesor(9898, "Edwin R. Modificado", "García Curiel jsjs", "ERGC123456789", ua);
        if(ServiceFacadeLocator.getInstanceFacadeProfesor().actualizarProfesor(profe)) {
            System.out.println("Modificación de Profesor exitosa!");
        }
        else {
            System.out.println("Modificación de Profesor fallida! :C");
        }
    }
    
}