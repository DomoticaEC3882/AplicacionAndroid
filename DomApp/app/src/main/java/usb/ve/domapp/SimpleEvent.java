package usb.ve.domapp;

import java.util.Date;

/**
 * Created by Diego on 31/3/2018.
 */

public class SimpleEvent {
    private Date date;
    private int id;

    public SimpleEvent(int id) {
        this.id = id;
        this.date = new Date();
    }

    public Date getDate() {
        return date;
    }

    public int getId() {
        return id;
    }
}
