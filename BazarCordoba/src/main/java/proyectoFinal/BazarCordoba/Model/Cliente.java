
package proyectoFinal.BazarCordoba.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;



@Entity
@Getter @Setter
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_cliente; 
    private String nombre;
    private String apellido;
    private String dni;
    
    //VENTA
    @OneToMany(mappedBy = "unCliente")
    private List<Venta> listaVentas;

    public Cliente(Long id_cliente, String nombre, String apellido, String dni, List<Venta> listaVentas) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.listaVentas = listaVentas;
    }

    public Cliente() {
    }

    

    
}
