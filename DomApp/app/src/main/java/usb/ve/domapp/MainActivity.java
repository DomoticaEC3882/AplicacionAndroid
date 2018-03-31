package usb.ve.domapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import usb.ve.domapp.adaptador.ComponenteAdaptador;
import usb.ve.domapp.adaptador.PaginaAdaptador;
import usb.ve.domapp.firebase.ComunicacionFirebase;
import usb.ve.domapp.firebase.ConstantesFirebase;
import usb.ve.domapp.objetoComponente.Componente;
import usb.ve.domapp.vista.fragment.ControlFragment;
import usb.ve.domapp.vista.fragment.SupervisionFragment;

public class MainActivity extends AppCompatActivity {
    //componentes
    ArrayList<Componente> componentes;
    //Fragments
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    //Firebase
    private ComunicacionFirebase comunicacionFirebase;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    public DatabaseReference temperaturaRef = firebaseDatabase.getReference(ConstantesFirebase.FIREBASE_TEMPERATURA);


    private static final String TAG = "VALOR: ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //declaracion de fragment
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setUpViewPager();
        //fin

        //validacion toolbar
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
        leerFirebase();
    }


//    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
//    public void onEvent(SimpleEvent event) {
//        adapter.append(event);
//        recyclerView.scrollToPosition(adapter.getItemCount() - 1);
//    }



    private ArrayList<Fragment> agregarFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new SupervisionFragment());
        fragments.add(new ControlFragment());


        return fragments;
    }

    //Inicializar los fragments
    private void setUpViewPager() {
        viewPager.setAdapter(new PaginaAdaptador(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        configurarTabLayout();

    }
    private void configurarTabLayout(){
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home).setText(R.string.hogar);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_tune).setText(R.string.control);
    }

    public void leerFirebase() {

        temperaturaRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                setUpViewPager();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


}
