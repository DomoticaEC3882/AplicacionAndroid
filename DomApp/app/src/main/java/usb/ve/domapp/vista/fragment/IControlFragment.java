package usb.ve.domapp.vista.fragment;

import java.util.ArrayList;

import usb.ve.domapp.adaptador.ComponenteAdaptador;
import usb.ve.domapp.objetoComponente.Componente;

/**
 * Created by Diego on 29/3/2018.
 */

public interface IControlFragment {
    public void generarGridLayout();

    public ComponenteAdaptador crearAdaptador(ArrayList<Componente> componentes);

    public void inicializarAdaptadorRV(ComponenteAdaptador adaptador);
}
