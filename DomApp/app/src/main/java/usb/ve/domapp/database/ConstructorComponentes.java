package usb.ve.domapp.database;

import android.content.Context;
import java.util.ArrayList;

import usb.ve.domapp.firebase.ConstantesFirebase;
import usb.ve.domapp.objetoComponente.Componente;

public class ConstructorComponentes {
    private Context context;

    public ConstructorComponentes(Context context) {
        this.context = context;
    }

    public ArrayList<Componente> obtenerComponentes(String seccion){
        ArrayList<Componente> componentes = new ArrayList<>();
        Componente componenteActual = new Componente();
        switch (seccion){
            case ConstantesBaseDatos.BASEDATOS_NOMBRE_SUPERVISION:
                componenteActual.setId(0);
                componenteActual.setNombre(ConstantesFirebase.FIREBASE_TEMPERATURA);
                componentes.add(componenteActual);
                componenteActual.setId(1);
                componenteActual.setNombre(ConstantesFirebase.FIREBASE_SEGURIDAD);
                componentes.add(componenteActual);
                break;
            case ConstantesBaseDatos.BASEDATOS_NOMBRE_CONTROL:
                componenteActual.setId(0);
                componenteActual.setNombre(ConstantesFirebase.FIREBASE_ILUMINACION);
                componentes.add(componenteActual);
                componenteActual.setId(1);
                componenteActual.setNombre(ConstantesFirebase.FIREBASE_VENTILACION);
                componentes.add(componenteActual);
                break;
            default:
                break;
        }
        return componentes;
    }
}
