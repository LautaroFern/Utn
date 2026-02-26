@Entity
@Table(name = "usuario")
public class Usuario {
// Creacion de atributos de la clase Usuario
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    @Column(nullable = false)
    private String nombre;

    @NotNull
    @Size(max = 100)
    @Column (nullable = false)
    private String apellido;

    @NotNull
    @Size(max = 100)
    @Column(nullable = false, unique = true)
    private String email;

    @NotNull
    @Size(max = 225)
    @Column (nullable = false)
    private String  password;

    @NotNull
    @DefaultValue(true)
    private Boolean estado;

    @ManyToOne(optional = false)
    @JoinColumn(name = "rol_id")
    private Rol rol;

    

    public Usuario(){
        this.nombre= "";
        this.apellido= "";
        this.email= "";
        this.password= "";
        this.estado= true;
    }

    public Usuario(String nombre, String apellido, String email, String password){
        this.nombre= nombre;
        this.apellido= apellido;
        this.email= email;
        this.password= password;
        this.estado= true;
    }

    // Getters Y Setters de la clase Usuario
    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

        public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    // Metodos Equals , HashCode y ToString
    @Override
    public boolean equals (Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id != null && id.equals(usuario.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }

    @Override
    public String toString(){
        return "Usuario: " + 
        "Id: " + this.id +
        "Nombre: " + this.nombre + 
        "Apellido: " + this.apellido +
        "Email: " + this.email;
    }
}

