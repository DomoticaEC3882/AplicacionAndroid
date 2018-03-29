package usb.ve.domapp.adaptador;


import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import usb.ve.domapp.R;
import usb.ve.domapp.objetoComponente.Componente;

public class ComponenteAdaptador extends RecyclerView.Adapter<ComponenteAdaptador.ComponenteViewHolder> {
    ArrayList<Componente> componentes;
    Activity activity;



    public ComponenteAdaptador(ArrayList<Componente> componentes, Activity activity){
        this.componentes = componentes;
        this.activity  = activity;
    }
    // Infla el layout y lo pasa al viewholder para que obtenga los views
    @Override
    public ComponenteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_grid_componente, parent, false);
        return new ComponenteViewHolder(v);
    }

    //asocia cada Componente con cada card_view
    @Override
    public void onBindViewHolder(final ComponenteViewHolder componenteViewHolder, final int position) {
        final Componente componente = componentes.get(position); //extrae la posicion de cada objeto

        componenteViewHolder.tvNombreCV.setText(String.valueOf(componente.getNombre()));

        componenteViewHolder.ivImagenCV.setImageResource(componente.getImagen());

        componenteViewHolder.tvEstadoCV.setText(String.valueOf(componente.getEstado()));

    }

    @Override
    public int getItemCount() { //cantidad de elementos que contiene la lista
        return componentes.size();
    }

    public static class ComponenteViewHolder extends RecyclerView.ViewHolder {

        private TextView    tvNombreCV;
        private ImageView   ivImagenCV;
        private TextView    tvEstadoCV;


        public ComponenteViewHolder(View itemView) {
            super(itemView);
            tvNombreCV    = (TextView) itemView.findViewById(R.id.tvNombreCV);
            ivImagenCV    = (ImageView) itemView.findViewById(R.id.ivImagenCV);
            tvEstadoCV    = (TextView) itemView.findViewById(R.id.tvEstadoCV);
        }
    }
}