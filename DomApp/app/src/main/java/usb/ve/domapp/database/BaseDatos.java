package usb.ve.domapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import usb.ve.domapp.objetoComponente.Componente;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;
    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.BASEDATOS_NOMBRE, null, ConstantesBaseDatos.BASEDATOS_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //CREA LA BASE DE DATOS
        String queryCrearTablaContacto = "CREATE TABLE " + ConstantesBaseDatos.TABLA_COMPONENTES + "(" +
                ConstantesBaseDatos.TABLA_COMPONENTES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLA_COMPONENTES_NOMBRE + " TEXT, " +
                ConstantesBaseDatos.TABLA_COMPONENTES_IMAGEN + " INTEGER, " +
                ConstantesBaseDatos.TABLA_COMPONENTES_ESTADO + " TEXT" +
                ")";
        sqLiteDatabase.execSQL(queryCrearTablaContacto); //Ejecuta la base de datos

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public ArrayList<Componente> obtenerTodosLosComponentes(){
        ArrayList<Componente> componentes = new ArrayList<>();

        String query = "SELECT * FROM " +ConstantesBaseDatos.TABLA_COMPONENTES;
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor registros = sqLiteDatabase.rawQuery(query, null );

       while(registros.moveToNext()) {
           Componente componenteActual = new Componente();

           componenteActual.setId(registros.getInt(0));
           componenteActual.setNombre(registros.getString(1));
           componenteActual.setImagen(registros.getInt(2));
           componenteActual.setEstado(registros.getString(3));

           componentes.add(componenteActual);
       }
       sqLiteDatabase.close();
       return componentes;
    }

    public void insertarComponente(ContentValues contentValues){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(ConstantesBaseDatos.TABLA_COMPONENTES,null, contentValues);
    }

}
