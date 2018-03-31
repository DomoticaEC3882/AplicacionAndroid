package usb.ve.domapp.presentador;

import android.content.Context;

import java.util.ArrayList;

import usb.ve.domapp.adaptador.ComponenteAdaptador;
import usb.ve.domapp.database.ConstantesBaseDatos;
import usb.ve.domapp.database.ConstructorComponentes;
import usb.ve.domapp.objetoComponente.Componente;
import usb.ve.domapp.vista.fragment.ISupervisionFragment;

public class SupervisionFragmentPresentador implements ISupervisionFragmentPresentador{
    private ISupervisionFragment iSupervisionFragment;
    private Context context;
    private ConstructorComponentes constructorComponentes;
    private ArrayList<Componente> componentes;

    private ComponenteAdaptador componenteAdaptador;



    public SupervisionFragmentPresentador(ISupervisionFragment iSupervisionFragment, Context context) {
        this.iSupervisionFragment = iSupervisionFragment;
        this.context = context;
        obtenerComponentesBaseDatos();
    }

    @Override
    public void obtenerComponentesBaseDatos() {
        constructorComponentes = new ConstructorComponentes(context);
        componentes = constructorComponentes.obtenerDatos(ConstantesBaseDatos.BASEDATOS_NOMBRE_SUPERVISION);
        mostrarComponentesRV();
    }

    @Override
    public void mostrarComponentesRV() {
        iSupervisionFragment.inicializarAdaptadorRV(iSupervisionFragment.crearAdaptador(componentes));
        iSupervisionFragment.generarGridLayout();
    }
}
