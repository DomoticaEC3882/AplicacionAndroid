package usb.ve.domapp.constantes;

import android.graphics.Color;

/**
 * Created by Diego on 31/3/2018.
 */

public class Constantes {
    public static final String  NOMBRE_SUPERVISION      = "supervision";
    public static final String  NOMBRE_CONTROL          = "control";
    //Selector
    public static final int     SECCION_SUPERVISION     = 0;
    public static final int     SECCION_CONTROL         = 1;

    //Nombre de las keys en la Firebase
    public static final String  FIREBASE_TEMPERATURA    = "Temperatura";
    public static final String  FIREBASE_ILUMINACION    = "Iluminacion";
    public static final String  FIREBASE_SEGURIDAD      = "Seguridad";
    public static final String  FIREBASE_ALARMA         = "Alarma";
    public static final String  FIREBASE_VENTILACION    = "Ventilacion";
    public static final String  FIREBASE_SISMO          = "Sismo";
    public static final String  FIREBASE_TOKEN          = "Token";

    public static final int     COLOR_SEGURIDAD_ACTIVAR     = Color.rgb(5,100,5);
    public static final int     COLOR_SEGURIDAD_DESACTIVAR  = Color.rgb(100,5,5);
}
