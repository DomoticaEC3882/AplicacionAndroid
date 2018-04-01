package usb.ve.domapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import usb.ve.domapp.adaptador.PaginaAdaptador;
import usb.ve.domapp.vista.fragment.ControlFragment;
import usb.ve.domapp.vista.fragment.SupervisionFragment;

public class MainActivity extends AppCompatActivity {
    //Fragments
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

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
