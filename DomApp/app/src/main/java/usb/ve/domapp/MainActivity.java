package usb.ve.domapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import usb.ve.domapp.adaptador.ComponenteAdaptador;
import usb.ve.domapp.adaptador.PaginaAdaptador;
import usb.ve.domapp.firebase.ComunicacionFirebase;
import usb.ve.domapp.firebase.ConstantesFirebase;
import usb.ve.domapp.objetoComponente.Componente;
import usb.ve.domapp.presentador.ControlFragmentPresentador;
import usb.ve.domapp.presentador.ISupervisionFragmentPresentador;
import usb.ve.domapp.presentador.SupervisionFragmentPresentador;
import usb.ve.domapp.vista.fragment.ControlFragment;
import usb.ve.domapp.vista.fragment.ISupervisionFragment;
import usb.ve.domapp.vista.fragment.SupervisionFragment;

public class MainActivity extends AppCompatActivity {
    //Fragments
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    //Firebase
    private ComunicacionFirebase comunicacionFirebase;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    public DatabaseReference temperaturaRef = firebaseDatabase.getReference(ConstantesFirebase.FIREBASE_TEMPERATURA);
    public int valorTemperatura;

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
    }


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



}
