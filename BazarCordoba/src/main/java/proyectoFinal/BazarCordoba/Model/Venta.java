
package proyectoFinal.BazarCordoba.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter 
@Setter
public class Venta {
   
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigo_venta;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha_venta;

    private Double total;

    @OneToMany(mappedBy = "venta")
    private List<DetalleVenta> detalles = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente unCliente;

    public Venta() {}

    public Venta(LocalDate fecha_venta, List<DetalleVenta> detalles, Cliente unCliente) {
        this.fecha_venta = fecha_venta;
        this.detalles = detalles;
        this.unCliente = unCliente;
    }

    @PrePersist
    public void prePersist() {
        this.fecha_venta = LocalDate.now();

        this.total = detalles.stream()
                             .mapToDouble(DetalleVenta::getSubtotal)
                             .sum();
    }
    
    
    
}
