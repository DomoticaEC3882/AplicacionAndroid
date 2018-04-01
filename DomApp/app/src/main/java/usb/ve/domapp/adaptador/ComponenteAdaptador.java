package usb.ve.domapp.adaptador;


import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import usb.ve.domapp.R;
import usb.ve.domapp.database.ConstantesBaseDatos;
import usb.ve.domapp.firebase.ComunicacionFirebase;
import usb.ve.domapp.firebase.ConstantesFirebase;
import usb.ve.domapp.objetoComponente.Componente;

public class ComponenteAdaptador extends RecyclerView.Adapter<ComponenteAdaptador.ComponenteViewHolder> {
    Activity activity;
    int seccion;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference temperaturaRef = firebaseDatabase.getReference(ConstantesFirebase.FIREBASE_TEMPERATURA);
    private DatabaseReference seguridadRef = firebaseDatabase.getReference(ConstantesFirebase.FIREBASE_SEGURIDAD);
    private DatabaseReference iluminacionRef = firebaseDatabase.getReference(ConstantesFirebase.FIREBASE_ILUMINACION);
    private DatabaseReference ventilacionRef = firebaseDatabase.getReference(ConstantesFirebase.FIREBASE_VENTILACION);

    private String valorTemperatura;
    private int valorSeguridad;
    private int valorIluminacion;
    private int valorVentilacion;
    public ComponenteAdaptador(Activity activity, int seccion){
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

        if(seccion == 0){
            switch (position) {
                case 0:
                    temperaturaViewHolder(componenteViewHolder);
                    break;
                case 1:
                    seguridadViewHolder(componenteViewHolder);
                    break;
                default:
                    break;
            }
        }
        else {
            switch (position) {
                case 0:
                    ilumincacionViewHolder(componenteViewHolder);
                    break;
                case 1:
                    ventilacionViewHolder(componenteViewHolder);
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return 2;
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

    private void temperaturaViewHolder(final ComponenteViewHolder componenteViewHolder){
        componenteViewHolder.tvNombreCV.setText(R.string.temperatura);
        componenteViewHolder.ivImagenCV.setImageResource(R.drawable.temperaturadefault);
        componenteViewHolder.tvEstadoCV.setText(R.string.actualizando);
        temperaturaRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                valorTemperatura= dataSnapshot.getValue().toString();
                componenteViewHolder.tvEstadoCV.setText(valorTemperatura);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void seguridadViewHolder(final ComponenteViewHolder componenteViewHolder){
        componenteViewHolder.tvNombreCV.setText(R.string.seguridad);
        componenteViewHolder.ivImagenCV.setImageResource(R.drawable.seguridaddefault);
        componenteViewHolder.tvEstadoCV.setText(R.string.actualizando);
        seguridadRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                valorSeguridad = dataSnapshot.getValue(Integer.class);
                if(valorSeguridad == 0){
                    componenteViewHolder.tvEstadoCV.setText(R.string.desactivada);
                }
                else{
                    componenteViewHolder.tvEstadoCV.setText(R.string.activada);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        componenteViewHolder.cvComponente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(valorSeguridad == 0){
                    seguridadRef.setValue(1);
                }
                else{
                    seguridadRef.setValue(0);
                }
            }
        });

    }
    private void ilumincacionViewHolder(final ComponenteViewHolder componenteViewHolder){
        componenteViewHolder.tvNombreCV.setText(R.string.iluminacion);
        componenteViewHolder.ivImagenCV.setImageResource(R.drawable.bombilloapagado);
        componenteViewHolder.tvEstadoCV.setText(R.string.actualizando);
        iluminacionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                valorIluminacion = dataSnapshot.getValue(Integer.class);
                if(valorIluminacion == 0){
                    componenteViewHolder.ivImagenCV.setImageResource(R.drawable.bombilloapagado);
                    componenteViewHolder.tvEstadoCV.setText(R.string.apagada);
                }
                else{
                    componenteViewHolder.ivImagenCV.setImageResource(R.drawable.bombilloencendido);
                    componenteViewHolder.tvEstadoCV.setText(R.string.encendida);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        componenteViewHolder.cvComponente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(valorIluminacion == 0){
                    iluminacionRef.setValue(1);
                }
                else{
                    iluminacionRef.setValue(0);
                }
            }
        });

    }
    private void ventilacionViewHolder(final ComponenteViewHolder componenteViewHolder){
        componenteViewHolder.tvNombreCV.setText(R.string.ventilacion);
        componenteViewHolder.ivImagenCV.setImageResource(R.drawable.ventiladorapagado);
        componenteViewHolder.tvEstadoCV.setText(R.string.actualizando);
        ventilacionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                valorVentilacion = dataSnapshot.getValue(Integer.class);
                if(valorVentilacion == 0){
                    componenteViewHolder.ivImagenCV.setImageResource(R.drawable.ventiladorapagado);
                    componenteViewHolder.tvEstadoCV.setText(R.string.apagada);
                }
                else{
                    componenteViewHolder.ivImagenCV.setImageResource(R.drawable.ventiladorencendido);
                    componenteViewHolder.tvEstadoCV.setText(R.string.encendida);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        componenteViewHolder.cvComponente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(valorVentilacion == 0){
                    ventilacionRef.setValue(1);
                }
                else{
                    ventilacionRef.setValue(0);
                }
            }
        });

    }
}