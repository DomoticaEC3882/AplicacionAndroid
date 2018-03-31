package usb.ve.domapp;

import android.support.v7.widget.RecyclerView;

/**
 * Created by Diego on 31/3/2018.
 */

public class GuardarRecycler {
    private RecyclerView recyclerView;
    GuardarRecycler(RecyclerView recyclerView){
        this.recyclerView= recyclerView;
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }
}
