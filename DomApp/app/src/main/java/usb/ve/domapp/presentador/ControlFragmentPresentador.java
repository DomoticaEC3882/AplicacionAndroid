package usb.ve.domapp.presentador;

import android.content.Context;

import usb.ve.domapp.adaptador.ComponenteAdaptador;

import usb.ve.domapp.vista.fragment.IControlFragment;

public class ControlFragmentPresentador implements IControlFragmentPresentador{
    private IControlFragment iControlFragment;
    private Context context;
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