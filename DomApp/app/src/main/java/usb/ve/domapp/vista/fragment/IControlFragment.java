package usb.ve.domapp.vista.fragment;
import java.util.ArrayList;
import usb.ve.domapp.adaptador.ComponenteAdaptador;
import usb.ve.domapp.objetoComponente.Componente;

public interface IControlFragment {
    void generarGridLayout();
    ComponenteAdaptador crearAdaptador();
    void inicializarAdaptadorRV(ComponenteAdaptador adaptador);
}
