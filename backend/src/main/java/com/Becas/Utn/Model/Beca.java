public class Beca {
    //Creacion de los atributos de la clase beca
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(max = 150)
    @Column(nullable = false, length = 150)
    private String nombre;

    @NotNull
    @Size(max = 30)
    @Column(name = "tipo_beca", nullable = false, length = 30)
    private String tipoBeca; //Nueva entidad ¿?

    @Column(name = "requiere_ingenieria", nullable = false)
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
