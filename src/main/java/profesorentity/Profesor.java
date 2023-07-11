package profesorentity;
import javax.persistence.NamedQueries;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "profesores")
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor

@NamedQueries({
    @NamedQuery(name = "Profesor.findAll", query = "SELECT c FROM Profesor c")
    , @NamedQuery(name = "Profesor.findByIdProfesor", query = "SELECT c FROM Profesor c WHERE c.idProfesor = :idProfesor")
    , @NamedQuery(name = "Profesor.findByNombre", query = "SELECT c FROM Profesor c WHERE c.nombre = :Nombre")
    , @NamedQuery(name = "Profesor.findByApellido", query = "SELECT c FROM Profesor c WHERE c.apellido = :Apellido")
    , @NamedQuery(name = "Profesor.findByEmail", query = "SELECT c FROM Profesor c WHERE c.email = :Email")})
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProfesor")
    private Integer idProfesor;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;

    
}