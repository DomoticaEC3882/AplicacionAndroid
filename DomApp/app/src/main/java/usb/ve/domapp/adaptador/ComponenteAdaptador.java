package usb.ve.domapp.adaptador;


import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

import usb.ve.domapp.R;
import usb.ve.domapp.database.ConstantesBaseDatos;
import usb.ve.domapp.objetoComponente.Componente;

public class ComponenteAdaptador extends RecyclerView.Adapter<ComponenteAdaptador.ComponenteViewHolder> {
    ArrayList<Componente> componentes;
    Activity activity;
    int seccion;



    public ComponenteAdaptador(ArrayList<Componente> componentes, Activity activity, int seccion){
        this.componentes    = componentes;
        this.activity       = activity;
        this.seccion        = seccion;
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
        final Componente componente = componentes.get(position); //Extrae la posicion de cada objeto

        componenteViewHolder.cvComponente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EjecutarAccion(componenteViewHolder,position,seccion);

            }
        });
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
        private CardView    cvComponente;


        public ComponenteViewHolder(View itemView) {
            super(itemView);
            tvNombreCV    = (TextView) itemView.findViewById(R.id.tvNombreCV);
            ivImagenCV    = (ImageView) itemView.findViewById(R.id.ivImagenCV);
            tvEstadoCV    = (TextView) itemView.findViewById(R.id.tvEstadoCV);
            cvComponente  = (CardView) itemView.findViewById(R.id.cvComponente);
        }
    }
    private void EjecutarAccion(ComponenteViewHolder componenteViewHolder,int position, int seccion){
        if(seccion == ConstantesBaseDatos.SECCION_SUPERVISION){
            switch (position ){
                case 0:
                    Toast.makeText(activity, "Temperatura", Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    Toast.makeText(activity, "Seguridad", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
        else {
            switch (position) {
                case 0:
                    componenteViewHolder.ivImagenCV.setImageResource(R.drawable.bombilloencendido);
                    componenteViewHolder.tvEstadoCV.setText(R.string.encendida);
                    break;
                case 1:
                    componenteViewHolder.ivImagenCV.setImageResource(R.drawable.ventiladorencendido);
                    componenteViewHolder.tvEstadoCV.setText(R.string.encendida);
                    break;
                default:
                    break;
            }
        }

    }



}