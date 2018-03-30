package usb.ve.domapp.database;

/**
 * Created by Diego on 28/3/2018.
 */

public class ConstantesBaseDatos {
    public static final String  BASEDATOS_NOMBRE               = "DomApp";
    public static final String  BASEDATOS_NOMBRE_SUPERVISION   = "supervision";
    public static final String  BASEDATOS_NOMBRE_CONTROL       = "control";
    public static final int     BASEDATOS_VERSION   = 1;



    //Identificadores
    public static final String  TABLA_COMPONENTES        = "componente";
    public static final String  TABLA_COMPONENTES_ID     = "id";
    public static final String  TABLA_COMPONENTES_NOMBRE = "nombre";
    public static final String  TABLA_COMPONENTES_IMAGEN = "imagen";
    public static final String  TABLA_COMPONENTES_ESTADO = "estado";

    //selector
    public static final int     SECCION_SUPERVISION      = 0;
    public static final int     SECCION_CONTROL          = 1;
}
