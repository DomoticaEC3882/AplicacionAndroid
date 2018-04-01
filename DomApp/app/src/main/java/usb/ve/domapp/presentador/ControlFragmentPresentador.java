package usb.ve.domapp.presentador;

import android.content.Context;

import java.util.ArrayList;

import usb.ve.domapp.adaptador.ComponenteAdaptador;
import usb.ve.domapp.database.ConstantesBaseDatos;
import usb.ve.domapp.database.ConstructorComponentes;
import usb.ve.domapp.objetoComponente.Componente;
import usb.ve.domapp.vista.fragment.IControlFragment;

public class ControlFragmentPresentador implements IControlFragmentPresentador{
    private IControlFragment iControlFragment;
    private Context context;
    private ConstructorComponentes constructorComponentes;
    public static ArrayList<Componente> componentes;
    private ComponenteAdaptador componenteAdaptador;

    public ControlFragmentPresentador(IControlFragment iControlFragment, Context context) {
        this.iControlFragment = iControlFragment;
        this.context = context;
        mostrarComponentesRV();
    }

    @Override
    public void mostrarComponentesRV() {
        componenteAdaptador = iControlFragment.crearAdaptador();
        iControlFragment.inicializarAdaptadorRV(componenteAdaptador);
        iControlFragment.generarGridLayout();
    }
}