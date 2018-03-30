package usb.ve.domapp.firebase;



import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import usb.ve.domapp.database.ConstantesBaseDatos;

/**
 * Created by Diego on 30/3/2018.
 */

public class ComunicacionFirebase {
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    public DatabaseReference temperaturaRef = firebaseDatabase.getReference(ConstantesFirebase.FIREBASE_TEMPERATURA);
    public int valorTemperatura;

    public void leerFirebase(){
        temperaturaRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                valorTemperatura = dataSnapshot.getValue(Integer.class);

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
