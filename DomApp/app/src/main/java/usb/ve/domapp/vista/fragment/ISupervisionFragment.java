package usb.ve.domapp.vista.fragment;
import usb.ve.domapp.adaptador.ComponenteAdaptador;


public interface ISupervisionFragment {
    void generarGridLayout();
    ComponenteAdaptador crearAdaptador();
    void inicializarAdaptadorRV(ComponenteAdaptador adaptador);

}
