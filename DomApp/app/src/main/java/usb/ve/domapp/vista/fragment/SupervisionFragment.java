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
import usb.ve.domapp.objetoComponente.Componente;
import usb.ve.domapp.presentador.ISupervisionFragmentPresentador;
import usb.ve.domapp.presentador.SupervisionFragmentPresentador;

public class SupervisionFragment extends Fragment implements ISupervisionFragment {

    private RecyclerView rvComponentes;
    private ISupervisionFragmentPresentador presentador;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup contenedor, @Nullable Bundle savedInstanceState) {
        View view = layoutInflater.inflate(R.layout.fragment_supervision,contenedor,false);

        rvComponentes = (RecyclerView) view.findViewById(R.id.rvComponentes);
        presentador = new SupervisionFragmentPresentador(this, getContext());
        return view;
    }

    public void generarGridLayout() {
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 1);
        rvComponentes.setLayoutManager(glm);
    }

    @Override
    public ComponenteAdaptador crearAdaptador(ArrayList<Componente> componentes) {
        return new ComponenteAdaptador(componentes, getActivity());
    }

    @Override
    public void inicializarAdaptadorRV(ComponenteAdaptador componenteAdaptador) {
        rvComponentes.setAdapter(componenteAdaptador);
    }
}
