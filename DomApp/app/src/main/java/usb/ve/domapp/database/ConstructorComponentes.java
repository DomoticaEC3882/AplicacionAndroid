package usb.ve.domapp.database;


import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import java.util.ArrayList;

import usb.ve.domapp.R;
import usb.ve.domapp.objetoComponente.Componente;

public class ConstructorComponentes {
    private Context context;
    public ConstructorComponentes(Context context) {
        this.context = context;
    }

    public ArrayList<Componente> obtenerDatos(String seleccion){
        BaseDatos baseDatos = new BaseDatos(context);
        if (baseDatos.obtenerTodosLosComponentes(seleccion).isEmpty()) {
            insertarComponentes(baseDatos,seleccion);
        }
        return baseDatos.obtenerTodosLosComponentes(seleccion);
    }

    public void insertarComponentes(BaseDatos baseDatos, String seleccion){
        ContentValues contentValues = new ContentValues();
        switch (seleccion){
            case ConstantesBaseDatos.BASEDATOS_NOMBRE_SUPERVISION:
                contentValues.put(ConstantesBaseDatos.TABLA_COMPONENTES_NOMBRE,"Temperatura");
                contentValues.put(ConstantesBaseDatos.TABLA_COMPONENTES_IMAGEN, R.drawable.temperaturadefault);
                contentValues.put(ConstantesBaseDatos.TABLA_COMPONENTES_ESTADO,"27°");

                baseDatos.insertarComponente(contentValues,seleccion);

                contentValues.put(ConstantesBaseDatos.TABLA_COMPONENTES_NOMBRE,"Seguridad");
                contentValues.put(ConstantesBaseDatos.TABLA_COMPONENTES_IMAGEN, R.drawable.seguridaddefault);
                contentValues.put(ConstantesBaseDatos.TABLA_COMPONENTES_ESTADO,"Activada");

                baseDatos.insertarComponente(contentValues,seleccion);
                break;
            case ConstantesBaseDatos.BASEDATOS_NOMBRE_CONTROL:
                contentValues.put(ConstantesBaseDatos.TABLA_COMPONENTES_NOMBRE,"Iluminación");
                contentValues.put(ConstantesBaseDatos.TABLA_COMPONENTES_IMAGEN, R.drawable.bombilloapagado);
                contentValues.put(ConstantesBaseDatos.TABLA_COMPONENTES_ESTADO,"Apagada");

                baseDatos.insertarComponente(contentValues,seleccion);

                contentValues.put(ConstantesBaseDatos.TABLA_COMPONENTES_NOMBRE,"Ventilación");
                contentValues.put(ConstantesBaseDatos.TABLA_COMPONENTES_IMAGEN, R.drawable.ventiladorapagado);
                contentValues.put(ConstantesBaseDatos.TABLA_COMPONENTES_ESTADO,"Apagada");

                baseDatos.insertarComponente(contentValues,seleccion);
                break;
            default:
                Toast.makeText(context, "Error en la base de datos", Toast.LENGTH_SHORT).show();
                break;
        }

    }

}
