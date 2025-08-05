
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
    
    //VENTA
    @ManyToOne
    @JoinColumn(name = "codigo_venta")
    private Venta unaVenta;

    
    //PRODUCTO
    @ManyToOne
    @JoinColumn(name = "codigo_producto")
    private Producto unProducto;

    private Integer cantidadVendida;
    private Double subtotal;

    public DetalleVenta() {
    }

    public DetalleVenta(Long id_detalleVenta, Venta unaVenta, Producto unProducto, Integer cantidadVendida, Double subtotal) {
        this.id_detalleVenta = id_detalleVenta;
        this.unaVenta = unaVenta;
        this.unProducto = unProducto;
        this.cantidadVendida = cantidadVendida;
        this.subtotal = subtotal;
    }

    
    
    
}
