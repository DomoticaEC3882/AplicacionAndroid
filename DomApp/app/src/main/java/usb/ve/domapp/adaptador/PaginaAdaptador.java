package usb.ve.domapp.adaptador;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class PaginaAdaptador extends FragmentPagerAdapter{
    private ArrayList<Fragment> fragments;

    public PaginaAdaptador(FragmentManager fragmentManager,ArrayList<Fragment> fragments){
        super(fragmentManager);
        this.fragments = fragments;
    }
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
