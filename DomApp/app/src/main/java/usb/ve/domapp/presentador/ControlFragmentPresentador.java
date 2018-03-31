package usb.ve.domapp.presentador;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;

import usb.ve.domapp.adaptador.ComponenteAdaptador;
import usb.ve.domapp.database.ConstantesBaseDatos;
import usb.ve.domapp.database.ConstructorComponentes;
import usb.ve.domapp.objetoComponente.Componente;
import usb.ve.domapp.vista.fragment.IControlFragment;

/**
 * Created by Diego on 29/3/2018.
 */

public class ControlFragmentPresentador implements IControlFragmentPresentador{
    private IControlFragment iControlFragment;
    private Context context;
    private ConstructorComponentes constructorComponentes;
    private ArrayList<Componente> componentes;
    private ComponenteAdaptador componenteAdaptador;

    public ControlFragmentPresentador(IControlFragment iControlFragment, Context context) {
        this.iControlFragment = iControlFragment;
        this.context = context;
        obtenerComponentesBaseDatos();
    }

    @Override
    public void obtenerComponentesBaseDatos() {
        constructorComponentes = new ConstructorComponentes(context);
        componentes = constructorComponentes.obtenerDatos(ConstantesBaseDatos.BASEDATOS_NOMBRE_CONTROL);
        mostrarComponentesRV();
    }



    @Override
    public void mostrarComponentesRV() {
        componenteAdaptador = iControlFragment.crearAdaptador(componentes);
        iControlFragment.inicializarAdaptadorRV(componenteAdaptador);
        iControlFragment.generarGridLayout();
    }
}
