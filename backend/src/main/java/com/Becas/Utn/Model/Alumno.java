import java.util.Date;

@Entity
@Table(name = "alumno")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false, unique = true)
    private Usuario usuario;

    @NotNull
    @Size(max = 20)
    @Column (nullable = false, unique = true)
    private Long dni;

    @NotNull
    @Size(max = 50)
    @Column (nullable = false)
    private String nacionalidad;

    @NotNull
    @Past
    @Column (name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @NotNull
    @Size(max = 100)
    @Column (nullable = false)
    private String carrera;

    @NotNull
    @Size(max = 300)
    @Column (nullable = false)
    private String domicilio;

    @NotNull
    @Size(max = 20)
    @Column (nullable = false)
    private String codigo_postal;

    @NotNull
    @Size(max = 100)
    @Column (nullable = false)
    private String localidad;

    @NotNull
    @Size(max = 100)
    @Column (nullable = false)
    private String provincia;

    @NotNull
    @Size(max = 100)
    @Column (nullable = false)
    private String ciudad_familia;

    @NotNull
    @Size(max = 200)
    @Column (nullable = false)
    private String vivienda;

    @NotNull
    @Size(max = 200)
    @Column (nullable = false)
    private String condicion_laboral;

    @NotNull
    @Size(max = 100)
    @Column (nullable = false)
    private String salud;

    @NotNull
    @Column (nullable = false)
    private Boolean tiene_discapacidad;

    @Size(max = 300)
    private String discapacidad_detalle;

    public Alumno(){
        this.id = 0;
        this.usuario = new Usuario();
        this.dni = 0;
        this.nacionalidad = "";
        this.fechaNacimiento = LocalDate.now();
        this.carrera = "";
        this.domicilio = "";
        this.codigo_postal = "";
        this.localidad = "";
        this.provincia = "";
        this.ciudad_familia = "";
        this.vivienda = "";
        this.condicion_laboral = "";
        this.salud = "";
        this.tiene_discapacidad = false;
        this.discapacidad_detalle = "";
    }

    public Alumno(Usuario usuario, Long dni, String nacionalidad, LocalDate fechaNacimiento, String carrera, String domicilio,
        String codigo_postal, String localidad, String provincia, String ciudad_familia, String vivienda, String condicion_laboral,
        String salud, Boolean tiene_discapacidad, String discapacidad_detalle){
            this.usuario = usuario;
            this.dni = dni;
            this.nacionalidad = nacionalidad;
            this.fechaNacimiento = fechaNacimiento;
            this.carrera = carrera;
            this.domicilio = domicilio;
            this.codigo_postal = codigo_postal;
            this.localidad = localidad;
            this.provincia = provincia;
            this.ciudad_familia = ciudad_familia;
            this.vivienda = vivienda;
            this.condicion_laboral = condicion_laboral;
            this.salud = salud;
            this.tiene_discapacidad = tiene_discapacidad;
            this.discapacidad_detalle = discapacidad_detalle;
        }

    //Getters y Setters de la clase Alumno
        public Long getId(){
            return id;
        }

        public void setId(Long id){
            this.id = id;
        }

        public Usuario getUsuario(){
            return usuario;
        }

        public void setUsuario(Usuario usuario){
            this.usuario = usuario;
        }

        public Long getDni(){
            return dni;
        }

        public void setDni(Long dni){
            this.dni = dni;
        }

        public String getNacionalidad(){
            return nacionalidad;
        }

        public void setNacionalidad(String nacionalidad){
            this.nacionalidad = nacionalidad;
        }

        public LocalDate getFechaNacimiento(){
            return fechaNacimiento;
        }

        public void setFechaNacimiento(LocalDate fechaNacimiento){
            this.fechaNacimiento = fechaNacimiento;
        }

        public String getCarrera(){
            return carrera;
        }

        public void setCarrera(String carrera){
            this.carrera = carrera;
        }

        public String getDomicilio(){
            return domicilio;
        }

        public void setDomicilio(String domicilio){
            this.domicilio = domicilio;
        }

        public String getCodigo_Postal(){
            return codigo_postal;
        }

        public void setCodigo_Postal(String codigo_postal){
            this.codigo_postal = codigo_postal;
        }

        public String getLocalidad(){
            return localidad;
        }

        public void setLocalidad(String localidad){
            this.localidad = localidad;
        }

        public String getProvincia(){
            return provincia;
        }

        public void setProvincia(String provincia){
            this.provincia = provincia;
        }

        public String getCiudad_Familia(){
            return ciudad_familia;
        }

        public void setCiudad_Familia(String ciudad_familia){
            this.ciudad_familia = ciudad_familia;
        }

        public String getVivienda(){
            return vivienda;
        }

        public void setVivienda(String vivienda){
            this.vivienda = vivienda;
        }

        public String getCondicion_Laboral(){
            return condicion_laboral;
        }

        public void setCondicion_Laboral(String condicion_laboral){
            this.condicion_laboral = condicion_laboral;
        }

        public String getSalud(){
            return salud;
        }

        public void setSalud(String salud){
            this.salud = salud;
        }

        public Boolean getTiene_Discapacidad(){
            return tiene_discapacidad;
        }

        public void setTiene_Discapacidad(Boolean tiene_discapacidad){
            this.tiene_discapacidad = tiene_discapacidad;
        }

        public String getDiscapacidad_Detalle(){
            return discapacidad_detalle;
        }

        public void setDiscapacidad_Detalle(String discapacidad_detalle){
            this.discapacidad_detalle = discapacidad_detalle;
        }

//Equals y HashCode de la clase Alumno
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Alumno)) return false;
        Alumno alumno = (Alumno) o;
        return id != null && id.equals(alumno.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}


