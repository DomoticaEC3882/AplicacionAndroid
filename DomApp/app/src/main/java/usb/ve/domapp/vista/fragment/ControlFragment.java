package usb.ve.domapp.vista.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import usb.ve.domapp.R;
import usb.ve.domapp.adaptador.ComponenteAdaptador;
import usb.ve.domapp.constantes.Constantes;
import usb.ve.domapp.presentador.ControlFragmentPresentador;
import usb.ve.domapp.presentador.IControlFragmentPresentador;

public class ControlFragment extends Fragment implements IControlFragment {
    private RecyclerView rvControlComponentes;
    private IControlFragmentPresentador presentador;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup contenedor, @Nullable Bundle savedInstanceState) {

        View view = layoutInflater.inflate(R.layout.fragment_control,contenedor,false);

        rvControlComponentes = (RecyclerView) view.findViewById(R.id.rvControlComponentes);
        presentador = new ControlFragmentPresentador(this, getContext());
        return view;
    }

    public void generarGridLayout() {
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 1);
        rvControlComponentes.setLayoutManager(glm);
    }

    @Override
    public ComponenteAdaptador crearAdaptador() {
        return new ComponenteAdaptador(getActivity(), Constantes.SECCION_CONTROL);
    }

    @Override
    public void inicializarAdaptadorRV(ComponenteAdaptador componenteAdaptador) {

        rvControlComponentes.setAdapter(componenteAdaptador);
    }

}
