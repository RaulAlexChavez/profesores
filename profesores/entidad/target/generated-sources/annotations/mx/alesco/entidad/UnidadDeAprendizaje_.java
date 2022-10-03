package mx.alesco.entidad;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mx.alesco.entidad.Profesor;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-10-02T22:36:23")
@StaticMetamodel(UnidadDeAprendizaje.class)
public class UnidadDeAprendizaje_ { 

    public static volatile SingularAttribute<UnidadDeAprendizaje, Integer> horasLaboratorio;
    public static volatile SingularAttribute<UnidadDeAprendizaje, Integer> idunidadDeAprendizaje;
    public static volatile SingularAttribute<UnidadDeAprendizaje, Integer> horasClase;
    public static volatile SingularAttribute<UnidadDeAprendizaje, String> nombreUA;
    public static volatile ListAttribute<UnidadDeAprendizaje, Profesor> profesorList;
    public static volatile SingularAttribute<UnidadDeAprendizaje, Integer> horasTaller;

}