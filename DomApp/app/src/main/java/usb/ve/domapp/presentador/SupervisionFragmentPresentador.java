package usb.ve.domapp.presentador;
import android.content.Context;
import usb.ve.domapp.vista.fragment.ISupervisionFragment;

public class SupervisionFragmentPresentador implements ISupervisionFragmentPresentador{
    private ISupervisionFragment iSupervisionFragment;
    private Context context;

    public SupervisionFragmentPresentador(ISupervisionFragment iSupervisionFragment, Context context) {
        this.iSupervisionFragment = iSupervisionFragment;
        this.context = context;
        mostrarComponentesRV();
    }

    @Override
    public void mostrarComponentesRV() {
        iSupervisionFragment.inicializarAdaptadorRV(iSupervisionFragment.crearAdaptador());
        iSupervisionFragment.generarGridLayout();
    }
}
