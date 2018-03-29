package usb.ve.domapp.database;


import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

import usb.ve.domapp.R;
import usb.ve.domapp.objetoComponente.Componente;

public class ConstructorComponentes {
    private Context context;
    public ConstructorComponentes(Context context) {
        this.context = context;
    }

    public ArrayList<Componente> obtenerDatos(){
        BaseDatos baseDatos = new BaseDatos(context);
        insertarComponentes(baseDatos);
        return baseDatos.obtenerTodosLosComponentes();
    }

    public void insertarComponentes(BaseDatos baseDatos){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_COMPONENTES_NOMBRE,"Temperatura");
        contentValues.put(ConstantesBaseDatos.TABLA_COMPONENTES_IMAGEN, R.drawable.temperaturadefault);
        contentValues.put(ConstantesBaseDatos.TABLA_COMPONENTES_ESTADO,"27°");

        baseDatos.insertarComponente(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLA_COMPONENTES_NOMBRE,"Seguridad");
        contentValues.put(ConstantesBaseDatos.TABLA_COMPONENTES_IMAGEN, R.drawable.seguridaddefault);
        contentValues.put(ConstantesBaseDatos.TABLA_COMPONENTES_ESTADO,"Activada");

        baseDatos.insertarComponente(contentValues);
    }

}
