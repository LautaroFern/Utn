public class Beca {
    //Creacion de los atributos de la clase beca
    
    private Long id;
    private String nombre;
    private String tipoBeca;
    private boolean requiereIngenieria;


    //Constructores
    public Beca () {

    }

    public Beca(Long id, String nombre, String tipoBeca, boolean requiereIngenieria) {
        this.id = id;
        this.nombre = nombre;
        this.tipoBeca = tipoBeca;
        this.requiereIngenieria = requiereIngenieria;
    }

    //Getters y Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTipoBeca() {
        return tipoBeca;
    }
    public void setTipoBeca(String tipoBeca) {
        this.tipoBeca = tipoBeca;
    }
    public boolean isRequiereIngenieria() {
        return requiereIngenieria;
    }
    public void setRequiereIngenieria(boolean requiereIngenieria) {
        this.requiereIngenieria = requiereIngenieria;
    }

    //Equal y Hashcode
}
