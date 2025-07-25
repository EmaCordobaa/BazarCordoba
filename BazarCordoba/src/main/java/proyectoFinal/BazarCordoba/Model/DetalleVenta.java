
package proyectoFinal.BazarCordoba.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter 
@Setter
public class DetalleVenta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_detalleVenta;

    @ManyToOne
    @JoinColumn(name = "venta_id")
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    private Integer cantidadVendida;
    private Double subtotal;

    public DetalleVenta() {
    }

    public DetalleVenta(Long id_detalleVenta, Venta venta, Producto producto, Integer cantidadVendida, Double subtotal) {
        this.id_detalleVenta = id_detalleVenta;
        this.venta = venta;
        this.producto = producto;
        this.cantidadVendida = cantidadVendida;
        this.subtotal = subtotal;
    }
    
    
    
}
