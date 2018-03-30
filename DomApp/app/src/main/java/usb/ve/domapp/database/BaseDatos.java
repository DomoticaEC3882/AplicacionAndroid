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
            super(context,ConstantesBaseDatos.BASEDATOS_NOMBRE, null, ConstantesBaseDatos.BASEDATOS_VERSION);
            this.context = context;

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //CREA LA BASE DE DATOS
        String queryCrearTablaSupervision = "CREATE TABLE " + ConstantesBaseDatos.BASEDATOS_NOMBRE_SUPERVISION + "(" +
                ConstantesBaseDatos.TABLA_COMPONENTES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLA_COMPONENTES_NOMBRE + " TEXT, " +
                ConstantesBaseDatos.TABLA_COMPONENTES_IMAGEN + " INTEGER, " +
                ConstantesBaseDatos.TABLA_COMPONENTES_ESTADO + " TEXT" +
                ")";
        sqLiteDatabase.execSQL(queryCrearTablaSupervision);
        String queryCrearTablaControl = "CREATE TABLE " + ConstantesBaseDatos.BASEDATOS_NOMBRE_CONTROL + "(" +
                ConstantesBaseDatos.TABLA_COMPONENTES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLA_COMPONENTES_NOMBRE + " TEXT, " +
                ConstantesBaseDatos.TABLA_COMPONENTES_IMAGEN + " INTEGER, " +
                ConstantesBaseDatos.TABLA_COMPONENTES_ESTADO + " TEXT" +
                ")";
        sqLiteDatabase.execSQL(queryCrearTablaControl);//Ejecuta la base de datos

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.BASEDATOS_NOMBRE_SUPERVISION);
        sqLiteDatabase.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.BASEDATOS_NOMBRE_CONTROL);
        onCreate(sqLiteDatabase);

    }

    public ArrayList<Componente> obtenerTodosLosComponentes(String seleccion){
        ArrayList<Componente> componentes = new ArrayList<>();

        String query = "SELECT * FROM " + seleccion;
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

    public void insertarComponente(ContentValues contentValues,String seleccion){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(seleccion,null, contentValues);
    }

}
