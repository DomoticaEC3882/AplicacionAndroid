package usb.ve.domapp.vista.fragment;

import java.util.ArrayList;

import usb.ve.domapp.adaptador.ComponenteAdaptador;
import usb.ve.domapp.objetoComponente.Componente;


public interface ISupervisionFragment {
    public void generarGridLayout();

    public ComponenteAdaptador crearAdaptador();

    public void inicializarAdaptadorRV(ComponenteAdaptador adaptador);

}
