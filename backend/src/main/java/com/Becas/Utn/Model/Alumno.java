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
    @Column (nullable = false, unique = true, length = 20)
    private String dni;

    @NotNull
    @Size(max = 50)
    @Column (nullable = false, length = 50)
    private String nacionalidad;

    @NotNull
    @Past
    @Column (name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @NotNull
    @Size(max = 100)
    @Column (nullable = false, length = 100)
    private String carrera;

    @NotNull
    @Size(max = 300)
    @Column (nullable = false, length = 300)
    private String domicilio;

    @NotNull
    @Size(max = 20)
    @Column (name = "codigo_postal", nullable = false, length = 20)
    private String codigoPostal;

    @NotNull
    @Size(max = 100)
    @Column (nullable = false, length = 100)
    private String localidad;

    @NotNull
    @Size(max = 100)
    @Column (nullable = false, length = 100)
    private String provincia;

    @NotNull
    @Size(max = 100)
    @Column (name = "ciudad_familia", nullable = false, length = 100)
    private String ciudadFamilia;

    @NotNull
    @Size(max = 200)
    @Column (nullable = false, length = 200)
    private String vivienda;

    @NotNull
    @Size(max = 200)
    @Column (name = "condicion_laboral", nullable = false, length = 200)
    private String condicionLaboral;

    @NotNull
    @Size(max = 200)
    @Column (nullable = false, length = 200)
    private String salud;

    @Column (name = "tiene_discapacidad", nullable = false)
    private boolean tieneDiscapacidad;

    @Size(max = 300)
    @Column(name = "discapacidad_detalle", length = 300)
    private String discapacidadDetalle;

    public Alumno(){
        // this.id = 0;
        // this.usuario = new Usuario();
        // this.dni = "";
        // this.nacionalidad = "";
        // this.fechaNacimiento = LocalDate.now();
        // this.carrera = "";
        // this.domicilio = "";
        // this.codigo_postal = "";
        // this.localidad = "";
        // this.provincia = "";
        // this.ciudad_familia = "";
        // this.vivienda = "";
        // this.condicion_laboral = "";
        // this.salud = "";
        // this.tiene_discapacidad = false;
        // this.discapacidad_detalle = "";
    }

    public Alumno(Usuario usuario, String dni, String nacionalidad, LocalDate fechaNacimiento, String carrera, String domicilio,
        String codigoPostal, String localidad, String provincia, String ciudadFamilia, String vivienda, String condicionLaboral,
        String salud, boolean tieneDiscapacidad, String discapacidadDetalle){
            this.usuario = usuario;
            this.dni = dni;
            this.nacionalidad = nacionalidad;
            this.fechaNacimiento = fechaNacimiento;
            this.carrera = carrera;
            this.domicilio = domicilio;
            this.codigoPostal = codigoPostal;
            this.localidad = localidad;
            this.provincia = provincia;
            this.ciudadFamilia = ciudadFamilia;
            this.vivienda = vivienda;
            this.condicionLaboral = condicionLaboral;
            this.salud = salud;
            this.tieneDiscapacidad = tieneDiscapacidad;
            this.discapacidadDetalle = discapacidadDetalle;
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

        public String getDni(){
            return dni;
        }

        public void setDni(String dni){
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

        public String getCodigoPostal() {
            return codigoPostal;
        }

        public void setCodigoPostal(String codigoPostal) {
            this.codigoPostal = codigoPostal;
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

        
        public String getCiudadFamilia() {
            return ciudadFamilia;
        }

        public void setCiudadFamilia(String ciudadFamilia) {
            this.ciudadFamilia = ciudadFamilia;
        }

        public String getVivienda(){
            return vivienda;
        }

        public void setVivienda(String vivienda){
            this.vivienda = vivienda;
        }

        
        public String getCondicionLaboral() {
            return condicionLaboral;
        }

        public void setCondicionLaboral(String condicionLaboral) {
            this.condicionLaboral = condicionLaboral;
        }

        public String getSalud(){
            return salud;
        }

        public void setSalud(String salud){
            this.salud = salud;
        }


        public boolean isTieneDiscapacidad() {
            return tieneDiscapacidad;
        }

        public void setTieneDiscapacidad(boolean tieneDiscapacidad) {
            this.tieneDiscapacidad = tieneDiscapacidad;
        }

        public String getDiscapacidadDetalle() {
            return discapacidadDetalle;
        }

        public void setDiscapacidadDetalle(String discapacidadDetalle) {
            this.discapacidadDetalle = discapacidadDetalle;
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


