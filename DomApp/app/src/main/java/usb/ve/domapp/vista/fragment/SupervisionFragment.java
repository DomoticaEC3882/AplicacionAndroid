package usb.ve.domapp.vista.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import usb.ve.domapp.R;
import usb.ve.domapp.adaptador.ComponenteAdaptador;
import usb.ve.domapp.database.ConstantesBaseDatos;
import usb.ve.domapp.objetoComponente.Componente;
import usb.ve.domapp.presentador.ISupervisionFragmentPresentador;
import usb.ve.domapp.presentador.SupervisionFragmentPresentador;

public class SupervisionFragment extends Fragment implements ISupervisionFragment {

    private RecyclerView rvSupervisionComponentes;
    private ISupervisionFragmentPresentador presentador;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup contenedor, @Nullable Bundle savedInstanceState) {
        View view = layoutInflater.inflate(R.layout.fragment_supervision,contenedor,false);

        rvSupervisionComponentes = (RecyclerView) view.findViewById(R.id.rvSupervisionComponentes);
        presentador = new SupervisionFragmentPresentador(this, getContext());
        return view;
    }

    public void generarGridLayout() {
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 1);
        rvSupervisionComponentes.setLayoutManager(glm);
    }

    @Override
    public ComponenteAdaptador crearAdaptador() {
        return new ComponenteAdaptador(getActivity(), ConstantesBaseDatos.SECCION_SUPERVISION);
    }

    @Override
    public void inicializarAdaptadorRV(ComponenteAdaptador componenteAdaptador) {
        rvSupervisionComponentes.setAdapter(componenteAdaptador);
    }
}
