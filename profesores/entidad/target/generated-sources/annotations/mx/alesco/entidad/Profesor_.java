package mx.alesco.entidad;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mx.alesco.entidad.UnidadDeAprendizaje;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-10-02T22:36:23")
@StaticMetamodel(Profesor.class)
public class Profesor_ { 

    public static volatile SingularAttribute<Profesor, String> apellido;
    public static volatile ListAttribute<Profesor, UnidadDeAprendizaje> unidadDeAprendizajeList;
    public static volatile SingularAttribute<Profesor, String> nombre;
    public static volatile SingularAttribute<Profesor, Integer> idprofesor;
    public static volatile SingularAttribute<Profesor, String> rfc;

}