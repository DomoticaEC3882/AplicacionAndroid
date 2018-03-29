package usb.ve.domapp.objetoComponente;


public class Componente {
    private int    id;
    private String nombre;
    private int    imagen;
    private String estado;

    public Componente(int id, String nombre, int imagen, String estado) {
        this.id     = id;
        this.nombre = nombre;
        this.imagen = imagen;
        this.estado = estado;
    }

    public Componente() {

    }

    //GETTERS AND SETTERS

    public int getId() {return id;}

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {return imagen;}

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    //WRAP

}
