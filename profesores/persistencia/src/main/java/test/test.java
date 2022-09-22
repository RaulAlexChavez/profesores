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
 * @author Raúl Alex Chávez
 */
public class test {
    public static void main(String[] args) {
        System.out.println("----- PERSISTENCIA ------");
        System.out.println("\n--------------------------------------------------\n");
        consultaProfesores();
        System.out.println("\n--------------------------------------------------\n");
        consultaUnidadesDeAprendizaje();
        
        System.out.println("\n--------------------------------------------------\n");
        UnidadDeAprendizaje ua = new UnidadDeAprendizaje(1, "Desarrollo de Software", 3, 3, 0);
        //altaUA(ua);
        
        System.out.println("\n--------------------------------------------------\n");
        ArrayList<UnidadDeAprendizaje> listaUAs = new ArrayList<UnidadDeAprendizaje>();
        listaUAs.add(ua);
        Profesor profe = new Profesor(1, "María Angélica", "Astorga Vargas", "RFCTEST123456", listaUAs);
        //altaProfesor(profe);
        
        /*System.out.println("\n--------------------------------------------------\n");
        profe.setNombre("Angelical");
        profe.setRfc("RFCMODIFICADO");
        modificarProfesor(profeModificar);*/
        
        /*System.out.println("\n--------------------------------------------------\n");
        ua.setHorasLaboratorio(1);
        ua.setNombreUA("Software Development");
        modificarUA(ua);*/
        
        try {
            bajaProfesor(20);
        } catch (java.lang.IllegalArgumentException ex){
            ex.printStackTrace();
            System.out.println("No existe un profesor con esa ID.");
        }
        //bajaUA(1);
        
        System.out.println("\n--------------------------------------------------\n");
        consultaProfesores();
        System.out.println("\n--------------------------------------------------\n");
        consultaUnidadesDeAprendizaje();
    }
    
    public static void consultaProfesores() {
        List<Profesor> listaProfesores = new ArrayList();
        ProfesorDAO profesorDAO = new ProfesorDAO();
        listaProfesores = profesorDAO.findAll();
        
        System.out.println("Consulta Profesores:\n");
        boolean noProfes = true;
        for(Profesor profe : listaProfesores) {
            noProfes = false;
            System.out.println("ID Profesor: " + profe.getIdprofesor());
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
    
    public static void consultaUnidadesDeAprendizaje() {
        List<UnidadDeAprendizaje> listaUnidadDeAprendizaje = new ArrayList();
        UnidadDeAprendizajeDAO unidadDeAprendizajeDAO = new UnidadDeAprendizajeDAO();
        listaUnidadDeAprendizaje = unidadDeAprendizajeDAO.findAll();
        
        System.out.println("Consulta UAs:\n");
        boolean noUAs = true;
        for(UnidadDeAprendizaje ua : listaUnidadDeAprendizaje) {
            noUAs = false;
            System.out.println("ID UA: " + ua.getIdunidadDeAprendizaje());
            System.out.println("Nombre UA: " + ua.getNombreUA());
            System.out.println("HC: " + ua.getHorasClase());
            System.out.println("HT: " + ua.getHorasTaller());
            System.out.println("HL: " + ua.getHorasLaboratorio());

            System.out.println("Cantidad de profesores que imparten la UA: " + ua.getProfesorList().size());
            System.out.println();
        }
        if(noUAs) {
            System.out.println("No hay UAs registrados.");
        }
    }
    
    public static boolean altaUA(UnidadDeAprendizaje ua) {
        if(getUAconID(ua.getIdunidadDeAprendizaje()) != null) {
            System.out.println("No se pudo guardar la UA.");
            return false;
        }
        
        UnidadDeAprendizajeDAO uaDAO = new UnidadDeAprendizajeDAO();
        uaDAO.save(ua);
        
        System.out.println("Nueva UA guardada.");
        return true;
    }
    
    public static boolean altaProfesor(Profesor profe) {
        if(getProfesorConID(profe.getIdprofesor()) != null) {
            System.out.println("No se pudo guardar el Profesor. El ID especificado ya existe.");
            return false;
        }
        
        if(profe.getUnidadDeAprendizajeList() == null || profe.getUnidadDeAprendizajeList().size() == 0) {
            System.out.println("No se dio de alta el Profesor. Necesita especificarse al  menos 1 UA que imparta.");
            return false;
        }
        
        ProfesorDAO uaDAO = new ProfesorDAO();
        uaDAO.save(profe);
        
        System.out.println("Nuevo Profesor guardado.");
        return true;
    }
    
    public static UnidadDeAprendizaje getUAconID(int id) {
        List<UnidadDeAprendizaje> listaUnidadDeAprendizaje = new ArrayList();
        UnidadDeAprendizajeDAO unidadDeAprendizajeDAO = new UnidadDeAprendizajeDAO();
        listaUnidadDeAprendizaje = unidadDeAprendizajeDAO.findAll();
        
        for(UnidadDeAprendizaje ua : listaUnidadDeAprendizaje) {
            if(ua.getIdunidadDeAprendizaje() == id) {
                return ua;
            }
        }
        return null;
    }
    
    public static Profesor getProfesorConID(int id) {
        List<Profesor> listaProfesor = new ArrayList();
        ProfesorDAO profesorDAO = new ProfesorDAO();
        listaProfesor = profesorDAO.findAll();
        
        for(Profesor profe : listaProfesor) {
            if(profe.getIdprofesor() == id) {
                return profe;
            }
        }
        return null;
    }
    
    public static void bajaProfesor(int id) {
        Profesor profeEliminar = getProfesorConID(id);
        bajaProfesor(profeEliminar);
    }
    
    public static void bajaProfesor(Profesor profeEliminar) {
        ProfesorDAO profesorDAO = new ProfesorDAO();
        profesorDAO.delete(profeEliminar);
    }
    
    public static void bajaUA(int id) {
        UnidadDeAprendizaje uaEliminar = getUAconID(id);
        bajaUA(uaEliminar);
    }
    
    public static void bajaUA(UnidadDeAprendizaje uaEliminar) {
        UnidadDeAprendizajeDAO uaDAO = new UnidadDeAprendizajeDAO();
        uaDAO.delete(uaEliminar);
    }
    
    public static void modificarProfesor(Profesor profe) {
        ProfesorDAO profesorDAO = new ProfesorDAO();
        profesorDAO.update(profe);
    }
    
    public static void modificarUA(UnidadDeAprendizaje ua) {
        UnidadDeAprendizajeDAO uaDAO = new UnidadDeAprendizajeDAO();
        uaDAO.update(ua);
    }
    
}
