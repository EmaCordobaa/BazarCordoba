
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

    
    //DETALLE VENTA
    @OneToMany(mappedBy = "unaVenta")
    private List<DetalleVenta> listaDetallesVentas = new ArrayList<>();

    
    //VENTA 
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente unCliente;

    
    @PrePersist
    public void prePersist() {

        this.fecha_venta = LocalDate.now();

        if (this.listaDetallesVentas != null && !this.listaDetallesVentas.isEmpty()) {
            double totalVenta = 0.0;

            for (DetalleVenta detalle : this.listaDetallesVentas) {
                if (detalle.getSubtotal() != null) {
                    totalVenta += detalle.getSubtotal();
                }
            }
            this.total = totalVenta;
        }else {
               this.total = 0.0;
              }
    }

    public Venta(Long codigo_venta, LocalDate fecha_venta, Double total, Cliente unCliente) {
        this.codigo_venta = codigo_venta;
        this.fecha_venta = fecha_venta;
        this.total = total;
        this.unCliente = unCliente;
    }

    public Venta() {
    }

}
